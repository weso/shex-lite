//------------------------------------------------------------------------------
// File: SyntaxTree.scala
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
import org.antlr.v4.runtime.tree

/**
  * The syntax tree object acts a wrapper to the antlr implementation to add
  * the compilation context. In the compilation
  * context there is a field that stores the input char stream in case it is
  * needed in the future.
  */
trait SyntaxTree {

  /**
    * Gets the compilation context.
    *
    * @return the compilation context.
    */
  def getCompilationContext: CompilationContext

  /**
    * Gets the tree antlr implementation. In case you want to visit you will
    * need to implement the ShexLiteParserVisitor.
    *
    * @return the tree antlr implementation.
    */
  def getTree: tree.SyntaxTree
}

/**
  * The syntax tree object acts a wrapper to the antlr implementation to add
  * the compilation context. In the compilation
  * context there is a field that stores the input char stream in case it is
  * needed in the future.
  */
private[shexlc] object SyntaxTree {

  def create(ccontext: CompilationContext, ttree: tree.SyntaxTree): SyntaxTree =
    new SyntaxTree {

      /**
        * Gets the compilation context.
        *
        * @return the compilation context.
        */
      override def getCompilationContext: CompilationContext = ccontext

      /**
        * Gets the tree antlr implementation. In case you want to visit you
        * will need to implement the ShexLiteParserVisitor.
        *
        * @return the tree antlr implementation.
        */
      override def getTree: org.antlr.v4.runtime.tree.SyntaxTree = ttree
    }
}
