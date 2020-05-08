//------------------------------------------------------------------------------
// File: AbstractSyntaxTree.scala
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

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.ast.{AbstractASTNode, Schema}
import es.weso.shexlc.parse.generated.ShexLiteParser

/**
  * Defines the AST base class. And packs together the tree root (contains the full tree by means of references). And
  * the compilation context that was generated in the previous stage (lexing -> parsing).
  *
  * @author Guillermo Facundo Colunga
  */
trait AbstractSyntaxTree {

  /**
    * Gets the root of the tree.
    *
    * @return the root of the tree.
    */
  def getRoot: AbstractASTNode

  /**
    * Gets the compilation context.
    *
    * @return the compilation context.
    */
  def getCompilationContext: CompilationContext
}

/**
  * Defines the AST base class. And packs together the tree root (contains the full tree by means of references). And
  * the compilation context that was generated in the previous stage (lexing -> parsing).
  *
  * @author Guillermo Facundo Colunga
  */
object AbstractSyntaxTree {

  /**
    * Gets the AST (Abstract Syntax Tree) for a given Syntax Tree.
    *
    * @param syntaxTree is the input from where the ast will be generated.
    * @return the abstract syntax tree generated.
    */
  def getAST(syntaxTree: SyntaxTree): AbstractSyntaxTree =
    new AbstractSyntaxTree {

      private var root = Option.empty[AbstractASTNode]

      new ASTBuilderParser(syntaxTree.getCompilationContext)

      /**
        * Gets the root of the tree.
        *
        * @return the root of the tree.
        */
      override def getRoot: AbstractASTNode = {
        root = Option(
          syntaxTree.getTree
            .asInstanceOf[
              ShexLiteParser.SchemaContext
            ] // It must be always a SchemaContext
            .accept(new ASTBuilderParser(syntaxTree.getCompilationContext))
        )

        root.get.asInstanceOf[Schema].accept(new SyntaxTreeParentBuilder(), ())

        root.get // If not present will throw an exception. Should we deal only with options?
      }

      /**
        * Gets the compilation context.
        *
        * @return the compilation context.
        */
      override def getCompilationContext: CompilationContext =
        syntaxTree.getCompilationContext
    }
}
