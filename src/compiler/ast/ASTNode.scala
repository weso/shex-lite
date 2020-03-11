package compiler.ast

/**
 * AST node represents a node in the Abstract Syntax Tree (AST). The nodes are generated
 * by the parser. Later they are used at semantic analysis and the tree will be attributed
 * with other information that will transform the tree in a graph but the nodes will be
 * the same but with more information. Each node always contains the file, line and column
 * where it was generated. So in case of an error we can trace back to the source code.
 */
private[compiler] abstract class ASTNode(val filename:String, val line: Int, val column: Int) {

  /**
   * Helper method for the ast walkers.
   *
   * @param walker to walk over the AST node.
   * @tparam TP is the type of the parameter.
   * @tparam TR is the type of the return object.
   * @return an object o
   */
  def walk[TP, TR] (walker: ASTWalker[TP,TR], param: TP): TR
}
