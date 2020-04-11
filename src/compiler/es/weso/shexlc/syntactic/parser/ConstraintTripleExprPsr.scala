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

import es.weso.shexlc.ast.expr._
import org.antlr.v4.runtime.misc.Interval
import es.weso.shexlc.syntactic.Syn01ASTBuilderVisitor
import es.weso.shexlc.syntactic.generated.Shexl2Parser

/**
 * This parser extracts a triple constraint expression from the parser triple constraint context.
 *
 * @author Guillermo Facundo Colunga
 * @param ctx     of the parser
 * @param visitor that will propagate any needed call.
 */
class ConstraintTripleExprPsr(ctx: Shexl2Parser.Constraint_triple_exprContext, visitor: Syn01ASTBuilderVisitor)
  extends Parser[ConstraintTripleExpr] {

  override def getParseResult: ConstraintTripleExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)
    val property: Expression = ctx.property.accept(visitor).asExpression()
    val constraint: Expression = ctx.constraint.accept(visitor).asExpression()
    val cardinality: Expression =
      if (ctx.cardinality == null)
        new CardinalityExpr(line, column, interval, 0, 1)
      else
        ctx.cardinality.accept(visitor).asExpression()

    new ConstraintTripleExpr(line, column, interval, property, constraint, cardinality)
  }
}
