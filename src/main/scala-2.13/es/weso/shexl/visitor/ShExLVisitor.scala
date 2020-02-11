package es.weso.shexl.visitor

import es.weso.shexl.ast.{Constraint, Definition, FieldConstraint, Invocation, PrefixDef, PrefixInv, ShExL, ShapeDef, ShapeInv, Type, TypeConstraint, URL}

trait ShExLVisitor {

  def visit(node: ShExL, param: Any)

  def visit(node: PrefixDef, param: Any)

  def visit(node: ShapeDef, param: Any)

  def visit(node: Constraint, param: Any)

  def visit(node: FieldConstraint, param: Any)

  def visit(node: TypeConstraint, param: Any)

  def visit(node: PrefixInv, param: Any)

  def visit(node: ShapeInv, param: Any)

  def visit(node: URL, param: Any)

  def visit(node: Type, param: Any)
}
