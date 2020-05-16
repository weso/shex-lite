//------------------------------------------------------------------------------
// File: SymbolHashTable.scala
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

import java.util.Objects

import com.typesafe.scalalogging.Logger
import es.weso.shexlc.parse.ast.expr.LiteralIRIValueExpr
import es.weso.shexlc.parse.ast.stmt._
import es.weso.shexlc.parse.ast.Position
import org.antlr.v4.runtime.misc.Interval

import scala.collection.mutable.HashMap

/**
  * Represents the data structure that holds the data used by the compiler
  * during the validation process. By default and
  * after https://github.com/weso/shex-lite-evolution/pull/16 the default
  * behaviour for all declarations is that no
  * redefinition is allowed. That way the language will be kept clean.
  *
  * @author Guillermo Facundo Colunga
  */
class DefaultSymbolTable extends SymbolTable {

  // Default logger
  final val logger = Logger[DefaultSymbolTable]

  // Auxiliary data structures used to store prefixes and shapes.
  final val _prefixesTable =
    new HashMap[String, Symbol[PrefixDefStmt]]()
  final val _shapesTable = new HashMap[String, Symbol[ShapeDefStmt]]()

  // Initial base and start definitions.
  private var _base = new DefaultSymbol[BaseDefStmt](
    new BaseDefStmt(
      Position.HOME,
      new Interval(0, 0),
      "base = <es.weso.shexlc" +
      ".internal://base>",
      new LiteralIRIValueExpr(
        Position.HOME,
        new Interval(0, 0),
        "<es.weso.shexlc.internal://base>",
        DEFAULT_BASE
      )
    )
  )

  private var _start: DefaultSymbol[StartDefStmt] = _ // The start
  // declaration initially has no value.
  override def getBase: BaseDefStmt = {
    _base.addOneCall()
    _base.content
  }

  override def setBase(base: BaseDefStmt): Unit =
    _base = new DefaultSymbol[BaseDefStmt](base)

  override def getNumberOfCallsForBase: Int = _base.getNumberOfCalls

  override def getStart: StartDefStmt = {
    if (Objects.isNull(_start)) {
      null
    } else {
      _start.addOneCall()
      _start.content
    }
  }

  override def setStart(start: StartDefStmt): Unit =
    _start = new DefaultSymbol[StartDefStmt](start)

  override def +=(prefixDef: PrefixDefStmt): Unit =
    _prefixesTable.put(
      prefixDef.label,
      new DefaultSymbol[PrefixDefStmt](prefixDef)
    )

  override def +=(shapeDef: ShapeDefStmt): Unit = {
    val isRelativeShape = shapeDef.label.isCallBaseExpr
    if (isRelativeShape) {
      _shapesTable.put(
        s"$DEFAULT_BASE:${shapeDef.label.asCallBaseExpr.argument}",
        new DefaultSymbol[ShapeDefStmt](shapeDef)
      )
    } else {
      _shapesTable.put(
        s"${shapeDef.label.asCallPrefixExpr.label}:${shapeDef.label.asCallPrefixExpr.argument}",
        new DefaultSymbol[ShapeDefStmt](shapeDef)
      )
    }
  }

  override def getPrefix(prefixLbl: String): PrefixDefStmt =
    _prefixesTable
      .get(prefixLbl) match {
      case None => null
      case Some(element) => {
        element.addOneCall()
        element.getContent
      }
    }

  override def getNumberOfCallsForPrefix(prefixLbl: String): Int =
    _prefixesTable.get(prefixLbl) match {
      case None =>
        throw new IllegalStateException(
          s"the prefix label " +
          s"$prefixLbl is not in the symbol table"
        )
      case Some(element) => element.getNumberOfCalls
    }

  override def getShape(prefixLbl: String, shapeLbl: String): ShapeDefStmt =
    _shapesTable.get(s"$prefixLbl:$shapeLbl") match {
      case None => null
      case Some(element) => {
        element.addOneCall()
        element.getContent
      }
    }

  def restore(): Unit = {
    _base = new DefaultSymbol[BaseDefStmt](
      new BaseDefStmt(
        Position.HOME,
        new Interval(0, 0),
        "base = <es.weso.shexlc.internal://base>",
        new LiteralIRIValueExpr(
          Position.HOME,
          new Interval(0, 0),
          "<es.weso" +
          ".shexlc.internal://base>",
          DEFAULT_BASE
        )
      )
    )
    _start = null
    _prefixesTable.clear()
    _shapesTable.clear()
  }
}
