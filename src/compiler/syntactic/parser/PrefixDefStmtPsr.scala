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

package syntactic.parser

import ast.expr.Expression
import ast.stmt.PrefixDefStmt
import org.antlr.v4.runtime.misc.Interval
import syntactic.ShExLiteASTBuilderVisitor
import syntactic.generated.Shexl2Parser

/**
 * The prefix definition statement sub-parser generates a prefix definition statement from the context of the parser.
 * It delegates the creation of the iri literal expression to its own sub-parser.
 *
 * @author Guillermo Facundo Colunga
 * @param ctx     of the parser.
 * @param visitor to propagate any action.
 */
class PrefixDefStmtPsr(ctx: Shexl2Parser.Prefix_def_stmtContext, visitor: ShExLiteASTBuilderVisitor)
  extends Parser[PrefixDefStmt] {

  override def getParseResult: PrefixDefStmt = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)
    val label = if (ctx.LABEL == null) "" else ctx.LABEL.getText
    val iri: Expression = ctx.iri.accept(visitor).asExpression()

    new PrefixDefStmt(line, column, interval, label, iri)
  }
}
