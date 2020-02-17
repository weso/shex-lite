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

import es.weso.shexl.ast.{PrefixDef, PrefixInv, ShapeDef, ShapeInv, Error}
import es.weso.shexl.error.ErrorHandler
import es.weso.shexl.symboltable.SymbolTable

import scala.collection.JavaConverters

case class DefinitionsVisitor() extends AbstractVisitor {


  override def visit(shapeDef: ShapeDef, param: Any) = {
    if(SymbolTable.getShape(shapeDef.name).isDefined) {
      val shapeName = shapeDef.name
      ErrorHandler.addError(Error(shapeDef.line, shapeDef.column, s"Shape id [$shapeName] is duplicated."))
    } else {
      SymbolTable insert shapeDef
    }

    for(constraint <- JavaConverters.asScalaIterator(shapeDef.constraints.iterator())) {
      constraint accept (this, param)
    }
  }

  override def visit(prefixDef: PrefixDef, param: Any) = {
    prefixDef.name match {
      case null => {
        if(SymbolTable.getPrefix(" ").isDefined) {
          ErrorHandler.addError(Error(prefixDef.line, prefixDef.column, "Cannot be to default prefixes"))
        } else {
          SymbolTable insert PrefixDef(prefixDef.line, prefixDef.column, " ", prefixDef.uri)
        }
      }

      case _ => {
        if(SymbolTable.getPrefix(prefixDef.name).isDefined) {
          val prefixName = prefixDef.name
          ErrorHandler.addError(Error(prefixDef.line, prefixDef.column, s"Prefix id [$prefixName] is duplicated."))
        } else {
          SymbolTable insert prefixDef
        }
      }
    }

    prefixDef.uri.accept(this, param)
  }
}
