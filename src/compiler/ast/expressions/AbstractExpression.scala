package compiler.ast.expressions

import compiler.ast.expressions.types.Type

private[compiler] abstract class AbstractExpression(filename: String, line: Int, column: Int, eType: Type = null, lValue: Boolean = false)
  extends Expression(filename, line, column, eType, lValue) {

}
