package compiler.ast

/**
 *
 * @tparam TP
 * @tparam TR
 */
private[compiler] trait ASTWalker[TP, TR] {

  def walk(schema: Schema, param: TP): TR
}
