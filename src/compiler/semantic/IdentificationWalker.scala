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
import compiler.ast.{BaseDeclaration, DefaultASTWalker}

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
}
