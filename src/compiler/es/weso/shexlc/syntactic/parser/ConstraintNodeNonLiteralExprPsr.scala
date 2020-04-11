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

import es.weso.shexlc.ast.expr.ConstraintNodeNonLiteralExpr
import org.antlr.v4.runtime.misc.Interval
import es.weso.shexlc.syntactic.Syn01ASTBuilderVisitor
import es.weso.shexlc.syntactic.generated.Shexl2Parser

/**
 * The constraint node non literal expression parser generates a constraint non literal expression from the parser
 * context.
 *
 * @override Guillermo Facundo Colunga
 * @param ctx     of the parser.
 * @param visitor to propagate any action.
 */
class ConstraintNodeNonLiteralExprPsr(ctx: Shexl2Parser.Constraint_node_non_literal_exprContext,
                                      visitor: Syn01ASTBuilderVisitor) extends Parser[ConstraintNodeNonLiteralExpr] {

  override def getParseResult: ConstraintNodeNonLiteralExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)

    new ConstraintNodeNonLiteralExpr(line, column, interval)
  }
}
