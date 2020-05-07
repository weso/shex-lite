//------------------------------------------------------------------------------
// File: ParseStartDefStmt.scala
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

package es.weso.shexlc.parse

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.expr.Expression
import es.weso.shexlc.parse.ast.stmt.StartDefStmt
import es.weso.shexlc.parse.generated.ShexLiteParser
import org.antlr.v4.runtime.misc.Interval

/**
  * The start definition statement sub-parser creates an start definition statement from the context of the parser.
  * It delegates the creation of the expression that represents the called shape to its own sub-parser.
  *
  * @author Guillermo Facundo Colunga
  * @param ctx     of the parser.
  * @param visitor to propagate any action.
  */
class ParseStartDefStmt(
  ctx: ShexLiteParser.Start_def_stmtContext,
  visitor: ASTBuilderParser,
  ccontext: CompilationContext
) extends HasParseResult[StartDefStmt] {

  override def getParseResult: StartDefStmt = {
    val line     = ctx.start.getLine
    val column   = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)
    val content  = ccontext.getInputContext.getText(interval)

    val calledShape: Expression = ctx.shape.accept(visitor).asExpression()

    new StartDefStmt(line, column, interval, content, calledShape)
  }
}
