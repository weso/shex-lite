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

package es.weso.shexl

import ast.Schema
import internal.io.{CompilerMsg, CompilerMsgsHandler}

class ShExLCompileResult(schema: Either[CompilerMsg, Schema], compilerMsgsHandler: CompilerMsgsHandler) {

  def hasErrors: Boolean = compilerMsgsHandler.hasErrorMsgs

  def hasWarnings: Boolean = compilerMsgsHandler.hasWarningMsgs

  def isCorrect: Boolean = !hasErrors && !hasErrors

  def getErrors: List[CompilerMsg] = compilerMsgsHandler.getErrorMsgs

  def getWarnings: List[CompilerMsg] = compilerMsgsHandler.getWarningMsgs

  def getSchema: Either[CompilerMsg, Schema] = schema
}
