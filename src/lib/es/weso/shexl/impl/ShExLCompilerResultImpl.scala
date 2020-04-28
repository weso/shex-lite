package es.weso.shexl.impl

import es.weso.shexl.{ShExLCompilerIndividualResult, ShExLCompilerResult}

import scala.collection.mutable.ListBuffer


class ShExLCompilerResultImpl extends ShExLCompilerResult {

  private[this] var _hasErrors = false
  private[this] var _hasWarnings = false
  private[this] val individualResults = new ListBuffer[ShExLCompilerIndividualResult]()

  /**
   * Indicates if any of the sources compiled contains an error.
   *
   * @return true if any of the compiled sources contains an error, false otherwise.
   */
  override def hasErrors: Boolean = this._hasErrors

  /**
   * Indicates if any of the sources compiled contains a warning.
   *
   * @return true if any of the compiled sources contains a warning, false otherwise.
   */
  override def hasWarnings: Boolean = this._hasWarnings

  /**
   * Gets the iterable collection of individual results of the compilation. One individual result per source compiled.
   *
   * @return the iterable collection of individual results of the compilation. One individual result per source
   *         compiled.
   */
  override def getIndividualResults: Iterable[ShExLCompilerIndividualResult] = this.individualResults

  /**
   * Adds a single individual result to the results collection.
   *
   * @param result to be added to the collection of results.
   */
  override def addIndividualResult(result: ShExLCompilerIndividualResult): Unit = {
    if(result.hasErrors) this._hasErrors = true
    else if(result.hasWarnings) this._hasWarnings = true
    this.individualResults += result
  }
}
