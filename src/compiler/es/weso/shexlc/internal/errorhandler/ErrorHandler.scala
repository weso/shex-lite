//--------------------------------------------------------------------------------------------------
// File: ErrorHandler.scala
//
// Short version for non-lawyers:
//
// The ShEx Lite Project is dual-licensed under GNU 3.0 and
// MIT terms.
//
// Longer version:
//
// Copyrights in the ShEx Lite project are retained by their contributors. No
// copyright assignment is required to contribute to the ShEx Lite project.
//
// Some files include explicit copyright notices and/or license notices.
// For full authorship information, see the version control history.
//
// Except as otherwise noted (below and/or in individual files), ShEx Lite is
// licensed under the GNU, Version 3.0 <LICENSE-GNU> or
// <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
// <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
// In case of incompatibility between project licenses, GNU/GPLv3 will be
// applied.
//
// The ShEx Lite Project includes packages written by third parties.
//--------------------------------------------------------------------------------------------------

package es.weso.shexlc.internal.errorhandler

import scala.collection.mutable.ListBuffer

/**
 * The error handler trait is the common trait for any implementation of error handlers that the compiler might
 * implement.
 *
 * @author Guillermo Facundo Colunga
 */
trait ErrorHandler {

  /**
   * Gets whether the compiler messages handler has errors or not.
   *
   * @return true if the handler contains any message that is an error. False otherwise.
   */
  def hasErrorMsgs: Boolean

  /**
   * Gets the list of errors that the event handler contains.
   *
   * @return the list of errors that the event handler contains.
   */
  def getErrors: List[Err]

  /**
   * Gets whether the compiler messages handler has warnings or not.
   *
   * @return true if the handler contains any message that is an warning. False otherwise.
   */
  def hasWarningMsgs: Boolean

  /**
   * Gets the list warnings that the event handler contains.
   *
   * @return the list warnings that the event handler contains.
   */
  def getWarnings: List[Warn]

  /**
   * Adds a single compiler event.
   *
   * @param event to add to the error handler.
   */
  def addEvent(event: CompilationEvent): Unit
}

object ErrorHandler {

  /**
   * Defines a new empty error handler.
   *
   * @return a new empty error handler.
   */
  def empty: ErrorHandler = new ErrorHandler {

    private[this] var events = new ListBuffer[CompilationEvent].empty
    private[this] var hasErrors = false;
    private[this] var hasWarnings = false;

    /**
     * Gets whether the compiler messages handler has errors or not.
     *
     * @return true if the handler contains any message that is an error. False otherwise.
     */
    override def hasErrorMsgs: Boolean = hasErrors

    /**
     * Gets the list of errors that the event handler contains.
     *
     * @return the list of errors that the event handler contains.
     */
    override def getErrors: List[Err] = events.filter(event => event.isError).asInstanceOf

    /**
     * Gets whether the compiler messages handler has warnings or not.
     *
     * @return true if the handler contains any message that is an warning. False otherwise.
     */
    override def hasWarningMsgs: Boolean = hasWarnings

    /**
     * Gets the list warnings that the event handler contains.
     *
     * @return the list warnings that the event handler contains.
     */
    override def getWarnings: List[Warn] = events.filter(event => event.isWarning).asInstanceOf

    /**
     * Adds a single compiler event.
     *
     * @param event to add to the error handler.
     */
    override def addEvent(event: CompilationEvent): Unit = {
      events += event
      if(event.isWarning) this.hasWarnings = true
      if(event.isError) this.hasErrors = true
    }
  }

}