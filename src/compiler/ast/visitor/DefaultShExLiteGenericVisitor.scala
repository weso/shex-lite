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

package ast.visitor
import ast.Schema
import ast.expr._
import ast.stmt._

class DefaultShExLiteGenericVisitor[TP] extends ShExLiteGenericVisitor[TP, Unit] {

  override def visit(schema: Schema, param: TP): Unit = {
    schema.stmts.foreach(stmt => stmt.accept(this, param))
  }

  override def visit(stmt: BaseDefStmt, param: TP): Unit = {
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ImportStmt, param: TP): Unit = {
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: PrefixDefStmt, param: TP): Unit = {
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ShapeDefStmt, param: TP): Unit = {
    stmt.label.accept(this, param)
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: StartDefStmt, param: TP): Unit = {
    stmt.expression.accept(this, param)
  }

  override def visit(expr: CallPrefixExpr, param: TP): Unit = {}

  override def visit(expr: CallShapeExpr, param: TP): Unit = {
    expr.label.accept(this, param)
  }

  override def visit(expr: CardinalityExpr, param: TP): Unit = {}

  override def visit(expr: ConstraintBlockTripleExpr, param: TP): Unit = {
    expr.body.foreach(ex => ex.accept(this, param))
  }

  override def visit(expr: ConstraintNodeAnyTypeExpr, param: TP): Unit = {}

  override def visit(expr: ConstraintNodeBNodeExpr, param: TP): Unit = {}

  override def visit(expr: ConstraintNodeIRIExpr, param: TP): Unit = {}

  override def visit(expr: ConstraintNodeLiteralExpr, param: TP): Unit = {}

  override def visit(expr: ConstraintNodeNonLiteralExpr, param: TP): Unit = {}

  override def visit(expr: ConstraintTripleExpr, param: TP): Unit = {
    expr.property.accept(this, param)
    expr.constraint.accept(this, param)
    expr.cardinality.accept(this, param)
  }

  override def visit(expr: ConstraintValueSetExpr, param: TP): Unit = {
    expr.values.foreach(value => value.accept(this, param))
  }

  override def visit(expr: LiteralIRIValueExpr, param: TP): Unit = {}

  override def visit(expr: LiteralRealValueExpr, param: TP): Unit = {}

  override def visit(expr: LiteralStringValueExpr, param: TP): Unit = {}
}
