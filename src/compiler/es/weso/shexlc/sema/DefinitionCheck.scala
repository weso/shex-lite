//------------------------------------------------------------------------------
// File: DefinitionCheck.scala
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

package es.weso.shexlc.sema

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.Err
import es.weso.shexlc.parse.ast.stmt._
import es.weso.shexlc.parse.ast.visitor._
import wvlet.log.LogSupport

class DefinitionCheck(ccontext: CompilationContext)
    extends ASTDefaultVisitor[Unit]
    with LogSupport {

  // Log message
  debug("creating a new definition checker")

  // Create an alias for the symbol table in order to keep things clean.
  private[this] val symbolTable = ccontext.getSymbolTable

  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    debug("checking a base definition from the definition checker")

    // Store the value of the base that might exists in the symbol table.
    val stBase = symbolTable.find(BaseDefStmt.DEFAULT_LABEL)

    // 1. Has the base been set previously
    if (stBase.isDefined) {

      // Log the action.
      debug("the base is already defined in the symbol table")

      // Store the value of the definedBase.
      val definedBase = stBase.get.getContent.get.asBaseDefStmt

      // Override for base is not allowed.
      ccontext.getErrorHandler.addEvent(new Err(
        stmt,
        s"this base definition overrides the previous one " +
        s"(${definedBase.getLine}:${definedBase.getColumn}) with value " +
        s"${definedBase.expression.asLiteralIRIValueExpr.value}",
        Err.BaseOverride
      ))
    } else {
      // If we enter this branch means that the base is not defined and therefore we can do the
      // action.
      debug("the base is not defined in the symbol table, inserting the base definition")
      symbolTable.insert(BaseDefStmt.DEFAULT_LABEL, stmt)
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    debug("checking a prefix definition from the definition checker")

    // Store the value of the prefix that might exists in the symbol table.
    val stPrefix = symbolTable.find(stmt.label)

    // Does the prefix exists in the symbol table?
    if (stPrefix.isDefined) {
      debug(s"the prefix `$stPrefix` is already defined in the symbol table")

      val existingPrefix = stPrefix.get.getContent.get.asPrefixDefStmt

      ccontext.getErrorHandler.addEvent(new Err(
        stmt,
        s"this prefix " + s"definition overrides the previous one " +
        s"(${existingPrefix.getLine}:${existingPrefix.getColumn}) with value " +
        s"${existingPrefix.expression.asLiteralIRIValueExpr.value}",
        Err.PrefixOverride
      ))
    } else {
      debug("the prefix is not defined in the symbol table, inserting the prefix definition.")
      symbolTable.insert(stmt.label, stmt)
    }

    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ShapeDefStmt, param: Unit): Unit = {
    debug("checking a shape definition from the definition checker")

    // Store the value of the shape that might exists in the symbol table.
    var stShape = Option.empty[es.weso.shexlc.internal.symbols.Symbol]
    var label   = ""

    val isRelativeShape = stmt.label.isCallBaseExpr

    if (isRelativeShape) {
      debug("relative shape")
      stShape = symbolTable.find(stmt.label.asCallBaseExpr.argument)
      label   = "base:" + stmt.label.asCallBaseExpr.argument
    } else {
      debug("non relative shape")
      stShape = symbolTable
        .find(stmt.label.asCallPrefixExpr.label + ':' + stmt.label.asCallPrefixExpr.argument)
      label = stmt.label.asCallPrefixExpr.label + ':' + stmt.label.asCallPrefixExpr.argument
    }

    // 1. Does the symbol table contains the shape?
    if (stShape.isDefined) {
      debug("shape defined in the symbol table")
      val existingShape = stShape.get.getContent.get.asShapeDefStmt

      ccontext.getErrorHandler.addEvent(new Err(
        stmt.label,
        s"this shape " + s"definition overrides the previous one " +
        s"(${existingShape.getLine}:${existingShape.getColumn})",
        Err.ShapeOverride
      ))
    } else {
      debug("shape not defined in the symbol table, inserting it")
      symbolTable.insert(label, stmt)
    }

    debug("propagating action from shape definition in definition checker")
    stmt.label.accept(this, param)
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    val stStart       = symbolTable.find(StartDefStmt.DefaultLabel)
    var cause: String = ""

    // Has been already set?
    if (stStart.isDefined) {
      val existingstart = stStart.get.getContent.get.asStartDefStmt
      if (stmt.expression.asCallShapeExpr.label.isCallBaseExpr) {
        cause = s"this start definition overrides the previous one " + s"" +
          s"(${existingstart.getLine}:${existingstart.getColumn})" + s" " + s"with value " +
          s"${existingstart.expression.asCallShapeExpr.label.asCallBaseExpr.argument}:"
      } else {
        cause = s"this start definition overrides the previous one " + s"" +
          s"(${existingstart.getLine}:${existingstart.getColumn})" + s" " + s"with value " +
          s"${existingstart.expression.asCallShapeExpr.label.asCallPrefixExpr.label}:" +
          s"${existingstart.expression.asCallShapeExpr.label.asCallPrefixExpr.argument}"
      }

      ccontext.getErrorHandler.addEvent(new Err(stmt, cause, Err.StartOverride))
    } else { symbolTable.insert(StartDefStmt.DefaultLabel, stmt) }
    stmt.expression.accept(this, param)
  }
}
