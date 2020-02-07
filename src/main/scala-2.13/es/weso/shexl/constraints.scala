package es.weso.shexl

case class Constraint(line: Int, column: Int, field: FieldConstraint, cType: TypeConstraint) extends ASTNode(line, column)
case class FieldConstraint(line: Int, column: Int, prefixInv: PrefixInv, propertyName:String) extends ASTNode(line, column)
case class TypeConstraint(line: Int, column: Int, invocation: Invocation) extends ASTNode(line, column)