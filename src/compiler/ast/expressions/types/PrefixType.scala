package compiler.ast.expressions.types
import compiler.ast.ASTWalker

private[compiler] object PrefixType extends AbstractType {

  // Sets the number of bytes of this type to 0. This type wont
  super.NUMBER_OF_BYTES = 0

  /**
   * Helper method for the ast walkers.
   *
   * @param walker to walk over the AST node.
   * @tparam TP is the type of the parameter.
   * @tparam TR is the type of the return object.
   * @return an object o
   */
  override def walk[TP, TR](walker: ASTWalker[TP, TR], param: TP): TR = ???
}
