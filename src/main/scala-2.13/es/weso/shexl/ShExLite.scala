/*
 * MIT License
 *
 * Copyright (c) 2020 WESO Research Group, University of Oviedo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package es.weso.shexl

import es.weso.shexl.ast.{Error, ShExL}
import es.weso.shexl.error.ErrorHandler
import es.weso.shexl.parser.generated.{ShExLLexer, ShExLParser}
import es.weso.shexl.visitor.{DefinitionsVisitor, InvocationsVisitor}
import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}

object ShExLite {

  def fromString(shapesDefinition: String): Either[List[Error], ShExL] = {
    val input = CharStreams.fromString(shapesDefinition)
    parse(input)
  }

  def fromFile(filePath: String): Either[List[Error], ShExL] = {
    val input = CharStreams.fromFileName(filePath)
    parse(input)
  }

  private[this] def parse(input: CharStream):  Either[List[Error], ShExL] = {
    val lexer = new ShExLLexer( input )

    val tokens = new CommonTokenStream( lexer )
    val parser = new ShExLParser( tokens )
    val ast = parser.shex_lite_doc().ast

    val defVisit = new DefinitionsVisitor
    defVisit.visit(ast, null)

    val invVisit = new InvocationsVisitor
    invVisit.visit(ast, null)

    if(ErrorHandler.hasErrors)
      Left(ErrorHandler.errors.result())
    else
      Right(ast)
  }
}
