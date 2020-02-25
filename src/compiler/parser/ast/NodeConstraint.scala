package es.weso.shexl.compiler.parser.ast

private[compiler] case class NodeConstraint(line: Int, column: Int, reference: Reference) extends ASTNode(line, column)
