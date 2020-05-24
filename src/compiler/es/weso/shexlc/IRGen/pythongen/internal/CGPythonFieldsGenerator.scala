//------------------------------------------------------------------------------
// File: CGPythonFieldsGenerator.scala
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

package es.weso.shexlc.IRGen.pythongen.internal

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor
import compiler.es.weso.shexlc.IRGen.pythongen.internal.PythonDatatypeMappings.toPythonType

class CGPythonFieldsGenerator(ccontext: CompilationContext, stringBuilder: StringBuilder)
  extends ASTDefaultVisitor[String] {

  private[this] var fieldsGenerated: Int = 0

  override def visit(expr: ConstraintTripleExpr, param: String): Unit = {
    val property    = expr.property
    val constraint  = expr.constraint
    val cardinality = expr.cardinality

    stringBuilder.append(s"\t${property.asCallPrefixExpr.argument.toLowerCase}")

    constraint.accept(this, cardinality.asCardinalityExpr.max.toString)

    stringBuilder.append("\n")

    this.fieldsGenerated += 1
  }

  override def visit(expr: CallPrefixExpr, isList: String): Unit = {
    stringBuilder.append(": ")
    stringBuilder.append(toPythonType(expr, isList))
  }

  override def visit(expr: CallShapeExpr, isList: String): Unit = {
    stringBuilder.append(": ")
    stringBuilder.append(toPythonType(expr, isList))
  }

  def hasGeneratedAnyField: Boolean = {
    this.fieldsGenerated > 0
  }
}
