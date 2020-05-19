//------------------------------------------------------------------------------
// File: LookUnusedPrefixCheck.scala
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
//------------------------------------------------------------------------------

package es.weso.shexlc.sema

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.{ErrorHandler, Warn}
import es.weso.shexlc.internal.symbols.SymbolTable
import es.weso.shexlc.parse.ast.stmt._
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

class LookUnusedPrefixCheck(ccontext: CompilationContext) extends ASTDefaultVisitor[Unit] {

  private[this] val symbolTable: SymbolTable   = ccontext.getSymbolTable
  private[this] val errorHandler: ErrorHandler = ccontext.getErrorHandler

  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    stmt.expression.accept(this, param)

    if (
      symbolTable.find(BaseDefStmt.DEFAULT_LABEL).isDefined &&
      symbolTable.find(BaseDefStmt.DEFAULT_LABEL).get.getStats.getNumberOfCalls == 0 &&
      ccontext.getConfiguration.generateWarnings
    ) {
      errorHandler.addEvent(new Warn(
        stmt.expression,
        s"the base `${stmt.expression.asLiteralIRIValueExpr.value}` " +
        s"definition is set but not " + s"used",
        Warn.BaseSetButNotUsed
      ))
    }
  }

  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    stmt.expression.accept(this, param)

    if (
      symbolTable.find(stmt.label).isDefined &&
      symbolTable.find(stmt.label).get.getStats.getNumberOfCalls == 0 &&
      ccontext.getConfiguration.generateWarnings
    ) {
      errorHandler.addEvent(new Warn(
        stmt.expression,
        s"the prefix `${stmt.label}` definition is not used",
        Warn.PrefixNotUsed
      ))
    }
  }
}
