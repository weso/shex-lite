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
 * An error represents a non-recoverable event at compilation time that does not allow next steps in the compilation.
 * Every error must be self descriptive and therefore will be accompanied by its source, that contains source file,
 * line, column and cause. And the error type, that represents what kind of error happened.
 */
private[compiler] trait Err {

  /**
   * The source of the event that generated the error. It contains the source file, line, column and description.
   */
  val source: ErrSource

  /**
   * The error type. Error types are standardised.
   */
  val errorType: ErrType
}
