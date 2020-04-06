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

package compiler.internal.symboltable

import java.util.Objects

import com.typesafe.scalalogging.Logger
import compiler.ast._
import compiler.internal.error.{BaseNotFoundErr, ErrType, NullReferenceErr, PrefixNotFoundErr, ShapeOverrideErr}
import compiler.internal.symboltable.policy.SymbolTablePolicy
import compiler.syntactic.ShExLSyntacticParser

import scala.collection.mutable.HashMap


private[compiler] class SymbolHashTable(val policy: SymbolTablePolicy) extends SymbolTable {

  // Default logger
  final val logger = Logger[ShExLSyntacticParser]

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
   * @param base      is the value that will be set as the base.
   * @return either an error if the base was already set or the new base declaration if it is the first time the method
   *         is called.
   */
  override def setBase(base: BaseDeclaration): Either[ErrType, BaseDeclaration] = base match {
    case null => Left(NullReferenceErr)
    case _ => {
      policy.projectInsertAction(this, base) match {
        case Some(error) => Left(error)
        case None => _base = base; Right(_base)
      }
    }
  }

  /**
   * Gets the base declaration. If the base declaration does not even exists internally by some reason an error will be
   * returned. Else the value set as the base declaration will be returned.
   *
   * @return either an error if the base does not even exists internally or the base declaration.
   */
  override def getBase: Either[ErrType, BaseDeclaration] = _base match {
    case null => Left(BaseNotFoundErr)
    case _ => Right(_base)
  }

  /**
   * Sets the value for the start declaration. The start is a pointer to a shape definition that will be use at
   * validation time. It indicates the validator which is the default shape definition to use in case no other shape
   * reference is set in the corresponding shape-map. Notice that this method should be only called once as the
   * redefinition is not allowed.
   *
   * @param start     is the value that will be set as the start.
   * @return either an error if the start parameter is not valid or is trying to redefine the start. Or the start
   *         declaration set as new value.
   */
  override def setStart(start: StartDeclaration): Either[ErrType, StartDeclaration] = start match {
    case null => Left(NullReferenceErr)
    case _ => {
      policy.projectInsertAction(this, start) match {
        case Some(error) => Left(error)
        case None => _start = start; Right(_start)
      }
    }
  }

  /**
   * Gets the start declaration. If no start declaration exists in the schema then will return a compiler error.
   *
   * @return either the start declaration or an error if no start declaration exists in the schema.
   */
  override def getStart: Either[ErrType, StartDeclaration] =  _start match {
    case null => Left(BaseNotFoundErr)
    case _ => Right(_start)
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
  override def +=(prefixDef: PrefixDeclaration): Either[ErrType,  Option[PrefixDeclaration]] = prefixDef match {
    case null => Left(NullReferenceErr)
    case _ => {
      policy.projectInsertAction(this, prefixDef) match {
        case Some(error) => Left(error)
        case None => Right(_prefixesTable.put(prefixDef.name, prefixDef))
      }
    }
  }

  /**
   * Stores a shape declaration in the data structure for future references. Shape redefinition is not allowed,
   * therefore if a shape declaration attempts to override a previous value a compiler error will be raised. Otherwise
   * the value stored will be returned.
   *
   * @param shapeDef  is the shape definition to be stored. Must be unique, otherwise an error will be thrown.
   * @return if a shape declaration attempts to override a previous value a compiler error will be raised. Otherwise
   *         the value stored will be returned.
   */
  override def +=(shapeDef: ShapeDeclaration): Either[ErrType, Option[ShapeDeclaration]] = shapeDef match {
    case null => Left(NullReferenceErr)
    case _ => policy.projectInsertAction(this, shapeDef) match {
        case Some(error) => Left(error)
        case None => Right(_shapesTable.put(shapeDef.getShapeLabel, shapeDef))
    }
  }

  /**
   * Gets the prefix declaration indexed by its prefix name. If no prefix is found indexed by that prefix name a
   * compiler error will be raised.
   *
   * @param prefixName is the key that will be used to look for the prefix definition in the persistence.
   * @return either the prefix declaration indexed at the prefix name key or an error otherwise.
   */
  override def getPrefix(prefixName: String): Either[ErrType, PrefixDeclaration] = {
    if(Objects.isNull(prefixName)) {
      // 1. Check if the prefix to look for does even have an acceptable shape.
      Left(NullReferenceErr)
    } else if(!_prefixesTable.contains(prefixName)) {
      // 2. Check if the prefix is stored in the table.
      Left(PrefixNotFoundErr)
    } else {
      Right(_prefixesTable.get(prefixName).get)
    }
  }

  /**
   * Gets the shape declaration indexed by its shape name. If no shape is found indexed by that shape name a
   * compiler error will be raised.
   *
   * @param shapeName is the key that will be used to look for the shape definition in the persistence.
   * @return either the shape declaration indexed at the shape name key or an error otherwise.
   */
  override def getShape(shapeName: String): Either[ErrType, ShapeDeclaration] = {
    if(Objects.isNull(shapeName) || shapeName.isEmpty) {
      // 1. Check if the prefix to look for does even have an acceptable shape.
      Left(NullReferenceErr)
    } else if(!_shapesTable.contains(shapeName)) {
      // 2. Check if the prefix is stored in the table.
      Left(ShapeOverrideErr)
    } else {
      Right(_shapesTable.get(shapeName).get)
    }
  }

  private[compiler] def restore(): Unit = {
    _base = new BaseDeclaration(DEFAULT_SOURCE_FILE, 0,0,
      new IRILiteral(DEFAULT_SOURCE_FILE, 0, 0, DEFAULT_BASE))
    _start = null
    _prefixesTable.clear()
    _shapesTable.clear()
  }
}
