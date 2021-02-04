package es.weso.shexlc

import es.weso.shexlc.IRGen.schemagen.IRSchemaGen
import es.weso.shexlc.IRGen.{IR, TargetIR}
import es.weso.shexlc.internal.{CompilationConfig, CompilationContext}
import es.weso.shexlc.parse.{AbstractSyntaxTree, Parser}
import es.weso.shexlc.sema.SIL
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class SchemaGenerationTest extends AnyFunSuite with BeforeAndAfter {

  val shexl = s"""prefix : <http://www.google.es>
                 |prefix xsd: <http://www.schema.org/>
                 |:User {
                 |  :name  xsd:string  ;
                 |  :surname . *;
                 |}
                 |:Person {
                 |  :dni xsd:integer ;
                 |  :knows @:Person ;
                 |}
                 |""".stripMargin

  val cconfig = new CompilationConfig {
    override def generateIR: Boolean       = true
    override def getTIR: Set[TargetIR]     = List(TargetIR.Java).toSet
    override def generateWarnings: Boolean = true
  }

  var ccontext = CompilationContext.withConfig(cconfig)

  test("Print generated schema") {

    ccontext = CompilationContext.withConfig(cconfig)

    // 1. Parse the vile and get the syntax tree.
    val syntaxTree = Parser.parseText(shexl, ccontext)

    // 2. Get the AST.
    val ast = AbstractSyntaxTree.getAST(syntaxTree)

    // 3. Get SIL.
    val sil = SIL.getSIL(ast)

    // 4. Dispatch the IRGen. This step it is not mandatory as we are not
    // generating code...
    val ir = IRSchemaGen.getIR(sil)

    println(ir.getGeneratedSources(0)._1);

  }
}
