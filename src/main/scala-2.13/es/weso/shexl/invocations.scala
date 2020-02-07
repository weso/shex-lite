package es.weso.shexl

class Invocation(line: Int, column: Int, var definition: Definition = null) extends ASTNode(line, column)

case class PrefixInv(line: Int, column: Int, prefixName: String) extends Invocation(line, column)
case class ShapeInv(line: Int, column: Int, shapeName: String) extends Invocation(line, column)
