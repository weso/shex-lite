//--------------------------------------------------------------------------------------------------
// File: Sem02DefCheckingStage.scala
//
// Short version for non-lawyers:
//
// The ShEx Lite Project is dual-licensed under GNU 3.0 and
// MIT terms.
//
// Longer version:
//
// Copyrights in the ShEx Lite project are retained by their contributors. No
// copyright assignment is required to contribute to the ShEx Lite project.
//
// Some files include explicit copyright notices and/or license notices.
// For full authorship information, see the version control history.
//
// Except as otherwise noted (below and/or in individual files), ShEx Lite is
// licensed under the GNU, Version 3.0 <LICENSE-GNU> or
// <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
// <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
// In case of incompatibility between project licenses, GNU/GPLv3 will be
// applied.
//
// The ShEx Lite Project includes packages written by third parties.
//--------------------------------------------------------------------------------------------------

package es.weso.shexlc.sema

import java.util.Objects

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.{Err, ErrorHandler}
import es.weso.shexlc.parse.ast.stmt._
import es.weso.shexlc.parse.ast.visitor._
import es.weso.shexlc.internal.symboltable.SymbolTable

class DefinitionCheck(ccontext: CompilationContext) extends DefaultShExLiteVisitor[Unit] {

  private[this] var symbolTable: SymbolTable = ccontext.getSymbolTable
  private[this] val errorHandler: ErrorHandler = ccontext.getErrorHandler

  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    val existingSTValue = symbolTable.getBase.expression.asLiteralIRIValueExpr.value
    // 1. Is the base the default one?
    if(existingSTValue.equals(symbolTable.DEFAULT_BASE)) {
      // If it is we allow to change the base once.
      symbolTable.setBase(stmt)
    } else {
      errorHandler.addEvent(
        new Err(
          stmt,
          s"this base definition overrides the previous one " +
            s"(${symbolTable.getBase.getLine}:${symbolTable.getBase.getColumn})" +
            s" with value $existingSTValue",
          Err.BaseOverride
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    val existingSTValue = symbolTable.getPrefix(stmt.label)
    // 1. Does the prefix exists in the symbol table?
    if(Objects.nonNull(symbolTable.getPrefix(stmt.label))) {
      errorHandler.addEvent(
        new Err(
          stmt.expression,
          s"this prefix definition overrides the previous one " +
            s"(${existingSTValue.getLine}:${existingSTValue.getColumn}) with value " +
            s"${existingSTValue.expression.asLiteralIRIValueExpr.value}",
          Err.PrefixOverride
        )
      )
    } else {
      symbolTable += stmt
    }

    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ShapeDefStmt, param: Unit): Unit = {
    val isRelativeShape = stmt.label.isCallBaseExpr
    var existingSTValue: ShapeDefStmt = null

    if(isRelativeShape) {
      existingSTValue = symbolTable.getShape(symbolTable.DEFAULT_BASE, stmt.label.asCallBaseExpr.argument)
    } else {
      existingSTValue = symbolTable.getShape(stmt.label.asCallPrefixExpr.label, stmt.label.asCallPrefixExpr.argument)
    }

    // 1. Does the symbol table contains the shape?
    if(Objects.nonNull(existingSTValue)) {
      errorHandler.addEvent(
        new Err(
          stmt.label,
          s"this shape definition overrides the previous one " +
            s"(${existingSTValue.getLine}:${existingSTValue.getColumn})",
          Err.ShapeOverride
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
    var cause: String = ""

    // Has been already set?
    if(Objects.nonNull(existingSTValue)) {

      if(stmt.expression.asCallShapeExpr.label.isCallBaseExpr) {
        cause = s"this start definition overrides the previous one " +
          s"(${existingSTValue.getLine}:${existingSTValue.getColumn})" +
          s" with value " +
          s"${existingSTValue.expression.asCallShapeExpr.label.asCallBaseExpr.argument}:"
      } else {
        cause = s"this start definition overrides the previous one " +
          s"(${existingSTValue.getLine}:${existingSTValue.getColumn})" +
          s" with value " +
          s"${existingSTValue.expression.asCallShapeExpr.label.asCallPrefixExpr.label}:" +
          s"${existingSTValue.expression.asCallShapeExpr.label.asCallPrefixExpr.argument}"
      }

      errorHandler.addEvent(
        new Err(
          stmt,
          cause,
          Err.StartOverride
        )
      )
    } else {
      symbolTable.setStart(stmt)
    }
    stmt.expression.accept(this, param)
  }
}