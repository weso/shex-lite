package compiler.semantic
import compiler.ast.Error
import compiler.ast.Warning

import scala.collection.mutable.ListBuffer

object MemoryErrorHandler extends ErrorHandler {

  val errors = new ListBuffer[Error]()
  var warnings = new ListBuffer[Warning]()

  /**
    * Returns whether the error handler has errors or not.
    *
    * @return true if has errors, false otherwise.
    */
  override def hasErrors: Boolean = !errors.isEmpty

  /**
    * Returns whether the error handler has warnings or not.
    *
    * @return true if has errors, false otherwise.
    */
  override def hasWarnings: Boolean = !warnings.isEmpty

  /**
    * Adds errors to the error system.
    *
    * @param error to add to the system.
    */
  override def addError(error: Error): Unit = errors.addOne(error)

  /**
    * Adds warnings to the error system.
    *
    * @param warning to add to the system.
    */
  override def addWarning(warning: Warning): Unit = warnings.addOne(warning)

  /**
    * Shows the errors through the terminal.
    */
  override def showErrors(): Unit = errors.map(println)

  /**
    * Shows the warnings through the terminal.
    */
  override def showWarnings(): Unit = warnings.map(println)
}
