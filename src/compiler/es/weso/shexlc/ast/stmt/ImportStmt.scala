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

package es.weso.shexlc.ast.stmt

import es.weso.shexlc.ast.Position
import es.weso.shexlc.ast.expr.Expression
import es.weso.shexlc.ast.visitor.ShExLiteGenericVisitor
import org.antlr.v4.runtime.misc.Interval

/**
 * The import statement is a directive that allows to import an schema defined in a different file. The file is
 * represented by the expression. It must conform to a type that at the end points to an schema like an iri, but this
 * will be checked by the es.weso.shexlc.semantic validator later.
 *
 * @author Guillermo Facundo Colunga.
 * @param line       in the source code where the token that generates de Base Definition Statement is located.
 * @param column     in the source code where the token that generates de Base Definition Statement is located.
 * @param expression that points or contains the schema to import.
 */
class ImportStmt(line: Int, column: Int, interval: Interval, val expression: Expression) extends Statement {
  override def getPosition: Position = Position.pos(line, column)

  override def getRange: Interval = interval

  // Override default methods to indicate that this is an Import Statement.
  override def isImportStmt: Boolean = true

  override def asImportStmt: ImportStmt = this

  override def accept[TP, TR](visitor: ShExLiteGenericVisitor[TP, TR], param: TP): TR = {
    visitor.visit(this, param)
  }


}
