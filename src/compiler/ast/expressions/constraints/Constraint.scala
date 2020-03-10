package compiler.ast.expressions.constraints

import compiler.ast.expressions.AbstractExpression

private[compiler] abstract class Constraint(filename: String, line: Int, column:Int)
  extends AbstractExpression(filename, line, column)
