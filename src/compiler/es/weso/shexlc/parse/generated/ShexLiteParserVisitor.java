// ------------------------------------------------------------------------------
// File: ShexLiteParserVisitor.java
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
// ------------------------------------------------------------------------------

// Generated from
// C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/es/weso/shexlc/grammar\ShexLiteParser.g4 by ANTLR 4.8
package es.weso.shexlc.parse.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * ShexLiteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface ShexLiteParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#schema}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSchema(ShexLiteParser.SchemaContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#statement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatement(ShexLiteParser.StatementContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#import_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImport_stmt(ShexLiteParser.Import_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#definition_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefinition_stmt(ShexLiteParser.Definition_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#start_def_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStart_def_stmt(ShexLiteParser.Start_def_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#prefix_def_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrefix_def_stmt(ShexLiteParser.Prefix_def_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#base_def_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBase_def_stmt(ShexLiteParser.Base_def_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#shape_def_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitShape_def_stmt(ShexLiteParser.Shape_def_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression(ShexLiteParser.ExpressionContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#literal_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral_expr(ShexLiteParser.Literal_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#literal_real_value_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral_real_value_expr(ShexLiteParser.Literal_real_value_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#literal_string_value_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral_string_value_expr(ShexLiteParser.Literal_string_value_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#literal_iri_value_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral_iri_value_expr(ShexLiteParser.Literal_iri_value_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#cardinality_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCardinality_expr(ShexLiteParser.Cardinality_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_expr(ShexLiteParser.Constraint_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_node_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_expr(ShexLiteParser.Constraint_node_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_block_triple_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_block_triple_expr(ShexLiteParser.Constraint_block_triple_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_triple_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_triple_expr(ShexLiteParser.Constraint_triple_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_node_iri_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_iri_expr(ShexLiteParser.Constraint_node_iri_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_valid_value_set_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_valid_value_set_type(ShexLiteParser.Constraint_valid_value_set_typeContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_node_any_type_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_any_type_expr(ShexLiteParser.Constraint_node_any_type_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_node_non_literal_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_non_literal_expr(
      ShexLiteParser.Constraint_node_non_literal_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_value_set_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_value_set_expr(ShexLiteParser.Constraint_value_set_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_node_bnode_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_bnode_expr(ShexLiteParser.Constraint_node_bnode_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#constraint_node_literal_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_literal_expr(ShexLiteParser.Constraint_node_literal_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#call_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCall_expr(ShexLiteParser.Call_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#call_prefix_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCall_prefix_expr(ShexLiteParser.Call_prefix_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link ShexLiteParser#call_shape_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCall_shape_expr(ShexLiteParser.Call_shape_exprContext ctx);
}
