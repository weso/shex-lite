package es.weso.shexl.cli

import java.io.{File, PrintWriter}

import es.weso.shexlc.IRGen.{IR, TargetIR}
import es.weso.shexlc.internal.{CompilationConfig, CompilationContext}
import es.weso.shexlc.parse.{AbstractSyntaxTree, Parser}
import es.weso.shexlc.sema.SIL
import org.backuity.clist._
import wvlet.log.{LogLevel, LogSupport, Logger}

import scala.collection.mutable

class JavaTranslator extends Command(description = "Translates to Java domain model."){

  var withEmptyConstructor = opt[Boolean](description = "Generates an empty constructor on each generated Java class.")
  var withCommonInterface = opt[String](default="", description = "Indicate the common interface for all the generated Java classes to implement.")


}

object JavaTranslator extends LogSupport {

  trait Common { this: Command =>
    var hideWarnings = opt[Boolean](abbrev = "hw", description = "Hides the warnings generated during the compilation.")
    var atOutputFolder = opt[String](default = "", description = "Indicates the output folder where the java classes will be generated.")
    var files = args[Seq[String]](description = "ShEx-Lite sources to compile")
  }

  object ToJava extends Command(description = "Generates Java code.") with Common {
    var withPackage = opt[String](default = "", description = "Sets the package declaration of the generated Java classes.")
    var withEmptyConstuctor = opt[Boolean](description = "Adds an empty constructor to all the generated Java classes.")
    var withCommonInterface = opt[String](default = "", description = "Adds the given interface to all the generated Java classes.")
  }

  object ToPython extends Command(description = "Generates Python code.") with Common {}

  def main(args: Array[String]) {

    Cli.parse(args)
      .withProgramName("shexlc")
      .version("1.1.0")
      .withCommands(ToJava, ToPython) match {
      case Some(ToJava) => {

        val cconfig = new CompilationConfig {

          val prop = mutable.HashMap.empty[String, String]

          override def generateIR: Boolean = if (!ToJava.withPackage.isEmpty) true else false

          override def getProperties: mutable.HashMap[String, String] = {
            prop.put("java-package", ToJava.withPackage)
            prop.put("java-empty-constructor", "true")
            prop.put("java-interface", ToJava.withCommonInterface)
            prop
          }

          override def generateWarnings: Boolean = !ToJava.hideWarnings

          override def getTIR: Set[TargetIR] =
            if (!ToJava.withPackage.isEmpty) List(TargetIR.Java).toSet else Set.empty
        }

        val ccontext = CompilationContext.withConfig(cconfig)

        for (file <- ToJava.files) {
          info(s"compiling file $file")

          // 1. Parse the vile and get the syntax tree.
          info(s"parsing file $file")
          val syntaxTree = Parser.parseFile(file, ccontext)

          // 2. Get the AST.
          info(s"generating ast for file $file")
          val ast = AbstractSyntaxTree.getAST(syntaxTree)

          // 3. Get SIL.
          info(s"generating sil for file $file")
          val sil = SIL.getSIL(ast)

          // 4. Dispatch the IRGen.
          info(s"generating ir for file $file")
          val ir = IR.getIR(sil)

          // 5. Write the generated files.
          if (cconfig.generateIR) {
            info(s"writing generated sources for file $file")
            ir.getSources.get(TargetIR.Java).get.foreach(source => {
              val file         = new File(s"${ToJava.atOutputFolder}/${source._1}.java")
              val print_Writer = new PrintWriter(file)
              print_Writer.write(source._2)
              print_Writer.close()
            })
          }
        }

        // If any error during compilation print them.
        for (error <- ccontext.getErrorHandler.getErrors) { println(error.toPrintableString) }

        // If any warning print them.
        for (warning <- ccontext.getErrorHandler.getWarnings) { println(warning.toPrintableString) }

        if (ccontext.getErrorHandler.hasErrorMsgs) { error("compilation finished with errors")   }
        else                                       { info("compilation finished without errors") }



      }
      case Some(ToPython) => {
        println("Python code generation is not available frm CLI yet.")
      }
      case _ => println("Not recognized")
    }
  }
}