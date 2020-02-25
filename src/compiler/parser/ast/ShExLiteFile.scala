package es.weso.shexl.compiler.parser.ast

/**
 *
 * @param definitions
 */
private[compiler] case class ShExLiteFile(line: Int, column: Int, definitions: List[Definition]) extends ASTNode(line, column)

