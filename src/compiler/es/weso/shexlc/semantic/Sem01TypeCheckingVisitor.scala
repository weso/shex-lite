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

package es.weso.shexlc.semantic

import es.weso.shexlc.ast.Schema
import es.weso.shexlc.ast.expr._
import es.weso.shexlc.ast.stmt._
import es.weso.shexlc.ast.visitor._
import es.weso.shexlc.internal.io.CompilerMsgsHandler
import es.weso.shexlc.internal.io.impl._
import es.weso.shexlc.internal.symboltable.SymbolTable

/**
 * The identification walker is the tool that travels the AST just to identify possible definitions an add the
 * information found to the symbol table.
 *
 * @param symbolTable is the symbol table used as a context.
 */
class Sem01TypeCheckingVisitor(symbolTable: SymbolTable, msgsHandler: CompilerMsgsHandler)
  extends DefaultShExLiteGenericVisitor[Unit] {

  override def visit(schema: Schema, param: Unit): Unit = {
    for(stmt <- schema.stmts) {
      if(!stmt.isStatement()) {
        msgsHandler.addMsg(
          new DefaultCompilerMsg(
            stmt.getPosition,
            stmt.getRange,
            s"$stmt is not an statement",
            CompilerMsgErrorType.TypeCheckingError
          )
        )
      }
      stmt.accept(this, param)
    }
  }

  override def visit(stmt: BaseDefStmt, param: Unit): Unit = {
    if(!stmt.expression.isLiteralIRIValueExpr) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.expression.getPosition,
          stmt.getRange,
          s"${stmt.expression} is not a Literal IRI Value Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ImportStmt, param: Unit): Unit = {
    if(!stmt.expression.isLiteralIRIValueExpr) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.expression.getPosition,
          stmt.getRange,
          s"${stmt.expression} is not a Literal IRI Value Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: PrefixDefStmt, param: Unit): Unit = {
    if(!stmt.expression.isLiteralIRIValueExpr) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.expression.getPosition,
          stmt.getRange,
          s"${stmt.expression} is not a Literal IRI Value Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: ShapeDefStmt, param: Unit): Unit = {
    if(!stmt.label.isCallPrefixExpr) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.label.getPosition,
          stmt.getRange,
          s"${stmt.expression} is not a Call Prefix Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    stmt.label.accept(this, param)
    if(!stmt.expression.isExpression) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.expression.getPosition,
          stmt.getRange,
          s"${stmt.expression} is not an Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(stmt: StartDefStmt, param: Unit): Unit = {
    if(!stmt.expression.isCallShapeExpr) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          stmt.expression.getPosition,
          stmt.getRange,
          s"${stmt.expression} is not a Call Shape Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    stmt.expression.accept(this, param)
  }

  override def visit(expr: CallShapeExpr, param: Unit): Unit = {
    if(!expr.label.isCallPrefixExpr) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          expr.label.getPosition,
          expr.getRange,
          s"${expr.label} is not a Call Prefix Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    expr.label.accept(this, param)
  }

  override def visit(expr: ConstraintBlockTripleExpr, param: Unit): Unit = {
    for(tripleExpr <- expr.body) {
      if(!tripleExpr.isConstraintTripleExpr) {
        msgsHandler.addMsg(
          new DefaultCompilerMsg(
            tripleExpr.getPosition,
            expr.getRange,
            s"$tripleExpr is not a Constraint Triple Expression",
            CompilerMsgErrorType.TypeCheckingError
          )
        )
      }
      tripleExpr.accept(this, param)
    }
  }

  override def visit(expr: ConstraintTripleExpr, param: Unit): Unit = {
    if(!expr.property.isCallPrefixExpr) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          expr.property.getPosition,
          expr.getRange,
          s"${expr.property} is not a Call Prefix Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    expr.property.accept(this, param)

    if(!expr.constraint.isExpression()) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          expr.constraint.getPosition,
          expr.getRange,
          s"${expr.constraint} is not an Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    expr.constraint.accept(this, param)

    if(!expr.cardinality.isCardinalityExpr) {
      msgsHandler.addMsg(
        new DefaultCompilerMsg(
          expr.cardinality.getPosition,
          expr.getRange,
          s"${expr.cardinality} is not a Cardinality Expression",
          CompilerMsgErrorType.TypeCheckingError
        )
      )
    }
    expr.cardinality.accept(this, param)
  }

  override def visit(expr: ConstraintValueSetExpr, param: Unit): Unit = {
    for(value <- expr.values) {
      if(!value.isConstraintValidValueSetExpr) {
        msgsHandler.addMsg(
          new DefaultCompilerMsg(
            value.getPosition,
            expr.getRange,
            s"$value is not a Valid Value Type Expression",
            CompilerMsgErrorType.TypeCheckingError
          )
        )
      }
      value.accept(this, param)
    }
  }
}