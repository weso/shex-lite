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

package es.weso.shexlc.semantic

import java.util.Objects

import es.weso.shexlc.ast.Schema
import es.weso.shexlc.ast.expr._
import es.weso.shexlc.ast.stmt._
import es.weso.shexlc.ast.visitor.DefaultShExLiteGenericVisitor
import es.weso.shexlc.internal.io.CompilerMsgsHandler
import es.weso.shexlc.internal.io.impl.{CompilerMsgErrorType, DefaultCompilerMsg}
import es.weso.shexlc.internal.symboltable.SymbolTable

class Sem03CallCheckingVisitor(symbolTable: SymbolTable, msgsHandler: CompilerMsgsHandler)
  extends DefaultShExLiteGenericVisitor[Unit] {

  override def visit(expr: CallPrefixExpr, param: Unit): Unit = {
    val existingSTValue = symbolTable.getPrefix(expr.label)
    // 1. Is the prefix defined in the symbol table?
    if(Objects.isNull(existingSTValue)) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          expr.getPosition,
          expr.getRange,
          s"the prefix `${expr.label}` has not been defined",
          CompilerMsgErrorType.PrefixNotFound
        )
      )
    } else {
      expr.definition = existingSTValue
    }
  }

  override def visit(expr: CallShapeExpr, param: Unit): Unit = {
    expr.label.accept(this, param)

    val isRelativeShape = expr.label.isCallBaseExpr

    var existingSTValue: ShapeDefStmt = null
    var cause: String = ""

    if(isRelativeShape) {
      existingSTValue = symbolTable.getShape(symbolTable.DEFAULT_BASE, expr.label.asCallBaseExpr.argument)
      cause = s"the shape `${expr.label.asCallBaseExpr.argument}` " +
        s"has not been defined in the scope of the prefix the base"
    } else {
      existingSTValue = symbolTable.getShape(expr.label.asCallPrefixExpr.label, expr.label.asCallPrefixExpr.argument)
      cause = s"the shape `${expr.label.asCallPrefixExpr.argument}` " +
        s"has not been defined in the scope of the prefix `${expr.label.asCallPrefixExpr.label}`"
    }

    // 1. Is the shape defined in the table?
    if(Objects.isNull(existingSTValue)) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          expr.label.getPosition,
          expr.getRange,
          cause,
          CompilerMsgErrorType.ShapeNotFound
        )
      )
    } else {
      expr.definition = existingSTValue
    }
  }
}
