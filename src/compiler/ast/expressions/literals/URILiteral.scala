package compiler.ast.expressions.literals

import compiler.ast.ASTWalker

private[compiler] class URILiteral(filename: String, line: Int, column: Int, value: String)
  extends Literal[String](filename, line, column, value) {

  /**
   * Helper method for the ast walkers.
   *
   * @param walker to walk over the AST node.
   * @tparam TP is the type of the parameter.
   * @tparam TR is the type of the return object.
   * @return an object o
   */
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = ???
}
