//------------------------------------------------------------------------------
// File: CGPython02ModuleGenStage.scala
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

import java.io.File

import compiler.es.weso.shexlc.IRGen.pythongen.internal.CGPythonImportGenerator
import es.weso.shexlc.IRGen.pythongen.internal.CGPythonFieldsGenerator
import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr.{CallBaseExpr, CallPrefixExpr}
import es.weso.shexlc.parse.ast.stmt.{ImportStmt, ShapeDefStmt}
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

import scala.collection.mutable.ListBuffer

class CGPython02ModuleGenStage(ccontex: CompilationContext) extends ASTDefaultVisitor[String] {

  private[this] var currentClassName: String = ""
  private[this] val stringBuilder = new StringBuilder()

  val generatedSources = ListBuffer.empty[(String, String)]


  override def visit(expr: CallBaseExpr, param: String): Unit = {
    currentClassName = expr.argument.replace("<", "")
                                    .replace(">", "")
                                    .toLowerCase().capitalize
  }

  override def visit(expr: CallPrefixExpr, param: String): Unit = {
    currentClassName = expr.argument.toLowerCase().capitalize
  }

  override def visit(schema: Schema, param: String): Unit = {
    schema.accept(new CGPythonImportGenerator(ccontex, stringBuilder), "")

    for(stmt <- schema.stmts) stmt.accept(this, "")

    val moduleName = new File(schema.getPosition.filename)
                           .getName.toLowerCase
                           .replaceAll("\\.[^.]*$", "") + ".py"
    generatedSources.append((moduleName, stringBuilder.toString()))
  }

  override def visit(stmt: ShapeDefStmt, param: String): Unit = {
    // This call will generate the class name.
    stmt.label.accept(this, param)

    // Generate the fields
    val fieldsGen = new CGPythonFieldsGenerator(ccontex, stringBuilder)

    // Write all the class static code.
    stringBuilder.append("@dataclass")
    stringBuilder.append(s"\nclass ${currentClassName}:")
    stringBuilder.append("\n")

    stmt.expression.accept(fieldsGen, param)
    if (!fieldsGen.hasGeneratedAnyField) stringBuilder.append("\tpass")  // empty class

    stringBuilder.append("\n")
  }
}