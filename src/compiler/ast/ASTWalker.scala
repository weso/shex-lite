package compiler.ast

/**
 * AST default walker fot he abstract syntax tree.
 *
 * @tparam TP is the type of the parameter.
 * @tparam TR is the type of the return object.
 */
private[compiler] trait ASTWalker[TP, TR] {

  // Schema
  def walk(schema: ASTNode, param: TP): TR

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
