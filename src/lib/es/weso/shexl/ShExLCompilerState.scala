package es.weso.shexl

/**
 * The Shapes Expression Lite Compiler State represents the actual state of the compiler. Each state is identified by
 * a unique code and its own short description.
 *
 * The natural flow of the compiler should be idle -> compiling -> idle. But it also can be the following:
 * idle -> error (for example if no configuration is provided and the user starts the compilation process)
 * idle -> compiler -> error (for example if there was a bug inside some compiler stage)
 *
 * @author Guillermo Facundo Colunga
 */
class ShExLCompilerState(code: Integer, description: String)

/**
 * The Shapes Expression Lite Compiler State represents the actual state of the compiler. Each state is identified by
 * a unique code and its own short description.
 *
 * The natural flow of the compiler should be idle -> compiling -> idle. But it also can be the following:
 * idle -> error (for example if no configuration is provided and the user starts the compilation process)
 * idle -> compiler -> error (for example if there was a bug inside some compiler stage)
 *
 * @author Guillermo Facundo Colunga
 */
object ShExLCompilerState {

  /**
   * The error state is used to represent an error of the compiler that does not allow it to terminate its process.
   * Notice that generation of errors/warnings during the compilation of sources are not causes the the error state in
   * the compiler. The error status for the compiler is only achieved if the expected flow of the compiler is not able
   * to be followed. Generation of errors/warnings is an expected behaviour.
   */
  val Error = new ShExLCompilerState(-1, "Error")

  /**
   * The idle status is the status in which the compiler is presented to the user. And it is also the status that it
   * achieves after ending a compilation. No mater if the compilation generated errors/warnings, that is inside the
   * expected behaviour of the compiler.
   */
  val Idle = new ShExLCompilerState(0, "Idle")

  /**
   * The compiling status represents the time in which the compiler is processing sources, and generating code. It is
   * constant during all the stages of the compiling process.
   */
  val Compiling = new ShExLCompilerState(1, "Compiling")
}
