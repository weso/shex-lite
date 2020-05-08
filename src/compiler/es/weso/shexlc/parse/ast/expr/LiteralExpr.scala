//------------------------------------------------------------------------------
// File: LiteralExpr.scala
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

package es.weso.shexlc.parse.ast.expr

import es.weso.shexlc.parse.ast.Position
import org.antlr.v4.runtime.misc.Interval

/**
  * A base class for all the literal expressions of the es.weso.shexlc.parse
  *  .ast.
  *
  * This literal expression trait is just used as a mean to know if an
  * expression is a literal, any literal. For that it overrides the super is
  * and as methods but let other literal is's and as's to its children. Not
  * need to implement here any more methods except those that will be
  * mandatory for all literals.
  *
  * @author Guillermo Facundo Colunga
  */
abstract class LiteralExpr(
  position: Position,
  tokenRange: Interval,
  content: String
) extends ConstraintNodeExpr(position, tokenRange, content) {

  // Override default methods to indicate that this is a Literal Expression.
  override def isLiteralExpr: Boolean     = true
  override def asLiteralExpr: LiteralExpr = this
}
