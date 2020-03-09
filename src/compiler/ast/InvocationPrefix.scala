package ast

case class InvocationPrefix(filename: String, line: Int, column: Int, prefix: String, property: String, var declaration: DeclarationPrefix = null) extends Invocation[DeclarationPrefix] {

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

  /**
   * Gets the associated declaration.
   *
   * @return the original declaration.
   */
  override def getDeclaration(): DeclarationPrefix = declaration

  /**
   * Sets the declaration value.
   *
   * @param declaration to be set as the original declaration.
   */
  override def setDeclaration(declaration: DeclarationPrefix): Unit = this.declaration = declaration
}
