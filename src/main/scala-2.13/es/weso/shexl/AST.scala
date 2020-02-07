package es.weso.shexl

sealed trait Node {
  def getLine: Integer
  def getColumn: Integer
}

class ASTNode(line: Int, column: Int) extends Node {
  override def getLine: Integer = line
  override def getColumn: Integer = column
}

class Type(line: Int, column: Int) extends ASTNode(line, column)

class Cardinality(line: Int, column: Int) extends ASTNode(line, column)

abstract class Definition(line: Int, column: Int) extends ASTNode(line, column)

abstract class Statement(line: Int, column: Int) extends ASTNode(line, column)

abstract class Expression(line: Int, column: Int) extends ASTNode(line, column)

case class ShExL(line: Int, column: Int, definitions: List[Definition]) extends ASTNode(line, column)

case class PrefixDef(line: Integer, column: Integer, name: String, uri: URL) extends Definition(line, column)

case class ShapeDef(line: Integer, column: Integer, name: String, shapeConstraints: List[Statement]) extends Definition(line, column)

case class ShapeConstraintStmt(line: Int, column: Int, constraintName: String, constraintType: Type, cardinality: Cardinality) extends Statement(line, column)

abstract class Literal[T](line: Int, column: Int) extends ASTNode(line, column) {
  def getValue: T
  def setValue(value: T)
}

case class URL(line:Int, column:Int, var url: String) extends Literal[String](line, column) {

  override def getValue: String = url

  override def setValue(value: String) = this.url = url
}