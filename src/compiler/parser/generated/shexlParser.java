// Generated from C:/Users/Willy/Documents/github/weso/shex-lite/src/compiler/grammar\shexl.g4 by ANTLR 4.8
package compiler.parser.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class shexlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ID=15, IRI=16, INT_LITERAL=17, 
		SKIP_=18;
	public static final int
		RULE_file = 0, RULE_definitions = 1, RULE_base_def = 2, RULE_start_def = 3, 
		RULE_prefix_def = 4, RULE_shape_def = 5, RULE_shape_lbl = 6, RULE_triple_expr = 7, 
		RULE_triple_constraint = 8, RULE_property = 9, RULE_node_constraint = 10, 
		RULE_cardinality = 11, RULE_prefix_ref = 12, RULE_shape_ref = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "definitions", "base_def", "start_def", "prefix_def", "shape_def", 
			"shape_lbl", "triple_expr", "triple_constraint", "property", "node_constraint", 
			"cardinality", "prefix_ref", "shape_ref"
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
			null, null, null, "ID", "IRI", "INT_LITERAL", "SKIP_"
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
	public String getGrammarFileName() { return "shexl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public shexlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(shexlParser.EOF, 0); }
		public List<DefinitionsContext> definitions() {
			return getRuleContexts(DefinitionsContext.class);
		}
		public DefinitionsContext definitions(int i) {
			return getRuleContext(DefinitionsContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				definitions();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__4))) != 0) );
			setState(33);
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

	public static class DefinitionsContext extends ParserRuleContext {
		public Base_defContext base_def() {
			return getRuleContext(Base_defContext.class,0);
		}
		public Start_defContext start_def() {
			return getRuleContext(Start_defContext.class,0);
		}
		public Prefix_defContext prefix_def() {
			return getRuleContext(Prefix_defContext.class,0);
		}
		public Shape_defContext shape_def() {
			return getRuleContext(Shape_defContext.class,0);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitDefinitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				base_def();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				start_def();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				prefix_def();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				shape_def();
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

	public static class Base_defContext extends ParserRuleContext {
		public TerminalNode IRI() { return getToken(shexlParser.IRI, 0); }
		public Base_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterBase_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitBase_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitBase_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_defContext base_def() throws RecognitionException {
		Base_defContext _localctx = new Base_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_base_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
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

	public static class Start_defContext extends ParserRuleContext {
		public Shape_refContext shape_ref() {
			return getRuleContext(Shape_refContext.class,0);
		}
		public Start_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterStart_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitStart_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitStart_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_defContext start_def() throws RecognitionException {
		Start_defContext _localctx = new Start_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_start_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__1);
			setState(45);
			match(T__2);
			setState(46);
			shape_ref();
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
		public TerminalNode IRI() { return getToken(shexlParser.IRI, 0); }
		public TerminalNode ID() { return getToken(shexlParser.ID, 0); }
		public Prefix_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterPrefix_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitPrefix_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitPrefix_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_defContext prefix_def() throws RecognitionException {
		Prefix_defContext _localctx = new Prefix_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_prefix_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__3);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(49);
				match(ID);
				}
			}

			setState(52);
			match(T__4);
			setState(53);
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
		public Shape_lblContext shape_lbl() {
			return getRuleContext(Shape_lblContext.class,0);
		}
		public Triple_exprContext triple_expr() {
			return getRuleContext(Triple_exprContext.class,0);
		}
		public Shape_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterShape_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitShape_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitShape_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_defContext shape_def() throws RecognitionException {
		Shape_defContext _localctx = new Shape_defContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_shape_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			shape_lbl();
			setState(56);
			match(T__5);
			setState(57);
			triple_expr();
			setState(58);
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

	public static class Shape_lblContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(shexlParser.ID, 0); }
		public Shape_lblContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_lbl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterShape_lbl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitShape_lbl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitShape_lbl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_lblContext shape_lbl() throws RecognitionException {
		Shape_lblContext _localctx = new Shape_lblContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_shape_lbl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__4);
			setState(61);
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

	public static class Triple_exprContext extends ParserRuleContext {
		public List<Triple_constraintContext> triple_constraint() {
			return getRuleContexts(Triple_constraintContext.class);
		}
		public Triple_constraintContext triple_constraint(int i) {
			return getRuleContext(Triple_constraintContext.class,i);
		}
		public Triple_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triple_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterTriple_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitTriple_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitTriple_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Triple_exprContext triple_expr() throws RecognitionException {
		Triple_exprContext _localctx = new Triple_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_triple_expr);
		try {
			int _alt;
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				triple_constraint();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(64);
						triple_constraint();
						setState(65);
						match(T__7);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(69); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(71);
				triple_constraint();
				}
				break;
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

	public static class Triple_constraintContext extends ParserRuleContext {
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public Node_constraintContext node_constraint() {
			return getRuleContext(Node_constraintContext.class,0);
		}
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public Triple_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triple_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterTriple_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitTriple_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitTriple_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Triple_constraintContext triple_constraint() throws RecognitionException {
		Triple_constraintContext _localctx = new Triple_constraintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_triple_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			property();
			setState(76);
			node_constraint();
			setState(77);
			cardinality();
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

	public static class PropertyContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(shexlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(shexlParser.ID, i);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(79);
				match(ID);
				}
			}

			setState(82);
			match(T__4);
			setState(83);
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

	public static class Node_constraintContext extends ParserRuleContext {
		public Prefix_refContext prefix_ref() {
			return getRuleContext(Prefix_refContext.class,0);
		}
		public Shape_refContext shape_ref() {
			return getRuleContext(Shape_refContext.class,0);
		}
		public Node_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterNode_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitNode_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitNode_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Node_constraintContext node_constraint() throws RecognitionException {
		Node_constraintContext _localctx = new Node_constraintContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_node_constraint);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				prefix_ref();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				shape_ref();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(T__8);
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

	public static class CardinalityContext extends ParserRuleContext {
		public List<TerminalNode> INT_LITERAL() { return getTokens(shexlParser.INT_LITERAL); }
		public TerminalNode INT_LITERAL(int i) {
			return getToken(shexlParser.INT_LITERAL, i);
		}
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitCardinality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cardinality);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(T__10);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				match(T__11);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				match(T__5);
				setState(94);
				match(INT_LITERAL);
				setState(95);
				match(T__6);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(96);
				match(T__5);
				setState(97);
				match(INT_LITERAL);
				setState(98);
				match(T__12);
				setState(99);
				match(INT_LITERAL);
				setState(100);
				match(T__6);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(101);
				match(T__5);
				setState(102);
				match(INT_LITERAL);
				setState(103);
				match(T__12);
				setState(104);
				match(T__6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				}
				break;
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

	public static class Prefix_refContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(shexlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(shexlParser.ID, i);
		}
		public Prefix_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterPrefix_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitPrefix_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitPrefix_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_refContext prefix_ref() throws RecognitionException {
		Prefix_refContext _localctx = new Prefix_refContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_prefix_ref);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(108);
				match(ID);
				}
			}

			setState(111);
			match(T__4);
			setState(112);
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

	public static class Shape_refContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(shexlParser.ID, 0); }
		public Shape_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).enterShape_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof shexlListener ) ((shexlListener)listener).exitShape_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof shexlVisitor ) return ((shexlVisitor<? extends T>)visitor).visitShape_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_refContext shape_ref() throws RecognitionException {
		Shape_refContext _localctx = new Shape_refContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_shape_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__13);
			setState(115);
			match(T__4);
			setState(116);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2 \n\2\r\2\16\2!\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\5\6\65\n\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\6\tF\n\t\r"+
		"\t\16\tG\3\t\3\t\5\tL\n\t\3\n\3\n\3\n\3\n\3\13\5\13S\n\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\5\f[\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\rm\n\r\3\16\5\16p\n\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\2{\2\37\3"+
		"\2\2\2\4)\3\2\2\2\6+\3\2\2\2\b.\3\2\2\2\n\62\3\2\2\2\f9\3\2\2\2\16>\3"+
		"\2\2\2\20K\3\2\2\2\22M\3\2\2\2\24R\3\2\2\2\26Z\3\2\2\2\30l\3\2\2\2\32"+
		"o\3\2\2\2\34t\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2"+
		"!\"\3\2\2\2\"#\3\2\2\2#$\7\2\2\3$\3\3\2\2\2%*\5\6\4\2&*\5\b\5\2\'*\5\n"+
		"\6\2(*\5\f\7\2)%\3\2\2\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\5\3\2\2\2+,\7"+
		"\3\2\2,-\7\22\2\2-\7\3\2\2\2./\7\4\2\2/\60\7\5\2\2\60\61\5\34\17\2\61"+
		"\t\3\2\2\2\62\64\7\6\2\2\63\65\7\21\2\2\64\63\3\2\2\2\64\65\3\2\2\2\65"+
		"\66\3\2\2\2\66\67\7\7\2\2\678\7\22\2\28\13\3\2\2\29:\5\16\b\2:;\7\b\2"+
		"\2;<\5\20\t\2<=\7\t\2\2=\r\3\2\2\2>?\7\7\2\2?@\7\21\2\2@\17\3\2\2\2AL"+
		"\5\22\n\2BC\5\22\n\2CD\7\n\2\2DF\3\2\2\2EB\3\2\2\2FG\3\2\2\2GE\3\2\2\2"+
		"GH\3\2\2\2HI\3\2\2\2IJ\5\22\n\2JL\3\2\2\2KA\3\2\2\2KE\3\2\2\2L\21\3\2"+
		"\2\2MN\5\24\13\2NO\5\26\f\2OP\5\30\r\2P\23\3\2\2\2QS\7\21\2\2RQ\3\2\2"+
		"\2RS\3\2\2\2ST\3\2\2\2TU\7\7\2\2UV\7\21\2\2V\25\3\2\2\2W[\5\32\16\2X["+
		"\5\34\17\2Y[\7\13\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\27\3\2\2\2\\m\7\f"+
		"\2\2]m\7\r\2\2^m\7\16\2\2_`\7\b\2\2`a\7\23\2\2am\7\t\2\2bc\7\b\2\2cd\7"+
		"\23\2\2de\7\17\2\2ef\7\23\2\2fm\7\t\2\2gh\7\b\2\2hi\7\23\2\2ij\7\17\2"+
		"\2jm\7\t\2\2km\3\2\2\2l\\\3\2\2\2l]\3\2\2\2l^\3\2\2\2l_\3\2\2\2lb\3\2"+
		"\2\2lg\3\2\2\2lk\3\2\2\2m\31\3\2\2\2np\7\21\2\2on\3\2\2\2op\3\2\2\2pq"+
		"\3\2\2\2qr\7\7\2\2rs\7\21\2\2s\33\3\2\2\2tu\7\20\2\2uv\7\7\2\2vw\7\21"+
		"\2\2w\35\3\2\2\2\13!)\64GKRZlo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}