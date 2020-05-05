//--------------------------------------------------------------------------------------------------
// File: ShexLiteParserListener.java
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

// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/es/weso/shexlc/grammar\ShexLiteParser.g4 by ANTLR 4.8
package es.weso.shexlc.parse.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShexLiteParser}.
 */
public interface ShexLiteParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#schema}.
	 * @param ctx the parse tree
	 */
	void enterSchema(ShexLiteParser.SchemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#schema}.
	 * @param ctx the parse tree
	 */
	void exitSchema(ShexLiteParser.SchemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ShexLiteParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ShexLiteParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(ShexLiteParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(ShexLiteParser.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#definition_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDefinition_stmt(ShexLiteParser.Definition_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#definition_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDefinition_stmt(ShexLiteParser.Definition_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#start_def_stmt}.
	 * @param ctx the parse tree
	 */
	void enterStart_def_stmt(ShexLiteParser.Start_def_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#start_def_stmt}.
	 * @param ctx the parse tree
	 */
	void exitStart_def_stmt(ShexLiteParser.Start_def_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#prefix_def_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_def_stmt(ShexLiteParser.Prefix_def_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#prefix_def_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_def_stmt(ShexLiteParser.Prefix_def_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#base_def_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_def_stmt(ShexLiteParser.Base_def_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#base_def_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_def_stmt(ShexLiteParser.Base_def_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#shape_def_stmt}.
	 * @param ctx the parse tree
	 */
	void enterShape_def_stmt(ShexLiteParser.Shape_def_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#shape_def_stmt}.
	 * @param ctx the parse tree
	 */
	void exitShape_def_stmt(ShexLiteParser.Shape_def_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ShexLiteParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ShexLiteParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#literal_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_expr(ShexLiteParser.Literal_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#literal_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_expr(ShexLiteParser.Literal_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#literal_real_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_real_value_expr(ShexLiteParser.Literal_real_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#literal_real_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_real_value_expr(ShexLiteParser.Literal_real_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#literal_string_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_string_value_expr(ShexLiteParser.Literal_string_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#literal_string_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_string_value_expr(ShexLiteParser.Literal_string_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#literal_iri_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_iri_value_expr(ShexLiteParser.Literal_iri_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#literal_iri_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_iri_value_expr(ShexLiteParser.Literal_iri_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#cardinality_expr}.
	 * @param ctx the parse tree
	 */
	void enterCardinality_expr(ShexLiteParser.Cardinality_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#cardinality_expr}.
	 * @param ctx the parse tree
	 */
	void exitCardinality_expr(ShexLiteParser.Cardinality_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_expr(ShexLiteParser.Constraint_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_expr(ShexLiteParser.Constraint_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_node_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_node_expr(ShexLiteParser.Constraint_node_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_node_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_node_expr(ShexLiteParser.Constraint_node_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_block_triple_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_block_triple_expr(ShexLiteParser.Constraint_block_triple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_block_triple_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_block_triple_expr(ShexLiteParser.Constraint_block_triple_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_triple_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_triple_expr(ShexLiteParser.Constraint_triple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_triple_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_triple_expr(ShexLiteParser.Constraint_triple_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_node_iri_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_node_iri_expr(ShexLiteParser.Constraint_node_iri_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_node_iri_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_node_iri_expr(ShexLiteParser.Constraint_node_iri_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_valid_value_set_type}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_valid_value_set_type(ShexLiteParser.Constraint_valid_value_set_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_valid_value_set_type}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_valid_value_set_type(ShexLiteParser.Constraint_valid_value_set_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_node_any_type_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_node_any_type_expr(ShexLiteParser.Constraint_node_any_type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_node_any_type_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_node_any_type_expr(ShexLiteParser.Constraint_node_any_type_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_node_non_literal_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_node_non_literal_expr(ShexLiteParser.Constraint_node_non_literal_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_node_non_literal_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_node_non_literal_expr(ShexLiteParser.Constraint_node_non_literal_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_value_set_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_value_set_expr(ShexLiteParser.Constraint_value_set_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_value_set_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_value_set_expr(ShexLiteParser.Constraint_value_set_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_node_bnode_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_node_bnode_expr(ShexLiteParser.Constraint_node_bnode_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_node_bnode_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_node_bnode_expr(ShexLiteParser.Constraint_node_bnode_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#constraint_node_literal_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_node_literal_expr(ShexLiteParser.Constraint_node_literal_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#constraint_node_literal_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_node_literal_expr(ShexLiteParser.Constraint_node_literal_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(ShexLiteParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(ShexLiteParser.Call_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#call_prefix_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_prefix_expr(ShexLiteParser.Call_prefix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#call_prefix_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_prefix_expr(ShexLiteParser.Call_prefix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexLiteParser#call_shape_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_shape_expr(ShexLiteParser.Call_shape_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexLiteParser#call_shape_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_shape_expr(ShexLiteParser.Call_shape_exprContext ctx);
}