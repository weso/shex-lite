package es.weso.shexl.compiler.parser.ast

/**
 * An AST Node represents a rule from the grammar.
 *
 * @param line is the line where the node is located.
 * @param column is the column where the node is located.
 */
private[compiler] class ASTNode(line: Int = -1, column: Int = -1) {

  /**
   * @return the line in the original source code where the node was found.
   */
  def getLine: Int = line

  /**
   * @return the line in the original source code where the node was found.
   */
  def getColumn: Int = line
}
