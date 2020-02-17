grammar ShExL;

@header {
import es.weso.shexlite.ast.*;
import java.util.*;
import java.lang.String;
}

shex_lite_doc returns [ShExL ast]
 : {List<Definition> defs = new ArrayList<Definition>();} (prefix_def {defs.add($prefix_def.ast);})+ (shape_def{defs.add($shape_def.ast);})+ {$ast = new ShExL($start.getLine(), $start.getCharPositionInLine(), defs);} EOF
 ;

// ------------------
// DEFINITIONS
// ------------------

prefix_def returns [PrefixDef ast]
 : 'PREFIX' ID? ':' IRI {$ast = new PrefixDef($start.getLine(), $start.getCharPositionInLine(), $ID.text, new URL($start.getLine(), $start.getCharPositionInLine(), $IRI.text));}
 ;

shape_def returns [ShapeDef ast]
 : ':' ID '{' shape_body '}' {$ast = new ShapeDef($start.getLine(), $start.getCharPositionInLine(), $ID.text, $shape_body.ast);}
 ;

shape_body returns [List<Constraint> ast = new ArrayList<Constraint>()]
 : ( c1=constraint_def {$ast.add($c1.ast);} | ( c2=constraint_def ';' {$ast.add($c2.ast);} )+ c3=constraint_def {$ast.add($c3.ast);} )
 ;

constraint_def returns [Constraint ast]
 : constraint_field constraint_type {$ast = new Constraint($start.getLine(), $start.getCharPositionInLine(), $constraint_field.ast, $constraint_type.ast);}
 ;

constraint_field returns [FieldConstraint ast]
 : prefix_inv ':' property_def {$ast = new FieldConstraint($start.getLine(), $start.getCharPositionInLine(), new PrefixInv($start.getLine(), $start.getCharPositionInLine(), $prefix_inv.ast.prefixName(), $property_def.ast));}
 ;

constraint_type returns [TypeConstraint ast]
 : prefix_inv ':' primitive_type {$ast = new TypeConstraint($start.getLine(), $start.getCharPositionInLine(), new PrefixInv($start.getLine(), $start.getCharPositionInLine(), $prefix_inv.ast.prefixName(), $primitive_type.ast));}
 | '@' ':' shape_inv {$ast = new TypeConstraint($start.getLine(), $start.getCharPositionInLine(), new ShapeInv($start.getLine(), $start.getCharPositionInLine(), $shape_inv.ast.shapeName()));}
 ;

property_def  returns [String ast]
 : ID {$ast = $ID.text;}
 ;

// ------------------
// INVOCATIONS
// ------------------

shape_inv  returns [ShapeInv ast]
 : ID {$ast = new ShapeInv($ID.line, $ID.pos+1, $ID.text);}
 ;

prefix_inv returns [PrefixInv ast]
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