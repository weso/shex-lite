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

package es.weso.shexlite.visitor
import es.weso.shexlite.ast.{Constraint, Definition, FieldConstraint, Invocation, PrefixDef, PrefixInv, ShExL, ShapeDef, ShapeInv, Type, TypeConstraint, URL}

import scala.collection.JavaConverters

class AbstractVisitor extends ShExLVisitor {

  override def visit(node: ShExL, param: Any): Unit = {
    for(defi <- JavaConverters.asScalaIterator(node.definitions.iterator() )) {
      defi.accept(this, param)
    }
  }

  override def visit(node: PrefixDef, param: Any): Unit = {
    node.uri.accept(this, param)
  }

  override def visit(node: ShapeDef, param: Any): Unit = {
    for(constraint <- JavaConverters.asScalaIterator(node.constraints.iterator())) {
      constraint.accept(this, param)
    }
  }

  override def visit(node: Constraint, param: Any): Unit = {
    node.cType.accept(this, param)
    node.field.accept(this, param)
  }

  override def visit(node: FieldConstraint, param: Any): Unit = {
    node.prefixInv.accept(this, param)
  }

  override def visit(node: TypeConstraint, param: Any): Unit = {
    node.invocation.accept(this, param)
  }

  override def visit(node: PrefixInv, param: Any): Unit = {
    //node.definition.accept(this, param)
  }

  override def visit(node: ShapeInv, param: Any): Unit = {
    //node.definition.accept(this, param)
  }

  override def visit(node: URL, param: Any): Unit = {}

  override def visit(node: Type, param: Any): Unit = {
    node.accept(this, param)
  }
}
