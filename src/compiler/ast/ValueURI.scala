package compiler.ast

/**
 * An URI is an Uniform Resource Identifier that atomically identifies
 * a resource in the system.
 *
 * @param address is the atomic address of the resource.
 */
private[compiler] case class ValueURI(address: String)