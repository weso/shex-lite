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
package es.weso.shexlite.compiler.symboltable

import java.util.Objects

import es.weso.shexlite.compiler.ast.{PrefixDefNode, ShapeDefNode, ShapeInvNode}

import scala.collection.mutable.HashMap

/**
 * Table to store different symbols of the parsed expressions, that is shapes definitions and prefixes.
 */
object SymbolTable {

  final val prefixes = HashMap[String, PrefixDefNode]()
  final val shapes = HashMap[String, ShapeDefNode]()

  /**
   * Inserts a prefix in the table.
   *
   * @param prefixDef is the prefix definition to insert in the table.
   * @return
   */
  def insert(prefixDef: PrefixDefNode) = {
    if(Objects.nonNull(prefixDef)) {
      this.prefixes += (prefixDef.name -> prefixDef)
    }
  }

  /**
   *
   * @param shapeDef
   * @return
   */
  def insert(shapeDef: ShapeDefNode)  = {
    if(Objects.nonNull(shapeDef)) {
      this.shapes += (shapeDef.name -> shapeDef)
    }
  }

  /**
   *
   * @param prefixName
   * @return
   */
  def getPrefix(prefixName: String): Option[PrefixDefNode] = {
    this.prefixes.get(prefixName)
  }

  /**
   *
   * @param shapeName
   * @return
   */
  def getShape(shapeName: String): Option[ShapeDefNode] = {
    this.shapes.get(shapeName)
  }
}
