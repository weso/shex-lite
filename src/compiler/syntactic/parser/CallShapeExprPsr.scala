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

package compiler.syntactic.parser

import compiler.ast.expr.{CallPrefixExpr, CallShapeExpr, Expression}
import compiler.syntactic.generated.{Shexl2Parser, ShexlParser}
import compiler.syntactic.ShExLiteASTBuilderVisitor

/**
 * The call shape expression parser generates a call shape expression  from the parser context.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param ctx of the parser.
 * @param visitor to propagate any action.
 */
class CallShapeExprPsr(ctx: Shexl2Parser.Call_shape_exprContext, visitor: ShExLiteASTBuilderVisitor)
  extends Parser[CallShapeExpr]{

  override def getParseResult: CallShapeExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine

    ctx.base_relative_lbl match {
      case null => {
        val prefix = if (ctx.prefix_lbl == null ) "" else ctx.prefix_lbl.getText
        val shape = ctx.shape_lbl.getText
        val prefixCall = new CallPrefixExpr(line, column, prefix, shape)

        new CallShapeExpr(line, column, prefixCall)
      }
      case _ => {
        val prefix = "base"
        val shape = ctx.base_relative_lbl.accept(visitor).asInstanceOf[Expression].asLiteralIRIValueExpr.value
        val prefixCall = new CallPrefixExpr(line, column, prefix, shape)

        new CallShapeExpr(line, column, prefixCall)
      }
    }
  }
}
