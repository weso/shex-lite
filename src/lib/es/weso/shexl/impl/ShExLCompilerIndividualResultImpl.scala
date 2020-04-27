package es.weso.shexl.impl

import es.weso.shexl._
import es.weso.shexlc.ast.Schema
import es.weso.shexlc.internal.io.CompilerMsg

import scala.collection.mutable.HashMap

/**
 * Represents the basic implementation fo the individual compiler result.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param sourceFilePath is the source compiled.
 * @param errors are the errors generated.
 * @param warnings the warnings generated.
 * @param schema the schema if it was generated.
 */
class ShExLCompilerIndividualResultImpl(sourceFilePath: String, errors: Iterable[CompilerMsg],
                                        warnings: Iterable[CompilerMsg], schema: Option[Schema])
  extends ShExLCompilerIndividualResult {

  private val generatedSources = new HashMap[ShExLCompilerTargetLanguage, Iterable[ShExLCompilerGeneratedSource]]()

  /**
   * Gets the path of the source that generated this individual compiler result.
   *
   * @return the path of the source that generated this individual compiler result.
   */
  override def getSource: String = sourceFilePath

  /**
   * Indicates if the source compiled contains an error.
   *
   * @return true if the compiled source generated an error, false otherwise.
   */
  override def hasErrors: Boolean = !errors.isEmpty

  /**
   * Indicates if the source compiled contains a warning.
   *
   * @return true if the compiled source generated a warning, false otherwise.
   */
  override def hasWarnings: Boolean = !warnings.isEmpty

  /**
   * Gets the list of errors that generated the compilation of the source attached to this result.
   *
   * @return the list of errors that generated the compilation of the source attached to this result.
   */
  override def getErrors: Iterable[CompilerMsg] = errors

  /**
   * Gets the list of warnings that generated the compilation of the source attached to this result.
   *
   * @return the list of warnings that generated the compilation of the source attached to this result.
   */
  override def getWarnings: Iterable[CompilerMsg] = warnings

  /**
   * Gets the generated schema as an option object. If the option is empty means that the compiler was not able to
   * generate an schema for the attached source. You should check the generated errors. Else the option object will
   * contain the generated schema.
   *
   * @return an option object that may contain the schema if no error was generated during the compilation.
   */
  override def getGeneratedSchema: Option[Schema] = schema

  /**
   * Gets the all the generated sources for the current source fle. It is important to know that a single file can
   * generate multiple sources. And also a single file can be the origin of the code generation in to multiple target
   * languages. For this reason this method returns a map where the key is the target language and for each key it
   * contains a collection of all the generated sources.
   *
   * @return a map where the key is the target language and for each key it contains a collection of all the generated
   *         sources.
   */
  override def getGeneratedSources: HashMap[ShExLCompilerTargetLanguage, Iterable[ShExLCompilerGeneratedSource]] =
    generatedSources
}
