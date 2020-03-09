package compiler.ast

/**
 * In ShEx lite the second level is composed by statements. As it is a declarative DSL
 * all inside will be declarations. The aim of this level is to add other capabilities in the future.
 */
private[compiler] trait Statement extends ASTNode
