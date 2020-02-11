package es.weso.shexl.ast

case class ShExL(line: Int, column: Int, definitions: java.util.List[Definition]) extends ASTNode(line, column)