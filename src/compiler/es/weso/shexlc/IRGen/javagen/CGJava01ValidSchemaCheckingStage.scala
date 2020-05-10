//------------------------------------------------------------------------------
// File: CGJava01ValidSchemaCheckingStage.scala
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

package es.weso.shexlc.IRGen.javagen

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.{Err, ErrorHandler, Warn}
import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.stmt._
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

class CGJava01ValidSchemaCheckingStage(ccontext: CompilationContext)
    extends ASTDefaultVisitor[Unit] {

  private[this] val msgsHandler: ErrorHandler = ccontext.getErrorHandler

  override def visit(stmt: ImportStmt, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(
        stmt,
        "import statements are not valid for java code generation",
        Warn.FeatureIgnored
      )
    )
    //stmt.expression.accept(this, param)
  }

  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(
        stmt,
        "the start statement will be ignored for java code generation",
        Warn.FeatureIgnored
      )
    )
    //stmt.expression.accept(this, param)
  }

  override def visit(expr: ConstraintNodeAnyTypeExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(
        expr,
        "this constraint will be substituted by the Object java class",
        Warn.FeatureIgnored
      )
    )
  }

  override def visit(expr: ConstraintNodeBNodeExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(
        expr,
        "this constraint cannot be represented in java",
        Err.FeatureNotAvailable
      )
    )
  }

  override def visit(expr: ConstraintNodeIRIExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(
        expr,
        "this constraint cannot be represented in java",
        Err.FeatureNotAvailable
      )
    )
  }

  override def visit(expr: ConstraintNodeLiteralExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(
        expr,
        "this constraint cannot be represented in java",
        Err.FeatureNotAvailable
      )
    )
  }

  override def visit(expr: ConstraintNodeNonLiteralExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(
        expr,
        "this constraint cannot be represented in java",
        Err.FeatureNotAvailable
      )
    )
  }

  override def visit(expr: ConstraintBlockTripleExpr, param: Unit): Unit = {
    for (constraint <- expr.body) {
      if (constraint.isConstraintTripleExpr) {
        constraint.accept(this, param)
      } else {
        msgsHandler.addEvent(
          new Err(
            constraint,
            "this constraint cannot be represented in java",
            Err.FeatureNotAvailable
          )
        )
      }
    }
  }

  override def visit(expr: ConstraintTripleExpr, param: Unit): Unit = {
    val constraint  = expr.constraint
    val cardinality = expr.cardinality
    val isCallShape = expr.constraint.isCallShapeExpr

    if (constraint.isCallPrefixExpr && !constraint.asCallPrefixExpr.label
          .equals("xsd")) {
      msgsHandler.addEvent(
        new Err(
          constraint,
          "this prefix has no mapping in java",
          Err.FeatureNotAvailable
        )
      )
    }

    if (cardinality.asCardinalityExpr.isEmptyCardinality) {
      msgsHandler.addEvent(
        new Err(
          cardinality,
          "this cardinality has no mapping in java",
          Err.FeatureNotAvailable
        )
      )
    }

    expr.property.accept(this, param)
    expr.constraint.accept(this, param)
    expr.cardinality.accept(this, param)
  }

  override def visit(expr: ConstraintValueSetExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(
        expr,
        "this constraint cannot be represented in java",
        Err.FeatureNotAvailable
      )
    )
    expr.values.foreach(value => value.accept(this, param))
  }
}
