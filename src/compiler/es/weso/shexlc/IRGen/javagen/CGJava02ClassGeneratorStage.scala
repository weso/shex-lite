//--------------------------------------------------------------------------------------------------
// File: CGJava02ClassGeneratorStage.scala
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

package es.weso.shexlc.IRGen.javagen

import es.weso.shexlc.parse.ast.expr.{CallBaseExpr, CallPrefixExpr}
import es.weso.shexlc.parse.ast.stmt.ShapeDefStmt
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor
import es.weso.shexlc.IRGen.javagen.internal._
import es.weso.shexlc.internal.{CompilationContext}
import es.weso.shexlc.internal.errorhandler.ErrorHandler

import scala.collection.mutable.ListBuffer

class CGJava02ClassGeneratorStage(ccontex: CompilationContext) extends ASTDefaultVisitor[String] {

  private[this] var stringBuilder = new StringBuilder() // This string builder will contain the generated sources.
  private[shexlc] var generatedSources = new ListBuffer[(String, String)].empty

  private[this] var className: String = ""

  override def visit(stmt: ShapeDefStmt, param: String): Unit = {

    // Clean the string builder where the class will be generated.
    this.stringBuilder = new StringBuilder()

    // This call will generate the class name.
    stmt.label.accept(this, param)

    // Generate the fields, the constructor and the getter and the setter.
    val fieldsGen = new CGJava03FieldsGenerator(ccontex, stringBuilder)
    val constructorGen = new CGJava04ConstructorGenerator(ccontex, stringBuilder)
    val getSetGen = new CGJava05GetSetGenerator(ccontex, stringBuilder)

    // Imports generator
    stmt.accept(new CGJava021ImportGenerator(ccontex, stringBuilder), null)

    // Write all the class static code.
    stringBuilder.append(s"public class $className {")
    stringBuilder.append("\n")
    stmt.expression.accept(fieldsGen, param) // Propagate the action to generate the fields.
    stringBuilder.append("\n")
    stmt.expression.accept(constructorGen, className) // Propagate the action to generate the constructor.
    stringBuilder.append("\n")
    stmt.expression.accept(getSetGen, param) // Propagate the action to generate the getters and the setters.
    stringBuilder.append(s"}")
    stringBuilder.append("\n")

    // Add the generated class to the list of generated results.
    generatedSources += ((className, stringBuilder.toString()))
  }

  override def visit(expr: CallBaseExpr, param: String): Unit = {
    className = expr.argument
      .replace("<", "")
      .replace(">", "")
      .toLowerCase()
      .capitalize
  }

  override def visit(expr: CallPrefixExpr, param: String): Unit = {
    className = expr.argument
      .toLowerCase()
      .capitalize
  }
}
