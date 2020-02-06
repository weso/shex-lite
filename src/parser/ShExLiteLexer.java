// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/parser\ShExLite.g4 by ANTLR 4.8
package parser;
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
		T__0=1, T__1=2, SKIP_=3, IRI=4, SCHEMA_ID=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "SKIP_", "IRI", "SCHEMA_ID", "WHITE_SPACE", "A", "B", 
			"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'{}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SKIP_", "IRI", "SCHEMA_ID"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7\u0096\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5P\n\5\f\5\16\5"+
		"S\13\5\3\5\3\5\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\7\6\7_\n\7\r\7\16\7"+
		"`\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21"+
		"\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63"+
		"\2\65\2\67\29\2;\2=\2?\2A\2\3\2\37\5\2C\\aac|\6\2\62;C\\aac|\7\2\13\f"+
		"\16\17\"\"GHQQ\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIi"+
		"i\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2"+
		"RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4"+
		"\2[[{{\4\2\\\\||\2}\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7H\3\2\2\2\tL\3\2\2\2\13V\3\2\2\2\r"+
		"^\3\2\2\2\17b\3\2\2\2\21d\3\2\2\2\23f\3\2\2\2\25h\3\2\2\2\27j\3\2\2\2"+
		"\31l\3\2\2\2\33n\3\2\2\2\35p\3\2\2\2\37r\3\2\2\2!t\3\2\2\2#v\3\2\2\2%"+
		"x\3\2\2\2\'z\3\2\2\2)|\3\2\2\2+~\3\2\2\2-\u0080\3\2\2\2/\u0082\3\2\2\2"+
		"\61\u0084\3\2\2\2\63\u0086\3\2\2\2\65\u0088\3\2\2\2\67\u008a\3\2\2\29"+
		"\u008c\3\2\2\2;\u008e\3\2\2\2=\u0090\3\2\2\2?\u0092\3\2\2\2A\u0094\3\2"+
		"\2\2CD\7<\2\2D\4\3\2\2\2EF\7}\2\2FG\7\177\2\2G\6\3\2\2\2HI\5\r\7\2IJ\3"+
		"\2\2\2JK\b\4\2\2K\b\3\2\2\2LM\7>\2\2MQ\t\2\2\2NP\t\3\2\2ON\3\2\2\2PS\3"+
		"\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7@\2\2U\n\3\2\2\2VZ\t"+
		"\2\2\2WY\t\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\f\3\2\2\2\\"+
		"Z\3\2\2\2]_\t\4\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\16\3\2\2"+
		"\2bc\t\5\2\2c\20\3\2\2\2de\t\6\2\2e\22\3\2\2\2fg\t\7\2\2g\24\3\2\2\2h"+
		"i\t\b\2\2i\26\3\2\2\2jk\t\t\2\2k\30\3\2\2\2lm\t\n\2\2m\32\3\2\2\2no\t"+
		"\13\2\2o\34\3\2\2\2pq\t\f\2\2q\36\3\2\2\2rs\t\r\2\2s \3\2\2\2tu\t\16\2"+
		"\2u\"\3\2\2\2vw\t\17\2\2w$\3\2\2\2xy\t\20\2\2y&\3\2\2\2z{\t\21\2\2{(\3"+
		"\2\2\2|}\t\22\2\2}*\3\2\2\2~\177\t\23\2\2\177,\3\2\2\2\u0080\u0081\t\24"+
		"\2\2\u0081.\3\2\2\2\u0082\u0083\t\25\2\2\u0083\60\3\2\2\2\u0084\u0085"+
		"\t\26\2\2\u0085\62\3\2\2\2\u0086\u0087\t\27\2\2\u0087\64\3\2\2\2\u0088"+
		"\u0089\t\30\2\2\u0089\66\3\2\2\2\u008a\u008b\t\31\2\2\u008b8\3\2\2\2\u008c"+
		"\u008d\t\32\2\2\u008d:\3\2\2\2\u008e\u008f\t\33\2\2\u008f<\3\2\2\2\u0090"+
		"\u0091\t\34\2\2\u0091>\3\2\2\2\u0092\u0093\t\35\2\2\u0093@\3\2\2\2\u0094"+
		"\u0095\t\36\2\2\u0095B\3\2\2\2\6\2QZ`\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}