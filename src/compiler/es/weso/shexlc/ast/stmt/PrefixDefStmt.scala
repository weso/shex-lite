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
 * A prefix definition associates an expression, presumably an identifier or similar with another expression that also
 * presumably will be an iri. But this is left to the es.weso.shexlc.semantic checker so we can extend the language in the future
 * without modifying this class.
 *
 * @author Guillermo Facundo Colunga.
 * @param line       in the source code where the token that generates de Base Definition Statement is located.
 * @param column     in the source code where the token that generates de Base Definition Statement is located.
 * @param label      that identifies the Prefix Definition Statement.
 * @param expression that will be associated to the label of the Prefix Definition Statement.
 */
class PrefixDefStmt(line: Int, column: Int, interval: Interval, val label: String, val expression: Expression) extends DefinitionStmt {
  override def getPosition: Position = Position.pos(line, column)

  override def getRange: Interval = interval

  // Override default methods to indicate that this is a Prefix Definition Statement.
  override def isPrefixDefStmt: Boolean = true

  override def asPrefixDefStmt: PrefixDefStmt = this

  override def accept[TP, TR](visitor: ShExLiteGenericVisitor[TP, TR], param: TP): TR = {
    visitor.visit(this, param)
  }


}
