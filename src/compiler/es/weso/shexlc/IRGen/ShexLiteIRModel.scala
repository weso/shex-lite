//--------------------------------------------------------------------------------------------------
// File: ShexLiteIRModel.scala
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

package es.weso.shexlc.IRGen

import es.weso.shexlc.IRGen.javagen.{CGJava01ValidSchemaCheckingStage, CGJava02ClassGeneratorStage}
import es.weso.shexlc.internal.CompilationContext

trait ShexLiteIRModel {

  /**
   * Gets the intermediate representation model that is generated from the intermediate language model. Up to now the
   * IR model is a hashMap where the key is the target language and the value is the sequence of generated sources
   * for that language.
   *
   * @return a hash map that contains the intermediate representation model.
   */
  def getIRModel(ilModel: ShexLiteILModel, ccontext: CompilationContext): ShexLiteIRModel
}

object ShexLiteIRModel extends ShexLiteIRModel {

  /**
   * Gets the intermediate representation model that is generated from the intermediate language model. Up to now the
   * IR model is a hashMap where the key is the target language and the value is the sequence of generated sources
   * for that language.
   *
   * @return a hash map that contains the intermediate representation model.
   */
  override def getIRModel(ilModel: ShexLiteILModel, ccontext: CompilationContext): ShexLiteIRModel = {
    ilModel.getModel.accept(new CGJava01ValidSchemaCheckingStage(), ())
    ilModel.getModel.accept(new CGJava02ClassGeneratorStage(ccontext), ())
    this
  }
}
