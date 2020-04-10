/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

package semantic

import java.util.Objects

import ast.stmt._
import ast.visitor._
import internal.io.CompilerMsgsHandler
import internal.io.impl.{CompilerMsgErrorType, DefaultCompilerMsg}
import internal.symboltable.SymbolTable

class Sem02DefCheckingVisitor(symbolTable: SymbolTable, msgsHandler: CompilerMsgsHandler)
  extends DefaultShExLiteGenericVisitor[Unit] {

  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    val existingSTValue = symbolTable.getBase.expression.asLiteralIRIValueExpr.value
    // 1. Is the base the default one?
    if(existingSTValue.equals(symbolTable.DEFAULT_BASE)) {
      // If it is we allow to change the base once.
      symbolTable.setBase(stmt)
    } else {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.getPosition,
          stmt.getRange,
          s"this base definition overrides the previous one " +
            s"(${symbolTable.getBase.getLine}:${symbolTable.getBase.getColumn})" +
            s" with value $existingSTValue",
          CompilerMsgErrorType.BaseOverride
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    val existingSTValue = symbolTable.getPrefix(stmt.label)
    // 1. Does the prefix exists in the symbol table?
    if(Objects.nonNull(symbolTable.getPrefix(stmt.label))) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.expression.getPosition,
          stmt.getRange,
          s"this prefix definition overrides the previous one " +
            s"(${existingSTValue.getLine}:${existingSTValue.getColumn}) with value " +
            s"${existingSTValue.expression.asLiteralIRIValueExpr.value}",
          CompilerMsgErrorType.PrefixOverride
        )
      )
    } else {
      symbolTable += stmt
    }

    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ShapeDefStmt, param: Unit): Unit = {
    val existingSTValue = symbolTable.getShape(stmt.label.asCallPrefixExpr.label, stmt.label.asCallPrefixExpr.argument)
    // 1. Does the symbol table contains the shape?
    if(Objects.nonNull(existingSTValue)) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.label.getPosition,
          stmt.label.getRange,
          s"this shape definition overrides the previous one " +
            s"(${existingSTValue.getLine}:${existingSTValue.getColumn})",
          CompilerMsgErrorType.ShapeOverride
        )
      )
    } else {
      symbolTable += stmt
    }

    stmt.label.accept(this, param)
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    val existingSTValue = symbolTable.getStart
    // Has been already set?
    if(Objects.nonNull(existingSTValue)) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.getPosition,
          stmt.getRange,
          s"this start definition overrides the previous one " +
            s"(${existingSTValue.getLine}:${existingSTValue.getColumn})" +
            s" with value " +
            s"${existingSTValue.expression.asCallShapeExpr.label.asCallPrefixExpr.label}:" +
            s"${existingSTValue.expression.asCallShapeExpr.label.asCallPrefixExpr.argument}",
          CompilerMsgErrorType.StartOverride
        )
      )
    } else {
      symbolTable.setStart(stmt)
    }
    stmt.expression.accept(this, param)
  }
}