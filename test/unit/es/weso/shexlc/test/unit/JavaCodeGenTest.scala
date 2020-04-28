package es.weso.shexlc.test.unit

import java.io.File

import es.weso.shexl.ShExLCompilerTargetLanguage
import es.weso.shexl.impl.{ShExLCompilerConfig, ShExLCompilerImpl}
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class JavaCodeGenTest extends AnyFunSuite with BeforeAndAfter {

  var compiler = new ShExLCompilerImpl()
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
        val compilationResult = compiler.addSource(file).compile.getCompilationResult
        compilationResult.getIndividualResults.last.printErrors
        compilationResult.getIndividualResults.last.printWarnings

        val sources = compilationResult.getIndividualResults.toList(0).getGeneratedSources.get(ShExLCompilerTargetLanguage.Java).get.toList
        sources.foreach(source => println(source.getSource))

        assert(!compilationResult.hasErrors)
      }
    }

    for(file <- incorrectFiles) {
      test(s"Compiling file and generating code for file $file should pass without errors") {
        // Parsing a sample file that contains a base redefinition.
        val compilationResult = compiler.addSource(file).compile.getCompilationResult
        compilationResult.getIndividualResults.last.printErrors
        compilationResult.getIndividualResults.last.printWarnings
        println(compilationResult.getIndividualResults
          .foreach(res => res.getGeneratedSources.size))
        assert(compilationResult.hasErrors)
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
