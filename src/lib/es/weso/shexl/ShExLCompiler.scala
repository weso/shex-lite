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
   * Adds one file to the compile queue. Non file will be processed until the compile method is called. Returns
   * the compiler itself as an object so that method vectorization can be used.
   *
   * @param filepath of the file to compile.
   * @return the compiler object with the file added.
   */
  def addFile(filepath: String): ShExLCompiler

  /**
   * Appends the compile queue with the file paths. Non file will be processed until the compile method is called. Returns
   * the compiler itself as an object so that method vectorization can be used.
   *
   * @param filePaths is the collection that contains all the path to the files to compile.
   * @return the compiler object with the files added.
   */
  def addFiles(filePaths: List[String]): ShExLCompiler

  /**
   * Compiles all the files in the queue.
   *
   * @return a list containing one result object per file compiled.
   */
  def compile(): List[ShExLCompileResult]
}
