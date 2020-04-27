package es.weso.shexl.impl

import java.util.Objects

import es.weso.shexl.{ShExLCompilerResult, _}
import es.weso.shexlc.codegen.javagen.{CGJava01ValidSchemaCheckingStage, CGJava02ClassGeneratorStage}
import es.weso.shexlc.internal.io.impl.DefaultCompilerMsgsHandler
import es.weso.shexlc.internal.symboltable.SymbolHashTable
import es.weso.shexlc.semantic.{Sem01TypeCheckingStage, Sem02DefCheckingStage, Sem03CallCheckingStage, Sem50UnusedPrefixFinderStage}
import es.weso.shexlc.syntactic.Syn01ASTBuilderStage

import scala.collection.mutable.PriorityQueue
import scala.collection.mutable.ListBuffer

/**
 *
 */
class ShExLCompilerImpl extends ShExLCompiler {

  // Internal compiler components.
  private var compilerConfiguration: ShExLCompilerConfig = null
  private var compilerState = ShExLCompilerState.Idle
  private val compilerStages = new PriorityQueue[ShExLCompilerStage]()
  private[weso] var compilerMsgsHandler: DefaultCompilerMsgsHandler = null
  private[weso] var compilerSymbolTable: SymbolHashTable = null;

  // Compiler I/O registers.
  private val compilationQueue = new ListBuffer[String]()
  private var compilationResult: ShExLCompilerResult = null

  // Stages of the compiler.
  registerCompilerStage(new Sem01TypeCheckingStage())           // Priority 1
  registerCompilerStage(new Sem02DefCheckingStage())            // Priority 2
  registerCompilerStage(new Sem03CallCheckingStage())           // Priority 3
  registerCompilerStage(new Sem50UnusedPrefixFinderStage())     // Priority 10
  registerCompilerStage(new CGJava01ValidSchemaCheckingStage()) // Priority 20
  registerCompilerStage(new CGJava02ClassGeneratorStage)        // Priority 21

  /**
   * Sets the configuration for the compiler to compile. The configuration might include:
   *  - Skipping warnings.
   *  - Target language.
   *  - Activate / De-activate compiler optimizations.
   *
   * @param config is the configuration object.
   */
  override def setConfiguration(config: ShExLCompilerConfig): ShExLCompiler = {
    if(Objects.isNull(config)) {
      moveCompilerToState(ShExLCompilerState.Error)
      throw new IllegalArgumentException(s"the configuration $config cannot be null")
    }
    this.compilerConfiguration = config
    this
  }

  /**
   * Gets the configuration of the compiler, notice that if no configuration has been set the initial one will be the
   * returned one.
   *
   * @return the current configuration of the compiler.
   */
  override def getConfiguration: ShExLCompilerConfig = this.compilerConfiguration

  /**
   * Gets the current state of the compiler.
   *
   * @return the current state of the compiler.
   */
  override def getState: ShExLCompilerState = this.compilerState

  /**
   * Gets whether the compilation queue is empty or not.
   *
   * @return true if the compilation queue is empty, false otherwise.
   */
  override def isCompilationQueueEmpty: Boolean = this.compilationQueue.isEmpty

  /**
   * Gets the collection that contains the compilation stages.
   *
   * @return the collection that contains the compilation stages.
   */
  override def getCompilerStages: Iterable[ShExLCompilerStage] = this.compilerStages

  /**
   * Registers a new stage in the compiler. If the stage of the compiler does already exists the compiler will place the
   * stage randomly with others with the same priority.
   *
   * @param stage to add to the compiler.
   */
  override def registerCompilerStage(stage: ShExLCompilerStage): ShExLCompiler = {
    if(Objects.isNull(stage)) {
      moveCompilerToState(ShExLCompilerState.Error)
      throw new IllegalArgumentException(s"the stage $stage cannot be null")
    }
    if(stage.getPriority < 0) {
      moveCompilerToState(ShExLCompilerState.Error)
      throw new IllegalStateException(s"the priority of $stage cannot be negative")
    }
    this.compilerStages.enqueue(stage)
    this
  }

