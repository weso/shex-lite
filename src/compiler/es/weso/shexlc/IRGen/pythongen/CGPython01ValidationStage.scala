//------------------------------------------------------------------------------
// File: CGPython01ValidationStage.scala
//
// Copyright 2020 Alejandro González Hevia
//
// Permission is hereby granted, free of charge, to any person obtaining a
// copy of this software and associated documentation files (the "Software"),
// to deal in the Software without restriction, including without limitation
// the rights to use, copy, modify, merge, publish, distribute, sublicense,
// and/or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
//------------------------------------------------------------------------------

package compiler.es.weso.shexlc.IRGen.pythongen

import compiler.es.weso.shexlc.IRGen.pythongen.internal.PythonDatatypeMappings.hasPythonDatatypeMapping
import compiler.es.weso.shexlc.IRGen.pythongen.internal.UriConstants.extractCompleteUriFrom
import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.{Err, ErrorHandler, Warn}
import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.stmt.StartDefStmt
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

class CGPython01ValidationStage(ccontext: CompilationContext) extends ASTDefaultVisitor[Unit] {

  private[this] val msgsHandler: ErrorHandler = ccontext.getErrorHandler

  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    msgsHandler.addEvent(new Warn(
      stmt,
      "the start statement will be ignored" + " for Python code generation",
      Warn.FeatureIgnored
    ))
  }

  override def visit(expr: ConstraintNodeBNodeExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(expr, "this constraint cannot be represented" + " in Python", Err.FeatureNotAvailable)
    )
  }

  override def visit(expr: ConstraintNodeIRIExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(expr, "this constraint cannot be represented" + " in Python", Err.FeatureNotAvailable)
    )
  }

  override def visit(expr: ConstraintNodeLiteralExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(expr, "this constraint cannot be represented" + " in Python", Err.FeatureNotAvailable)
    )
  }

  override def visit(expr: ConstraintNodeNonLiteralExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(expr, "this constraint cannot be represented" + " in Python", Err.FeatureNotAvailable)
    )
  }

  override def visit(expr: ConstraintBlockTripleExpr, param: Unit): Unit = {
    for (constraint <- expr.body) {
      if (constraint.isConstraintTripleExpr || constraint.isConstraintValueSetExpr) { constraint.accept(this, param) }
      else {
        msgsHandler.addEvent(new Err(
          constraint,
          "this constraint cannot be " + "represented in Python",
          Err.FeatureNotAvailable
        ))
      }
    }
  }

  override def visit(expr: ConstraintTripleExpr, param: Unit): Unit = {
    val constraint  = expr.constraint
    val cardinality = expr.cardinality

    if (constraint.isCallPrefixExpr) {
      val completeURI = extractCompleteUriFrom(constraint.asCallPrefixExpr)
      if (!hasPythonDatatypeMapping(completeURI)) {
        msgsHandler.addEvent(
          new Err(constraint, "this resource has no mapping in" + " Python", Err.FeatureNotAvailable)
        )
      }
    }

    if (cardinality.asCardinalityExpr.isEmptyCardinality) {
      msgsHandler.addEvent(new Err(
        cardinality,
        "this cardinality has no mapping in" + " Python",
        Err.FeatureNotAvailable
      ))
    }

    expr.property.accept(this, param)
    expr.constraint.accept(this, param)
    expr.cardinality.accept(this, param)
  }

  override def visit(expr: ConstraintValueSetExpr, param: Unit): Unit = {
    msgsHandler.addEvent(
      new Err(expr, "this constraint cannot be represented" + " in Python", Err.FeatureNotAvailable)
    )
    expr.values.foreach(value => value.accept(this, param))
  }
}
