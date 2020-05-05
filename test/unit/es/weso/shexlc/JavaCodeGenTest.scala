//--------------------------------------------------------------------------------------------------
// File: JavaCodeGenTest.scala
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

package es.weso.shexlc

import java.io.File

import es.weso.shexl.ShExLCompilerTargetLanguage
import es.weso.shexl.impl.ShExLCompilerConfig
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class JavaCodeGenTest extends AnyFunSuite with BeforeAndAfter {

  var compiler = new ShExLCompilerImpl()
  var config = new ShExLCompilerConfig {
    override def generateWarnings: Boolean = true
    //override def getTargetGenerationLanguage: String = targetLanguage
    override def generateCode: Boolean = true
  }
  compiler.setConfiguration(config)

  generateTestCases()

  private[this] def generateTestCases(): Unit = {
    val correctFiles = getListOfFiles("test/assets", "input_correct")
    val incorrectFiles = getListOfFiles("test/assets", "input_incorrect")

    for(file <- correctFiles) {
      test(s"Compiling file and generating code for file $file should pass without errors") {
        // Parsing a sample file that contains a base redefinition.
        val compilationResult = compiler.addSource(file).compile.getCompilationResult
        compilationResult.getIndividualResults.last.printErrors
        compilationResult.getIndividualResults.last.printWarnings

        val sources = compilationResult.getIndividualResults.toList(0).getGeneratedSources.get(ShExLCompilerTargetLanguage.Java).get.toList
        sources.foreach(source => println(source.getSource))

        assert(!compilationResult.hasErrors)
      }
    }

    for(file <- incorrectFiles) {
      test(s"Compiling file and generating code for file $file should pass without errors") {
        // Parsing a sample file that contains a base redefinition.
        val compilationResult = compiler.addSource(file).compile.getCompilationResult
        compilationResult.getIndividualResults.last.printErrors
        compilationResult.getIndividualResults.last.printWarnings
        println(compilationResult.getIndividualResults
          .foreach(res => res.getGeneratedSources.size))
        assert(compilationResult.hasErrors)
      }
    }
  }

  test("Compile a single file, generate code for it and test that the code is well generated.") {

    val compiler = new ShExLCompilerImpl().setConfiguration(new ShExLCompilerConfig {
      override def generateWarnings: Boolean = true
      override def generateCode: Boolean = true
    })

    var compileResult =
      compiler
        .addSource("test/assets/input_correct_java_schema_user_car_1.shexl")
        .compile.getCompilationResult

    assert(!compileResult.hasErrors)
    compileResult.getIndividualResults.foreach(result => result.getGeneratedSources.get(ShExLCompilerTargetLanguage.Java).get.foreach(source => println(source.getSource)))
    val expected = "import java.util.List;\n\npublic class User {\n\tprivate String name;\n\tprivate String surname;\n\tprivate int age;\n\tprivate List<User> knows;\n\n\tpublic User(String name, String surname, int age, List<User> knows) {\n\t\tthis.name = name;\n\t\tthis.surname = surname;\n\t\tthis.age = age;\n\t\tthis.knows = knows;\n\t}\n\n\tpublic String getName() {\n\t\treturn this.name;\n\t}\n\n\tpublic void setName(String name) {\n\t\tthis.name = name;\n\t}\n\n\tpublic String getSurname() {\n\t\treturn this.surname;\n\t}\n\n\tpublic void setSurname(String surname) {\n\t\tthis.surname = surname;\n\t}\n\n\tpublic int getAge() {\n\t\treturn this.age;\n\t}\n\n\tpublic void setAge(int age) {\n\t\tthis.age = age;\n\t}\n\n\tpublic List<User> getKnows() {\n\t\treturn this.knows;\n\t}\n\n\tpublic void setKnows(List<User> knows) {\n\t\tthis.knows = knows;\n\t}\n\n}\npublic class Car {\n\tprivate String platenumber;\n\tprivate User owner;\n\n\tpublic Car(String platenumber, User owner) {\n\t\tthis.platenumber = platenumber;\n\t\tthis.owner = owner;\n\t}\n\n\tpublic String getPlatenumber() {\n\t\treturn this.platenumber;\n\t}\n\n\tpublic void setPlatenumber(String platenumber) {\n\t\tthis.platenumber = platenumber;\n\t}\n\n\tpublic User getOwner() {\n\t\treturn this.owner;\n\t}\n\n\tpublic void setOwner(User owner) {\n\t\tthis.owner = owner;\n\t}\n\n}\n"
    val results = compileResult.getIndividualResults.head.getGeneratedSources.get(ShExLCompilerTargetLanguage.Java).get
    val res_1 = results.toList(0).getSource
    val res_2 = results.toList(1).getSource

    assert((res_1+res_2).equals(expected))

    compileResult =
      compiler
        .addSource("test/assets/incorrect_schema_big_schema_2.shexl")
        .compile.getCompilationResult

    assert(compileResult.hasErrors)

    if(compileResult.hasErrors) {
      //compileResult.getIndividualResults.foreach(result => result.getErrors.foreach(err => println(err.getMessage)))
    } else {
      assert(!compileResult.hasErrors)
      //compileResult.getIndividualResults.foreach(result => result.getGeneratedSchema.head.accept(new PrettyPrintASTVisitor(), new StringBuilder()))
    }

    //compileResult.getIndividualResults.foreach(result => result.getGeneratedSources.get(ShExLCompilerTargetLanguage.Java).get.foreach(source => println(source.getSource)))
  }

  private[this] def getListOfFiles(dir: String, startsWith: String): List[String] = {
    val file = new File(dir)
    file.listFiles.filter(_.isFile)
      .filter(_.getName.startsWith(startsWith))
      .map(_.getPath).toList
  }
}
