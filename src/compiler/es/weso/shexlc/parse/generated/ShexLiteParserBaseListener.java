// ------------------------------------------------------------------------------
// File: ShexLiteParserBaseListener.java
//
// Short version for non-lawyers:
//
// The ShEx Lite Project is dual-licensed under GNU 3.0 and
// MIT terms.
//
// Longer version:
//
// Copyrights in the ShEx Lite project are retained by their contributors. No
// copyright assignment is required to contribute to the ShEx Lite project.
//
// Some files include explicit copyright notices and/or license notices.
// For full authorship information, see the version control history.
//
// Except as otherwise noted (below and/or in individual files), ShEx Lite is
// licensed under the GNU, Version 3.0 <LICENSE-GNU> or
// <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
// <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
// In case of incompatibility between project licenses, GNU/GPLv3 will be
// applied.
//
// The ShEx Lite Project includes packages written by third parties.
// ------------------------------------------------------------------------------

// Generated from
// C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/es/weso/shexlc/grammar\ShexLiteParser.g4 by ANTLR 4.8
package es.weso.shexlc.parse.generated;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link ShexLiteParserListener}, which can be
 * extended to create a listener which only needs to handle a subset of the available methods.
 */
public class ShexLiteParserBaseListener implements ShexLiteParserListener {
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterSchema(ShexLiteParser.SchemaContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitSchema(ShexLiteParser.SchemaContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterStatement(ShexLiteParser.StatementContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitStatement(ShexLiteParser.StatementContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterImport_stmt(ShexLiteParser.Import_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitImport_stmt(ShexLiteParser.Import_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDefinition_stmt(ShexLiteParser.Definition_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDefinition_stmt(ShexLiteParser.Definition_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterStart_def_stmt(ShexLiteParser.Start_def_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitStart_def_stmt(ShexLiteParser.Start_def_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterPrefix_def_stmt(ShexLiteParser.Prefix_def_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitPrefix_def_stmt(ShexLiteParser.Prefix_def_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterBase_def_stmt(ShexLiteParser.Base_def_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitBase_def_stmt(ShexLiteParser.Base_def_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterShape_def_stmt(ShexLiteParser.Shape_def_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitShape_def_stmt(ShexLiteParser.Shape_def_stmtContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterExpression(ShexLiteParser.ExpressionContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitExpression(ShexLiteParser.ExpressionContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterLiteral_expr(ShexLiteParser.Literal_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitLiteral_expr(ShexLiteParser.Literal_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterLiteral_real_value_expr(ShexLiteParser.Literal_real_value_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitLiteral_real_value_expr(ShexLiteParser.Literal_real_value_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterLiteral_string_value_expr(ShexLiteParser.Literal_string_value_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitLiteral_string_value_expr(ShexLiteParser.Literal_string_value_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterLiteral_iri_value_expr(ShexLiteParser.Literal_iri_value_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitLiteral_iri_value_expr(ShexLiteParser.Literal_iri_value_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterCardinality_expr(ShexLiteParser.Cardinality_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitCardinality_expr(ShexLiteParser.Cardinality_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_expr(ShexLiteParser.Constraint_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_expr(ShexLiteParser.Constraint_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_node_expr(ShexLiteParser.Constraint_node_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_node_expr(ShexLiteParser.Constraint_node_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_block_triple_expr(
      ShexLiteParser.Constraint_block_triple_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_block_triple_expr(
      ShexLiteParser.Constraint_block_triple_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_triple_expr(ShexLiteParser.Constraint_triple_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_triple_expr(ShexLiteParser.Constraint_triple_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_node_iri_expr(ShexLiteParser.Constraint_node_iri_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_node_iri_expr(ShexLiteParser.Constraint_node_iri_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_valid_value_set_type(
      ShexLiteParser.Constraint_valid_value_set_typeContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_valid_value_set_type(
      ShexLiteParser.Constraint_valid_value_set_typeContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_node_any_type_expr(
      ShexLiteParser.Constraint_node_any_type_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_node_any_type_expr(
      ShexLiteParser.Constraint_node_any_type_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_node_non_literal_expr(
      ShexLiteParser.Constraint_node_non_literal_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_node_non_literal_expr(
      ShexLiteParser.Constraint_node_non_literal_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_value_set_expr(ShexLiteParser.Constraint_value_set_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_value_set_expr(ShexLiteParser.Constraint_value_set_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_node_bnode_expr(
      ShexLiteParser.Constraint_node_bnode_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_node_bnode_expr(
      ShexLiteParser.Constraint_node_bnode_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterConstraint_node_literal_expr(
      ShexLiteParser.Constraint_node_literal_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitConstraint_node_literal_expr(
      ShexLiteParser.Constraint_node_literal_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterCall_expr(ShexLiteParser.Call_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitCall_expr(ShexLiteParser.Call_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterCall_prefix_expr(ShexLiteParser.Call_prefix_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitCall_prefix_expr(ShexLiteParser.Call_prefix_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterCall_shape_expr(ShexLiteParser.Call_shape_exprContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitCall_shape_expr(ShexLiteParser.Call_shape_exprContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterEveryRule(ParserRuleContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitEveryRule(ParserRuleContext ctx) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void visitTerminal(TerminalNode node) {}
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void visitErrorNode(ErrorNode node) {}
}
