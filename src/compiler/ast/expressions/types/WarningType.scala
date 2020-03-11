package compiler.ast.expressions.types

import compiler.ast.{ASTNode, ASTWalker}

/**
 *
 * @param astNode
 * @param message
 */
private[compiler] class WarningType(val astNode: ASTNode, val message: String) extends AbstractType {

  // Sets the number of bytes of this type to 0. This type wont
  super.NUMBER_OF_BYTES = 0;

  /**
   * Format of the errors.
   *
   * @return an string object containing the error location and message.
   */
  override def toString: String = {
    s"warning[${astNode.filename}::${astNode.line}:${astNode.column}] $message."
  }

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
