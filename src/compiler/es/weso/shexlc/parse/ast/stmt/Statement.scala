//--------------------------------------------------------------------------------------------------
// File: Statement.scala
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

package es.weso.shexlc.parse.ast.stmt

import es.weso.shexlc.parse.ast.{AbstractASTNode, Position}
import org.antlr.v4.runtime.misc.Interval

/**
 * A base class for all the statements.
 *
 * When an statement is added to the es.weso.shexlc.parse.ast it is mandatory to add its is and as methods, that way it is much
 * simple and faster to check if the es.weso.shexlc.parse.ast is semantically correct or not and also to access fields.
 *
 * @author Guillermo Facundo Colunga.
 */
abstract class Statement(position: Position, tokenRange: Interval, content: String)
  extends AbstractASTNode(position, tokenRange, content) {

  // Override default values from node with position.
  override def isStatement(): Boolean = true
  override def asStatement(): Statement = this

  // Definition Statement.
  def isDefinitionStmt: Boolean = false
  def asDefinitionStmt: DefinitionStmt = throw new IllegalStateException(s"$this is not a DefinitionStmt")

  // Prefix Definition Statement.
  def isPrefixDefStmt: Boolean = false
  def asPrefixDefStmt: PrefixDefStmt = throw new IllegalStateException(s"$this is not a PrefixDefStmt")

  // Shape Definition Statement.
  def isShapeDefStmt: Boolean = false
  def asShapeDefStmt: ShapeDefStmt = throw new IllegalStateException(s"$this is not a ShapeDefStmt")

  // Base Definition Statement.
  def isBaseDefStmt: Boolean = false
  def asBaseDefStmt: BaseDefStmt = throw new IllegalStateException(s"$this is not a BaseDefStmt")

  // Start Definition Statement.
  def isStartDefStmt: Boolean = false
  def asStartDefStmt: StartDefStmt = throw new IllegalStateException(s"$this is not a StartDefStmt")


  // --- Experimental ---
  // Experimental features are not fully tested and therefore any critical application should not rely on them.

  // Import Statement.
  def isImportStmt: Boolean = false
  def asImportStmt: ImportStmt = throw new IllegalStateException(s"$this is not an ImportStmt")
}