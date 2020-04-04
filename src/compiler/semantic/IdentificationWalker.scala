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

package compiler.semantic

import com.typesafe.scalalogging.Logger
import compiler.ast.{BaseDeclaration, DefaultASTWalker, PrefixDeclaration, ShapeDeclaration, StartDeclaration}

/**
 * The identification walker is the tool that travels the AST just to identify possible definitions an add the
 * information found to the symbol table.
 */
class IdentificationWalker extends DefaultASTWalker {

  // Default logger
  final val logger = Logger[IdentificationWalker]

  /**
   * Identifies a base declaration. It looks for base declarations and add the content of the abse declaration  to
   * the symbol table.
   *
   * @param declaration that is being walked and will be added to the symbol table.
   * @param param is the parameter is any needed.
   * @return either the base declaration if no error happen or a compile error otherwise.
   */
  override def walk(declaration: BaseDeclaration, param: Any): Any = {
    logger.debug(s"Walking over a base declaration [$declaration].")

    // Adds the base to the memory table. Policies about redefinition and other things are delegated to the ST.
    MemorySymbolTable.setBase(declaration, declaration)
  }

  /**
   * Identifies an start declaration. Once this method is called to walk over an start declaration if delegates to the
   * symbol table the action of adding it to the context or raising an error.
   *
   * @param declaration that is being walked and will be added to the symbol table.
   * @param param is the parameter is any needed.
   * @return either the base declaration if no error happen or a compile error otherwise.
   */
  override def walk(declaration: StartDeclaration, param: Any): Any = {
    logger.debug(s"Walking over a start declaration [$declaration].")

    // Adds the start to the memory table. Policies about redefinition and other things are delegated to the ST.
    MemorySymbolTable.setStart(declaration, declaration)
  }

  /**
   * Identifies a prefix declaration. Once this method is called to walk over an prefix declaration if delegates to the
   * symbol table the action of adding it to the context or raising an error.
   *
   * @param declaration that is being walked and will be added to the symbol table.
   * @param param is the parameter if any needed.
   * @return either the prefix declaration if no error happen or a compile error otherwise.
   */
  override def walk(declaration: PrefixDeclaration, param: Any): Any = {
    logger.debug(s"Walking over a prefix declaration [$declaration]")

    // Ads the prefix ot the symbol table. Policies about redefinition and other things are delegated to the ST.
    MemorySymbolTable.insert(declaration, declaration)
  }

  /**
   * Identifies a shape declaration. Once this method is called to walk over an shape declaration if delegates to the
   * symbol table the action of adding it to the context or raising an error.
   *
   * @param declaration
   * @param param
   * @return
   */
  override def walk(declaration: ShapeDeclaration, param: Any): Any = {
    logger.debug(s"Walking over a prefix declaration [$declaration]")

    // Adds the shape to the symbol table. Policies about redefinition and other things are delegated to the ST.
    MemorySymbolTable.insert(declaration, declaration)
  }
}
