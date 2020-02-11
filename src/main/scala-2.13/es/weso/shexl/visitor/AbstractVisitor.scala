package es.weso.shexl.visitor
import es.weso.shexl.ast.{Constraint, Definition, FieldConstraint, Invocation, PrefixDef, PrefixInv, ShExL, ShapeDef, ShapeInv, Type, TypeConstraint, URL}

import scala.collection.JavaConverters

class AbstractVisitor extends ShExLVisitor {

  override def visit(node: ShExL, param: Any): Unit = {
    for(defi <- JavaConverters.asScalaIterator(node.definitions.iterator() )) {
      defi.accept(this, param)
    }
  }

  override def visit(node: PrefixDef, param: Any): Unit = {
    node.uri.accept(this, param)
  }

  override def visit(node: ShapeDef, param: Any): Unit = {
    for(constraint <- JavaConverters.asScalaIterator(node.constraints.iterator())) {
      constraint.accept(this, param)
    }
  }

  override def visit(node: Constraint, param: Any): Unit = {
    node.cType.accept(this, param)
    node.field.accept(this, param)
  }

  override def visit(node: FieldConstraint, param: Any): Unit = {
    node.prefixInv.accept(this, param)
  }

  override def visit(node: TypeConstraint, param: Any): Unit = {
    node.invocation.accept(this, param)
  }

  override def visit(node: PrefixInv, param: Any): Unit = {
    //node.definition.accept(this, param)
  }

  override def visit(node: ShapeInv, param: Any): Unit = {
    //node.definition.accept(this, param)
  }

  override def visit(node: URL, param: Any): Unit = {}

  override def visit(node: Type, param: Any): Unit = {
    node.accept(this, param)
  }
}
