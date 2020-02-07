grammar ShExLite;

@header {
  import es.weso.shexl.*;
  import java.util.*;
}

shex_lite_doc returns [ShExL ast]
 : {List<Definition> defs = new ArrayList<Definition>();} (prefix_def {defs.add($prefix_def.ast);})+ (shape_def {defs.add($shape_def.ast);})+ EOF {$ast = new ShExL(0,0,defs);}
 ;

// ------------------
// DEFINITIONS
// ------------------

prefix_def returns [Definition ast]
 : 'PREFIX' ID? ':' IRI {$ast = new PrefixDef($IRI.line, $IRI.pos+1, $ID.text, new URI($IRI.line, $IRI.pos+1, $IRI.text));}
 ;

shape_def returns [Definition ast]
 : ':' ID '{' shape_body '}' {$ast = new ShapeDef($ID.line, $ID.pos+1, $ID.text, $shape_body.ast);}
 ;

shape_body returns [List<Constraint> ast = new ArrayList<Constraint>()]
 : (c1=constraint_def {$ast.add($c1.ast)} | (c2=constraint_def';' {$ast.add($c2.ast)})+ c3=constraint_def {$ast.add($c3.ast)})
 ;

constraint_def returns [Constraint $ast]
 : contraint_id constraint_type {$ast = new ShapeConstraintStmt($contraint_id.line, $contraint_id.pos+1, $contraint_id.text, $contraint_type, null);}
 ;

contraint_id returns [
]
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