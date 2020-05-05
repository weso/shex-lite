//--------------------------------------------------------------------------------------------------
// File: CompilationConfigBuilder.scala
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

package es.weso.shexlc.internal

import es.weso.shexlc.IRGen.TargetIR

/**
 * The compilation configuration is a basic configuration that is passed to through the compilation context to all the
 * different tasks that take place and are the individual tasks who decide if they need to be executed or not.
 *
 * @author Guillermo Facundo Colunga
 */
case class CompilationConfigBuilder() {

  // Should warnings be generated?
  private var warnings = false

  // Should warnings be generated?
  private var generateIR = false

  // Specifies which target languages will be generated.
  private var TIR = Set.empty[TargetIR]

  /**
   * Sets whether or not the warnings should be generated. By default warnings generation is set to true.
   *
   * @param generate true to generate warnings, false otherwise.
   */
  def generateWarnings(generate: Boolean): CompilationConfigBuilder = {
    warnings = generate
    this
  }

  /**
   * Sets whether or not the IR should be generated. By default IR generation is set to false.
   *
   * @param generate true to generate IR, false otherwise.
   */
  def generateIR(generate: Boolean): CompilationConfigBuilder = {
    generateIR = generate
    this
  }

  /**
   * Sets the target intermediate representation languages to use.
   *
   * @param tir is the list that contains the intermediate representation target languages.
   */
  def withTIR(tir: List[TargetIR]): CompilationConfigBuilder = {
    TIR = Set.from(tir)
    this
  }

  /**
   * Builds a new compilation config object with the previous set values.
   *
   * @return the compilation configuration build with the defined values.
   */
  def build: CompilationConfig = {

    // Store a copy of the return value. It has to be computed this way to be able to reset the values of the object
    // to the default value.
    val returnValue = new CompilationConfig() {
      override def generateWarnings: Boolean = warnings
      override def generateIR: Boolean = generateIR
      override def getTIR: Set[TargetIR] = TIR
    }

    // Reset internal object values to default.
    this.generateIR = false
    this.warnings = true
    this.TIR = Set.empty

    // return the previous created object.
    returnValue
  }
}
