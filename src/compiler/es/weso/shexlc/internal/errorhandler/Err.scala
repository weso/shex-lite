//------------------------------------------------------------------------------
// File: Err.scala
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

import es.weso.shexlc.parse.ast.{AbstractASTNode, Position, Schema}

/**
  * Represents an error event that occurred during the compilation process.
  * An error contains the position in the source
  * where it was raised, the message/cause and the type of error.
  *
  * @author Guillermo Facundo Colunga
  * @param node    where the error was generated
  * @param message indicating the description of the cause of the error
  * @param ttype   of the error indicating why the error occurred
  */
case class Err(node: AbstractASTNode, message: String, ttype: CompilerEventType)
    extends CompilationEvent {

  /**
    * Gets whether an event is an error or not.
    *
    * @return whether an event is an error or not.
    */
  override def isError: Boolean = true

  /**
    * Gets the position in the source where the event occurred.
    *
    * @return the position in the source where the event occurred.
    */
  override def getEventPosition: Position = node.getPosition

  /**
    * Gets the context of the event. The context is the content of the parent
    * node. So if for example we have int a = 'c'
    * as a is an integer and 'c' is a char we cannot assign its value an
    * event will be raised, there the error will be
    * 'c' that is the node that raises the error as it should be an integer.
    * And the context would be a = c that is the
    * parent node.
    *
    * @return the context of the event.
    */
  override def getEventContext: String = node.getContent

  /**
    * Gets the event type. The event type contains the error code and the
    * description of the type of errors. An error
    * type can be for example -> BaseNotFoundError(code = E001, "base not
    * found")
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

    val errTitle = s"${Console.RED}error[${ttype.getCode}]: ${Console.RESET}${ttype.getDescription}"

    val errPos =
      s"--> ${node.getPosition.filename}:${node.getPosition.line}:${node.getPosition.column}"

    var errContext = ""

    node.getParent match {
      case Some(parent) => {
        if (parent.isInstanceOf[Schema]) { errContext = node.getContent                                 }
        else                             { errContext = parent.asInstanceOf[AbstractASTNode].getContent }
      }
      case None => errContext = node.getContent
    }

    val sb = new StringBuilder()
    sb.append(errTitle)
    sb.append("\n")
    sb.append(errPos)
    sb.append(s"\n\t${Console.CYAN}|${Console.RESET} ")
    sb.append(s"\n${Console.CYAN}${node.getPosition.line}\t|${Console.RESET} ")
    sb.append(errContext)
    sb.append(s"\n\t${Console.CYAN}|${Console.RESET} ")

    var absolute = 0
    if (node.getParent.isDefined)
      absolute = node.getParent.get.asInstanceOf[AbstractASTNode].getRange.a

    var spaces = node.getRange.a - absolute

    node.getParent match {
      case Some(parent) => {
        if (parent.isInstanceOf[Schema]) { spaces = 0                          }
        else                             { spaces = node.getRange.a - absolute }
      }
      case None => spaces = 0
    }

    for (i <- 0 to (spaces - 1)) { sb.append(" ") }

    sb.append(s"^ $message")
    sb.append("\n")
    sb.toString()
  }
}

/**
  * The compiler error object contains all the standardized pre-defined.
  */
object Err {

  /**
    * Element Override Errors.
    */
  val BaseOverride = new CompilerEventType {
    override def getCode: String = "E001"

    override def getDescription: String = "attempt to override a base " + "directive value"
  }

  val StartOverride = new CompilerEventType {
    override def getCode: String = "E002"

    override def getDescription: String = "attempt to override an start " + "directive value"
  }

  val PrefixOverride = new CompilerEventType {
    override def getCode: String = "E003"

    override def getDescription: String = "attempt to override an already " + "defined prefix"
  }

  val ShapeOverride = new CompilerEventType {
    override def getCode: String = "E004"

    override def getDescription: String = "attempt to override an already " + "defined shape"
  }

  /**
    * Element Not Found Errors.
    */
  val BaseNotFound = new CompilerEventType {
    override def getCode: String = "E005"

    override def getDescription: String = "base not defined"
  }

  val StartNotFound = new CompilerEventType {
    override def getCode: String = "E006"

    override def getDescription: String = "start not defined"
  }

  val PrefixNotFound = new CompilerEventType {
    override def getCode: String = "E007"

    override def getDescription: String = "prefix not defined"
  }

  val ShapeNotFound = new CompilerEventType {
    override def getCode: String = "E008"

    override def getDescription: String = "shape not defined"
  }

  val NullReference = new CompilerEventType {
    override def getCode: String = "E009"

    override def getDescription: String = "null reference"
  }

  val NonValidAction = new CompilerEventType {
    override def getCode: String = "E010"

    override def getDescription: String = "non valid action"
  }

  /**
    * Compiler errors.
    */
  val CouldNotCreateSchemaForSource = new CompilerEventType {
    override def getCode: String = "E011"

    override def getDescription: String = "couldn't create schema for source " + "file"
  }

  val TypeCheckingError = new CompilerEventType {
    override def getCode: String = "E012"

    override def getDescription: String = "not valid type"
  }

  val CodeGeneratorError = new CompilerEventType {
    override def getCode: String = "E013"

    override def getDescription: String = "code generation error"
  }

  val FeatureNotAvailable = new CompilerEventType {
    override def getCode: String = "E014"

    override def getDescription: String = "feature not available"
  }
}
