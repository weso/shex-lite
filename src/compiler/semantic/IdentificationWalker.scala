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

import com.typesafe.scalalogging.Logger
import compiler.ast.{BaseDeclaration, DefaultASTWalker, PrefixDeclaration, ShapeDeclaration, StartDeclaration}
import compiler.internal.error.{CompilerErr, CompilerErrSource, ErrType}
import compiler.internal.symboltable.SymbolTable

/**
 * The identification walker is the tool that travels the AST just to identify possible definitions an add the
 * information found to the symbol table.
 *
 * @param symbolTable is the symbol table used as a context.
 */
private[compiler] class IdentificationWalker(symbolTable: SymbolTable) extends DefaultASTWalker {

  // Default logger
  final val logger = Logger[IdentificationWalker]

  /**
   * Identifies a base declaration. It looks for base declarations and add the content of the abse declaration  to
   * the symbol table.
   *
   * @param declaration that is being walked and will be added to the symbol table.
   * @param param is the parameter is any needed.
   * @return either the base declaration if no error happen or a compile error otherwise.
   */
  override def walk(declaration: BaseDeclaration, param: Any): Any = symbolTable.setBase(declaration) match {
    case Left(err) =>
      new CompilerErr(
        new CompilerErrSource(declaration, s"base declaration ${declaration.iri.value}"),
        err
      )
    case _ =>
  }

  /**
   * Identifies an start declaration. Once this method is called to walk over an start declaration if delegates to the
   * symbol table the action of adding it to the context or raising an error.
   *
   * @param declaration that is being walked and will be added to the symbol table.
   * @param param is the parameter is any needed.
   * @return either the base declaration if no error happen or a compile error otherwise.
   */
  override def walk(declaration: StartDeclaration, param: Any): Any = symbolTable.setStart(declaration) match {
    case Left(err) =>
      new CompilerErr(
        new CompilerErrSource(declaration, s"start declaration ${declaration.ref.content}"),
        err
      )
    case _ =>
  }

  /**
   * Identifies a prefix declaration. Once this method is called to walk over an prefix declaration if delegates to the
   * symbol table the action of adding it to the context or raising an error.
   *
   * @param declaration that is being walked and will be added to the symbol table.
   * @param param is the parameter if any needed.
   * @return either the prefix declaration if no error happen or a compile error otherwise.
   */
  override def walk(declaration: PrefixDeclaration, param: Any): Any = symbolTable += declaration match {
    case Left(err) =>
      new CompilerErr(
        new CompilerErrSource(declaration, s"prefix declaration ${declaration.name}: ${declaration.iri.value}"),
        err
      )
    case _ =>
  }

  /**
   * Identifies a shape declaration. Once this method is called to walk over an shape declaration if delegates to the
   * symbol table the action of adding it to the context or raising an error.
   *
   * @param declaration
   * @param param
   * @return
   */
  override def walk(declaration: ShapeDeclaration, param: Any): Any = symbolTable += declaration match {
    case Left(err) =>
      new CompilerErr(
        new CompilerErrSource(declaration, s"shape declaration ${declaration.name}: ${declaration.constraint}"),
        err
      )
    case _ =>
  }
}