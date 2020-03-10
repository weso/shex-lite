package compiler.ast.expressions.types

import compiler.ast.{ASTNode, ASTWalker}

/**
 * Represents an error. An error in shex-lite is an event that does not allow the end of the compilation process.
 * For example that a start directive is redefined or that a reference point to a non-existing definition.
 *
 * @param astNode where the error took place.
 * @param message describing the error.
 */
private[compiler] class ErrorType(val astNode: ASTNode, val message: String) extends AbstractType {

  // Sets the number of bytes of this type to 0. This type wont
  super.NUMBER_OF_BYTES = 0

  /**
   * Returns true as this type represents an error.
   *
   * @return whether the type represents an error or not.
   *         Always true in this case.
   */
  override def isError: Boolean = true;

  /**
   * Format of the errors.
   *
   * @return an string object containing the error location and message.
   */
  override def toString: String = {
    s"error[${astNode.filename}::${astNode.line}:${astNode.column}] $message."
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
