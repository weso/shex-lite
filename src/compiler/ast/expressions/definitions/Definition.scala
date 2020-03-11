package compiler.ast.expressions.definitions

import compiler.ast.expressions.types.Type
import compiler.ast.statements.Statement

private[compiler] abstract class Definition(filename: String, line: Int, column: Int, val name: String, val dType: Type, val scope: Int)
  extends Statement(filename, line, column) {


}
