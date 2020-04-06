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
private[compiler] class TripleExpressionConstraint(filename: String, line: Int, column: Int, constraints: List[TripleConstraint])
  extends Constraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = {
    val sb = new StringBuilder()
    sb.append(constraints.size)
    constraints.foreach(println)
    sb.toString()
  }
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
private[compiler] class TripleConstraint(filename: String, line: Int, column: Int, val property: PrefixInvocation, val constraint: NodeConstraint,
                                         val cardinality: Cardinality) extends Constraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"triple constraint -> $filename:$line:$column $property $constraint $cardinality"
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
private[compiler] class Cardinality(filename: String, line: Int, column: Int, val min: BigInt, val max: BigInt)
  extends ASTNode(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"cardinality -> $filename:$line:$column $min $max"
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

  override def toString: String = s"Literal -> $filename:$line:$column"
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

  override def toString: String = s"IRI -> $filename:$line:$column"
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

  override def toString: String = s"AnyType -> $filename:$line:$column"
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

  override def toString: String = s"BNode -> $filename:$line:$column"
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

  override def toString: String = s"NonLiteral -> $filename:$line:$column"
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
private[compiler] abstract class Invocation(filename: String, line: Int, column: Int, val content: String, var decl: DeclarationStmt)
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
private[compiler] class PrefixInvocation(filename: String, line: Int, column: Int, content: String, decl: PrefixDeclaration = null)
  extends Invocation(filename, line, column, content, decl) with ValidValueSetConstraint {

  def isRelativeIRI: Boolean = content.contains(":")

  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"Prefix Invocation -> $filename:$line:$column $content $decl"
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
private[compiler] class ShapeInvocation(filename: String, line: Int, column: Int, content: String, decl: PrefixDeclaration = null)
  extends Invocation(filename, line, column, content, decl) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"Shape Invocation -> $filename:$line:$column $content $decl"
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
private[compiler] abstract class Literal[T](filename: String, line: Int, column: Int, val value: T)
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

  override def toString: String = s"IRI Literal -> $filename:$line:$column $value"
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

  override def toString: String = s"String Literal -> $filename:$line:$column $value"
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

  override def toString: String = s"Real Literal -> $filename:$line:$column $value"
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
private[compiler] class ValueSetConstraint(filename: String, line: Int, column: Int, val set: List[ValidValueSetConstraint])
  extends NodeConstraint(filename, line, column) {
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = walker.walk(this, param)

  override def toString: String = s"Value Set -> $filename:$line:$column $set"
}

/**
 * This is a functional interface needed only to mark those types that are candidate to be included in a value set.
 */
private[compiler] sealed trait ValidValueSetConstraint