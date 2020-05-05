//--------------------------------------------------------------------------------------------------
// File: HasParseResult.scala
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

package es.weso.shexlc.parse

import es.weso.shexlc.parse.ast.NodeWithPosition

/**
 * The Parser interface is the trait that all sub-parsers of the syntax analyzer will implement. It defines a common
 * contract by which all of the classes that extend from this trait need to add implementation to the get parse result
 * method. The context needed to parse by the specific classes will be given on its constructor.
 *
 * @author Guillermo Facundo Colunga
 * @tparam T is the type that will parse and therefore the return type of the get parse result function.
 */
trait HasParseResult[T <: NodeWithPosition] {

  /**
   * Gets the result of parsing.
   *
   * @return
   */
  def getParseResult: T
}
