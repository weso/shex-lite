package es.weso.shexl.ast

import es.weso.shexl.visitor.ShExLVisitor

case class Constraint(line: Int, column: Int, field: FieldConstraint, cType: TypeConstraint) extends ASTNode(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}


case class FieldConstraint(line: Int, column: Int, prefixInv: PrefixInv) extends ASTNode(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}


case class TypeConstraint(line: Int, column: Int, invocation: Invocation) extends ASTNode(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}