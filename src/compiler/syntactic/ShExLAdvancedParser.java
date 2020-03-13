package compiler.syntactic;

import compiler.ast.*;
import compiler.syntactic.generated.ShexlBaseVisitor;
import compiler.syntactic.generated.ShexlParser;

public class ShExLAdvancedParser extends ShexlBaseVisitor<ASTNode> {

    @Override
    public ImportStatement visitImport_statement(ShexlParser.Import_statementContext ctx) {
        IRILiteral iri = new IRILiteral("", ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.getText());
        ImportStatement importStmt =  new ImportStatement("", ctx.start.getLine(), ctx.start.getCharPositionInLine(), iri);

        System.out.println("--->" + importStmt.iri());

        return importStmt;
    }

    @Override
    public PrefixDeclaration visitPrefix_definition(ShexlParser.Prefix_definitionContext ctx) {

        String var =  ctx.LABEL()==null ? "" : ctx.LABEL().getText();
        IRILiteral iri = new IRILiteral("", ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.IRI().getText());
        PrefixDeclaration prefix =  new PrefixDeclaration("", ctx.start.getLine(), ctx.start.getCharPositionInLine(), var, iri);

        System.out.println("--->" + prefix.name() + "::" + prefix.iri().value());

        return prefix;
    }
}
