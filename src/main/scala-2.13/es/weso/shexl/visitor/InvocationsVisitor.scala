package es.weso.shexl.visitor

import es.weso.shexl.ast.{Error, PrefixInv, ShapeInv}
import es.weso.shexl.error.ErrorHandler
import es.weso.shexl.symboltable.SymbolTable

case class InvocationsVisitor() extends AbstractVisitor {

  override def visit(shapeInv: ShapeInv, param: Any): Unit = {
    if( SymbolTable.getShape(shapeInv.shapeName).isEmpty ) {
      val shapeName = shapeInv.shapeName
      ErrorHandler.addError(new Error(shapeInv.line, shapeInv.column, s"Shape [$shapeName] not defined."))
    }
    //shapeInv.definition.accept(this, param)
  }

  override def visit(prefixInv: PrefixInv, param: Any): Unit = {
    if( SymbolTable.getPrefix(prefixInv.prefixName).isEmpty ) {
      val prefixName = prefixInv.prefixName
      ErrorHandler.addError(new Error(prefixInv.line, prefixInv.column, s"Prefix [$prefixName] not defined."))
    }
    //prefixInv.definition.accept(this, param)
  }

}
