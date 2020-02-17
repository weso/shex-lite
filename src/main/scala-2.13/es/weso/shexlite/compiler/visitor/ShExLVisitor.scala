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

trait ShExLVisitor {

  def visit(node: ShExL, param: Any)

  def visit(node: PrefixDef, param: Any)

  def visit(node: ShapeDef, param: Any)

  def visit(node: Constraint, param: Any)

  def visit(node: FieldConstraint, param: Any)

  def visit(node: TypeConstraint, param: Any)

  def visit(node: PrefixInv, param: Any)

  def visit(node: ShapeInv, param: Any)

  def visit(node: URL, param: Any)

  def visit(node: Type, param: Any)
}
