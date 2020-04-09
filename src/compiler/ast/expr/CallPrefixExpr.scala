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
import compiler.ast.stmt.Statement

/**
 * A call prefix expression is a call to a prefix definition.
 *
 * @param line in the source code where the token that generates de Base Definition Statement is located.
 * @param column in the source code where the token that generates de Base Definition Statement is located.
 * @param label of the prefix to call.
 * @param argument on which the prefix is called.
 * @param definition of the prefix that is being called.
 */
class CallPrefixExpr(line: Int, column: Int, val label: String, val argument: String,
                     var definition: Statement = null) extends CallExpr {
  override def getPosition: Position = Position.pos(line, column)

  // Override default methods to indicate that this is a Call Prefix Expression.
  override def isCallPrefixExpr: Boolean = true
  override def asCallPrefixExpr: CallPrefixExpr = this
}
