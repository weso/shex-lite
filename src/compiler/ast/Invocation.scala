package compiler.ast

/**
 *
 */
private[compiler] trait Invocation[T <: StatementDeclaration] extends ConstraintNode with ValueSetValidType {

  /**
   * Gets the associated declaration.
   *
   * @return the original declaration.
   */
  def getDeclaration(): T

  /**
   * Sets the declaration value.
   *
   * @param declaration to be set as the original declaration.
   */
  def setDeclaration(declaration: T)
}
