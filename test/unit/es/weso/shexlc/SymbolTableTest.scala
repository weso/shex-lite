//------------------------------------------------------------------------------
// File: SymbolTableTest.scala
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

import java.util.Objects

import es.weso.shexlc.internal.symbols.SymbolTable
import es.weso.shexlc.parse.ast.stmt.BaseDefStmt
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter

class SymbolTableTest extends AnyFunSuite with BeforeAndAfter {

  // The symbol table object for testing
  private[this] var symbolTable = SymbolTable.empty

  test("The empty symbol table is well created") {
    // Mock a clean creation of the symbol table.
    symbolTable = SymbolTable.empty

    // Checking that the symbol table object is non null and that it is an instance of the symbol
    // table trait.
    assert(Objects.nonNull(symbolTable))
    assert(symbolTable.isInstanceOf[SymbolTable])
  }

  test("An empty symbol table is capable of inserting elements") {
    // Mock a clean creation of the symbol table.
    symbolTable = SymbolTable.empty

    // The mock label and definition for the insert method.
    val mockDefinitionLabel = "label"
    val mockDefinition      = new BaseDefStmt(null, null, null, null)

    try {
      // Inserting the mock definition i the symbol table.
      symbolTable.insert(mockDefinitionLabel, mockDefinition)
    } catch {
      // If any exception then fail.
      case e: Exception =>
        fail(
          s"Inserting a element in an empty symbol table should " +
          s"not produce an exception, but produced: ${e.getStackTrace}"
        )
    }
  }

  test("The symbol table is able top find inserted elements") {
    // Mock a clean creation of the symbol table.
    symbolTable = SymbolTable.empty

    // The mock label and definition for the insert method.
    val mockDefinitionLabel = "label"
    val mockDefinition      = new BaseDefStmt(null, null, null, null)

    // Inserting the mock definition in the symbol table.
    symbolTable.insert(mockDefinitionLabel, mockDefinition)

    // Check that the find method finds the definition and that the definition is the one
    // previously checked.
    assert(symbolTable.find(mockDefinitionLabel).isDefined)
    assert(symbolTable.find(mockDefinitionLabel).get.getContent.get == mockDefinition)
  }

  test("The symbol table does not found not inserted elements") {
    // Mock a clean creation of the symbol table.
    symbolTable = SymbolTable.empty

    // The mock label and definition for the insert method.
    val mockDefinitionLabel            = "label"
    val mockNonExistingDefinitionLabel = "non_existing_element"
    val mockDefinition                 = new BaseDefStmt(null, null, null, null)

    // No symbol is inserted in the symbol table

    // Check that the find method does not finds the definition and that the definition is the one
    // previously checked.
    assert(symbolTable.find(mockNonExistingDefinitionLabel).isEmpty)

    // Inserting the mock definition in the symbol table to check if there is an element in tha
    // table and we look for a non existing one that still returns null
    symbolTable.insert(mockDefinitionLabel, mockDefinition)

    // Check that the find method does not finds the definition and that the definition is the one
    // previously checked.
    assert(symbolTable.find(mockNonExistingDefinitionLabel).isEmpty)
  }

  test("The symbol table does not allow repeated elements and do not override existing ones") {
    // Mock a clean creation of the symbol table.
    symbolTable = SymbolTable.empty

    // The mock label and definition for the insert method.
    val mockDefinitionLabel = "label"
    val mockDefinition      = new BaseDefStmt(null, null, "mock_definition_1", null)
    val mockDefinition2     = new BaseDefStmt(null, null, "mock_definition_2", null)

    // Inserting the mock definition in the symbol table.
    assert(symbolTable.insert(mockDefinitionLabel, mockDefinition).isDefined)

    // When inserting an element with the same label the method should return and empty optional.
    assert(symbolTable.insert(mockDefinitionLabel, mockDefinition2).isEmpty)

    // Thew value should not be changed under any condition.
    assert(symbolTable.find(mockDefinitionLabel).get.getContent.get == mockDefinition)
  }

  test("The symbol table should not rise an exception if try to reset an empty table") {
    // Mock a clean creation of the symbol table.
    symbolTable = SymbolTable.empty

    // Should not raise an exception when the table is empty.
    try { symbolTable.reset }
    catch { case e: Exception => fail("No exception should be thrown here") }
  }

  test("The symbol table should allow to increase and reduce the scope") {
    // Mock a clean creation of the symbol table.
    symbolTable = SymbolTable.empty

    // Testing the set method.
    try { symbolTable.set }
    catch { case e: Exception => fail("No exception should be thrown here") }

    // Testing the reset method.
    try { symbolTable.reset }
    catch { case e: Exception => fail("No exception should be thrown here") }
  }
}
