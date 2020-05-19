//------------------------------------------------------------------------------
// File: IR.scala
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
//------------------------------------------------------------------------------

package es.weso.shexlc.IRGen

import es.weso.shexlc.IRGen.javagen.IRJavaGen
import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.sema.SIL

import scala.collection.mutable.HashMap

/**
  * The intermediate representation is the result of the code generation for
  * the shex-lite compiler. It contains
  * all the sources generated for the different target languages. Each
  * generated source is represented by a tuple where
  * the first element is the name of the source file and the second the value
  * (its content).
  *
  * @author Guillermo Facundo Colunga
  */
trait IR {

  /**
    * Gets the compilation context.
    *
    * @return the compilation context.
    */
  def getCompilationContext: CompilationContext

  /**
    * Gets all the generated sources indexed by the target intermediate
    * representation.
    *
    * @return a list of tuples, each one represents a source file and the
    *         first value is the source file name, the second
    *         is its content.
    */
  def getSources: Map[TargetIR, List[(String, String)]]
}

object IR {

  def getIR(sil: SIL): IR =
    new IR {

      private[this] val sources = HashMap.empty[TargetIR, List[(String, String)]]

      // Java code generation.
      val javaGen = IRJavaGen.getIR(sil)

      // Add the sources from the java generation to the list of sources.
      sources.put(TargetIR.Java, javaGen.getGeneratedSources)

      /**
        * Gets all the generated sources for a target language. For example for
        * java will get all the objects generated from
        * a shex-lite file or some of them.
        *
      * @return a list of tuples, each one represents a source file and the
        *         first value is the source file name, the second
        *         is its content.
        */
      override def getSources: Map[TargetIR, List[(String, String)]] = sources.toMap

      /**
        * Gets the compilation context.
        *
      * @return the compilation context.
        */
      override def getCompilationContext: CompilationContext = sil.getCompilationContext
    }
}
