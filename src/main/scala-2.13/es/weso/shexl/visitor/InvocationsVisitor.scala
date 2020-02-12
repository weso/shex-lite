package es.weso.shexl.visitor

import es.weso.shexl.ast.{Error, PrefixInv, ShapeInv}
import es.weso.shexl.error.ErrorHandler
import es.weso.shexl.symboltable.SymbolTable

case class InvocationsVisitor() extends AbstractVisitor {

  override def visit(shapeInv: ShapeInv, param: Any): Unit = {
    val definition = SymbolTable.getShape(shapeInv.shapeName)
    if( definition.isEmpty ) {
      val shapeName = shapeInv.shapeName
      ErrorHandler.addError(Error(shapeInv.line, shapeInv.column, s"Shape [$shapeName] not defined."))
    }

    shapeInv.definition = definition.get
  }

  override def visit(prefixInv: PrefixInv, param: Any): Unit = {
    val definition = SymbolTable.getPrefix(prefixInv.prefixName)
    if( definition.isEmpty ) {
      val prefixName = prefixInv.prefixName
      ErrorHandler.addError(Error(prefixInv.line, prefixInv.column, s"Prefix [$prefixName] not defined."))
    }

    prefixInv.definition = definition.get
  }

}
