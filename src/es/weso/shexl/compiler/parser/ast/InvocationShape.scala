package es.weso.compiler.parser.ast

/**
 *
 * @param filename
 * @param line
 * @param column
 * @param prefixInvocation
 * @param declaration
 */
case class InvocationShape(filename: String, line: Int, column: Int, prefixInvocation: InvocationPrefix, var declaration: DeclarationShape = null) extends Invocation[DeclarationShape] {

  /**
   * Gets the associated declaration.
   *
   * @return the original declaration.
   */
  override def getDeclaration(): DeclarationShape = declaration

  /**
   * Sets the declaration value.
   *
   * @param declaration to be set as the original declaration.
   */
  override def setDeclaration(declaration: DeclarationShape): Unit = this.declaration = declaration

  /**
   * Gets the name of the file where the node was originated.
   *
   * @return the name of the file where the node was originated.
   */
  override def getFileName: String = filename

  /**
   * Gets the number of the line where the node was originated.
   *
   * @return the number of the line where the node was originated.
   */
  override def getLine: Int = line

  /**
   * Gets the number of the column where the node was originated.
   *
   * @return the number of the column where the node was originated.
   */
  override def getColumn: Int = column
}
