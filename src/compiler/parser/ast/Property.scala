package es.weso.shexl.compiler.parser.ast

private[compiler] case class Property(line: Int, column: Int, prefixReference: PrefixReference, propertyName: String) extends ASTNode(line, column)
