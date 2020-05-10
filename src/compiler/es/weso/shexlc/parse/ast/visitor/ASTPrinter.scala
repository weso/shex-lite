//------------------------------------------------------------------------------
// File: ASTPrinter.scala
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

package es.weso.shexlc.parse.ast.visitor

import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr._
import es.weso.shexlc.parse.ast.stmt._

/**
  * The ast printer prints the content of the ast after the execution of the semantic validation and therefore should
  * only be applied to SIL. That is because it tries to print definitions.
  */
class ASTPrinter extends ASTGenericWalker[StringBuilder, String] {

  final val NL  = "\n"
  final val TAB = "  "

  override def visit(schema: Schema, param: StringBuilder): String = {
    param.append(
      s"(schema location=${schema.getPosition}"
    )
    // Open
    // schema.

    for (stmt <- schema.stmts) {
      param.append(NL + TAB)
      param.append(stmt.accept(this, param))
    }

    param.append(")") // Close schema.

    param.toString()
  }

  override def visit(stmt: BaseDefStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"(base_def iri='${stmt.expression.accept(this, param)}')")
    sb.toString()
  }

  override def visit(stmt: ImportStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"(import_stmt iri='${stmt.expression.accept(this, param)}')")
    sb.toString()
  }

  override def visit(stmt: PrefixDefStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(
      s"(prefix_def label='${stmt.label}' iri='${stmt.expression
        .accept(this, param)}' content='${stmt.getContent}')"
    )
    sb.toString()
  }

  override def visit(stmt: ShapeDefStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(
      s"(shape_def $NL$TAB$TAB${stmt.label.accept(this, param)}$NL$TAB$TAB${stmt.expression
        .accept(this, param)})"
    )
    sb.toString()
  }

  override def visit(stmt: StartDefStmt, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"(start_def $NL$TAB$TAB${stmt.expression.accept(this, param)})")
    sb.toString()
  }

  override def visit(expr: CallPrefixExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"(prefix_call label='${expr.label}' arg='${expr.argument}')")
    sb.toString()
  }

  override def visit(expr: CallShapeExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(
      s"(shape_call $NL$TAB$TAB$TAB$TAB$TAB${expr.label.accept(this, param)})"
    )
    sb.toString()
  }

  override def visit(expr: CallBaseExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"(base_call iri='${expr.argument}')")
    sb.toString()
  }

  override def visit(expr: CardinalityExpr, param: StringBuilder): String = {
    val sb = new StringBuilder()
    sb.append(s"(cardinality min='${expr.min}' max='${expr.max}')")
    sb.toString()
  }

  override def visit(
    expr: ConstraintBlockTripleExpr,
    param: StringBuilder
  ): String = {
    val sb = new StringBuilder()
    sb.append(s"(constraint_block")

    for (bExpr <- expr.body) {
      sb.append(s"$NL$TAB$TAB$TAB${bExpr.accept(this, param)}")
    }
    sb.append(s")")
    sb.toString()
  }

  override def visit(
    expr: ConstraintNodeAnyTypeExpr,
    param: StringBuilder
  ): String = {
    val sb = new StringBuilder()
    sb.append(s"(constraint type='Any')")
    sb.toString()
  }

  override def visit(
    expr: ConstraintNodeBNodeExpr,
    param: StringBuilder
  ): String = {
    val sb = new StringBuilder()
    sb.append(s"(constraint type='BNode')")
    sb.toString()
  }

  override def visit(
    expr: ConstraintNodeIRIExpr,
    param: StringBuilder
  ): String = {
    val sb = new StringBuilder()
    sb.append(s"(constraint type='IRI')")
    sb.toString()
  }

  override def visit(
    expr: ConstraintNodeLiteralExpr,
    param: StringBuilder
  ): String = {
    val sb = new StringBuilder()
    sb.append(s"(constraint type='Literal')")
    sb.toString()
  }

  override def visit(
    expr: ConstraintNodeNonLiteralExpr,
    param: StringBuilder
  ): String = {
    val sb = new StringBuilder()
    sb.append(s"'(constraint type=Non Literal)'")
    sb.toString()
  }

  override def visit(
    expr: ConstraintTripleExpr,
    param: StringBuilder
  ): String = {
    val sb   = new StringBuilder()
    val prop = expr.property.accept(this, param)
    val cons = expr.constraint.accept(this, param)
    val card = expr.cardinality.accept(this, param)
    sb.append(
      s"(triple_expr $NL$TAB$TAB$TAB$TAB$prop $NL$TAB$TAB$TAB$TAB$cons " +
      s"$NL$TAB$TAB$TAB$TAB$card)"
    )
    sb.toString()
  }

  override def visit(
    expr: ConstraintValueSetExpr,
    param: StringBuilder
  ): String = {
    val sb = new StringBuilder()
    sb.append(s"(value_set")

    for (value <- expr.values) {
      sb.append(NL + TAB + TAB + TAB + TAB + TAB + value.accept(this, param))
    }
    sb.append(s")")
    sb.toString()
  }

  override def visit(
    expr: LiteralIRIValueExpr,
    param: StringBuilder
  ): String = {
    val sb    = new StringBuilder()
    val value = expr.value
    sb.append(s"$value")
    sb.toString()
  }

  override def visit(
    expr: LiteralRealValueExpr,
    param: StringBuilder
  ): String = {
    val sb    = new StringBuilder()
    val value = expr.value
    sb.append(s"$value")
    sb.toString()
  }

  override def visit(
    expr: LiteralStringValueExpr,
    param: StringBuilder
  ): String = {
    val sb    = new StringBuilder()
    val value = expr.value
    sb.append(s"$value")
    sb.toString()
  }
}
