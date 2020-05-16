//------------------------------------------------------------------------------
// File: StartDefStmt.scala
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

package es.weso.shexlc.parse.ast.stmt

import es.weso.shexlc.parse.ast.Position
import es.weso.shexlc.parse.ast.expr.Expression
import es.weso.shexlc.parse.ast.visitor.ASTGenericWalker
import org.antlr.v4.runtime.misc.Interval

/**
  * A Start Definition Statement assigns an expression to the start value of
  * the schema. In an schema must only be one
  * start definition, but this will be checked by the es.weso.shexlc.semantic
  * analyzer later. At the same time the expression represents
  * the value that will be pointed by the start, and should be a shape
  * reference even though this will be also checked
  * later by the es.weso.shexlc.semantic analyzer.
  *
  * @author Guillermo Facundo Colunga.
  */
class StartDefStmt(
  position: Position,
  tokenRange: Interval,
  content: String,
  val expression: Expression
) extends DefinitionStmt(position, tokenRange, content) {

  // Override default methods to indicate that this is as Start Definition
  // Statement.
  override def isStartDefStmt: Boolean = true

  override def asStartDefStmt: StartDefStmt = this

  /**
    * Gets the position object that points to the source file.
    *
    * @return a position object containing the position in the source file.
    */
  override def getPosition: Position = position

  /**
    * Gets the range of tokens from the source on which the node was generated.
    *
    * @return the range of tokens from the source on which the node was
    *         generated.
    */
  override def getRange: Interval = tokenRange

  /**
    * Gets the content of the node as a String, for example for a node that
    * contains the assignment of a and 3 the content
    * would be 'a = 3'.
    *
    * @return the content of the node as a String.
    */
  override def getContent: String = content

  /**
    * Accept method for visitor support.
    *
    * @param visitor the visitor implementation.
    * @param param   is the parameter passed to the visitor (of type A).
    * @tparam TP is the type the user parameter passed to the visitor.
    * @tparam TR is the type of the return value of the visitor.
    * @return the result of the visit (of type TR).
    */
  override def accept[TP, TR](
    visitor: ASTGenericWalker[TP, TR],
    param: TP
  ): TR = {
    visitor.visit(this, param)
  }
}
