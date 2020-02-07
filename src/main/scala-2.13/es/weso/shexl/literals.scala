package es.weso.shexl

class Literal[T](line: Int, column: Int, var value: T) extends ASTNode(line, column) {
  def getValue: T = value
  def setValue(value: T) = this.value = value
}

case class URL(line:Int, column:Int, var url: String) extends Literal[String](line, column, url)
case class IntLiteral(line:Int, column:Int, var int: Int) extends Literal[Int](line, column, int)
case class StringLiteral(line:Int, column:Int, var string: String) extends Literal[String](line, column, string)
case class DoubleLiteral(line:Int, column:Int, var double: Double) extends Literal[Double](line, column, double)