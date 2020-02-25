package es.weso.shexl.compiler.parser.ast

private[compiler] case class ShapeDefinition(line: Int, column: Int, shapeLbl: String, tripleExpr: TripleExpression) extends Definition(line, column)