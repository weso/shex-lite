// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/main/java/es.weso.shexl/parser\ShExL.g4 by ANTLR 4.8
package es.weso.shexl.parser;

  import es.weso.shexl.*;
  import java.util.*;

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
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#shape_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_body(ShExLiteParser.Shape_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#constraint_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_def(ShExLiteParser.Constraint_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#contraint_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContraint_id(ShExLiteParser.Contraint_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#constraint_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint_type(ShExLiteParser.Constraint_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#property_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_def(ShExLiteParser.Property_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#shape_inv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_inv(ShExLiteParser.Shape_invContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#prefix_inv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_inv(ShExLiteParser.Prefix_invContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExLiteParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_type(ShExLiteParser.Primitive_typeContext ctx);
}