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

import compiler.ast.expr.Expression
import compiler.ast.stmt.ShapeDefStmt
import compiler.syntactic.ShExLiteASTBuilderVisitor
import compiler.syntactic.generated.Shexl2Parser

/**
 * The shape definition statement sub-parser generates a shape definition statement from the context of the parser.
 * It delegates the creation of the label and the expression to its own sub-parsers.
 *
 * @override Guillermo Facundo Colunga
 *
 * @param ctx of the parser.
 * @param visitor to propagate any action.
 */
class ShapeDefStmtPsr(ctx: Shexl2Parser.Shape_def_stmtContext, visitor: ShExLiteASTBuilderVisitor)
  extends Parser[ShapeDefStmt] {

  override def getParseResult: ShapeDefStmt = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val label: Expression = ctx.label.accept(visitor).asExpression()
    val expression: Expression = ctx.expr.accept(visitor).asExpression()

   new ShapeDefStmt(line, column, label, expression)
  }
}
