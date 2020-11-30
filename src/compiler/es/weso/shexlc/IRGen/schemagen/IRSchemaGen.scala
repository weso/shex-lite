package es.weso.shexlc.IRGen.schemagen

import es.weso.shexlc.IRGen.IRGenerator
import es.weso.shexlc.IRGen.javagen.IRJavaGen
import es.weso.shexlc.sema.SIL

trait IRSchemaGen extends IRGenerator {}

object IRSchemaGen {

  /**
    * Gets the java generation from the Shex-lite intermediate language.
    *
    * @param sil is the shex-lite intermediate language used for the java
    *            generation.
    * @return an IRGenerator object.
    */
  def getIR(sil: SIL): IRSchemaGen = {
    null
  }
}