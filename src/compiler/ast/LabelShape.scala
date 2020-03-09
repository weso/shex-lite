package ast

private[compiler] trait LabelShape extends ASTNode {

  /**
   * Gets the value of the label as a unique string.
   *
   * @return the value of the label as a unique string.
   */
  def getValue: String
}
