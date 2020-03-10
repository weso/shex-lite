package compiler.ast.expressions.literals

import compiler.ast.expressions.AbstractExpression

private[compiler] abstract class Literal[T](filename: String, line: Int, column: Int, val value: T)
  extends AbstractExpression(filename, line, column)
