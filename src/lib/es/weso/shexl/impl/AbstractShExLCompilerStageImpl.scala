package es.weso.shexl.impl

import es.weso.shexl.ShExLCompilerStage

/**
 * Mains abstraction of the shex-lite compiler stage. It does not define the execute method so the stages that implement
 * this abstraction define it.
 *
 * @param priority of the stage.
 */
abstract class AbstractShExLCompilerStageImpl(priority: Int) extends ShExLCompilerStage {

  /**
   * Gets the priority of the stage, 0 highest priority, 999... lowest priority.
   *
   * @return the priority of the stage.
   */
  override def getPriority: Int = this.priority

  override def compareTo(o: ShExLCompilerStage): Int = {
    // If the current element has a lower priority number means it is more important.
    if(this.priority < o.getPriority) 1

    // If the priority of this element is greater means it is less important
    else if (this.priority > o.getPriority) -1

    // Finally for same priority both elements have the same importance.
    else 0
  }
}
