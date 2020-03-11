package compiler.ast.expressions.definitions

import compiler.ast.ASTWalker
import compiler.ast.expressions.types.Type

private[compiler] class VariableDefinition(filename: String, line: Int, column: Int, name: String, vType: Type, scope: Int)
  extends Definition(filename, column, line, name, vType, scope) {

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
