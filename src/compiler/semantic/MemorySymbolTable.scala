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

import java.util.Objects

import com.typesafe.scalalogging.Logger
import compiler.ast
import compiler.ast.{ASTNode, BaseDeclaration, IRILiteral, PrefixDeclaration, ShapeDeclaration, StartDeclaration}
import compiler.syntactic.ShExLSyntacticParser

import scala.collection.mutable.HashMap

object MemorySymbolTable extends SymbolTable {

  // Default logger
  final val logger = Logger[ShExLSyntacticParser]

  // Default values.
  final val DEFAULT_BASE = "<internal>"
  final val DEFAULT_SOURCE_FILE = "memsys.table"

  // Auxiliary data structures used to store prefixes and shapes.
  private final val _prefixesTable = new HashMap[String, PrefixDeclaration]()
  private final val _shapesTable = new HashMap[String, ShapeDeclaration]()

  // Initial base and start definitions.
  private var _base = new BaseDeclaration(DEFAULT_SOURCE_FILE, 0,0,
    new IRILiteral(DEFAULT_SOURCE_FILE, 0, 0, DEFAULT_BASE))

  private var _start: StartDeclaration = null // The start declaration initially has no value.

  /**
   * Sets the value of the base. The base is the default iri that will be referenced from the relative iris of the
   * schema. Notice that this method should be only called once, after it should produce an error as no redefinition
   * is allowed.
   *
   * @param base is the value that will be set as the base.
   * @return either an error if the base was already set or the new base declaration if it is the first time the method
   *         is called.
   */
  override def setBase(requester:ASTNode, base: BaseDeclaration): Either[ast.Error, BaseDeclaration] = {
    logger.debug(s"Setting the value of a base. Requester [$requester]. Value [$base]")
    if(!_base.iri.value.equals(DEFAULT_BASE)) {
      // 1. Check if the existing base declaration is different from the default, if it is then should not be changed.
      logger.error("Base redefinition attempt.")
      Left(new ast.Error(base, -1, "Base redefinition is not allowed."))
    } else if(Objects.isNull(base)) {
      // 2. Check the integrity of the new reference.
      logger.error("New value for the base is a null reference.")
      Left(new ast.Error(requester, -1, "Null reference detected."))
    } else {
      // 3. If pass all previous checks then the base can be changed.
      logger.debug("Changing the value of the base.")
      _base = base
      Right(_base)
    }
  }

  /**
   * Gets the base declaration. If the base declaration does not even exists internally by some reason an error will be
   * returned. Else the value set as the base declaration will be returned.
   *
   * @param requester is the ast node that request access to the base declaration.
   * @return either an error if the base does not even exists internally or the base declaration.
   */
  override def getBase(requester: ASTNode): Either[ast.Error, BaseDeclaration] = {
    if(Objects.isNull(_base)) {
      // If by some reason the base reference is broken.
      logger.error("The stored value of the base is null.")
      Left(new ast.Error(requester, -1, "Null reference detected. Accessing to a non existing base."))
    } else {
      // If there exists a base just return it.
      logger.debug(s"Seding the value of the base to requester [$requester]")
      Right(_base)
    }
  }

  /**
   * Sets the value for the start declaration. The start is a pointer to a shape definition that will be use at
   * validation time. It indicates the validator which is the default shape definition to use in case no other shape
   * reference is set in the corresponding shape-map. Notice that this method should be only called once as the
   * redefinition is not allowed.
   *
   * @param start is the value that will be set as the start.
   * @return either an error if the start parameter is not valid or is trying to redefine the start. Or the start
   *         declaration set as new value.
   */
  override def setStart(requester:ASTNode, start: StartDeclaration): Either[ast.Error, StartDeclaration] = {
    if(Objects.nonNull(_start)) {
      // 1. Check if the base has been already set, if yes then should not be changed.
      Left(new ast.Error(start, -1, "Start redefinition is not allowed."))
    } else if(Objects.isNull(start)) {
      // 2. Check the integrity of the new reference.
      Left(new ast.Error(requester, -1, "Null reference detected."))
    } else {
      // 3. If pass all previous checks then the start can be changed.
      _start = start
      Right(_start)
    }
  }

  /**
   * Gets the start declaration. If no start declaration exists in the schema then will return a compiler error.
   *
   * @param requester is the ast node that request access to the start declaration.
   * @return either the start declaration or an error if no start declaration exists in the schema.
   */
  override def getStart(requester: ASTNode): Either[ast.Error, StartDeclaration] = {
    if(Objects.isNull(_start)) {
      // If by some reason the start reference is broken.
      Left(new ast.Error(requester, -1, "Null reference detected. Accessing to a non existing start."))
    } else {
      // If there exists an start just return it.
      Right(_start)
    }
  }

