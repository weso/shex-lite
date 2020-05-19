//------------------------------------------------------------------------------
// File: SymbolTableEntry.scala
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

import es.weso.shexlc.parse.ast.stmt.DefinitionStmt
import wvlet.log.LogSupport

/**
  * A symbol is a container for the definitions of the schema.
  *
  * @author Guillermo Facundo Colunga.
  */
trait Symbol {

  /**
    * Gets the content of the symbol.
    * @return the content of the symbol.
    */
  def getContent: Option[DefinitionStmt]

  /**
    * Gets the symbol associated statistics.
    *
    * @return the symbol associated statistics.
    */
  def getStats: SymbolStats
}

/**
  * Symbol object offers and entry-point for symbols creation.
  *
  * @author Guillermo Facundo Colunga
  */
object Symbol {

  /**
    * Creates a new symbol implementation for the given content.
    *
    * @param definition to store in the symbol. Usually the definition.
    * @return a new Symbol implementation for the given content.
    */
  def ofDefinition(definition: DefinitionStmt): Symbol =
    new Symbol with LogSupport {

      // Logging message
      debug(s"creating a new symbol for definition `$definition`")

      // Private copy of the definition and private value for the stats of
      // the symbol
      private val _definition: DefinitionStmt = definition
      private val _stats: SymbolStats         = SymbolStats.empty

      /**
        * Gets the content of the symbol.
        *
        * @return the content of the symbol.
        */
      override def getContent: Option[DefinitionStmt] = {
        debug("accessing to the content of a symbol")
        Option(this._definition)
      }

      /**
        * Gets the number of calls that have been made to the symbol.
        *
        * @return the number of calls that have been made to the symbol.
        */
      override def getStats: SymbolStats = {
        debug("accessing to the stats of a symbol")
        this._stats
      }
    }
}
