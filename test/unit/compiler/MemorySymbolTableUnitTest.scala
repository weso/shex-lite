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

package compiler

import compiler.ast.{BaseDeclaration, IRILiteral, PrefixDeclaration, ShapeInvocation, StartDeclaration}
import compiler.semantic.{MemoryErrorHandler, MemorySymbolTable}
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class MemorySymbolTableUnitTest extends AnyFunSuite with BeforeAndAfter {

  // Creating a first base.
  val base = new BaseDeclaration("example", 0, 1,
    new IRILiteral("example", 0, 2, "base-iri"))

  // Creating a second base.
  val newBase = new BaseDeclaration("example", 1, 1,
    new IRILiteral("example", 1, 2, "new-base-iri"))

  // Creating a prefix
  val prefix = new PrefixDeclaration("example", 2, 1, "xsd",
    new IRILiteral("example", 2, 2, "<http://schema.org/>"))

  // Creating a second prefix
  val newPrefix = new PrefixDeclaration("example", 3, 1, "xsd",
    new IRILiteral("example", 3, 2, "<http://foaf.org/>"))

  before {
    MemorySymbolTable.restore()
  }

  // Test Cases.

  test("Check that the default base is correct") {
    assert(MemorySymbolTable.getBase(newBase).isRight)
    assert(MemorySymbolTable.getBase(newBase).right.get.iri.value.equals(MemorySymbolTable.DEFAULT_BASE))

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    assert(!MemoryErrorHandler.hasWarnings)
  }

  test("Check that the base can be set") {
    MemorySymbolTable.setBase(base)
    assert(MemorySymbolTable.getBase(newBase).right.get equals base)

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    assert(!MemoryErrorHandler.hasWarnings)
  }

  test("Check that the base can only be changed once") {
    val nWarnings = MemoryErrorHandler.warnings.size

    MemorySymbolTable.setBase(base)
    assert(MemorySymbolTable.getBase(newBase).right.get equals base)

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    //assert(nWarnings equals MemoryErrorHandler.warnings.size)

    MemorySymbolTable.setBase(newBase)
    assert(!MemorySymbolTable.getBase(newBase).right.get.equals(newBase))

    // Check that there are no errors nor warnings.
    assert(MemoryErrorHandler.hasErrors)
    //assert(nWarnings equals MemoryErrorHandler.warnings.size+2)
  }

  test("Check that the start variable has a correct default value") {
    assert(MemorySymbolTable.getStart(newBase).isLeft)
  }

  test("Check that the start variable can be set") {
    MemorySymbolTable.setStart(new StartDeclaration("test", 4,4,null))
    assert(MemorySymbolTable.getStart(newBase).getOrElse(null).filename equals "test")
  }

  test("Check that the override a prefix generates a warning") {
    assert(MemorySymbolTable.insert(prefix).isRight)
    assert(MemorySymbolTable.insert(newPrefix).isLeft)

    // Check that the change is correct.
    assert(MemorySymbolTable.getPrefix(newBase, prefix.name).isRight)
    assert(MemorySymbolTable.getPrefix(newBase, newPrefix.name).isRight)

    // Check that there is errors and warnings.
    assert(MemoryErrorHandler.hasErrors)
  }
}
