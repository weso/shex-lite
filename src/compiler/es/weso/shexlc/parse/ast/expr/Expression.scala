//--------------------------------------------------------------------------------------------------
// File: Expression.scala
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

import es.weso.shexlc.parse.ast.{NodeWithParent, NodeWithPosition}

/**
 * A base class for all the expression.
 *
 * When an expression is added to the es.weso.shexlc.parse.ast it is mandatory to add its is and as methods, that way it is much
 * simple and faster to check if the es.weso.shexlc.parse.ast is semantically correct or not and also to access fields.
 *
 * @author Guillermo Facundo Colunga
 */
trait Expression extends NodeWithPosition with NodeWithParent {

  // Override default values from node with position.
  override def isExpression(): Boolean = true

  override def asExpression(): Expression = this

  // Literal Expression.
  def isLiteralExpr: Boolean = false

  def asLiteralExpr: LiteralExpr =
    throw new IllegalStateException(s"$this is not an LiteralExpr")

  // Literal IRI Value Expression.
  def isLiteralIRIValueExpr: Boolean = false

  def asLiteralIRIValueExpr: LiteralIRIValueExpr =
    throw new IllegalStateException(s"$this is not an LiteralIRIValueExpr")

  // Literal String Value Expression.
  def isLiteralStringValueExpr: Boolean = false

  def asLiteralStringValueExpr: LiteralStringValueExpr =
    throw new IllegalStateException(s"$this is not an LiteralStringValueExpr")

  // Literal Real Value Expression.
  def isLiteralRealValueExpr: Boolean = false

  def asLiteralRealValueExpr: LiteralRealValueExpr =
    throw new IllegalStateException(s"$this is not an LiteralRealValueExpr")

  // Constraint Expression.
  def isConstraintExpr: Boolean = false

  def asConstraintExpr: ConstraintExpr =
    throw new IllegalStateException(s"$this is not an ConstraintExpr")

  // Constraint Block Triple Expression.
  def isConstraintBlockTripleExpr: Boolean = false

  def asConstraintBlockTripleExpr: ConstraintBlockTripleExpr =
    throw new IllegalStateException(s"$this is not an asConstraintBlockTripleExpr")

  // Constraint Triple Expression.
  def isConstraintTripleExpr: Boolean = false

  def asConstraintTripleExpr: ConstraintTripleExpr =
    throw new IllegalStateException(s"$this is not an ConstraintTripleExpr")

  // Cardinality Expression.
  def isCardinalityExpr: Boolean = false

  def asCardinalityExpr: CardinalityExpr =
    throw new IllegalStateException(s"$this is not an CardinalityExpr")

  // Constraint Node Expression.
  def isConstraintNodeExpr: Boolean = false

  def asConstraintNodeExpr: ConstraintNodeExpr =
    throw new IllegalStateException(s"$this is not an ConstraintNodeExpr")

  // Constraint Node Literal Expression.
  def isConstraintNodeLiteralExpr: Boolean = false

  def asConstraintNodeLiteralExpr: ConstraintNodeLiteralExpr =
    throw new IllegalStateException(s"$this is not an ConstraintNodeLiteralExpr")

  // Constraint Node IRI Expression.
  def isConstraintNodeIRIExpr: Boolean = false

  def asConstraintNodeIRIExpr: ConstraintNodeIRIExpr =
    throw new IllegalStateException(s"$this is not an ConstraintNodeIRIExpr")

  // Constraint Node Any Type Expression.
  def isConstraintNodeAnyTypeExpr: Boolean = false

  def asConstraintNodeAnyTypeExpr: ConstraintNodeAnyTypeExpr =
    throw new IllegalStateException(s"$this is not an ConstraintNodeAnyTypeExpr")

  // Constraint Node BNode Expression.
  def isConstraintNodeBNodeExpr: Boolean = false

  def asConstraintNodeBNodeExpr: ConstraintNodeBNodeExpr =
    throw new IllegalStateException(s"$this is not an ConstraintNodeBNodeExpr")

  // Constraint Node Non Literal Expression.
  def isConstraintNodeNonLiteralExpr: Boolean = false

  def asConstraintNodeNonLiteralExpr: ConstraintNodeNonLiteralExpr =
    throw new IllegalStateException(s"$this is not an ConstraintNodeNonLiteralExpr")

  // Constraint Valid Value Set Expression
  def isConstraintValidValueSetExpr: Boolean = false

  def asConstraintValidValueSetExpr: ConstraintValidValueSetExpr =
    throw new IllegalStateException(s"$this is not an ConstraintValidValueSetExpr")

  // Constraint Value Set Expression.
  def isConstraintValueSetExpr: Boolean = false

  def asConstraintValueSetExpr: ConstraintValueSetExpr =
    throw new IllegalStateException(s"$this is not an ConstraintValueSetExpr")

  // Call Expression.
  def isCallExpr: Boolean = false

  def asCallExpr: CallExpr =
    throw new IllegalStateException(s"$this is not an CallExpr")

  // Call Prefix Expression.
  def isCallPrefixExpr: Boolean = false

  def asCallPrefixExpr: CallPrefixExpr =
    throw new IllegalStateException(s"$this is not an CallPrefixExpr")

  // Call Shape Expression.
  def isCallShapeExpr: Boolean = false

  def asCallShapeExpr: CallShapeExpr =
    throw new IllegalStateException(s"$this is not an CallShapeExpr")

  // Call Base Expression.
  def isCallBaseExpr = false

  def asCallBaseExpr: CallBaseExpr =
    throw new IllegalStateException(s"$this is not an CallBaseExpr")
}