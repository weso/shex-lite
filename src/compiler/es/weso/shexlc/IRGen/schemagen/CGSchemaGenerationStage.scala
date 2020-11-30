package es.weso.shexlc.IRGen.schemagen

import es.weso.shexlc.internal.CompilationContext
import es.weso.shexlc.internal.errorhandler.ErrorHandler
import es.weso.shexlc.parse.ast.Schema
import es.weso.shexlc.parse.ast.expr.{CallPrefixExpr, CallShapeExpr, ConstraintTripleExpr}
import es.weso.shexlc.parse.ast.stmt.ShapeDefStmt
import es.weso.shexlc.parse.ast.visitor.ASTDefaultVisitor

class CGSchemaGenerationStage(ccontext: CompilationContext) extends ASTDefaultVisitor[String] {

  private[this] val msgsHandler: ErrorHandler = ccontext.getErrorHandler
  private[this] val schema: String = ""

  override def visit(schema: Schema, param: String): Unit = {
    /*this.schema.appended('[')
    schema.stmts.foreach(stmt => {
      stmt.accept(this, param)
      this.schema.appended(',')
    })
    this.schema.appended(']')*/
  }

  override def visit(stmt: ShapeDefStmt, param: String): Unit = {
    /*this.schema.appended('{')
    stmt.label.accept(this, param)
    this.schema.appended("\"attributes: [\"")
    stmt.expression.accept(this, param)
    this.schema.appended("]")*/
  }

  override def visit(expr: ConstraintTripleExpr, param: String): Unit = {
    /*val property    = expr.property
    val constraint  = expr.constraint
    this.schema.appended('{')
    //this.schema.appended(s"\"attributeName\": ${property.asCallPrefixExpr.argument.toLowerCase()},")
    //this.schema.appended(s"\"attributeType:\" ${property.asCallPrefixExpr.argument.toLowerCase()}")
    constraint.accept(this, param);
    this.schema.appended('}')*/
  }

  override def visit(expr: CallPrefixExpr, isList: String): Unit = {
    /*this.schema.appended("\"attributeType\":")
    expr.argument match {
      case "string" =>
        if (isList > "1") this.schema.appended("\"List<String>\"")
        else this.schema.appended("\"String\"")
      case "integer" =>
        if (isList > "1") this.schema.appended("\"List<int>\"") else this.schema.appended("\"int\"")
      case "date" =>
        if (isList > "1") this.schema.appended("\"List<Date>\"") else this.schema.appended("\"Date\"")
      case _ =>
    }*/
  }

  override def visit(expr: CallShapeExpr, isList: String): Unit = {
    /*if (expr.label.isCallPrefixExpr) {
      val prefixCall = expr.label.asCallPrefixExpr
      if (isList > "1")
        this.schema.appended(s"\"List<${prefixCall.argument.toLowerCase.capitalize}>\"")
      else this.schema.appended(s"\"${prefixCall.argument.toLowerCase.capitalize}\"")
    } else {
      val baseCall = expr.label.asCallBaseExpr
      if (isList > "1")
        this.schema.appended(s"\"List<${baseCall.argument.toLowerCase.capitalize}>\"")
      else this.schema.appended(s"\"${baseCall.argument.toLowerCase.capitalize}\"")
    }*/
  }
}
