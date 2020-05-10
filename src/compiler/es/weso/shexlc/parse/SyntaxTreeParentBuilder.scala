//------------------------------------------------------------------------------
// File: SyntaxTreeParentBuilder.scala
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

package es.weso.shexlc.parse

import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.stmt._
import es.weso.shexlc.parse.ast.visitor.ASTGenericWalker
import es.weso.shexlc.parse.ast.Schema

class SyntaxTreeParentBuilder extends ASTGenericWalker[Unit, Unit] {

  /**
    * Executes the corresponding action.
    *
    * @param schema is the node being visited.
    * @param param  that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(schema: Schema, param: Unit): Unit = {
    schema.stmts.foreach(stmt => schema.setAsParentOf(stmt))
    schema.stmts.foreach(stmt => stmt.accept(this, param))
  }

  /**
    * Executes the corresponding action.
    *
    * @param stmt  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    stmt.setAsParentOf(stmt.expression)
    stmt.expression.accept(this, param)
  }

  /**
    * Executes the corresponding action.
    *
    * @param stmt  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(stmt: ImportStmt, param: Unit): Unit = {
    stmt.setAsParentOf(stmt.expression)
    stmt.expression.accept(this, param)
  }

  /**
    * Executes the corresponding action.
    *
    * @param stmt  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    stmt.setAsParentOf(stmt.expression)
    stmt.expression.accept(this, param)
  }

  /**
    * Executes the corresponding action.
    *
    * @param stmt  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(stmt: ShapeDefStmt, param: Unit): Unit = {
    stmt.setAsParentOf(stmt.label)
    stmt.setAsParentOf(stmt.expression)
    stmt.label.accept(this, param)
    stmt.expression.accept(this, param)
  }

  /**
    * Executes the corresponding action.
    *
    * @param stmt  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    stmt.setAsParentOf(stmt.expression)
    stmt.expression.accept(this, param)
  }

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: CallPrefixExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: CallShapeExpr, param: Unit): Unit = {
    expr.setAsParentOf(expr.label)
    expr.label.accept(this, param)
  }

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: CallBaseExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: CardinalityExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: ConstraintBlockTripleExpr, param: Unit): Unit = {
    expr.body.foreach(tex => expr.setAsParentOf(tex))
    expr.body.foreach(tex => tex.accept(this, param))
  }

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: ConstraintNodeAnyTypeExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: ConstraintNodeBNodeExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: ConstraintNodeIRIExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: ConstraintNodeLiteralExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: ConstraintNodeNonLiteralExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: ConstraintTripleExpr, param: Unit): Unit = {
    expr.setAsParentOf(expr.property)
    expr.setAsParentOf(expr.constraint)
    expr.setAsParentOf(expr.cardinality)

    expr.property.accept(this, param)
    expr.constraint.accept(this, param)
    expr.cardinality.accept(this, param)
  }

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: ConstraintValueSetExpr, param: Unit): Unit = {
    expr.values.foreach(value => expr.setAsParentOf(value))
    expr.values.foreach(value => value.accept(this, param))
  }

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: LiteralIRIValueExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: LiteralRealValueExpr, param: Unit): Unit = {}

  /**
    * Executes the corresponding action.
    *
    * @param expr  is the node being visited.
    * @param param that comes from previous visit actions.
    * @return the computed value, if any.
    */
  override def visit(expr: LiteralStringValueExpr, param: Unit): Unit = {}
}
