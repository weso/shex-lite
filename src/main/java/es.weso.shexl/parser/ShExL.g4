grammar ShExL;

shex_lite_doc
 : (prefix_def)+ (shape_def)+ EOF
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
 : ( c1=constraint_def | ( c2=constraint_def ';' )+ c3=constraint_def )
 ;

constraint_def
 : constraint_field constraint_type
 ;

constraint_field
 : prefix_inv ':' property_def
 ;

constraint_type returns [Constraint ast]
 : prefix_inv ':' primitive_type {$ast = new TypeConstraint($start.getLine(), $start.getPosInLine(), new PrefixInv($start.getLine(), $start.getPosInLine(), $prefix_inv.ast.getPrefixName(), $primitive_type.ast));}
 | '@' ':' shape_inv
 ;

property_def  returns [String ast]
 : ID {$ast = $ID.text;}
 ;

// ------------------
// INVOCATIONS
// ------------------

shape_inv  returns [Invocation ast]
 : ID {$ast = new ShapeInv($ID.line, $ID.pos+1, $ID.text);}
 ;

prefix_inv returns [Invocation ast]
 : ID? {$ast = new PrefixInv($ID.line, $ID.pos+1, $ID.text, "");}
 ;

primitive_type returns [String ast]
 : 'integer' {$ast = "INTEGER";}
 | 'string' {$ast = "STRING";}
 | 'double' {$ast = "DOUBLE";}
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