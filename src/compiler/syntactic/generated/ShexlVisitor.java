// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/grammar\Shexl.g4 by ANTLR 4.8
package syntactic.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShexlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShexlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShexlParser#schema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema(ShexlParser.SchemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ShexlParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#declaration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_statement(ShexlParser.Declaration_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#base_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase_declaration(ShexlParser.Base_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#start_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_declaration(ShexlParser.Start_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#prefix_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_declaration(ShexlParser.Prefix_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#shape_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_declaration(ShexlParser.Shape_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#import_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_statement(ShexlParser.Import_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#shape_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_name(ShexlParser.Shape_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#shape_invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_invocation(ShexlParser.Shape_invocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ShexlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#triple_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriple_expression(ShexlParser.Triple_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#triple_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriple_constraint(ShexlParser.Triple_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#prefix_invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_invocation(ShexlParser.Prefix_invocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#node_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode_constraint(ShexlParser.Node_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#value_set_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_set_type(ShexlParser.Value_set_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShexlParser#cardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCardinality(ShexlParser.CardinalityContext ctx);
}