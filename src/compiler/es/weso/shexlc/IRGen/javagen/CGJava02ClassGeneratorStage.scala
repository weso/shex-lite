//--------------------------------------------------------------------------------------------------
// File: CGJava02ClassGeneratorStage.scala
//
// Short version for non-lawyers:
//
// The ShEx Lite Project is dual-licensed under GNU 3.0 and
// MIT terms.
//
// Longer version:
//
// Copyrights in the ShEx Lite project are retained by their contributors. No
// copyright assignment is required to contribute to the ShEx Lite project.
//
// Some files include explicit copyright notices and/or license notices.
// For full authorship information, see the version control history.
//
// Except as otherwise noted (below and/or in individual files), ShEx Lite is
// licensed under the GNU, Version 3.0 <LICENSE-GNU> or
// <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
// <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
// In case of incompatibility between project licenses, GNU/GPLv3 will be
// applied.
//
// The ShEx Lite Project includes packages written by third parties.
//--------------------------------------------------------------------------------------------------

package es.weso.shexlc.IRGen.javagen

import java.io.{File, PrintWriter}
import es.weso.shexl.ShExLCompilerTargetLanguage
import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr.{CallBaseExpr, CallPrefixExpr}
import es.weso.shexlc.parse.ast.stmt.ShapeDefStmt
import es.weso.shexlc.parse.ast.visitor.DefaultShExLiteVisitor
import es.weso.shexlc.IRGen.javagen.internal.{CGJava021ImportGenerator, CGJava03FieldsGenerator, CGJava04ConstructorGenerator, CGJava05GetSetGenerator}
import es.weso.shexlc.internal.{CompilationContext, CompilationResult}
import es.weso.shexlc.internal.errorhandler.ErrorHandler
import es.weso.shexlc.internal.io.CompilerMsgsHandler
import es.weso.shexlc.internal.symboltable.SymbolTable

class CGJava02ClassGeneratorStage(ccontex: CompilationContext) extends DefaultShExLiteVisitor[String] {

  private[this] val symbolTable: SymbolTable = ccontex.getSymbolTable
  private[this] val msgsHandler: ErrorHandler = ccontex.getErrorHandler
  private[this] var stringBuilder = new StringBuilder() // This string builder will contain the generated sources.
  private[this] var result: CompilationResult = ccontex.getCompilationResult

  private[this] var className: String = ""

  override def visit(stmt: ShapeDefStmt, param: String): Unit = {
    // Clean the string builder where the class will be generated.
    this.stringBuilder = new StringBuilder()

    stmt.label.accept(this, param)
    val fieldsGen = new CGJava03FieldsGenerator(msgsHandler, stringBuilder)
    val constructorGen = new CGJava04ConstructorGenerator(msgsHandler, stringBuilder)
    val getSetGen = new CGJava05GetSetGenerator(msgsHandler, stringBuilder)

    // Imports generator
    stmt.accept(new CGJava021ImportGenerator(msgsHandler, stringBuilder), null)

    stringBuilder.append(s"public class $className {")
    stringBuilder.append("\n")
    stmt.expression.accept(fieldsGen, param)
    stringBuilder.append("\n")
    stmt.expression.accept(constructorGen, className)
    stringBuilder.append("\n")
    stmt.expression.accept(getSetGen, param)
    stringBuilder.append(s"}")
    stringBuilder.append("\n")

    result.getGeneratedSources.get(ShExLCompilerTargetLanguage.Java) match {
      case None => {
        result.getGeneratedSources.put(
          ShExLCompilerTargetLanguage.Java,
          List(new ShExLCompilerGeneratedSourceImpl(
            ShExLCompilerTargetLanguage.Java,
            stringBuilder.toString()
          ))
        )
      }
      case Some(list) => {
        result.getGeneratedSources.put(ShExLCompilerTargetLanguage.Java, list :+ new ShExLCompilerGeneratedSourceImpl(
          ShExLCompilerTargetLanguage.Java,
          stringBuilder.toString()
        ))
      }
    }
  }

  override def visit(expr: CallBaseExpr, param: String): Unit = {
    className = expr.argument
      .replace("<", "")
      .replace(">", "")
      .toLowerCase()
      .capitalize
  }

  override def visit(expr: CallPrefixExpr, param: String): Unit = {
    className = expr.argument
      .toLowerCase()
      .capitalize
  }
}
