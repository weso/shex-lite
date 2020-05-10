//------------------------------------------------------------------------------
// File: NodeWithParent.scala
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

package es.weso.shexlc.parse.ast

/**
  * A node with parent is a node that has been created after another an therefore has a parent. If the parent of a node
  * is null is that it is the root of a tree.
  *
  * @author Guillermo Facundo Colunga
  */
trait NodeWithParent {

  /**
    * Gets the parent of the current node. If it is empty then the current node is the root of the tree.
    *
    * @return the parent of the current node.
    */
  def getParent: Option[NodeWithParent]

  /**
    * Sets the parent for the current node.
    *
    * @param parent to be set as the parent of the current node.
    */
  def setParent(parent: NodeWithParent): Unit

  /**
    * Sets the current node as the parent of the given node.
    *
    * @param node where the parent will be set as the current one.
    */
  def setAsParentOf(node: NodeWithParent): Unit

  /**
    * Gets the root of the tree where this leaf is in.
    *
    * @return the root of the tree where this leaf is in.
    */
  def findRootNode: NodeWithParent
}
