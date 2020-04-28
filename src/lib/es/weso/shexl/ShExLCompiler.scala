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

import es.weso.shexl.impl.ShExLCompilerConfig
import es.weso.shexlc.internal.io.CompilerMsgsHandler
import es.weso.shexlc.internal.symboltable.SymbolHashTable

/**
 * The Shapes Expressions Lite Compiler is the main entry point for the public API. It allows to configure the compiler,
 * compile files and generate target code from it.
 *
 * @author Guillermo Facundo Colunga.
 */
trait ShExLCompiler {

  /**
   * Sets the configuration for the compiler to compile. The configuration might include:
   *  - Skipping warnings.
   *  - Target language.
   *  - Activate / De-activate compiler optimizations.
   *
   * @param config is the configuration object.
   */
  def setConfiguration(config: ShExLCompilerConfig): ShExLCompiler

  /**
   * Gets the configuration of the compiler, notice that if no configuration has been set the initial one will be the
   * returned one.
   *
   * @return the current configuration of the compiler.
   */
  def getConfiguration: ShExLCompilerConfig

  /**
   * Gets the current state of the compiler.
   *
   *
   * @return the current state of the compiler.
   */
  def getState: ShExLCompilerState

  /**
   * Gets whether the compilation queue is empty or not.
   *
   * @return true if the compilation queue is empty, false otherwise.
   */
  def isCompilationQueueEmpty: Boolean

  /**
   * Gets the collection that contains the compilation stages.
   *
   * @return the collection that contains the compilation stages.
   */
  def getCompilerStages: Iterable[ShExLCompilerStage]

  /**
   * Registers a new stage in the compiler. If the stage of the compiler does already exists the compiler will place the
   * stage randomly with others with the same priority.
   *
   * @param stage to add to the compiler.
   * @return the compiler object with the stage added.
   */
  def registerCompilerStage(stage: ShExLCompilerStage): ShExLCompiler

  /**
   * Adds one file to the compile queue. Non file will be processed until the compile method is called. Returns
   * the compiler itself as an object so that method vectorization can be used.
   *
   * @param filepath of the file to compile.
   * @return the compiler object with the file added.
   */
  def addSource(filepath: String): ShExLCompiler

  /**
   * Appends the compile queue with the file paths. Non file will be processed until the compile method is called. Returns
   * the compiler itself as an object so that method vectorization can be used.
   *
   * @param filePaths is the collection that contains all the path to the files to compile.
   * @return the compiler object with the files added.
   */
  def addSources(filePaths: List[String]): ShExLCompiler

  /**
   * Gets the collection of files in the compilation queue.
   *
   * @return the collection of files in the compilation queue.
   */
  def getCompilationQueue: Iterable[String]

  /**
   * Compiles all the files in the compilation queue.
   *
   * @return the compiler object with the files compiled.
   */
  def compile: ShExLCompiler

  /**
   * Gets the  result of the compilation. It is important to know that the compilation must have finished to be able to
   * get the result.
   *
   * @return the  result of the compilation.
   */
  def getCompilationResult: ShExLCompilerResult

  /**
   * Gets the symbol table of the compiler.
   *
   * @return the symbol table of the compiler.
   */
  private[weso] def getCompilerSymbolTable: SymbolHashTable

  /**
   * Gets the compiler messages handler.
   *
   * @return the compiler messages handler.
   */
  private[weso] def getCompilerMsgsHandler: CompilerMsgsHandler
}
