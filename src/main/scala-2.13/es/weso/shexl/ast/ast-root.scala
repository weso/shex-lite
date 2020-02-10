package es.weso.shexl.ast

case class ShExL(line: Int, column: Int, definitions: List[Definition]) extends ASTNode(line, column)