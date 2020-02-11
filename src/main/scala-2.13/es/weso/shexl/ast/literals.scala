package es.weso.shexl.ast

import es.weso.shexl.visitor.ShExLVisitor

abstract class Literal[T](line: Int, column: Int, var value: T) extends ASTNode(line, column) {
  def getValue: T = value
  def setValue(value: T) = this.value = value
}

case class URL(line:Int, column:Int, var url: String) extends Literal[String](line, column, url)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}