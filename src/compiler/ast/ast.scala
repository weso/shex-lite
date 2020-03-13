package compiler.ast

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
    statements.foreach(s=> sb.append(s + "\n"))
    sb.toString()
  }
}

/**
 * A warning is an event that does not compromise the result of the compilation but the user must be aware of because
 * might have side effects on the result.
 *
 * @param node that produces the warning.
 * @param code of the warning, check all possible codes at shex-lite.org.
 * @param message of the warning.
 */
private[compiler] class Warning(node: ASTNode, code: Int, message: String) extends ASTNode(node.filename, node.line, node.column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
  override def toString: String = s"warning[$code] at $filename:$line:$column --> $message"
}

/**
 * A error is an event that does compromise the result of the compilation and therefore it cannot produce a result.
 *
 * @param node that produces the error.
 * @param code of the error, check all possible codes at shex-lite.org.
 * @param message of the error.
 */
private[compiler] class Error(node: ASTNode, code: Int, message: String) extends ASTNode(node.filename, node.line, node.column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
  override def toString: String = s"error[$code] at $filename:$line:$column --> $message"
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
