grammar ShExLite;

shex_lite_doc
 : prefix_def+ shape_def+ EOF
 ;

// ------------------
// DEFINITIONS
// ------------------

prefix_def
 : 'PREFIX' ID? ':' IRI
 ;

shape_def
 : ':' ID '{' shape_body '}'
 ;

shape_body
 : (constraint_def | (constraint_def';')+ constraint_def)
 ;

constraint_def
 : contraint_id constraint_type
 ;

contraint_id
 : prefix_inv ':' property_def
 ;

constraint_type
 : '@:' shape_inv
 | prefix_inv ':' primitive_type
 ;

property_def
 : ID
 ;

// ------------------
// INVOCATIONS
// ------------------

shape_inv
 : ID
 ;

prefix_inv
 : ID?
 ;

primitive_type
 : 'integer'
 | 'string'
 | 'double'
 | 'long'
 ;

// ------------------
// TERMINALS
// ------------------

INT_CONSTANT
 : '0'
 | [1-9]DIGIT*
 ;

REAL_CONSTANT
 : INT_CONSTANT? FRACTION
 | INT_CONSTANT '.'
 | INT_CONSTANT EXPONENT
 | INT_CONSTANT '.' DIGIT* EXPONENT
 ;

CHAR_CONSTANT
 : '\'' . '\''
 | '\'' '\\' INT_CONSTANT INT_CONSTANT INT_CONSTANT'\''
 | '\'' '\\n' '\''
 | '\'' '\\t' '\''
 | '\'' '-' '\''
 ;

ID
 : [a-zA-Z_][a-zA-Z0-9_]*
 ;

IRI
 : '<' (~[\u0000-\u0020=<>"{}|^`\\] | UCHAR)* '>'
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