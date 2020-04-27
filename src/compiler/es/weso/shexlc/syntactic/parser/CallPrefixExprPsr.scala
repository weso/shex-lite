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

package es.weso.shexlc.syntactic.parser

import es.weso.shexlc.ast.expr.{CallBaseExpr, CallExpr, CallPrefixExpr, Expression}
import org.antlr.v4.runtime.misc.Interval
import es.weso.shexlc.syntactic.Syn01ASTBuilderStage
import es.weso.shexlc.syntactic.generated.Shexl2Parser

/**
 * The call prefix expression parser creates a call prefix expression from the parser context.
 *
 * @author Guillermo Facundo Colunga
 * @param ctx     of the parser.
 * @param visitor top propagate any action.
 */
class CallPrefixExprPsr(ctx: Shexl2Parser.Call_prefix_exprContext, visitor: Syn01ASTBuilderStage)
  extends Parser[CallExpr] {

  override def getParseResult: CallExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)

    ctx.base_relative_lbl match {
      case null => {
        val label = if (ctx.pref_lbl == null) "" else ctx.pref_lbl.getText
        val arg = ctx.shape_lbl.getText

        new CallPrefixExpr(line, column, interval, label, arg)
      }
      case _ => {
        val label = "base"
        val arg = ctx.base_relative_lbl.accept(visitor).asInstanceOf[Expression].asLiteralIRIValueExpr.value

        new CallBaseExpr(line, column, interval, arg)
      }
    }
  }
}
