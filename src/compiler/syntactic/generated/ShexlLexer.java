// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/grammar\Shexl.g4 by ANTLR 4.8
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
public class ShexlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, PREFIX_KW=14, BASE_KW=15, IMPORT_KW=16, 
		START_KW=17, AND_KW=18, OR_KW=19, NOT_KW=20, IRI_KW=21, LITERAL_KW=22, 
		BNODE_KW=23, NON_LITERAL_KW=24, CLOSED_KW=25, A_KW=26, LABEL=27, ID=28, 
		IRI=29, INT_LITERAL=30, REAL_LITERAL=31, STRING_LITERAL=32, SKIP_=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "PREFIX_KW", "BASE_KW", "IMPORT_KW", 
			"START_KW", "AND_KW", "OR_KW", "NOT_KW", "IRI_KW", "LITERAL_KW", "BNODE_KW", 
			"NON_LITERAL_KW", "CLOSED_KW", "A_KW", "LABEL", "ID", "IRI", "INT_LITERAL", 
			"REAL_LITERAL", "STRING_LITERAL", "SKIP_", "WHITE_SPACE", "COMMENT", 
			"DIGIT", "NON_ZERO_DIGIT", "EXPONENT", "FRACTION", "UCHAR", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "':'", "'@'", "'{'", "'}'", "';'", "'.'", "'['", "']'", 
			"'*'", "'+'", "'?'", "','", "'PREFIX'", "'BASE'", "'IMPORT'", "'START'", 
			"'AND'", "'OR'", "'NOT'", "'IRI'", "'LITERAL'", "'BNODE'", "'NONLITERAL'", 
			"'CLOSED'", "'a'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "PREFIX_KW", "BASE_KW", "IMPORT_KW", "START_KW", "AND_KW", 
			"OR_KW", "NOT_KW", "IRI_KW", "LITERAL_KW", "BNODE_KW", "NON_LITERAL_KW", 
			"CLOSED_KW", "A_KW", "LABEL", "ID", "IRI", "INT_LITERAL", "REAL_LITERAL", 
			"STRING_LITERAL", "SKIP_"
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


	public ShexlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Shexl.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u0155\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\7\34\u00bc"+
		"\n\34\f\34\16\34\u00bf\13\34\3\35\3\35\7\35\u00c3\n\35\f\35\16\35\u00c6"+
		"\13\35\5\35\u00c8\n\35\3\35\3\35\3\35\7\35\u00cd\n\35\f\35\16\35\u00d0"+
		"\13\35\3\36\3\36\3\36\7\36\u00d5\n\36\f\36\16\36\u00d8\13\36\3\36\3\36"+
		"\3\37\3\37\3\37\7\37\u00df\n\37\f\37\16\37\u00e2\13\37\5\37\u00e4\n\37"+
		"\3 \5 \u00e7\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u00f3\n \f \16 \u00f6"+
		"\13 \3 \3 \5 \u00fa\n \3!\3!\7!\u00fe\n!\f!\16!\u0101\13!\3!\3!\3\"\3"+
		"\"\5\"\u0107\n\"\3\"\3\"\3#\6#\u010c\n#\r#\16#\u010d\3$\3$\7$\u0112\n"+
		"$\f$\16$\u0115\13$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u011f\n$\7$\u0121\n$\f$"+
		"\16$\u0124\13$\3$\3$\5$\u0128\n$\3%\3%\3&\3&\3\'\3\'\5\'\u0130\n\'\3\'"+
		"\6\'\u0133\n\'\r\'\16\'\u0134\3(\3(\6(\u0139\n(\r(\16(\u013a\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0151\n)\3*\5*"+
		"\u0154\n*\3\u00ff\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E\2G\2I\2K\2M\2O\2Q\2S\2\3\2\16\5\2C\\aa"+
		"c|\5\2\62;C\\a\u00c4\t\2\2\"$$>@^^``bb}\177\3\2\63;\5\2\13\f\16\17\"\""+
		"\4\2\f\f\17\17\3\2,,\3\2\61\61\3\2\62;\4\2GGgg\4\2--//\5\2\62;CHch\2\u0165"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3U\3\2\2\2\5W\3\2\2"+
		"\2\7Y\3\2\2\2\t[\3\2\2\2\13]\3\2\2\2\r_\3\2\2\2\17a\3\2\2\2\21c\3\2\2"+
		"\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35o\3\2"+
		"\2\2\37v\3\2\2\2!{\3\2\2\2#\u0082\3\2\2\2%\u0088\3\2\2\2\'\u008c\3\2\2"+
		"\2)\u008f\3\2\2\2+\u0093\3\2\2\2-\u0097\3\2\2\2/\u009f\3\2\2\2\61\u00a5"+
		"\3\2\2\2\63\u00b0\3\2\2\2\65\u00b7\3\2\2\2\67\u00b9\3\2\2\29\u00c7\3\2"+
		"\2\2;\u00d1\3\2\2\2=\u00e3\3\2\2\2?\u00f9\3\2\2\2A\u00fb\3\2\2\2C\u0106"+
		"\3\2\2\2E\u010b\3\2\2\2G\u0127\3\2\2\2I\u0129\3\2\2\2K\u012b\3\2\2\2M"+
		"\u012d\3\2\2\2O\u0136\3\2\2\2Q\u0150\3\2\2\2S\u0153\3\2\2\2UV\7?\2\2V"+
		"\4\3\2\2\2WX\7<\2\2X\6\3\2\2\2YZ\7B\2\2Z\b\3\2\2\2[\\\7}\2\2\\\n\3\2\2"+
		"\2]^\7\177\2\2^\f\3\2\2\2_`\7=\2\2`\16\3\2\2\2ab\7\60\2\2b\20\3\2\2\2"+
		"cd\7]\2\2d\22\3\2\2\2ef\7_\2\2f\24\3\2\2\2gh\7,\2\2h\26\3\2\2\2ij\7-\2"+
		"\2j\30\3\2\2\2kl\7A\2\2l\32\3\2\2\2mn\7.\2\2n\34\3\2\2\2op\7R\2\2pq\7"+
		"T\2\2qr\7G\2\2rs\7H\2\2st\7K\2\2tu\7Z\2\2u\36\3\2\2\2vw\7D\2\2wx\7C\2"+
		"\2xy\7U\2\2yz\7G\2\2z \3\2\2\2{|\7K\2\2|}\7O\2\2}~\7R\2\2~\177\7Q\2\2"+
		"\177\u0080\7T\2\2\u0080\u0081\7V\2\2\u0081\"\3\2\2\2\u0082\u0083\7U\2"+
		"\2\u0083\u0084\7V\2\2\u0084\u0085\7C\2\2\u0085\u0086\7T\2\2\u0086\u0087"+
		"\7V\2\2\u0087$\3\2\2\2\u0088\u0089\7C\2\2\u0089\u008a\7P\2\2\u008a\u008b"+
		"\7F\2\2\u008b&\3\2\2\2\u008c\u008d\7Q\2\2\u008d\u008e\7T\2\2\u008e(\3"+
		"\2\2\2\u008f\u0090\7P\2\2\u0090\u0091\7Q\2\2\u0091\u0092\7V\2\2\u0092"+
		"*\3\2\2\2\u0093\u0094\7K\2\2\u0094\u0095\7T\2\2\u0095\u0096\7K\2\2\u0096"+
		",\3\2\2\2\u0097\u0098\7N\2\2\u0098\u0099\7K\2\2\u0099\u009a\7V\2\2\u009a"+
		"\u009b\7G\2\2\u009b\u009c\7T\2\2\u009c\u009d\7C\2\2\u009d\u009e\7N\2\2"+
		"\u009e.\3\2\2\2\u009f\u00a0\7D\2\2\u00a0\u00a1\7P\2\2\u00a1\u00a2\7Q\2"+
		"\2\u00a2\u00a3\7F\2\2\u00a3\u00a4\7G\2\2\u00a4\60\3\2\2\2\u00a5\u00a6"+
		"\7P\2\2\u00a6\u00a7\7Q\2\2\u00a7\u00a8\7P\2\2\u00a8\u00a9\7N\2\2\u00a9"+
		"\u00aa\7K\2\2\u00aa\u00ab\7V\2\2\u00ab\u00ac\7G\2\2\u00ac\u00ad\7T\2\2"+
		"\u00ad\u00ae\7C\2\2\u00ae\u00af\7N\2\2\u00af\62\3\2\2\2\u00b0\u00b1\7"+
		"E\2\2\u00b1\u00b2\7N\2\2\u00b2\u00b3\7Q\2\2\u00b3\u00b4\7U\2\2\u00b4\u00b5"+
		"\7G\2\2\u00b5\u00b6\7F\2\2\u00b6\64\3\2\2\2\u00b7\u00b8\7c\2\2\u00b8\66"+
		"\3\2\2\2\u00b9\u00bd\t\2\2\2\u00ba\u00bc\t\3\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be8\3\2\2\2"+
		"\u00bf\u00bd\3\2\2\2\u00c0\u00c4\t\2\2\2\u00c1\u00c3\t\3\2\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c0\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7<\2\2\u00ca\u00ce\t\2\2\2\u00cb"+
		"\u00cd\t\3\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf:\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d6"+
		"\7>\2\2\u00d2\u00d5\n\4\2\2\u00d3\u00d5\5Q)\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7@\2\2\u00da"+
		"<\3\2\2\2\u00db\u00e4\7\62\2\2\u00dc\u00e0\t\5\2\2\u00dd\u00df\5I%\2\u00de"+
		"\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3"+
		"\u00dc\3\2\2\2\u00e4>\3\2\2\2\u00e5\u00e7\5=\37\2\u00e6\u00e5\3\2\2\2"+
		"\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00fa\5O(\2\u00e9\u00ea"+
		"\5=\37\2\u00ea\u00eb\7\60\2\2\u00eb\u00fa\3\2\2\2\u00ec\u00ed\5=\37\2"+
		"\u00ed\u00ee\5M\'\2\u00ee\u00fa\3\2\2\2\u00ef\u00f0\5=\37\2\u00f0\u00f4"+
		"\7\60\2\2\u00f1\u00f3\5I%\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f7\u00f8\5M\'\2\u00f8\u00fa\3\2\2\2\u00f9\u00e6\3\2\2\2\u00f9"+
		"\u00e9\3\2\2\2\u00f9\u00ec\3\2\2\2\u00f9\u00ef\3\2\2\2\u00fa@\3\2\2\2"+
		"\u00fb\u00ff\7$\2\2\u00fc\u00fe\13\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0101"+
		"\3\2\2\2\u00ff\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0103\7$\2\2\u0103B\3\2\2\2\u0104\u0107\5E#\2\u0105"+
		"\u0107\5G$\2\u0106\u0104\3\2\2\2\u0106\u0105\3\2\2\2\u0107\u0108\3\2\2"+
		"\2\u0108\u0109\b\"\2\2\u0109D\3\2\2\2\u010a\u010c\t\6\2\2\u010b\u010a"+
		"\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"F\3\2\2\2\u010f\u0113\7%\2\2\u0110\u0112\n\7\2\2\u0111\u0110\3\2\2\2\u0112"+
		"\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0128\3\2"+
		"\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7\61\2\2\u0117\u0118\7,\2\2\u0118"+
		"\u0122\3\2\2\2\u0119\u0121\n\b\2\2\u011a\u011e\7,\2\2\u011b\u011c\7^\2"+
		"\2\u011c\u011f\7\61\2\2\u011d\u011f\n\t\2\2\u011e\u011b\3\2\2\2\u011e"+
		"\u011d\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u0119\3\2\2\2\u0120\u011a\3\2"+
		"\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7,\2\2\u0126\u0128\7\61"+
		"\2\2\u0127\u010f\3\2\2\2\u0127\u0116\3\2\2\2\u0128H\3\2\2\2\u0129\u012a"+
		"\t\n\2\2\u012aJ\3\2\2\2\u012b\u012c\t\5\2\2\u012cL\3\2\2\2\u012d\u012f"+
		"\t\13\2\2\u012e\u0130\t\f\2\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2"+
		"\u0130\u0132\3\2\2\2\u0131\u0133\5I%\2\u0132\u0131\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135N\3\2\2\2\u0136"+
		"\u0138\7\60\2\2\u0137\u0139\5I%\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013bP\3\2\2\2\u013c\u013d"+
		"\7^\2\2\u013d\u013e\7w\2\2\u013e\u013f\3\2\2\2\u013f\u0140\5S*\2\u0140"+
		"\u0141\5S*\2\u0141\u0142\5S*\2\u0142\u0143\5S*\2\u0143\u0151\3\2\2\2\u0144"+
		"\u0145\7^\2\2\u0145\u0146\7W\2\2\u0146\u0147\3\2\2\2\u0147\u0148\5S*\2"+
		"\u0148\u0149\5S*\2\u0149\u014a\5S*\2\u014a\u014b\5S*\2\u014b\u014c\5S"+
		"*\2\u014c\u014d\5S*\2\u014d\u014e\5S*\2\u014e\u014f\5S*\2\u014f\u0151"+
		"\3\2\2\2\u0150\u013c\3\2\2\2\u0150\u0144\3\2\2\2\u0151R\3\2\2\2\u0152"+
		"\u0154\t\r\2\2\u0153\u0152\3\2\2\2\u0154T\3\2\2\2\33\2\u00bd\u00c4\u00c7"+
		"\u00ce\u00d4\u00d6\u00e0\u00e3\u00e6\u00f4\u00f9\u00ff\u0106\u010d\u0113"+
		"\u011e\u0120\u0122\u0127\u012f\u0134\u013a\u0150\u0153\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}