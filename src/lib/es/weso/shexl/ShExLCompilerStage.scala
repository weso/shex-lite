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
   * Executes the stage, the passed variables can be modified so their value will be passed to the next stage.
   *
   * @param compiler that it is executing the stage.
   * @param ast is the Abstract Syntax Tree that is being processed. Stages can modify the ast and next stages will
   *            receive the modified AST.
   * @param individualResult is the individual result that after all the stages will be given to the user. Each stage
   *                         can append information on it.
   */
  def execute(compiler: ShExLCompiler, ast: Schema, individualResult: ShExLCompilerIndividualResult)

  override def compareTo(o: ShExLCompilerStage): Int = {
    // If the current element has a lower priority number means it is more important.
    if(this.getPriority < o.getPriority) 1

    // If the priority of this element is greater means it is less important
    else if (this.getPriority > o.getPriority) -1

    // Finally for same priority both elements have the same importance.
    else 0
  }
}
