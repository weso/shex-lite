package es.weso.shexl

class Type(line: Int, column: Int) extends ASTNode(line, column)

object Int extends Type(-1, -1)
object String extends Type(-1, -1)
object Long extends Type(-1, -1)
object Double extends Type(-1, -1)