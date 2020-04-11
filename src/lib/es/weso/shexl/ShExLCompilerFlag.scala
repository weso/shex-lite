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

class ShExLCompilerFlag(cliOptionName: String, description: String, active: Boolean = false) {
  override def toString: String = s"-$cliOptionName"
}

object ShExLCompilerFlag {

  // Compiler analysis
  final val SyntaxAnalysis = new ShExLCompilerFlag("-sya", "Syntax Analysis", true)
  final val SemanticAnalysis = new ShExLCompilerFlag("-sea", "Semantic Analysis", true)

  // Warnings / Errors
  final val WarningEmission = new ShExLCompilerFlag("-warn", "Warning Emission", true)
  final val ErrorEmission = new ShExLCompilerFlag("-err", "Error Emission", true)

  // Other flags down here.
}