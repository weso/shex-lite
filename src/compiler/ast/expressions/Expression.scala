package compiler.ast.expressions

import compiler.ast.ASTNode
import compiler.ast.expressions.types.Type

private[compiler] abstract class Expression(filename: String, line: Int, column: Int, val eType: Type, val lValue: Boolean)
  extends ASTNode(filename, line, column)