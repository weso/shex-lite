//------------------------------------------------------------------------------
// File: PythonCodeGenTest.scala
//
// Copyright 2020 Alejandro González Hevia
//
// Permission is hereby granted, free of charge, to any person obtaining a
// copy of this software and associated documentation files (the "Software"),
// to deal in the Software without restriction, including without limitation
// the rights to use, copy, modify, merge, publish, distribute, sublicense,
// and/or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
//------------------------------------------------------------------------------

package unit.es.weso.shexlc

import java.io.File

import es.weso.shexlc.IRGen.{IR, TargetIR}
import es.weso.shexlc.internal.{CompilationConfig, CompilationContext}
import es.weso.shexlc.parse.{AbstractSyntaxTree, Parser, SyntaxTree}
import es.weso.shexlc.sema.SIL
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.Source

class PythonCodeGenTest extends AnyFunSuite with BeforeAndAfter {

  val cconfig = new CompilationConfig {
    override def generateIR: Boolean       = true
    override def getTIR: Set[TargetIR]     = List(TargetIR.Python).toSet
    override def generateWarnings: Boolean = true
  }

  var ccontext = CompilationContext.withConfig(cconfig)

  generateTestCases()

  private[this] def generateTestCases(): Unit = {
    val correctData   = getListOfValidData("test/assets/python_gen")
    val incorrectFiles = getListOfInvalidFiles("test/assets/python_gen")

    for ((input, expected) <- correctData) {
      test(s"Compiling file and generating code for file $input should pass " + s"without errors") {
        val ir = executeIRGen(input, Parser.parseFile)
        assert(!ccontext.getErrorHandler.hasErrorMsgs)
        assert(getFileNameFrom(ir.getSources(TargetIR.Python).head._1).equals(getFileNameFrom(expected)))

        val expectedContent = Source.fromFile(new File(expected)).mkString.replaceAll("\r", "")
        assert(ir.getSources(TargetIR.Python).head._2.equals(expectedContent))
      }
    }

    for (file <- incorrectFiles) {
      test(s"Compiling file and generating code for file $file should pass with " + s"errors") {

        ccontext = CompilationContext.withConfig(cconfig)
        executeIRGen(file, Parser.parseFile)
        assert(ccontext.getErrorHandler.hasErrorMsgs)
      }
    }
  }

  private[this] def getFileNameFrom(path: String): String = {
    new File(path).getName
  }

  private[this] def getListOfInvalidFiles(baseDir: String): List[String] = {
    val dirs: List[File] = new File(baseDir).listFiles.filter(_.isDirectory).toList
    val filteredDirs = dirs.filter(_.getName.startsWith("incorrect"))
    filteredDirs.map(dir => extractFilePathFrom(dir, "input"))
  }

  private[this] def getListOfValidData(baseDir: String): List[(String, String)] = {
    val result = ListBuffer.empty[(String, String)]
    val dirs: List[File] = new File(baseDir).listFiles.filter(_.isDirectory).toList
    val filteredDirs = dirs.filter(_.getName.startsWith("correct"))
    for (testCaseDir <- filteredDirs) {
      val shexlInput: String = extractFilePathFrom(testCaseDir, "input")
      val expectedOutput: String = extractFilePathFrom(testCaseDir, "expected")
      result += Tuple2(shexlInput, expectedOutput)
    }
    result.toList
  }

  private[this] def executeIRGen(input: String, parsingCallback: (String, CompilationContext) => SyntaxTree): IR = {
    ccontext = CompilationContext.withConfig(cconfig)
    IR.getIR(SIL.getSIL(AbstractSyntaxTree.getAST(parsingCallback(input, ccontext))))
  }

  private[this] def extractFilePathFrom(testCaseDir: File, subdir: String): String = {
    testCaseDir.listFiles.toList.filter(_.getName.equals(subdir)).head.listFiles.toList.head.getPath
  }
}
