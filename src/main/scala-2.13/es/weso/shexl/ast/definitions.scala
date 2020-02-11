package es.weso.shexl.ast

import es.weso.shexl.visitor.ShExLVisitor

abstract class Definition(line: Int, column: Int, name: String) extends ASTNode(line, column)

case class PrefixDef(line: Int, column: Int, name: String, uri: URL) extends Definition(line, column, name)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}


case class ShapeDef(line: Int, column: Int, name: String, constraints: java.util.List[Constraint]) extends Definition(line, column, name)  {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}
