package es.weso.shexl.cli

import es.weso.shexl.impl.{ShExLCompilerImpl, ShExLCompilerConfig}
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
    }
}
