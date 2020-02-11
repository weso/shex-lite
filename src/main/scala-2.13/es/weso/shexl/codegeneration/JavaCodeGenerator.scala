package es.weso.shexl.codegeneration

import java.io.{File, PrintWriter}

case class JavaCodeGenerator(inputFile: String, outputFile: String) {

  val writter = new PrintWriter( new File(outputFile) )

  def public() = {
    writter.print("public")
    writter.flush()
  }

  def space() = {
    writter.print(' ')
    writter.flush()
  }

  def Class() = {
    writter.print("class")
    writter.flush()
  }

  def string() = {
    writter.print("String")
    writter.flush()
  }

  def int() = {
    writter.print("int")
    writter.flush()
  }

  def double() = {
    writter.print("double")
    writter.flush()
  }

  def semicolon() = {
    writter.println(";")
    writter.flush()
  }

  def Import(packageName: String) = {
    writter.print("import")
    space()
    writter.print(packageName)
    semicolon()
    writter.flush()
  }

  def className(className: String) = {
    writter.print(className.toLowerCase.capitalize)
    writter.flush()
  }

  def openCurlyBrackets(): Unit = {
    writter.println("{")
    writter.flush()
  }

  def closeCurlyBrackets(): Unit = {
    writter.println("}")
    writter.flush()
  }

  def propertyName(porpertyName: String) = {
    writter.print(porpertyName)
    writter.flush()
  }

  def property(pType: String, pName: String): Unit = {
    writter.println(s"\tpublic $pType $pName;")
  }

}
