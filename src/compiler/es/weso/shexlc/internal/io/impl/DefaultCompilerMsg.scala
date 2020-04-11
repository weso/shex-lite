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

import es.weso.shexlc.ast.Position
import es.weso.shexlc.ast.visitor.ShExLiteGenericVisitor
import es.weso.shexlc.internal.io.{CompilerMsg, CompilerMsgType}
import org.antlr.v4.runtime.{CharStream}
import org.antlr.v4.runtime.misc.Interval

class DefaultCompilerMsg(pos: Position, tokenRange: Interval, cause: String, mType: CompilerMsgType) extends CompilerMsg {

  override def getCompilerMsgType: CompilerMsgType = mType

  override def getMessage: String = cause

  override def getPosition: Position = pos

  override def getRange: Interval = tokenRange

  override def accept[TP, TR](visitor: ShExLiteGenericVisitor[TP, TR], param: TP): TR = {
    throw new IllegalStateException(s"$this should not be visited")
  }

  override def toPrintableString(input: CharStream): String = {
    val sb = new StringBuilder()
    sb.append(s"${mType.getSuperType}")
    sb.append("\n")
    sb.append(s"--> ${input.getSourceName}:${pos.line}:${pos.column}")
    sb.append("\n | ")
    sb.append(s"${input.getText(tokenRange)}")
    sb.append("\n | ")

    //    for(_ <- 0 to pos.column-1) {
//      sb.append(" ")
//    }
    sb.append(s"^ $cause")
    sb.append("\n")
    sb.toString()
  }
}
