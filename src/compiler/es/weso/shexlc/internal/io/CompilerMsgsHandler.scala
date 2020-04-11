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

package es.weso.shexlc.internal.io

trait CompilerMsgsHandler {

  /**
   * Gets whether the compiler messages handler has errors or not.
   *
   * @return true if the handler contains any message that is an error. False otherwise.
   */
  def hasErrorMsgs: Boolean

  /**
   * Gets whether the compiler messages handler has warnings or not.
   *
   * @return true if the handler contains any message that is an warning. False otherwise.
   */
  def hasWarningMsgs: Boolean

  /**
   *
   * @param msg
   */
  def addMsg(msg: CompilerMsg)

  /**
   *
   * @return
   */
  def getErrorMsgs: List[CompilerMsg]

  /**
   *
   * @return
   */
  def getWarningMsgs: List[CompilerMsg]

  /**
   *
   */
  def showErrorMsgs: Unit

  /**
   *
   */
  def showWarningMsgs: Unit
}
