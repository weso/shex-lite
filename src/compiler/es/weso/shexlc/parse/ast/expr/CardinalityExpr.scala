//------------------------------------------------------------------------------
// File: CardinalityExpr.scala
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
//------------------------------------------------------------------------------

package es.weso.shexlc.parse.ast.expr

import es.weso.shexlc.parse.ast.Position
import es.weso.shexlc.parse.ast.visitor.ASTGenericWalker
import org.antlr.v4.runtime.misc.Interval

/**
  * A cardinality represents a range. And will be applied to express hop many times a property with a given constraint
  * can appear in a node.This range can go from MinValue to MaxValue.
  *
  * @author Guillermo Facundo Colunga
  */
class CardinalityExpr(
  position: Position,
  tokenRange: Interval,
  content: String,
  val min: Int,
  val max: Int
) extends Expression(position, tokenRange, content) {

  // Override default methods to indicate that this is a Cardinality Expression.
  override def isCardinalityExpr: Boolean         = true
  override def asCardinalityExpr: CardinalityExpr = this

  /**
    * Gets the position object that points to the source file.
    *
    * @return a position object containing the position in the source file.
    */
  override def getPosition: Position = position

  /**
    * Gets the range of tokens from the source on which the node was generated.
    *
    * @return the range of tokens from the source on which the node was generated.
    */
  override def getRange: Interval = tokenRange

  /**
    * Gets the content of the node as a String, for example for a node that contains the assignment of a and 3 the content
    * would be 'a = 3'.
    *
    * @return the content of the node as a String.
    */
  override def getContent: String = content

  /**
    * If the minimum number of repetitions is zero and the maximum is 1 that means that is an optional cardinality.
    *
    * @return true if the cardinality represents the optional one.
    */
  def isOptionalCardinality: Boolean = (min == 0) && (max == 1)

  /**
    * If he minimum and the maximum are zero that means that the cardinality is empty.
    *
    * @return true if the min and max are both 0.
    */
  def isEmptyCardinality: Boolean = (min == 0) && (max == 0)

  /**
    * If the maximum value of the cardinality is open.
    *
    * @return true if the maximum value of the cardinality is open.
    */
  def isUpperBoundOpen: Boolean = max == CardinalityExpr.MaxValue

  /**
    * Is valid if and only if the min is eq or greater than the min possible value, the max is lower or eq the max
    * possible value and the mis is less or eq the max value.
    *
    * @return true if the cardinality is valid, false otherwise.
    */
  def isValid: Boolean =
    (CardinalityExpr.MinValue <= min) && (max <= CardinalityExpr.MaxValue) && (min <= max)

  /**
    * Counts the elements in the range, that is if the min = 0 and tha max = 1 this will return 1. If the min = 1
    * and the max = 3 the function will return 2.
    *
    * @return the difference between the max and the min.
    */
  def countElementsInRange: Int = max - min

  /**
    * Accept method for visitor support.
    *
    * @param visitor the visitor implementation.
    * @param param   is the parameter passed to the visitor (of type A).
    * @tparam TP is the type the user parameter passed to the visitor.
    * @tparam TR is the type of the return value of the visitor.
    * @return the result of the visit (of type TR).
    */
  override def accept[TP, TR](
    visitor: ASTGenericWalker[TP, TR],
    param: TP
  ): TR = {
    visitor.visit(this, param)
  }
}

/**
  * Companion object of the cardinality expression to include the min and max standardised values.
  *
  * @author Guillermo Facundo Colunga
  */
object CardinalityExpr {

  /**
    * Minimum possible value for the cardinality.
    */
  final val MinValue = 0

  /**
    * Maximum possible value for the cardinality.
    */
  final val MaxValue = Int.MaxValue - 1
}
