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

package compiler.ast.expr
import compiler.ast.Position

/**
 * A Constraint Block Triple Expression represents a constraint composed of multiple expressions.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param line in the source code where the token that generates de Base Definition Statement is located.
 * @param column in the source code where the token that generates de Base Definition Statement is located.
 * @param body of the block that contains the expressions.
 */
class ConstraintBlockTripleExpr(line: Int, column: Int, val body: List[Expression]) extends ConstraintExpr {
  override def getPosition: Position = Position.pos(line, column)

  // Override default methods to indicate that this is a Constraint Block Triple Expression.
  override def isConstraintBlockTripleExpr: Boolean = true
  override def asConstraintBlockTripleExpr: ConstraintBlockTripleExpr = this
}
