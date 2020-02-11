package es.weso.shexl.ast

abstract class Definition(line: Int, column: Int, name: String) extends ASTNode(line, column)

case class PrefixDef(line: Int, column: Int, name: String, uri: URL) extends Definition(line, column, name)
case class ShapeDef(line: Int, column: Int, name: String, constraints: java.util.List[Constraint]) extends Definition(line, column, name)