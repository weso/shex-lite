//--------------------------------------------------------------------------------------------------
// File: Visitable.scala
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

package es.weso.shexlc.parse.ast.visitor

/**
 * Defines a common trait for all nodes that can be visited.
 *
 * This file is a modification of the original java parser, found here:
 * https://github.com/javaparser/javaparser/blob/master/javaparser-core/src/main/java/com/github/javaparser/es.weso.shexlc.parse.ast/visitor/Visitable.java
 *
 * @author Guillermo Facundo Colunga
 */
trait Visitable {

  /**
   * Accept method for visitor support.
   *
   * @param visitor the visitor implementation.
   * @param param   is the parameter passed to the visitor (of type A).
   * @tparam TP is the type the user parameter passed to the visitor.
   * @tparam TR is the type of the return value of the visitor.
   * @return the result of the visit (of type TR).
   */
  def accept[TP, TR](visitor: ShExLiteGenericVisitor[TP, TR], param: TP): TR
}
