//------------------------------------------------------------------------------
// File: CGPythonImportGenerator.scala
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

package compiler.es.weso.shexlc.IRGen.pythongen.internal

import PythonDatatypeMappings.toPythonImport

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr.{CallPrefixExpr, CardinalityExpr, ConstraintTripleExpr}
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

import scala.collection.mutable

class CGPythonImportGenerator (ccontext: CompilationContext, stringBuilder: StringBuilder)
  extends ASTDefaultVisitor[String] {

  private[this] val imports = mutable.Set.empty[String]

  override def visit(schema: Schema, param: String): Unit = {
    this.imports += generateFromImport("dataclasses", "dataclass")

    schema.stmts.foreach(stmt => stmt.accept(this, ""))

    this.imports.toList.sorted.foreach(imp => stringBuilder.append(imp))
  }

  override def visit(expr: CallPrefixExpr, isList: String): Unit = {
    toPythonImport(expr, isList) match {
      case Some(value) => this.imports += generateFromImport(value._1, value._2)
      case None => this.imports += generateFromImport("typing", "Any")
    }
  }

  override def visit(expr: ConstraintTripleExpr, param: String): Unit = {
    val constraint  = expr.constraint
    val cardinality = expr.cardinality

    constraint.accept(this, cardinality.asCardinalityExpr.max.toString)
    cardinality.accept(this, cardinality.asCardinalityExpr.max.toString)
  }

  override def visit(expr: CardinalityExpr, param: String): Unit = {
    if (expr.max > 1) this.imports += generateFromImport("typing", "List")
  }

  private def generateBaseImport(importModule: String): String = {
    s"import $importModule"
  }

  private def generateFromImport(module: String, importObject: String): String = {
    s"from $module import $importObject\n\n"
  }
}
