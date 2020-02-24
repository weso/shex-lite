// Generated from C:/Users/Willy/Documents/github/weso/shex-lite/src/compiler/grammar\shexl.g4 by ANTLR 4.8
package compiler.parser.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class shexlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ID=15, IRI=16, SKIP_=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "ID", "IRI", "SKIP_", "WHITE_SPACE", 
			"COMMENT", "DIGIT", "NON_ZERO_DIGIT", "UCHAR", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'base'", "'start'", "'='", "'prefix'", "':'", "'{'", "'}'", "';'", 
			"'.'", "'*'", "'+'", "'?'", "','", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "IRI", "SKIP_"
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


	public shexlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "shexl.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u00ae\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20\\\n\20\f\20\16\20_\13\20\3\21\3"+
		"\21\3\21\7\21d\n\21\f\21\16\21g\13\21\3\21\3\21\3\22\3\22\5\22m\n\22\3"+
		"\22\3\22\3\23\6\23r\n\23\r\23\16\23s\3\24\3\24\7\24x\n\24\f\24\16\24{"+
		"\13\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0085\n\24\7\24\u0087"+
		"\n\24\f\24\16\24\u008a\13\24\3\24\3\24\5\24\u008e\n\24\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00aa\n\27\3\30\5\30"+
		"\u00ad\n\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\2\'\2)\2+\2-\2/\2\3\2\f\5\2C\\aac|\6"+
		"\2\62;C\\aac|\t\2\2\"$$>@^^``bb}\177\7\2\13\f\16\17\"\"GHQQ\4\2\f\f\17"+
		"\17\3\2,,\3\2\61\61\3\2\62;\3\2\63;\5\2\62;CHch\2\u00b2\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3\61\3\2\2"+
		"\2\5\66\3\2\2\2\7<\3\2\2\2\t>\3\2\2\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2"+
		"\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33U\3\2"+
		"\2\2\35W\3\2\2\2\37Y\3\2\2\2!`\3\2\2\2#l\3\2\2\2%q\3\2\2\2\'\u008d\3\2"+
		"\2\2)\u0091\3\2\2\2+\u0093\3\2\2\2-\u00a9\3\2\2\2/\u00ac\3\2\2\2\61\62"+
		"\7d\2\2\62\63\7c\2\2\63\64\7u\2\2\64\65\7g\2\2\65\4\3\2\2\2\66\67\7u\2"+
		"\2\678\7v\2\289\7c\2\29:\7t\2\2:;\7v\2\2;\6\3\2\2\2<=\7?\2\2=\b\3\2\2"+
		"\2>?\7r\2\2?@\7t\2\2@A\7g\2\2AB\7h\2\2BC\7k\2\2CD\7z\2\2D\n\3\2\2\2EF"+
		"\7<\2\2F\f\3\2\2\2GH\7}\2\2H\16\3\2\2\2IJ\7\177\2\2J\20\3\2\2\2KL\7=\2"+
		"\2L\22\3\2\2\2MN\7\60\2\2N\24\3\2\2\2OP\7,\2\2P\26\3\2\2\2QR\7-\2\2R\30"+
		"\3\2\2\2ST\7A\2\2T\32\3\2\2\2UV\7.\2\2V\34\3\2\2\2WX\7B\2\2X\36\3\2\2"+
		"\2Y]\t\2\2\2Z\\\t\3\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^ \3\2"+
		"\2\2_]\3\2\2\2`e\7>\2\2ad\n\4\2\2bd\5-\27\2ca\3\2\2\2cb\3\2\2\2dg\3\2"+
		"\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7@\2\2i\"\3\2\2\2jm\5%"+
		"\23\2km\5\'\24\2lj\3\2\2\2lk\3\2\2\2mn\3\2\2\2no\b\22\2\2o$\3\2\2\2pr"+
		"\t\5\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2t&\3\2\2\2uy\7%\2\2vx"+
		"\n\6\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\u008e\3\2\2\2{y\3\2"+
		"\2\2|}\7\61\2\2}~\7,\2\2~\u0088\3\2\2\2\177\u0087\n\7\2\2\u0080\u0084"+
		"\7,\2\2\u0081\u0082\7^\2\2\u0082\u0085\7\61\2\2\u0083\u0085\n\b\2\2\u0084"+
		"\u0081\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0087\3\2\2\2\u0086\177\3\2\2"+
		"\2\u0086\u0080\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7,\2\2\u008c"+
		"\u008e\7\61\2\2\u008du\3\2\2\2\u008d|\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0090\b\24\2\2\u0090(\3\2\2\2\u0091\u0092\t\t\2\2\u0092*\3\2\2\2\u0093"+
		"\u0094\t\n\2\2\u0094,\3\2\2\2\u0095\u0096\7^\2\2\u0096\u0097\7w\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\5/\30\2\u0099\u009a\5/\30\2\u009a\u009b\5/"+
		"\30\2\u009b\u009c\5/\30\2\u009c\u00aa\3\2\2\2\u009d\u009e\7^\2\2\u009e"+
		"\u009f\7W\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\5/\30\2\u00a1\u00a2\5/\30"+
		"\2\u00a2\u00a3\5/\30\2\u00a3\u00a4\5/\30\2\u00a4\u00a5\5/\30\2\u00a5\u00a6"+
		"\5/\30\2\u00a6\u00a7\5/\30\2\u00a7\u00a8\5/\30\2\u00a8\u00aa\3\2\2\2\u00a9"+
		"\u0095\3\2\2\2\u00a9\u009d\3\2\2\2\u00aa.\3\2\2\2\u00ab\u00ad\t\13\2\2"+
		"\u00ac\u00ab\3\2\2\2\u00ad\60\3\2\2\2\17\2]celsy\u0084\u0086\u0088\u008d"+
		"\u00a9\u00ac\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}