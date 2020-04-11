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

package es.weso.shexlc.syntactic.parser

import es.weso.shexlc.ast.expr.Expression
import es.weso.shexlc.ast.stmt.ImportStmt
import org.antlr.v4.runtime.misc.Interval
import es.weso.shexlc.syntactic._
import es.weso.shexlc.syntactic.generated.Shexl2Parser

/**
 * The import statement sub-parser generates an import statement from the parser context. It is an experimental feature
 * yet. It delegates the creation of the iri to its own sub-parser.
 *
 * @author Guillermo Facundo Colunga
 * @param ctx     of the parser.
 * @param visitor to propagate any action.
 */
class ImportStmtPsr(ctx: Shexl2Parser.Import_stmtContext, visitor: Syn01ASTBuilderVisitor)
  extends Parser[ImportStmt] {

  override def getParseResult: ImportStmt = {
    val line = ctx.start.getLine
    val column = ctx.start.getCharPositionInLine
    val interval = new Interval(ctx.start.getStartIndex, ctx.stop.getStopIndex)
    val iri: Expression = ctx.iri.accept(visitor).asExpression()

    // Generate a warning here as the import is just an experimental feature.

    new ImportStmt(line, column, interval, iri)
  }
}
