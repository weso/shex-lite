package es.weso.shexl.compiler.parser.ast

private[compiler] case class PrefixReference(line: Int, column: Int) extends Reference(line, column)
