package es.weso.shexl

import es.weso.shexl.ast.{Error, ShExL}
import es.weso.shexl.error.ErrorHandler
import es.weso.shexl.parser.generated.{ShExLLexer, ShExLParser}
import es.weso.shexl.visitor.{DefinitionsVisitor, InvocationsVisitor}
import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}

object ShExLite {

  def fromString(shapesDefinition: String): Either[List[Error], ShExL] = {
    val input = CharStreams.fromString(shapesDefinition)
    parse(input)
  }

  def fromFile(filePath: String): Either[List[Error], ShExL] = {
    val input = CharStreams.fromFileName(filePath)
    parse(input)
  }

  private[this] def parse(input: CharStream):  Either[List[Error], ShExL] = {
    val lexer = new ShExLLexer( input )

    val tokens = new CommonTokenStream( lexer )
    val parser = new ShExLParser( tokens )
    val ast = parser.shex_lite_doc().ast

    val defVisit = new DefinitionsVisitor
    defVisit.visit(ast, null)

    val invVisit = new InvocationsVisitor
    invVisit.visit(ast, null)

    if(ErrorHandler.hasErrors)
      Left(ErrorHandler.errors.result())
    else
      Right(ast)
  }
}
