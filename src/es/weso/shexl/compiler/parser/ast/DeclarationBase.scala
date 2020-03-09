package es.weso.compiler.parser.ast

import es.weso.shexl.compiler.parser.ast.StatementDeclaration

/**
 * A base declaration is the definition of the prefix that will be used at any relative URI.
 *
 * @param filename is the name of the file where the prefix definition appears.
 * @param line is the line in the file where the prefix definition is located.
 * @param column is the column in the file where the prefix definition is located.
 * @param uri is the value (uri) that will be stored at the label.
 */
private[compiler] case class DeclarationBase(filename: String, line: Int, column: Int, uri: ValueURI) extends StatementDeclaration {

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
