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

package compiler.ast

/**
 * In shape expressions lite the first depth level are the statements. A schema is formed by statements.
 * The statements, are divided in two blocks:
 *  - declarations (shex-lite is a declarative language)
 *  - import statement. The import directive implies compile the referenced document.
 *
 * @param filename where the statement is located.
 * @param line     where the statement is located.
 * @param column   where the statement is located.
 */
private[compiler] abstract class Statement(filename: String, line: Int, column: Int)
  extends ASTNode(filename, line, column)

/**
 * The import statement is used to fetch, compile and aggregate another `.shexl` file to the current schema.
 *
 * @param filename where the statement is located.
 * @param line     where the statement is located.
 * @param column   where the statement is located.
 * @param iri      is the identifier of the resource that contains the file to import.
 */
private[compiler] class ImportStatement(filename: String, line: Int, column: Int, val iri: IRILiteral)
  extends Statement(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"import -> $filename:$line:$column $iri"
}

// ******************************************
// DECLARATIONS
// ******************************************

/**
 * In sehx-lite a declaration is the second level of abstraction. Except the import directive everything else is
 * a declaration.
 *
 * @param filename where the statement is located.
 * @param line     where the statement is located.
 * @param column   where the statement is located.
 */
private[compiler] class DeclarationStmt(filename: String, line: Int, column: Int)
  extends Statement(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * A prefix is the alias that is given to an IRI, that prefix can be re-arranged by means of another prefix declaration.
 * When declaring shapes and constraints prefix references are used to keep track of the semantic meaning of the things.
 * Every reference also contains the definition.
 *
 * @param filename where the statement is located.
 * @param line     where the statement is located.
 * @param column   where the statement is located.
 * @param name     of the prefix.
 * @param iri      is the resource to assign to the given name.
 */
private[compiler] class PrefixDeclaration(filename: String, line: Int, column: Int, val name: String, val iri: IRILiteral)
  extends DeclarationStmt(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"prefix -> $filename:$line:$column $name:$iri"
}

/**
 * The base declaration assigns the given resource IRI to the base environment variable that is needed to translate
 * other relative IRIs. The base env. var. can be override with other base declarations. But that is not recommended
 * and therefore generates a warning.
 *
 * @param filename where the statement is located.
 * @param line     where the statement is located.
 * @param column   where the statement is located.
 * @param iri      is the resource to set as the base.
 */
private[compiler] class BaseDeclaration(filename: String, line: Int, column: Int, val iri: IRILiteral)
  extends DeclarationStmt(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"base -> $filename:$line:$column $iri"
}

/**
 * The start declaration defines which shape will be used by default to validate the nodes if no shape is indicated at
 * the shape map. Start declarations cannot be overriden and doing it generates and error. If it would be allowed
 * the semantic value would be confusing as only the last one would be the one used. And as the start variable has
 * no side effect on the shape expression the other definitions would be useless and meaningful.
 *
 * @param filename where the statement is located.
 * @param line     where the statement is located.
 * @param column   where the statement is located.
 * @param ref      to the shape that will be used as the default shape.
 */
private[compiler] class StartDeclaration(filename: String, line: Int, column: Int, val ref: ShapeInvocation)
  extends DeclarationStmt(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"start -> $filename:$line:$column $ref"
}

/**
 * A shape declaration is the act of defining a shape, composed of a shape label (the name) and the expression associated
 * to it. The expression associated to it can be a node constraint or a triple expression (a finite set of triple constraints).
 * A shape cannot be redefined, redefine a shape does not add any functionality to the language but the semantic value
 * would be confusing.
 *
 * @param filename   where the statement is located.
 * @param line       where the statement is located.
 * @param column     where the statement is located.
 * @param name       of the shape (shape label).
 * @param constraint to be associated to that label.
 */
private[compiler] class ShapeDeclaration(filename: String, line: Int, column: Int, val name: PrefixInvocation, val constraint: Constraint)
  extends DeclarationStmt(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"shape -> $filename:$line:$column $constraint"
}