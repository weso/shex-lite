// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/grammar\Shexl.g4 by ANTLR 4.8
package syntactic.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShexlParser}.
 */
public interface ShexlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShexlParser#schema}.
	 * @param ctx the parse tree
	 */
	void enterSchema(ShexlParser.SchemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#schema}.
	 * @param ctx the parse tree
	 */
	void exitSchema(ShexlParser.SchemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ShexlParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ShexlParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#declaration_statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_statement(ShexlParser.Declaration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#declaration_statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_statement(ShexlParser.Declaration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#base_declaration}.
	 * @param ctx the parse tree
	 */
	void enterBase_declaration(ShexlParser.Base_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#base_declaration}.
	 * @param ctx the parse tree
	 */
	void exitBase_declaration(ShexlParser.Base_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#start_declaration}.
	 * @param ctx the parse tree
	 */
	void enterStart_declaration(ShexlParser.Start_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#start_declaration}.
	 * @param ctx the parse tree
	 */
	void exitStart_declaration(ShexlParser.Start_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#prefix_declaration}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_declaration(ShexlParser.Prefix_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#prefix_declaration}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_declaration(ShexlParser.Prefix_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#shape_declaration}.
	 * @param ctx the parse tree
	 */
	void enterShape_declaration(ShexlParser.Shape_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#shape_declaration}.
	 * @param ctx the parse tree
	 */
	void exitShape_declaration(ShexlParser.Shape_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void enterImport_statement(ShexlParser.Import_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void exitImport_statement(ShexlParser.Import_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#shape_name}.
	 * @param ctx the parse tree
	 */
	void enterShape_name(ShexlParser.Shape_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#shape_name}.
	 * @param ctx the parse tree
	 */
	void exitShape_name(ShexlParser.Shape_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#shape_invocation}.
	 * @param ctx the parse tree
	 */
	void enterShape_invocation(ShexlParser.Shape_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#shape_invocation}.
	 * @param ctx the parse tree
	 */
	void exitShape_invocation(ShexlParser.Shape_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ShexlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ShexlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#triple_expression}.
	 * @param ctx the parse tree
	 */
	void enterTriple_expression(ShexlParser.Triple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#triple_expression}.
	 * @param ctx the parse tree
	 */
	void exitTriple_expression(ShexlParser.Triple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#triple_constraint}.
	 * @param ctx the parse tree
	 */
	void enterTriple_constraint(ShexlParser.Triple_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#triple_constraint}.
	 * @param ctx the parse tree
	 */
	void exitTriple_constraint(ShexlParser.Triple_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#prefix_invocation}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_invocation(ShexlParser.Prefix_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#prefix_invocation}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_invocation(ShexlParser.Prefix_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#node_constraint}.
	 * @param ctx the parse tree
	 */
	void enterNode_constraint(ShexlParser.Node_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#node_constraint}.
	 * @param ctx the parse tree
	 */
	void exitNode_constraint(ShexlParser.Node_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#value_set_type}.
	 * @param ctx the parse tree
	 */
	void enterValue_set_type(ShexlParser.Value_set_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#value_set_type}.
	 * @param ctx the parse tree
	 */
	void exitValue_set_type(ShexlParser.Value_set_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShexlParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void enterCardinality(ShexlParser.CardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShexlParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void exitCardinality(ShexlParser.CardinalityContext ctx);
}