package compiler.ast

private[compiler] case class LabelShapeURI(filename: String, line: Int, column: Int, name:String, var base: DeclarationBase = null) extends LabelShape {

  /**
   * Gets the value of the label as a unique string.
   *
   * @return the value of the label as a unique string.
   */
  override def getValue: String = s"${base.uri}:$name"

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
