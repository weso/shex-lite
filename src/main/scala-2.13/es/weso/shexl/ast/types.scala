package es.weso.shexl.ast

import es.weso.shexl.visitor.ShExLVisitor

class Type(line: Int, column: Int) extends ASTNode(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}

object Int extends Type(-1, -1)
object String extends Type(-1, -1)
object Long extends Type(-1, -1)
object Double extends Type(-1, -1)


case class Error(line: Int, column: Int, message: String) extends Type(line, column)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}