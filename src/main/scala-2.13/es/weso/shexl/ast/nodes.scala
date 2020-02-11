package es.weso.shexl.ast

import es.weso.shexl.visitor.ShExLVisitor

sealed trait Node {
  def getLine: Integer
  def getColumn: Integer
}

abstract class ASTNode(line: Int, column: Int) extends Node {
  override def getLine: Integer = line
  override def getColumn: Integer = column

  def accept(v: ShExLVisitor, param: Any)
}
