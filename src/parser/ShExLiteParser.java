// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/parser\ShExLite.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShExLiteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, SKIP_=3, IRI=4, SCHEMA_ID=5, P=6, R=7, E=8, F=9, I=10, 
		X=11;
	public static final int
		RULE_shex_lite_doc = 0, RULE_prefix_def = 1, RULE_shape_def = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"shex_lite_doc", "prefix_def", "shape_def"
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
			null, null, null, "SKIP_", "IRI", "SCHEMA_ID", "P", "R", "E", "F", "I", 
			"X"
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

	@Override
	public String getGrammarFileName() { return "ShExLite.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShExLiteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Shex_lite_docContext extends ParserRuleContext {
		public List<Prefix_defContext> prefix_def() {
			return getRuleContexts(Prefix_defContext.class);
		}
		public Prefix_defContext prefix_def(int i) {
			return getRuleContext(Prefix_defContext.class,i);
		}
		public List<Shape_defContext> shape_def() {
			return getRuleContexts(Shape_defContext.class);
		}
		public Shape_defContext shape_def(int i) {
			return getRuleContext(Shape_defContext.class,i);
		}
		public Shex_lite_docContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shex_lite_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterShex_lite_doc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitShex_lite_doc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitShex_lite_doc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shex_lite_docContext shex_lite_doc() throws RecognitionException {
		Shex_lite_docContext _localctx = new Shex_lite_docContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_shex_lite_doc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6);
				prefix_def();
				}
				}
				setState(9); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==P );
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(11);
				shape_def();
				}
				}
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Prefix_defContext extends ParserRuleContext {
		public TerminalNode P() { return getToken(ShExLiteParser.P, 0); }
		public TerminalNode R() { return getToken(ShExLiteParser.R, 0); }
		public TerminalNode E() { return getToken(ShExLiteParser.E, 0); }
		public TerminalNode F() { return getToken(ShExLiteParser.F, 0); }
		public TerminalNode I() { return getToken(ShExLiteParser.I, 0); }
		public TerminalNode X() { return getToken(ShExLiteParser.X, 0); }
		public TerminalNode IRI() { return getToken(ShExLiteParser.IRI, 0); }
		public TerminalNode SCHEMA_ID() { return getToken(ShExLiteParser.SCHEMA_ID, 0); }
		public Prefix_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterPrefix_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitPrefix_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitPrefix_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_defContext prefix_def() throws RecognitionException {
		Prefix_defContext _localctx = new Prefix_defContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prefix_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(P);
			setState(17);
			match(R);
			setState(18);
			match(E);
			setState(19);
			match(F);
			setState(20);
			match(I);
			setState(21);
			match(X);
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCHEMA_ID) {
				{
				setState(22);
				match(SCHEMA_ID);
				}
			}

			setState(25);
			match(T__0);
			setState(26);
			match(IRI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shape_defContext extends ParserRuleContext {
		public TerminalNode SCHEMA_ID() { return getToken(ShExLiteParser.SCHEMA_ID, 0); }
		public Shape_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterShape_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitShape_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitShape_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_defContext shape_def() throws RecognitionException {
		Shape_defContext _localctx = new Shape_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_shape_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			match(SCHEMA_ID);
			setState(30);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r#\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\6\2\n\n\2\r\2\16\2\13\3\2\6\2\17\n\2\r\2\16\2\20\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\2\2"+
		"\5\2\4\6\2\2\2\"\2\t\3\2\2\2\4\22\3\2\2\2\6\36\3\2\2\2\b\n\5\4\3\2\t\b"+
		"\3\2\2\2\n\13\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\16\3\2\2\2\r\17\5\6"+
		"\4\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\3\3\2\2"+
		"\2\22\23\7\b\2\2\23\24\7\t\2\2\24\25\7\n\2\2\25\26\7\13\2\2\26\27\7\f"+
		"\2\2\27\31\7\r\2\2\30\32\7\7\2\2\31\30\3\2\2\2\31\32\3\2\2\2\32\33\3\2"+
		"\2\2\33\34\7\3\2\2\34\35\7\6\2\2\35\5\3\2\2\2\36\37\7\3\2\2\37 \7\7\2"+
		"\2 !\7\4\2\2!\7\3\2\2\2\5\13\20\31";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}