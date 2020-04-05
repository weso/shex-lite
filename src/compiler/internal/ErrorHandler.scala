/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

package compiler.internal

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
