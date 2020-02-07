package es.weso.shexl

abstract class ASTNode(line: Int, column: Int) {
  def getLine: Integer
  def getColumn: Integer
}

trait Definition extends ASTNode {}

case class ShExL(line: Int, column: Int, definitions: List[Definition]) extends ASTNode {
  override def getLine: Integer = line
  override def getColumn: Integer = column
}

case class PrefixDefinition(line: Integer, column: Integer, name: String, uri: URL) extends Definition {
  override def getLine: Integer = line
  override def getColumn: Integer = column
}

case class ShapeDefinition(line: Integer, column: Integer, name: String, shapeConsatraint: ShapeConsatraint) extends
  ASTNode {

}

case class URL(url: String)