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

package syntactic.parser

import ast.Schema
import ast.stmt.Statement
import syntactic.Syn01ASTBuilderVisitor
import syntactic.generated.Shexl2Parser

import scala.collection.JavaConverters._

/**
 * The schema sub-parser generates an schema from the parser context. For that delegates all sub-parsing to sub-parsers
 * that are implemented on each rule.
 *
 * @author Guillermo Facundo Colunga
 * @param ctx     of the parser.
 * @param visitor to propagate any action.
 */
class SchemaPsr(ctx: Shexl2Parser.SchemaContext, visitor: Syn01ASTBuilderVisitor) extends Parser[Schema] {

  override def getParseResult: Schema = {
    val statements: List[Statement] = ctx.statement().asScala
      .map(stmt => stmt.accept(visitor)).toList.asInstanceOf[List[Statement]]

    new Schema(statements)
  }
}
