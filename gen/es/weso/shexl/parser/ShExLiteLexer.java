// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/main/java/es.weso.shexl/parser\ShExL.g4 by ANTLR 4.8
package es.weso.shexl.parser;

  import es.weso.shexl.*;
  import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShExLiteLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT_CONSTANT=11, REAL_CONSTANT=12, CHAR_CONSTANT=13, ID=14, IRI=15, 
		SKIP_=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID", "IRI", 
			"SKIP_", "WHITE_SPACE", "COMMENT", "DIGIT", "NON_ZERO_DIGIT", "EXPONENT", 
			"FRACTION", "UCHAR", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PREFIX'", "':'", "'{'", "'}'", "';'", "'@:'", "'integer'", "'string'", 
			"'double'", "'long'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INT_CONSTANT", 
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


	public ShExLiteLexer(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u00fd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\7\fd\n"+
		"\f\f\f\16\fg\13\f\5\fi\n\f\3\r\5\rl\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\7\rx\n\r\f\r\16\r{\13\r\3\r\3\r\5\r\177\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0098\n\16\3\17\3\17\7\17\u009c\n"+
		"\17\f\17\16\17\u009f\13\17\3\20\3\20\3\20\7\20\u00a4\n\20\f\20\16\20\u00a7"+
		"\13\20\3\20\3\20\3\21\3\21\5\21\u00ad\n\21\3\21\3\21\3\22\6\22\u00b2\n"+
		"\22\r\22\16\22\u00b3\3\23\3\23\7\23\u00b8\n\23\f\23\16\23\u00bb\13\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c5\n\23\7\23\u00c7\n"+
		"\23\f\23\16\23\u00ca\13\23\3\23\3\23\5\23\u00ce\n\23\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\5\26\u00d8\n\26\3\26\6\26\u00db\n\26\r\26\16\26"+
		"\u00dc\3\27\3\27\6\27\u00e1\n\27\r\27\16\27\u00e2\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u00f9\n\30\3\31\5\31\u00fc\n\31\2\2\32\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\2"+
		"\'\2)\2+\2-\2/\2\61\2\3\2\16\3\2\63;\5\2C\\aac|\6\2\62;C\\aac|\t\2\2\""+
		"$$>@^^``bb}\177\7\2\13\f\16\17\"\"GHQQ\4\2\f\f\17\17\3\2,,\3\2\61\61\3"+
		"\2\62;\4\2GGgg\4\2--//\5\2\62;CHch\2\u010d\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3\63\3\2\2\2\5:\3\2\2\2\7<\3\2\2\2"+
		"\t>\3\2\2\2\13@\3\2\2\2\rB\3\2\2\2\17E\3\2\2\2\21M\3\2\2\2\23T\3\2\2\2"+
		"\25[\3\2\2\2\27h\3\2\2\2\31~\3\2\2\2\33\u0097\3\2\2\2\35\u0099\3\2\2\2"+
		"\37\u00a0\3\2\2\2!\u00ac\3\2\2\2#\u00b1\3\2\2\2%\u00cd\3\2\2\2\'\u00d1"+
		"\3\2\2\2)\u00d3\3\2\2\2+\u00d5\3\2\2\2-\u00de\3\2\2\2/\u00f8\3\2\2\2\61"+
		"\u00fb\3\2\2\2\63\64\7R\2\2\64\65\7T\2\2\65\66\7G\2\2\66\67\7H\2\2\67"+
		"8\7K\2\289\7Z\2\29\4\3\2\2\2:;\7<\2\2;\6\3\2\2\2<=\7}\2\2=\b\3\2\2\2>"+
		"?\7\177\2\2?\n\3\2\2\2@A\7=\2\2A\f\3\2\2\2BC\7B\2\2CD\7<\2\2D\16\3\2\2"+
		"\2EF\7k\2\2FG\7p\2\2GH\7v\2\2HI\7g\2\2IJ\7i\2\2JK\7g\2\2KL\7t\2\2L\20"+
		"\3\2\2\2MN\7u\2\2NO\7v\2\2OP\7t\2\2PQ\7k\2\2QR\7p\2\2RS\7i\2\2S\22\3\2"+
		"\2\2TU\7f\2\2UV\7q\2\2VW\7w\2\2WX\7d\2\2XY\7n\2\2YZ\7g\2\2Z\24\3\2\2\2"+
		"[\\\7n\2\2\\]\7q\2\2]^\7p\2\2^_\7i\2\2_\26\3\2\2\2`i\7\62\2\2ae\t\2\2"+
		"\2bd\5\'\24\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2"+
		"\2\2h`\3\2\2\2ha\3\2\2\2i\30\3\2\2\2jl\5\27\f\2kj\3\2\2\2kl\3\2\2\2lm"+
		"\3\2\2\2m\177\5-\27\2no\5\27\f\2op\7\60\2\2p\177\3\2\2\2qr\5\27\f\2rs"+
		"\5+\26\2s\177\3\2\2\2tu\5\27\f\2uy\7\60\2\2vx\5\'\24\2wv\3\2\2\2x{\3\2"+
		"\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\5+\26\2}\177\3\2\2\2~k"+
		"\3\2\2\2~n\3\2\2\2~q\3\2\2\2~t\3\2\2\2\177\32\3\2\2\2\u0080\u0081\7)\2"+
		"\2\u0081\u0082\13\2\2\2\u0082\u0098\7)\2\2\u0083\u0084\7)\2\2\u0084\u0085"+
		"\7^\2\2\u0085\u0086\5\27\f\2\u0086\u0087\5\27\f\2\u0087\u0088\5\27\f\2"+
		"\u0088\u0089\7)\2\2\u0089\u0098\3\2\2\2\u008a\u008b\7)\2\2\u008b\u008c"+
		"\7^\2\2\u008c\u008d\7p\2\2\u008d\u008e\3\2\2\2\u008e\u0098\7)\2\2\u008f"+
		"\u0090\7)\2\2\u0090\u0091\7^\2\2\u0091\u0092\7v\2\2\u0092\u0093\3\2\2"+
		"\2\u0093\u0098\7)\2\2\u0094\u0095\7)\2\2\u0095\u0096\7/\2\2\u0096\u0098"+
		"\7)\2\2\u0097\u0080\3\2\2\2\u0097\u0083\3\2\2\2\u0097\u008a\3\2\2\2\u0097"+
		"\u008f\3\2\2\2\u0097\u0094\3\2\2\2\u0098\34\3\2\2\2\u0099\u009d\t\3\2"+
		"\2\u009a\u009c\t\4\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\36\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a5\7>\2\2\u00a1\u00a4\n\5\2\2\u00a2\u00a4\5/\30\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7@"+
		"\2\2\u00a9 \3\2\2\2\u00aa\u00ad\5#\22\2\u00ab\u00ad\5%\23\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\b\21\2\2"+
		"\u00af\"\3\2\2\2\u00b0\u00b2\t\6\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3"+
		"\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4$\3\2\2\2\u00b5\u00b9"+
		"\7%\2\2\u00b6\u00b8\n\7\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00ce\3\2\2\2\u00bb\u00b9\3\2"+
		"\2\2\u00bc\u00bd\7\61\2\2\u00bd\u00be\7,\2\2\u00be\u00c8\3\2\2\2\u00bf"+
		"\u00c7\n\b\2\2\u00c0\u00c4\7,\2\2\u00c1\u00c2\7^\2\2\u00c2\u00c5\7\61"+
		"\2\2\u00c3\u00c5\n\t\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5"+
		"\u00c7\3\2\2\2\u00c6\u00bf\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c7\u00ca\3\2"+
		"\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00cc\7,\2\2\u00cc\u00ce\7\61\2\2\u00cd\u00b5\3\2"+
		"\2\2\u00cd\u00bc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\b\23\2\2\u00d0"+
		"&\3\2\2\2\u00d1\u00d2\t\n\2\2\u00d2(\3\2\2\2\u00d3\u00d4\t\2\2\2\u00d4"+
		"*\3\2\2\2\u00d5\u00d7\t\13\2\2\u00d6\u00d8\t\f\2\2\u00d7\u00d6\3\2\2\2"+
		"\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00db\5\'\24\2\u00da\u00d9"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		",\3\2\2\2\u00de\u00e0\7\60\2\2\u00df\u00e1\5\'\24\2\u00e0\u00df\3\2\2"+
		"\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3."+
		"\3\2\2\2\u00e4\u00e5\7^\2\2\u00e5\u00e6\7w\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\5\61\31\2\u00e8\u00e9\5\61\31\2\u00e9\u00ea\5\61\31\2\u00ea\u00eb"+
		"\5\61\31\2\u00eb\u00f9\3\2\2\2\u00ec\u00ed\7^\2\2\u00ed\u00ee\7W\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\5\61\31\2\u00f0\u00f1\5\61\31\2\u00f1\u00f2"+
		"\5\61\31\2\u00f2\u00f3\5\61\31\2\u00f3\u00f4\5\61\31\2\u00f4\u00f5\5\61"+
		"\31\2\u00f5\u00f6\5\61\31\2\u00f6\u00f7\5\61\31\2\u00f7\u00f9\3\2\2\2"+
		"\u00f8\u00e4\3\2\2\2\u00f8\u00ec\3\2\2\2\u00f9\60\3\2\2\2\u00fa\u00fc"+
		"\t\r\2\2\u00fb\u00fa\3\2\2\2\u00fc\62\3\2\2\2\30\2ehky~\u0097\u009d\u00a3"+
		"\u00a5\u00ac\u00b3\u00b9\u00c4\u00c6\u00c8\u00cd\u00d7\u00dc\u00e2\u00f8"+
		"\u00fb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}