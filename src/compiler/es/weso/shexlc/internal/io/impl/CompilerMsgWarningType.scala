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

class CompilerMsgWarningType(code: String, description: String) extends CompilerMsgType {
  override def getCode: String = code
  override def getDescription: String = description
  override def getSuperType:String = Console.YELLOW + s"warning($getCode): $getDescription" + Console.RESET
}

object CompilerMsgWarningType {
  final val PrefixNotUsed = new CompilerMsgWarningType("W001", "prefix definition not used")
  final val BaseSetButNotUsed = new CompilerMsgWarningType("W002", "base has been set but not used")

  final val FeatureIgnored = new CompilerMsgWarningType("W003", "feature ignored")
  final val SchemaWithoutDirectMapping = new CompilerMsgWarningType("W003", "schema includes " +
    "constraints without a direct mapping to target language")
}


