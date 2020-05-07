//------------------------------------------------------------------------------
// File: DefaultSymbolTableEntry.scala
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

package es.weso.shexlc.internal.symboltable

class DefaultSymbolTableEntry[T](var content: T) extends SymbolTableEntry[T] {

  private var nOfCalls = 0

  override def getContent: T = content

  override def setContent(content: T): Unit = this.content = content

  override def getNumberOfCalls: Int = nOfCalls

  override def addOneCall(): Unit = nOfCalls += 1

  override def addNCalls(n: Int): Unit = nOfCalls += n
}
