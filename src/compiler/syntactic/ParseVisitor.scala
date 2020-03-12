package compiler.syntactic

import compiler.syntactic.generated._
import compiler.ast.{ASTNode, ASTWalker, BaseDeclaration, Cardinality, Constraint, DeclarationStmt, IRILiteral, ImportStatement, NodeConstraint, PrefixDeclaration, Schema, ShapeDeclaration, ShapeInvocation, StartDeclaration, Statement, TripleExpressionConstraint, ValueSetConstraint}
import org.antlr.v4.runtime.tree.{AbstractParseTreeVisitor, ErrorNode, ParseTree, RuleNode, TerminalNode}

import collection.JavaConverters._

class ParseVisitor extends ShexlVisitor[ASTNode] {

  override def visitSchema(ctx: ShexlParser.SchemaContext): Schema = {

    val statements = ctx.statement().asScala.map(st => st.accept(this)).toList.asInstanceOf[List[Statement]]

    new Schema("", ctx.start.getLine, ctx.start.getCharPositionInLine, statements)
  }

  override def visitStatement(ctx: ShexlParser.StatementContext): Statement = {
    ctx.definition_statement().accept(this)
    ctx.import_statement().accept(this)
    null
  }

  //override def visitDefinition_statement(ctx: ShexlParser.Definition_statementContext): DeclarationStmt = ???

  //override def visitBase_definition(ctx: ShexlParser.Base_definitionContext): BaseDeclaration = ???

  //override def visitStart_definition(ctx: ShexlParser.Start_definitionContext): StartDeclaration = ???

  //override def visitPrefix_definition(ctx: ShexlParser.Prefix_definitionContext): PrefixDeclaration = ???

  //override def visitShape_definition(ctx: ShexlParser.Shape_definitionContext): ShapeDeclaration = ???

  override def visitImport_statement(ctx: ShexlParser.Import_statementContext): ImportStatement = {
    val iri = new IRILiteral("a", ctx.IRI().getSymbol.getLine, ctx.IRI.getSymbol.getCharPositionInLine, ctx.IRI.getText )
    new ImportStatement("a", ctx.start.getLine, ctx.start.getCharPositionInLine,iri)
  }

  /*override def visitShape_name(ctx: ShexlParser.Shape_nameContext): ASTNode = ???

  override def visitShape_invocation(ctx: ShexlParser.Shape_invocationContext): ShapeInvocation = ???

  override def visitConstraint(ctx: ShexlParser.ConstraintContext): Constraint = ???

  override def visitTriple_constraint(ctx: ShexlParser.Triple_constraintContext): TripleExpressionConstraint = ???

  override def visitNode_constraint(ctx: ShexlParser.Node_constraintContext): NodeConstraint = ???

  override def visitValue_set_type(ctx: ShexlParser.Value_set_typeContext): ValueSetConstraint = ???*/

  override def visitCardinality(ctx: ShexlParser.CardinalityContext): Cardinality = {
    val min = 0
    val max = 0

    ctx.getRuleIndex match {
      case 0 => new Cardinality("", ctx.start.getLine, ctx.start.getCharPositionInLine, 0, (2 ^ 32) ^ Integer.MAX_VALUE-1)
      case 1 => new Cardinality("", ctx.start.getLine, ctx.start.getCharPositionInLine, 1, (2 ^ 32) ^ Integer.MAX_VALUE-1)
      case 2 => new Cardinality("", ctx.start.getLine, ctx.start.getCharPositionInLine, 0, 1)
      case 3 => new Cardinality("", ctx.start.getLine, ctx.start.getCharPositionInLine, min, (2 ^ 32) ^ Integer.MAX_VALUE-1)
      case 4 => new Cardinality("", ctx.start.getLine, ctx.start.getCharPositionInLine, min, max)
    }


  }
}
