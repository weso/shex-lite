package es.weso.shexlite.compiler.ast

import java.util

import es.weso.shexl.codegeneration.{JavaCodeGenVisitor, JavaCodeGenerator}
import es.weso.shexlite.compiler.error.ErrorHandler
import es.weso.shexl.parser.generated.ShExLParser
import es.weso.shexlite.parser.generated.{ShExLLexer, ShExLParser}
import es.weso.shexlite.compiler.visitor.{DefinitionsVisitor, InvocationsVisitor}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object ASTBasicTest {

  def main(args: Array[String]): Unit = {

    ShapeExpressionsFileNode(0,0,
      util.Arrays.asList(
        PrefixDefNode(0,0,"xsd", URLNode(0,0,"http://scheema.org/xsd/>")),
        PrefixDefNode(0,0,"foaf", URLNode(0,0,"http://scheema.org/foaf/>")),
        ShapeDefNode(0,0,"Person",
          util.Arrays.asList(
            TripleConstraintNode(0,0,FieldConstraintNode(0,0,PrefixInvNode(0,0,"foaf", "name")), TypeConstraintNode(0,0,PrefixInvNode(0,0,"xsd", "string"))),
            TripleConstraintNode(0,0,FieldConstraintNode(0,0,PrefixInvNode(0,0,"xsd", "knows")), TypeConstraintNode(0,0,ShapeInvNode(0,0,"Person")))
          )
        )
      )
    )

    val input = CharStreams.fromFileName( args(0) )
    val lexer = new ShExLLexer( input )

    val tokens = new CommonTokenStream( lexer )
    val parser = new ShExLParser( tokens )
    val ast = parser.shex_lite_doc().ast

    println(ast)

    val defVisit = new DefinitionsVisitor
    defVisit.visit(ast, null)

    val invVisit = new InvocationsVisitor
    invVisit.visit(ast, null)

    ErrorHandler.showErrors()

    val generator = new JavaCodeGenerator(args(0), args(1))
    new JavaCodeGenVisitor(generator).visit(ast, null)

  }

}
