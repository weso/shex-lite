// Generated from C:/Users/Willy/Documents/github/weso/shex-lite/src/compiler/grammar\Shexl2.g4 by
// ANTLR 4.8
package syntactic.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * Shexl2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface Shexl2Visitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#schema}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSchema(Shexl2Parser.SchemaContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#statement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatement(Shexl2Parser.StatementContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#import_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImport_stmt(Shexl2Parser.Import_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#definition_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefinition_stmt(Shexl2Parser.Definition_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#start_def_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStart_def_stmt(Shexl2Parser.Start_def_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#prefix_def_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrefix_def_stmt(Shexl2Parser.Prefix_def_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#base_def_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBase_def_stmt(Shexl2Parser.Base_def_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#shape_def_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitShape_def_stmt(Shexl2Parser.Shape_def_stmtContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression(Shexl2Parser.ExpressionContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#literal_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral_expr(Shexl2Parser.Literal_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#literal_real_value_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral_real_value_expr(Shexl2Parser.Literal_real_value_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#literal_string_value_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral_string_value_expr(Shexl2Parser.Literal_string_value_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#literal_iri_value_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral_iri_value_expr(Shexl2Parser.Literal_iri_value_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#cardinality_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCardinality_expr(Shexl2Parser.Cardinality_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_expr(Shexl2Parser.Constraint_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_node_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_expr(Shexl2Parser.Constraint_node_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_block_triple_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_block_triple_expr(Shexl2Parser.Constraint_block_triple_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_triple_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_triple_expr(Shexl2Parser.Constraint_triple_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_node_iri_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_iri_expr(Shexl2Parser.Constraint_node_iri_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_valid_value_set_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_valid_value_set_type(Shexl2Parser.Constraint_valid_value_set_typeContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_node_any_type_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_any_type_expr(Shexl2Parser.Constraint_node_any_type_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_node_non_literal_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_non_literal_expr(Shexl2Parser.Constraint_node_non_literal_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_value_set_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_value_set_expr(Shexl2Parser.Constraint_value_set_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_node_bnode_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_bnode_expr(Shexl2Parser.Constraint_node_bnode_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#constraint_node_literal_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstraint_node_literal_expr(Shexl2Parser.Constraint_node_literal_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#call_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCall_expr(Shexl2Parser.Call_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#call_prefix_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCall_prefix_expr(Shexl2Parser.Call_prefix_exprContext ctx);
  /**
   * Visit a parse tree produced by {@link Shexl2Parser#call_shape_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCall_shape_expr(Shexl2Parser.Call_shape_exprContext ctx);
}
