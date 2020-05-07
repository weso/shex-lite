//--------------------------------------------------------------------------------------------------
// File: SyntaxTreeShexCompatibilityChecker.scala
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
//--------------------------------------------------------------------------------------------------

package es.weso.shexlc.parse

import java.util.Objects

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.Warn
import es.weso.shexlc.parse.ast.visitor.ASTGenericWalker
import es.weso.shexlc.parse.ast.{NodeWithPosition, Position}
import es.weso.shexlc.parse.generated.{ShexLiteParser, ShexLiteParserBaseVisitor}
import org.antlr.v4.runtime.misc.Interval

/**
 * This class checks that the input shape expressions are compatible with the shex specification. For now it only
 * checks that all the triple expressions contain a semicolon at the end. But it also can be used as an example
 * of wat users can implement to check for oder syntax constraints.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param ccontext is the compiler context.
 */
class CheckSyntaxTreeShexCompatibility(ccontext: CompilationContext) extends ShexLiteParserBaseVisitor[Unit] {

  override def visitConstraint_triple_expr(ctx: ShexLiteParser.Constraint_triple_exprContext): Unit = {

    // Check if the expression contains a semicolon at the end, they are compulsory on shex. This check will be only
    // done if and only if the generate warnings flag from the configuration of the context is set to true. Else will
    // be skip.
    if(Objects.isNull(ctx.SEMI()) && ccontext.getConfiguration.generateWarnings) {

      val node = new NodeWithPosition {
        /**
         * Gets the position object that points to the source file.
         *
         * @return a position object containing the position in the source file.
         */
        override def getPosition: Position =
          new Position("",
            ctx.stop.getLine,
            ctx.stop.getCharPositionInLine
          )

        /**
         * Gets the range of tokens from the source on which the node was generated.
         *
         * @return the range of tokens from the source on which the node was generated.
         */
        override def getRange: Interval = ctx.getSourceInterval

        /**
         * Gets the content of the node as a String, for example for a node that contains the assignment of a and 3
         * the content would be 'a = 3'.
         *
         * @return the content of the node as a String.
         */
        override def getContent: String = ""

        /**
         * Accept method for visitor support.
         *
         * @param visitor the visitor implementation.
         * @param param   is the parameter passed to the visitor (of type A).
         * @tparam TP is the type the user parameter passed to the visitor.
         * @tparam TR is the type of the return value of the visitor.
         * @return the result of the visit (of type TR).
         */
        override def accept[TP, TR](visitor: ASTGenericWalker[TP, TR], param: TP): TR = {
          throw new IllegalStateException("This method should never be called")
        }
      }

      // We add the event warning to the error handler
      ccontext.getErrorHandler.addEvent(
        Warn(
          node,
          "semicolons are not compulsory in ShEx Lite, but its usage its encouraged as otherwise your " +
            "code wont be following shape expressions specification.",
          Warn.MissingSemicolon
        )
      )
    }
  }
}
