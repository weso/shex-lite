package es.weso.shexl.compiler.parser.ast

private[compiler] case class CardinalityZeroOrMore(line: Int, column: Int) extends Cardinality(line, column)