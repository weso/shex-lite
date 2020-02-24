// Generated from C:/Users/Willy/Documents/github/weso/shex-lite/src/compiler/grammar\shexl.g4 by ANTLR 4.8
package compiler.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link shexlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface shexlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link shexlParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(shexlParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitions(shexlParser.DefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#base_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase_def(shexlParser.Base_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#start_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_def(shexlParser.Start_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#prefix_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_def(shexlParser.Prefix_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#shape_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_def(shexlParser.Shape_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#shape_lbl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_lbl(shexlParser.Shape_lblContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#triple_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriple_expr(shexlParser.Triple_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#triple_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriple_constraint(shexlParser.Triple_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(shexlParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#node_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode_constraint(shexlParser.Node_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#cardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCardinality(shexlParser.CardinalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#prefix_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_ref(shexlParser.Prefix_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link shexlParser#shape_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_ref(shexlParser.Shape_refContext ctx);
}