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

package es.weso.shexlite.compiler.error
import es.weso.shexlite.compiler.ast.ErrorNode

import scala.collection.mutable.ListBuffer

/**
 * Error handler system. This system helps to hold the errors found at compile time.
 */
object ErrorHandler {

  // List of errors.
  final val errors = new ListBuffer[ErrorNode]()

  /**
   * Returns whether the error handler has errors or not.
   *
   * @return true if has errors, false otherwise.
   */
  def hasErrors: Boolean = {
    !this.errors.isEmpty
  }

  /**
   * Adds errors to the error system.
   *
   * @param error to add to the system.
   * @return
   */
  def addError(error: ErrorNode) = {
    this.errors += error
  }

  /**
   * Shows the errors through the terminal.
   */
  def showErrors(): Unit = {
    for(error <- errors) {
      val line = error.line
      val column = error.column
      val message = error.message
      println( s"ERROR [$line, $column] -> $message")
    }
  }
}
