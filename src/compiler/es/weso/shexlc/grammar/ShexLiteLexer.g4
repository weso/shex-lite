lexer grammar ShexLiteLexer;

// KEYWORDS

//A:                  'a';
ANYTYPE:            '.';
BASE:               'base';
BNODE:              'bnode';
IRI:                'iri';
LITERAL:		    'literal';
NONLITERAL:         'nonliteral';
PREFIX:             'prefix';
START:              'start';
IMPORT:             'import';

// Literals

STRING_LITERAL:         STATIC_STRING_LITERAL;        // Meant to be extended with interpolated text. (from Swift 3)
STATIC_STRING_LITERAL:  '"' Quoted_text? '"';
IRI_LITERAL:            '<' (~[\u0000-\u0020=<>"{}|^`\\] | Unsigned_character)* '>';
DECIMAL_LITERAL:        ('0' | [1-9] (Digits? | '_'+ Digits)) [lL]?;
FLOAT_LITERAL
 :                      (Digits '.' Digits? | '.' Digits) Exponent_part? [fFdD]?
 |                      Digits (Exponent_part [fFdD]? | [fFdD])
 ;

// Separators

LPAREN:             '(';
RPAREN:             ')';
LBRACE:             '{';
RBRACE:             '}';
LBRACK:             '[';
RBRACK:             ']';
SEMI:               ';';
COLON :             ':';
COMMA:              ',';

// Operators

AT:                 '@';
ADD:                '+';
EQ:                 '=';
MUL:                '*';
QUESTION:           '?';

// Comments and Whitespace

COMMENT:            ('#' ~[\r\n]* | '/*' (~[*] | '*' ('\\/' | ~[/]))* '*/') -> channel(HIDDEN);
WHITE_SPACE:        [ \t\r\n\f]+  -> channel(HIDDEN);

// Identifiers

IDENTIFIER:         Identifier_head Identifier_characters?;

fragment Identifier_head
 : [a-zA-Z]
 | '_'
 | '\u00A8' | '\u00AA' | '\u00AD' | '\u00AF' | [\u00B2-\u00B5] | [\u00B7-\u00BA]
 | [\u00BC-\u00BE] | [\u00C0-\u00D6] | [\u00D8-\u00F6] | [\u00F8-\u00FF]
 | [\u0100-\u02FF] | [\u0370-\u167F] | [\u1681-\u180D] | [\u180F-\u1DBF]
 | [\u1E00-\u1FFF]
 | [\u200B-\u200D] | [\u202A-\u202E] | [\u203F-\u2040] | '\u2054' | [\u2060-\u206F]
 | [\u2070-\u20CF] | [\u2100-\u218F] | [\u2460-\u24FF] | [\u2776-\u2793]
 | [\u2C00-\u2DFF] | [\u2E80-\u2FFF]
 | [\u3004-\u3007] | [\u3021-\u302F] | [\u3031-\u303F] | [\u3040-\uD7FF]
 | [\uF900-\uFD3D] | [\uFD40-\uFDCF] | [\uFDF0-\uFE1F] | [\uFE30-\uFE44]
 | [\uFE47-\uFFFD]
 ;

fragment Identifier_characters
 : Identifier_character+
 ;

fragment Identifier_character
 : [0-9]
 | [\u0300-\u036F]
 | [\u1DC0-\u1DFF]
 | [\u20D0-\u20FF]
 | [\uFE20-\uFE2F]
 | Identifier_head
 ;

// Fragment rules

fragment Quoted_text
 : Quoted_text_item+
 ;

fragment Quoted_text_item
 : Escaped_character
 | ~["\n\r\\]
 ;

fragment Escaped_character
 : '\\' [0\\tnr"']
 | '\\x' Hexadecimal_digit Hexadecimal_digit
 | '\\u' '{' Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit '}'
 | '\\u' '{' Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit '}'
 ;

fragment Unsigned_character
 : '\\u' Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit
 | '\\u' Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit  Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit
 ;

fragment Digits
 : Digit ([0-9_]* Digit)?
 ;

fragment Digit
 : [0-9]
 ;

fragment Exponent_part
 : [eE] [+-]? Digits
 ;

fragment Hexadecimal_digits
 : Hexadecimal_digit ((Hexadecimal_digit | '_')* Hexadecimal_digit)?
 ;

fragment Hexadecimal_digit
 : [0-9a-fA-F]
 ;
