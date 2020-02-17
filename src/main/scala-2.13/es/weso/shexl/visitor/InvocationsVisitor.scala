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

package es.weso.shexl.visitor

import es.weso.shexl.ast.{Error, PrefixInv, ShapeInv}
import es.weso.shexl.error.ErrorHandler
import es.weso.shexl.symboltable.SymbolTable

case class InvocationsVisitor() extends AbstractVisitor {

  override def visit(shapeInv: ShapeInv, param: Any): Unit = {
    val definition = SymbolTable.getShape(shapeInv.shapeName)
    if( definition.isEmpty ) {
      val shapeName = shapeInv.shapeName
      ErrorHandler.addError(Error(shapeInv.line, shapeInv.column, s"Shape [$shapeName] not defined."))
    } else {
      shapeInv.definition = definition.get
    }
  }

  override def visit(prefixInv: PrefixInv, param: Any): Unit = {
    val definition = SymbolTable.getPrefix(prefixInv.prefixName)
    if( definition.isEmpty ) {
      val prefixName = prefixInv.prefixName
      ErrorHandler.addError(Error(prefixInv.line, prefixInv.column, s"Prefix [$prefixName] not defined."))
    } else {
      prefixInv.definition = definition.get
    }
  }

}
