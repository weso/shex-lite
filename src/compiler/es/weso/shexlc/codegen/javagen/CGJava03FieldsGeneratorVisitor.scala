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

import java.io.PrintWriter

import es.weso.shexlc.ast.expr._
import es.weso.shexlc.ast.visitor.DefaultShExLiteVisitor
import es.weso.shexlc.internal.io.CompilerMsgsHandler

class CGJava03FieldsGeneratorVisitor(msgsHandler: CompilerMsgsHandler, writer: PrintWriter)
  extends DefaultShExLiteVisitor[String] {

  override def visit(expr: ConstraintTripleExpr, param: String): Unit = {
    val property = expr.property
    val constraint = expr.constraint
    val cardinality = expr.cardinality

    // Field type.
    constraint.accept(this, cardinality.asCardinalityExpr.max.toString)

    // Field name.
    writer.println(s"${property.asCallPrefixExpr.argument.toLowerCase()};")
  }

  override def visit(expr: CallPrefixExpr, isList: String): Unit = {
    writer.print("\tprivate ")
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
        writer.print(s"\tprivate List<${prefixCall.argument.toLowerCase.capitalize}> ")
      else
        writer.print(s"\tprivate ${prefixCall.argument.toLowerCase.capitalize} ")
    } else {
      val baseCall = expr.label.asCallBaseExpr
      if(isList > "1")
        writer.print(s"\tprivate List<${baseCall.argument.toLowerCase.capitalize}> ")
      else
        writer.print(s"\tprivate ${baseCall.argument.toLowerCase.capitalize} ")
    }
  }
}
