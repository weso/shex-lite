package es.weso.shexl.ast

class Type(line: Int, column: Int) extends ASTNode(line, column)

object Int extends Type(-1, -1)
object String extends Type(-1, -1)
object Long extends Type(-1, -1)
object Double extends Type(-1, -1)
case class Error(line: Int, column: Int, message: String) extends Type(line, column)