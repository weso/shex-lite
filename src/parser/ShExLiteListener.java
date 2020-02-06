// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/parser\ShExLite.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShExLiteParser}.
 */
public interface ShExLiteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#shex_lite_doc}.
	 * @param ctx the parse tree
	 */
	void enterShex_lite_doc(ShExLiteParser.Shex_lite_docContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#shex_lite_doc}.
	 * @param ctx the parse tree
	 */
	void exitShex_lite_doc(ShExLiteParser.Shex_lite_docContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#prefix_def}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_def(ShExLiteParser.Prefix_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#prefix_def}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_def(ShExLiteParser.Prefix_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#shape_def}.
	 * @param ctx the parse tree
	 */
	void enterShape_def(ShExLiteParser.Shape_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#shape_def}.
	 * @param ctx the parse tree
	 */
	void exitShape_def(ShExLiteParser.Shape_defContext ctx);
}