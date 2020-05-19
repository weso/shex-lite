//------------------------------------------------------------------------------
// File: CGJava021ImportGenerator.scala
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

package es.weso.shexlc.IRGen.javagen.internal

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.expr.CardinalityExpr
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

class CGJava021ImportGenerator(ccontext: CompilationContext, stringBuilder: StringBuilder)
    extends ASTDefaultVisitor[String] {

  // If any of the cardinality is greater than 1 then the import for the
  // java.util.List will be generated.
  override def visit(expr: CardinalityExpr, param: String): Unit = {
    if (expr.max > 1) {
      stringBuilder.append("import java.util.List;")
      stringBuilder.append("\n")
      stringBuilder.append("\n")
    }
  }
}
