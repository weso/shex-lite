// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/parser\ShExLite.g4 by ANTLR 4.8
package es.weso.shexl.parser;
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
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#shape_body}.
	 * @param ctx the parse tree
	 */
	void enterShape_body(ShExLiteParser.Shape_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#shape_body}.
	 * @param ctx the parse tree
	 */
	void exitShape_body(ShExLiteParser.Shape_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#constraint_def}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_def(ShExLiteParser.Constraint_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#constraint_def}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_def(ShExLiteParser.Constraint_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#contraint_id}.
	 * @param ctx the parse tree
	 */
	void enterContraint_id(ShExLiteParser.Contraint_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#contraint_id}.
	 * @param ctx the parse tree
	 */
	void exitContraint_id(ShExLiteParser.Contraint_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#constraint_type}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_type(ShExLiteParser.Constraint_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#constraint_type}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_type(ShExLiteParser.Constraint_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#property_def}.
	 * @param ctx the parse tree
	 */
	void enterProperty_def(ShExLiteParser.Property_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#property_def}.
	 * @param ctx the parse tree
	 */
	void exitProperty_def(ShExLiteParser.Property_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#shape_inv}.
	 * @param ctx the parse tree
	 */
	void enterShape_inv(ShExLiteParser.Shape_invContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#shape_inv}.
	 * @param ctx the parse tree
	 */
	void exitShape_inv(ShExLiteParser.Shape_invContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#prefix_inv}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_inv(ShExLiteParser.Prefix_invContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#prefix_inv}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_inv(ShExLiteParser.Prefix_invContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLiteParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_type(ShExLiteParser.Primitive_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLiteParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_type(ShExLiteParser.Primitive_typeContext ctx);
}