  /**
   * Stores a prefix declaration in the data structure for future references. Prefix redefinition is not allowed,
   * therefore if a prefix declaration attempts to override a previous value a compiler error will be raised. Otherwise
   * the value stored will be returned.
   *
   * @param prefixDef is the prefix definition to be stored. Must be unique, otherwise an error will be thrown.
   * @return if a prefix declaration attempts to override a previous value a compiler error will be raised. Otherwise
   *         the value stored will be returned.
   */
  override def insert(requester:ASTNode, prefixDef: PrefixDeclaration): Either[ast.Error, PrefixDeclaration] = {
    if(Objects.isNull(prefixDef)) {
      // 1. If the prefix reference to insert is null raise an error.
      Left(new ast.Error(null, -1, "Null reference detected."))
    } else if(_prefixesTable.contains(prefixDef.name)) {
      // 2. If the table has already an entry for the given prefix definition raise an error.
      Left(new ast.Error(prefixDef, -1, "Prefix redefinition is not allowed."))
    } else {
      // 3. If previous checks passed then store the prefix definition in the table.
      _prefixesTable.put(prefixDef.name, prefixDef)
      Right(prefixDef)
    }
  }

  /**
   * Stores a shape declaration in the data structure for future references. Shape redefinition is not allowed,
   * therefore if a shape declaration attempts to override a previous value a compiler error will be raised. Otherwise
   * the value stored will be returned.
   *
   * @param shapeDef is the shape definition to be stored. Must be unique, otherwise an error will be thrown.
   * @return if a shape declaration attempts to override a previous value a compiler error will be raised. Otherwise
   *         the value stored will be returned.
   */
  override def insert(requester:ASTNode, shapeDef: ShapeDeclaration): Either[ast.Error, ShapeDeclaration] = {
    if(Objects.isNull(shapeDef)) {
      // 1. If the prefix reference to insert is null raise an error.
      Left(new ast.Error(null, -1, "Null reference detected."))
    } else if(_shapesTable.contains(shapeDef.name.content)) {
      // 2. If the table has already an entry for the given prefix definition raise an error.
      Left(new ast.Error(shapeDef, -1, "Shape redefinition is not allowed."))
    } else {
      // 3. If previous checks passed then store the prefix definition in the table.
      _shapesTable.put(shapeDef.name.content, shapeDef)
      Right(shapeDef)
    }
  }

  /**
   * Gets the prefix declaration indexed by its prefix name. If no prefix is found indexed by that prefix name a
   * compiler error will be raised.
   *
   * @param requester is the ast node that request access to the prefix declaration.
   * @param prefixName is the key that will be used to look for the prefix definition in the persistence.
   * @return either the prefix declaration indexed at the prefix name key or an error otherwise.
   */
  override def getPrefix(requester:ASTNode, prefixName: String): Either[ast.Error, PrefixDeclaration] = {
    if(Objects.isNull(prefixName) || prefixName.isEmpty) {
      // 1. Check if the prefix to look for does even have an acceptable shape.
      Left(new ast.Error(requester, -1, "Cannot access null-empty prefixes."))
    } else if(!_prefixesTable.contains(prefixName)) {
      // 2. Check if the prefix is stored in the table.
      Left(new ast.Error(requester, -1, "The prefix has not been defined."))
    } else {
      Right(_prefixesTable.get(prefixName).get)
    }
  }

  /**
   * Gets the shape declaration indexed by its shape name. If no shape is found indexed by that shape name a
   * compiler error will be raised.
   *
   * @param requester is the ast node that request access to the shape declaration.
   * @param shapeName is the key that will be used to look for the shape definition in the persistence.
   * @return either the shape declaration indexed at the shape name key or an error otherwise.
   */
  override def getShape(requester: ASTNode, shapeName: String): Either[ast.Error, ShapeDeclaration] = {
    if(Objects.isNull(shapeName) || shapeName.isEmpty) {
      // 1. Check if the prefix to look for does even have an acceptable shape.
      Left(new ast.Error(requester, -1, "Cannot access null-empty shapes."))
    } else if(!_shapesTable.contains(shapeName)) {
      // 2. Check if the prefix is stored in the table.
      Left(new ast.Error(requester, -1, "The shape has not been defined."))
    } else {
      Right(_shapesTable.get(shapeName).get)
    }
  }

  /**
   * For mocking this method is added. It restores the symbol table to default values.
   */
  private[compiler] def restore(): Unit = {

    // To be changed by a correct logging library.
    println("Restoring symbol table to defaults.")

    _shapesTable.clear()
    _prefixesTable.clear()
    _start = null
    _base = new BaseDeclaration(DEFAULT_SOURCE_FILE, 0,0,
      new IRILiteral(DEFAULT_SOURCE_FILE, 0, 0, DEFAULT_BASE))
  }
}
