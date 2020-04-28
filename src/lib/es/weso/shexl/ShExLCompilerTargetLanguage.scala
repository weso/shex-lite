package es.weso.shexl

/**
 * The Shape Expression Lite Target Language represents the standardized abstraction of the possible target language
 * for the code generation. Each standardized possible target language has a description field that contains the name
 * of the language that ir represents.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param description is the name of the represented language.
 */
class ShExLCompilerTargetLanguage(description: String)

object ShExLCompilerTargetLanguage {
  val Java = new ShExLCompilerTargetLanguage("java")
  val Kotlin = new ShExLCompilerTargetLanguage("kotlin")
  val Scala = new ShExLCompilerTargetLanguage("scala")
  val Python = new ShExLCompilerTargetLanguage("python")
  val Rust = new ShExLCompilerTargetLanguage("rust")
  val Swift = new ShExLCompilerTargetLanguage("swift")
}
