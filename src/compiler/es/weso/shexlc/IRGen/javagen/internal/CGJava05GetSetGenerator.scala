//--------------------------------------------------------------------------------------------------
// File: CGJava05GetSetGenerator.scala
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

package es.weso.shexlc.IRGen.javagen.internal

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.expr.{CallPrefixExpr, CallShapeExpr, ConstraintBlockTripleExpr}
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

class CGJava05GetSetGenerator(ccontext: CompilationContext, stringBuilder: StringBuilder)
  extends ASTDefaultVisitor[String] {

  override def visit(expr: ConstraintBlockTripleExpr, param: String): Unit = {

    for(field <- expr.body) {

      // Getter
      stringBuilder.append(s"\tpublic ")
      field.asConstraintTripleExpr.constraint.accept(this, field.asConstraintTripleExpr.cardinality.asCardinalityExpr.max.toString)
      stringBuilder.append(s"get${field.asConstraintTripleExpr.property.asCallPrefixExpr.argument.toLowerCase.capitalize}() {")
      stringBuilder.append("\n")
      stringBuilder.append(s"\t\treturn this.${field.asConstraintTripleExpr.property.asCallPrefixExpr.argument.toLowerCase};")
      stringBuilder.append("\n")
      stringBuilder.append("\t}")
      stringBuilder.append("\n")
      stringBuilder.append("\n")

      // Setter
      stringBuilder.append(s"\tpublic void set${field.asConstraintTripleExpr.property.asCallPrefixExpr.argument.toLowerCase.capitalize}(")
      field.asConstraintTripleExpr.constraint.accept(this, field.asConstraintTripleExpr.cardinality.asCardinalityExpr.max.toString)
      stringBuilder.append(s"${field.asConstraintTripleExpr.property.asCallPrefixExpr.argument.toLowerCase}) {")
      stringBuilder.append("\n")
      stringBuilder.append(s"\t\tthis.${field.asConstraintTripleExpr.property.asCallPrefixExpr.argument.toLowerCase} = " +
        s"${field.asConstraintTripleExpr.property.asCallPrefixExpr.argument.toLowerCase};")
      stringBuilder.append("\n")
      stringBuilder.append("\t}")
      stringBuilder.append("\n")
      stringBuilder.append("\n")
    }
  }

  override def visit(expr: CallPrefixExpr, isList: String): Unit = {
    expr.argument match {
      case "string" => if(isList > "1") stringBuilder.append("List<String> ") else stringBuilder.append("String ")
      case "integer" => if(isList > "1") stringBuilder.append("List<int> ") else stringBuilder.append("int ")
      case "date" => if(isList > "1") stringBuilder.append("List<Date> ") else stringBuilder.append("Date ")
      case _ =>
    }
  }

  override def visit(expr: CallShapeExpr, isList: String): Unit = {
    if(expr.label.isCallPrefixExpr) {
      val prefixCall = expr.label.asCallPrefixExpr
      if(isList > "1")
        stringBuilder.append(s"List<${prefixCall.argument.toLowerCase.capitalize}> ")
      else
        stringBuilder.append(s"${prefixCall.argument.toLowerCase.capitalize} ")
    } else {
      val baseCall = expr.label.asCallBaseExpr
      if(isList > "1")
        stringBuilder.append(s"List<${baseCall.argument.toLowerCase.capitalize}> ")
      else
        stringBuilder.append(s"${baseCall.argument.toLowerCase.capitalize} ")
    }
  }
}
