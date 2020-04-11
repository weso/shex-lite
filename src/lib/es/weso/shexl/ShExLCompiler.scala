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

import es.weso.shexlc.ast.Schema
import es.weso.shexlc.internal.io.{CompilerMsg, CompilerMsgsHandler}
import es.weso.shexlc.internal.io.impl.{CompilerMsgErrorType, DefaultCompilerMsg, DefaultCompilerMsgsHandler}
import es.weso.shexlc.internal.symboltable.SymbolHashTable
import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}
import es.weso.shexlc.semantic.{Sem01TypeCheckingVisitor, Sem02DefCheckingVisitor}
import es.weso.shexlc.syntactic.Syn01ASTBuilderVisitor
import es.weso.shexlc.syntactic.generated.{Shexl2Lexer, Shexl2Parser}

object ShExLCompiler {

  private var config: ShExLCompilerConfig = null
  private var inputCharStream: CharStream = null
  private val symbolTable = new SymbolHashTable
  private var compilerMsgsHandler: CompilerMsgsHandler = null
  private var parsedSchema: Either[CompilerMsg, Schema] = null;


  def parseFile(filepath: String): ShExLCompileResult = {
    inputCharStream = CharStreams.fromFileName(filepath)
    compilerMsgsHandler = new DefaultCompilerMsgsHandler(inputCharStream)
    val lexer = new Shexl2Lexer(inputCharStream)
    val tokens = new CommonTokenStream(lexer)
    val parseTree = new Shexl2Parser(tokens)

    val ast = new Syn01ASTBuilderVisitor().visitSchema(parseTree.schema())

    // Depending on the flags here the schema/es.weso.shexlc.ast has to be validated.
    new Sem01TypeCheckingVisitor(symbolTable, compilerMsgsHandler).visit(ast, ())
    new Sem02DefCheckingVisitor(symbolTable, compilerMsgsHandler).visit(ast, ())

    if(/*config.flags.contains(ShExLCompilerFlag.ErrorEmission) &&*/ compilerMsgsHandler.hasErrorMsgs) {
      compilerMsgsHandler.showErrorMsgs
      Left(compilerMsgsHandler.getErrorMsgs)
    }

    if(compilerMsgsHandler.hasErrorMsgs) {
      parsedSchema = Left(
        new DefaultCompilerMsg(
          compilerMsgsHandler.getErrorMsgs.head.getPosition,
          compilerMsgsHandler.getErrorMsgs.head.getRange,
          "the source file contained errors and the compiler cannot create an schema",
          CompilerMsgErrorType.CouldNotCreateSchemaForSource
        )
      )
    } else {
      parsedSchema = Right(ast)
    }

    new ShExLCompileResult(parsedSchema, compilerMsgsHandler)
  }
}