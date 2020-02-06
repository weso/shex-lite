grammar ShExLite;

shex_lite_doc
 : prefix_def+ shape_def+
 ;

prefix_def
 : 'PREFIX' ID? ':' IRI
 ;

shape_def
 : ':'ID shape_body
 ;

shape_body
 : '{' (shape_body_contraint';')+ '}'
 ;

shape_body_contraint
 : ID ':' ID ID ':'('string'|'double'|'int'|'char')
 ;

// TOKENS
fragment WHITE_SPACE
 : [ \t\r\n\fEOF]+
 ;


fragment COMMENT
 : ('#' ~[\r\n]* | '/*' (~[*] | '*' ('\\/' | ~[/]))* '*/') -> skip
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

IRI
 : '<' (~[\u0000-\u0020=<>"{}|^`\\] | UCHAR)* '>'
 ;

ID
 : [a-zA-Z_][a-zA-Z0-9_]*
 ;

SKIP_
 : ( WHITE_SPACE | COMMENT ) -> skip
 ;