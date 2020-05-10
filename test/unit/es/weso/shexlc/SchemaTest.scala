//------------------------------------------------------------------------------
// File: SchemaTest.scala
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
//------------------------------------------------------------------------------

package es.weso.shexlc

import es.weso.shexlc.parse.{AbstractSyntaxTree, Parser}
import es.weso.shexlc.IRGen.{IR, TargetIR}
import es.weso.shexlc.internal.{CompilationConfig, CompilationContext}
import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.visitor.ASTPrinter
import es.weso.shexlc.sema.SIL
import org.scalatest.funsuite.AnyFunSuite

class SchemaTest extends AnyFunSuite {

  val cconfig = new CompilationConfig {
    override def generateIR: Boolean       = true
    override def getTIR: Set[TargetIR]     = List(TargetIR.Java).toSet
    override def generateWarnings: Boolean = true
  }

  var ccontext = CompilationContext.withConfig(cconfig)

  test("positive individual file compilation") {
    val shexl =
      s"""prefix : <http://www.google.es>
         |prefix xsd: <http://www.schema.org/>
         |prefix xsd: <http://www.schema.org/>
         |base <http://thebase.com/>
         |start = @:User
         |:User {
         |  :name  xsds:string  ;
         |  :surname . ;
         |}
         |""".stripMargin

    ccontext = CompilationContext.withConfig(cconfig)

    // 1. Parse the vile and get the syntax tree.
    //val syntaxTree = Parser.parseText(shexl, ccontext)
    val syntaxTree = Parser.parseFile(
      "test/assets/incorrect_schema_big_schema_2.shexl",
      ccontext
    )

    println("--- SYNTAX TREE PARSED ---")

    // If any error during compilation print them.
    for (error <- ccontext.getErrorHandler.getErrors) {
      println(error.toPrintableString)
    }

    // If any warning print them.
    for (warning <- ccontext.getErrorHandler.getWarnings) {
      println(warning.toPrintableString)
    }

    // No errors should be generated
    assert(!ccontext.getErrorHandler.hasErrorMsgs)

    // 2. Get the AST.
    val ast = AbstractSyntaxTree.getAST(syntaxTree)

    println("--- ABSTRACT SYNTAX TREE PARSED ---")

    // If any error during compilation print them.
    for (error <- ccontext.getErrorHandler.getErrors) {
      println(error.toPrintableString)
    }

    // If any warning print them.
    for (warning <- ccontext.getErrorHandler.getWarnings) {
      println(warning.toPrintableString)
    }

    // No errors should be generated
    assert(!ccontext.getErrorHandler.hasErrorMsgs)

    // Print the AST.
    println(
      ast.getRoot
        .asInstanceOf[Schema]
        .accept(new ASTPrinter(), new StringBuilder())
    )

    // 3. Get SIL.
    val sil = SIL.getSIL(ast)

    println("--- SIL GENERATED ---")

    // If any error during compilation print them.
    for (error <- ccontext.getErrorHandler.getErrors) {
      println(error.toPrintableString)
    }

    // If any warning print them.
    for (warning <- ccontext.getErrorHandler.getWarnings) {
      println(warning.toPrintableString)
    }

    // Errors should be generated
    assert(ccontext.getErrorHandler.hasErrorMsgs)

    // 4. Dispatch the IRGen. This step it is not mandatory as we are not
    // generating code...
    val ir = IR.getIR(sil)

    println("--- IR GENERATED ---")

    // If any error during compilation print them.
    for (error <- ccontext.getErrorHandler.getErrors) {
      println(error.toPrintableString)
    }

    // No errors should be generated
    assert(ccontext.getErrorHandler.hasErrorMsgs)

    // If any warning print them.
    for (warning <- ccontext.getErrorHandler.getWarnings) {
      println(warning.toPrintableString)
    }

    // Check that no errors where generated.
    //assert(!ccontext.getErrorHandler.hasErrorMsgs)

    // Print the result
    //println(ir.getSources.get(TargetIR.Java).get(0)._2)
  }

}
