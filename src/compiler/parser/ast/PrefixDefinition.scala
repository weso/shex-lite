package es.weso.shexl.compiler.parser.ast

private[compiler] case class PrefixDefinition(line: Int, column: Int, prefixName: String, prefixURI: URI) extends Definition(line, column)
