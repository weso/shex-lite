// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/parser\ShExLite.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShExLiteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShExLiteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#shex_lite_doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShex_lite_doc(ShExLiteParser.Shex_lite_docContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#prefix_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_def(ShExLiteParser.Prefix_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#shape_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_def(ShExLiteParser.Shape_defContext ctx);
}