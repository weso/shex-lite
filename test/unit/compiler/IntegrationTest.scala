/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

package compiler

import java.io.File

import es.weso.shexl.DefaultShExLCompiler
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class IntegrationTest extends AnyFunSuite with BeforeAndAfter {

  var compiler = new DefaultShExLCompiler()

  generateTestCases()

  private[this] def generateTestCases():Unit = {
    val correctFiles = getListOfFiles("test/assets", "correct_schema")
    val incorrectFiles = getListOfFiles("test/assets", "incorrect_schema")

    // Individual file compiling
    for(file <- correctFiles) {
      test(s"Compiling file $file should pass without errors") {
        // Parsing a sample file that contains a base redefinition.
        val ast = compiler.addFile(file).compile()(0)
        assert(!ast.hasErrors)
        asset(false) // Error added to trigger weso-bot
      }
    }

    for(file <- incorrectFiles) {
      test(s"Compiling file $file should generate errors") {
        val ast = compiler.addFile(file).compile()(0)
        assert(ast.hasErrors)
      }
    }

    // Multiple file compiling
    test(s"Compiling multiple correct files at the same time should pass without errors") {
      for(file <- correctFiles) {
        compiler.addFile(file)
      }
      val results = compiler.compile()
      for(result <- results) {
        assert(!result.hasErrors)
      }
    }

    test(s"Compiling multiple incorrect files at the same time should pass with errors") {
      for(file <- incorrectFiles) {
        compiler.addFile(file)
      }
      val results = compiler.compile()
      for(result <- results) {
        assert(result.hasErrors)
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
