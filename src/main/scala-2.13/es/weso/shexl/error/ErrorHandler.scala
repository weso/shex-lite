package es.weso.shexl.error

import es.weso.shexl.ast.Error

import scala.collection.mutable.ListBuffer

object ErrorHandler {

  final val errors = new ListBuffer[Error]()

  def hasErrors: Boolean = {
    !this.errors.isEmpty
  }

  def addError(error: Error) = {
    this.errors += error
  }

  def showErrors(): Unit = {
    for(error <- errors) {
      println( "ERROR [$line, $column] -> $message", error.line, error.column, error.message)
    }
  }
}
