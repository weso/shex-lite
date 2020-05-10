//------------------------------------------------------------------------------
// File: CompilationResult.scala
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

import scala.collection.mutable.ListBuffer

/**
  * A compilation result contains all the objects generated after a compilation.
  *
  * @author Guillermo Facundo Colunga
  */
trait CompilationResult {

  /**
    * Indicates if any of the sources compiled contains an error.
    *
    * @return true if any of the compiled sources contains an error, false otherwise.
    */
  def hasErrors: Boolean

  /**
    * Indicates if any of the sources compiled contains a warning.
    *
    * @return true if any of the compiled sources contains a warning, false otherwise.
    */
  def hasWarnings: Boolean

  /**
    * Gets the generated results.
    *
    * @return the generated results.
    */
  def getCompilationIndividualResults: List[CompilationIndividualResult]

  /**
    * Adds a single generated source to the list of generated sources.
    *
    * @param result to be added to the list of individual sources.
    */
  def addCompilationIndividualResult(result: CompilationIndividualResult): Unit
}

object CompilationResult {

  /**
    * Creates an empty compiler result.
    *
    * @return an empty compiler implementation.
    */
  def empty: CompilationResult =
    new CompilationResult {

      private[this] var _hasErrors   = false
      private[this] var _hasWarnings = false
      private[this] var individualResults =
        ListBuffer.empty[CompilationIndividualResult]

      /**
        * Indicates if any of the sources compiled contains an error.
        *
        * @return true if any of the compiled sources contains an error, false otherwise.
        */
      override def hasErrors: Boolean = _hasErrors

      /**
        * Indicates if any of the sources compiled contains a warning.
        *
        * @return true if any of the compiled sources contains a warning, false otherwise.
        */
      override def hasWarnings: Boolean = _hasWarnings

      /**
        * Gets the generated sources.
        *
        * @return the generated sources.
        */
      override def getCompilationIndividualResults
        : List[CompilationIndividualResult] = individualResults.toList

      /**
        * Adds a single generated source to the list of generated sources.
        *
        * @param result to be added to the list of generated sources.
        */
      override def addCompilationIndividualResult(
        result: CompilationIndividualResult
      ): Unit = {
        individualResults += result
        if (result.hasErrors) this._hasErrors     = true
        if (result.hasWarnings) this._hasWarnings = true
      }
    }
}
