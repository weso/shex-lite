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

import es.weso.shexl.ShExLCompilerTargetLanguage
import es.weso.shexl.impl.{ShExLCompilerConfig, ShExLCompilerImpl}
import org.scalatest.funsuite.AnyFunSuite

class SchemaTest extends AnyFunSuite {

  test("individual file compilation") {

    val compiler = new ShExLCompilerImpl().setConfiguration(new ShExLCompilerConfig {
      override def generateWarnings: Boolean = false
      override def generateCode: Boolean = false
    })

    var compileResult =
      compiler
        .addSource("test/assets/correct_schema_big_schema_2.shexl")
        .compile.getCompilationResult

    assert(!compileResult.hasErrors)

    compileResult =
      compiler
        .addSource("test/assets/incorrect_schema_big_schema_2.shexl")
        .compile.getCompilationResult

    assert(compileResult.hasErrors)

    if(compileResult.hasErrors) {
      //compileResult.getIndividualResults.foreach(result => result.getErrors.foreach(err => println(err.getMessage)))
    } else {
      assert(!compileResult.hasErrors)
      //compileResult.getIndividualResults.foreach(result => result.getGeneratedSchema.head.accept(new PrettyPrintASTVisitor(), new StringBuilder()))
    }

    //compileResult.getIndividualResults.foreach(result => result.getGeneratedSources.get(ShExLCompilerTargetLanguage.Java).get.foreach(source => println(source.getSource)))
  }

}
