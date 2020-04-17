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

import es.weso.shexlc.ast.stmt._
import es.weso.shexlc.ast.visitor.DefaultShExLiteVisitor
import es.weso.shexlc.internal.io.CompilerMsgsHandler
import es.weso.shexlc.internal.io.impl._
import es.weso.shexlc.internal.symboltable.SymbolTable
import org.antlr.v4.runtime.misc.Interval

class Sem50UnusedPrefixFinderVisitor(symbolTable: SymbolTable, msgsHandler: CompilerMsgsHandler)
  extends DefaultShExLiteVisitor[Unit] {

  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    stmt.expression.accept(this, param)

    if(symbolTable.getNumberOfCallsForBase == 0 && !stmt.expression.asLiteralIRIValueExpr.equals(symbolTable.DEFAULT_BASE)) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.expression.getPosition,
          stmt.getRange,
          stmt.expression.getRange,
          s"the base `${stmt.expression.asLiteralIRIValueExpr.value}` definition is set but not used",
          CompilerMsgWarningType.BaseSetButNotUsed
        )
      )
    }
  }

  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    stmt.expression.accept(this, param)

    if(symbolTable.getNumberOfCallsForPrefix(stmt.label) == 0) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.expression.getPosition,
          stmt.getRange,
          new Interval(stmt.getRange.a + 7, stmt.getRange.b),
          s"the prefix `${stmt.label}` definition is not used",
          CompilerMsgWarningType.PrefixNotUsed
        )
      )
    }
  }
}
