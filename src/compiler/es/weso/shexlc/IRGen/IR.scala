//--------------------------------------------------------------------------------------------------
// File: IR.scala
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
//--------------------------------------------------------------------------------------------------

package es.weso.shexlc.IRGen

import es.weso.shexlc.internal.errorhandler.{CompilationEvent, Err, Warn}

/**
 * The intermediate representation is the result of the code generation for the shex-lite compiler. It contains
 * all the sources generated for the different target languages. Each generated source is represented by a tuple where
 * the first element is the name of the source file and the second the value (its content).
 *
 * @author Guillermo Facundo Colunga
 */
trait IR {

  /**
   * Gets all the generated sources for a target language. For example for java will get all the objects generated from
   * a shex-lite file or some of them.
   *
   * @param targetIR is the target language for which the sources will be retrieved.
   * @return a list of tuples, each one represents a source file and the first value is the source file name, the second
   *         is its content.
   */
  def getSources(targetIR: TargetIR): List[(String, String)]

  /**
   * Gets whether the intermediate representation generated errors or not.
   *
   * @return true if has errors, false otherwise.
   */
  def hasErrors: Boolean

  /**
   * Gets the list of errors generated during the generation of thr IR.
   *
   * @return the list of errors generated during the generation of thr IR.
   */
  def getErrors: List[Err]

  /**
   * Gets whether the intermediate representation generated warnings or not.
   *
   * @return true if has warnings, false otherwise.
   */
  def hasWarnings: Boolean

  /**
   * Gets the list of warnings generated during the generation of thr IR.
   *
   * @return the list of warnings generated during the generation of thr IR.
   */
  def getWarnings: List[Warn]

  /**
   * Adds a single compilation event (warning or error) to the IR. This is not intended to be used from outside this
   * package.
   *
   * @param compilationEvent to add to the IR object.
   */
  private[IRGen] def addCompilationEvent(compilationEvent: CompilationEvent)
}
