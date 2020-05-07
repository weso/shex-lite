//--------------------------------------------------------------------------------------------------
// File: ConstraintNodeLiteralExpr.scala
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

package es.weso.shexlc.parse.ast.expr

import es.weso.shexlc.parse.ast.Position
import es.weso.shexlc.parse.ast.visitor.ASTGenericWalker
import org.antlr.v4.runtime.misc.Interval

/**
 * A Constraint Node Literal Expression indicated that a node constraint is of type Literal. Does not add more
 * functionality than the classification of the node constraint type.
 *
 * @author Guillermo Facundo Colunga
 * @param line   in the source code where the token that generates de Base Definition Statement is located.
 * @param column in the source code where the token that generates de Base Definition Statement is located.
 */
class ConstraintNodeLiteralExpr(line: Int, column: Int, interval: Interval, content: String) extends ConstraintNodeExpr {
  override def getPosition: Position = Position.pos(line, column)

  override def getRange: Interval = interval

/**
   * Gets the content of the node as a String, for example for a node that contains the assignment of a and 3 the content
   * would be 'a = 3'.
   *
   * @return the content of the node as a String.
   */
  override def getContent: String = content

  // Override default methods to indicate that this is a Constraint Node Literal Expression.
  override def isConstraintNodeLiteralExpr: Boolean = true

  override def asConstraintNodeLiteralExpr: ConstraintNodeLiteralExpr = this

  override def accept[TP, TR](visitor: ASTGenericWalker[TP, TR], param: TP): TR = {
    visitor.visit(this, param)
  }


}
