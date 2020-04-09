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

import compiler.ast.expr.ConstraintNodeBNodeExpr
import compiler.syntactic.ShExLiteASTBuilderVisitor
import compiler.syntactic.generated.Shexl2Parser

/**
 * The constraint node bnode expression parser generates a constraint node of type bnode from the parser context.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param ctx of the parser.
 * @param visitor to propagate any action.
 */
class ConstraintNodeBNodeExprPsr(ctx: Shexl2Parser.Constraint_node_bnode_exprContext,
                                 visitor: ShExLiteASTBuilderVisitor) extends Parser[ConstraintNodeBNodeExpr] {


  override def getParseResult: ConstraintNodeBNodeExpr = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine

    new ConstraintNodeBNodeExpr(line, column)
  }
}
