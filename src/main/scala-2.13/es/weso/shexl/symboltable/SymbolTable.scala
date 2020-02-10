package es.weso.shexl.symboltable

import java.util.{Objects}

import es.weso.shexl.ast.{PrefixDef, ShapeDef}

import scala.collection.mutable.HashMap

case class SymbolTable() {

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
   * @param prefixDef
   * @return
   */
  def get(prefixDef: PrefixDef): Option[PrefixDef] = {
    this.prefixes.get(prefixDef.name)
  }

  /**
   *
   * @param shapeDef
   * @return
   */
  def get(shapeDef: ShapeDef): Option[ShapeDef] = {
    this.shapes.get(shapeDef.name)
  }
}
