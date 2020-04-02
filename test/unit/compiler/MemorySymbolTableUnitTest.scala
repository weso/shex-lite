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

import compiler.ast.{BaseDeclaration, IRILiteral, PrefixDeclaration, PrefixInvocation, ShapeDeclaration, ShapeInvocation, StartDeclaration}
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

  val shape = new ShapeDeclaration("example", 4,1,
    new PrefixInvocation("example", 4,2, "this is my shape name", prefix), null)

  before {
    MemorySymbolTable.restore()
    MemoryErrorHandler.restore()
  }

  // Test Cases.

  test("Check that the default base is correct") {
    assert(MemorySymbolTable.DEFAULT_BASE.equals("<internal>"))
    assert(MemorySymbolTable.getBase(newBase).isRight)
    assert(MemorySymbolTable.getBase(newBase).right.get.iri.value.equals(MemorySymbolTable.DEFAULT_BASE))

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    assert(!MemoryErrorHandler.hasWarnings)
  }

  test("Check that the default source file is correct") {
    assert(MemorySymbolTable.DEFAULT_SOURCE_FILE.equals("memsys.table"))
  }

  test("Check that the base can be set") {
    MemorySymbolTable.setBase(newBase, base)
    assert(MemorySymbolTable.getBase(newBase).right.get equals base)

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    assert(!MemoryErrorHandler.hasWarnings)
  }

  test("Check that the base cannot be set to a null reference") {
    MemorySymbolTable.setBase(newBase,null)
    assert(MemoryErrorHandler.hasErrors)
  }

  test("Check that the base can only be changed once") {
    val nWarnings = MemoryErrorHandler.warnings.size

    MemorySymbolTable.setBase(newBase,base)
    assert(MemorySymbolTable.getBase(newBase).right.get equals base)

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    //assert(nWarnings equals MemoryErrorHandler.warnings.size)

    MemorySymbolTable.setBase(newBase, newBase)
    assert(!MemorySymbolTable.getBase(newBase).right.get.equals(newBase))

    // Check that there are no errors nor warnings.
    assert(MemoryErrorHandler.hasErrors)
    //assert(nWarnings equals MemoryErrorHandler.warnings.size+2)
  }

  test("Check that the start variable has a correct default value") {
    assert(MemorySymbolTable.getStart(newBase).isLeft)
  }

  test("Check that the start variable can be set") {
    MemorySymbolTable.setStart(newBase, new StartDeclaration("test", 4,4,null))
    assert(MemorySymbolTable.getStart(newBase).getOrElse(null).filename equals "test")
  }

  test("Check that the start variable cannot be set to null") {
    assert(MemorySymbolTable.setStart(newBase, null).isLeft)
    println(MemorySymbolTable.setStart(newBase, null))
    assert(MemoryErrorHandler.hasErrors)
  }

  test("Check that the start variable cannot be override") {
    MemorySymbolTable.setStart(newBase, new StartDeclaration("test", 4,4,null))
    assert(MemorySymbolTable.getStart(newBase).getOrElse(null).filename equals "test")

    MemorySymbolTable.setStart(newBase, new StartDeclaration("test", 4,4,null))
    assert(MemoryErrorHandler.hasErrors)
  }

  test("Check that the override a prefix generates an error") {
    assert(MemorySymbolTable.insert(newBase, prefix).isRight)
    assert(MemorySymbolTable.insert(newBase, newPrefix).isLeft)

    // Check that the change is correct.
    assert(MemorySymbolTable.getPrefix(newBase, prefix.name).isRight)
    assert(MemorySymbolTable.getPrefix(newBase, newPrefix.name).isRight)

    // Check that there is errors and warnings.
    assert(MemoryErrorHandler.hasErrors)
  }

  test("Check that override a shape generates an error") {
    assert(MemorySymbolTable.insert(newBase, shape).isRight)
    assert(MemorySymbolTable.insert(newBase, shape).isLeft)

    // Check that the change is not done.
    assert(MemorySymbolTable.getShape(newBase, shape.name.content).isRight)
    assert(MemorySymbolTable.getShape(newBase, shape.name.content).isRight)

    // Check that there is errors and warnings.
    assert(MemoryErrorHandler.hasErrors)
  }

  test("Check that a prefix cannot be retrieved from an empty prefix name") {
    assert(MemorySymbolTable.getPrefix(base, null).isLeft)
    assert(MemorySymbolTable.getPrefix(base, "").isLeft)
  }

  test("Check that retrieving a non existing prefix raises an error") {
    assert(MemorySymbolTable.getPrefix(base, "NonExistingPrefix").isLeft)
  }

  test("Check that retrieving a non existing shape raises an error") {
    assert(MemorySymbolTable.getShape(base, "NonExistingShape").isLeft)
  }

  test("Check that an existing shape can be retrieved") {
    assert(MemorySymbolTable.insert(shape, shape).isRight)
    assert(MemorySymbolTable.getShape(shape, shape.name.content).isRight)
  }

  test("Check that a shape cannot be retrieved from an empty shape name") {
    assert(MemorySymbolTable.getShape(shape, null).isLeft)
    assert(MemorySymbolTable.getShape(shape, "").isLeft)
  }
}
