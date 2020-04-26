package es.weso.shexlc.test.benchmark

import es.weso.shexl.{DefaultShExLCompiler, ShExLCompilerConfig}
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class PerformanceTests extends AnyFunSuite with BeforeAndAfter {

  private[this] val iterations = 10000
  private[this] var compiler = new DefaultShExLCompiler()
  private[this] val correct_file = "test/assets/correct_schema_big_schema_2.shexl"
  private[this] val config_1 = new ShExLCompilerConfig {
    override def generateWarnings: Boolean = true
    //override def getTargetGenerationLanguage: String = targetLanguage
    override def generateCode: Boolean = false
  }

  var i = 0
  var startTime = System.nanoTime()
  var time = System.nanoTime()
  var meanTime = 0L;
  while (i < iterations) {
    test(s"Compiling correct file at $i time should end in less thant 1000000000ns.") {
      compiler = new DefaultShExLCompiler()
      compiler.setConfiguration(config_1)
      compiler.addFile(correct_file)

      startTime = System.nanoTime()
      compiler.compile()
      time = System.nanoTime() - startTime
      assert(time < 1000000000)
    }

    i = i + 1
  }
}
