/*
 * MIT License
 *
 * Copyright (c) 2020 Weso Research Group, University of Oviedo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
*/

// Shapes Expression Litle grammar is an implementation of a defined subset of shape
// expressions on its compact syntax version.
grammar Shexl;

// The top level element of the grammar is the shema, that is
// what we want to represent with this grammar.
// A schema is defined as a non-empty set of statements.
schema
 : statement+ EOF
 ;

// The statements are the second level of the grammar.
// Each statement can be:
//  - a declaration.
//  - an import statement. import is not a definition but yes an statement as
//     it does not declare anything.
// *This rule is intended to be exntended in the future with more statements.*
statement
 : declaration_statement
 | import_statement
 ;

// The third level are the declararions, up to this level
// everything in an scheema is a declaration, directives
// like base, start, prefix or shapes declarations.
declaration_statement
 : base_declaration
 | start_declaration
 | prefix_declaration
 | shape_declaration
 ;

// A base declaration is the directive that defines the
// base IRI. It if defined as the keywork `base` and the
// IRI.
base_declaration
 : BASE_KW IRI
 ;

// The start declaration defines the shape that will be
// used as the default one during the validation. It is
// defined by the `start` keyword, then an `=` symbol and
// the shape invocation.
start_declaration
 : START_KW '=' shape_invocation
 ;

// A prefix declaration is the association of an IRI to
// a label. It is defined by the `prefix` keyword, the
// label that is optional (can be the null prefix), the
// `:` symbol, and the IRI.
prefix_declaration
 : PREFIX_KW LABEL? ':' IRI
 ;

// The shape declaration is the core of the validation
// as it is use to build the schema that the nodes will
// be validated against. It is defined as the conjunction
// of a shape name and an expression.
shape_declaration
 : shape_name expression
 ;

// The import statement imports another shex-lite schema
// defined in a separated file. It is defined as the
// keyword `import` and the corresponding IRI pointing
// to the .shexl file.
import_statement
 : IMPORT_KW IRI
 ;

// The shape name is the corresponding label associated
// to a shape_declaration. It can be a node or an IRI.
shape_name
 : prefix_invocation    // Node.
 | IRI        // IRI.
 ;

// A shape invocation is the toold used to make reference
// to the expression defined for that shape name. It is
// defined as a `@` symbol and the shape_name, it doesn't
// matter if it is an IRI or a Node.
shape_invocation
 : '@' shape_name
 ;

// An expresion up to this point is only a triple_expression
// but this rule prepares the syntax for future extension.
expression
 : triple_expression
 ;

// A triple expression is the shema that is associated to the
// shape name label. And it is this expression the one that it
// is used to validate against.
triple_expression
 : ex1=triple_expression AND_KW? ex2=triple_expression
 | ex1=triple_expression OR_KW ex2=triple_expression
 | NOT_KW triple_expression
 | node_constraint
 | '{' triple_constraint '}'                            // A single triple constraint.
 | '{' (triple_constraint ';')+ triple_constraint '}'   // Multiple triple constraints. (eachOfs)
 ;

// A triple constraint is the abstraction of the well known
// eachOf of ShEx. In our case as we don't have the eachOneOf
// we don't need to expand this rule. Therefore the triple
// constraint is defined as a property, a node constraint and
// the cardinality. If no cardilaity is pressent the default one
// will be the [0,n).
triple_constraint
 : prefix_invocation node_constraint cardinality?
 ;

// A prefix invocation is the invocation to something declared
// in the prefix. For example when we declare a property name
// in a triple constraint we invoque the property associated to
// the declared prefix. And the same with Datatypes.
prefix_invocation
 : prefix=LABEL? ':' property=LABEL
 ;

// Describe the allow values of a node. It can be:
//  - anything.
//  - a datatype. Notice that a datatype actually is a prefix
//      invocation.
//  - a node kind.
//  - a value set.
//  - or a shape reference.
node_constraint
 : '.'                  // Anything.
 | prefix_invocation    // Datatype.
 | LITERAL_KW           // Node kind.
 | IRI_KW
 | BNODE_KW
 | NON_LITERAL_KW
 | '[' value_set_type* ']'  // Value set.
 | shape_invocation     // Shape reference.
 ;

// Represents the possible values that a value set might contain.
value_set_type
 : prefix_invocation    // Prefix invocation.
 | shape_invocation     // Shape invocation.
 | STRING_LITERAL       // String literal.
 | REAL_LITERAL         // Real literal.
 ;

// As seen previously a triple constraint is formed by a property, a
// node constraint and a cardinality. The cardinality might be take
// different values depending on wat does it means:
//  - `*` -> any number of repetitions, 0 or more. If no cardinality
//           is set this one is de default one. [0,n)
//  - `+` -> any number of repetitions but at least 1. [1,n)
//  - `?` -> none or one appearance. Also known as optional. [0,1]
//  - `{N}` -> exactly N repetitions [N,N].
//  - `{N,M}` -> a minimum of N and a maximum of M repetitions. [N,M]
//  - `{N, }` -> any number of repetitions but a minimum of N. [N,m)
cardinality
 : '*'
 | '+'
 | '?'
 | '{' INT_LITERAL '}'
 | '{' INT_LITERAL ',' INT_LITERAL '}'
 | '{' INT_LITERAL ',''}'
 ;

// TOKENS

PREFIX_KW       :   'PREFIX'        ;
BASE_KW         :   'BASE'          ;
IMPORT_KW       :   'IMPORT'        ;
START_KW        :   'START'         ;
AND_KW          :   'AND'           ;
OR_KW           :   'OR'            ;
NOT_KW          :   'NOT'           ;
IRI_KW          :   'IRI'           ;
LITERAL_KW      :   'LITERAL'       ;
BNODE_KW        :   'BNODE'         ;
NON_LITERAL_KW  :   'NONLITERAL'    ;


LABEL
 : [a-zA-Z_][a-zA-Z0-9_]*
 ;

IRI
 : '<' (~[\u0000-\u0020=<>"{}|^`\\] | UCHAR)* '>'
 ;

INT_LITERAL
 : '0'
 | [1-9]DIGIT*
 ;

REAL_LITERAL
 : INT_LITERAL? FRACTION
 | INT_LITERAL '.'
 | INT_LITERAL EXPONENT
 | INT_LITERAL '.' DIGIT* EXPONENT
 ;

STRING_LITERAL
 : '"'.'"'
 ;

SKIP_
 : ( WHITE_SPACE | COMMENT ) -> skip
 ;

// FRAGMENTS

fragment WHITE_SPACE
 : [ \t\r\n\f]+
 ;

fragment COMMENT
 : ('#' ~[\r\n]* | '/*' (~[*] | '*' ('\\/' | ~[/]))* '*/')
 ;

fragment DIGIT
 : [0-9]
 ;

fragment NON_ZERO_DIGIT
 : [1-9]
 ;

fragment EXPONENT
 : [eE] [+-]? DIGIT+
 ;

fragment FRACTION
 : '.' DIGIT+
 ;

fragment UCHAR
 : '\\u' HEX HEX HEX HEX
 | '\\U' HEX HEX HEX HEX HEX HEX HEX HEX
 ;

fragment HEX
 : [0-9]
 | [A-F]
 | [a-f]
 ;