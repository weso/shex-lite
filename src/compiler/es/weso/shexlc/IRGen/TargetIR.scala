//--------------------------------------------------------------------------------------------------
// File: CompilerTargetLanguage.scala
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

/**
 * The Shape Expression Lite Target Intermediate Representation represents the standardized abstraction of the possible
 * target language for the code generation. Each standardized possible target language has a description field that
 * contains the name of the language that ir represents.
 *
 * @author Guillermo Facundo Colunga
 */
trait TargetIR {

  /**
   * Gets the description of a target language, this description will be key used to index the target language.
   *
   * @return the description of a target language.
   */
  def getDescription: String
}

object TargetIR {

  val Java = new TargetIR {
    override def getDescription: String = "java"
  }

  val Kotlin = new TargetIR {
    override def getDescription: String = "kotlin"
  }

  val Scala = new TargetIR {
    override def getDescription: String = "scala"
  }

  val Python = new TargetIR {
    override def getDescription: String = "python"
  }

  val Rust = new TargetIR {
    override def getDescription: String = "rust"
  }

  val Swift = new TargetIR {
    override def getDescription: String = "swift"
  }

  val HTML = new TargetIR {
    override def getDescription: String = "html"
  }
}



