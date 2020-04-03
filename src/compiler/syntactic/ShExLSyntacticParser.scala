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

package compiler.syntactic



import com.typesafe.scalalogging.Logger
import compiler.ast._
import compiler.syntactic.generated.{ShexlBaseVisitor, ShexlLexer, ShexlParser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.collection.JavaConverters._

class ShExLSyntacticParser(filename: String) extends ShexlBaseVisitor[ASTNode] {

  // Default logger
  final val logger = Logger[ShExLSyntacticParser]

  final val FILENAME = this.filename

  def parse(): Schema = {
    logger.debug(s"Parsing new file: $filename")
    val input = CharStreams.fromFileName(FILENAME)
    val lexer = new ShexlLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new ShexlParser(tokens)
    parser.schema().accept(this).asInstanceOf[Schema]
  }

  override def visitSchema(ctx: ShexlParser.SchemaContext): Schema = {
    logger.debug(s"Visiting an schema: $ctx")
    val statements = ctx.statement().asScala.toList.map(st => st.accept(this)).asInstanceOf[List[Statement]]
    new Schema(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, statements)
  }


  override def visitImport_statement(ctx: ShexlParser.Import_statementContext): ImportStatement = {
    logger.debug(s"Visiting an import: $ctx")
    val iri = new IRILiteral(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, ctx.IRI().getText)
    new ImportStatement(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, iri)
  }

  override def visitStart_definition(ctx: ShexlParser.Start_definitionContext): StartDeclaration = {
    logger.debug(s"Visiting a start def: $ctx")
    val shapeRef = visitShape_invocation(ctx.shape_invocation())
    new StartDeclaration(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, shapeRef)
  }

  override def visitShape_invocation(ctx: ShexlParser.Shape_invocationContext): ShapeInvocation = {
    logger.debug(s"Visiting a shape inv: $ctx")
    visitShape_name(ctx.shape_name())
  }

  override def visitBase_definition(ctx: ShexlParser.Base_definitionContext): BaseDeclaration = {
    logger.debug(s"Visiting a base def: $ctx")
    val iri = new IRILiteral(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, ctx.IRI.getText)
    new BaseDeclaration(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, iri)
  }

  override def visitPrefix_definition(ctx: ShexlParser.Prefix_definitionContext): PrefixDeclaration = {
    logger.debug(s"Visiting a prefix def: $ctx")
    val shapeLabel = if (ctx.LABEL == null) "" else ctx.LABEL.getText
    val iri = new IRILiteral(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, ctx.IRI.getText)
    new PrefixDeclaration(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, shapeLabel, iri)
  }

  override def visitShape_definition(ctx: ShexlParser.Shape_definitionContext): ShapeDeclaration = {
    logger.debug(s"Visiting a shape def: $ctx")
    val shapeName = visitShape_name(ctx.shape_name()).content
    val prefixInvocation = new PrefixInvocation(FILENAME, ctx.shape_name().start.getLine, ctx.shape_name().start.getCharPositionInLine, shapeName)
    val constraint = ctx.constraint().accept(this).asInstanceOf[Constraint]
    new ShapeDeclaration(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, prefixInvocation, constraint)
  }

  override def visitShape_name(ctx: ShexlParser.Shape_nameContext): ShapeInvocation = {
    logger.debug(s"Visiting a shape name: $ctx")
    if (ctx.ID() != null) {
      new ShapeInvocation(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, ctx.ID().getText)
    } else {
      new ShapeInvocation(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, ctx.IRI().getText)
    }
  }

  override def visitConstraint(ctx: ShexlParser.ConstraintContext): Constraint = {
    logger.debug(s"Visiting a constraint: $ctx")
    if (ctx.node_constraint() != null) {
      ctx.node_constraint().accept(this).asInstanceOf[NodeConstraint]
    } else if (ctx.constraint() != null) {
      ctx.constraint().accept(this).asInstanceOf[Constraint]
    } else /*if(ctx.triple_constraint() != null)*/ {
      val constraints = ctx.triple_constraint().asScala.toList.map(cons => cons.accept(this)).asInstanceOf[List[TripleConstraint]]
      new TripleExpressionConstraint(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, constraints)
    }
  }

  override def visitTriple_constraint(ctx: ShexlParser.Triple_constraintContext): ASTNode = {
    logger.debug(s"Visiting a triple constraint: $ctx")
    val property = new PrefixInvocation(FILENAME, ctx.ID.getSymbol.getLine, ctx.ID.getSymbol.getCharPositionInLine, ctx.ID.getText)
    val constraint = ctx.node_constraint().accept(this).asInstanceOf[NodeConstraint]
    var cardinality = new Cardinality(FILENAME, ctx.node_constraint().start.getLine, ctx.node_constraint().start.getCharPositionInLine, 1, 1)
    if (ctx.cardinality() != null) {
      cardinality = ctx.cardinality().accept(this).asInstanceOf[Cardinality]
    }
    new TripleConstraint(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, property, constraint, cardinality)
  }

  override def visitNode_constraint(ctx: ShexlParser.Node_constraintContext): NodeConstraint = {
    logger.debug(s"Visiting a node constraint: $ctx")

    if (ctx.ID() != null) {
      new PrefixInvocation(FILENAME, ctx.ID().getSymbol.getLine, ctx.ID.getSymbol.getCharPositionInLine, ctx.ID().getText)
    } else if (ctx.shape_invocation() != null) {
      //new ShapeInvocation(FILENAME, ctx.ID().getSymbol.getLine, ctx.ID.getSymbol.getCharPositionInLine, ctx.shape_invocation().getText)
      ctx.shape_invocation().accept(this).asInstanceOf[ShapeInvocation]
    } else if (!ctx.value_set_type().isEmpty) {
      val values = ctx.value_set_type().asScala.toList.map(v => v.accept(this)).asInstanceOf[List[ValidValueSetConstraint]]
      new ValueSetConstraint(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, values)
    } else {
      ctx.getText match {
        case "." => new AnyTypeNodeConstraint(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine)
        case "LITERAL" => new LiteralNodeConstraint(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine)
        case "IRI" => new IRINodeConstraint(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine)
        case "BNODE" => new BNodeNodeConstraint(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine)
        case "NONLITERAL" => new NonLiteralNodeConstraint(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine)
      }
    }
  }

  override def visitCardinality(ctx: ShexlParser.CardinalityContext): Cardinality = {
    logger.debug(s"Visiting a cardinality: $ctx")
    if (ctx.min == null) {
      ctx.getText match {
        case "*" => new Cardinality(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, 0, Int.MaxValue)
        case "+" => new Cardinality(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, 1, Int.MaxValue)
        case "?" => new Cardinality(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, 0, 1)
      }
    } else {
      if (ctx.max != null) {
        new Cardinality(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, Integer.parseInt(ctx.min.getText), Integer.parseInt(ctx.max.getText))
      } else {
        if (ctx.getText.contains(",")) {
          new Cardinality(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, Integer.parseInt(ctx.min.getText), Int.MaxValue)
        } else {
          new Cardinality(FILENAME, ctx.start.getLine, ctx.start.getCharPositionInLine, Integer.parseInt(ctx.min.getText), Integer.parseInt(ctx.min.getText))
        }
      }
    }
  }
}
