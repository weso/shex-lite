parser grammar ShexLiteParser;

options { tokenVocab=ShexLiteLexer; }

schema
 : statement+ EOF
 ;

statement
 : import_stmt
 | definition_stmt
 ;

import_stmt
 : IMPORT iri=literal_iri_value_expr
 ;

definition_stmt
 : start_def_stmt
 | prefix_def_stmt
 | base_def_stmt
 | shape_def_stmt
 ;

start_def_stmt
 : START EQ shape=call_shape_expr
 ;

prefix_def_stmt
 : PREFIX IDENTIFIER? COLON iri=literal_iri_value_expr
 ;

base_def_stmt
 : BASE iri=literal_iri_value_expr
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
 : DECIMAL_LITERAL
 ;

literal_string_value_expr
 : STRING_LITERAL
 ;

literal_iri_value_expr
 : IRI_LITERAL
 ;

cardinality_expr
 : MUL
 | ADD
 | QUESTION
 | LBRACE min=DECIMAL_LITERAL RBRACE
 | LBRACE min=DECIMAL_LITERAL COMMA max=DECIMAL_LITERAL RBRACE
 | LBRACE min=DECIMAL_LITERAL COMMA RBRACE
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
 : LBRACE (constraint_triple_expr)+ RBRACE
 ;

constraint_triple_expr
 : property=call_prefix_expr constraint=constraint_node_expr cardinality=cardinality_expr? SEMI?
 ;

constraint_node_iri_expr
 : IRI
 ;

constraint_valid_value_set_type
 : call_prefix_expr
 | call_shape_expr
 | literal_string_value_expr
 | literal_real_value_expr
 ;

constraint_node_any_type_expr
 : ANYTYPE
 ;

constraint_node_non_literal_expr
 : NONLITERAL
 ;

constraint_value_set_expr
 : LBRACK constraint_valid_value_set_type* RBRACK
 ;

constraint_node_bnode_expr
 : BNODE
 ;

constraint_node_literal_expr
 : LITERAL
 ;

call_expr
 : call_prefix_expr
 | call_shape_expr
 ;

call_prefix_expr
 : pref_lbl=IDENTIFIER? COLON shape_lbl=IDENTIFIER
 | base_relative_lbl=literal_iri_value_expr
 ;

call_shape_expr
 : AT prefix_lbl=IDENTIFIER? COLON shape_lbl=IDENTIFIER
 | AT base_relative_lbl=literal_iri_value_expr
 ;