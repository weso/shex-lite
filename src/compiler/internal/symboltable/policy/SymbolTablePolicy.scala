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

package compiler.internal.symboltable.policy

import compiler.ast.ASTNode
import compiler.internal.error.ErrType
import compiler.internal.symboltable.SymbolTable

/**
 * Defines a policy that will be used by the symbol table to decide whether an action is allowed.
 */
private[compiler] trait SymbolTablePolicy {

  /**
   * Projects an insert action over the given symbol table.
   *
   * @param symbolTable to project the insert action over.
   * @param node to insert in the given st.
   * @return an option object that if contains something means that the action will produce an event.
   */
  def projectInsertAction(symbolTable: SymbolTable, node: ASTNode): Option[ErrType]
}
