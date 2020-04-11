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

package es.weso.shexlc.ast.expr

import es.weso.shexlc.ast.Position
import es.weso.shexlc.ast.visitor.ShExLiteGenericVisitor
import org.antlr.v4.runtime.misc.Interval

/**
 * A cardinality represents a range. And will be applied to express hop many times a property with a given constraint
 * can appear in a node.This range can go from MinValue to MaxValue.
 *
 * @author Guillermo Facundo Colunga
 * @param line   in the source code where the token that generates de Base Definition Statement is located.
 * @param column in the source code where the token that generates de Base Definition Statement is located.
 * @param min    value of the range. Must be MinValue or greater.
 * @param max    value of the range. If equals MaxValue then will be interpreted as open upper bound.
 */
class CardinalityExpr(line: Int, column: Int, interval: Interval, val min: Int, val max: Int) extends Expression {
  /**
   * Gets the position object that points to the source file.
   *
   * @return a position object containing the position in the source file.
   */
  override def getPosition: Position = Position.pos(line, column)

  override def getRange: Interval = interval

  // Override default methods to indicate that this is a Cardinality Expression.
  override def isCardinalityExpr: Boolean = true

  override def asCardinalityExpr: CardinalityExpr = this

  def isOptionalCardinality: Boolean = (min == 0) && (max == 1)

  def isEmptyCardinality: Boolean = (min == 0) && (max == 0)

  def isUpperBoundOpen: Boolean = max == CardinalityExpr.MaxValue

  def isValid: Boolean = (CardinalityExpr.MinValue <= min) && (max <= CardinalityExpr.MaxValue) && (min <= max)

  def countElementsInRange: Int = max - min

  override def accept[TP, TR](visitor: ShExLiteGenericVisitor[TP, TR], param: TP): TR = {
    visitor.visit(this, param)
  }


}

/**
 * Companion object of the cardinality expression to include the min and max standardised values.
 *
 * @author Guillermo Facundo Colunga
 */
object CardinalityExpr {
  final val MinValue = 0
  final val MaxValue = Int.MaxValue - 1
}
