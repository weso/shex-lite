//------------------------------------------------------------------------------
// File: SymbolStats.scala
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

package es.weso.shexlc.internal.symbols

import wvlet.log.LogSupport

/**
  * The symbol stats are statistics about symbols that can be collected for
  * further analysis of the schema.
  *
  * @author Guillermo Facundo Colunga
  */
trait SymbolStats {

  /**
    * Gets the number of calls that have been made to a symbol. A call is
    * each time the symbol has been accessed.
    *
    * @return the number of calls done to a symbol.
    */
  def getNumberOfCalls: Int

  /**
    * Adds one call to the symbol stats and returns the new value for the
    * calls of the symbol.
    *
    * @return the number of calls after add one.
    */
  def addOneCall: Int
}

object SymbolStats {

  def empty: SymbolStats =
    new SymbolStats with LogSupport {

      // Logging message.
      debug("creating a new empty symbol stats")

      // Private variable for the number of calls.
      private[this] var numberOfCalls = 0

      /**
        * Gets the number of calls that have been made to a symbol. A call is
        * each time the symbol has been accessed.
        *
      * @return the number of calls done to a symbol.
        */
      override def getNumberOfCalls: Int = {
        debug("accessing the number of calls of a symbol")
        this.numberOfCalls
      }

      /**
        * Adds one call to the symbol stats and returns the new value for the
        * calls of the symbol.
        *
      * @return the number of calls after add one.
        */
      override def addOneCall: Int = {
        debug("increasing the number of calls of a symbol in 1 unit")
        this.numberOfCalls += 1

        debug("accessing the number of calls of a symbol")
        this.numberOfCalls
      }
    }
}
