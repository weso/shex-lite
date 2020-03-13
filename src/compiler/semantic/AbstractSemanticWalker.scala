package compiler.semantic

import compiler.ast._

/**
 * This layer of abstraction
 */
class AbstractSemanticWalker extends ASTWalker[Any, Any] {
  override def walk(schema: Schema, param: Any): Any = schema.statements.map(st => st.walk(this, param))
  override def walk(statement: Statement, param: Any): Any = null
  override def walk(statement: ImportStatement, param: Any): Any = statement.iri.walk(this, param)
  override def walk(statement: DeclarationStmt, param: Any): Any = null
  override def walk(declaration: PrefixDeclaration, param: Any): Any = declaration.iri.walk(this, param)
  override def walk(declaration: BaseDeclaration, param: Any): Any = declaration.iri.walk(this, param)
  override def walk(declaration: StartDeclaration, param: Any): Any = declaration.ref.walk(this, param)
  override def walk(declaration: ShapeDeclaration, param: Any): Any = declaration.constraint.walk(this, param)
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
