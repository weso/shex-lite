//--------------------------------------------------------------------------------------------------
// File: PrettyPrintASTVisitor.scala
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

package es.weso.shexlc.parse.ast.visitor

import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.stmt._

/**
 * The ast printer prints the content of the ast after the execution of the semantic validation and therefore should
 * only be applied to SIL. That is because it tries to print definitions.
 */
class ASTPrinter extends ASTGenericWalker[StringBuilder, String] {

  final val NL = "\n"
  final val TAB = "\t"

  override def visit(schema: Schema, param: StringBuilder): String = {
    param.append(schema)

    for (stmt <- schema.stmts) {
      param.append(NL + TAB + "|")
      param.append(stmt.accept(this, param))
    }

    param.toString()
  }

  override def visit(stmt: BaseDefStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val expr = stmt.expression.accept(this, param)
    sb.append(s"--BaseDefStmt:")
    sb.append(NL + TAB + "|" + TAB + "|")
    sb.append(s"--iri: $expr")
    sb.toString()
  }

  override def visit(stmt: ImportStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val expr = stmt.expression.accept(this, param)
    sb.append(s"--ImportStmt:")
    sb.append(NL + TAB + "|" + TAB + "|")
    sb.append(s"--iri: $expr")
    sb.toString()
  }

  override def visit(stmt: PrefixDefStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val lbl = stmt.label
    val expression = stmt.expression.asLiteralIRIValueExpr.accept(this, param)
    sb.append(s"--PrefixDefStmt:")
    sb.append(NL + TAB + "|" + TAB + "|")
    sb.append(s"--label: $lbl")
    sb.append(NL + TAB + "|" + TAB + "|")
    sb.append(s"--iri: $expression")
    sb.toString()
  }

  override def visit(stmt: ShapeDefStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val lbl = stmt.label.accept(this, param)
    val expr = stmt.expression.accept(this, param)
    sb.append(s"--ShapeDefStmt:")
    sb.append(NL + TAB + "|" + TAB + "|")
    sb.append(s"--label: $lbl")
    sb.append(NL + TAB + "|" + TAB + "|")
    sb.append(s"--expr: $expr")
    sb.toString()
  }

  override def visit(stmt: StartDefStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val expr = stmt.expression.accept(this, param)
    sb.append(s"--StartDefStmt:")
    sb.append(NL + TAB + "|" + TAB + "|")
    sb.append(s"--shape: $expr")
    sb.toString()
  }

  override def visit(expr: CallPrefixExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val lbl = expr.label
    val arg = expr.argument
    sb.append(s"CallPrefixExpr: $lbl:$arg")
    sb.toString()
  }

  override def visit(expr: CallShapeExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val lbl = expr.label.accept(this, param)
    sb.append(s"CallShapeExpr: $lbl")
    sb.toString()
  }

  override def visit(expr: CallBaseExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val arg = expr.argument
    sb.append(s"BaseCall:$arg")
    sb.toString()
  }

  override def visit(expr: CardinalityExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val min = expr.min
    val max = expr.max
    sb.append(s"CardinalityExpr: [$min, $max]")
    sb.toString()
  }

  override def visit(expr: ConstraintBlockTripleExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(NL + TAB + "|" + TAB + "|" + TAB + "|")
    sb.append(s"--ConstraintBlockTripleExpr:")

    for (bExpr <- expr.body) {
      sb.append(NL + TAB + "|" + TAB + "|" + TAB + "|" + TAB + "|")
      sb.append(bExpr.accept(this, param))
    }
    sb.toString()
  }

  override def visit(expr: ConstraintNodeAnyTypeExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"ConstraintNodeAnyTypeExpr")
    sb.toString()
  }

  override def visit(expr: ConstraintNodeBNodeExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"ConstraintNodeBNodeExpr")
    sb.toString()
  }

  override def visit(expr: ConstraintNodeIRIExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"ConstraintNodeIRIExpr")
    sb.toString()
  }

  override def visit(expr: ConstraintNodeLiteralExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"ConstraintNodeLiteralExpr")
    sb.toString()
  }

  override def visit(expr: ConstraintNodeNonLiteralExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"ConstraintNodeNonLiteralExpr")
    sb.toString()
  }

  override def visit(expr: ConstraintTripleExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val prop = expr.property.accept(this, param)
    val cons = expr.constraint.accept(this, param)
    val card = expr.cardinality.accept(this, param)
    sb.append(s"--ConstraintTripleExpr: [$prop] [$cons] [$card]")
    sb.toString()
  }

  override def visit(expr: ConstraintValueSetExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"ConstraintValueSetExpr: ")

    for (value <- expr.values) {
      sb.append(value.accept(this, param))
    }

    sb.toString()
  }

  override def visit(expr: LiteralIRIValueExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val value = expr.value
    sb.append(s"LiteralIRIValueExpr: $value")
    sb.toString()
  }

  override def visit(expr: LiteralRealValueExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val value = expr.value
    sb.append(s"LiteralRealValueExpr: $value")
    sb.toString()
  }

  override def visit(expr: LiteralStringValueExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    val value = expr.value
    sb.append(s"LiteralStringValueExpr: $value")
    sb.toString()
  }
}
