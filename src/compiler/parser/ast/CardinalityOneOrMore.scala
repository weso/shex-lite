package es.weso.shexl.compiler.parser.ast

private[compiler] case class CardinalityOneOrMore(line: Int, column: Int) extends Cardinality(line, column)