package es.weso.compiler.parser.ast

import es.weso.shexl.compiler.parser.ast.StatementDeclaration

/**
 * A start declaration is the fact of defining a start directive where a shape is associated to the start directive.
 *
 * @param filename is the name of the file where the prefix definition appears.
 * @param line is the line in the file where the prefix definition is located.
 * @param column is the column in the file where the prefix definition is located.
 * @param shape is the reference to the shape that will be used as a start.
 */
private[compiler] case class DeclarationStart(filename: String, line: Int, column: Int, shape: ReferenceShape) extends StatementDeclaration {

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
