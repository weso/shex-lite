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

import es.weso.shexlc.ast.expr.ConstraintNodeAnyTypeExpr
import org.antlr.v4.runtime.misc.Interval
import es.weso.shexlc.syntactic.Syn01ASTBuilderStage
import es.weso.shexlc.syntactic.generated.Shexl2Parser

/**
 * The constraint node any type expression sub-parser generates a constraint node of any type expression from the
 * context of the parser.
 *
 * @author Guillermo Facundo Colunga
 * @param ctx     of the parser.
 * @param visitor to delegate any action.
 */
class ConstraintNodeAnyTypeExprPsr(ctx: Shexl2Parser.Constraint_node_any_type_exprContext,
                                   visitor: Syn01ASTBuilderStage) extends Parser[ConstraintNodeAnyTypeExpr] {

  override def getParseResult: ConstraintNodeAnyTypeExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)

    new ConstraintNodeAnyTypeExpr(line, column, interval)
  }
}
