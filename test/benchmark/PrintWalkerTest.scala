package benchmark
import compiler.syntactic.ParseVisitor
import compiler.syntactic.generated.{ShexlLexer, ShexlParser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.scalatest.flatspec.AnyFlatSpec

class PrintWalkerTest extends AnyFlatSpec {

  "A tree" should "look like" in {

    val testFileName = "test/test-assets/test_1.shexl"

    val input = CharStreams.fromFileName(testFileName)
    val lexer = new ShexlLexer( input )

    val tokens = new CommonTokenStream( lexer )
    val parser = new ShexlParser( tokens )

    val ast = new ParseVisitor().visitSchema(parser.schema())

    //println(ast)

  }

}
