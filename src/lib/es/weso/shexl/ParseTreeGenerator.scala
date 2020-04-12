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

package es.weso.shexl

import es.weso.shexlc.syntactic.generated.{Shexl2Lexer, Shexl2Parser}
import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}

private[shexl] class ParseTreeGenerator(filepath: String) {

  var inputCharStream: CharStream = null

  def generateParseTree(): Shexl2Parser = {
    inputCharStream = CharStreams.fromFileName(filepath)
    val caseInsensitiveCharStream = new CaseChangingCharStream(inputCharStream, false)
    val lexer = new Shexl2Lexer(caseInsensitiveCharStream)
    val tokens = new CommonTokenStream(lexer)
    new Shexl2Parser(tokens)
  }
}
