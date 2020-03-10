package compiler.ast.expressions

import compiler.ast.ASTWalker
import compiler.ast.expressions.constraints.ValueSetValidType
import compiler.ast.expressions.definitions.Definition

private[compiler] class VariableExpression(filename: String, line: Int, column: Int, val name: String, val definition: Definition)
  extends AbstractExpression(filename: String, line: Int, column: Int) with ValueSetValidType {

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
