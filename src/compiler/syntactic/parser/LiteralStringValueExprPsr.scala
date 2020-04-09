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

import compiler.ast.expr.LiteralStringValueExpr
import compiler.syntactic.ShExLiteASTBuilderVisitor
import compiler.syntactic.generated.Shexl2Parser

/**
 * The literal string value expression sub-parser creates a literal of string type with the value provided by the
 * context of the parser.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param ctx of the parser.
 * @param visitor to propagate any action.
 */
class LiteralStringValueExprPsr(ctx: Shexl2Parser.Literal_string_value_exprContext, visitor: ShExLiteASTBuilderVisitor)
  extends Parser[LiteralStringValueExpr] {

  override def getParseResult: LiteralStringValueExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val value: String = ctx.STRING_LITERAL().getText

    new LiteralStringValueExpr(line, column, value)
  }
}