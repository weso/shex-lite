/*
 * MIT License
 *
 * Copyright (c) 2020 WESO Research Group, University of Oviedo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

// Generated from C:/Users/Willy/Documents/github/weso/shex-lite/src/main/java/es/weso/shexlite/parser\ShExL.g4 by ANTLR 4.8
package es.weso.shexlite.compiler.parser.generated;

import es.weso.shexlite.compiler.ast.*;
import java.util.*;
import java.lang.String;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShExLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		INT_CONSTANT=10, REAL_CONSTANT=11, CHAR_CONSTANT=12, ID=13, IRI=14, SKIP_=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID", "IRI", "SKIP_", 
			"WHITE_SPACE", "COMMENT", "DIGIT", "NON_ZERO_DIGIT", "EXPONENT", "FRACTION", 
			"UCHAR", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PREFIX'", "':'", "'{'", "'}'", "';'", "'@'", "'integer'", "'string'", 
			"'double'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "INT_CONSTANT", 
			"REAL_CONSTANT", "CHAR_CONSTANT", "ID", "IRI", "SKIP_"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ShExLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ShExL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u00f5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\7\13\\\n\13\f\13\16\13_\13\13\5\13a\n\13\3"+
		"\f\5\fd\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\fp\n\f\f\f\16\f"+
		"s\13\f\3\f\3\f\5\fw\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0090\n\r\3\16\3\16"+
		"\7\16\u0094\n\16\f\16\16\16\u0097\13\16\3\17\3\17\3\17\7\17\u009c\n\17"+
		"\f\17\16\17\u009f\13\17\3\17\3\17\3\20\3\20\5\20\u00a5\n\20\3\20\3\20"+
		"\3\21\6\21\u00aa\n\21\r\21\16\21\u00ab\3\22\3\22\7\22\u00b0\n\22\f\22"+
		"\16\22\u00b3\13\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00bd"+
		"\n\22\7\22\u00bf\n\22\f\22\16\22\u00c2\13\22\3\22\3\22\5\22\u00c6\n\22"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\5\25\u00d0\n\25\3\25\6\25\u00d3"+
		"\n\25\r\25\16\25\u00d4\3\26\3\26\6\26\u00d9\n\26\r\26\16\26\u00da\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u00f1\n\27\3\30\5\30\u00f4\n\30\2\2\31"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\2#\2%\2\'\2)\2+\2-\2/\2\3\2\16\3\2\63;\5\2C\\aac|\6\2\62;C\\a"+
		"ac|\t\2\2\"$$>@^^``bb}\177\7\2\13\f\16\17\"\"GHQQ\4\2\f\f\17\17\3\2,,"+
		"\3\2\61\61\3\2\62;\4\2GGgg\4\2--//\5\2\62;CHch\2\u0105\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3\61\3\2\2\2\58\3\2\2\2\7:\3\2\2\2"+
		"\t<\3\2\2\2\13>\3\2\2\2\r@\3\2\2\2\17B\3\2\2\2\21J\3\2\2\2\23Q\3\2\2\2"+
		"\25`\3\2\2\2\27v\3\2\2\2\31\u008f\3\2\2\2\33\u0091\3\2\2\2\35\u0098\3"+
		"\2\2\2\37\u00a4\3\2\2\2!\u00a9\3\2\2\2#\u00c5\3\2\2\2%\u00c9\3\2\2\2\'"+
		"\u00cb\3\2\2\2)\u00cd\3\2\2\2+\u00d6\3\2\2\2-\u00f0\3\2\2\2/\u00f3\3\2"+
		"\2\2\61\62\7R\2\2\62\63\7T\2\2\63\64\7G\2\2\64\65\7H\2\2\65\66\7K\2\2"+
		"\66\67\7Z\2\2\67\4\3\2\2\289\7<\2\29\6\3\2\2\2:;\7}\2\2;\b\3\2\2\2<=\7"+
		"\177\2\2=\n\3\2\2\2>?\7=\2\2?\f\3\2\2\2@A\7B\2\2A\16\3\2\2\2BC\7k\2\2"+
		"CD\7p\2\2DE\7v\2\2EF\7g\2\2FG\7i\2\2GH\7g\2\2HI\7t\2\2I\20\3\2\2\2JK\7"+
		"u\2\2KL\7v\2\2LM\7t\2\2MN\7k\2\2NO\7p\2\2OP\7i\2\2P\22\3\2\2\2QR\7f\2"+
		"\2RS\7q\2\2ST\7w\2\2TU\7d\2\2UV\7n\2\2VW\7g\2\2W\24\3\2\2\2Xa\7\62\2\2"+
		"Y]\t\2\2\2Z\\\5%\23\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^a\3\2\2"+
		"\2_]\3\2\2\2`X\3\2\2\2`Y\3\2\2\2a\26\3\2\2\2bd\5\25\13\2cb\3\2\2\2cd\3"+
		"\2\2\2de\3\2\2\2ew\5+\26\2fg\5\25\13\2gh\7\60\2\2hw\3\2\2\2ij\5\25\13"+
		"\2jk\5)\25\2kw\3\2\2\2lm\5\25\13\2mq\7\60\2\2np\5%\23\2on\3\2\2\2ps\3"+
		"\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\5)\25\2uw\3\2\2\2vc\3"+
		"\2\2\2vf\3\2\2\2vi\3\2\2\2vl\3\2\2\2w\30\3\2\2\2xy\7)\2\2yz\13\2\2\2z"+
		"\u0090\7)\2\2{|\7)\2\2|}\7^\2\2}~\5\25\13\2~\177\5\25\13\2\177\u0080\5"+
		"\25\13\2\u0080\u0081\7)\2\2\u0081\u0090\3\2\2\2\u0082\u0083\7)\2\2\u0083"+
		"\u0084\7^\2\2\u0084\u0085\7p\2\2\u0085\u0086\3\2\2\2\u0086\u0090\7)\2"+
		"\2\u0087\u0088\7)\2\2\u0088\u0089\7^\2\2\u0089\u008a\7v\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u0090\7)\2\2\u008c\u008d\7)\2\2\u008d\u008e\7/\2\2\u008e"+
		"\u0090\7)\2\2\u008fx\3\2\2\2\u008f{\3\2\2\2\u008f\u0082\3\2\2\2\u008f"+
		"\u0087\3\2\2\2\u008f\u008c\3\2\2\2\u0090\32\3\2\2\2\u0091\u0095\t\3\2"+
		"\2\u0092\u0094\t\4\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\34\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009d\7>\2\2\u0099\u009c\n\5\2\2\u009a\u009c\5-\27\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7@"+
		"\2\2\u00a1\36\3\2\2\2\u00a2\u00a5\5!\21\2\u00a3\u00a5\5#\22\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\20\2\2"+
		"\u00a7 \3\2\2\2\u00a8\u00aa\t\6\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\"\3\2\2\2\u00ad\u00b1"+
		"\7%\2\2\u00ae\u00b0\n\7\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00c6\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b6\7,\2\2\u00b6\u00c0\3\2\2\2\u00b7"+
		"\u00bf\n\b\2\2\u00b8\u00bc\7,\2\2\u00b9\u00ba\7^\2\2\u00ba\u00bd\7\61"+
		"\2\2\u00bb\u00bd\n\t\2\2\u00bc\u00b9\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00b7\3\2\2\2\u00be\u00b8\3\2\2\2\u00bf\u00c2\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7,\2\2\u00c4\u00c6\7\61\2\2\u00c5\u00ad\3\2"+
		"\2\2\u00c5\u00b4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\22\2\2\u00c8"+
		"$\3\2\2\2\u00c9\u00ca\t\n\2\2\u00ca&\3\2\2\2\u00cb\u00cc\t\2\2\2\u00cc"+
		"(\3\2\2\2\u00cd\u00cf\t\13\2\2\u00ce\u00d0\t\f\2\2\u00cf\u00ce\3\2\2\2"+
		"\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00d3\5%\23\2\u00d2\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"*\3\2\2\2\u00d6\u00d8\7\60\2\2\u00d7\u00d9\5%\23\2\u00d8\u00d7\3\2\2\2"+
		"\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db,\3"+
		"\2\2\2\u00dc\u00dd\7^\2\2\u00dd\u00de\7w\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\5/\30\2\u00e0\u00e1\5/\30\2\u00e1\u00e2\5/\30\2\u00e2\u00e3\5/"+
		"\30\2\u00e3\u00f1\3\2\2\2\u00e4\u00e5\7^\2\2\u00e5\u00e6\7W\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e8\5/\30\2\u00e8\u00e9\5/\30\2\u00e9\u00ea\5/"+
		"\30\2\u00ea\u00eb\5/\30\2\u00eb\u00ec\5/\30\2\u00ec\u00ed\5/\30\2\u00ed"+
		"\u00ee\5/\30\2\u00ee\u00ef\5/\30\2\u00ef\u00f1\3\2\2\2\u00f0\u00dc\3\2"+
		"\2\2\u00f0\u00e4\3\2\2\2\u00f1.\3\2\2\2\u00f2\u00f4\t\r\2\2\u00f3\u00f2"+
		"\3\2\2\2\u00f4\60\3\2\2\2\30\2]`cqv\u008f\u0095\u009b\u009d\u00a4\u00ab"+
		"\u00b1\u00bc\u00be\u00c0\u00c5\u00cf\u00d4\u00da\u00f0\u00f3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}