// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/parser\ShExLite.g4 by ANTLR 4.8
package es.weso.shexl.parser;
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
		T__9=10, T__10=11, T__11=12, INT_CONSTANT=13, REAL_CONSTANT=14, CHAR_CONSTANT=15, 
		ID=16, IRI=17, SKIP_=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
			"ID", "IRI", "SKIP_", "WHITE_SPACE", "COMMENT", "DIGIT", "NON_ZERO_DIGIT", 
			"EXPONENT", "FRACTION", "UCHAR", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PREFIX'", "':'", "'<'", "'>'", "'{'", "';'", "'}'", "'@:'", "'integer'", 
			"'string'", "'double'", "'long'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID", "IRI", 
			"SKIP_"
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
	public String getGrammarFileName() { return "ShExLite.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0105\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16l\n\16\f\16\16\16o\13\16\5\16"+
		"q\n\16\3\17\5\17t\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\7\17\u0080\n\17\f\17\16\17\u0083\13\17\3\17\3\17\5\17\u0087\n\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a0\n\20\3\21\3\21"+
		"\7\21\u00a4\n\21\f\21\16\21\u00a7\13\21\3\22\3\22\3\22\7\22\u00ac\n\22"+
		"\f\22\16\22\u00af\13\22\3\22\3\22\3\23\3\23\5\23\u00b5\n\23\3\23\3\23"+
		"\3\24\6\24\u00ba\n\24\r\24\16\24\u00bb\3\25\3\25\7\25\u00c0\n\25\f\25"+
		"\16\25\u00c3\13\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00cd"+
		"\n\25\7\25\u00cf\n\25\f\25\16\25\u00d2\13\25\3\25\3\25\5\25\u00d6\n\25"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\5\30\u00e0\n\30\3\30\6\30\u00e3"+
		"\n\30\r\30\16\30\u00e4\3\31\3\31\6\31\u00e9\n\31\r\31\16\31\u00ea\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u0101\n\32\3\33\5\33\u0104\n\33\2\2\34"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\2)\2+\2-\2/\2\61\2\63\2\65\2\3\2\16\3\2\63;\5\2C"+
		"\\aac|\6\2\62;C\\aac|\t\2\2\"$$>@^^``bb}\177\7\2\13\f\16\17\"\"GHQQ\4"+
		"\2\f\f\17\17\3\2,,\3\2\61\61\3\2\62;\4\2GGgg\4\2--//\5\2\62;CHch\2\u0115"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\3\67\3\2\2\2\5>\3\2\2\2\7@\3\2\2\2\tB\3\2\2\2\13D\3\2"+
		"\2\2\rF\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23M\3\2\2\2\25U\3\2\2\2\27\\\3"+
		"\2\2\2\31c\3\2\2\2\33p\3\2\2\2\35\u0086\3\2\2\2\37\u009f\3\2\2\2!\u00a1"+
		"\3\2\2\2#\u00a8\3\2\2\2%\u00b4\3\2\2\2\'\u00b9\3\2\2\2)\u00d5\3\2\2\2"+
		"+\u00d9\3\2\2\2-\u00db\3\2\2\2/\u00dd\3\2\2\2\61\u00e6\3\2\2\2\63\u0100"+
		"\3\2\2\2\65\u0103\3\2\2\2\678\7R\2\289\7T\2\29:\7G\2\2:;\7H\2\2;<\7K\2"+
		"\2<=\7Z\2\2=\4\3\2\2\2>?\7<\2\2?\6\3\2\2\2@A\7>\2\2A\b\3\2\2\2BC\7@\2"+
		"\2C\n\3\2\2\2DE\7}\2\2E\f\3\2\2\2FG\7=\2\2G\16\3\2\2\2HI\7\177\2\2I\20"+
		"\3\2\2\2JK\7B\2\2KL\7<\2\2L\22\3\2\2\2MN\7k\2\2NO\7p\2\2OP\7v\2\2PQ\7"+
		"g\2\2QR\7i\2\2RS\7g\2\2ST\7t\2\2T\24\3\2\2\2UV\7u\2\2VW\7v\2\2WX\7t\2"+
		"\2XY\7k\2\2YZ\7p\2\2Z[\7i\2\2[\26\3\2\2\2\\]\7f\2\2]^\7q\2\2^_\7w\2\2"+
		"_`\7d\2\2`a\7n\2\2ab\7g\2\2b\30\3\2\2\2cd\7n\2\2de\7q\2\2ef\7p\2\2fg\7"+
		"i\2\2g\32\3\2\2\2hq\7\62\2\2im\t\2\2\2jl\5+\26\2kj\3\2\2\2lo\3\2\2\2m"+
		"k\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2ph\3\2\2\2pi\3\2\2\2q\34\3\2\2"+
		"\2rt\5\33\16\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2u\u0087\5\61\31\2vw\5\33\16"+
		"\2wx\7\60\2\2x\u0087\3\2\2\2yz\5\33\16\2z{\5/\30\2{\u0087\3\2\2\2|}\5"+
		"\33\16\2}\u0081\7\60\2\2~\u0080\5+\26\2\177~\3\2\2\2\u0080\u0083\3\2\2"+
		"\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0085\5/\30\2\u0085\u0087\3\2\2\2\u0086s\3\2\2\2\u0086"+
		"v\3\2\2\2\u0086y\3\2\2\2\u0086|\3\2\2\2\u0087\36\3\2\2\2\u0088\u0089\7"+
		")\2\2\u0089\u008a\13\2\2\2\u008a\u00a0\7)\2\2\u008b\u008c\7)\2\2\u008c"+
		"\u008d\7^\2\2\u008d\u008e\5\33\16\2\u008e\u008f\5\33\16\2\u008f\u0090"+
		"\5\33\16\2\u0090\u0091\7)\2\2\u0091\u00a0\3\2\2\2\u0092\u0093\7)\2\2\u0093"+
		"\u0094\7^\2\2\u0094\u0095\7p\2\2\u0095\u0096\3\2\2\2\u0096\u00a0\7)\2"+
		"\2\u0097\u0098\7)\2\2\u0098\u0099\7^\2\2\u0099\u009a\7v\2\2\u009a\u009b"+
		"\3\2\2\2\u009b\u00a0\7)\2\2\u009c\u009d\7)\2\2\u009d\u009e\7/\2\2\u009e"+
		"\u00a0\7)\2\2\u009f\u0088\3\2\2\2\u009f\u008b\3\2\2\2\u009f\u0092\3\2"+
		"\2\2\u009f\u0097\3\2\2\2\u009f\u009c\3\2\2\2\u00a0 \3\2\2\2\u00a1\u00a5"+
		"\t\3\2\2\u00a2\u00a4\t\4\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\"\3\2\2\2\u00a7\u00a5\3\2\2\2"+
		"\u00a8\u00ad\7>\2\2\u00a9\u00ac\n\5\2\2\u00aa\u00ac\5\63\32\2\u00ab\u00a9"+
		"\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7@"+
		"\2\2\u00b1$\3\2\2\2\u00b2\u00b5\5\'\24\2\u00b3\u00b5\5)\25\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\23\2\2"+
		"\u00b7&\3\2\2\2\u00b8\u00ba\t\6\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3"+
		"\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc(\3\2\2\2\u00bd\u00c1"+
		"\7%\2\2\u00be\u00c0\n\7\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00d6\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c4\u00c5\7\61\2\2\u00c5\u00c6\7,\2\2\u00c6\u00d0\3\2\2\2\u00c7"+
		"\u00cf\n\b\2\2\u00c8\u00cc\7,\2\2\u00c9\u00ca\7^\2\2\u00ca\u00cd\7\61"+
		"\2\2\u00cb\u00cd\n\t\2\2\u00cc\u00c9\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00c8\3\2\2\2\u00cf\u00d2\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d4\7,\2\2\u00d4\u00d6\7\61\2\2\u00d5\u00bd\3\2"+
		"\2\2\u00d5\u00c4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\b\25\2\2\u00d8"+
		"*\3\2\2\2\u00d9\u00da\t\n\2\2\u00da,\3\2\2\2\u00db\u00dc\t\2\2\2\u00dc"+
		".\3\2\2\2\u00dd\u00df\t\13\2\2\u00de\u00e0\t\f\2\2\u00df\u00de\3\2\2\2"+
		"\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00e3\5+\26\2\u00e2\u00e1"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\60\3\2\2\2\u00e6\u00e8\7\60\2\2\u00e7\u00e9\5+\26\2\u00e8\u00e7\3\2\2"+
		"\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\62"+
		"\3\2\2\2\u00ec\u00ed\7^\2\2\u00ed\u00ee\7w\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\5\65\33\2\u00f0\u00f1\5\65\33\2\u00f1\u00f2\5\65\33\2\u00f2\u00f3"+
		"\5\65\33\2\u00f3\u0101\3\2\2\2\u00f4\u00f5\7^\2\2\u00f5\u00f6\7W\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f8\5\65\33\2\u00f8\u00f9\5\65\33\2\u00f9\u00fa"+
		"\5\65\33\2\u00fa\u00fb\5\65\33\2\u00fb\u00fc\5\65\33\2\u00fc\u00fd\5\65"+
		"\33\2\u00fd\u00fe\5\65\33\2\u00fe\u00ff\5\65\33\2\u00ff\u0101\3\2\2\2"+
		"\u0100\u00ec\3\2\2\2\u0100\u00f4\3\2\2\2\u0101\64\3\2\2\2\u0102\u0104"+
		"\t\r\2\2\u0103\u0102\3\2\2\2\u0104\66\3\2\2\2\30\2mps\u0081\u0086\u009f"+
		"\u00a5\u00ab\u00ad\u00b4\u00bb\u00c1\u00cc\u00ce\u00d0\u00d5\u00df\u00e4"+
		"\u00ea\u0100\u0103\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}