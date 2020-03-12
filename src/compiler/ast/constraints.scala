package compiler.ast

/**
 * A constraint is a condition that the validation node must fulfill. This class serves as an abstraction for the
 * specific constraints that shex-lite allows.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 */
private[compiler] abstract class Constraint(filename: String, line: Int, column: Int)
  extends ASTNode(filename, line, column)

/**
 * A triple expression is a wrapper for a set of triple constraints.
 *
 * @param filename    where the constraint is located.
 * @param line        where the constraint is located.
 * @param column      where the constraint is located.
 * @param constraints is the set of triple constraints that build the expression.
 */
private[compiler] class TripleExpressionConstraint(filename: String, line: Int, column: Int,constraints: List[TripleConstraint])
  extends Constraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * A triple constraint is the triple build by a property, a node constraint and the cardinality.
 *
 * The property is a prefix invocation that is, the prefix alias plus the property to be defined.
 * Notice that the prefix must exist in the scheme space at compilation time, that is, it doesn't
 * matter where it is defined meanwhile it is defined.
 *
 * The node constraint is the condition that the property has to meet.
 *
 * The cardinality is the range (min_times, max_times) that the property+constraint can be repeated. (0,1) meas optional
 * (1,1) means compulsory, (0, MAX_BIG_INT) means any number, (0,n) means anything between 0 and n.
 *
 * @param filename    where the constraint is located.
 * @param line        where the constraint is located.
 * @param column      where the constraint is located.
 * @param property    of the constraint.
 * @param constraint  to be applies to the property.
 * @param cardinality of the constraint.
 */
private[compiler] class TripleConstraint(filename: String,line: Int, column: Int, property: PrefixInvocation, constraint: NodeConstraint,
                                         cardinality: Cardinality) extends Constraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * The cardinality is a range that represents how many times the tuple property+constraint can be repeated in the node
 * to be validated.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param min      number of times that the tuple can be repeated.
 * @param max      number of times that the tuple can be repeated.
 */
private[compiler] class Cardinality(filename: String, line: Int, column: Int, min: BigInt, max: BigInt)
  extends ASTNode(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

// ******************************************
// NODE CONSTRAINTS
// ******************************************

/**
 * A node constraint is the abstraction used by the specific constraint accepted in shex-lite
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 */
private[compiler] abstract class NodeConstraint(filename: String, line: Int, column: Int)
  extends Constraint(filename, line, column)

/**
 * A literal node constraint specifies that the node to validate must be of type `Literal`.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 */
private[compiler] class LiteralNodeConstraint(filename: String, line: Int, column: Int)
  extends NodeConstraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * An IRI node constraint specifies that the node to validate must be of type `IRI`.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 */
private[compiler] class IRINodeConstraint(filename: String, line: Int, column: Int)
  extends NodeConstraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * An AnyType node constraint specifies that the node to validate must be of type `.`.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 */
private[compiler] class AnyTypeNodeConstraint(filename: String, line: Int, column: Int)
  extends NodeConstraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * A BNode node constraint specifies that the node to validate must be of type `BNode`.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 */
private[compiler] class BNodeNodeConstraint(filename: String, line: Int, column: Int)
  extends NodeConstraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * A non-literal node constraint specifies that the node to validate must be of type `NonLiteral`.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 */
private[compiler] class NonLiteralNodeConstraint(filename: String, line: Int, column: Int)
  extends NodeConstraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

// ******************************************
// INVOCATIONS
// ******************************************

/**
 * An invocation is the abstraction used to represent references to IRIs defined as bases / prefixes or shapes.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param content  of the invocation, can be the prefix:property or the iri:shape.
 * @param decl     to the statement where the variable to be invoke id declared.
 */
private[compiler] abstract class Invocation(filename: String, line: Int, column: Int, val content: String, val decl: DeclarationStmt)
  extends NodeConstraint(filename, line, column)

/**
 * A prefix invocation is the reference to a prefix defined in the schema space.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param content  of the invocation as `prefix:property`.
 * @param decl     to the statement where the variable to be invoke id declared.
 */
private[compiler] class PrefixInvocation(filename: String, line: Int, column: Int, content: String, decl: PrefixDeclaration)
  extends Invocation(filename, line, column, content, decl) with ValidValueSetConstraint {

  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * A shape invocation is the reference to a shape defined in the schema space.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param content  of the invocation as `prefix:shape`.
 * @param decl     to the statement where the variable to be invoke id declared.
 */
private[compiler] class ShapeInvocation(filename: String, line: Int, column: Int, content: String, decl: PrefixDeclaration)
  extends Invocation(filename, line, column, content, decl) {

  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

// ******************************************
// LITERALS
// ******************************************

/**
 * A literal is an abstraction for every especific literal implemented in the system.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param value    of the literal.
 * @tparam T is the type of the literal.
 */
private[compiler] abstract class Literal[T](filename: String, line: Int, column: Int, value: T)
  extends NodeConstraint(filename, line, column)

/**
 * An IRI literal is the container for literal IRIs found in the scheme.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param value    of the literal.
 */
private[compiler] class IRILiteral(filename: String, line: Int, column: Int, value: String)
  extends Literal[String](filename, line, column, value) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * A string literal is the container for literal strings found in the scheme.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param value    of the literal.
 */
private[compiler] class StringLiteral(filename: String, line: Int, column: Int, value: String)
  extends Literal[String](filename, line, column, value) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * A real literal is the container for literal reals found in the scheme.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param value    of the literal.
 */
private[compiler] class RealLiteral(filename: String, line: Int, column: Int, value: Double)
  extends Literal[Double](filename, line, column, value) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

// ******************************************
// Value Set Constraints
// ******************************************

/**
 * A value set constraint is an special case of constraint where we have a set of types.
 *
 * @param filename where the constraint is located.
 * @param line     where the constraint is located.
 * @param column   where the constraint is located.
 * @param set      is the set of types that the node must contain.
 */
private[compiler] class ValueSetConstraint(filename: String, line: Int, column: Int, set: List[ValidValueSetConstraint])
  extends NodeConstraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)
}

/**
 * This is a functional interface needed only to mark those types that are candidate to be included in a value set.
 */
private[compiler] sealed trait ValidValueSetConstraint