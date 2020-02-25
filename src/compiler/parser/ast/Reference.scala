package es.weso.shexl.compiler.parser.ast

private[compiler] class Reference(line: Int, column: Int, definition: Definition = null) extends ASTNode(line, column)