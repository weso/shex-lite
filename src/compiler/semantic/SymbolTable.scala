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
package compiler.semantic

import compiler.ast.{ASTNode, BaseDeclaration, PrefixDeclaration, ShapeDeclaration, StartDeclaration, Error, Warning}

/**
 * Table to store different symbols of the parsed expressions, that is shapes definitions and prefixes.
 *
 * Behaviour:
 * - Prefixes: When a prefix name is repeated its record its updated.
 * - Shapes: Shapes names must be unique, so definitions cannot be override.
 * - Base: Base prefix can be updated.
 * - Start: Start prefix can can be updated.
 */
private[compiler] trait SymbolTable {

  /**
    * Changes the base declaration to the one in the parameter.
    *
    * @param base to be set as the new base.
    * @return either a warning if the base was already set or the base declaration the first time.
    */
  def setBase(base: BaseDeclaration): Either[Warning, BaseDeclaration]

  /**
    * Gets the declaration attached to the base variable.
    *
    * @return the declaration attached to the base variable.
    */
  def getBase(): Option[BaseDeclaration]

  /**
    * Sets the start declarations to the given one. If the start was already set an error is thrown.
    *
    * @param start to set as the start declaration.
    * @return either the start declaration or an error.
    */
  def setStart(start: StartDeclaration): Either[Error, StartDeclaration]

  /**
    * Gets the start declaration.
    *
    * @return either the start declaration or an error if no start was declared.
    */
  def getStart(): Either[Error, StartDeclaration]

  /**
    * Inserts a prefix in the prefixes table, if it exists it will update its record and create a warning.
    *
    * @param prefixDef is the prefix definition to be inserted.
    * @return an either object, AST Node will be a warning/error, the prefix declaration is present if no errors happen.
    */
  def insert(prefixDef: PrefixDeclaration): Either[Warning, PrefixDeclaration]

  /**
    * Inserts a shape in the shapes table, if it exists it will create an error.
    *
    * @param shapeDef is the shape definition to be inserted.
    * @return an either object, AST Node will be a warning/error, the shape declaration is present if no errors happen.
    */
  def insert(shapeDef: ShapeDeclaration): Either[Error, ShapeDeclaration]

  /**
   * Gets the prefix definition indexed at the given prefix name.
   *
   * @param prefixName is the prefix name to look for in the table.
   * @return is a option object that might contain the prefix definition.
   */
  def getPrefix(prefixName: String): Either[Error, PrefixDeclaration]

  /**
   * Gets the shape definition indexed at the given shape name.
   *
   * @param shapeName is the prefix name to look for in the table.
   * @return is a option object that might contain the prefix definition.
   */
  def getShape(shapeName: String): Either[Error, ShapeDeclaration]
}
