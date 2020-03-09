package compiler.ast

/**
 * In shex-lite the top level is an schema, a single file represents
 * an schema, two or more files linked through import declarations are join
 * to build a unique schema. And an schema is composed of statements.
 *
 * @param statements is the list of statements that compose a schema.
 */
private[compiler] class Schema(statements: List[Statement])
