package es.weso.shexl.visitor

import es.weso.shexl.ast.{PrefixDef, PrefixInv, ShapeDef, ShapeInv, Error}
import es.weso.shexl.error.ErrorHandler
import es.weso.shexl.symboltable.SymbolTable

import scala.collection.JavaConverters

case class DefinitionsVisitor() extends AbstractVisitor {


  override def visit(shapeDef: ShapeDef, param: Any) = {
    if(SymbolTable.getShape(shapeDef.name).isDefined) {
      val shapeName = shapeDef.name
      ErrorHandler.addError(Error(shapeDef.line, shapeDef.column, s"Shape id [$shapeName] is duplicated."))
    } else {
      SymbolTable insert shapeDef
    }

    for(constraint <- JavaConverters.asScalaIterator(shapeDef.constraints.iterator())) {
      constraint accept (this, param)
    }
  }

  override def visit(prefixDef: PrefixDef, param: Any) = {
    prefixDef.name match {
      case null => {
        if(SymbolTable.getPrefix(" ").isDefined) {
          ErrorHandler.addError(Error(prefixDef.line, prefixDef.column, "Cannot be to default prefixes"))
        } else {
          SymbolTable insert PrefixDef(prefixDef.line, prefixDef.column, " ", prefixDef.uri)
        }
      }

      case _ => {
        if(SymbolTable.getPrefix(prefixDef.name).isDefined) {
          val prefixName = prefixDef.name
          ErrorHandler.addError(Error(prefixDef.line, prefixDef.column, s"Prefix id [$prefixName] is duplicated."))
        } else {
          SymbolTable insert prefixDef
        }
      }
    }

    prefixDef.uri.accept(this, param)
  }
}
