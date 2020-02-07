package es.weso.shexl

case class ShExL(line: Int, column: Int, definitions: List[Definition]) extends ASTNode(line, column)