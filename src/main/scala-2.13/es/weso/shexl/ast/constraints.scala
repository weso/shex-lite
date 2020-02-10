package es.weso.shexl.ast

case class Constraint(line: Int, column: Int, field: FieldConstraint, cType: TypeConstraint) extends ASTNode(line, column)
case class FieldConstraint(line: Int, column: Int, prefixInv: PrefixInv) extends ASTNode(line, column)
case class TypeConstraint(line: Int, column: Int, invocation: Invocation) extends ASTNode(line, column)