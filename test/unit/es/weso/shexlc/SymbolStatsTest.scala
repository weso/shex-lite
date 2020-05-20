//------------------------------------------------------------------------------
// File: SymbolStatsTest.scala
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

import es.weso.shexlc.internal.symbols.SymbolStats
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter

class SymbolStatsTest extends AnyFunSuite with BeforeAndAfter {

  // The symbol stats object that will be used for testing.
  private[this] var symbolStats = SymbolStats.empty

  test("Check that the default number of calls is 0") {
    assert(SymbolStats.defaultNumberOfCalls == 0)
  }

  test("The default values of the empty created symbol must be well formed") {
    // Mock the creation of an empty symbol.
    symbolStats = SymbolStats.empty

    // Check that the initial values are correct.
    assert(symbolStats.getNumberOfCalls == SymbolStats.defaultNumberOfCalls)
  }

  test("Increasing the calls in one unit should affect the number of calls") {
    // Mock the creation of an empty symbol.
    symbolStats = SymbolStats.empty

    // Add one call to the number of calls of the symbol stats.
    symbolStats.addOneCall

    // Check that the number of calls has been affected.
    assert(symbolStats.getNumberOfCalls == SymbolStats.defaultNumberOfCalls + 1)
  }
}
