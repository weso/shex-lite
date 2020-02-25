package es.weso.shexl.compiler.parser.ast

private[compiler] class Literal[T](line: Int, column: Int, value: T) extends ASTNode(line, column)
