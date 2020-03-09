package es.weso.compiler.parser.ast

import es.weso.shexl.compiler.parser.ast.{Expression, StatementDeclaration}

/**
 * A shape declaration is the fact of associating an expression with a shape label.
 *
 * @param filename is the name of the file where the prefix definition appears.
 * @param line is the line in the file where the prefix definition is located.
 * @param column is the column in the file where the prefix definition is located.
 * @param shapeLabel is the label that will be associated with the expression.
 * @param expression is used to validate the nodes, therefore it includes the constraints.
 */
private[compiler] case class DeclarationShape(filename: String, line: Int, column: Int, shapeLabel: LabelShape, expression: Expression) extends StatementDeclaration {

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
