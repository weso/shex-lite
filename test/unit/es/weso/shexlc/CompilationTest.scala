//------------------------------------------------------------------------------
// File: CompilationTest.scala
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
import es.weso.shexlc.parse.{AbstractSyntaxTree, Parser}
import es.weso.shexlc.IRGen.IR
import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.visitor.ASTPrinter
import es.weso.shexlc.sema.SIL
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class CompilationTest extends AnyFunSuite with BeforeAndAfter {

  val cconfig = new CompilationConfig {
    override def generateIR: Boolean       = false
    override def generateWarnings: Boolean = true
  }

  var ccontext = CompilationContext.withConfig(cconfig)

  generateTestCases()

  private[this] def generateTestCases(): Unit = {
    val correctFiles   = getListOfFiles("test/assets", "correct_schema")
    val incorrectFiles = getListOfFiles("test/assets", "incorrect_schema")

    // Individual file compiling
    for (file <- correctFiles) {
      test(s"Compiling file $file should pass without errors") {

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
      }
    }

    for (file <- incorrectFiles) {
      test(s"Compiling file $file should generate errors") {

        ccontext = CompilationContext.withConfig(cconfig)

        // 1. Parse the vile and get the syntax tree.
        val syntaxTree = Parser.parseFile(file, ccontext)

        // 2. Get the AST.
        val ast = AbstractSyntaxTree.getAST(syntaxTree)

        // Print the AST.
        println(ast.getRoot.asInstanceOf[Schema].accept(new ASTPrinter(), new StringBuilder()))

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
      }
    }
  }

  private[this] def getListOfFiles(dir: String, startsWith: String): List[String] = {
    val file = new File(dir)
    file.listFiles.filter(_.isFile).filter(_.getName.startsWith(startsWith)).map(_.getPath).toList
  }
}
