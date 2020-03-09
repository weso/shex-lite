package ast

private[compiler] case class LabelShapeNode(filename: String, line: Int, column: Int, prefixInvocation: InvocationPrefix) extends LabelShape {

  /**
   * Gets the value of the label as a unique string.
   *
   * @return the value of the label as a unique string.
   */
  override def getValue: String = s"${prefixInvocation.prefix}:${prefixInvocation.property}"

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
