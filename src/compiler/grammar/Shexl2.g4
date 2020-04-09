grammar Shexl2;

schema
 : statement+ EOF
 ;

statement
 : import_stmt
 | definition_stmt
 ;

import_stmt
 : 'import' iri=literal_iri_value_expr
 ;

definition_stmt
 : start_def_stmt
 | prefix_def_stmt
 | base_def_stmt
 | shape_def_stmt
 ;

start_def_stmt
 : 'start' '=' shape=call_shape_expr
 ;

prefix_def_stmt
 : 'prefix' LABEL? ':' iri=literal_iri_value_expr
 ;

base_def_stmt
 : 'base' iri=literal_iri_value_expr
 ;

shape_def_stmt
 : label=call_prefix_expr expr=constraint_expr
 ;

expression
 : literal_expr
 | cardinality_expr
 | constraint_expr
 ;

literal_expr
 : literal_real_value_expr
 | literal_string_value_expr
 | literal_iri_value_expr
 ;

literal_real_value_expr
 : REAL_LITERAL
 ;

literal_string_value_expr
 : STRING_LITERAL
 ;

literal_iri_value_expr
 : IRI_LITERAL
 ;

cardinality_expr
 : '*'
 | '+'
 | '?'
 | '{' min=INT_LITERAL '}'
 | '{' min=INT_LITERAL ',' max=INT_LITERAL '}'
 | '{' min=INT_LITERAL ',''}'
 ;

constraint_expr
 : constraint_node_expr
 | constraint_block_triple_expr
 | constraint_triple_expr
 ;

constraint_node_expr
 : constraint_node_iri_expr
 | constraint_valid_value_set_type
 | constraint_node_any_type_expr
 | call_expr
 | constraint_node_non_literal_expr
 | constraint_value_set_expr
 | constraint_node_bnode_expr
 | constraint_node_literal_expr
 ;

constraint_block_triple_expr
 : '{' (constraint_triple_expr)+ '}'
 ;

constraint_triple_expr
 : property=call_prefix_expr constraint=constraint_node_expr cardinality=cardinality_expr?
 ;

constraint_node_iri_expr
 : 'iri'
 ;

constraint_valid_value_set_type
 : call_prefix_expr
 | call_shape_expr
 | literal_string_value_expr
 | literal_real_value_expr
 ;

constraint_node_any_type_expr
 : '.'
 ;

constraint_node_non_literal_expr
 : 'nonliteral'
 ;

constraint_value_set_expr
 : '[' constraint_valid_value_set_type* ']'
 ;

constraint_node_bnode_expr
 : 'bnode'
 ;

constraint_node_literal_expr
 : 'literal'
 ;

call_expr
 : call_prefix_expr
 | call_shape_expr
 ;

call_prefix_expr
 : pref_lbl=LABEL? ':' shape_lbl=LABEL
 | base_relative_lbl=literal_iri_value_expr
 ;

call_shape_expr
 : '@' prefix_lbl=LABEL? ':' shape_lbl=LABEL
 | '@' base_relative_lbl=literal_iri_value_expr
 ;

LABEL
 : [a-zA-Z_][a-zA-Z0-9_-·]*
 ;

IRI_LITERAL
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
 : '"'.*?'"'
 ;

SKIP_
 : ( WHITE_SPACE | COMMENT ) -> skip
 ;

/* FRAGMENTS*/

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