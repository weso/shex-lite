package es.weso.shexl.impl

import java.io.FileWriter

import es.weso.shexl.{ShExLCompilerGeneratedSource, ShExLCompilerTargetLanguage}

/**
 * The implementation of the shape expressions lite compiler generated sources acts as a wrapper for the language and
 * the generated source code. It also adds the functionality of writing the file in the computer file system.
 *
 * @author Guillermo Facundo Colunga
 *
 * @param language of the generated source file.
 * @param source code generated.
 */
class ShExLCompilerGeneratedSourceImpl(language: ShExLCompilerTargetLanguage, source: String)
  extends ShExLCompilerGeneratedSource {

  /**
   * Gets the standardized target language in which the source has been generated.
   *
   * @return the standardized target language.
   */
  override def getLanguage: ShExLCompilerTargetLanguage = language

  /**
   * Gets the source as a plain String object.
   *
   * @return the source as a plain String object.
   */
  override def getSource: String = source

  /**
   * Writes the generated source in a given filepath.
   *
   * @param filePath is the place where the source will be written.
   */
  override def toFile(filePath: String): Unit = {
    // Create a file at the destination folder.
    val file = new FileWriter(filePath)

    // Writing the file with the contests of the source.
    file.write(source)

    // Flushing and closing the file.
    file.flush()
    file.close()
  }
}
