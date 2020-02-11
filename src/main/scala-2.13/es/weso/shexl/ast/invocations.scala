package es.weso.shexl.ast

import es.weso.shexl.visitor.ShExLVisitor

abstract class Invocation(line: Int, column: Int, var definition: Definition = null) extends ASTNode(line, column)

case class PrefixInv(line: Int, column: Int, prefixName: String, propertyName: String) extends Invocation(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}

case class ShapeInv(line: Int, column: Int, shapeName: String) extends Invocation(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}