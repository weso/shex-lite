/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/grammar\Shexl.g4 by ANTLR 4.8
package compiler.syntactic.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShexlParser}.
 */
public interface ShexlListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link ShexlParser#schema}.
     *
     * @param ctx the parse tree
     */
    void enterSchema(ShexlParser.SchemaContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#schema}.
     *
     * @param ctx the parse tree
     */
    void exitSchema(ShexlParser.SchemaContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(ShexlParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(ShexlParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#definition_statement}.
     *
     * @param ctx the parse tree
     */
    void enterDefinition_statement(ShexlParser.Definition_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#definition_statement}.
     *
     * @param ctx the parse tree
     */
    void exitDefinition_statement(ShexlParser.Definition_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#base_definition}.
     *
     * @param ctx the parse tree
     */
    void enterBase_definition(ShexlParser.Base_definitionContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#base_definition}.
     *
     * @param ctx the parse tree
     */
    void exitBase_definition(ShexlParser.Base_definitionContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#start_definition}.
     *
     * @param ctx the parse tree
     */
    void enterStart_definition(ShexlParser.Start_definitionContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#start_definition}.
     *
     * @param ctx the parse tree
     */
    void exitStart_definition(ShexlParser.Start_definitionContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#prefix_definition}.
     *
     * @param ctx the parse tree
     */
    void enterPrefix_definition(ShexlParser.Prefix_definitionContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#prefix_definition}.
     *
     * @param ctx the parse tree
     */
    void exitPrefix_definition(ShexlParser.Prefix_definitionContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#shape_definition}.
     *
     * @param ctx the parse tree
     */
    void enterShape_definition(ShexlParser.Shape_definitionContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#shape_definition}.
     *
     * @param ctx the parse tree
     */
    void exitShape_definition(ShexlParser.Shape_definitionContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#import_statement}.
     *
     * @param ctx the parse tree
     */
    void enterImport_statement(ShexlParser.Import_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#import_statement}.
     *
     * @param ctx the parse tree
     */
    void exitImport_statement(ShexlParser.Import_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#shape_name}.
     *
     * @param ctx the parse tree
     */
    void enterShape_name(ShexlParser.Shape_nameContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#shape_name}.
     *
     * @param ctx the parse tree
     */
    void exitShape_name(ShexlParser.Shape_nameContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#shape_invocation}.
     *
     * @param ctx the parse tree
     */
    void enterShape_invocation(ShexlParser.Shape_invocationContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#shape_invocation}.
     *
     * @param ctx the parse tree
     */
    void exitShape_invocation(ShexlParser.Shape_invocationContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#constraint}.
     *
     * @param ctx the parse tree
     */
    void enterConstraint(ShexlParser.ConstraintContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#constraint}.
     *
     * @param ctx the parse tree
     */
    void exitConstraint(ShexlParser.ConstraintContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#triple_constraint}.
     *
     * @param ctx the parse tree
     */
    void enterTriple_constraint(ShexlParser.Triple_constraintContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#triple_constraint}.
     *
     * @param ctx the parse tree
     */
    void exitTriple_constraint(ShexlParser.Triple_constraintContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#node_constraint}.
     *
     * @param ctx the parse tree
     */
    void enterNode_constraint(ShexlParser.Node_constraintContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#node_constraint}.
     *
     * @param ctx the parse tree
     */
    void exitNode_constraint(ShexlParser.Node_constraintContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#value_set_type}.
     *
     * @param ctx the parse tree
     */
    void enterValue_set_type(ShexlParser.Value_set_typeContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#value_set_type}.
     *
     * @param ctx the parse tree
     */
    void exitValue_set_type(ShexlParser.Value_set_typeContext ctx);

    /**
     * Enter a parse tree produced by {@link ShexlParser#cardinality}.
     *
     * @param ctx the parse tree
     */
    void enterCardinality(ShexlParser.CardinalityContext ctx);

    /**
     * Exit a parse tree produced by {@link ShexlParser#cardinality}.
     *
     * @param ctx the parse tree
     */
    void exitCardinality(ShexlParser.CardinalityContext ctx);
}