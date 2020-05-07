//------------------------------------------------------------------------------
// File: NodeWithPosition.scala
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
//------------------------------------------------------------------------------

package es.weso.shexlc.parse.ast

import es.weso.shexlc.parse.ast.expr.Expression
import es.weso.shexlc.parse.ast.stmt.Statement

/**
  * Base class for all nodes of the abstract syntax tree.
  *
  * @author Guillermo Facundo Colunga
  */
trait NodeWithPosition {

  /**
    * Gets the position object that points to the source file.
    *
    * @return a position object containing the position in the source file.
    */
  def getPosition: Position

  /**
    * Gets the line in the source file where the node is located.
    *
    * @return the line in the source file where the node is located.
    */
  def getLine: Int = getPosition.line

  /**
    * Gets the column in the source file where the node is located.
    *
    * @return the column in the source file where the node is located.
    */
  def getColumn: Int = getPosition.column

  // Expression
  def isExpression(): Boolean = false

  def asExpression(): Expression =
    throw new IllegalStateException(s"$this is not an Expression")

  // Statement
  def isStatement(): Boolean = false

  def asStatement(): Statement =
    throw new IllegalStateException(s"$this is not an Statement")
}
