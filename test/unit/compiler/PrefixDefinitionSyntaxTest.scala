package compiler

import compiler.ast.{ASTNode, Schema}
import compiler.syntactic.ParseVisitor
import compiler.syntactic.generated.{ShexlLexer, ShexlParser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.scalatest.funsuite.AnyFunSuite

class PrefixDefinitionSyntaxTest extends AnyFunSuite {


  test("A prefix with a bad iri is not accepted") {
    assert(getNumberOfSyntaxErrorFromFile("test/assets/incorrect_prefix_definition_1.shexl") > 0)
    assert(getNumberOfSyntaxErrorFromFile("test/assets/incorrect_prefix_definition_2.shexl") > 0)
    assert(getNumberOfSyntaxErrorFromFile("test/assets/incorrect_prefix_definition_3.shexl") > 0)
  }

  test("A good formed prefix is accepted") {
    assert(getNumberOfSyntaxErrorFromFile("test/assets/correct_prefix_definition_1.shexl") == 0)
  }

  def getNumberOfSyntaxErrorFromFile(file: String): Int = {
    val input = CharStreams.fromFileName(file)
    val lexer = new ShexlLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new ShexlParser(tokens)
    parser.schema
    parser.getNumberOfSyntaxErrors
  }
}
