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

package es.weso.shexlite.compiler.ast

import es.weso.shexlite.compiler.visitor.ShExLVisitor

class TypeNode(line: Int, column: Int) extends ASTNode(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}

object IntNode extends TypeNode(-1, -1)
object StringNode extends TypeNode(-1, -1)
object LongNode extends TypeNode(-1, -1)
object DoubleNode extends TypeNode(-1, -1)


case class ErrorNode(line: Int, column: Int, message: String) extends TypeNode(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}