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

import compiler.ast.Schema
import compiler.syntactic.ShExLiteASTBuilderVisitor
import compiler.syntactic.generated.{Shexl2Lexer, Shexl2Parser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.scalatest.funsuite.AnyFunSuite

class SchemaTest extends AnyFunSuite {

  test("sdfg") {
    //println(SchemaBuilder.fromFile("test/assets/correct_big_schema_2.shexl"))
    val input = CharStreams.fromFileName("test/assets/correct_big_schema_2.shexl")
    val lexer = new Shexl2Lexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new Shexl2Parser(tokens)

    val ast = parser.schema().accept(new ShExLiteASTBuilderVisitor())

    println(ast)
    ast.asInstanceOf[Schema].stmts.foreach(stmt => println(s"\t$stmt"))

  }

}
