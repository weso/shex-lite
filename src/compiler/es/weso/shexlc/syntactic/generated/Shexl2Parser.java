// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/es/weso/shexlc/grammar\Shexl2.g4 by ANTLR 4.8
package es.weso.shexlc.syntactic.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Shexl2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, LABEL=22, IRI_LITERAL=23, INT_LITERAL=24, 
		REAL_LITERAL=25, STRING_LITERAL=26, SKIP_=27;
	public static final int
		RULE_schema = 0, RULE_statement = 1, RULE_import_stmt = 2, RULE_definition_stmt = 3, 
		RULE_start_def_stmt = 4, RULE_prefix_def_stmt = 5, RULE_base_def_stmt = 6, 
		RULE_shape_def_stmt = 7, RULE_expression = 8, RULE_literal_expr = 9, RULE_literal_real_value_expr = 10, 
		RULE_literal_string_value_expr = 11, RULE_literal_iri_value_expr = 12, 
		RULE_cardinality_expr = 13, RULE_constraint_expr = 14, RULE_constraint_node_expr = 15, 
		RULE_constraint_block_triple_expr = 16, RULE_constraint_triple_expr = 17, 
		RULE_constraint_node_iri_expr = 18, RULE_constraint_valid_value_set_type = 19, 
		RULE_constraint_node_any_type_expr = 20, RULE_constraint_node_non_literal_expr = 21, 
		RULE_constraint_value_set_expr = 22, RULE_constraint_node_bnode_expr = 23, 
		RULE_constraint_node_literal_expr = 24, RULE_call_expr = 25, RULE_call_prefix_expr = 26, 
		RULE_call_shape_expr = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"schema", "statement", "import_stmt", "definition_stmt", "start_def_stmt", 
			"prefix_def_stmt", "base_def_stmt", "shape_def_stmt", "expression", "literal_expr", 
			"literal_real_value_expr", "literal_string_value_expr", "literal_iri_value_expr", 
			"cardinality_expr", "constraint_expr", "constraint_node_expr", "constraint_block_triple_expr", 
			"constraint_triple_expr", "constraint_node_iri_expr", "constraint_valid_value_set_type", 
			"constraint_node_any_type_expr", "constraint_node_non_literal_expr", 
			"constraint_value_set_expr", "constraint_node_bnode_expr", "constraint_node_literal_expr", 
			"call_expr", "call_prefix_expr", "call_shape_expr"
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

	@Override
	public String getGrammarFileName() { return "Shexl2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Shexl2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SchemaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Shexl2Parser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SchemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterSchema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitSchema(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitSchema(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaContext schema() throws RecognitionException {
		SchemaContext _localctx = new SchemaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_schema);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				statement();
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << LABEL) | (1L << IRI_LITERAL))) != 0) );
			setState(61);
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

	public static class StatementContext extends ParserRuleContext {
		public Import_stmtContext import_stmt() {
			return getRuleContext(Import_stmtContext.class,0);
		}
		public Definition_stmtContext definition_stmt() {
			return getRuleContext(Definition_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				import_stmt();
				}
				break;
			case T__1:
			case T__3:
			case T__4:
			case T__5:
			case LABEL:
			case IRI_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				definition_stmt();
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

	public static class Import_stmtContext extends ParserRuleContext {
		public Literal_iri_value_exprContext iri;
		public Literal_iri_value_exprContext literal_iri_value_expr() {
			return getRuleContext(Literal_iri_value_exprContext.class,0);
		}
		public Import_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterImport_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitImport_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitImport_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_stmtContext import_stmt() throws RecognitionException {
		Import_stmtContext _localctx = new Import_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_import_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__0);
			setState(68);
			((Import_stmtContext)_localctx).iri = literal_iri_value_expr();
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

	public static class Definition_stmtContext extends ParserRuleContext {
		public Start_def_stmtContext start_def_stmt() {
			return getRuleContext(Start_def_stmtContext.class,0);
		}
		public Prefix_def_stmtContext prefix_def_stmt() {
			return getRuleContext(Prefix_def_stmtContext.class,0);
		}
		public Base_def_stmtContext base_def_stmt() {
			return getRuleContext(Base_def_stmtContext.class,0);
		}
		public Shape_def_stmtContext shape_def_stmt() {
			return getRuleContext(Shape_def_stmtContext.class,0);
		}
		public Definition_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterDefinition_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitDefinition_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitDefinition_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Definition_stmtContext definition_stmt() throws RecognitionException {
		Definition_stmtContext _localctx = new Definition_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definition_stmt);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				start_def_stmt();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				prefix_def_stmt();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				base_def_stmt();
				}
				break;
			case T__4:
			case LABEL:
			case IRI_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				shape_def_stmt();
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

	public static class Start_def_stmtContext extends ParserRuleContext {
		public Call_shape_exprContext shape;
		public Call_shape_exprContext call_shape_expr() {
			return getRuleContext(Call_shape_exprContext.class,0);
		}
		public Start_def_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_def_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterStart_def_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitStart_def_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitStart_def_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_def_stmtContext start_def_stmt() throws RecognitionException {
		Start_def_stmtContext _localctx = new Start_def_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_start_def_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__1);
			setState(77);
			match(T__2);
			setState(78);
			((Start_def_stmtContext)_localctx).shape = call_shape_expr();
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

	public static class Prefix_def_stmtContext extends ParserRuleContext {
		public Literal_iri_value_exprContext iri;
		public Literal_iri_value_exprContext literal_iri_value_expr() {
			return getRuleContext(Literal_iri_value_exprContext.class,0);
		}
		public TerminalNode LABEL() { return getToken(Shexl2Parser.LABEL, 0); }
		public Prefix_def_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_def_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterPrefix_def_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitPrefix_def_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitPrefix_def_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_def_stmtContext prefix_def_stmt() throws RecognitionException {
		Prefix_def_stmtContext _localctx = new Prefix_def_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_prefix_def_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__3);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				setState(81);
				match(LABEL);
				}
			}

			setState(84);
			match(T__4);
			setState(85);
			((Prefix_def_stmtContext)_localctx).iri = literal_iri_value_expr();
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

	public static class Base_def_stmtContext extends ParserRuleContext {
		public Literal_iri_value_exprContext iri;
		public Literal_iri_value_exprContext literal_iri_value_expr() {
			return getRuleContext(Literal_iri_value_exprContext.class,0);
		}
		public Base_def_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_def_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterBase_def_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitBase_def_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitBase_def_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_def_stmtContext base_def_stmt() throws RecognitionException {
		Base_def_stmtContext _localctx = new Base_def_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_base_def_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__5);
			setState(88);
			((Base_def_stmtContext)_localctx).iri = literal_iri_value_expr();
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

	public static class Shape_def_stmtContext extends ParserRuleContext {
		public Call_prefix_exprContext label;
		public Constraint_exprContext expr;
		public Call_prefix_exprContext call_prefix_expr() {
			return getRuleContext(Call_prefix_exprContext.class,0);
		}
		public Constraint_exprContext constraint_expr() {
			return getRuleContext(Constraint_exprContext.class,0);
		}
		public Shape_def_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_def_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterShape_def_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitShape_def_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitShape_def_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_def_stmtContext shape_def_stmt() throws RecognitionException {
		Shape_def_stmtContext _localctx = new Shape_def_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_shape_def_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((Shape_def_stmtContext)_localctx).label = call_prefix_expr();
			setState(91);
			((Shape_def_stmtContext)_localctx).expr = constraint_expr();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Literal_exprContext literal_expr() {
			return getRuleContext(Literal_exprContext.class,0);
		}
		public Cardinality_exprContext cardinality_expr() {
			return getRuleContext(Cardinality_exprContext.class,0);
		}
		public Constraint_exprContext constraint_expr() {
			return getRuleContext(Constraint_exprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				literal_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				cardinality_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				constraint_expr();
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

	public static class Literal_exprContext extends ParserRuleContext {
		public Literal_real_value_exprContext literal_real_value_expr() {
			return getRuleContext(Literal_real_value_exprContext.class,0);
		}
		public Literal_string_value_exprContext literal_string_value_expr() {
			return getRuleContext(Literal_string_value_exprContext.class,0);
		}
		public Literal_iri_value_exprContext literal_iri_value_expr() {
			return getRuleContext(Literal_iri_value_exprContext.class,0);
		}
		public Literal_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterLiteral_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitLiteral_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitLiteral_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_exprContext literal_expr() throws RecognitionException {
		Literal_exprContext _localctx = new Literal_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_literal_expr);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				literal_real_value_expr();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				literal_string_value_expr();
				}
				break;
			case IRI_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				literal_iri_value_expr();
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

	public static class Literal_real_value_exprContext extends ParserRuleContext {
		public TerminalNode REAL_LITERAL() { return getToken(Shexl2Parser.REAL_LITERAL, 0); }
		public Literal_real_value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_real_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterLiteral_real_value_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitLiteral_real_value_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitLiteral_real_value_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_real_value_exprContext literal_real_value_expr() throws RecognitionException {
		Literal_real_value_exprContext _localctx = new Literal_real_value_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literal_real_value_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(REAL_LITERAL);
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

	public static class Literal_string_value_exprContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(Shexl2Parser.STRING_LITERAL, 0); }
		public Literal_string_value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_string_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterLiteral_string_value_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitLiteral_string_value_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitLiteral_string_value_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_string_value_exprContext literal_string_value_expr() throws RecognitionException {
		Literal_string_value_exprContext _localctx = new Literal_string_value_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal_string_value_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(STRING_LITERAL);
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

	public static class Literal_iri_value_exprContext extends ParserRuleContext {
		public TerminalNode IRI_LITERAL() { return getToken(Shexl2Parser.IRI_LITERAL, 0); }
		public Literal_iri_value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_iri_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterLiteral_iri_value_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitLiteral_iri_value_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitLiteral_iri_value_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_iri_value_exprContext literal_iri_value_expr() throws RecognitionException {
		Literal_iri_value_exprContext _localctx = new Literal_iri_value_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literal_iri_value_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(IRI_LITERAL);
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

	public static class Cardinality_exprContext extends ParserRuleContext {
		public Token min;
		public Token max;
		public List<TerminalNode> INT_LITERAL() { return getTokens(Shexl2Parser.INT_LITERAL); }
		public TerminalNode INT_LITERAL(int i) {
			return getToken(Shexl2Parser.INT_LITERAL, i);
		}
		public Cardinality_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterCardinality_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitCardinality_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitCardinality_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cardinality_exprContext cardinality_expr() throws RecognitionException {
		Cardinality_exprContext _localctx = new Cardinality_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cardinality_expr);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(T__7);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(T__8);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(T__9);
				setState(113);
				((Cardinality_exprContext)_localctx).min = match(INT_LITERAL);
				setState(114);
				match(T__10);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(T__9);
				setState(116);
				((Cardinality_exprContext)_localctx).min = match(INT_LITERAL);
				setState(117);
				match(T__11);
				setState(118);
				((Cardinality_exprContext)_localctx).max = match(INT_LITERAL);
				setState(119);
				match(T__10);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(120);
				match(T__9);
				setState(121);
				((Cardinality_exprContext)_localctx).min = match(INT_LITERAL);
				setState(122);
				match(T__11);
				setState(123);
				match(T__10);
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

	public static class Constraint_exprContext extends ParserRuleContext {
		public Constraint_node_exprContext constraint_node_expr() {
			return getRuleContext(Constraint_node_exprContext.class,0);
		}
		public Constraint_block_triple_exprContext constraint_block_triple_expr() {
			return getRuleContext(Constraint_block_triple_exprContext.class,0);
		}
		public Constraint_triple_exprContext constraint_triple_expr() {
			return getRuleContext(Constraint_triple_exprContext.class,0);
		}
		public Constraint_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_exprContext constraint_expr() throws RecognitionException {
		Constraint_exprContext _localctx = new Constraint_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constraint_expr);
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				constraint_node_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				constraint_block_triple_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				constraint_triple_expr();
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

	public static class Constraint_node_exprContext extends ParserRuleContext {
		public Constraint_node_iri_exprContext constraint_node_iri_expr() {
			return getRuleContext(Constraint_node_iri_exprContext.class,0);
		}
		public Constraint_valid_value_set_typeContext constraint_valid_value_set_type() {
			return getRuleContext(Constraint_valid_value_set_typeContext.class,0);
		}
		public Constraint_node_any_type_exprContext constraint_node_any_type_expr() {
			return getRuleContext(Constraint_node_any_type_exprContext.class,0);
		}
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public Constraint_node_non_literal_exprContext constraint_node_non_literal_expr() {
			return getRuleContext(Constraint_node_non_literal_exprContext.class,0);
		}
		public Constraint_value_set_exprContext constraint_value_set_expr() {
			return getRuleContext(Constraint_value_set_exprContext.class,0);
		}
		public Constraint_node_bnode_exprContext constraint_node_bnode_expr() {
			return getRuleContext(Constraint_node_bnode_exprContext.class,0);
		}
		public Constraint_node_literal_exprContext constraint_node_literal_expr() {
			return getRuleContext(Constraint_node_literal_exprContext.class,0);
		}
		public Constraint_node_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_node_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_node_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_node_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_node_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_node_exprContext constraint_node_expr() throws RecognitionException {
		Constraint_node_exprContext _localctx = new Constraint_node_exprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constraint_node_expr);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				constraint_node_iri_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				constraint_valid_value_set_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				constraint_node_any_type_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				call_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(135);
				constraint_node_non_literal_expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				constraint_value_set_expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(137);
				constraint_node_bnode_expr();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(138);
				constraint_node_literal_expr();
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

	public static class Constraint_block_triple_exprContext extends ParserRuleContext {
		public List<Constraint_triple_exprContext> constraint_triple_expr() {
			return getRuleContexts(Constraint_triple_exprContext.class);
		}
		public Constraint_triple_exprContext constraint_triple_expr(int i) {
			return getRuleContext(Constraint_triple_exprContext.class,i);
		}
		public Constraint_block_triple_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_block_triple_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_block_triple_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_block_triple_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_block_triple_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_block_triple_exprContext constraint_block_triple_expr() throws RecognitionException {
		Constraint_block_triple_exprContext _localctx = new Constraint_block_triple_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constraint_block_triple_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__9);
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				constraint_triple_expr();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(143);
					match(T__12);
					}
				}

				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << LABEL) | (1L << IRI_LITERAL))) != 0) );
			setState(150);
			match(T__10);
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

	public static class Constraint_triple_exprContext extends ParserRuleContext {
		public Call_prefix_exprContext property;
		public Constraint_node_exprContext constraint;
		public Cardinality_exprContext cardinality;
		public Call_prefix_exprContext call_prefix_expr() {
			return getRuleContext(Call_prefix_exprContext.class,0);
		}
		public Constraint_node_exprContext constraint_node_expr() {
			return getRuleContext(Constraint_node_exprContext.class,0);
		}
		public Cardinality_exprContext cardinality_expr() {
			return getRuleContext(Cardinality_exprContext.class,0);
		}
		public Constraint_triple_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_triple_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_triple_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_triple_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_triple_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_triple_exprContext constraint_triple_expr() throws RecognitionException {
		Constraint_triple_exprContext _localctx = new Constraint_triple_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constraint_triple_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((Constraint_triple_exprContext)_localctx).property = call_prefix_expr();
			setState(153);
			((Constraint_triple_exprContext)_localctx).constraint = constraint_node_expr();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
				{
				setState(154);
				((Constraint_triple_exprContext)_localctx).cardinality = cardinality_expr();
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

	public static class Constraint_node_iri_exprContext extends ParserRuleContext {
		public Constraint_node_iri_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_node_iri_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_node_iri_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_node_iri_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_node_iri_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_node_iri_exprContext constraint_node_iri_expr() throws RecognitionException {
		Constraint_node_iri_exprContext _localctx = new Constraint_node_iri_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constraint_node_iri_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__13);
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

	public static class Constraint_valid_value_set_typeContext extends ParserRuleContext {
		public Call_prefix_exprContext call_prefix_expr() {
			return getRuleContext(Call_prefix_exprContext.class,0);
		}
		public Call_shape_exprContext call_shape_expr() {
			return getRuleContext(Call_shape_exprContext.class,0);
		}
		public Literal_string_value_exprContext literal_string_value_expr() {
			return getRuleContext(Literal_string_value_exprContext.class,0);
		}
		public Literal_real_value_exprContext literal_real_value_expr() {
			return getRuleContext(Literal_real_value_exprContext.class,0);
		}
		public Constraint_valid_value_set_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_valid_value_set_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_valid_value_set_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_valid_value_set_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_valid_value_set_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_valid_value_set_typeContext constraint_valid_value_set_type() throws RecognitionException {
		Constraint_valid_value_set_typeContext _localctx = new Constraint_valid_value_set_typeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constraint_valid_value_set_type);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case LABEL:
			case IRI_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				call_prefix_expr();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				call_shape_expr();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				literal_string_value_expr();
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				literal_real_value_expr();
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

	public static class Constraint_node_any_type_exprContext extends ParserRuleContext {
		public Constraint_node_any_type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_node_any_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_node_any_type_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_node_any_type_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_node_any_type_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_node_any_type_exprContext constraint_node_any_type_expr() throws RecognitionException {
		Constraint_node_any_type_exprContext _localctx = new Constraint_node_any_type_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constraint_node_any_type_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__14);
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

	public static class Constraint_node_non_literal_exprContext extends ParserRuleContext {
		public Constraint_node_non_literal_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_node_non_literal_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_node_non_literal_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_node_non_literal_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_node_non_literal_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_node_non_literal_exprContext constraint_node_non_literal_expr() throws RecognitionException {
		Constraint_node_non_literal_exprContext _localctx = new Constraint_node_non_literal_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constraint_node_non_literal_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(T__15);
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

	public static class Constraint_value_set_exprContext extends ParserRuleContext {
		public List<Constraint_valid_value_set_typeContext> constraint_valid_value_set_type() {
			return getRuleContexts(Constraint_valid_value_set_typeContext.class);
		}
		public Constraint_valid_value_set_typeContext constraint_valid_value_set_type(int i) {
			return getRuleContext(Constraint_valid_value_set_typeContext.class,i);
		}
		public Constraint_value_set_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_value_set_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_value_set_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_value_set_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_value_set_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_value_set_exprContext constraint_value_set_expr() throws RecognitionException {
		Constraint_value_set_exprContext _localctx = new Constraint_value_set_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constraint_value_set_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__16);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__20) | (1L << LABEL) | (1L << IRI_LITERAL) | (1L << REAL_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				{
				setState(170);
				constraint_valid_value_set_type();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			match(T__17);
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

	public static class Constraint_node_bnode_exprContext extends ParserRuleContext {
		public Constraint_node_bnode_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_node_bnode_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_node_bnode_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_node_bnode_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_node_bnode_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_node_bnode_exprContext constraint_node_bnode_expr() throws RecognitionException {
		Constraint_node_bnode_exprContext _localctx = new Constraint_node_bnode_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constraint_node_bnode_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__18);
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

	public static class Constraint_node_literal_exprContext extends ParserRuleContext {
		public Constraint_node_literal_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_node_literal_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterConstraint_node_literal_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitConstraint_node_literal_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitConstraint_node_literal_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_node_literal_exprContext constraint_node_literal_expr() throws RecognitionException {
		Constraint_node_literal_exprContext _localctx = new Constraint_node_literal_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_constraint_node_literal_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__19);
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

	public static class Call_exprContext extends ParserRuleContext {
		public Call_prefix_exprContext call_prefix_expr() {
			return getRuleContext(Call_prefix_exprContext.class,0);
		}
		public Call_shape_exprContext call_shape_expr() {
			return getRuleContext(Call_shape_exprContext.class,0);
		}
		public Call_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterCall_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitCall_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitCall_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_exprContext call_expr() throws RecognitionException {
		Call_exprContext _localctx = new Call_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_call_expr);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case LABEL:
			case IRI_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				call_prefix_expr();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				call_shape_expr();
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

	public static class Call_prefix_exprContext extends ParserRuleContext {
		public Token pref_lbl;
		public Token shape_lbl;
		public Literal_iri_value_exprContext base_relative_lbl;
		public List<TerminalNode> LABEL() { return getTokens(Shexl2Parser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(Shexl2Parser.LABEL, i);
		}
		public Literal_iri_value_exprContext literal_iri_value_expr() {
			return getRuleContext(Literal_iri_value_exprContext.class,0);
		}
		public Call_prefix_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_prefix_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterCall_prefix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitCall_prefix_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitCall_prefix_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_prefix_exprContext call_prefix_expr() throws RecognitionException {
		Call_prefix_exprContext _localctx = new Call_prefix_exprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_call_prefix_expr);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LABEL) {
					{
					setState(186);
					((Call_prefix_exprContext)_localctx).pref_lbl = match(LABEL);
					}
				}

				setState(189);
				match(T__4);
				setState(190);
				((Call_prefix_exprContext)_localctx).shape_lbl = match(LABEL);
				}
				break;
			case IRI_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				((Call_prefix_exprContext)_localctx).base_relative_lbl = literal_iri_value_expr();
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

	public static class Call_shape_exprContext extends ParserRuleContext {
		public Token prefix_lbl;
		public Token shape_lbl;
		public Literal_iri_value_exprContext base_relative_lbl;
		public List<TerminalNode> LABEL() { return getTokens(Shexl2Parser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(Shexl2Parser.LABEL, i);
		}
		public Literal_iri_value_exprContext literal_iri_value_expr() {
			return getRuleContext(Literal_iri_value_exprContext.class,0);
		}
		public Call_shape_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_shape_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).enterCall_shape_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Shexl2Listener ) ((Shexl2Listener)listener).exitCall_shape_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Shexl2Visitor ) return ((Shexl2Visitor<? extends T>)visitor).visitCall_shape_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_shape_exprContext call_shape_expr() throws RecognitionException {
		Call_shape_exprContext _localctx = new Call_shape_exprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_call_shape_expr);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(T__20);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LABEL) {
					{
					setState(195);
					((Call_shape_exprContext)_localctx).prefix_lbl = match(LABEL);
					}
				}

				setState(198);
				match(T__4);
				setState(199);
				((Call_shape_exprContext)_localctx).shape_lbl = match(LABEL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(T__20);
				setState(201);
				((Call_shape_exprContext)_localctx).base_relative_lbl = literal_iri_value_expr();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00cf\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\6\2<\n\2\r\2\16\2=\3\2\3"+
		"\2\3\3\3\3\5\3D\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\5\7U\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\5"+
		"\nc\n\n\3\13\3\13\3\13\5\13h\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\177\n\17\3\20\3\20\3\20\5\20\u0084\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u008e\n\21\3\22\3\22\3\22\5\22\u0093\n\22\6\22\u0095\n"+
		"\22\r\22\16\22\u0096\3\22\3\22\3\23\3\23\3\23\5\23\u009e\n\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\5\25\u00a6\n\25\3\26\3\26\3\27\3\27\3\30\3\30\7\30"+
		"\u00ae\n\30\f\30\16\30\u00b1\13\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\5\33\u00bb\n\33\3\34\5\34\u00be\n\34\3\34\3\34\3\34\5\34\u00c3\n"+
		"\34\3\35\3\35\5\35\u00c7\n\35\3\35\3\35\3\35\3\35\5\35\u00cd\n\35\3\35"+
		"\2\2\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2"+
		"\2\2\u00d6\2;\3\2\2\2\4C\3\2\2\2\6E\3\2\2\2\bL\3\2\2\2\nN\3\2\2\2\fR\3"+
		"\2\2\2\16Y\3\2\2\2\20\\\3\2\2\2\22b\3\2\2\2\24g\3\2\2\2\26i\3\2\2\2\30"+
		"k\3\2\2\2\32m\3\2\2\2\34~\3\2\2\2\36\u0083\3\2\2\2 \u008d\3\2\2\2\"\u008f"+
		"\3\2\2\2$\u009a\3\2\2\2&\u009f\3\2\2\2(\u00a5\3\2\2\2*\u00a7\3\2\2\2,"+
		"\u00a9\3\2\2\2.\u00ab\3\2\2\2\60\u00b4\3\2\2\2\62\u00b6\3\2\2\2\64\u00ba"+
		"\3\2\2\2\66\u00c2\3\2\2\28\u00cc\3\2\2\2:<\5\4\3\2;:\3\2\2\2<=\3\2\2\2"+
		"=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\7\2\2\3@\3\3\2\2\2AD\5\6\4\2BD\5\b\5"+
		"\2CA\3\2\2\2CB\3\2\2\2D\5\3\2\2\2EF\7\3\2\2FG\5\32\16\2G\7\3\2\2\2HM\5"+
		"\n\6\2IM\5\f\7\2JM\5\16\b\2KM\5\20\t\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2L"+
		"K\3\2\2\2M\t\3\2\2\2NO\7\4\2\2OP\7\5\2\2PQ\58\35\2Q\13\3\2\2\2RT\7\6\2"+
		"\2SU\7\30\2\2TS\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\7\2\2WX\5\32\16\2X\r\3"+
		"\2\2\2YZ\7\b\2\2Z[\5\32\16\2[\17\3\2\2\2\\]\5\66\34\2]^\5\36\20\2^\21"+
		"\3\2\2\2_c\5\24\13\2`c\5\34\17\2ac\5\36\20\2b_\3\2\2\2b`\3\2\2\2ba\3\2"+
		"\2\2c\23\3\2\2\2dh\5\26\f\2eh\5\30\r\2fh\5\32\16\2gd\3\2\2\2ge\3\2\2\2"+
		"gf\3\2\2\2h\25\3\2\2\2ij\7\33\2\2j\27\3\2\2\2kl\7\34\2\2l\31\3\2\2\2m"+
		"n\7\31\2\2n\33\3\2\2\2o\177\7\t\2\2p\177\7\n\2\2q\177\7\13\2\2rs\7\f\2"+
		"\2st\7\32\2\2t\177\7\r\2\2uv\7\f\2\2vw\7\32\2\2wx\7\16\2\2xy\7\32\2\2"+
		"y\177\7\r\2\2z{\7\f\2\2{|\7\32\2\2|}\7\16\2\2}\177\7\r\2\2~o\3\2\2\2~"+
		"p\3\2\2\2~q\3\2\2\2~r\3\2\2\2~u\3\2\2\2~z\3\2\2\2\177\35\3\2\2\2\u0080"+
		"\u0084\5 \21\2\u0081\u0084\5\"\22\2\u0082\u0084\5$\23\2\u0083\u0080\3"+
		"\2\2\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084\37\3\2\2\2\u0085"+
		"\u008e\5&\24\2\u0086\u008e\5(\25\2\u0087\u008e\5*\26\2\u0088\u008e\5\64"+
		"\33\2\u0089\u008e\5,\27\2\u008a\u008e\5.\30\2\u008b\u008e\5\60\31\2\u008c"+
		"\u008e\5\62\32\2\u008d\u0085\3\2\2\2\u008d\u0086\3\2\2\2\u008d\u0087\3"+
		"\2\2\2\u008d\u0088\3\2\2\2\u008d\u0089\3\2\2\2\u008d\u008a\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e!\3\2\2\2\u008f\u0094\7\f\2\2"+
		"\u0090\u0092\5$\23\2\u0091\u0093\7\17\2\2\u0092\u0091\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0090\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\r"+
		"\2\2\u0099#\3\2\2\2\u009a\u009b\5\66\34\2\u009b\u009d\5 \21\2\u009c\u009e"+
		"\5\34\17\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e%\3\2\2\2\u009f"+
		"\u00a0\7\20\2\2\u00a0\'\3\2\2\2\u00a1\u00a6\5\66\34\2\u00a2\u00a6\58\35"+
		"\2\u00a3\u00a6\5\30\r\2\u00a4\u00a6\5\26\f\2\u00a5\u00a1\3\2\2\2\u00a5"+
		"\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6)\3\2\2\2"+
		"\u00a7\u00a8\7\21\2\2\u00a8+\3\2\2\2\u00a9\u00aa\7\22\2\2\u00aa-\3\2\2"+
		"\2\u00ab\u00af\7\23\2\2\u00ac\u00ae\5(\25\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7\24\2\2\u00b3/\3\2\2\2\u00b4\u00b5"+
		"\7\25\2\2\u00b5\61\3\2\2\2\u00b6\u00b7\7\26\2\2\u00b7\63\3\2\2\2\u00b8"+
		"\u00bb\5\66\34\2\u00b9\u00bb\58\35\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3"+
		"\2\2\2\u00bb\65\3\2\2\2\u00bc\u00be\7\30\2\2\u00bd\u00bc\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7\7\2\2\u00c0\u00c3\7\30"+
		"\2\2\u00c1\u00c3\5\32\16\2\u00c2\u00bd\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3"+
		"\67\3\2\2\2\u00c4\u00c6\7\27\2\2\u00c5\u00c7\7\30\2\2\u00c6\u00c5\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\7\7\2\2\u00c9"+
		"\u00cd\7\30\2\2\u00ca\u00cb\7\27\2\2\u00cb\u00cd\5\32\16\2\u00cc\u00c4"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd9\3\2\2\2\25=CLTbg~\u0083\u008d\u0092"+
		"\u0096\u009d\u00a5\u00af\u00ba\u00bd\u00c2\u00c6\u00cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}