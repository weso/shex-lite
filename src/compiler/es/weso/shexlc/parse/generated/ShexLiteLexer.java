// ------------------------------------------------------------------------------
// File: ShexLiteLexer.java
//
// Short version for non-lawyers:
//
// The ShEx Lite Project is dual-licensed under GNU 3.0 and
// MIT terms.
//
// Longer version:
//
// Copyrights in the ShEx Lite project are retained by their contributors. No
// copyright assignment is required to contribute to the ShEx Lite project.
//
// Some files include explicit copyright notices and/or license notices.
// For full authorship information, see the version control history.
//
// Except as otherwise noted (below and/or in individual files), ShEx Lite is
// licensed under the GNU, Version 3.0 <LICENSE-GNU> or
// <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
// <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
// In case of incompatibility between project licenses, GNU/GPLv3 will be
// applied.
//
// The ShEx Lite Project includes packages written by third parties.
// ------------------------------------------------------------------------------

// Generated from
// C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/es/weso/shexlc/grammar\ShexLiteLexer.g4 by ANTLR 4.8
package es.weso.shexlc.parse.generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShexLiteLexer extends Lexer {
  public static final int ANYTYPE = 1,
      BASE = 2,
      BNODE = 3,
      IRI = 4,
      LITERAL = 5,
      NONLITERAL = 6,
      PREFIX = 7,
      START = 8,
      IMPORT = 9,
      STRING_LITERAL = 10,
      STATIC_STRING_LITERAL = 11,
      IRI_LITERAL = 12,
      DECIMAL_LITERAL = 13,
      FLOAT_LITERAL = 14,
      LPAREN = 15,
      RPAREN = 16,
      LBRACE = 17,
      RBRACE = 18,
      LBRACK = 19,
      RBRACK = 20,
      SEMI = 21,
      COLON = 22,
      COMMA = 23,
      AT = 24,
      ADD = 25,
      EQ = 26,
      MUL = 27,
      QUESTION = 28,
      COMMENT = 29,
      WHITE_SPACE = 30,
      IDENTIFIER = 31;
  public static final String[] ruleNames = makeRuleNames();
  /** @deprecated Use {@link #VOCABULARY} instead. */
  @Deprecated public static final String[] tokenNames;

  public static final String _serializedATN =
      "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u017d\b\1\4\2\t"
          + "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
          + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
          + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
          + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"
          + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"
          + ",\t,\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"
          + "\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"
          + "\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"
          + "\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\5\f\u0096\n\f\3\f\3\f\3\r\3\r\3\r"
          + "\7\r\u009d\n\r\f\r\16\r\u00a0\13\r\3\r\3\r\3\16\3\16\3\16\5\16\u00a7\n"
          + "\16\3\16\6\16\u00aa\n\16\r\16\16\16\u00ab\3\16\5\16\u00af\n\16\5\16\u00b1"
          + "\n\16\3\16\5\16\u00b4\n\16\3\17\3\17\3\17\5\17\u00b9\n\17\3\17\3\17\5"
          + "\17\u00bd\n\17\3\17\5\17\u00c0\n\17\3\17\5\17\u00c3\n\17\3\17\3\17\3\17"
          + "\5\17\u00c8\n\17\3\17\5\17\u00cb\n\17\5\17\u00cd\n\17\3\20\3\20\3\21\3"
          + "\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3"
          + "\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\7\36\u00ed"
          + "\n\36\f\36\16\36\u00f0\13\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5"
          + "\36\u00fa\n\36\7\36\u00fc\n\36\f\36\16\36\u00ff\13\36\3\36\3\36\5\36\u0103"
          + "\n\36\3\36\3\36\3\37\6\37\u0108\n\37\r\37\16\37\u0109\3\37\3\37\3 \3 "
          + "\5 \u0110\n \3!\5!\u0113\n!\3\"\6\"\u0116\n\"\r\"\16\"\u0117\3#\3#\5#"
          + "\u011c\n#\3$\6$\u011f\n$\r$\16$\u0120\3%\3%\5%\u0125\n%\3&\3&\3&\3&\3"
          + "&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"
          + "&\3&\3&\3&\3&\5&\u0147\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"
          + "\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u015d\n\'\3(\3(\7(\u0161\n(\f"
          + "(\16(\u0164\13(\3(\5(\u0167\n(\3)\3)\3*\3*\5*\u016d\n*\3*\3*\3+\3+\3+"
          + "\7+\u0174\n+\f+\16+\u0177\13+\3+\5+\u017a\n+\3,\3,\2\2-\3\3\5\4\7\5\t"
          + "\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"
          + "%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\2C\2E\2"
          + "G\2I\2K\2M\2O\2Q\2S\2U\2W\2\3\2\23\t\2\2\"$$>@^^``bb}\177\3\2\63;\4\2"
          + "NNnn\6\2FFHHffhh\4\2\f\f\17\17\3\2,,\3\2\61\61\5\2\13\f\16\17\"\"%\2C"
          + "\\aac|\u00aa\u00aa\u00ac\u00ac\u00af\u00af\u00b1\u00b1\u00b4\u00b7\u00b9"
          + "\u00bc\u00be\u00c0\u00c2\u00d8\u00da\u00f8\u00fa\u0301\u0372\u1681\u1683"
          + "\u180f\u1811\u1dc1\u1e02\u2001\u200d\u200f\u202c\u2030\u2041\u2042\u2056"
          + "\u2056\u2062\u20d1\u2102\u2191\u2462\u2501\u2778\u2795\u2c02\u2e01\u2e82"
          + "\u3001\u3006\u3009\u3023\u3031\u3033\ud801\uf902\ufd3f\ufd42\ufdd1\ufdf2"
          + "\ufe21\ufe32\ufe46\ufe49\uffff\7\2\62;\u0302\u0371\u1dc2\u1e01\u20d2\u2101"
          + "\ufe22\ufe31\6\2\f\f\17\17$$^^\t\2$$))\62\62^^ppttvv\4\2\62;aa\3\2\62"
          + ";\4\2GGgg\4\2--//\5\2\62;CHch\2\u0194\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"
          + "\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"
          + "\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"
          + "\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"
          + "\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"
          + "\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3Y\3"
          + "\2\2\2\5[\3\2\2\2\7`\3\2\2\2\tf\3\2\2\2\13j\3\2\2\2\rr\3\2\2\2\17}\3\2"
          + "\2\2\21\u0084\3\2\2\2\23\u008a\3\2\2\2\25\u0091\3\2\2\2\27\u0093\3\2\2"
          + "\2\31\u0099\3\2\2\2\33\u00b0\3\2\2\2\35\u00cc\3\2\2\2\37\u00ce\3\2\2\2"
          + "!\u00d0\3\2\2\2#\u00d2\3\2\2\2%\u00d4\3\2\2\2\'\u00d6\3\2\2\2)\u00d8\3"
          + "\2\2\2+\u00da\3\2\2\2-\u00dc\3\2\2\2/\u00de\3\2\2\2\61\u00e0\3\2\2\2\63"
          + "\u00e2\3\2\2\2\65\u00e4\3\2\2\2\67\u00e6\3\2\2\29\u00e8\3\2\2\2;\u0102"
          + "\3\2\2\2=\u0107\3\2\2\2?\u010d\3\2\2\2A\u0112\3\2\2\2C\u0115\3\2\2\2E"
          + "\u011b\3\2\2\2G\u011e\3\2\2\2I\u0124\3\2\2\2K\u0146\3\2\2\2M\u015c\3\2"
          + "\2\2O\u015e\3\2\2\2Q\u0168\3\2\2\2S\u016a\3\2\2\2U\u0170\3\2\2\2W\u017b"
          + "\3\2\2\2YZ\7\60\2\2Z\4\3\2\2\2[\\\7d\2\2\\]\7c\2\2]^\7u\2\2^_\7g\2\2_"
          + "\6\3\2\2\2`a\7d\2\2ab\7p\2\2bc\7q\2\2cd\7f\2\2de\7g\2\2e\b\3\2\2\2fg\7"
          + "k\2\2gh\7t\2\2hi\7k\2\2i\n\3\2\2\2jk\7n\2\2kl\7k\2\2lm\7v\2\2mn\7g\2\2"
          + "no\7t\2\2op\7c\2\2pq\7n\2\2q\f\3\2\2\2rs\7p\2\2st\7q\2\2tu\7p\2\2uv\7"
          + "n\2\2vw\7k\2\2wx\7v\2\2xy\7g\2\2yz\7t\2\2z{\7c\2\2{|\7n\2\2|\16\3\2\2"
          + "\2}~\7r\2\2~\177\7t\2\2\177\u0080\7g\2\2\u0080\u0081\7h\2\2\u0081\u0082"
          + "\7k\2\2\u0082\u0083\7z\2\2\u0083\20\3\2\2\2\u0084\u0085\7u\2\2\u0085\u0086"
          + "\7v\2\2\u0086\u0087\7c\2\2\u0087\u0088\7t\2\2\u0088\u0089\7v\2\2\u0089"
          + "\22\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c\7o\2\2\u008c\u008d\7r\2\2\u008d"
          + "\u008e\7q\2\2\u008e\u008f\7t\2\2\u008f\u0090\7v\2\2\u0090\24\3\2\2\2\u0091"
          + "\u0092\5\27\f\2\u0092\26\3\2\2\2\u0093\u0095\7$\2\2\u0094\u0096\5G$\2"
          + "\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098"
          + "\7$\2\2\u0098\30\3\2\2\2\u0099\u009e\7>\2\2\u009a\u009d\n\2\2\2\u009b"
          + "\u009d\5M\'\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2"
          + "\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0"
          + "\u009e\3\2\2\2\u00a1\u00a2\7@\2\2\u00a2\32\3\2\2\2\u00a3\u00b1\7\62\2"
          + "\2\u00a4\u00ae\t\3\2\2\u00a5\u00a7\5O(\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7"
          + "\3\2\2\2\u00a7\u00af\3\2\2\2\u00a8\u00aa\7a\2\2\u00a9\u00a8\3\2\2\2\u00aa"
          + "\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2"
          + "\2\2\u00ad\u00af\5O(\2\u00ae\u00a6\3\2\2\2\u00ae\u00a9\3\2\2\2\u00af\u00b1"
          + "\3\2\2\2\u00b0\u00a3\3\2\2\2\u00b0\u00a4\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"
          + "\u00b4\t\4\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\34\3\2\2"
          + "\2\u00b5\u00b6\5O(\2\u00b6\u00b8\7\60\2\2\u00b7\u00b9\5O(\2\u00b8\u00b7"
          + "\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bd\3\2\2\2\u00ba\u00bb\7\60\2\2"
          + "\u00bb\u00bd\5O(\2\u00bc\u00b5\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00bf"
          + "\3\2\2\2\u00be\u00c0\5S*\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"
          + "\u00c2\3\2\2\2\u00c1\u00c3\t\5\2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2"
          + "\2\2\u00c3\u00cd\3\2\2\2\u00c4\u00ca\5O(\2\u00c5\u00c7\5S*\2\u00c6\u00c8"
          + "\t\5\2\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"
          + "\u00cb\t\5\2\2\u00ca\u00c5\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cd\3\2"
          + "\2\2\u00cc\u00bc\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cd\36\3\2\2\2\u00ce\u00cf"
          + "\7*\2\2\u00cf \3\2\2\2\u00d0\u00d1\7+\2\2\u00d1\"\3\2\2\2\u00d2\u00d3"
          + "\7}\2\2\u00d3$\3\2\2\2\u00d4\u00d5\7\177\2\2\u00d5&\3\2\2\2\u00d6\u00d7"
          + "\7]\2\2\u00d7(\3\2\2\2\u00d8\u00d9\7_\2\2\u00d9*\3\2\2\2\u00da\u00db\7"
          + "=\2\2\u00db,\3\2\2\2\u00dc\u00dd\7<\2\2\u00dd.\3\2\2\2\u00de\u00df\7."
          + "\2\2\u00df\60\3\2\2\2\u00e0\u00e1\7B\2\2\u00e1\62\3\2\2\2\u00e2\u00e3"
          + "\7-\2\2\u00e3\64\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\66\3\2\2\2\u00e6\u00e7"
          + "\7,\2\2\u00e78\3\2\2\2\u00e8\u00e9\7A\2\2\u00e9:\3\2\2\2\u00ea\u00ee\7"
          + "%\2\2\u00eb\u00ed\n\6\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"
          + "\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u0103\3\2\2\2\u00f0\u00ee\3\2"
          + "\2\2\u00f1\u00f2\7\61\2\2\u00f2\u00f3\7,\2\2\u00f3\u00fd\3\2\2\2\u00f4"
          + "\u00fc\n\7\2\2\u00f5\u00f9\7,\2\2\u00f6\u00f7\7^\2\2\u00f7\u00fa\7\61"
          + "\2\2\u00f8\u00fa\n\b\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa"
          + "\u00fc\3\2\2\2\u00fb\u00f4\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fc\u00ff\3\2"
          + "\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"
          + "\u00fd\3\2\2\2\u0100\u0101\7,\2\2\u0101\u0103\7\61\2\2\u0102\u00ea\3\2"
          + "\2\2\u0102\u00f1\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\b\36\2\2\u0105"
          + "<\3\2\2\2\u0106\u0108\t\t\2\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2"
          + "\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c"
          + "\b\37\2\2\u010c>\3\2\2\2\u010d\u010f\5A!\2\u010e\u0110\5C\"\2\u010f\u010e"
          + "\3\2\2\2\u010f\u0110\3\2\2\2\u0110@\3\2\2\2\u0111\u0113\t\n\2\2\u0112"
          + "\u0111\3\2\2\2\u0113B\3\2\2\2\u0114\u0116\5E#\2\u0115\u0114\3\2\2\2\u0116"
          + "\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118D\3\2\2\2"
          + "\u0119\u011c\t\13\2\2\u011a\u011c\5A!\2\u011b\u0119\3\2\2\2\u011b\u011a"
          + "\3\2\2\2\u011cF\3\2\2\2\u011d\u011f\5I%\2\u011e\u011d\3\2\2\2\u011f\u0120"
          + "\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121H\3\2\2\2\u0122"
          + "\u0125\5K&\2\u0123\u0125\n\f\2\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2"
          + "\2\u0125J\3\2\2\2\u0126\u0127\7^\2\2\u0127\u0147\t\r\2\2\u0128\u0129\7"
          + "^\2\2\u0129\u012a\7z\2\2\u012a\u012b\3\2\2\2\u012b\u012c\5W,\2\u012c\u012d"
          + "\5W,\2\u012d\u0147\3\2\2\2\u012e\u012f\7^\2\2\u012f\u0130\7w\2\2\u0130"
          + "\u0131\3\2\2\2\u0131\u0132\7}\2\2\u0132\u0133\5W,\2\u0133\u0134\5W,\2"
          + "\u0134\u0135\5W,\2\u0135\u0136\5W,\2\u0136\u0137\7\177\2\2\u0137\u0147"
          + "\3\2\2\2\u0138\u0139\7^\2\2\u0139\u013a\7w\2\2\u013a\u013b\3\2\2\2\u013b"
          + "\u013c\7}\2\2\u013c\u013d\5W,\2\u013d\u013e\5W,\2\u013e\u013f\5W,\2\u013f"
          + "\u0140\5W,\2\u0140\u0141\5W,\2\u0141\u0142\5W,\2\u0142\u0143\5W,\2\u0143"
          + "\u0144\5W,\2\u0144\u0145\7\177\2\2\u0145\u0147\3\2\2\2\u0146\u0126\3\2"
          + "\2\2\u0146\u0128\3\2\2\2\u0146\u012e\3\2\2\2\u0146\u0138\3\2\2\2\u0147"
          + "L\3\2\2\2\u0148\u0149\7^\2\2\u0149\u014a\7w\2\2\u014a\u014b\3\2\2\2\u014b"
          + "\u014c\5W,\2\u014c\u014d\5W,\2\u014d\u014e\5W,\2\u014e\u014f\5W,\2\u014f"
          + "\u015d\3\2\2\2\u0150\u0151\7^\2\2\u0151\u0152\7w\2\2\u0152\u0153\3\2\2"
          + "\2\u0153\u0154\5W,\2\u0154\u0155\5W,\2\u0155\u0156\5W,\2\u0156\u0157\5"
          + "W,\2\u0157\u0158\5W,\2\u0158\u0159\5W,\2\u0159\u015a\5W,\2\u015a\u015b"
          + "\5W,\2\u015b\u015d\3\2\2\2\u015c\u0148\3\2\2\2\u015c\u0150\3\2\2\2\u015d"
          + "N\3\2\2\2\u015e\u0166\5Q)\2\u015f\u0161\t\16\2\2\u0160\u015f\3\2\2\2\u0161"
          + "\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\3\2"
          + "\2\2\u0164\u0162\3\2\2\2\u0165\u0167\5Q)\2\u0166\u0162\3\2\2\2\u0166\u0167"
          + "\3\2\2\2\u0167P\3\2\2\2\u0168\u0169\t\17\2\2\u0169R\3\2\2\2\u016a\u016c"
          + "\t\20\2\2\u016b\u016d\t\21\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2"
          + "\u016d\u016e\3\2\2\2\u016e\u016f\5O(\2\u016fT\3\2\2\2\u0170\u0179\5W,"
          + "\2\u0171\u0174\5W,\2\u0172\u0174\7a\2\2\u0173\u0171\3\2\2\2\u0173\u0172"
          + "\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176"
          + "\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u017a\5W,\2\u0179\u0175\3\2\2"
          + "\2\u0179\u017a\3\2\2\2\u017aV\3\2\2\2\u017b\u017c\t\22\2\2\u017cX\3\2"
          + "\2\2&\2\u0095\u009c\u009e\u00a6\u00ab\u00ae\u00b0\u00b3\u00b8\u00bc\u00bf"
          + "\u00c2\u00c7\u00ca\u00cc\u00ee\u00f9\u00fb\u00fd\u0102\u0109\u010f\u0112"
          + "\u0117\u011b\u0120\u0124\u0146\u015c\u0162\u0166\u016c\u0173\u0175\u0179"
          + "\3\2\3\2";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  private static final String[] _LITERAL_NAMES = makeLiteralNames();
  private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};
  public static String[] modeNames = {"DEFAULT_MODE"};

  static {
    RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
  }

  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }

  public ShexLiteLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  private static String[] makeRuleNames() {
    return new String[] {
      "ANYTYPE",
      "BASE",
      "BNODE",
      "IRI",
      "LITERAL",
      "NONLITERAL",
      "PREFIX",
      "START",
      "IMPORT",
      "STRING_LITERAL",
      "STATIC_STRING_LITERAL",
      "IRI_LITERAL",
      "DECIMAL_LITERAL",
      "FLOAT_LITERAL",
      "LPAREN",
      "RPAREN",
      "LBRACE",
      "RBRACE",
      "LBRACK",
      "RBRACK",
      "SEMI",
      "COLON",
      "COMMA",
      "AT",
      "ADD",
      "EQ",
      "MUL",
      "QUESTION",
      "COMMENT",
      "WHITE_SPACE",
      "IDENTIFIER",
      "Identifier_head",
      "Identifier_characters",
      "Identifier_character",
      "Quoted_text",
      "Quoted_text_item",
      "Escaped_character",
      "Unsigned_character",
      "Digits",
      "Digit",
      "Exponent_part",
      "Hexadecimal_digits",
      "Hexadecimal_digit"
    };
  }

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      "'.'",
      "'base'",
      "'bnode'",
      "'iri'",
      "'literal'",
      "'nonliteral'",
      "'prefix'",
      "'start'",
      "'import'",
      null,
      null,
      null,
      null,
      null,
      "'('",
      "')'",
      "'{'",
      "'}'",
      "'['",
      "']'",
      "';'",
      "':'",
      "','",
      "'@'",
      "'+'",
      "'='",
      "'*'",
      "'?'"
    };
  }

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "ANYTYPE",
      "BASE",
      "BNODE",
      "IRI",
      "LITERAL",
      "NONLITERAL",
      "PREFIX",
      "START",
      "IMPORT",
      "STRING_LITERAL",
      "STATIC_STRING_LITERAL",
      "IRI_LITERAL",
      "DECIMAL_LITERAL",
      "FLOAT_LITERAL",
      "LPAREN",
      "RPAREN",
      "LBRACE",
      "RBRACE",
      "LBRACK",
      "RBRACK",
      "SEMI",
      "COLON",
      "COMMA",
      "AT",
      "ADD",
      "EQ",
      "MUL",
      "QUESTION",
      "COMMENT",
      "WHITE_SPACE",
      "IDENTIFIER"
    };
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override
  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() {
    return "ShexLiteLexer.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public String[] getChannelNames() {
    return channelNames;
  }

  @Override
  public String[] getModeNames() {
    return modeNames;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }
}
