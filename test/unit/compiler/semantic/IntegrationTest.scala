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

import com.typesafe.scalalogging.Logger
import compiler.internal.error.MemoryErrorHandler
import compiler.internal.symboltable.SymbolHashTable
import compiler.internal.symboltable.policy.PassiveAggressiveSymbolTablePolicy
import compiler.semantic.{DefinitionsCheckerWalker, DefinitionsCheckerWalterTest, InvocationsCheckerWalker}
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class IntegrationTest extends AnyFunSuite with BeforeAndAfter {

  final val logger = Logger[DefinitionsCheckerWalterTest]

  final val st = new SymbolHashTable(PassiveAggressiveSymbolTablePolicy)

  // In order to be sure that on each test case we do not have data from previous tests.
  before {
    logger.debug("Restoring memory symbol table.")
    st.restore()

    logger.debug("Restoring memory error handler.")
    MemoryErrorHandler.restore()
  }

  after {
    logger.debug("Restoring memory symbol table.")
    st.restore()

    logger.debug("Restoring memory error handler.")
    MemoryErrorHandler.restore()
  }

  generateTestCases()

  private[this] def generateTestCases():Unit = {
    val correctFiles = getListOfFiles("test/assets", "correct_schema")
    val incorrectFiles = getListOfFiles("test/assets", "incorrect_schema")

    for(file <- correctFiles) {
      test(s"Compiling file $file should pass without errors") {
        //st.restore()
        //MemoryErrorHandler.restore()

        // Parsing a sample file that contains a base redefinition.
        val ast = new ShExLSyntacticParser(file).parse()
        assert(!MemoryErrorHandler.hasErrors)

        // Then we walk the AST and here the error should be generated.
        ast.walk(new DefinitionsCheckerWalker(st), null)
        ast.walk(new InvocationsCheckerWalker(st), null)

        // Check that the error have been generated.
        MemoryErrorHandler.showErrors()
        assert(!MemoryErrorHandler.hasErrors)

        //st.restore()
        //MemoryErrorHandler.restore()
      }
    }

    for(file <- incorrectFiles) {
      test(s"Compiling file $file should generate errors") {
        //st.restore()
        //MemoryErrorHandler.restore()

        // Parsing a sample file that contains a base redefinition.
        val ast = new ShExLSyntacticParser(file).parse()
        assert(!MemoryErrorHandler.hasErrors)

        // Then we walk the AST and here the error should be generated.
        ast.walk(new DefinitionsCheckerWalker(st), null)
        ast.walk(new InvocationsCheckerWalker(st), null)

        // Check that the error have been generated.
        MemoryErrorHandler.showErrors()
        assert(MemoryErrorHandler.hasErrors)

        //st.restore()
        //MemoryErrorHandler.restore()
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
