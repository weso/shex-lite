package es.weso.shexl.symboltable

import java.util.Objects

import es.weso.shexl.ast.{PrefixDef, ShapeDef, ShapeInv}

import scala.collection.mutable.HashMap

object SymbolTable {

  final val prefixes = HashMap[String, PrefixDef]()
  final val shapes = HashMap[String, ShapeDef]()

  /**
   *
   * @param prefixDef
   * @return
   */
  def insert(prefixDef: PrefixDef) = {
    if(Objects.nonNull(prefixDef)) {
      this.prefixes += (prefixDef.name -> prefixDef)
    }
  }

  /**
   *
   * @param shapeDef
   * @return
   */
  def insert(shapeDef: ShapeDef)  = {
    if(Objects.nonNull(shapeDef)) {
      this.shapes += (shapeDef.name -> shapeDef)
    }
  }

  /**
   *
   * @param prefixName
   * @return
   */
  def getPrefix(prefixName: String): Option[PrefixDef] = {
    this.prefixes.get(prefixName)
  }

  /**
   *
   * @param shapeName
   * @return
   */
  def getShape(shapeName: String): Option[ShapeDef] = {
    this.shapes.get(shapeName)
  }
}
