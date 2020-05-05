//--------------------------------------------------------------------------------------------------
// File: SIL.scala
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

package es.weso.shexlc.sema

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.parse.AbstractSyntaxTree
import es.weso.shexlc.parse.ast.AbstractASTNode

/**
 * The shex lite intermediate language is nothing else than the type-checked, attributed graph in which is transformed
 * the AST after all semantic operations.
 *
 * @author Guillermo Facundo Colunga
 */
trait SIL {

  /**
   * Gets the compilation context.
   *
   * @return the compilation context.
   */
  def getCompilationContext: CompilationContext

  /**
   * Gets the entry point for the graph that represents the shex-lite intermediate language.
   *
   * @return the abstract ast node that represents the entry point of the graph. Will be an schema always.
   */
  def getGraphEntryPoint: AbstractASTNode
}

/**
 * The shex lite intermediate language is nothing else than the type-checked, attributed graph in which is transformed
 * the AST after all semantic operations.
 *
 * @author Guillermo Facundo Colunga
 */
object SIL {

  /**
   * Gets the Shex Lite Intermediate Language representation for a given AST.
   *
   * @param abstractSyntaxTree for which the SIL will be generated.
   * @return the generated SIL.
   */
  def getSIL(abstractSyntaxTree: AbstractSyntaxTree): SIL = new SIL {

    /**
     * Gets the compilation context.
     *
     * @return the compilation context.
     */
    override def getCompilationContext: CompilationContext = abstractSyntaxTree.getCompilationContext

    /**
     * Gets the entry point for the graph that represents the shex-lite intermediate language.
     *
     * @return the abstract ast node that represents the entry point of the graph. Will be an schema always.
     */
    override def getGraphEntryPoint: AbstractASTNode = {
      // First the type checking of the AST
      abstractSyntaxTree.getRoot.accept(new TypeCheck(abstractSyntaxTree.getCompilationContext), ())

      // Then add definitions to the symbol table and look for duplicates.
      abstractSyntaxTree.getRoot.accept(new DefinitionCheck(abstractSyntaxTree.getCompilationContext), ())

      // Then check that all calls have a definition and assign it.
      abstractSyntaxTree.getRoot.accept(new CallCheck(abstractSyntaxTree.getCompilationContext), ())

      // Finally look for un-used prefixes to throw warnings.
      abstractSyntaxTree.getRoot.accept(new LookUnusedPrefixCheck(abstractSyntaxTree.getCompilationContext), ())

      // Return the graph entry point.
      abstractSyntaxTree.getRoot
    }
  }
}
