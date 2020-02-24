// Generated from C:/Users/Willy/Documents/github/weso/shex-lite/src/compiler/grammar\shexl.g4 by ANTLR 4.8
package compiler.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link shexlParser}.
 */
public interface shexlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link shexlParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(shexlParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(shexlParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(shexlParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(shexlParser.DefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#base_def}.
	 * @param ctx the parse tree
	 */
	void enterBase_def(shexlParser.Base_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#base_def}.
	 * @param ctx the parse tree
	 */
	void exitBase_def(shexlParser.Base_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#start_def}.
	 * @param ctx the parse tree
	 */
	void enterStart_def(shexlParser.Start_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#start_def}.
	 * @param ctx the parse tree
	 */
	void exitStart_def(shexlParser.Start_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#prefix_def}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_def(shexlParser.Prefix_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#prefix_def}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_def(shexlParser.Prefix_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#shape_def}.
	 * @param ctx the parse tree
	 */
	void enterShape_def(shexlParser.Shape_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#shape_def}.
	 * @param ctx the parse tree
	 */
	void exitShape_def(shexlParser.Shape_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#shape_lbl}.
	 * @param ctx the parse tree
	 */
	void enterShape_lbl(shexlParser.Shape_lblContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#shape_lbl}.
	 * @param ctx the parse tree
	 */
	void exitShape_lbl(shexlParser.Shape_lblContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#triple_expr}.
	 * @param ctx the parse tree
	 */
	void enterTriple_expr(shexlParser.Triple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#triple_expr}.
	 * @param ctx the parse tree
	 */
	void exitTriple_expr(shexlParser.Triple_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#triple_constraint}.
	 * @param ctx the parse tree
	 */
	void enterTriple_constraint(shexlParser.Triple_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#triple_constraint}.
	 * @param ctx the parse tree
	 */
	void exitTriple_constraint(shexlParser.Triple_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(shexlParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(shexlParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#node_constraint}.
	 * @param ctx the parse tree
	 */
	void enterNode_constraint(shexlParser.Node_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#node_constraint}.
	 * @param ctx the parse tree
	 */
	void exitNode_constraint(shexlParser.Node_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void enterCardinality(shexlParser.CardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void exitCardinality(shexlParser.CardinalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#prefix_ref}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_ref(shexlParser.Prefix_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#prefix_ref}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_ref(shexlParser.Prefix_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link shexlParser#shape_ref}.
	 * @param ctx the parse tree
	 */
	void enterShape_ref(shexlParser.Shape_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link shexlParser#shape_ref}.
	 * @param ctx the parse tree
	 */
	void exitShape_ref(shexlParser.Shape_refContext ctx);
}