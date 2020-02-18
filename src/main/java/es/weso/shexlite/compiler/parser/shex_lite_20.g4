grammar shex_lite_20;

shape_expr_file
 : prefix_def+ shape_def+ EOF
 ;

prefix_def
 : 'PREFIX' ID ':' IRI
 | 'BASE' IRI
 ;

shape_def
 : ':' ID triple_constraint
 | ':' ID '{' shape_body '}'
 | '<#' ID '>' '{' shape_body '}'
 ;

shape_body
 : ( triple_constraint | ( triple_constraint ';' )+ triple_constraint ';'? )
 ;

triple_constraint
 : prefix_inv node_constraint cardinality?
 ;

prefix_inv
 : ID? ':' ID
 ;

node_constraint
 : ID ':' xsd_type
 | '@' ':' ID
 | '@' '<#' ID '>'
 ;

xsd_type
 :
 | 'string'
 | 'decimal'
 | 'integer'
 | 'boolean'
 | 'date'
 | 'time'
 ;

cardinality
 : '*'
 | '+'
 | '?'
 | '{' INT_CONSTANT '}'
 | '{' INT_CONSTANT ',' INT_CONSTANT '}'
 | '{' INT_CONSTANT ',' '}'
 ;

// ------------------
// TERMINALS
// ------------------

ID
 : [a-zA-Z_][a-zA-Z0-9_]*
 ;

IRI
 : '<' (~[\u0000-\u0020=<>"{}|^`\\] | UCHAR)* '>'
 ;

INT_CONSTANT
 : '0'
 | [1-9]DIGIT*
 ;

SKIP_
 : ( WHITE_SPACE | COMMENT ) -> skip
 ;

// ------------------
// FRAGMENTS
// ------------------

fragment WHITE_SPACE
 : [ \t\r\n\fEOF]+
 ;

fragment COMMENT
 : ('#' ~[\r\n]* | '/*' (~[*] | '*' ('\\/' | ~[/]))* '*/') -> skip
 ;

fragment DIGIT
 : [0-9]
 ;

fragment NON_ZERO_DIGIT
 : [1-9]
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