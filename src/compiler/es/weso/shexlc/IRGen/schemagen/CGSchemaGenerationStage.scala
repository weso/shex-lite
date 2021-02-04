package es.weso.shexlc.IRGen.schemagen

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.ErrorHandler
import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr.{CallBaseExpr, CallPrefixExpr, CallShapeExpr, ConstraintBlockTripleExpr, ConstraintNodeAnyTypeExpr, ConstraintTripleExpr}
import es.weso.shexlc.parse.ast.stmt.ShapeDefStmt
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

class CGSchemaGenerationStage(ccontext: CompilationContext) extends ASTDefaultVisitor[String] {

  private[this] val msgsHandler: ErrorHandler = ccontext.getErrorHandler

  private[this] val generationDate = System.currentTimeMillis()
  val schema: StringBuilder = new StringBuilder()

  override def visit(schema: Schema, param: String): Unit = {
    this.schema.append(
      s"""{
        |"generationDate":$generationDate,
        |"classes":[
        |""".stripMargin)

    for(stmt <- schema.stmts if stmt.isShapeDefStmt ) {
      stmt.accept(this, param)
      if(!stmt.equals(schema.stmts.last)) {
        this.schema.append(",")
      }
    }
    this.schema.append("]}")
  }

  override def visit(expr: ConstraintBlockTripleExpr, param: String): Unit = {
    for(expression <- expr.body ) {
      expression.accept(this, param)
      if(!expression.equals(expr.body.last)) {
        this.schema.append(",")
      }
    }
  }

  override def visit(stmt: ShapeDefStmt, param: String): Unit = {
    this.schema.append("{")
    this.schema.append("\"className\":")
    stmt.label.accept(this, param)
    this.schema.append("\"attributes\":[")
    stmt.expression.accept(this, param)
    this.schema.append("]")
    this.schema.append("}")
  }

  override def visit(expr: CallBaseExpr, param: String): Unit = {
   this.schema.append(expr.argument.replace("<", "").replace(">", "").toLowerCase().capitalize + ",")
  }

  override def visit(expr: ConstraintTripleExpr, param: String): Unit = {
    val property    = expr.property
    val constraint  = expr.constraint
    val cardinality = expr.cardinality


    this.schema.append('{')
    this.schema.append("\"attributeName\":\""+s"${property.asCallPrefixExpr.argument.toLowerCase()}"+"\",")
    this.schema.append("\"attributeType\":")
    constraint.accept(this, cardinality.asCardinalityExpr.max.toString)
    this.schema.append('}')
  }

  override def visit(expr: CallPrefixExpr, isList: String): Unit = {
    expr.argument match {
      case "string" =>
        if (isList > "1") this.schema.append("\"List<String>\"")
        else this.schema.append("\"String\"")
      case "integer" =>
        if (isList > "1") this.schema.append("\"List<int>\"") else this.schema.append("\"int\"")
      case "date" =>
        if (isList > "1") this.schema.append("\"List<Date>\"") else this.schema.append("\"Date\"")
      case _ => this.schema.append("\""+expr.argument.toLowerCase().capitalize+"\"" + ",")
    }
  }

  override def visit(expr: CallShapeExpr, isList: String): Unit = {
    if (expr.label.isCallPrefixExpr) {
      val prefixCall = expr.label.asCallPrefixExpr
      if (isList > "1")
        this.schema.append("\"List<"+s"${prefixCall.argument.toLowerCase.capitalize}>"+"\"")
      else this.schema.append("\""+s"${prefixCall.argument.toLowerCase.capitalize}"+"\"")
    } else {
      val baseCall = expr.label.asCallBaseExpr
      if (isList > "1")
        this.schema.append("\""+s"List<${baseCall.argument.toLowerCase.capitalize}>"+"\"")
      else this.schema.append("\""+s"${baseCall.argument.toLowerCase.capitalize}"+"\"")
    }
  }

  override def visit(expr: ConstraintNodeAnyTypeExpr, isList: String): Unit = {
    if(isList > "1") {
      this.schema.append("\"List<Object>\"")
    } else {
      this.schema.append("\"Object\"")
    }
  }
}
