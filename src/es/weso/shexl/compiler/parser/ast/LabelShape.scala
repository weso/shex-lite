package es.weso.compiler.parser.ast

import es.weso.shexl.compiler.parser.ast.ASTNode

private[compiler] trait LabelShape extends ASTNode {

  /**
   * Gets the value of the label as a unique string.
   *
   * @return the value of the label as a unique string.
   */
  def getValue: String
}
