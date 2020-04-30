package es.weso.shexlc.codegen.javagen.internal

import es.weso.shexlc.ast.expr.CardinalityExpr
import es.weso.shexlc.ast.visitor.DefaultShExLiteVisitor
import es.weso.shexlc.internal.io.CompilerMsgsHandler

class CGJava021ImportGenerator(msgsHandler: CompilerMsgsHandler, stringBuilder: StringBuilder)
  extends DefaultShExLiteVisitor[String] {

  override def visit(expr: CardinalityExpr, param: String): Unit = {
    if(expr.max>1) {
      stringBuilder.append("import java.util.List;")
      stringBuilder.append("\n")
      stringBuilder.append("\n")
    }
  }
}
