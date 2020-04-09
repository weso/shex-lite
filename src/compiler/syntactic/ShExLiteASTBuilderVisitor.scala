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

package compiler.syntactic

import compiler.ast.NodeWithPosition
import compiler.ast.stmt.BaseDefStmt
import compiler.syntactic.generated.{Shexl2BaseVisitor, Shexl2Parser}
import compiler.syntactic.parser._

class ShExLiteASTBuilderVisitor extends Shexl2BaseVisitor[NodeWithPosition] {

  override def visitSchema(ctx: Shexl2Parser.SchemaContext): NodeWithPosition = {
    new SchemaPsr(ctx, this).getParseResult
  }

  override def visitImport_stmt(ctx: Shexl2Parser.Import_stmtContext): NodeWithPosition = {
    new ImportStmtPsr(ctx, this).getParseResult
  }

  override def visitBase_def_stmt(ctx: Shexl2Parser.Base_def_stmtContext): BaseDefStmt = {
    new BaseDefStmtPsr(ctx, this).getParseResult
  }

  override def visitStart_def_stmt(ctx: Shexl2Parser.Start_def_stmtContext): NodeWithPosition = {
    new StartDefStmtPsr(ctx, this).getParseResult
  }

  override def visitPrefix_def_stmt(ctx: Shexl2Parser.Prefix_def_stmtContext): NodeWithPosition = {
    new PrefixDefStmtPsr(ctx, this).getParseResult
  }

  override def visitShape_def_stmt(ctx: Shexl2Parser.Shape_def_stmtContext): NodeWithPosition = {
    new ShapeDefStmtPsr(ctx, this).getParseResult
  }

  override def visitLiteral_real_value_expr(ctx: Shexl2Parser.Literal_real_value_exprContext): NodeWithPosition = {
    new LiteralRealValueExprPsr(ctx, this).getParseResult
  }

  override def visitLiteral_string_value_expr(ctx: Shexl2Parser.Literal_string_value_exprContext): NodeWithPosition = {
    new LiteralStringValueExprPsr(ctx, this).getParseResult
  }

  override def visitLiteral_iri_value_expr(ctx: Shexl2Parser.Literal_iri_value_exprContext): NodeWithPosition = {
    new LiteralIRIValueExprPsr(ctx, this).getParseResult
  }

  override def visitCardinality_expr(ctx: Shexl2Parser.Cardinality_exprContext): NodeWithPosition = {
    new CardinalityExprPsr(ctx, this).getParseResult
  }

  override def visitConstraint_block_triple_expr(ctx: Shexl2Parser.Constraint_block_triple_exprContext):
    NodeWithPosition = {
    new ConstraintBlockTripleExprPsr(ctx, this).getParseResult
  }

  override def visitConstraint_triple_expr(ctx: Shexl2Parser.Constraint_triple_exprContext): NodeWithPosition = {
    new ConstraintTripleExprPsr(ctx, this).getParseResult
  }

  override def visitConstraint_node_iri_expr(ctx: Shexl2Parser.Constraint_node_iri_exprContext): NodeWithPosition = {
    new ConstraintNodeIRIExprPsr(ctx, this).getParseResult
  }

  override def visitConstraint_node_any_type_expr(ctx: Shexl2Parser.Constraint_node_any_type_exprContext):
    NodeWithPosition = {
    new ConstraintNodeAnyTypeExprPsr(ctx, this).getParseResult
  }

  override def visitConstraint_node_non_literal_expr(ctx: Shexl2Parser.Constraint_node_non_literal_exprContext):
    NodeWithPosition = {
    new ConstraintNodeNonLiteralExprPsr(ctx, this).getParseResult
  }

  override def visitConstraint_value_set_expr(ctx: Shexl2Parser.Constraint_value_set_exprContext): NodeWithPosition = {
    new ConstraintValueSetExprPsr(ctx, this).getParseResult
  }

  override def visitConstraint_node_bnode_expr(ctx: Shexl2Parser.Constraint_node_bnode_exprContext):
    NodeWithPosition = {
    new ConstraintNodeBNodeExprPsr(ctx, this).getParseResult
  }

  override def visitConstraint_node_literal_expr(ctx: Shexl2Parser.Constraint_node_literal_exprContext):
    NodeWithPosition = {
    new ConstraintNodeLiteralExprPsr(ctx, this).getParseResult
  }

  override def visitCall_prefix_expr(ctx: Shexl2Parser.Call_prefix_exprContext): NodeWithPosition = {
    new CallPrefixExprPsr(ctx, this).getParseResult
  }

  override def visitCall_shape_expr(ctx: Shexl2Parser.Call_shape_exprContext): NodeWithPosition = {
    new CallShapeExprPsr(ctx, this).getParseResult
  }
}
