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

package es.weso.shexlc.codegen.javagen.internal

import java.io.PrintWriter

import es.weso.shexl.{ShExLCompiler, ShExLCompilerStage, ShExLCompilerTargetLanguage}
import es.weso.shexlc.ast.Schema
import es.weso.shexlc.ast.expr.{CallPrefixExpr, CallShapeExpr, ConstraintBlockTripleExpr}
import es.weso.shexlc.ast.visitor.DefaultShExLiteVisitor
import es.weso.shexlc.internal.io.CompilerMsgsHandler
import es.weso.shexlc.internal.symboltable.SymbolTable

class CGJava04ConstructorGenerator(msgsHandler: CompilerMsgsHandler, writer: PrintWriter) extends DefaultShExLiteVisitor[String] {

  override def visit(expr: ConstraintBlockTripleExpr, className: String): Unit = {
    writer.print(s"\tpublic ${className.toLowerCase.capitalize}(")

    // Constructor parameters here.
    // Format: type parameterName, type2 parameterName2, ...
    // Example: List<String> names
    val fields = expr.body
    for(i <- 0 to fields.size-1) {
      fields(i).asConstraintTripleExpr.constraint.accept(this,
        fields(i).asConstraintTripleExpr.cardinality.asCardinalityExpr.max.toString)
      writer.print(fields(i).asConstraintTripleExpr.property.asCallPrefixExpr.argument.toLowerCase)
      if(i != fields.size-1) {
        writer.print(", ")
      }
    }
    writer.println(") {")

    // Print body of the constructor
    for(field <- fields) {
      val fieldName = field.asConstraintTripleExpr.property.asCallPrefixExpr.argument.toLowerCase
      writer.println(s"\t\tthis.$fieldName = $fieldName;")
    }

    // Close the constructor
    writer.println("\t}")
  }

  override def visit(expr: CallPrefixExpr, isList: String): Unit = {
    expr.argument match {
      case "string" => if(isList > "1") writer.print("List<String> ") else writer.print("String ")
      case "integer" => if(isList > "1") writer.print("List<int> ") else writer.print("int ")
      case "date" => if(isList > "1") writer.print("List<Date> ") else writer.print("Date ")
      case _ =>
    }
  }

  override def visit(expr: CallShapeExpr, isList: String): Unit = {
    if(expr.label.isCallPrefixExpr) {
      val prefixCall = expr.label.asCallPrefixExpr
      if(isList > "1")
        writer.print(s"List<${prefixCall.argument.toLowerCase.capitalize}> ")
      else
        writer.print(s"${prefixCall.argument.toLowerCase.capitalize} ")
    } else {
      val baseCall = expr.label.asCallBaseExpr
      if(isList > "1")
        writer.print(s"List<${baseCall.argument.toLowerCase.capitalize}> ")
      else
        writer.print(s"${baseCall.argument.toLowerCase.capitalize} ")
    }
  }
}
