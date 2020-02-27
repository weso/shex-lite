grammar shexl;

file
 : definitions+ EOF
 ;

definitions
 : base_def
 | start_def
 | prefix_def
 | shape_def
 ;

base_def
 : 'base' IRI
 ;

start_def
 : 'start' '=' shape_ref
 ;

prefix_def
 : 'prefix' ID? ':' IRI
 ;

shape_def
 : shape_lbl '{' triple_expr '}'
 ;

shape_lbl
 : ':' ID
 ;

triple_expr
 : triple_constraint
 | (triple_constraint ';')+ triple_constraint
 ;

triple_constraint
 : property node_constraint cardinality
 ;

property
 : ID? ':' ID
 ;

node_constraint
 : prefix_ref
 | shape_ref
 | '.'
 ;

cardinality
 : '*'
 | '+'
 | '?'
 | '{' INT_LITERAL '}'
 | '{' INT_LITERAL ',' INT_LITERAL '}'
 | '{' INT_LITERAL ',''}'
 | // default cardinality
 ;

prefix_ref
 : ID? ':' ID
 ;

shape_ref
 : '@' ':' ID
 ;

ID
 : [a-zA-Z_][a-zA-Z0-9_]*
 ;

IRI
 : '<' (~[\u0000-\u0020=<>"{}|^`\\] | UCHAR)* '>'
 ;

INT_LITERAL
 : DIGIT+
 ;

SKIP_
 : ( WHITE_SPACE | COMMENT ) -> skip
 ;

fragment WHITE_SPACE
 : [ \t\r\n\fEOF]+
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

fragment UCHAR
 : '\\u' HEX HEX HEX HEX
 | '\\U' HEX HEX HEX HEX HEX HEX HEX HEX
 ;

fragment HEX
 : [0-9]
 | [A-F]
 | [a-f]
 ;