//--------------------------------------------------------------------------------------------------
// File: ShExLiteCLI.scala
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

package es.weso.shexl.cli

import es.weso.shexl.impl.ShExLCompilerConfig
import org.backuity.clist.{CliMain, args, opt}

object ShExLiteCLI extends CliMain[Unit](name = "shexlc", description = "compile and generate target domain model objects") {

    var hideWarnings                = opt[Boolean](abbrev = "hw", description = "if present will hide the warnings")
    var generateDomainModelObjects  = opt[Boolean](default = false, abbrev = "gd", description = "if present will generate domain object models")
    // var targetLanguage              = opt[String](default = "none", description = "sets the target language [java, scala, yml, ...]")
    var files                       = args[Seq[String]](description = "ShEx-Lite sources to compile")

    def run: Unit = {
      // Create the compiler.
      val compiler = new ShExLCompilerImpl()

      // Set the configuration.
      compiler.setConfiguration(new ShExLCompilerConfig {
        override def generateWarnings: Boolean = !hideWarnings
        override def generateCode: Boolean = generateDomainModelObjects
      })

      // Add the files to compile.
      compiler.addSources(files.toList)

      // Finally compile them.
      compiler.compile

      compiler.getCompilationResult.getIndividualResults.foreach(res => res.printErrors)
      compiler.getCompilationResult.getIndividualResults.foreach(res => res.printWarnings)
    }
}
