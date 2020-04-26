package es.weso.shexlc.test.unit

import java.io.File

import es.weso.shexl.{DefaultShExLCompiler, ShExLCompilerConfig}
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class JavaCodeGenTest extends AnyFunSuite with BeforeAndAfter {

  var compiler = new DefaultShExLCompiler()
  var config = new ShExLCompilerConfig {
    override def generateWarnings: Boolean = true
    //override def getTargetGenerationLanguage: String = targetLanguage
    override def generateCode: Boolean = true
  }
  compiler.setConfiguration(config)

  generateTestCases()

  private[this] def generateTestCases(): Unit = {
    val correctFiles = getListOfFiles("test/assets", "input_correct")
    val incorrectFiles = getListOfFiles("test/assets", "input_incorrect")

    for(file <- correctFiles) {
      test(s"Compiling file and generating code for file $file should pass without errors") {
        // Parsing a sample file that contains a base redefinition.
        val ast = compiler.addFile(file).compile()(0)
        assert(!ast.hasErrors)
      }
    }

    for(file <- incorrectFiles) {
      test(s"Compiling file and generating code for file $file should pass without errors") {
        // Parsing a sample file that contains a base redefinition.
        val ast = compiler.addFile(file).compile()(0)
        assert(ast.hasErrors)
      }
    }
  }

  private[this] def getListOfFiles(dir: String, startsWith: String): List[String] = {
    val file = new File(dir)
    file.listFiles.filter(_.isFile)
      .filter(_.getName.startsWith(startsWith))
      .map(_.getPath).toList
  }
}
