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

import compiler.ast.{Error, Warning}

/**
 * The error handler is the abstraction used to deal with errors and warnings during the compilation time.
 * Notice that this is just to wrapper that holds errors and warnings, it does not add any additional behaviour
 * to what to do if there are warnings / errors.
 */
private[compiler] trait ErrorHandler {

  /**
   * Returns whether the error handler has errors or not.
   *
   * @return true if has errors, false otherwise.
   */
  def hasErrors: Boolean

  /**
   * Returns whether the error handler has warnings or not.
   *
   * @return true if has errors, false otherwise.
   */
  def hasWarnings: Boolean

  /**
   * Adds errors to the error system.
   *
   * @param error to add to the system.
   */
  def addError(error: Error): Unit

  /**
   * Adds warnings to the error system.
   *
   * @param warning to add to the system.
   */
  def addWarning(warning: Warning): Unit

  /**
   * Shows the errors through the terminal.
   */
  def showErrors(): Unit

  /**
   * Shows the warnings through the terminal.
   */
  def showWarnings(): Unit
}
