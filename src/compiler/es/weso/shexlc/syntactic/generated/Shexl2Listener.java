// Generated from C:/Users/Willy/Documents/github/weso/shex-lite/src/compiler/es.weso.shexlc.grammar\Shexl2.g4 by
// ANTLR 4.8
package es.weso.shexlc.syntactic.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/** This interface defines a complete listener for a parse tree produced by {@link Shexl2Parser}. */
public interface Shexl2Listener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#schema}.
   *
   * @param ctx the parse tree
   */
  void enterSchema(Shexl2Parser.SchemaContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#schema}.
   *
   * @param ctx the parse tree
   */
  void exitSchema(Shexl2Parser.SchemaContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#statement}.
   *
   * @param ctx the parse tree
   */
  void enterStatement(Shexl2Parser.StatementContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#statement}.
   *
   * @param ctx the parse tree
   */
  void exitStatement(Shexl2Parser.StatementContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#import_stmt}.
   *
   * @param ctx the parse tree
   */
  void enterImport_stmt(Shexl2Parser.Import_stmtContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#import_stmt}.
   *
   * @param ctx the parse tree
   */
  void exitImport_stmt(Shexl2Parser.Import_stmtContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#definition_stmt}.
   *
   * @param ctx the parse tree
   */
  void enterDefinition_stmt(Shexl2Parser.Definition_stmtContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#definition_stmt}.
   *
   * @param ctx the parse tree
   */
  void exitDefinition_stmt(Shexl2Parser.Definition_stmtContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#start_def_stmt}.
   *
   * @param ctx the parse tree
   */
  void enterStart_def_stmt(Shexl2Parser.Start_def_stmtContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#start_def_stmt}.
   *
   * @param ctx the parse tree
   */
  void exitStart_def_stmt(Shexl2Parser.Start_def_stmtContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#prefix_def_stmt}.
   *
   * @param ctx the parse tree
   */
  void enterPrefix_def_stmt(Shexl2Parser.Prefix_def_stmtContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#prefix_def_stmt}.
   *
   * @param ctx the parse tree
   */
  void exitPrefix_def_stmt(Shexl2Parser.Prefix_def_stmtContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#base_def_stmt}.
   *
   * @param ctx the parse tree
   */
  void enterBase_def_stmt(Shexl2Parser.Base_def_stmtContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#base_def_stmt}.
   *
   * @param ctx the parse tree
   */
  void exitBase_def_stmt(Shexl2Parser.Base_def_stmtContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#shape_def_stmt}.
   *
   * @param ctx the parse tree
   */
  void enterShape_def_stmt(Shexl2Parser.Shape_def_stmtContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#shape_def_stmt}.
   *
   * @param ctx the parse tree
   */
  void exitShape_def_stmt(Shexl2Parser.Shape_def_stmtContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void enterExpression(Shexl2Parser.ExpressionContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#expression}.
   *
   * @param ctx the parse tree
   */
  void exitExpression(Shexl2Parser.ExpressionContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#literal_expr}.
   *
   * @param ctx the parse tree
   */
  void enterLiteral_expr(Shexl2Parser.Literal_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#literal_expr}.
   *
   * @param ctx the parse tree
   */
  void exitLiteral_expr(Shexl2Parser.Literal_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#literal_real_value_expr}.
   *
   * @param ctx the parse tree
   */
  void enterLiteral_real_value_expr(Shexl2Parser.Literal_real_value_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#literal_real_value_expr}.
   *
   * @param ctx the parse tree
   */
  void exitLiteral_real_value_expr(Shexl2Parser.Literal_real_value_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#literal_string_value_expr}.
   *
   * @param ctx the parse tree
   */
  void enterLiteral_string_value_expr(Shexl2Parser.Literal_string_value_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#literal_string_value_expr}.
   *
   * @param ctx the parse tree
   */
  void exitLiteral_string_value_expr(Shexl2Parser.Literal_string_value_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#literal_iri_value_expr}.
   *
   * @param ctx the parse tree
   */
  void enterLiteral_iri_value_expr(Shexl2Parser.Literal_iri_value_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#literal_iri_value_expr}.
   *
   * @param ctx the parse tree
   */
  void exitLiteral_iri_value_expr(Shexl2Parser.Literal_iri_value_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#cardinality_expr}.
   *
   * @param ctx the parse tree
   */
  void enterCardinality_expr(Shexl2Parser.Cardinality_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#cardinality_expr}.
   *
   * @param ctx the parse tree
   */
  void exitCardinality_expr(Shexl2Parser.Cardinality_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_expr(Shexl2Parser.Constraint_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_expr(Shexl2Parser.Constraint_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_node_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_node_expr(Shexl2Parser.Constraint_node_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_node_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_node_expr(Shexl2Parser.Constraint_node_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_block_triple_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_block_triple_expr(Shexl2Parser.Constraint_block_triple_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_block_triple_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_block_triple_expr(Shexl2Parser.Constraint_block_triple_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_triple_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_triple_expr(Shexl2Parser.Constraint_triple_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_triple_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_triple_expr(Shexl2Parser.Constraint_triple_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_node_iri_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_node_iri_expr(Shexl2Parser.Constraint_node_iri_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_node_iri_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_node_iri_expr(Shexl2Parser.Constraint_node_iri_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_valid_value_set_type}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_valid_value_set_type(
      Shexl2Parser.Constraint_valid_value_set_typeContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_valid_value_set_type}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_valid_value_set_type(Shexl2Parser.Constraint_valid_value_set_typeContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_node_any_type_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_node_any_type_expr(Shexl2Parser.Constraint_node_any_type_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_node_any_type_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_node_any_type_expr(Shexl2Parser.Constraint_node_any_type_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_node_non_literal_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_node_non_literal_expr(
      Shexl2Parser.Constraint_node_non_literal_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_node_non_literal_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_node_non_literal_expr(
      Shexl2Parser.Constraint_node_non_literal_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_value_set_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_value_set_expr(Shexl2Parser.Constraint_value_set_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_value_set_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_value_set_expr(Shexl2Parser.Constraint_value_set_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_node_bnode_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_node_bnode_expr(Shexl2Parser.Constraint_node_bnode_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_node_bnode_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_node_bnode_expr(Shexl2Parser.Constraint_node_bnode_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#constraint_node_literal_expr}.
   *
   * @param ctx the parse tree
   */
  void enterConstraint_node_literal_expr(Shexl2Parser.Constraint_node_literal_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#constraint_node_literal_expr}.
   *
   * @param ctx the parse tree
   */
  void exitConstraint_node_literal_expr(Shexl2Parser.Constraint_node_literal_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#call_expr}.
   *
   * @param ctx the parse tree
   */
  void enterCall_expr(Shexl2Parser.Call_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#call_expr}.
   *
   * @param ctx the parse tree
   */
  void exitCall_expr(Shexl2Parser.Call_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#call_prefix_expr}.
   *
   * @param ctx the parse tree
   */
  void enterCall_prefix_expr(Shexl2Parser.Call_prefix_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#call_prefix_expr}.
   *
   * @param ctx the parse tree
   */
  void exitCall_prefix_expr(Shexl2Parser.Call_prefix_exprContext ctx);
  /**
   * Enter a parse tree produced by {@link Shexl2Parser#call_shape_expr}.
   *
   * @param ctx the parse tree
   */
  void enterCall_shape_expr(Shexl2Parser.Call_shape_exprContext ctx);
  /**
   * Exit a parse tree produced by {@link Shexl2Parser#call_shape_expr}.
   *
   * @param ctx the parse tree
   */
  void exitCall_shape_expr(Shexl2Parser.Call_shape_exprContext ctx);
}
