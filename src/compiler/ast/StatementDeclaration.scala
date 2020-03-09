package compiler.ast

/**
 * A declaration in ShEx Lite is the fact of defining something. For example
 * prefix, basem start, import or even shapes declarations.
 */
private[compiler] trait StatementDeclaration extends ASTNode
