package es.weso.shexl.ast

import java.util

import es.weso.shexl.codegeneration.{JavaCodeGenVisitor, JavaCodeGenerator}
import es.weso.shexl.error.ErrorHandler
import es.weso.shexl.parser.generated.{ShExLLexer, ShExLParser}
import es.weso.shexl.visitor.{DefinitionsVisitor, InvocationsVisitor}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object ASTBasicTest {

  def main(args: Array[String]): Unit = {

    ShExL(0,0,
      util.Arrays.asList(
        PrefixDef(0,0,"xsd", URL(0,0,"http://scheema.org/xsd/>")),
        PrefixDef(0,0,"foaf", URL(0,0,"http://scheema.org/foaf/>")),
        ShapeDef(0,0,"Person",
          util.Arrays.asList(
            Constraint(0,0,FieldConstraint(0,0,PrefixInv(0,0,"foaf", "name")), TypeConstraint(0,0,PrefixInv(0,0,"xsd", "string"))),
            Constraint(0,0,FieldConstraint(0,0,PrefixInv(0,0,"xsd", "knows")), TypeConstraint(0,0,ShapeInv(0,0,"Person")))
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
