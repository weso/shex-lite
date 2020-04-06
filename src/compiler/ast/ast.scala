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

import compiler.internal.error.MemoryErrorHandler

/**
 * AST node represents a node in the Abstract Syntax Tree (AST). The nodes are generated
 * by the parser. Later they are used at semantic analysis and the tree will be attributed
 * with other information that will transform the tree in a graph but the nodes will be
 * the same but with more information. Each node always contains the file, line and column
 * where it was generated. So in case of an error we can trace back to the source code.
 */
private[compiler] abstract class ASTNode(val filename: String, val line: Int, val column: Int) {

  /**
   * Helper method for the ast walkers.
   *
   * @param walker to walk over the AST node.
   * @tparam TP is the type of the parameter.
   * @tparam TR is the type of the return object.
   * @return an object o
   */
  def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR

  /**
   * Default to string method for all the ast nodes.
   *
   * @return an string containing the information.
   */
  override def toString: String = s"$filename:$line:$column"
}

/**
 * The schema is the set of statements that is used to validate a graph.
 *
 * @param filename   of the main file used to build the schema.
 * @param line       where the schema starts.
 * @param column     where the schema starts.
 * @param statements that compose the schema.
 */
private[compiler] class Schema(filename: String, line: Int, column: Int, val statements: List[Statement])
  extends ASTNode(filename, line, column) {

  /**
   * Helper method for the ast walkers.
   *
   * @param walker to walk over the AST node.
   * @tparam TP is the type of the parameter.
   * @tparam TR is the type of the return object.
   * @return an object o
   */
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = {
    walker.walk(this, param)
  }

  override def toString: String = {
    val sb = new StringBuilder()
    sb.append(s"schema -> $filename:$line:$column\n")
    statements.foreach(s => sb.append(s + "\n"))
    sb.toString()
  }
}

/**
 * AST default walker fot he abstract syntax tree.
 *
 * @tparam TP is the type of the parameter.
 * @tparam TR is the type of the return object.
 */
private[compiler] trait ASTWalker[TP, TR] {

  // Schema
  def walk(schema: Schema, param: TP): TR

  // Statements
  def walk(statement: Statement, param: TP): TR

  def walk(statement: ImportStatement, param: TP): TR

  def walk(statement: DeclarationStmt, param: TP): TR

  // Declarations
  def walk(declaration: PrefixDeclaration, param: TP): TR

  def walk(declaration: BaseDeclaration, param: TP): TR

  def walk(declaration: StartDeclaration, param: TP): TR

  def walk(declaration: ShapeDeclaration, param: TP): TR

  // Constraints
  def walk(constraint: Constraint, param: TP): TR

  def walk(constraint: TripleConstraint, param: TP): TR

  def walk(constraint: Cardinality, param: TP): TR

  def walk(constraint: NodeConstraint, param: TP): TR

  def walk(constraint: LiteralNodeConstraint, param: TP): TR

  def walk(constraint: IRINodeConstraint, param: TP): TR

  def walk(constraint: AnyTypeNodeConstraint, param: TP): TR

  def walk(constraint: BNodeNodeConstraint, param: TP): TR

  def walk(constraint: NonLiteralNodeConstraint, param: TP): TR

  def walk(constraint: Invocation, param: TP): TR

  def walk(constraint: PrefixInvocation, param: TP): TR

  def walk(constraint: ShapeInvocation, param: TP): TR

  def walk[TL](constraint: Literal[TL], param: TP): TR

  def walk(constraint: IRILiteral, param: TP): TR

  def walk(constraint: StringLiteral, param: TP): TR

  def walk(constraint: RealLiteral, param: TP): TR

  def walk(constraint: ValueSetConstraint, param: TP): TR
}

/**
 * Default implementation for the AST walker. It only propagates the action to all the children of each node.
 */
class DefaultASTWalker extends ASTWalker[Any, Any] {
  override def walk(schema: Schema, param: Any): Any = schema.statements.map(st => st.walk(this, param))

  override def walk(statement: Statement, param: Any): Any = null

  override def walk(statement: ImportStatement, param: Any): Any = statement.iri.walk(this, param)

  override def walk(statement: DeclarationStmt, param: Any): Any = null

  override def walk(declaration: PrefixDeclaration, param: Any): Any = declaration.iri.walk(this, param)

  override def walk(declaration: BaseDeclaration, param: Any): Any = declaration.iri.walk(this, param)

  override def walk(declaration: StartDeclaration, param: Any): Any = declaration.ref.walk(this, param)

  override def walk(declaration: ShapeDeclaration, param: Any): Any = {
    declaration.name.walk(this, param)
    declaration.constraint.walk(this, param)
  }

  override def walk(constraint: Constraint, param: Any): Any = null

  override def walk(constraint: TripleConstraint, param: Any): Any = {
    constraint.property.walk(this, param)
    constraint.constraint.walk(this, param)
    constraint.cardinality.walk(this, param)
  }

  override def walk(constraint: Cardinality, param: Any): Any = null

  override def walk(constraint: NodeConstraint, param: Any): Any = null

  override def walk(constraint: LiteralNodeConstraint, param: Any): Any = null

  override def walk(constraint: IRINodeConstraint, param: Any): Any = null

  override def walk(constraint: AnyTypeNodeConstraint, param: Any): Any = null

  override def walk(constraint: BNodeNodeConstraint, param: Any): Any = null

  override def walk(constraint: NonLiteralNodeConstraint, param: Any): Any = null

  override def walk(constraint: Invocation, param: Any): Any = constraint.decl.walk(this, param)

  override def walk(constraint: PrefixInvocation, param: Any): Any = constraint.decl.walk(this, param)

  override def walk(constraint: ShapeInvocation, param: Any): Any = constraint.decl.walk(this, param)

  override def walk[TL](constraint: Literal[TL], param: Any): Any = null

  override def walk(constraint: IRILiteral, param: Any): Any = null

  override def walk(constraint: StringLiteral, param: Any): Any = null

  override def walk(constraint: RealLiteral, param: Any): Any = null

  override def walk(constraint: ValueSetConstraint, param: Any): Any = null
}
