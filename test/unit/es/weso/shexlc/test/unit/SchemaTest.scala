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

package es.weso.shexlc.test.unit

import es.weso.shexl.impl.{ShExLCompilerConfig, ShExLCompilerImpl}
import es.weso.shexlc.ast.visitor.PrettyPrintASTVisitor
import org.scalatest.funsuite.AnyFunSuite

class SchemaTest extends AnyFunSuite {

  test("individual file compilation") {

    val compileResult =
      new ShExLCompilerImpl()
        .addSource("test/assets/incorrect_schema_big_schema_2.shexl")
        .setConfiguration(new ShExLCompilerConfig {
          override def generateWarnings: Boolean = true
          //override def getTargetGenerationLanguage: String = targetLanguage
          override def generateCode: Boolean = false
        })
        .compile.getCompilationResult

    if(compileResult.hasErrors) {
      compileResult.getIndividualResults.foreach(result => result.getErrors.foreach(err => println(err)))
    } else {
      assert(!compileResult.hasErrors)
      compileResult.getIndividualResults.foreach(result => result.getGeneratedSchema.head.accept(new PrettyPrintASTVisitor(), new StringBuilder()))
    }
  }

}
