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

import es.weso.shexlc.internal.io.CompilerMsgType

class CompilerMsgErrorType(code: String, description: String) extends CompilerMsgType {
  override def getCode: String = code
  override def getDescription: String = description
  override def getSuperType:String = Console.RED + s"error($getCode): $getDescription" + Console.RESET
}

object CompilerMsgErrorType {

  /**
   * Element Override Errors.
   */
  final val BaseOverride = new CompilerMsgErrorType("E001", "attempt to override a base directive value")
  final val StartOverride = new CompilerMsgErrorType("E002", "attempt to override an start directive value")
  final val PrefixOverride = new CompilerMsgErrorType("E003", "attempt to override an already defined prefix")
  final val ShapeOverride = new CompilerMsgErrorType("E004", "attempt to override an already defined shape")

  /**
   * Element Not Found Errors.
   */
  final val BaseNotFound = new CompilerMsgErrorType("E005", "base not defined")
  final val StartNotFound = new CompilerMsgErrorType("E006", "start not defined")
  final val PrefixNotFound = new CompilerMsgErrorType("E007", "prefix not defined")
  final val ShapeNotFound = new CompilerMsgErrorType("E008", "shape not defined")
  final val NullReference = new CompilerMsgErrorType("E009", "null reference")
  final val NonValidAction = new CompilerMsgErrorType("E010", "non valid action")


  /**
   * Compiler errors.
   */
  final val CouldNotCreateSchemaForSource = new CompilerMsgErrorType("E011", "couldn't create schema for source file")
  final val TypeCheckingError = new CompilerMsgErrorType("E012", "not valid type")
  final val CodeGeneratorError = new CompilerMsgErrorType("E013", "code generation error")
  final val FeatureNotAvailable = new CompilerMsgErrorType("E013", "feature not available")
}
