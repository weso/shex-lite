// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/es/weso/shexlc/grammar\Shexl2.g4 by ANTLR 4.8
package es.weso.shexlc.syntactic.generated;
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
		T__17=18, T__18=19, T__19=20, T__20=21, LABEL=22, IRI_LITERAL=23, INT_LITERAL=24, 
		REAL_LITERAL=25, STRING_LITERAL=26, SKIP_=27;
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
			"T__17", "T__18", "T__19", "T__20", "LABEL", "IRI_LITERAL", "INT_LITERAL", 
			"REAL_LITERAL", "STRING_LITERAL", "SKIP_", "WHITE_SPACE", "COMMENT", 
			"DIGIT", "NON_ZERO_DIGIT", "EXPONENT", "FRACTION", "UCHAR", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'start'", "'='", "'prefix'", "':'", "'base'", "'*'", 
			"'+'", "'?'", "'{'", "'}'", "','", "';'", "'iri'", "'.'", "'nonliteral'", 
			"'['", "']'", "'bnode'", "'literal'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "LABEL", 
			"IRI_LITERAL", "INT_LITERAL", "REAL_LITERAL", "STRING_LITERAL", "SKIP_"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u0124\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\7\27\u009c\n\27\f\27"+
		"\16\27\u009f\13\27\3\30\3\30\3\30\7\30\u00a4\n\30\f\30\16\30\u00a7\13"+
		"\30\3\30\3\30\3\31\3\31\3\31\7\31\u00ae\n\31\f\31\16\31\u00b1\13\31\5"+
		"\31\u00b3\n\31\3\32\5\32\u00b6\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u00c2\n\32\f\32\16\32\u00c5\13\32\3\32\3\32\5\32"+
		"\u00c9\n\32\3\33\3\33\7\33\u00cd\n\33\f\33\16\33\u00d0\13\33\3\33\3\33"+
		"\3\34\3\34\5\34\u00d6\n\34\3\34\3\34\3\35\6\35\u00db\n\35\r\35\16\35\u00dc"+
		"\3\36\3\36\7\36\u00e1\n\36\f\36\16\36\u00e4\13\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u00ee\n\36\7\36\u00f0\n\36\f\36\16\36\u00f3"+
		"\13\36\3\36\3\36\5\36\u00f7\n\36\3\37\3\37\3 \3 \3!\3!\5!\u00ff\n!\3!"+
		"\6!\u0102\n!\r!\16!\u0103\3\"\3\"\6\"\u0108\n\"\r\"\16\"\u0109\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0120\n#\3$\5"+
		"$\u0123\n$\3\u00ce\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\2;\2=\2?\2A\2C\2E\2G\2\3\2\16\5\2C\\aac|\5\2\62;C\\a\u00c4"+
		"\t\2\2\"$$>@^^``bb}\177\3\2\63;\5\2\13\f\16\17\"\"\4\2\f\f\17\17\3\2,"+
		",\3\2\61\61\3\2\62;\4\2GGgg\4\2--//\5\2\62;CHch\2\u0131\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\3I\3\2\2\2\5P\3\2\2\2\7V\3\2\2"+
		"\2\tX\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17f\3\2\2\2\21h\3\2\2\2\23j\3\2\2"+
		"\2\25l\3\2\2\2\27n\3\2\2\2\31p\3\2\2\2\33r\3\2\2\2\35t\3\2\2\2\37x\3\2"+
		"\2\2!z\3\2\2\2#\u0085\3\2\2\2%\u0087\3\2\2\2\'\u0089\3\2\2\2)\u008f\3"+
		"\2\2\2+\u0097\3\2\2\2-\u0099\3\2\2\2/\u00a0\3\2\2\2\61\u00b2\3\2\2\2\63"+
		"\u00c8\3\2\2\2\65\u00ca\3\2\2\2\67\u00d5\3\2\2\29\u00da\3\2\2\2;\u00f6"+
		"\3\2\2\2=\u00f8\3\2\2\2?\u00fa\3\2\2\2A\u00fc\3\2\2\2C\u0105\3\2\2\2E"+
		"\u011f\3\2\2\2G\u0122\3\2\2\2IJ\7k\2\2JK\7o\2\2KL\7r\2\2LM\7q\2\2MN\7"+
		"t\2\2NO\7v\2\2O\4\3\2\2\2PQ\7u\2\2QR\7v\2\2RS\7c\2\2ST\7t\2\2TU\7v\2\2"+
		"U\6\3\2\2\2VW\7?\2\2W\b\3\2\2\2XY\7r\2\2YZ\7t\2\2Z[\7g\2\2[\\\7h\2\2\\"+
		"]\7k\2\2]^\7z\2\2^\n\3\2\2\2_`\7<\2\2`\f\3\2\2\2ab\7d\2\2bc\7c\2\2cd\7"+
		"u\2\2de\7g\2\2e\16\3\2\2\2fg\7,\2\2g\20\3\2\2\2hi\7-\2\2i\22\3\2\2\2j"+
		"k\7A\2\2k\24\3\2\2\2lm\7}\2\2m\26\3\2\2\2no\7\177\2\2o\30\3\2\2\2pq\7"+
		".\2\2q\32\3\2\2\2rs\7=\2\2s\34\3\2\2\2tu\7k\2\2uv\7t\2\2vw\7k\2\2w\36"+
		"\3\2\2\2xy\7\60\2\2y \3\2\2\2z{\7p\2\2{|\7q\2\2|}\7p\2\2}~\7n\2\2~\177"+
		"\7k\2\2\177\u0080\7v\2\2\u0080\u0081\7g\2\2\u0081\u0082\7t\2\2\u0082\u0083"+
		"\7c\2\2\u0083\u0084\7n\2\2\u0084\"\3\2\2\2\u0085\u0086\7]\2\2\u0086$\3"+
		"\2\2\2\u0087\u0088\7_\2\2\u0088&\3\2\2\2\u0089\u008a\7d\2\2\u008a\u008b"+
		"\7p\2\2\u008b\u008c\7q\2\2\u008c\u008d\7f\2\2\u008d\u008e\7g\2\2\u008e"+
		"(\3\2\2\2\u008f\u0090\7n\2\2\u0090\u0091\7k\2\2\u0091\u0092\7v\2\2\u0092"+
		"\u0093\7g\2\2\u0093\u0094\7t\2\2\u0094\u0095\7c\2\2\u0095\u0096\7n\2\2"+
		"\u0096*\3\2\2\2\u0097\u0098\7B\2\2\u0098,\3\2\2\2\u0099\u009d\t\2\2\2"+
		"\u009a\u009c\t\3\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e.\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a5\7>\2\2\u00a1\u00a4\n\4\2\2\u00a2\u00a4\5E#\2\u00a3\u00a1\3\2\2"+
		"\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9"+
		"\60\3\2\2\2\u00aa\u00b3\7\62\2\2\u00ab\u00af\t\5\2\2\u00ac\u00ae\5=\37"+
		"\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b2"+
		"\u00ab\3\2\2\2\u00b3\62\3\2\2\2\u00b4\u00b6\5\61\31\2\u00b5\u00b4\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00c9\5C\"\2\u00b8"+
		"\u00b9\5\61\31\2\u00b9\u00ba\7\60\2\2\u00ba\u00c9\3\2\2\2\u00bb\u00bc"+
		"\5\61\31\2\u00bc\u00bd\5A!\2\u00bd\u00c9\3\2\2\2\u00be\u00bf\5\61\31\2"+
		"\u00bf\u00c3\7\60\2\2\u00c0\u00c2\5=\37\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c7\5A!\2\u00c7\u00c9\3\2\2\2\u00c8\u00b5\3\2\2"+
		"\2\u00c8\u00b8\3\2\2\2\u00c8\u00bb\3\2\2\2\u00c8\u00be\3\2\2\2\u00c9\64"+
		"\3\2\2\2\u00ca\u00ce\7$\2\2\u00cb\u00cd\13\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7$\2\2\u00d2\66\3\2\2\2\u00d3\u00d6"+
		"\59\35\2\u00d4\u00d6\5;\36\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d8\b\34\2\2\u00d88\3\2\2\2\u00d9\u00db\t\6\2\2"+
		"\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd:\3\2\2\2\u00de\u00e2\7%\2\2\u00df\u00e1\n\7\2\2\u00e0\u00df"+
		"\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00f7\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7\61\2\2\u00e6\u00e7\7"+
		",\2\2\u00e7\u00f1\3\2\2\2\u00e8\u00f0\n\b\2\2\u00e9\u00ed\7,\2\2\u00ea"+
		"\u00eb\7^\2\2\u00eb\u00ee\7\61\2\2\u00ec\u00ee\n\t\2\2\u00ed\u00ea\3\2"+
		"\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00e8\3\2\2\2\u00ef"+
		"\u00e9\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7,\2\2\u00f5"+
		"\u00f7\7\61\2\2\u00f6\u00de\3\2\2\2\u00f6\u00e5\3\2\2\2\u00f7<\3\2\2\2"+
		"\u00f8\u00f9\t\n\2\2\u00f9>\3\2\2\2\u00fa\u00fb\t\5\2\2\u00fb@\3\2\2\2"+
		"\u00fc\u00fe\t\13\2\2\u00fd\u00ff\t\f\2\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff"+
		"\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u0102\5=\37\2\u0101\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104B\3\2\2\2"+
		"\u0105\u0107\7\60\2\2\u0106\u0108\5=\37\2\u0107\u0106\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010aD\3\2\2\2\u010b"+
		"\u010c\7^\2\2\u010c\u010d\7w\2\2\u010d\u010e\3\2\2\2\u010e\u010f\5G$\2"+
		"\u010f\u0110\5G$\2\u0110\u0111\5G$\2\u0111\u0112\5G$\2\u0112\u0120\3\2"+
		"\2\2\u0113\u0114\7^\2\2\u0114\u0115\7W\2\2\u0115\u0116\3\2\2\2\u0116\u0117"+
		"\5G$\2\u0117\u0118\5G$\2\u0118\u0119\5G$\2\u0119\u011a\5G$\2\u011a\u011b"+
		"\5G$\2\u011b\u011c\5G$\2\u011c\u011d\5G$\2\u011d\u011e\5G$\2\u011e\u0120"+
		"\3\2\2\2\u011f\u010b\3\2\2\2\u011f\u0113\3\2\2\2\u0120F\3\2\2\2\u0121"+
		"\u0123\t\r\2\2\u0122\u0121\3\2\2\2\u0123H\3\2\2\2\30\2\u009d\u00a3\u00a5"+
		"\u00af\u00b2\u00b5\u00c3\u00c8\u00ce\u00d5\u00dc\u00e2\u00ed\u00ef\u00f1"+
		"\u00f6\u00fe\u0103\u0109\u011f\u0122\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}