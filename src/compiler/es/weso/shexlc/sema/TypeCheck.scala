//--------------------------------------------------------------------------------------------------
// File: Sem01TypeCheckingStage.scala
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

package es.weso.shexlc.sema

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.{Err, ErrorHandler}
import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.stmt._
import es.weso.shexlc.parse.ast.visitor._

/**
 * The identification walker is the tool that travels the AST just to identify possible definitions an add the
 * information found to the symbol table.
 *
 */
class TypeCheck(ccontex: CompilationContext) extends DefaultShExLiteVisitor[Unit] {

  private[this] val errorHandler: ErrorHandler = ccontex.getErrorHandler

  override def visit(schema: Schema, param: Unit): Unit = {
    for(stmt <- schema.stmts) {
      if(!stmt.isStatement()) {
        errorHandler.addEvent(
          new Err(
            stmt,
            s"$stmt is not an statement",
            Err.TypeCheckingError
          )
        )
      }
      stmt.accept(this, param)
    }
  }

  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    if(!stmt.expression.isLiteralIRIValueExpr) {
      errorHandler.addEvent(
        new Err(
          stmt.expression,
          s"${stmt.expression} is not a Literal IRI Value Expression",
          Err.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ImportStmt, param: Unit): Unit = {
    if(!stmt.expression.isLiteralIRIValueExpr) {
      errorHandler.addEvent(
        new Err(
          stmt.expression,
          s"${stmt.expression} is not a Literal IRI Value Expression",
          Err.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    if(!stmt.expression.isLiteralIRIValueExpr) {
      errorHandler.addEvent(
        new Err(
          stmt.expression,
          s"${stmt.expression} is not a Literal IRI Value Expression",
          Err.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ShapeDefStmt, param: Unit): Unit = {
    if(!(stmt.label.isCallPrefixExpr || stmt.label.isCallBaseExpr)) {
      errorHandler.addEvent(
        new Err(
          stmt.label,
          s"${stmt.label} is not a Call Prefix or Base Expression",
          Err.TypeCheckingError
        )
      )
    }
    stmt.label.accept(this, param)
    if(!stmt.expression.isExpression) {
      errorHandler.addEvent(
        new Err(
          stmt.expression,
          s"${stmt.expression} is not an Expression",
          Err.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    if(!stmt.expression.isCallShapeExpr) {
      errorHandler.addEvent(
        new Err(
          stmt.expression,
          s"${stmt.expression} is not a Call Shape Expression",
          Err.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(expr: CallShapeExpr, param: Unit): Unit = {
    if(!(expr.label.isCallPrefixExpr || expr.label.isCallBaseExpr)) {
      errorHandler.addEvent(
        new Err(
          expr.label,
          s"${expr.label} is not a Call Prefix / Base Expression",
          Err.TypeCheckingError
        )
      )
    }
    expr.label.accept(this, param)
  }

  override def visit(expr: ConstraintBlockTripleExpr, param: Unit): Unit = {
    for(tripleExpr <- expr.body) {
      if(!tripleExpr.isConstraintTripleExpr) {
        errorHandler.addEvent(
          new Err(
            tripleExpr,
            s"$tripleExpr is not a Constraint Triple Expression",
            Err.TypeCheckingError
          )
        )
      }
      tripleExpr.accept(this, param)
    }
  }

  override def visit(expr: ConstraintTripleExpr, param: Unit): Unit = {
    if(!expr.property.isCallPrefixExpr) {
      errorHandler.addEvent(
        new Err(
          expr.property,
          s"${expr.property} is not a Call Prefix Expression",
          Err.TypeCheckingError
        )
      )
    }
    expr.property.accept(this, param)

    if(!expr.constraint.isExpression()) {
      errorHandler.addEvent(
        new Err(
          expr.constraint,
          s"${expr.constraint} is not an Expression",
          Err.TypeCheckingError
        )
      )
    }
    expr.constraint.accept(this, param)

    if(!expr.cardinality.isCardinalityExpr) {
      errorHandler.addEvent(
        new Err(
          expr.cardinality,
          s"${expr.cardinality} is not a Cardinality Expression",
          Err.TypeCheckingError
        )
      )
    }
    expr.cardinality.accept(this, param)
  }

  override def visit(expr: ConstraintValueSetExpr, param: Unit): Unit = {
    for(value <- expr.values) {
      if(!value.isConstraintValidValueSetExpr) {
        errorHandler.addEvent(
          new Err(
            value,
            s"$value is not a Valid Value Type Expression",
            Err.TypeCheckingError
          )
        )
      }
      value.accept(this, param)
    }
  }
}