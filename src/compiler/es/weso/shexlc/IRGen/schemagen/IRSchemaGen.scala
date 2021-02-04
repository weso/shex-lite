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
    new IRSchemaGen {

      /**
        * Gets the generated sources from the generator.
        *
        * @return a list of generated sources where the first element is the name
        *         and the second the source itself.
        */
      override def getGeneratedSources: List[(String, String)] = {
        val visitor = new CGSchemaGenerationStage(sil.getCompilationContext)
        sil.getGraphEntryPoint.accept(visitor, "");

        val generatedSchemaFile = ("schema.json", visitor.schema.toString())
        List(generatedSchemaFile)
      }
    }
  }
}