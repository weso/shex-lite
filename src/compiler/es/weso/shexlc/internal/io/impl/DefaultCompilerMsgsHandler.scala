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

package es.weso.shexlc.internal.io.impl

import java.util.Objects

import es.weso.shexlc.internal.io.{CompilerMsg, CompilerMsgsHandler}
import org.antlr.v4.runtime.CharStream

import scala.collection.mutable.ListBuffer

class DefaultCompilerMsgsHandler(input: CharStream) extends CompilerMsgsHandler{

  private[this] final val msgs = new ListBuffer[CompilerMsg]
  private[this] final var hasErrorMsgsFlag = false;
  private[this] final var hasWarningMsgsFlag = false;

  override def hasErrorMsgs: Boolean = hasErrorMsgsFlag

  override def hasWarningMsgs: Boolean = hasWarningMsgsFlag

  override def addMsg(msg: CompilerMsg): Unit = {
    if(Objects.isNull(msg))
      throw new IllegalArgumentException("the message cannot be null")

    if(msg.getCompilerMsgType.isInstanceOf[CompilerMsgErrorType])
      hasErrorMsgsFlag = true
    else
      hasWarningMsgsFlag = true

    // Else add the message to the list.
    msgs += msg
  }

  override def getErrorMsgs: List[CompilerMsg] = {
    msgs.filter(msg => msg.getCompilerMsgType.isInstanceOf[CompilerMsgErrorType]).toList
  }

  override def getWarningMsgs: List[CompilerMsg] = {
    msgs.filter(msg => msg.getCompilerMsgType.isInstanceOf[CompilerMsgWarningType]).toList
  }

  override def showErrorMsgs: Unit = {
    msgs.filter(msg => msg.getCompilerMsgType.isInstanceOf[CompilerMsgErrorType])
      .foreach(msg => println(msg.toPrintableString(input)))
  }

  override def showWarningMsgs: Unit = {
    msgs.filter(msg => msg.getCompilerMsgType.isInstanceOf[CompilerMsgWarningType])
      .foreach(msg => println(msg.toPrintableString(input)))
  }
}
