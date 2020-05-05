//--------------------------------------------------------------------------------------------------
// File: ConstraintValueSetExprPsr.scala
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
import es.weso.shexlc.parse.ast.expr.{ConstraintValueSetExpr, Expression}
import es.weso.shexlc.parse.generated.ShexLiteParser
import org.antlr.v4.runtime.misc.Interval

import scala.collection.JavaConverters._

/**
 * The constraint value set expression sub-parser generates a constraint value set expression from the parser context.
 * It delegates the action of creating the value set to each one of the value sets included to their own sub-parsers.
 *
 * @author Guillermo Facundo Colunga
 * @param ctx     of the parser.
 * @param visitor to propagate any action.
 */
class ParseConstraintValueSetExpr(ctx: ShexLiteParser.Constraint_value_set_exprContext, visitor: ASTBuilderParser, ccontext: CompilationContext)
  extends HasParseResult[ConstraintValueSetExpr] {

  override def getParseResult: ConstraintValueSetExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)
    val content = ccontext.getInputContext.getText(interval)

    // Would be nice to remove the as instance of from here but as antlr generates java...
    val valueSet = ctx.constraint_valid_value_set_type().asScala
      .map(ex => ex.accept(visitor)).toList.asInstanceOf[List[Expression]]

    new ConstraintValueSetExpr(line, column, interval, content, valueSet)
  }
}
