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

package compiler.semantic

import compiler.ast.{DefaultASTWalker, PrefixInvocation, ShapeDeclaration, ShapeInvocation}
import compiler.internal.error.{CompilerErr, CompilerErrSource}
import compiler.internal.symboltable.SymbolTable

/**
 * The invocations checker keeps track that every invocation or reference that appears at the schema is semantically
 * correct. For that check the information that appears in the symbol table and therefore it its need to previously
 * execute the DefinitionsCheckerWalker in order to add the information to the symbol table.
 */
private[compiler] class InvocationsCheckerWalker(symbolTable: SymbolTable) extends DefaultASTWalker {

  override def walk(constraint: PrefixInvocation, param: Any): Any = constraint.isRelativeIRI match {
    case true => {
      // Check that the prefix is in the st.
      val prefixName = constraint.content.split(":")(0)
      symbolTable.getPrefix(prefixName) match {
        case Left(err) =>
          new CompilerErr(
            new CompilerErrSource(constraint, s"prefix invocation [$prefixName]"),
            err
          )

        case Right(prefixDeclaration) => constraint.decl = prefixDeclaration
      }
    }

    case false => {
      symbolTable.getBase match {
        case Left(err) =>
          new CompilerErr(
            new CompilerErrSource(constraint, s"base invocation [${constraint.content}]"),
            err
          )

        case Right(baseDeclaration) => constraint.decl = baseDeclaration
      }
    }
  }

  override def walk(constraint: ShapeInvocation, param: Any): Any = symbolTable.getShape(constraint.content) match {
    case Left(err) =>
      new CompilerErr(
        new CompilerErrSource(constraint, s"shape invocation [${constraint.content}]"),
        err
      )
    case Right(declaration) => constraint.decl = declaration
  }
}
