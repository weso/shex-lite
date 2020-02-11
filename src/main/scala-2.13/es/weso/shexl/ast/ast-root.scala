package es.weso.shexl.ast
import es.weso.shexl.visitor.ShExLVisitor

case class ShExL(line: Int, column: Int, definitions: java.util.List[Definition]) extends ASTNode(line, column) {
  override def accept(v: ShExLVisitor, param: Any): Unit = v.visit(this, param)
}