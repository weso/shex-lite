//------------------------------------------------------------------------------
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
//------------------------------------------------------------------------------

package es.weso.shexl.cli

import es.weso.shexlc.internal.{CompilationConfig, CompilationContext}
import es.weso.shexlc.parse.{AbstractSyntaxTree, Parser}
import es.weso.shexlc.sema.SIL
import es.weso.shexlc.IRGen.IR
import org.backuity.clist.{args, opt, CliMain}

object ShExLiteCLI
    extends CliMain[Unit](
      name        = "shexlc",
      description = "compile and generate target domain model objects"
    ) {

  var hideWarnings = opt[Boolean](
    abbrev      = "hw",
    description = "if present will hide the warnings"
  )
  var generateDomainModelObjects = opt[Boolean](
    default     = false,
    abbrev      = "gd",
    description = "if present will generate domain object models"
  )

  var files = args[Seq[String]](description = "ShEx-Lite sources to compile")

  def run: Unit = {

    // Create the compiler config from the received config.
    val cconfig = new CompilationConfig {
      override def generateIR: Boolean       = generateDomainModelObjects
      override def generateWarnings: Boolean = !hideWarnings
    }

    val ccontext = CompilationContext.withConfig(cconfig)

    for (file <- files) {
      // 1. Parse the vile and get the syntax tree.
      val syntaxTree = Parser.parseFile(file, ccontext)

      // 2. Get the AST.
      val ast = AbstractSyntaxTree.getAST(syntaxTree)

      // 3. Get SIL.
      val sil = SIL.getSIL(ast)

      // 4. Dispatch the IRGen.
      val ir = IR.getIR(sil)
    }

    // If any error during compilation print them.
    for (error <- ccontext.getErrorHandler.getErrors) {
      println(error.toPrintableString)
    }

    // If any warning print them.
    for (warning <- ccontext.getErrorHandler.getWarnings) {
      println(warning.toPrintableString)
    }
  }
}
