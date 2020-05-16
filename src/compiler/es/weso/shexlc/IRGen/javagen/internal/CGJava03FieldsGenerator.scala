//------------------------------------------------------------------------------
// File: CGJava03FieldsGenerator.scala
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

package es.weso.shexlc.IRGen.javagen.internal

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

class CGJava03FieldsGenerator(
  ccontext: CompilationContext,
  stringBuilder: StringBuilder
) extends ASTDefaultVisitor[String] {

  override def visit(expr: ConstraintTripleExpr, param: String): Unit = {
    val property    = expr.property
    val constraint  = expr.constraint
    val cardinality = expr.cardinality

    // Field type.
    constraint.accept(this, cardinality.asCardinalityExpr.max.toString)

    // Field name.
    stringBuilder.append(
      s"${property.asCallPrefixExpr.argument.toLowerCase()};"
    )
    stringBuilder.append("\n")
  }

  override def visit(expr: CallPrefixExpr, isList: String): Unit = {
    stringBuilder.append("\tprivate ")
    expr.argument match {
      case "string" =>
        if (isList > "1")
          stringBuilder.append(
            "List<String> " +
            ""
          )
        else stringBuilder.append("String ")
      case "integer" =>
        if (isList > "1") stringBuilder.append("List<int> ")
        else stringBuilder.append("int ")
      case "date" =>
        if (isList > "1") stringBuilder.append("List<Date> ")
        else stringBuilder.append("Date ")
      case _ =>
    }
  }

  override def visit(expr: CallShapeExpr, isList: String): Unit = {
    if (expr.label.isCallPrefixExpr) {
      val prefixCall = expr.label.asCallPrefixExpr
      if (isList > "1")
        stringBuilder.append(
          s"\tprivate List<${prefixCall.argument.toLowerCase.capitalize}> "
        )
      else
        stringBuilder.append(
          s"\tprivate ${prefixCall.argument.toLowerCase.capitalize} "
        )
    } else {
      val baseCall = expr.label.asCallBaseExpr
      if (isList > "1")
        stringBuilder.append(
          s"\tprivate List<${baseCall.argument.toLowerCase.capitalize}> "
        )
      else
        stringBuilder.append(
          s"\tprivate ${baseCall.argument.toLowerCase.capitalize} "
        )
    }
  }
}
