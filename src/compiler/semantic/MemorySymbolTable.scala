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

import compiler.ast.{ASTNode, ASTWalker, BaseDeclaration, Error, IRILiteral, PrefixDeclaration, ShapeDeclaration, StartDeclaration, Warning}

import scala.collection.mutable.HashMap

object MemorySymbolTable extends SymbolTable {

  val prefixesTable = new HashMap[String, PrefixDeclaration]()
  val shapesTable = new HashMap[String, ShapeDeclaration]()
  /**
   * The base default declaration.
   */
  private var _base: BaseDeclaration = new BaseDeclaration("memsym.table", 6, 3,
    new IRILiteral("memsym.table", 6, 3, "<internal>"))
  /**
   * The start default declaration. If not definied at the end will continue being null.
   */
  private var _start: StartDeclaration = null

  /**
   * Changes the base declaration to the one in the parameter.
   *
   * @param base to be set as the new base.
   * @return either a warning if the base was already set or the base declaration the first time.
   */
  override def setBase(base: BaseDeclaration): Either[Warning, BaseDeclaration] = {
    if (!_base.iri.value.equals("<internal>")) {
      val warn = new Warning(base, 2,
        s"Base declaration override detected. Overriding base at (${_base.filename}:${_base.line}:${_base.column}) " +
          s"with value (${_base.iri.value}) with base at (${base.filename}:${base.line}:${base.column}) with value (${base.iri.value})")
      MemoryErrorHandler.addWarning(warn)
      Left(warn)
    }
    this._base = base
    Right(_base)
  }

  /**
   * Sets the start declarations to the given one. If the start was already set an error is thrown.
   *
   * @param start to set as the start declaration.
   * @return either the start declaration or an error.
   */
  override def setStart(start: StartDeclaration): Either[Error, StartDeclaration] = {
    if (!Objects.isNull(_start)) {
      val err = new Error(start, 2,
        s"The start shape expression cannot be override. Start declaration at (${start.filename}:${start.line}:${start.column}) " +
          s"overrides previous start declaration from (${_start.filename}:${_start.line}:${_start.column})")
      MemoryErrorHandler.addError(err)
      Left(err)
    } else {
      this._start = start
      Right(this._start)
    }
  }

  /**
   * Inserts a prefix in the prefixes table, if it exists it will update its record.
   *
   * @param prefixDef is the prefix definition to be inserted.
   */
  override def insert(prefixDef: PrefixDeclaration): Either[Warning, PrefixDeclaration] = {
    if (prefixesTable contains prefixDef.name) {
      val prevDecl = prefixesTable.get(prefixDef.name).get

      // Throw warning.
      val warn = new Warning(prefixDef, 1,
        s"The prefix declaration found at (${prefixDef.filename}:${prefixDef.line}:${prefixDef.column} " +
          s"is overwriting the already existing prefix declaration from (${prevDecl.filename}:${prevDecl.line}:${prevDecl.column}). " +
          s"Previous IRI was (${prevDecl.iri.value}), new value is (${prefixDef.iri.value})")
      MemoryErrorHandler.addWarning(warn)
      prefixesTable.put(prefixDef.name, prefixDef)
      Left(warn)
    } else {
      // Prefixes can be override.
      prefixesTable.put(prefixDef.name, prefixDef)
      Right(prefixDef)
    }
  }

  /**
   * Inserts a shape in the shapes table, shapes definitions must be unique.
   *
   * @param shapeDef is the shape definition to be inserted.
   */
  override def insert(shapeDef: ShapeDeclaration): Either[Error, ShapeDeclaration] = {
    if (shapesTable contains shapeDef.name.content) {
      val prevShp = shapesTable.get(shapeDef.name.content).get
      // Throw error.
      val err = new Error(shapeDef, 1,
        s"Shapes declarations cannot be overwritten. Shape declaration at (${shapeDef.filename}:${shapeDef.line}:${shapeDef.column}) " +
          s"with label (${shapeDef.name.content}) is trying to override shape declaration at (${prevShp.filename}:${prevShp.line}:${prevShp.column}) " +
          s"with label (${prevShp.name.content})")
      MemoryErrorHandler.addError(err)
      Left(err)
    } else {
      shapesTable.put(shapeDef.name.content, shapeDef)
      Right(shapeDef)
    }
  }

  /**
   * Gets the prefix definition indexed at the given prefix name.
   *
   * @param prefixName is the prefix name to look for in the table.
   * @return is a option object that might contain the prefix definition.
   */
  override def getPrefix(prefixName: String): Either[Error, PrefixDeclaration] = {
    val valOnTable = prefixesTable.get(prefixName)
    if (valOnTable.isDefined) {
      Right(valOnTable.get)
    } else {
      // Throw error.
      val err = new Error(null, 2,
        s"Prefix ($prefixName) not defined. Prefix invocations must make reference to a defined prefix on " +
          s"the current scheme. You can add the prefix to your schema by adding 'PREFIX $prefixName: <the_prefix_iri>' " +
          s"to your source file.")

      MemoryErrorHandler.addError(err)
      Left(err)
    }
  }

  /**
   * Gets the shape definition indexed at the given shape name.
   *
   * @param shapeName is the prefix name to look for in the table.
   * @return is a option object that might contain the prefix definition.
   */
  override def getShape(shapeName: String): Either[Error, ShapeDeclaration] = {
    val valOnTable = shapesTable.get(shapeName)
    if (valOnTable.isDefined) {
      Right(valOnTable.get)
    } else {
      // Throw error.
      val err = new Error(null, 2,
        s"Shape ($shapeName) not defined. Shape invocations must make reference to a defined shape on " +
          s"the current scheme. You can add the shape to your schema by adding '$shapeName constraint' " +
          s"to your source file.")

      MemoryErrorHandler.addError(err)
      Left(err)
    }
  }

  def printSymbolTable(): Unit = {
    println(s"Base -> $getBase()")
    println(s"Start -> $getStart()")
    println("--- PREFIXES ---")
    prefixesTable.foreachEntry((k, v) => println(s"$k -> $v"))
    println("--- SHAPES ---")
    shapesTable.foreachEntry((k, v) => println(s"$k -> $v"))
  }

  /**
   * Gets the declaration attached to the base variable.
   *
   * @return the declaration attached to the base variable.
   */
  override def getBase(): Option[BaseDeclaration] = {
    Some(_base)
  }

  /**
   * Gets the start declaration.
   *
   * @return either the start declaration or an error if no start was declared.
   */
  override def getStart(): Either[Error, StartDeclaration] = {
    if (Objects.isNull(_start)) {
      val err = new Error(new ASTNode("", -1, -1) {
        /**
         * Helper method for the ast walkers.
         *
         * @param walker to walk over the AST node.
         * @tparam TP is the type of the parameter.
         * @tparam TR is the type of the return object.
         * @return an object o
         */
        override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = ???
      }, 3,
        s"No start declaration found. Add 'start = shape_reference' to your source code to fix it.")
      MemoryErrorHandler.addError(err)
      Left(err)
    } else {
      Right(_start)
    }
  }
}
