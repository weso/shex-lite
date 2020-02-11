package es.weso.shexl.codegeneration

import es.weso.shexl.ast.{Constraint, FieldConstraint, PrefixDef, PrefixInv, ShExL, ShapeDef, ShapeInv, Type, TypeConstraint, URL}
import es.weso.shexl.visitor.AbstractVisitor

import scala.collection.JavaConverters

case class JavaCodeGenVisitor(generator: JavaCodeGenerator) extends AbstractVisitor {

  override def visit(node:ShExL, param: Any) = {
    for(shapeDef <- JavaConverters.asScalaIterator(node.definitions.iterator())) {
      if (shapeDef.isInstanceOf[ShapeDef]) {
        shapeDef.accept(this, param)
      }
    }
  }

  override def visit(node: ShapeDef, param: Any): Unit = {
    generator.public()
    generator.space()
    generator.Class()
    generator.space()
    generator.className(node.name)
    generator.space()
    generator.openCurlyBrackets()
    for(constraint <- JavaConverters.asScalaIterator(node.constraints.iterator())) {

      generator.property("String"/*constraint.cType.invocation.definition.name*/, constraint.field.prefixInv.propertyName)
    }
    generator.closeCurlyBrackets()
  }

  override def visit(node: FieldConstraint, param: Any): Unit = {
    generator.propertyName(node.prefixInv.prefixName)
    generator.semicolon()
  }

  override def visit(node: TypeConstraint, param: Any): Unit = {
    generator.public()
    generator.space()
    node.invocation.accept(this, param)
  }

  override def visit(node: PrefixInv, param: Any): Unit = {
    generator.propertyName(node.propertyName)
  }

  override def visit(node: ShapeInv, param: Any): Unit = {
    generator.propertyName(node.shapeName)
  }

  override def visit(node: URL, param: Any): Unit = {
    generator.propertyName(node.url)
  }

  override def visit(node: Type, param: Any): Unit = {
    node match {
      case es.weso.shexl.ast.String => generator.string()
      case es.weso.shexl.ast.Int => generator.int()
      case es.weso.shexl.ast.Long => generator.double()
    }
  }
}
