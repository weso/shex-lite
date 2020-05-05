//--------------------------------------------------------------------------------------------------
// File: CompilationContext.scala
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

import es.weso.shexlc.internal.errorhandler.ErrorHandler
import es.weso.shexlc.internal.symboltable.{SymbolHashTable, SymbolTable}
import org.antlr.v4.runtime.CharStream

/**
 * The compilation contexts defines the universe of the compilation. It contains its configuration, its symbol table,
 * its error handler, and the compilation result. Only the compilation result can be set, as other fields should be
 * read only for the different compiler stages.
 *
 * @author Guillermo Facundo Colunga
 */
trait CompilationContext {

  /**
   * Gets the input file as a char stream. This is needed to add the context information to its node of the ast. That
   * way we can not only add the line and the column to the error but also display a little of context about it by
   * writing the line where the error has been produce and the highlight the error in the line.
   *
   * @return the content of the input file as an stream of character.
   */
  def getInputContext: CharStream

  /**
   * Sets the input of the compilation context.
   *
   * @param input of the file to parse as a stream of characters.
   */
  private[shexlc] def setInputContext(input: CharStream): Unit

  /**
   * Gets the configuration fo the compiler. The configuration will affect different stages. But only those stages know
   * how to behave in respond to a given configuration. That means that all stages are dispatched from the compiler
   * point of view but maybe not all are executed according to the configuration.
   *
   * @return the configuration of the compiler.
   */
  def getConfiguration: CompilationConfig

  /**
   * Gets the symbol table attached to this compilation.
   *
   * @return the symbol table attached to this compilation.
   */
  def getSymbolTable: SymbolTable

  /**
   * Gets the error handler for this compilation.
   *
   * @return the error handler for this compilation.
   */
  def getErrorHandler: ErrorHandler

  /**
   * Gets the compilation result.
   *
   * @return the compilation result.
   */
  def getCompilationResult: CompilationResult

  /**
   * Sets the compilation result.
   *
   * @param compilationResult the compilation result.
   */
  def setCompilationResult(compilationResult: CompilationResult)
}

object CompilationContext {

  def withConfig(configuration: CompilationConfig): CompilationContext = new CompilationContext {

    private var input = Option.empty[CharStream]
    private val symbolTable = new SymbolHashTable()
    private val errorHandler: ErrorHandler = ErrorHandler.empty
    private var compilationResult: CompilationResult = CompilationResult.empty

    /**
     * Gets the configuration fo the compiler. The configuration will affect different stages. But only those stages know
     * how to behave in respond to a given configuration. That means that all stages are dispatched from the compiler
     * point of view but maybe not all are executed according to the configuration.
     *
     * @return the configuration of the compiler.
     */
    override def getConfiguration: CompilationConfig = configuration

    /**
     * Gets the symbol table attached to this compilation.
     *
     * @return the symbol table attached to this compilation.
     */
    override def getSymbolTable: SymbolTable = symbolTable

    /**
     * Gets the error handler for this compilation.
     *
     * @return the error handler for this compilation.
     */
    override def getErrorHandler: ErrorHandler = errorHandler

    /**
     * Gets the compilation result.
     *
     * @return the compilation result.
     */
    override def getCompilationResult: CompilationResult = compilationResult

    /**
     * Sets the compilation result.
     *
     * @param compilationResult the compilation result.
     */
    override def setCompilationResult(compilationResult: CompilationResult): Unit = {
      this.compilationResult = compilationResult
    }

    /**
     * Gets the input file as a char stream. This is needed to add the context information to its node of the ast. That
     * way we can not only add the line and the column to the error but also display a little of context about it by
     * writing the line where the error has been produce and the highlight the error in the line.
     *
     * @return the content of the input file as an stream of character.
     */
    override def getInputContext: CharStream = input.get

    /**
     * Sets the input of the compilation context.
     *
     * @param input of the file to parse as a stream of characters.
     */
    override private[shexlc] def setInputContext(input: CharStream): Unit = this.input = Option(input)
  }
}