  /**
   * Adds one file to the compile queue. Non file will be processed until the compile method is called. Returns
   * the compiler itself as an object so that method vectorization can be used.
   *
   * @param filepath of the file to compile.
   * @return the compiler object with the file added.
   */
  override def addSource(filepath: String): ShExLCompiler = {
    if(Objects.isNull(filepath)) {
      moveCompilerToState(ShExLCompilerState.Error)
      throw new IllegalArgumentException("the file path of the source cannot be null")
    }
    if(!filepath.contains(".shexl")) {
      moveCompilerToState(ShExLCompilerState.Error)
      throw new IllegalArgumentException("the file is not a shex-lite source file")
    }
    this.compilationQueue += filepath
    this
  }

  /**
   * Appends the compile queue with the file paths. Non file will be processed until the compile method is called. Returns
   * the compiler itself as an object so that method vectorization can be used.
   *
   * @param filePaths is the collection that contains all the path to the files to compile.
   * @return the compiler object with the files added.
   */
  override def addSources(filePaths: List[String]): ShExLCompiler = {
    filePaths.foreach(f => this.addSource(f))
    this
  }

  /**
   * Gets the collection of files in the compilation queue.
   *
   * @return the collection of files in the compilation queue.
   */
  override def getCompilationQueue: Iterable[String] = this.compilationQueue

  /**
   * Compiles all the files in the compilation queue.
   *
   */
  override def compile: ShExLCompiler = {
    if(Objects.isNull(this.compilerConfiguration)) {
      moveCompilerToState(ShExLCompilerState.Error)
      throw new IllegalStateException("the configuration of the compiler cannot be null")
    } else if (this.isCompilationQueueEmpty) {
      moveCompilerToState(ShExLCompilerState.Error)
      throw new IllegalStateException("the compilation queue cannot be empty")
    } else {
      moveCompilerToState(ShExLCompilerState.Compiling)
    }

    // We have to compile each source
    for(source <- compilationQueue) {

      // 1. Ingest the file as a string stream.
      val parser = new ParseTreeGenerator(source)
      val parseTree = parser.generateParseTree()

      // 2. Clear the needed structures for the source compilation.
      compilerMsgsHandler = new DefaultCompilerMsgsHandler(parser.inputCharStream)
      compilerSymbolTable = new SymbolHashTable()

      // TO DO... CREATE A NEW COMPILER RESULT (IT HAS NOT BEEN IMPLEMENTED YET)

      // 3. Build the AST that will be given to the different stages later.
      val ast = new Syn01ASTBuilderStage().visitSchema(parseTree.schema())

      // 4. for each step of the compiler execute with the current file.
      while(this.compilerStages.size > 0) {
        val stage = this.compilerStages.dequeue()
        println(stage)
        // Execute the stage
        stage.execute(this, ast)
        // Iterate the stage
      }

      // If the compilation generated errors we won't pass the ast as it is corrupted.
      if(compilerMsgsHandler.hasErrorMsgs) {
        compilationResult.addIndividualResult(
          new ShExLCompilerIndividualResultImpl(
            source,
            compilerMsgsHandler.getErrorMsgs,
            compilerMsgsHandler.getWarningMsgs,
            Option.empty
          )
        )
      } else {
        compilationResult.addIndividualResult(
          new ShExLCompilerIndividualResultImpl(
            source,
            compilerMsgsHandler.getErrorMsgs,
            compilerMsgsHandler.getWarningMsgs,
            Option(ast)
          )
        )
      }
    }

    // 5. Move the compiler again to idle state.
    moveCompilerToState(ShExLCompilerState.Idle)
    this
  }

  /**
   * Gets the  result of the compilation. It is important to know that the compilation must have finished to be able to
   * get the result.
   *
   * @return the  result of the compilation.
   */
  override def getCompilationResult: ShExLCompilerResult = this.compilationResult

  /**
   * Gets the symbol table of the compiler.
   *
   * @return the symbol table of the compiler.
   */
  override private[weso] def getCompilerSymbolTable = this.compilerSymbolTable

  /**
   * Gets the compiler messages handler.
   *
   * @return the compiler messages handler.
   */
  override private[weso] def getCompilerMsgsHandler = this.compilerMsgsHandler

  /**
   * Moves the compiler to a given state.
   *
   * @param state to move the compiler.
   */
  private[this] def moveCompilerToState(state: ShExLCompilerState) {
    this.compilerState = state
  }
}
