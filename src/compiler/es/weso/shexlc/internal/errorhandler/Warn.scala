//------------------------------------------------------------------------------
// File: Warn.scala
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

import es.weso.shexlc.parse.ast.{NodeWithPosition, Position}

/**
  * Represents a warning event that occurred during the compilation process. A warning contains the position in the
  * source where it was raised, the message/cause and the type of warnings.
  *
  * @author Guillermo Facundo Colunga
  *
  * @param node where the warning was generated
  * @param message indicating the description of the cause of the warning
  * @param ttype of the warning indicating why the error occurred
  */
case class Warn(
  node: NodeWithPosition,
  message: String,
  ttype: CompilerEventType
) extends CompilationEvent {

  /**
    * Gets whether an event is a warning or not.
    *
    * @return whether an event is a warning or not.
    */
  override def isWarning: Boolean = true

  /**
    * Gets the position in the source where the event occurred.
    *
    * @return the position in the source where the event occurred.
    */
  override def getEventPosition: Position = node.getPosition

  /**
    * Gets the context of the event. The context is the content of the parent node. So if for example we have int a = 'c'
    * as a is an integer and 'c' is a char we cannot assign its value an event will be raised, there the error will be
    * 'c' that is the node that raises the error as it should be an integer. And the context would be a = c that is the
    * parent node.
    *
    * @return the context of the event.
    */
  override def getEventContext: String = node.getContent

  /**
    * Gets the event type. The event type contains the error code and the description of the type of errors. An error
    * type can be for example -> BaseNotFoundError(code = E001, "base not found")
    *
    * @return the event type.
    */
  override def getEventType: CompilerEventType = ttype

  /**
    * Formats the event to a default printable string.
    *
    * @return the event as a printable string.
    */
  override def toPrintableString: String = {
    val sb = new StringBuilder()
    sb.append(
      s"${Console.YELLOW}error[${ttype.getCode}]: ${Console.RESET}${ttype.getDescription}"
    )
    sb.append("\n")
    sb.append(
      s"--> ${node.getPosition.filename}:${node.getPosition.line}:${node.getPosition.column}"
    )
    sb.append(s"\n\t${Console.CYAN}|${Console.RESET} ")
    sb.append(s"\n${Console.CYAN}${node.getPosition.line}\t|${Console.RESET} ")
    sb.append(s"${node.getContent}")
    sb.append(s"\n\t${Console.CYAN}|${Console.RESET} ")

    val spaces = node.getRange

    for (i <- 0 to spaces - 1) {
      sb.append(" ")
    }

    sb.append(s"^ $message")
    sb.append("\n")
    sb.toString()
  }
}

/**
  * The compiler warning object contains all the standardized pre-defined.
  */
object Warn {

  val PrefixNotUsed = new CompilerEventType {
    override def getCode: String        = "W001"
    override def getDescription: String = "prefix definition not used"
  }

  val BaseSetButNotUsed = new CompilerEventType {
    override def getCode: String        = "W002"
    override def getDescription: String = "base has been set but not used"
  }

  val FeatureIgnored = new CompilerEventType {
    override def getCode: String        = "W003"
    override def getDescription: String = "feature ignored"
  }

  val SchemaWithoutDirectMapping = new CompilerEventType {
    override def getCode: String = "W004"
    override def getDescription: String =
      "schema includes constraints without a direct mapping to target language"
  }

  val MissingSemicolon = new CompilerEventType {
    override def getCode: String        = "W005"
    override def getDescription: String = "missing semicolon"
  }
}
