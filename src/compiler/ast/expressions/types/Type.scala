package compiler.ast.expressions.types

import compiler.ast.ASTNode

/**
 * The type interface defines the abstraction for every type in shex-lite.
 * Every type is represented by:
 *  - The number of bytes that it needs to be sored in memory.
 *  - Whether it is or it is not a reference.
 *  - Whether it is or it is not an error.
 */
private[compiler] trait Type extends ASTNode {

  /**
   * Gets the number of bytes.
   *
   * @return the number of bytes
   */
  def getNumberOfBytes: Int

  /**
   * Checks if is reference type.
   *
   * @return true, if is reference type
   */
  def isReferenceType: Boolean

  /**
   * Checks whether a type is an instance of error type or not.
   *
   * @return whether the type represents an error or not.
   */
  def isError: Boolean

}
