//------------------------------------------------------------------------------
// File: SymbolTable.scala
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

import es.weso.shexlc.parse.ast.stmt._
import wvlet.log.LogSupport

import scala.collection.mutable.HashMap

/**
  * Represents the data structure that holds the data used by the compiler
  * during the validation process. By default and
  * after https://github.com/weso/shex-lite-evolution/pull/16 the default
  * behaviour for all declarations is that no
  * redefinition is allowed. That way the language will be kept clean.
  */
trait SymbolTable {

  /**
    * Adds a new scope in the symbol table.
    */
  def set: Unit

  /**
    * Removes tha last scope in the symbol table.
    */
  def reset: Unit

  /**
    * Inserts a new symbol in the current scope.
    *
    * @param symbolLabel is the symbol identifier.
    * @param definition is the symbol definition
    * @return an option with the inserted symbol if success or an empty
    *         symbol otherwise.
    */
  def insert(symbolLabel: String, definition: DefinitionStmt): Option[Symbol]

  /**
    * Searches the symbol table for a symbol matching the specified name. The
    * symbol table is searched backwards, that means from the deepest scope
    * to most superficial one.
    *
    * @param symbolLabel is the identifier of the symbol to look for.
    * @return an option with the symbol if success or an empty option otherwise.
    */
  def find(symbolLabel: String): Option[Symbol]
}

object SymbolTable {

  def empty: SymbolTable =
    new SymbolTable with LogSupport {

      // Log message indicating the new empty symbol table is being created.
      debug("creating new empty symbol table")

      // Provides a mapping between a identifier name and its symbol.
      private[this] var table = Array.empty[HashMap[String, Symbol]]

      override def set: Unit = {
        debug("adding new scope to the symbol table")
        this.table = this.table.appended(HashMap.empty[String, Symbol])
      }

      override def reset: Unit = {
        debug("removing the last scope from the symbol table")
        this.table = this.table.dropRight(this.table.size - 1)
      }

      override def insert(symbolLabel: String, definition: DefinitionStmt): Option[Symbol] = {

        // Logging the action of inserting a new symbol.
        debug(
          s"inserting symbol `$definition` in the symbol table scope " + s"${this.table.size - 1}"
        )

        if (this.table.isEmpty) this.set

        // Checking if the symbol is already defined in the scope.
        if (this.table(this.table.size - 1).contains(symbolLabel)) {
          debug(
            s"the symbol table does already contain the symbol `$symbolLabel` " +
            s"in the scope `${this.table.size - 1}`"
          )
          return Option.empty
        }

        // Create the symbol.
        debug(s"creating symbol for definition `$definition`")
        val symbol = Symbol.ofDefinition(definition)

        // Add the symbol to the table corresponding scope.
        debug(s"inserting symbol $symbol in the symbol table scope " + s"`${this.table.size - 1}`")
        this.table(this.table.size - 1).put(symbolLabel, symbol)

        // Returning the inserted symbol
        debug("accessing symbol from the symbol table")
        Option(symbol)
      }

      override def find(symbolLabel: String): Option[Symbol] = {

        // Logging the action of finding a symbol.
        debug(s"looking for symbol `$symbolLabel` in the symbol table")

        // The search is from the last to the first table in the array.
        var scope = this.table.size - 1
        while (scope >= 0) {

          // Log information about current search scope.
          debug(s"looking for symbol $symbolLabel at scope `$scope`")

          // Check if the table from the current iterator scope contains the
          // symbol.
          if (this.table(scope).contains(symbolLabel)) {

            // If it does debug the success and return the value.
            debug(s"match found for symbol `$symbolLabel` at scope `$scope`")
            return this.table(scope).get(symbolLabel)

          } else {

            // If it does not then log the information and decrease the scope
            // to look for in the upper symbol table.
            debug(
              s"no match found for symbol `$symbolLabel` at scope `$scope`, " + s"decreasing scope"
            )
            scope -= 1
          }
        }

        // Return an empty optional as no symbol has been found.
        debug(s"no symbol `$symbolLabel` was found in the symbol table")
        Option.empty
      }
    }
}
