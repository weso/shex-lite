package es.weso.shexl.ast

class Invocation(line: Int, column: Int, var definition: Definition = null) extends ASTNode(line, column)

case class PrefixInv(line: Int, column: Int, prefixName: String, propertyName: String) extends Invocation(line, column)
case class ShapeInv(line: Int, column: Int, shapeName: String) extends Invocation(line, column)
