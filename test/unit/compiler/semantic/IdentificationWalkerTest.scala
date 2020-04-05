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

import java.util.Objects

import com.typesafe.scalalogging.Logger
import compiler.ast.{ASTNode, ASTWalker}
import compiler.internal.{MemoryErrorHandler, MemorySymbolTable}
import compiler.semantic.{IdentificationWalker, MemoryErrorHandler}
import compiler.syntactic.ShExLSyntacticParser
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class IdentificationWalkerTest extends AnyFunSuite with BeforeAndAfter {

  final val logger = Logger[IdentificationWalkerTest]

  // In order to be sure that on each test case we do not have data from previous tests.
  after {
    logger.debug("Restoring memory symbol table.")
    MemorySymbolTable.restore()

    logger.debug("Restoring memory error handler.")
    MemoryErrorHandler.restore()
  }

  /**
   * By default the redefinition ob a base is not allowed. Therefore if the identification walker detects this case
   * should delegate in the symbol table the creation of an error.
   */
  test("Check that a base redefinition is detected by the identification walker") {

    // Parsing a sample file that contains a base redefinition.
    val ast = new ShExLSyntacticParser("test/assets/incorrect_schema_using_base_redefinition_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here the error should be generated.
    ast.walk(new IdentificationWalker(), null)

    // Check that the error have been generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(MemoryErrorHandler.hasErrors)
  }

  /**
   * A base definition that is correctly defined in a schema should be identified by the identification walker, added
   * to the corresponding symbol table and no errors should be generated.
   */
  test("Check that a base declaration is detected by the identification walker") {

    // Parsing a sample file that contains a base definition.
    val ast = new ShExLSyntacticParser("test/assets/correct_schema_using_base_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here no error should be generated.
    ast.walk(new IdentificationWalker(), null)

    // Check that no errors where generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Check that the base value in the symbol table is right.
    assert(MemorySymbolTable.getBase(null).isRight)

    // Check that the actual value of the base in the symbol table has been updated.
    assert(!MemorySymbolTable.getBase(null).getOrElse(null).iri.value.equals(MemorySymbolTable.DEFAULT_BASE))
  }

  /**
   * By default the redefinition of an start is not allowed. Therefore if the identification walker detects this case
   * should delegate in the symbol table the creation of an error.
   */
  test("Check that an start redefinition is detected by the identification walker") {
    // Parsing a sample file that contains an start redefinition.
    val ast = new ShExLSyntacticParser("test/assets/incorrect_schema_using_start_redefinition_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here the error should be generated.
    ast.walk(new IdentificationWalker(), null)

    // Check that the error have been generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(MemoryErrorHandler.hasErrors)
  }

  /**
   * An start definition that is correctly defined in a schema should be identified by the identification walker, added
   * to the corresponding symbol table and no errors should be generated.
   */
  test("Check that an start declaration is detected by the identification walker") {

    // Parsing a sample file that contains a single start definition.
    val ast = new ShExLSyntacticParser("test/assets/correct_schema_using_start_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here no error should be generated.
    ast.walk(new IdentificationWalker(), null)

    // Check that no errors where generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Check that the start value in the symbol table is right.
    assert(MemorySymbolTable.getStart(null).isRight)

    // Check that the actual value of the start in the symbol table has been updated and therefore is not null.
    assert(Objects.nonNull(MemorySymbolTable.getStart(null).getOrElse(null)))
  }

  /**
   * By default the redefinition of a prefix is not allowed. Therefore if the identification walker detects this case
   * should delegate in the symbol table the creation of an error.
   */
  test("Check that a prefix redefinition is detected by the identification walker") {

    // Parsing a sample file that contains a prefix redefinition.
    val ast = new ShExLSyntacticParser("test/assets/incorrect_schema_using_prefix_redefinition_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here the error should be generated.
    ast.walk(new IdentificationWalker(), null)

    // Check that the error have been generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(MemoryErrorHandler.hasErrors)
  }

  /**
   * An prefix definition that is correctly defined in a schema should be identified by the identification walker, added
   * to the corresponding symbol table and no errors should be generated.
   */
  test("Check that a prefix declaration is detected by the identification walker") {

    // Parsing a sample file that contains a single start definition.
    val ast = new ShExLSyntacticParser("test/assets/correct_schema_using_prefix_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here no error should be generated.
    ast.walk(new IdentificationWalker(), null)

    // Check that no errors where generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Check that the prefix value in the symbol table is right.
    assert(MemorySymbolTable.getPrefix(null, "xsd").isRight)
  }

  /**
   * By default the redefinition of a shape is not allowed. Therefore if the identification walker detects this case
   * should delegate in the symbol table the creation of an error.
   */
  test("Check that a shape redefinition is detected by the identification walker") {

    // Parsing a sample file that contains a prefix redefinition.
    val ast = new ShExLSyntacticParser("test/assets/incorrect_schema_using_shape_redefinition_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here the error should be generated.
    ast.walk(new IdentificationWalker(), null)

    // Check that the error have been generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(MemoryErrorHandler.hasErrors)
  }

  /**
   * An shape definition that is correctly defined in a schema should be identified by the identification walker, added
   * to the corresponding symbol table and no errors should be generated.
   */
  test("Check that a shape declaration is detected by the identification walker") {

    // Parsing a sample file that contains a single start definition.
    val ast = new ShExLSyntacticParser("test/assets/correct_schema_using_shape_1.shexl").parse()

    // Initially should not be any errors.
    logger.debug(s"Memory Error Handler values before identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Then we walk the AST and here no error should be generated.
    ast.walk(new IdentificationWalker(), null)

    // Check that no errors where generated.
    logger.debug(s"Memory Error Handler values after identification visitor: [${MemoryErrorHandler.toString()}].")
    assert(!MemoryErrorHandler.hasErrors)

    // Check that the prefix value in the symbol table is right.
    assert(MemorySymbolTable.getShape(null, ":User").isRight)
  }
}