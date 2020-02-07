// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/parser\ShExLite.g4 by ANTLR 4.8
package es.weso.shexl.parser;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, INT_CONSTANT=13, REAL_CONSTANT=14, CHAR_CONSTANT=15, 
		ID=16, IRI=17, SKIP_=18;
	public static final int
		RULE_shex_lite_doc = 0, RULE_prefix_def = 1, RULE_shape_def = 2, RULE_shape_body = 3, 
		RULE_constraint_def = 4, RULE_contraint_id = 5, RULE_constraint_type = 6, 
		RULE_property_def = 7, RULE_shape_inv = 8, RULE_prefix_inv = 9, RULE_primitive_type = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"shex_lite_doc", "prefix_def", "shape_def", "shape_body", "constraint_def", 
			"contraint_id", "constraint_type", "property_def", "shape_inv", "prefix_inv", 
			"primitive_type"
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
		public TerminalNode EOF() { return getToken(ShExLiteParser.EOF, 0); }
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
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				prefix_def();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				shape_def();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(32);
			match(EOF);
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
		public TerminalNode IRI() { return getToken(ShExLiteParser.IRI, 0); }
		public TerminalNode ID() { return getToken(ShExLiteParser.ID, 0); }
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
			setState(34);
			match(T__0);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(35);
				match(ID);
				}
			}

			setState(38);
			match(T__1);
			setState(39);
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
		public TerminalNode ID() { return getToken(ShExLiteParser.ID, 0); }
		public Shape_bodyContext shape_body() {
			return getRuleContext(Shape_bodyContext.class,0);
		}
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
			setState(41);
			match(T__2);
			setState(42);
			match(ID);
			setState(43);
			match(T__3);
			setState(44);
			shape_body();
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

	public static class Shape_bodyContext extends ParserRuleContext {
		public List<Constraint_defContext> constraint_def() {
			return getRuleContexts(Constraint_defContext.class);
		}
		public Constraint_defContext constraint_def(int i) {
			return getRuleContext(Constraint_defContext.class,i);
		}
		public Shape_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterShape_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitShape_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitShape_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_bodyContext shape_body() throws RecognitionException {
		Shape_bodyContext _localctx = new Shape_bodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_shape_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__4);
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(47);
				constraint_def();
				}
				break;
			case 2:
				{
				setState(51); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(48);
						constraint_def();
						setState(49);
						match(T__5);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(53); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(55);
				constraint_def();
				}
				break;
			}
			setState(59);
			match(T__6);
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

	public static class Constraint_defContext extends ParserRuleContext {
		public Contraint_idContext contraint_id() {
			return getRuleContext(Contraint_idContext.class,0);
		}
		public Constraint_typeContext constraint_type() {
			return getRuleContext(Constraint_typeContext.class,0);
		}
		public Constraint_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterConstraint_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitConstraint_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitConstraint_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_defContext constraint_def() throws RecognitionException {
		Constraint_defContext _localctx = new Constraint_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constraint_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			contraint_id();
			setState(62);
			constraint_type();
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

	public static class Contraint_idContext extends ParserRuleContext {
		public Prefix_invContext prefix_inv() {
			return getRuleContext(Prefix_invContext.class,0);
		}
		public Property_defContext property_def() {
			return getRuleContext(Property_defContext.class,0);
		}
		public Contraint_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contraint_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterContraint_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitContraint_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitContraint_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Contraint_idContext contraint_id() throws RecognitionException {
		Contraint_idContext _localctx = new Contraint_idContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_contraint_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			prefix_inv();
			setState(65);
			match(T__1);
			setState(66);
			property_def();
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

	public static class Constraint_typeContext extends ParserRuleContext {
		public Shape_invContext shape_inv() {
			return getRuleContext(Shape_invContext.class,0);
		}
		public Prefix_invContext prefix_inv() {
			return getRuleContext(Prefix_invContext.class,0);
		}
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public Constraint_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterConstraint_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitConstraint_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitConstraint_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_typeContext constraint_type() throws RecognitionException {
		Constraint_typeContext _localctx = new Constraint_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constraint_type);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(T__7);
				setState(69);
				shape_inv();
				}
				break;
			case T__1:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				prefix_inv();
				setState(71);
				match(T__1);
				setState(72);
				primitive_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Property_defContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShExLiteParser.ID, 0); }
		public Property_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterProperty_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitProperty_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitProperty_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Property_defContext property_def() throws RecognitionException {
		Property_defContext _localctx = new Property_defContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_property_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ID);
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

	public static class Shape_invContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShExLiteParser.ID, 0); }
		public Shape_invContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_inv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterShape_inv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitShape_inv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitShape_inv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_invContext shape_inv() throws RecognitionException {
		Shape_invContext _localctx = new Shape_invContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_shape_inv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(ID);
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

	public static class Prefix_invContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShExLiteParser.ID, 0); }
		public Prefix_invContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_inv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterPrefix_inv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitPrefix_inv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitPrefix_inv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_invContext prefix_inv() throws RecognitionException {
		Prefix_invContext _localctx = new Prefix_invContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_prefix_inv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(80);
				match(ID);
				}
			}

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

	public static class Primitive_typeContext extends ParserRuleContext {
		public Primitive_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).enterPrimitive_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLiteListener ) ((ShExLiteListener)listener).exitPrimitive_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLiteVisitor ) return ((ShExLiteVisitor<? extends T>)visitor).visitPrimitive_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_typeContext primitive_type() throws RecognitionException {
		Primitive_typeContext _localctx = new Primitive_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primitive_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\2\6\2\37\n\2\r\2\16\2 \3\2\3\2\3\3"+
		"\3\3\5\3\'\n\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\6\5"+
		"\66\n\5\r\5\16\5\67\3\5\3\5\5\5<\n\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bM\n\b\3\t\3\t\3\n\3\n\3\13\5\13T\n\13\3"+
		"\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\3\3\2\13\16\2S\2\31\3\2"+
		"\2\2\4$\3\2\2\2\6+\3\2\2\2\b\60\3\2\2\2\n?\3\2\2\2\fB\3\2\2\2\16L\3\2"+
		"\2\2\20N\3\2\2\2\22P\3\2\2\2\24S\3\2\2\2\26U\3\2\2\2\30\32\5\4\3\2\31"+
		"\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35"+
		"\37\5\6\4\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2"+
		"\"#\7\2\2\3#\3\3\2\2\2$&\7\3\2\2%\'\7\22\2\2&%\3\2\2\2&\'\3\2\2\2\'(\3"+
		"\2\2\2()\7\4\2\2)*\7\23\2\2*\5\3\2\2\2+,\7\5\2\2,-\7\22\2\2-.\7\6\2\2"+
		"./\5\b\5\2/\7\3\2\2\2\60;\7\7\2\2\61<\5\n\6\2\62\63\5\n\6\2\63\64\7\b"+
		"\2\2\64\66\3\2\2\2\65\62\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2"+
		"\289\3\2\2\29:\5\n\6\2:<\3\2\2\2;\61\3\2\2\2;\65\3\2\2\2<=\3\2\2\2=>\7"+
		"\t\2\2>\t\3\2\2\2?@\5\f\7\2@A\5\16\b\2A\13\3\2\2\2BC\5\24\13\2CD\7\4\2"+
		"\2DE\5\20\t\2E\r\3\2\2\2FG\7\n\2\2GM\5\22\n\2HI\5\24\13\2IJ\7\4\2\2JK"+
		"\5\26\f\2KM\3\2\2\2LF\3\2\2\2LH\3\2\2\2M\17\3\2\2\2NO\7\22\2\2O\21\3\2"+
		"\2\2PQ\7\22\2\2Q\23\3\2\2\2RT\7\22\2\2SR\3\2\2\2ST\3\2\2\2T\25\3\2\2\2"+
		"UV\t\2\2\2V\27\3\2\2\2\t\33 &\67;LS";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}