//--------------------------------------------------------------------------------------------------
// File: ShExLiteGenericVisitor.scala
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

package es.weso.shexlc.parse.ast.visitor

import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.stmt._

/**
 * This generic walker defines all the visit methods for each node of the ast.
 *
 * @author Guillermo Facundo Colunga
 *
 * @tparam TP is the type of the parameter.
 * @tparam TR is the type of the return type.
 */
trait ASTGenericWalker[TP, TR] {

  // - Schema ---------------------------------------------

  /**
   * Executes the corresponding action.
   *
   * @param schema is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(schema: Schema, param: TP): TR

  // - Statements -----------------------------------------

  /**
   * Executes the corresponding action.
   *
   * @param stmt is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(stmt: BaseDefStmt, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param stmt is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(stmt: ImportStmt, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param stmt is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(stmt: PrefixDefStmt, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param stmt is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(stmt: ShapeDefStmt, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param stmt is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(stmt: StartDefStmt, param: TP): TR

  // - Expressions ----------------------------------------

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: CallPrefixExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: CallShapeExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: CallBaseExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: CardinalityExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: ConstraintBlockTripleExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: ConstraintNodeAnyTypeExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: ConstraintNodeBNodeExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: ConstraintNodeIRIExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: ConstraintNodeLiteralExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: ConstraintNodeNonLiteralExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: ConstraintTripleExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: ConstraintValueSetExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: LiteralIRIValueExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: LiteralRealValueExpr, param: TP): TR

  /**
   * Executes the corresponding action.
   *
   * @param expr is the node being visited.
   * @param param that comes from previous visit actions.
   * @return the computed value, if any.
   */
  def visit(expr: LiteralStringValueExpr, param: TP): TR
}
