package es.weso.shexl.compiler.parser.ast

private[compiler] class Cardinality(line: Int, column: Int, min: Int = -1, max: Int = -1) extends ASTNode(line, column)

