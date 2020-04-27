package es.weso.shexl

import es.weso.shexlc.ast.Schema

/**
 * A Shape Expression Compiler Stage represents an stage of the compiler process. It contains the priority which is
 * as follows 0 (highest priority) 999.. (lowest priority). It also has an execute function that will execute the
 * stage.
 *
 * @author Guillermo Facundo Colunga
 */
trait ShExLCompilerStage extends Comparable[ShExLCompilerStage] {

  /**
   * Gets the priority of the stage, 0 highest priority, 999... lowest priority.
   *
   * @return the priority of the stage.
   */
  def getPriority: Int

  /**
   * Executes the Stage.
   */
  def execute(compiler: ShExLCompiler, ast: Schema)

  override def compareTo(o: ShExLCompilerStage): Int = {
    // If the current element has a lower priority number means it is more important.
    if(this.getPriority < o.getPriority) 1

    // If the priority of this element is greater means it is less important
    else if (this.getPriority > o.getPriority) -1

    // Finally for same priority both elements have the same importance.
    else 0
  }
}
