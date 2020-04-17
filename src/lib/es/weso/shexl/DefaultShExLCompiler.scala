/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

package es.weso.shexl

import java.util.Objects

import es.weso.shexlc.ast.Schema
import es.weso.shexlc.codegen.javagen.{CGJava01ValidSchemaCheckingVisitor, CGJava02ClassGeneratorVisitor}
import es.weso.shexlc.internal.io.{CompilerMsg, CompilerMsgsHandler}
import es.weso.shexlc.internal.io.impl.{CompilerMsgErrorType, DefaultCompilerMsg, DefaultCompilerMsgsHandler}
import es.weso.shexlc.internal.symboltable.{SymbolHashTable, SymbolTable}
import es.weso.shexlc.semantic.{Sem01TypeCheckingVisitor, Sem02DefCheckingVisitor, Sem03CallCheckingVisitor, Sem50UnusedPrefixFinderVisitor}
import es.weso.shexlc.syntactic.Syn01ASTBuilderVisitor
import es.weso.shexlc.syntactic.generated.Shexl2Parser

import scala.collection.mutable.ListBuffer


class DefaultShExLCompiler extends ShExLCompiler {

  private[this] var config: ShExLCompilerConfig = DefaultShExLCompilerConfig
  private[this] val compileQueue = new ListBuffer[String]()
  private[this] val compileResults = new ListBuffer[ShExLCompileResult]()

  override def setConfiguration(config: ShExLCompilerConfig): ShExLCompiler = {
    if(Objects.isNull(config)) {
      throw new IllegalArgumentException("the configuration of the compiler cannot be null")
    }
    this.config = config
    this
  }

  override def addFile(filepath: String): ShExLCompiler = {
    if(Objects.isNull(filepath) || filepath.isEmpty) {
      throw new IllegalArgumentException("the filepath cannot be null nor be empty")
    }
    this.compileQueue += filepath
    this
  }

  override def addFiles(filePaths: List[String]): ShExLCompiler = {
    if(Objects.isNull(filePaths) || filePaths.isEmpty) {
      throw new IllegalArgumentException("the file paths collection cannot be null nor be empty")
    }
    this.compileQueue ++= filePaths
    this
  }

  override def compile(): List[ShExLCompileResult] = {
    compileResults.clear()
    if(compileQueue.isEmpty) {
      throw new IllegalStateException("the compile queue is empty")
    }

    for(file <- compileQueue) {
      val parser = new ParseTreeGenerator(file)
      val parseTree = parser.generateParseTree()
      val compilerMsgsHandler = new DefaultCompilerMsgsHandler(parser.inputCharStream)
      val symbolTable = new SymbolHashTable

      // Building the AST.
      val ast = buildAST(parseTree)

      // Apply semantic validation to the AST.
      validateAST(ast, symbolTable, compilerMsgsHandler)

      // Small optimizations / warnings generation.
      optimizeAST(ast, symbolTable, compilerMsgsHandler)

      // Code generation would be going here.
      generateCode(ast, symbolTable, compilerMsgsHandler)

      // If errors/warnings show them.
      showErrors(compilerMsgsHandler)
      showWarnings(compilerMsgsHandler)

      // Generate compile result.
      compileResults += generateCompileResult(ast, compilerMsgsHandler)
    }
    compileQueue.clear()
    compileResults.toList
  }

  private[this] def buildAST(parser: Shexl2Parser): Schema = {
    new Syn01ASTBuilderVisitor().visitSchema(parser.schema())
  }

  private[this] def validateAST(root: Schema, st: SymbolTable, msgsHandler: CompilerMsgsHandler): Unit = {
    // Depending on the flags here the schema/es.weso.shexlc.ast has to be validated.
    new Sem01TypeCheckingVisitor(st, msgsHandler).visit(root, ())
    new Sem02DefCheckingVisitor(st, msgsHandler).visit(root, ())
    new Sem03CallCheckingVisitor(st, msgsHandler).visit(root, ())
  }

  private[this] def optimizeAST(root: Schema, st: SymbolTable, msgsHandler: CompilerMsgsHandler): Unit = {
    if(config.generateWarnings) new Sem50UnusedPrefixFinderVisitor(st, msgsHandler).visit(root, ())
  }

  private[this] def generateCode(root: Schema, st: SymbolTable, msgsHandler: CompilerMsgsHandler): Unit = {
    if(config.generateCode) {
      new CGJava01ValidSchemaCheckingVisitor(st, msgsHandler).visit(root, ())
      if(!msgsHandler.hasErrorMsgs) new CGJava02ClassGeneratorVisitor(msgsHandler).visit(root, "")
    }
  }

  private[this] def showErrors(msgsHandler: CompilerMsgsHandler): Unit = {
    if(msgsHandler.hasErrorMsgs) {
      msgsHandler.showErrorMsgs
    }
  }

  private[this] def showWarnings(msgsHandler: CompilerMsgsHandler): Unit = {
    if(msgsHandler.hasWarningMsgs && config.generateWarnings) {
      msgsHandler.showWarningMsgs
    }
  }

  private[this] def generateCompileResult(root: Schema, msgsHandler: CompilerMsgsHandler): ShExLCompileResult = {
    var parsedSchema: Either[String, Schema] = null
    if(msgsHandler.hasErrorMsgs) {
      parsedSchema = Left(Console.RED + "error:" + Console.RESET + " aborting due to previous error")
    } else {
      parsedSchema = Right(root)
    }
    new ShExLCompileResult(parsedSchema, msgsHandler)
  }
}
