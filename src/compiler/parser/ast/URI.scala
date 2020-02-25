package es.weso.shexl.compiler.parser.ast

case class URI(line: Int, column: Int, value: String) extends Literal[String](line, column, value)
