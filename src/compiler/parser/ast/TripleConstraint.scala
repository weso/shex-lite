package es.weso.shexl.compiler.parser.ast

private[compiler] case class TripleConstraint(line: Int, column: Int, property: Property, nodeConstraint: NodeConstraint, cardinality: Cardinality) extends ASTNode(line, column)