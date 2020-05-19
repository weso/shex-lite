//------------------------------------------------------------------------------
// File: JavaCodeGenTest.scala
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

import java.io.File

import es.weso.shexlc.internal.{CompilationConfig, CompilationContext}
import es.weso.shexlc.IRGen.{IR, TargetIR}
import es.weso.shexlc.parse.{AbstractSyntaxTree, Parser}
import es.weso.shexlc.sema.SIL
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class JavaCodeGenTest extends AnyFunSuite with BeforeAndAfter {

  val cconfig = new CompilationConfig {
    override def generateIR: Boolean       = true
    override def getTIR: Set[TargetIR]     = List(TargetIR.Java).toSet
    override def generateWarnings: Boolean = true
  }

  var ccontext = CompilationContext.withConfig(cconfig)

  generateTestCases()

  private[this] def generateTestCases(): Unit = {
    val correctFiles   = getListOfFiles("test/assets", "input_correct")
    val incorrectFiles = getListOfFiles("test/assets", "input_incorrect")

    for (file <- correctFiles) {
      test(s"Compiling file and generating code for file $file should pass " + s"without errors") {

        ccontext = CompilationContext.withConfig(cconfig)

        // 1. Parse the vile and get the syntax tree.
        val syntaxTree = Parser.parseFile(file, ccontext)

        // 2. Get the AST.
        val ast = AbstractSyntaxTree.getAST(syntaxTree)

        // 3. Get SIL.
        val sil = SIL.getSIL(ast)

        // 4. Dispatch the IRGen. This step it is not mandatory as we are not
        // generating code...
        val ir = IR.getIR(sil)

        // If any error during compilation print them.
        //for (error <- ccontext.getErrorHandler.getErrors) {
        //  println(error.toPrintableString)
        //}

        // If any warning print them.
        //for (warning <- ccontext.getErrorHandler.getWarnings) {
        //  println(warning.toPrintableString)
        //}

        assert(!ccontext.getErrorHandler.hasErrorMsgs)

        ir.getSources.get(TargetIR.Java) match {
          case Some(element) => element.foreach(source => println(source._2))
          case _             =>
        }

        assert(!ccontext.getErrorHandler.hasErrorMsgs)
      }
    }

    for (file <- incorrectFiles) {
      test(s"Compiling file and generating code for file $file should pass with " + s"errors") {

        ccontext = CompilationContext.withConfig(cconfig)

        // 1. Parse the vile and get the syntax tree.
        val syntaxTree = Parser.parseFile(file, ccontext)

        // 2. Get the AST.
        val ast = AbstractSyntaxTree.getAST(syntaxTree)

        // 3. Get SIL.
        val sil = SIL.getSIL(ast)

        // 4. Dispatch the IRGen. This step it is not mandatory as we are not
        // generating code...
        val ir = IR.getIR(sil)

        // If any error during compilation print them.
        //for (error <- ccontext.getErrorHandler.getErrors) {
        //  println(error.toPrintableString)
        //}

        // If any warning print them.
        //for (warning <- ccontext.getErrorHandler.getWarnings) {
        //  println(warning.toPrintableString)
        //}

        assert(ccontext.getErrorHandler.hasErrorMsgs)

        ir.getSources.get(TargetIR.Java) match {
          case Some(element) => element.foreach(source => println(source._2))
          case _             =>
        }

        assert(ccontext.getErrorHandler.hasErrorMsgs)
      }
    }
  }

  test(
    "Compile a single file, generate code for it and test that the code is " + "well generated."
  ) {

    val shexl = s"""prefix : <http://www.google.es>
                   |prefix xsd: <http://www.schema.org/>
                   |:User {
                   |  :name  xsd:string  ;
                   |}
                   |""".stripMargin

    val result =
      "package generated;\npublic class User {\n\tprivate String name;" + "\n\n\tpublic " +
      "User(String name) {\n\t\tthis.name = name;\n\t}\n\n\tpublic String " +
      "getName() {\n\t\treturn this.name;\n\t}\n\n\tpublic void " +
      "setName(String name) {\n\t\tthis.name = name;\n\t}\n\n}\n"

    ccontext = CompilationContext.withConfig(cconfig)

    // 1. Parse the vile and get the syntax tree.
    val syntaxTree = Parser.parseText(shexl, ccontext)

    // 2. Get the AST.
    val ast = AbstractSyntaxTree.getAST(syntaxTree)

    // 3. Get SIL.
    val sil = SIL.getSIL(ast)

    // 4. Dispatch the IRGen. This step it is not mandatory as we are not
    // generating code...
    val ir = IR.getIR(sil)

    // If any error during compilation print them.
    //for (error <- ccontext.getErrorHandler.getErrors) {
    //  println(error.toPrintableString)
    //}

    // If any warning print them.
    //for (warning <- ccontext.getErrorHandler.getWarnings) {
    //  println(warning.toPrintableString)
    //}

    // Check that no errors where generated.
    assert(!ccontext.getErrorHandler.hasErrorMsgs)

    // Print the result
    println(ir.getSources.get(TargetIR.Java).get(0)._2)

    assert(ir.getSources.get(TargetIR.Java).get(0)._2.equals(result))
  }

  private[this] def getListOfFiles(dir: String, startsWith: String): List[String] = {
    val file = new File(dir)
    file.listFiles.filter(_.isFile).filter(_.getName.startsWith(startsWith)).map(_.getPath).toList
  }
}
