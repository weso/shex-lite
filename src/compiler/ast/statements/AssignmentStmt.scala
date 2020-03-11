package compiler.ast.statements

import compiler.ast.expressions.{Expression, VariableExpression}
import compiler.ast.ASTWalker

private[compiler] class AssignmentStmt(filename: String, line: Int, column: Int, val variable: VariableExpression, val expression: Expression)
  extends Statement(filename, line, column) {

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
