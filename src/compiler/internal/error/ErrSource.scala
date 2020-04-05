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

package compiler.internal.error

/**
 * The error source describes the source event that trigger the error to be generates. That is the source file, the line
 * and the column where the error is generated. And the cause that generates the error as a plain string.
 */
trait ErrSource {

  /**
   * Source file where the error is being generated.
   */
  val sourceFile: String

  /**
   * Line where the error is being generated.
   */
  val line: Int

  /**
   * Column where the error is being generated.
   */
  val column: Int

  /**
   * Human friendly string containing the cause that trigger the error.
   */
  val cause: String
}
