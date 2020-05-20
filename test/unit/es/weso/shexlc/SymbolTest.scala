//------------------------------------------------------------------------------
// File: SymbolTest.scala
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

package es.weso.shexlc

import es.weso.shexlc.parse.ast.stmt.BaseDefStmt
import es.weso.shexlc.internal.symbols.{Symbol, SymbolStats}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter

class SymbolTest extends AnyFunSuite with BeforeAndAfter {

  // The mock definition will be used to create the symbol from it.
  private[this] val mockDefinition = new BaseDefStmt(null, null, null, null)

  // The symbol variable that will be used for testing.
  private[this] var symbol = Symbol.ofDefinition(mockDefinition)

  test("The content of the symbol must be defined after creation") {
    // Mock the clean creation of a symbol.
    symbol = Symbol.ofDefinition(mockDefinition)

    // Check that the content of the symbol is defined.
    assert(this.symbol.getContent.isDefined)
  }

  test("The content of a symbol must match the definition used for creation") {
    // Mock the clean creation of a symbol.
    symbol = Symbol.ofDefinition(mockDefinition)

    // Check that the content of the symbol matched the one used during creation.
    assert(this.symbol.getContent.get == mockDefinition)
  }

  test("The default statistics of a symbol must be an empty stats object") {
    // Mock the clean creation of a symbol.
    symbol = Symbol.ofDefinition(mockDefinition)

    // A simple mock for the symbol stats.
    val mockEmptyStats = SymbolStats.empty

    // Check that the symbol stats default values are well formed.
    assert(this.symbol.getStats.getNumberOfCalls == mockEmptyStats.getNumberOfCalls)
  }
}
