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

import ast.{Position, Schema}
import ast.visitor.PrettyPrintASTVisitor
import es.weso.shexl.ShExLCompiler
import internal.io.impl.{CompilerMsgErrorType, DefaultCompilerMsg}
import org.antlr.v4.runtime.misc.Interval
import syntactic.ShExLiteASTBuilderVisitor
import syntactic.generated.{Shexl2Lexer, Shexl2Parser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.scalatest.funsuite.AnyFunSuite

class SchemaTest extends AnyFunSuite {

  test("sdfg") {

    val compileResult = ShExLCompiler.parseFile("test/assets/correct_big_schema_2.shexl")

    //println(s"Errors: ${compileResult.hasErrors}")
    //println(s"Warnings: ${compileResult.hasWarnings}")
    //println(compileResult.getSchema)

    compileResult.getSchema match {
      case Left(error) => //println(error)
      case Right(schema) => {
        println(schema.accept(new PrettyPrintASTVisitor(), new StringBuilder()))
      }
    }
  }















  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  def oldCode = {
    //println(SchemaBuilder.fromFile("test/assets/correct_big_schema_2.shexl"))
    val input = CharStreams.fromFileName("test/assets/correct_big_schema_2.shexl")
    val lexer = new Shexl2Lexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new Shexl2Parser(tokens)

    val ast = time { parser.schema().accept(new ShExLiteASTBuilderVisitor()) }

    val sb = new StringBuilder()
    ast.asInstanceOf[Schema].accept(new PrettyPrintASTVisitor(), sb)

    val errMsg = new DefaultCompilerMsg(new Position(2,20), new Interval(0, 40), "Prefix lalala is overriding prefix lalale", CompilerMsgErrorType.PrefixOverride)

    println(errMsg.toPrintableString(input))

    //println(sb.toString())
  }


}
