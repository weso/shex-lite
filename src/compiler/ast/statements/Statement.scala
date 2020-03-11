package compiler.ast.statements

import compiler.ast.ASTNode

private[compiler] abstract class Statement(filename: String, line: Int, column: Int) extends ASTNode(filename, line, column)
