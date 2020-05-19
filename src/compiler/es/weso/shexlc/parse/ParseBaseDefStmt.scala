//------------------------------------------------------------------------------
// File: ParseBaseDefStmt.scala
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
import es.weso.shexlc.parse.ast.stmt.BaseDefStmt
import es.weso.shexlc.parse.ast.Position
import es.weso.shexlc.parse.generated.ShexLiteParser
import org.antlr.v4.runtime.misc.Interval

/**
  * The base definition statement sub-parser creates a new base definition
  * statement from the parser context. It
  * delegates the creation of the iri literal to its corresponding sub-parser.
  *
  * @author Guillermo Facundo Colunga
  * @param ctx     of the parser.
  * @param visitor to propagate any action.
  */
class ParseBaseDefStmt(
  ctx: ShexLiteParser.Base_def_stmtContext,
  visitor: ASTBuilderParser,
  ccontext: CompilationContext
) extends HasParseResult[BaseDefStmt] {

  override def getParseResult: BaseDefStmt = {
    val sourceName      = ccontext.getInputContext.getSourceName
    val line            = ctx.start.getLine
    val column          = ctx.start.getCharPositionInLine
    val pos             = Position.pos(sourceName, line, column)
    val tokenRange      = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)
    val content         = ccontext.getInputContext.getText(tokenRange)
    val iri: Expression = ctx.iri.accept(visitor).asExpression()

    new BaseDefStmt(pos, tokenRange, content, iri)
  }
}
