//------------------------------------------------------------------------------
// File: CompilationConfig.scala
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

package es.weso.shexlc.internal

import es.weso.shexlc.IRGen.TargetIR

/**
  * The compilation configuration is a basic configuration that is passed to through the compilation context to all the
  * different tasks that take place and are the individual tasks who decide if they need to be executed or not.
  *
  * By default warnings will be generated and IR won't.
  *
  * @author Guillermo Facundo Colunga
  */
trait CompilationConfig {
  def generateWarnings: Boolean = true
  def generateIR: Boolean       = false
  def getTIR: Set[TargetIR]     = Set.empty[TargetIR]
}
