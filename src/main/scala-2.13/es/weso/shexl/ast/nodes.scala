package es.weso.shexl.ast

sealed trait Node {
  def getLine: Integer
  def getColumn: Integer
}

class ASTNode(line: Int, column: Int) extends Node {
  override def getLine: Integer = line
  override def getColumn: Integer = column
}
