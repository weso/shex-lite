package compiler.ast.expressions.definitions

import compiler.ast.expressions.Expression
import compiler.ast.ASTWalker
import compiler.ast.expressions.types.Type

private[compiler] class ShapeDefinition(filename: String, line: Int, column: Int, name: String, dType: Type, val constraints:List[Expression])
  extends Definition(filename, line, column, name, dType, 1) {

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
