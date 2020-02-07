// Generated from /Users/willy/github/shExLite/src/main/java/es.weso.shexl/parser/ShExL.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShExLParser}.
 */
public interface ShExLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShExLParser#shex_lite_doc}.
	 * @param ctx the parse tree
	 */
	void enterShex_lite_doc(ShExLParser.Shex_lite_docContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#shex_lite_doc}.
	 * @param ctx the parse tree
	 */
	void exitShex_lite_doc(ShExLParser.Shex_lite_docContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#prefix_def}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_def(ShExLParser.Prefix_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#prefix_def}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_def(ShExLParser.Prefix_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#shape_def}.
	 * @param ctx the parse tree
	 */
	void enterShape_def(ShExLParser.Shape_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#shape_def}.
	 * @param ctx the parse tree
	 */
	void exitShape_def(ShExLParser.Shape_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#shape_body}.
	 * @param ctx the parse tree
	 */
	void enterShape_body(ShExLParser.Shape_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#shape_body}.
	 * @param ctx the parse tree
	 */
	void exitShape_body(ShExLParser.Shape_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#constraint_def}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_def(ShExLParser.Constraint_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#constraint_def}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_def(ShExLParser.Constraint_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#constraint_field}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_field(ShExLParser.Constraint_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#constraint_field}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_field(ShExLParser.Constraint_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#constraint_type}.
	 * @param ctx the parse tree
	 */
	void enterConstraint_type(ShExLParser.Constraint_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#constraint_type}.
	 * @param ctx the parse tree
	 */
	void exitConstraint_type(ShExLParser.Constraint_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#property_def}.
	 * @param ctx the parse tree
	 */
	void enterProperty_def(ShExLParser.Property_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#property_def}.
	 * @param ctx the parse tree
	 */
	void exitProperty_def(ShExLParser.Property_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#shape_inv}.
	 * @param ctx the parse tree
	 */
	void enterShape_inv(ShExLParser.Shape_invContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#shape_inv}.
	 * @param ctx the parse tree
	 */
	void exitShape_inv(ShExLParser.Shape_invContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#prefix_inv}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_inv(ShExLParser.Prefix_invContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#prefix_inv}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_inv(ShExLParser.Prefix_invContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExLParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_type(ShExLParser.Primitive_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExLParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_type(ShExLParser.Primitive_typeContext ctx);
}