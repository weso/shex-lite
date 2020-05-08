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

import java.util.Objects

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.{Err, ErrorHandler}
import es.weso.shexlc.parse.ast.stmt._
import es.weso.shexlc.parse.ast.visitor._

class DefinitionCheck(ccontext: CompilationContext)
    extends ASTDefaultVisitor[Unit] {

  //private[this] val ccontext.getErrorHandler: ErrorHandler = ccontext.getErrorHandler

  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    val existingSTValue =
      ccontext.getSymbolTable.getBase.expression.asLiteralIRIValueExpr.value
    // 1. Is the base the default one?
    if (existingSTValue.equals(ccontext.getSymbolTable.DEFAULT_BASE)) {
      // If it is we allow to change the base once.
      ccontext.getSymbolTable.setBase(stmt)
    } else {
      ccontext.getErrorHandler.addEvent(
        new Err(
          stmt,
          s"this base definition overrides the previous one " +
          s"(${ccontext.getSymbolTable.getBase.getLine}:${ccontext.getSymbolTable.getBase.getColumn})" +
          s" with value $existingSTValue",
          Err.BaseOverride
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    val existingSTValue = ccontext.getSymbolTable.getPrefix(stmt.label)
    // 1. Does the prefix exists in the symbol table?
    if (Objects.nonNull(ccontext.getSymbolTable.getPrefix(stmt.label))) {
      ccontext.getErrorHandler.addEvent(
        new Err(
          stmt.expression,
          s"this prefix definition overrides the previous one " +
          s"(${existingSTValue.getLine}:${existingSTValue.getColumn}) with value " +
          s"${existingSTValue.expression.asLiteralIRIValueExpr.value}",
          Err.PrefixOverride
        )
      )
    } else {
      ccontext.getSymbolTable += stmt
    }

    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ShapeDefStmt, param: Unit): Unit = {
    val isRelativeShape               = stmt.label.isCallBaseExpr
    var existingSTValue: ShapeDefStmt = null

    if (isRelativeShape) {
      existingSTValue = ccontext.getSymbolTable.getShape(
        ccontext.getSymbolTable.DEFAULT_BASE,
        stmt.label.asCallBaseExpr.argument
      )
    } else {
      existingSTValue = ccontext.getSymbolTable.getShape(
        stmt.label.asCallPrefixExpr.label,
        stmt.label.asCallPrefixExpr.argument
      )
    }

    // 1. Does the symbol table contains the shape?
    if (Objects.nonNull(existingSTValue)) {
      ccontext.getErrorHandler.addEvent(
        new Err(
          stmt.label,
          s"this shape definition overrides the previous one " +
          s"(${existingSTValue.getLine}:${existingSTValue.getColumn})",
          Err.ShapeOverride
        )
      )
    } else {
      ccontext.getSymbolTable += stmt
    }

    stmt.label.accept(this, param)
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    val existingSTValue = ccontext.getSymbolTable.getStart
    var cause: String   = ""

    // Has been already set?
    if (Objects.nonNull(existingSTValue)) {

      if (stmt.expression.asCallShapeExpr.label.isCallBaseExpr) {
        cause = s"this start definition overrides the previous one " +
          s"(${existingSTValue.getLine}:${existingSTValue.getColumn})" +
          s" with value " +
          s"${existingSTValue.expression.asCallShapeExpr.label.asCallBaseExpr.argument}:"
      } else {
        cause = s"this start definition overrides the previous one " +
          s"(${existingSTValue.getLine}:${existingSTValue.getColumn})" +
          s" with value " +
          s"${existingSTValue.expression.asCallShapeExpr.label.asCallPrefixExpr.label}:" +
          s"${existingSTValue.expression.asCallShapeExpr.label.asCallPrefixExpr.argument}"
      }

      ccontext.getErrorHandler.addEvent(
        new Err(
          stmt,
          cause,
          Err.StartOverride
        )
      )
    } else {
      ccontext.getSymbolTable.setStart(stmt)
    }
    stmt.expression.accept(this, param)
  }
}
