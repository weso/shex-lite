package es.weso.shexl.compiler.parser.ast

/**
 * AST node represents a node in the Abstract Syntax Tree (AST). The nodes are generated
 * by the parser. Later they are used at semantic analysis and the tree will be attributed
 * with other information that will transform the tree in a graph but the nodes will be
 * the same but with more information. Each node always contains the file, line and column
 * where it was generated. So in case of an error we can trace back to the source code.
 */
private[compiler] trait ASTNode {

  /**
   * Gets the name of the file where the node was originated.
   *
   * @return the name of the file where the node was originated.
   */
  def getFileName: String

  /**
   * Gets the number of the line where the node was originated.
   *
   * @return the number of the line where the node was originated.
   */
  def getLine: Int

  /**
   * Gets the number of the column where the node was originated.
   *
   * @return the number of the column where the node was originated.
   */
  def getColumn: Int
}
