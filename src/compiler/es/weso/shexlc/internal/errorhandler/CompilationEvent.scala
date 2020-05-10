//------------------------------------------------------------------------------
// File: CompilationEvent.scala
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
//------------------------------------------------------------------------------

package es.weso.shexlc.internal.errorhandler

import es.weso.shexlc.parse.ast.Position

/**
  * A build event is something that occurs during the course of the build that either prevents the build from continuing,
  * an error. Or it is relevant enough to be notified to the user.
  *
  * @author Guillermo Facundo Colunga
  */
trait CompilationEvent {

  /**
    * Gets the position in the source where the event occurred.
    *
    * @return the position in the source where the event occurred.
    */
  def getEventPosition: Position

  /**
    * Gets the context of the event. The context is the content of the parent node. So if for example we have int a = 'c'
    * as a is an integer and 'c' is a char we cannot assign its value an event will be raised, there the error will be
    * 'c' that is the node that raises the error as it should be an integer. And the context would be a = c that is the
    * parent node.
    *
    * @return the context of the event.
    */
  def getEventContext: String

  /**
    * Gets the event type. The event type contains the error code and the description of the type of errors. An error
    * type can be for example -> BaseNotFoundError(code = E001, "base not found")
    *
    * @return the event type.
    */
  def getEventType: CompilerEventType

  /**
    * Formats the event to a default printable string.
    *
    * @return the event as a printable string.
    */
  def toPrintableString: String

  // For avoiding casts. If more types of events are added add here its isXXX method.

  /**
    * Gets whether an event is an error or not.
    *
    * @return whether an event is an error or not.
    */
  def isError: Boolean = false

  /**
    * Gets whether an event is a warning or not.
    *
    * @return whether an event is a warning or not.
    */
  def isWarning: Boolean = false
}
