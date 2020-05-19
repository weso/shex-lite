//------------------------------------------------------------------------------
// File: Parser.scala
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
//------------------------------------------------------------------------------

package es.weso.shexlc.parse

import es.weso.shexl.impl.CaseChangingCharStream
import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.generated.{ShexLiteLexer, ShexLiteParser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

/**
  * The parser gets the input file an transform it in to a syntax tree. A
  * syntax tree is the antlr implementation that
  * includes all the tokens and set of rules. The point of doing this step
  * and not generate the AST (Abstract Syntax
  * Tree) directly is that providing the SyntaxTree users can implement their
  * own linters and other tools to improve the
  * look and feel of the language.
  *
  * @author Guillermo Facundo Colunga
  */
trait Parser {

  /**
    * Parses the text from the lexemes, then the tokens and finally the
    * syntax tree.
    *
    * @param text to be parsed.
    * @return the antlr generated syntax tree.
    */
  def parseText(text: String, ccontext: CompilationContext): SyntaxTree

  /**
    * arses the text from the lexemes, then the tokens and finally the syntax
    * tree.
    *
    * @param filePath to be parsed.
    * @return the antlr generated syntax tree.
    */
  def parseFile(filePath: String, ccontext: CompilationContext): SyntaxTree
}

/**
  * The parser gets the input file an transform it in to a syntax tree. A
  * syntax tree is the antlr implementation that
  * includes all the tokens and set of rules. The point of doing this step
  * and not generate the AST (Abstract Syntax
  * Tree) directly is that providing the SyntaxTree users can implement their
  * own linters and other tools to improve the
  * look and feel of the language.
  *
  * @author Guillermo Facundo Colunga
  */
object Parser extends Parser {

  /**
    * Parses the text from the lexemes, then the tokens and finally the
    * syntax tree.
    *
    * @param text to be parsed.
    * @return the antlr generated syntax tree.
    */
  override def parseText(text: String, ccontext: CompilationContext): SyntaxTree = {
    // Load the file in to the context.
    ccontext.setInputContext(CharStreams.fromString(text))

    // Build the Syntax Tree.
    buildST(ccontext)
  }

  private[this] def buildST(ccontext: CompilationContext): SyntaxTree = {
    // Insensitive characters.
    val caseInsensitiveCharStream = new CaseChangingCharStream(ccontext.getInputContext, false)

    // Lexing the file in to tokens.
    val lexer  = new ShexLiteLexer(caseInsensitiveCharStream)
    val tokens = new CommonTokenStream(lexer)

    // Parsing the file to generate the syntax tree.
    val antlrTreeRoot = new ShexLiteParser(tokens).schema()

    // Dispatch needed syntax checks.
    antlrTreeRoot.accept(new CheckSyntaxTreeShexCompatibility(ccontext)) //
    // Check for missing semicolons.
    // Creating the wrapper syntax tree that contains both the context and
    // the antlr syntax tree.
    SyntaxTree.create(ccontext, antlrTreeRoot)
  }

  /**
    * arses the text from the lexemes, then the tokens and finally the syntax
    * tree.
    *
    * @param filePath to be parsed.
    * @return the antlr generated syntax tree.
    */
  override def parseFile(filePath: String, ccontext: CompilationContext): SyntaxTree = {
    // Load the file in to the context.
    ccontext.setInputContext(CharStreams.fromFileName(filePath))

    // Build the Syntax Tree.
    buildST(ccontext)
  }
}
