package compiler

import java.util.Objects

import compiler.ast.{BaseDeclaration, IRILiteral, PrefixDeclaration, ShapeInvocation, StartDeclaration}
import compiler.semantic.{MemoryErrorHandler, MemorySymbolTable}
import org.scalatest.funsuite.AnyFunSuite

class MemorySymbolTableUnitTest extends AnyFunSuite {

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


  // Test Cases.

  test("Check that the default base is correct") {
    assert(MemorySymbolTable.getBase.get.iri.value equals "<internal>")

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    assert(!MemoryErrorHandler.hasWarnings)
  }

  test("Check that the base can be set") {
    MemorySymbolTable.setBase(base)
    assert(MemorySymbolTable.getBase.get equals base)

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    assert(!MemoryErrorHandler.hasWarnings)
  }

  test("Check that the base can be changed and no errors/warnings are generated") {
    val nWarnings = MemoryErrorHandler.warnings.size

    MemorySymbolTable.setBase(base)
    assert(MemorySymbolTable.getBase.get equals base)

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    //assert(nWarnings equals MemoryErrorHandler.warnings.size)

    MemorySymbolTable.setBase(newBase)
    assert(MemorySymbolTable.getBase.get equals newBase)

    // Check that there are no errors nor warnings.
    assert(!MemoryErrorHandler.hasErrors)
    //assert(nWarnings equals MemoryErrorHandler.warnings.size+2)
  }

  test("Check that the start variable has a correct default value") {
    println(MemorySymbolTable.getStart())
    assert(MemorySymbolTable.getStart().isLeft)
  }

  test("Check that the start variable can be set") {
    MemorySymbolTable.setStart(new StartDeclaration("test", 4,4,null))
    assert(MemorySymbolTable.getStart().getOrElse(null).filename equals "test")
  }

  test("Check that the override a prefix generates a warning") {
    assert(MemorySymbolTable.insert(prefix).isRight)
    assert(MemorySymbolTable.insert(newPrefix).isLeft)

    // Check that the change is correct.
    assert(MemorySymbolTable.getPrefix(prefix.name).isRight)
    assert(MemorySymbolTable.getPrefix(newPrefix.name).isRight)

    // Check that there is errors and warnings.
    assert(MemoryErrorHandler.hasErrors)
    assert(MemoryErrorHandler.hasWarnings)
  }
}
