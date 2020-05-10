//------------------------------------------------------------------------------
// File: ASTBuilderParser.scala
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

package es.weso.shexlc.parse

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.{AbstractASTNode, Schema}
import es.weso.shexlc.parse.generated.{
  ShexLiteParser,
  ShexLiteParserBaseVisitor
}

class ASTBuilderParser(ccontext: CompilationContext)
    extends ShexLiteParserBaseVisitor[AbstractASTNode]
    with HasParseResult[Schema] {

  private var astRoot: Option[Schema] = Option.empty[Schema]

  /**
    * Gets the result of parsing.
    *
    * @return the result of parsing the parse tree
    */
  override def getParseResult: Schema = astRoot.get

  override def visitSchema(ctx: ShexLiteParser.SchemaContext): Schema = {
    astRoot = Option(new ParseSchema(ctx, this, ccontext).getParseResult)
    astRoot.get
  }

  override def visitImport_stmt(
    ctx: ShexLiteParser.Import_stmtContext
  ): AbstractASTNode = {
    new ParseImportStmt(ctx, this, ccontext).getParseResult
  }

  override def visitBase_def_stmt(
    ctx: ShexLiteParser.Base_def_stmtContext
  ): AbstractASTNode = {
    new ParseBaseDefStmt(ctx, this, ccontext).getParseResult
  }

  override def visitStart_def_stmt(
    ctx: ShexLiteParser.Start_def_stmtContext
  ): AbstractASTNode = {
    new ParseStartDefStmt(ctx, this, ccontext).getParseResult
  }

  override def visitPrefix_def_stmt(
    ctx: ShexLiteParser.Prefix_def_stmtContext
  ): AbstractASTNode = {
    new ParsePrefixDefStmt(ctx, this, ccontext).getParseResult
  }

  override def visitShape_def_stmt(
    ctx: ShexLiteParser.Shape_def_stmtContext
  ): AbstractASTNode = {
    new ParseShapeDefStmt(ctx, this, ccontext).getParseResult
  }

  override def visitLiteral_real_value_expr(
    ctx: ShexLiteParser.Literal_real_value_exprContext
  ): AbstractASTNode = {
    new ParseLiteralRealValueExpr(ctx, this, ccontext).getParseResult
  }

  override def visitLiteral_string_value_expr(
    ctx: ShexLiteParser.Literal_string_value_exprContext
  ): AbstractASTNode = {
    new ParseLiteralStringValueExpr(ctx, this, ccontext).getParseResult
  }

  override def visitLiteral_iri_value_expr(
    ctx: ShexLiteParser.Literal_iri_value_exprContext
  ): AbstractASTNode = {
    new ParseLiteralIRIValueExpr(ctx, this, ccontext).getParseResult
  }

  override def visitCardinality_expr(
    ctx: ShexLiteParser.Cardinality_exprContext
  ): AbstractASTNode = {
    new ParseCardinalityExpr(ctx, this, ccontext).getParseResult
  }

  override def visitConstraint_block_triple_expr(
    ctx: ShexLiteParser.Constraint_block_triple_exprContext
  ): AbstractASTNode = {
    new ParseConstraintBlockTripleExpr(ctx, this, ccontext).getParseResult
  }

  override def visitConstraint_triple_expr(
    ctx: ShexLiteParser.Constraint_triple_exprContext
  ): AbstractASTNode = {
    new ParseConstraintTripleExpr(ctx, this, ccontext).getParseResult
  }

  override def visitConstraint_node_iri_expr(
    ctx: ShexLiteParser.Constraint_node_iri_exprContext
  ): AbstractASTNode = {
    new ParseConstraintNodeIRIExpr(ctx, this, ccontext).getParseResult
  }

  override def visitConstraint_node_any_type_expr(
    ctx: ShexLiteParser.Constraint_node_any_type_exprContext
  ): AbstractASTNode = {
    new ParseConstraintNodeAnyTypeExpr(ctx, this, ccontext).getParseResult
  }

  override def visitConstraint_node_non_literal_expr(
    ctx: ShexLiteParser.Constraint_node_non_literal_exprContext
  ): AbstractASTNode = {
    new ParseConstraintNodeNonLiteralExpr(ctx, this, ccontext).getParseResult
  }

  override def visitConstraint_value_set_expr(
    ctx: ShexLiteParser.Constraint_value_set_exprContext
  ): AbstractASTNode = {
    new ParseConstraintValueSetExpr(ctx, this, ccontext).getParseResult
  }

  override def visitConstraint_node_bnode_expr(
    ctx: ShexLiteParser.Constraint_node_bnode_exprContext
  ): AbstractASTNode = {
    new ParseConstraintNodeBNodeExpr(ctx, this, ccontext).getParseResult
  }

  override def visitConstraint_node_literal_expr(
    ctx: ShexLiteParser.Constraint_node_literal_exprContext
  ): AbstractASTNode = {
    new ParseConstraintNodeLiteralExpr(ctx, this, ccontext).getParseResult
  }

  override def visitCall_prefix_expr(
    ctx: ShexLiteParser.Call_prefix_exprContext
  ): AbstractASTNode = {
    new ParseCallPrefixExpr(ctx, this, ccontext).getParseResult
  }

  override def visitCall_shape_expr(
    ctx: ShexLiteParser.Call_shape_exprContext
  ): AbstractASTNode = {
    new ParseCallShapeExpr(ctx, this, ccontext).getParseResult
  }
}
