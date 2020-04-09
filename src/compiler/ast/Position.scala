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

package compiler.ast

/**
 * A position in a source file. Lines and columns start counting at 1.
 */
class Position(val line: Int, val column: Int) extends Comparable[Position] {

  /**
   * Check if the position is usable. Does not know what it is pointing at, so it can't check if the position is after
   * the end of the source.
   */
  def isValid: Boolean = line >= Position.HOME.line && column > Position.HOME.line

  override def compareTo(position: Position):Int = {
    if (this.line < position.line) return -1
    if (this.line > position.line) return +1
    if (this.column < position.column) return -1
    if (this.column > position.column) return +1
    0
  }
}

object Position {

  /**
   * The first position in the file
   */
  final val HOME = new Position(1,1)

  /**
   * Convenient factory method.
   */
  def pos(line: Int, column: Int): Position = new Position(line, column)
}
