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

package ast.stmt

/**
 * A base class for all the definitions.
 *
 * This definition trait is just used as a mean to know if an statement is a definition, any definition. For that it
 * overrides the super is and as methods but let other definitions is's and as's to its children. Not need to implement
 * here any more methods except those that will be mandatory for all definitions.
 *
 * @author Guillermo Facundo Colunga
 */
trait DefinitionStmt extends Statement {

  // Override default methods to indicate that this is a Definition Statement.
  override def isDefinitionStmt: Boolean = true

  override def asDefinitionStmt: DefinitionStmt = this
}
