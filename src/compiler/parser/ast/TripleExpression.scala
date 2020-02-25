package es.weso.shexl.compiler.parser.ast

private[compiler] case class TripleExpression(line: Int, column: Int, tripleConstraints: List[TripleConstraint]) extends ASTNode(line, column)
