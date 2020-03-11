package compiler.ast.expressions.types

/**
 * The abstract type adds the default implementation for all the types of shex-lite.
 *
 */
private abstract class AbstractType extends Type {

  // Represents the number of bytes needed to represent the type in memory.
  protected var NUMBER_OF_BYTES = 0

  /**
   * Gets the number of bytes.
   *
   * @return the number of bytes
   */
  override def getNumberOfBytes: Int = NUMBER_OF_BYTES

  /**
   * Checks if is reference type.
   *
   * @return true, if is reference type
   */
  override def isReferenceType: Boolean = false

  /**
   * Checks whether a type is an instance of error type or not.
   *
   * @return whether the type represents an error or not.
   */
  override def isError: Boolean = false
}
