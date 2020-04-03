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


import compiler.syntactic.generated.{ShexlLexer, ShexlParser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.scalatest.funsuite.AnyFunSuite

class PrefixDefinitionSyntaxTest extends AnyFunSuite {


  test("A prefix with a bad iri is not accepted") {
    assert(getNumberOfSyntaxErrorFromFile("test/assets/incorrect_prefix_definition_1.shexl") > 0)
    assert(getNumberOfSyntaxErrorFromFile("test/assets/incorrect_prefix_definition_2.shexl") > 0)
    assert(getNumberOfSyntaxErrorFromFile("test/assets/incorrect_prefix_definition_3.shexl") > 0)
  }

  test("A good formed prefix is accepted") {
    assert(getNumberOfSyntaxErrorFromFile("test/assets/correct_prefix_definition_1.shexl") == 0)
  }

  def getNumberOfSyntaxErrorFromFile(file: String): Int = {
    val input = CharStreams.fromFileName(file)
    val lexer = new ShexlLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new ShexlParser(tokens)
    parser.schema
    parser.getNumberOfSyntaxErrors
  }
}
