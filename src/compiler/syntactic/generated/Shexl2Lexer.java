// Generated from C:/Users/Willy/Documents/github/weso/shex-lite/src/compiler/grammar\Shexl2.g4 by ANTLR 4.8
package compiler.syntactic.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Shexl2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, LABEL=21, IRI_LITERAL=22, INT_LITERAL=23, 
		REAL_LITERAL=24, STRING_LITERAL=25, SKIP_=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "LABEL", "IRI_LITERAL", "INT_LITERAL", "REAL_LITERAL", 
			"STRING_LITERAL", "SKIP_", "WHITE_SPACE", "COMMENT", "DIGIT", "NON_ZERO_DIGIT", 
			"EXPONENT", "FRACTION", "UCHAR", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'start'", "'='", "'prefix'", "':'", "'base'", "'*'", 
			"'+'", "'?'", "'{'", "'}'", "','", "'iri'", "'.'", "'nonliteral'", "'['", 
			"']'", "'bnode'", "'literal'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "LABEL", "IRI_LITERAL", 
			"INT_LITERAL", "REAL_LITERAL", "STRING_LITERAL", "SKIP_"
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


	public Shexl2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Shexl2.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u0120\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\26\3\26\7\26\u0098\n\26\f\26\16\26\u009b\13"+
		"\26\3\27\3\27\3\27\7\27\u00a0\n\27\f\27\16\27\u00a3\13\27\3\27\3\27\3"+
		"\30\3\30\3\30\7\30\u00aa\n\30\f\30\16\30\u00ad\13\30\5\30\u00af\n\30\3"+
		"\31\5\31\u00b2\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u00be\n\31\f\31\16\31\u00c1\13\31\3\31\3\31\5\31\u00c5\n\31\3\32"+
		"\3\32\7\32\u00c9\n\32\f\32\16\32\u00cc\13\32\3\32\3\32\3\33\3\33\5\33"+
		"\u00d2\n\33\3\33\3\33\3\34\6\34\u00d7\n\34\r\34\16\34\u00d8\3\35\3\35"+
		"\7\35\u00dd\n\35\f\35\16\35\u00e0\13\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u00ea\n\35\7\35\u00ec\n\35\f\35\16\35\u00ef\13\35\3\35"+
		"\3\35\5\35\u00f3\n\35\3\36\3\36\3\37\3\37\3 \3 \5 \u00fb\n \3 \6 \u00fe"+
		"\n \r \16 \u00ff\3!\3!\6!\u0104\n!\r!\16!\u0105\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u011c\n"+
		"\"\3#\5#\u011f\n#\3\u00ca\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\29\2;\2=\2?\2A\2C\2E\2\3\2\16\5\2C\\aac|\5\2\62;C\\"+
		"a\u00c4\t\2\2\"$$>@^^``bb}\177\3\2\63;\5\2\13\f\16\17\"\"\4\2\f\f\17\17"+
		"\3\2,,\3\2\61\61\3\2\62;\4\2GGgg\4\2--//\5\2\62;CHch\2\u012d\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3G\3\2\2\2\5N\3\2\2\2\7T\3\2\2\2\tV\3\2"+
		"\2\2\13]\3\2\2\2\r_\3\2\2\2\17d\3\2\2\2\21f\3\2\2\2\23h\3\2\2\2\25j\3"+
		"\2\2\2\27l\3\2\2\2\31n\3\2\2\2\33p\3\2\2\2\35t\3\2\2\2\37v\3\2\2\2!\u0081"+
		"\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u008b\3\2\2\2)\u0093\3\2\2\2"+
		"+\u0095\3\2\2\2-\u009c\3\2\2\2/\u00ae\3\2\2\2\61\u00c4\3\2\2\2\63\u00c6"+
		"\3\2\2\2\65\u00d1\3\2\2\2\67\u00d6\3\2\2\29\u00f2\3\2\2\2;\u00f4\3\2\2"+
		"\2=\u00f6\3\2\2\2?\u00f8\3\2\2\2A\u0101\3\2\2\2C\u011b\3\2\2\2E\u011e"+
		"\3\2\2\2GH\7k\2\2HI\7o\2\2IJ\7r\2\2JK\7q\2\2KL\7t\2\2LM\7v\2\2M\4\3\2"+
		"\2\2NO\7u\2\2OP\7v\2\2PQ\7c\2\2QR\7t\2\2RS\7v\2\2S\6\3\2\2\2TU\7?\2\2"+
		"U\b\3\2\2\2VW\7r\2\2WX\7t\2\2XY\7g\2\2YZ\7h\2\2Z[\7k\2\2[\\\7z\2\2\\\n"+
		"\3\2\2\2]^\7<\2\2^\f\3\2\2\2_`\7d\2\2`a\7c\2\2ab\7u\2\2bc\7g\2\2c\16\3"+
		"\2\2\2de\7,\2\2e\20\3\2\2\2fg\7-\2\2g\22\3\2\2\2hi\7A\2\2i\24\3\2\2\2"+
		"jk\7}\2\2k\26\3\2\2\2lm\7\177\2\2m\30\3\2\2\2no\7.\2\2o\32\3\2\2\2pq\7"+
		"k\2\2qr\7t\2\2rs\7k\2\2s\34\3\2\2\2tu\7\60\2\2u\36\3\2\2\2vw\7p\2\2wx"+
		"\7q\2\2xy\7p\2\2yz\7n\2\2z{\7k\2\2{|\7v\2\2|}\7g\2\2}~\7t\2\2~\177\7c"+
		"\2\2\177\u0080\7n\2\2\u0080 \3\2\2\2\u0081\u0082\7]\2\2\u0082\"\3\2\2"+
		"\2\u0083\u0084\7_\2\2\u0084$\3\2\2\2\u0085\u0086\7d\2\2\u0086\u0087\7"+
		"p\2\2\u0087\u0088\7q\2\2\u0088\u0089\7f\2\2\u0089\u008a\7g\2\2\u008a&"+
		"\3\2\2\2\u008b\u008c\7n\2\2\u008c\u008d\7k\2\2\u008d\u008e\7v\2\2\u008e"+
		"\u008f\7g\2\2\u008f\u0090\7t\2\2\u0090\u0091\7c\2\2\u0091\u0092\7n\2\2"+
		"\u0092(\3\2\2\2\u0093\u0094\7B\2\2\u0094*\3\2\2\2\u0095\u0099\t\2\2\2"+
		"\u0096\u0098\t\3\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a,\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\u00a1\7>\2\2\u009d\u00a0\n\4\2\2\u009e\u00a0\5C\"\2\u009f\u009d\3\2\2"+
		"\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5"+
		".\3\2\2\2\u00a6\u00af\7\62\2\2\u00a7\u00ab\t\5\2\2\u00a8\u00aa\5;\36\2"+
		"\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae"+
		"\u00a7\3\2\2\2\u00af\60\3\2\2\2\u00b0\u00b2\5/\30\2\u00b1\u00b0\3\2\2"+
		"\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00c5\5A!\2\u00b4\u00b5"+
		"\5/\30\2\u00b5\u00b6\7\60\2\2\u00b6\u00c5\3\2\2\2\u00b7\u00b8\5/\30\2"+
		"\u00b8\u00b9\5? \2\u00b9\u00c5\3\2\2\2\u00ba\u00bb\5/\30\2\u00bb\u00bf"+
		"\7\60\2\2\u00bc\u00be\5;\36\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2"+
		"\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c2\u00c3\5? \2\u00c3\u00c5\3\2\2\2\u00c4\u00b1\3\2\2\2\u00c4"+
		"\u00b4\3\2\2\2\u00c4\u00b7\3\2\2\2\u00c4\u00ba\3\2\2\2\u00c5\62\3\2\2"+
		"\2\u00c6\u00ca\7$\2\2\u00c7\u00c9\13\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00ce\7$\2\2\u00ce\64\3\2\2\2\u00cf\u00d2\5\67\34"+
		"\2\u00d0\u00d2\59\35\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d4\b\33\2\2\u00d4\66\3\2\2\2\u00d5\u00d7\t\6\2\2\u00d6"+
		"\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d98\3\2\2\2\u00da\u00de\7%\2\2\u00db\u00dd\n\7\2\2\u00dc\u00db"+
		"\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00f3\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\61\2\2\u00e2\u00e3\7"+
		",\2\2\u00e3\u00ed\3\2\2\2\u00e4\u00ec\n\b\2\2\u00e5\u00e9\7,\2\2\u00e6"+
		"\u00e7\7^\2\2\u00e7\u00ea\7\61\2\2\u00e8\u00ea\n\t\2\2\u00e9\u00e6\3\2"+
		"\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e4\3\2\2\2\u00eb"+
		"\u00e5\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1"+
		"\u00f3\7\61\2\2\u00f2\u00da\3\2\2\2\u00f2\u00e1\3\2\2\2\u00f3:\3\2\2\2"+
		"\u00f4\u00f5\t\n\2\2\u00f5<\3\2\2\2\u00f6\u00f7\t\5\2\2\u00f7>\3\2\2\2"+
		"\u00f8\u00fa\t\13\2\2\u00f9\u00fb\t\f\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fe\5;\36\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100@\3\2\2\2"+
		"\u0101\u0103\7\60\2\2\u0102\u0104\5;\36\2\u0103\u0102\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106B\3\2\2\2\u0107"+
		"\u0108\7^\2\2\u0108\u0109\7w\2\2\u0109\u010a\3\2\2\2\u010a\u010b\5E#\2"+
		"\u010b\u010c\5E#\2\u010c\u010d\5E#\2\u010d\u010e\5E#\2\u010e\u011c\3\2"+
		"\2\2\u010f\u0110\7^\2\2\u0110\u0111\7W\2\2\u0111\u0112\3\2\2\2\u0112\u0113"+
		"\5E#\2\u0113\u0114\5E#\2\u0114\u0115\5E#\2\u0115\u0116\5E#\2\u0116\u0117"+
		"\5E#\2\u0117\u0118\5E#\2\u0118\u0119\5E#\2\u0119\u011a\5E#\2\u011a\u011c"+
		"\3\2\2\2\u011b\u0107\3\2\2\2\u011b\u010f\3\2\2\2\u011cD\3\2\2\2\u011d"+
		"\u011f\t\r\2\2\u011e\u011d\3\2\2\2\u011fF\3\2\2\2\30\2\u0099\u009f\u00a1"+
		"\u00ab\u00ae\u00b1\u00bf\u00c4\u00ca\u00d1\u00d8\u00de\u00e9\u00eb\u00ed"+
		"\u00f2\u00fa\u00ff\u0105\u011b\u011e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}