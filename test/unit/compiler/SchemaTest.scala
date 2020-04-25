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
import es.weso.shexlc.ast.visitor.PrettyPrintASTVisitor
import es.weso.shexl.DefaultShExLCompiler
import org.scalatest.funsuite.AnyFunSuite

class SchemaTest extends AnyFunSuite {

  test("individual file compilation") {

    val compileResult =
      new DefaultShExLCompiler()
        .addFile("test/assets/incorrect_schema_big_schema_2.shexl")
        .compile()(0)

    compileResult.getResult match {
      case Left(error) => println(error)
      case Right(schema) => {
        assert(!compileResult.hasErrors)
        assert(false)// Error introduced to trigger weso-bot on pr.
        println(schema.accept(new PrettyPrintASTVisitor(), new StringBuilder()))
      }
    }
  }

}
