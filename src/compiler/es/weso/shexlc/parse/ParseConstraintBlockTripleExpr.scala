//--------------------------------------------------------------------------------------------------
// File: ConstraintBlockTripleExprPsr.scala
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

package es.weso.shexlc.parse

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.expr.{ConstraintBlockTripleExpr, Expression}
import es.weso.shexlc.parse.generated.ShexLiteParser
import org.antlr.v4.runtime.misc.Interval

import scala.collection.JavaConverters._

/**
 * The constraint block triple expression sub-parser generates a new block of triple expression constraints from the
 * parser context.
 *
 * @author Guillermo Facundo Colunga
 * @param ctx     of the parser.
 * @param visitor to propagate any action.
 */
class ParseConstraintBlockTripleExpr(ctx: ShexLiteParser.Constraint_block_triple_exprContext, visitor: ASTBuilderParser,
                                     ccontext: CompilationContext) extends HasParseResult[ConstraintBlockTripleExpr] {

  override def getParseResult: ConstraintBlockTripleExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)
    val content = ccontext.getInputContext.getText(interval)

    // Would be nice to avoid the as Instance Of here...
    val expressions: List[Expression] = ctx.constraint_triple_expr().asScala
      .map(expr => expr.accept(visitor)).toList.asInstanceOf[List[Expression]]

    new ConstraintBlockTripleExpr(line, column, interval, content, expressions)
  }
}
