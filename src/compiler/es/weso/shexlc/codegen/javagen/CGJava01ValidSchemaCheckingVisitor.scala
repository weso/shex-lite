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

package es.weso.shexlc.codegen.javagen

import es.weso.shexlc.ast.expr._
import es.weso.shexlc.ast.stmt._
import es.weso.shexlc.ast.visitor.DefaultShExLiteVisitor
import es.weso.shexlc.internal.io.CompilerMsgsHandler
import es.weso.shexlc.internal.io.impl.{CompilerMsgErrorType, CompilerMsgWarningType, DefaultCompilerMsg}
import es.weso.shexlc.internal.symboltable.SymbolTable

class CGJava01ValidSchemaCheckingVisitor(symbolTable: SymbolTable, msgsHandler: CompilerMsgsHandler) extends DefaultShExLiteVisitor[Unit] {


  override def visit(stmt: ImportStmt, param: Unit): Unit = {
    msgsHandler.addMsg(
      new DefaultCompilerMsg(
        stmt.expression.getPosition,
        stmt.getRange,
        stmt.expression.getRange,
        "import statements are not valid for java code generation",
        CompilerMsgErrorType.FeatureNotAvailable
      )
    )
    //stmt.expression.accept(this, param)
  }

  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    msgsHandler.addMsg(
      new DefaultCompilerMsg(
        stmt.expression.getPosition,
        stmt.getRange,
        stmt.expression.getRange,
        "the start statement will be ignored for java code generation",
        CompilerMsgWarningType.FeatureIgnored
      )
    )
    //stmt.expression.accept(this, param)
  }

  override def visit(expr: ConstraintNodeAnyTypeExpr, param: Unit): Unit = {
    msgsHandler.addMsg(
      new DefaultCompilerMsg(
        expr.getPosition,
        expr.getRange,
        expr.getRange,
        "this constraint will be substituted by the Object java class",
        CompilerMsgWarningType.SchemaWithoutDirectMapping
      )
    )
  }

  override def visit(expr: ConstraintNodeBNodeExpr, param: Unit): Unit = {
    msgsHandler.addMsg(
      new DefaultCompilerMsg(
        expr.getPosition,
        expr.getRange,
        expr.getRange,
        "this constraint cannot be represented in java",
        CompilerMsgErrorType.FeatureNotAvailable
      )
    )
  }

  override def visit(expr: ConstraintNodeIRIExpr, param: Unit): Unit = {
    msgsHandler.addMsg(
      new DefaultCompilerMsg(
        expr.getPosition,
        expr.getRange,
        expr.getRange,
        "this constraint cannot be represented in java",
        CompilerMsgErrorType.FeatureNotAvailable
      )
    )
  }

  override def visit(expr: ConstraintNodeLiteralExpr, param: Unit): Unit = {
    msgsHandler.addMsg(
      new DefaultCompilerMsg(
        expr.getPosition,
        expr.getRange,
        expr.getRange,
        "this constraint cannot be represented in java",
        CompilerMsgErrorType.FeatureNotAvailable
      )
    )
  }

  override def visit(expr: ConstraintNodeNonLiteralExpr, param: Unit): Unit = {
    msgsHandler.addMsg(
      new DefaultCompilerMsg(
        expr.getPosition,
        expr.getRange,
        expr.getRange,
        "this constraint cannot be represented in java",
        CompilerMsgErrorType.FeatureNotAvailable
      )
    )
  }

  override def visit(expr: ConstraintBlockTripleExpr, param: Unit): Unit = {
    for(constraint <- expr.body) {
      if(constraint.isConstraintTripleExpr) {
        constraint.accept(this, param)
      } else {
        new DefaultCompilerMsg(
          constraint.getPosition,
          expr.getRange,
          constraint.getRange,
          "this constraint cannot be represented in java",
          CompilerMsgErrorType.FeatureNotAvailable
        )
      }
    }
  }

  override def visit(expr: ConstraintTripleExpr, param: Unit): Unit = {
    val constraint = expr.constraint
    val cardinality = expr.cardinality
    val isCallShape = expr.constraint.isCallShapeExpr

    if(constraint.isCallPrefixExpr && !constraint.asCallPrefixExpr.label.equals("xsd")) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          expr.getPosition,
          expr.getRange,
          expr.constraint.getRange,
          "this prefix has no mapping in java",
          CompilerMsgErrorType.FeatureNotAvailable
        )
      )
    }

    if(cardinality.asCardinalityExpr.isEmptyCardinality) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          expr.getPosition,
          expr.getRange,
          expr.getRange,
          "this cardinality cannot be represented in java",
          CompilerMsgErrorType.FeatureNotAvailable
        )
      )
    }

    expr.property.accept(this, param)
    expr.constraint.accept(this, param)
    expr.cardinality.accept(this, param)
  }

  override def visit(expr: ConstraintValueSetExpr, param: Unit): Unit = {
    msgsHandler.addMsg(
      new DefaultCompilerMsg(
        expr.getPosition,
        expr.getRange,
        expr.getRange,
        "this constraint cannot be represented in java",
        CompilerMsgErrorType.FeatureNotAvailable
      )
    )
    expr.values.foreach(value => value.accept(this, param))
  }
}