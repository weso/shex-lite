package es.weso.shexl

/**
 * A compiler result contains the aggregation of the compilation of all the sources. Along that it also indicates if any
 * of the sources generated an error or a warning. It also provides the iterable collection of individual results for
 * each single source.
 *
 * @author Guillermo Facundo Colunga
 */
trait ShExLCompilerResult {

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
   * Gets the iterable collection of individual results of the compilation. One individual result per source compiled.
   *
   * @return the iterable collection of individual results of the compilation. One individual result per source
   *         compiled.
   */
  def getIndividualResults: Iterable[ShExLCompilerIndividualResult]

  /**
   * Adds a single individual result to the results collection.
   *
   * @param result to be added to the collection of results.
   */
  def addIndividualResult(result: ShExLCompilerIndividualResult)
}
