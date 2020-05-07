//--------------------------------------------------------------------------------------------------
// File: IRJavaGen.scala
//
// Short version for non-lawyers:
//
// The ShEx Lite Project is dual-licensed under GNU 3.0 and
// MIT terms.
//
// Longer version:
//
// Copyrights in the ShEx Lite project are retained by their contributors. No
// copyright assignment is required to contribute to the ShEx Lite project.
//
// Some files include explicit copyright notices and/or license notices.
// For full authorship information, see the version control history.
//
// Except as otherwise noted (below and/or in individual files), ShEx Lite is
// licensed under the GNU, Version 3.0 <LICENSE-GNU> or
// <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
// <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
// In case of incompatibility between project licenses, GNU/GPLv3 will be
// applied.
//
// The ShEx Lite Project includes packages written by third parties.
//--------------------------------------------------------------------------------------------------

package es.weso.shexlc.IRGen.javagen

import es.weso.shexlc.IRGen.{IRGenerator, TargetIR}
import es.weso.shexlc.sema.SIL

//--------------------------------------------------------------------------------------------------
//
// This file has been generated through the framework of the HERCULES-ASIO project.
// For more information please see https://github.com/weso/shex-lite/issues/0121.
//
//--------------------------------------------------------------------------------------------------

/**
 * The intermediate representation of the java code are the different domain model objects generated from the
 * shapes.
 *
 * @override Guillermo Facundo Colunga
 */
trait IRJavaGen extends IRGenerator {

}

object IRJavaGen {

  /**
   * Gets the java generation from the Shex-lite intermediate language.
   *
   * @param sil is the shex-lite intermediate language used for the java generation.
   * @return an IRGenerator object.
   */
  def getIR(sil: SIL): IRJavaGen = new IRJavaGen {

    // The java feature checker object.
    private[this] val javaFeatureChecker = new CGJava01ValidSchemaCheckingStage(sil.getCompilationContext)

    // The java class generator object.
    private[this] val javaClassGenerator = new CGJava02ClassGeneratorStage(sil.getCompilationContext)

    /**
     * Gets the generated sources if any. The generated sources are a list of tuples where the first element is the
     * name of the generated source and the second value is its content.
     *
     * @return the list of tuples that contain the name of the source and the source content.
     */
    override def getGeneratedSources: List[(String, String)] = {
      if(sil.getCompilationContext.getConfiguration.getTIR.contains(TargetIR.Java)) {

        // 1. Validate that the SIL represents a valid schema for the representation.
        sil.getGraphEntryPoint.accept(javaFeatureChecker, ())

        // 2. If during the validation any error was generated then generate the target code.
        if(!sil.getCompilationContext.getErrorHandler.hasErrorMsgs) {
          sil.getGraphEntryPoint.accept(javaClassGenerator, ())
          javaClassGenerator.generatedSources.toList
        } else {
          List.empty[(String,String)] // An empty list.
        }

      } else {
        List.empty[(String,String)] // An empty list.
      }
    }
  }
}
