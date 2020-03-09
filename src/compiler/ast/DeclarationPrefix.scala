package ast

/**
 * A prefix declaration is the fact of defining a prefix in the scheme scope. A prefix definition is nothing more than
 * the association of a label with an URI.
 *
 * @param filename is the name of the file where the prefix definition appears.
 * @param line is the line in the file where the prefix definition is located.
 * @param column is the column in the file where the prefix definition is located.
 * @param label is the name where the prefix definition will be stored.
 * @param uri is the value (uri) that will be stored at the label.
 */
private[compiler] case class DeclarationPrefix(filename: String, line: Int, column: Int, label: String, uri: ValueURI) extends StatementDeclaration {
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
