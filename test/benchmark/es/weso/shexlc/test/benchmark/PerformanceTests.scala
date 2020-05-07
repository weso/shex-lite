//------------------------------------------------------------------------------
// File: PerformanceTests.scala
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

package es.weso.shexlc.test.benchmark

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class PerformanceTests extends AnyFunSuite with BeforeAndAfter {

  private[this] val iterations = 10000
  private[this] val correct_file =
    "test/assets/correct_schema_big_schema_2.shexl"
  private[this] val config_1 = new ShExLCompilerConfig {
    override def generateWarnings: Boolean = true
    //override def getTargetGenerationLanguage: String = targetLanguage
    override def generateCode: Boolean = false
  }
  var i                      = 0
  var startTime              = System.nanoTime()
  var time                   = System.nanoTime()
  var meanTime               = 0L;
  private[this] var compiler = new ShExLCompilerImpl()
  while (i < iterations) {
    test(
      s"Compiling correct file at $i time should end in less thant 1000000000ns."
    ) {
      compiler = new ShExLCompilerImpl()
      compiler.setConfiguration(config_1)
      compiler.addSource(correct_file)

      startTime = System.nanoTime()
      compiler.compile
      time = System.nanoTime() - startTime
      assert(time < 1000000000)
    }

    i = i + 1
  }
}
