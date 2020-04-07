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

package compiler.semantic

import com.typesafe.scalalogging.Logger
import compiler.PAInvocationsCheckerWalkerTest
import compiler.ast.{BaseDeclaration, PrefixDeclaration, PrefixInvocation, ShapeDeclaration, ShapeInvocation, TripleExpressionConstraint}
import compiler.internal.error.MemoryErrorHandler
import compiler.internal.symboltable.SymbolHashTable
import compiler.internal.symboltable.policy.PassiveAggressiveSymbolTablePolicy
import compiler.syntactic.ShExLSyntacticParser
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class DefinitionsCheckerWalterTest extends AnyFunSuite with BeforeAndAfter {

  final val logger = Logger[DefinitionsCheckerWalterTest]

  final val st = new SymbolHashTable(PassiveAggressiveSymbolTablePolicy)

  // In order to be sure that on each test case we do not have data from previous tests.
  before {
    logger.debug("Restoring memory symbol table.")
    st.restore()

    logger.debug("Restoring memory error handler.")
    MemoryErrorHandler.restore()
  }

  after {
    logger.debug("Restoring memory symbol table.")
    st.restore()

    logger.debug("Restoring memory error handler.")
    MemoryErrorHandler.restore()
  }

  test("Check that a prefix invocation that exists does pass the checker") {

    // Parsing a sample file that contains a base redefinition.
    val ast = new ShExLSyntacticParser("test/assets/correct_schema_using_prefix_invocation_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here the error should be generated.
    ast.walk(new DefinitionsCheckerWalker(st), null)
    ast.walk(new InvocationsCheckerWalker(st), null)

    assert(st.getPrefix("").isRight)
    assert(st.getPrefix("xsd").isRight)
    assert(st.getShape("xsd:User").isRight)
    assert(st.getShape(":Person").isRight)
    assert(st.getShape("<Animal>").isRight)

    st.getShape("xsd:User") match {
      case Right(shape) => assert(shape.name.decl.asInstanceOf[PrefixDeclaration].name.equals("xsd"))
    }

    st.getShape(":Person") match {
      case Right(shape) => assert(shape.name.decl.asInstanceOf[PrefixDeclaration].name.equals(""))
    }

    st.getShape("<Animal>") match {
      case Right(shape) => assert(shape.name.decl.isInstanceOf[BaseDeclaration])
    }

    // Check that the error have been generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)
  }

  test("Check that a prefix invocation that does not exists does not pass the checker") {

    // Parsing a sample file that contains a base redefinition.
    val ast = new ShExLSyntacticParser("test/assets/incorrect_schema_using_non_existing_prefix_invocation_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here the error should be generated.
    ast.walk(new DefinitionsCheckerWalker(st), null)
    ast.walk(new InvocationsCheckerWalker(st), null)


    // Check that the error has been generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(MemoryErrorHandler.hasErrors)
  }

  test("Check that a shape invocation that exists does pass the checker") {

    // Parsing a sample file that contains a base redefinition.
    val ast = new ShExLSyntacticParser("test/assets/correct_schema_using_shape_invocation_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here the error should be generated.
    ast.walk(new DefinitionsCheckerWalker(st), null)
    ast.walk(new InvocationsCheckerWalker(st), null)

    assert(st.getStart.isRight)
    st.getStart match {
      case Right(start) => assert(start.ref.content.equals(":Person"))
    }

    st.getShape(":Person") match {
      case Left(_) => fail("The shape :Person must exists")
      case Right(shape) => assert(
        shape.constraint.asInstanceOf[TripleExpressionConstraint].constraints(0)
          .constraint.asInstanceOf[ShapeInvocation]
          .decl.asInstanceOf[ShapeDeclaration]
          .name.content.equals("<Car>")
      )
    }

    // Check that the error have been generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)
  }

  test("Check that a shape invocation that does not exists does not pass the checker") {

    // Parsing a sample file that contains a base redefinition.
    val ast = new ShExLSyntacticParser("test/assets/incorrect_schema_using_non_existing_shape_invocation_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here the error should be generated.
    ast.walk(new DefinitionsCheckerWalker(st), null)
    ast.walk(new InvocationsCheckerWalker(st), null)

    // Check that the error have been generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(MemoryErrorHandler.hasErrors)
    assert(MemoryErrorHandler.errors.size == 2)
  }

}
