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

import compiler.ast.expr.LiteralIRIValueExpr
import compiler.syntactic.ShExLiteASTBuilderVisitor
import compiler.syntactic.generated.Shexl2Parser

/**
 * The Literal IRI Value Expression sub-parser creates a literal with iri value from the parser context.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param ctx of the parser.
 * @param visitor to propagate any action.
 */
class LiteralIRIValueExprPsr(ctx: Shexl2Parser.Literal_iri_value_exprContext, visitor: ShExLiteASTBuilderVisitor)
  extends Parser[LiteralIRIValueExpr] {

  override def getParseResult: LiteralIRIValueExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val value = ctx.IRI_LITERAL().getText

    new LiteralIRIValueExpr(line, column, value)
  }
}
