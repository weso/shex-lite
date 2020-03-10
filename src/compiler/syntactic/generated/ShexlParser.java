// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/grammar\Shexl.g4 by ANTLR 4.8
package syntactic.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShexlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, PREFIX_KW=14, BASE_KW=15, IMPORT_KW=16, 
		START_KW=17, AND_KW=18, OR_KW=19, NOT_KW=20, IRI_KW=21, LITERAL_KW=22, 
		BNODE_KW=23, NON_LITERAL_KW=24, CLOSED_KW=25, A_KW=26, LABEL=27, IRI=28, 
		INT_LITERAL=29, REAL_LITERAL=30, STRING_LITERAL=31, SKIP_=32;
	public static final int
		RULE_schema = 0, RULE_statement = 1, RULE_declaration_statement = 2, RULE_base_declaration = 3, 
		RULE_start_declaration = 4, RULE_prefix_declaration = 5, RULE_shape_declaration = 6, 
		RULE_import_statement = 7, RULE_shape_name = 8, RULE_shape_invocation = 9, 
		RULE_expression = 10, RULE_triple_expression = 11, RULE_triple_constraint = 12, 
		RULE_prefix_invocation = 13, RULE_node_constraint = 14, RULE_value_set_type = 15, 
		RULE_cardinality = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"schema", "statement", "declaration_statement", "base_declaration", "start_declaration", 
			"prefix_declaration", "shape_declaration", "import_statement", "shape_name", 
			"shape_invocation", "expression", "triple_expression", "triple_constraint", 
			"prefix_invocation", "node_constraint", "value_set_type", "cardinality"
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
			"CLOSED_KW", "A_KW", "LABEL", "IRI", "INT_LITERAL", "REAL_LITERAL", "STRING_LITERAL", 
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
	public String getGrammarFileName() { return "Shexl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShexlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SchemaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ShexlParser.EOF, 0); }
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
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterSchema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitSchema(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitSchema(this);
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
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				statement();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << PREFIX_KW) | (1L << BASE_KW) | (1L << IMPORT_KW) | (1L << START_KW) | (1L << LABEL) | (1L << IRI))) != 0) );
			setState(39);
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
		public Declaration_statementContext declaration_statement() {
			return getRuleContext(Declaration_statementContext.class,0);
		}
		public Import_statementContext import_statement() {
			return getRuleContext(Import_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case PREFIX_KW:
			case BASE_KW:
			case START_KW:
			case LABEL:
			case IRI:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				declaration_statement();
				}
				break;
			case IMPORT_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				import_statement();
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

	public static class Declaration_statementContext extends ParserRuleContext {
		public Base_declarationContext base_declaration() {
			return getRuleContext(Base_declarationContext.class,0);
		}
		public Start_declarationContext start_declaration() {
			return getRuleContext(Start_declarationContext.class,0);
		}
		public Prefix_declarationContext prefix_declaration() {
			return getRuleContext(Prefix_declarationContext.class,0);
		}
		public Shape_declarationContext shape_declaration() {
			return getRuleContext(Shape_declarationContext.class,0);
		}
		public Declaration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterDeclaration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitDeclaration_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitDeclaration_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_statementContext declaration_statement() throws RecognitionException {
		Declaration_statementContext _localctx = new Declaration_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration_statement);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASE_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				base_declaration();
				}
				break;
			case START_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				start_declaration();
				}
				break;
			case PREFIX_KW:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				prefix_declaration();
				}
				break;
			case T__1:
			case LABEL:
			case IRI:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				shape_declaration();
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

	public static class Base_declarationContext extends ParserRuleContext {
		public TerminalNode BASE_KW() { return getToken(ShexlParser.BASE_KW, 0); }
		public TerminalNode IRI() { return getToken(ShexlParser.IRI, 0); }
		public Base_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterBase_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitBase_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitBase_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_declarationContext base_declaration() throws RecognitionException {
		Base_declarationContext _localctx = new Base_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_base_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(BASE_KW);
			setState(52);
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

	public static class Start_declarationContext extends ParserRuleContext {
		public TerminalNode START_KW() { return getToken(ShexlParser.START_KW, 0); }
		public Shape_invocationContext shape_invocation() {
			return getRuleContext(Shape_invocationContext.class,0);
		}
		public Start_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterStart_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitStart_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitStart_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_declarationContext start_declaration() throws RecognitionException {
		Start_declarationContext _localctx = new Start_declarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_start_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(START_KW);
			setState(55);
			match(T__0);
			setState(56);
			shape_invocation();
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

	public static class Prefix_declarationContext extends ParserRuleContext {
		public TerminalNode PREFIX_KW() { return getToken(ShexlParser.PREFIX_KW, 0); }
		public TerminalNode IRI() { return getToken(ShexlParser.IRI, 0); }
		public TerminalNode LABEL() { return getToken(ShexlParser.LABEL, 0); }
		public Prefix_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterPrefix_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitPrefix_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitPrefix_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_declarationContext prefix_declaration() throws RecognitionException {
		Prefix_declarationContext _localctx = new Prefix_declarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_prefix_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(PREFIX_KW);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				setState(59);
				match(LABEL);
				}
			}

			setState(62);
			match(T__1);
			setState(63);
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

	public static class Shape_declarationContext extends ParserRuleContext {
		public Shape_nameContext shape_name() {
			return getRuleContext(Shape_nameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSED_KW() { return getToken(ShexlParser.CLOSED_KW, 0); }
		public Shape_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterShape_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitShape_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitShape_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_declarationContext shape_declaration() throws RecognitionException {
		Shape_declarationContext _localctx = new Shape_declarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_shape_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			shape_name();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLOSED_KW) {
				{
				setState(66);
				match(CLOSED_KW);
				}
			}

			setState(69);
			expression();
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

	public static class Import_statementContext extends ParserRuleContext {
		public TerminalNode IMPORT_KW() { return getToken(ShexlParser.IMPORT_KW, 0); }
		public TerminalNode IRI() { return getToken(ShexlParser.IRI, 0); }
		public Import_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterImport_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitImport_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitImport_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_statementContext import_statement() throws RecognitionException {
		Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_import_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(IMPORT_KW);
			setState(72);
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

	public static class Shape_nameContext extends ParserRuleContext {
		public Prefix_invocationContext prefix_invocation() {
			return getRuleContext(Prefix_invocationContext.class,0);
		}
		public TerminalNode IRI() { return getToken(ShexlParser.IRI, 0); }
		public Shape_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterShape_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitShape_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitShape_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_nameContext shape_name() throws RecognitionException {
		Shape_nameContext _localctx = new Shape_nameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_shape_name);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				prefix_invocation();
				}
				break;
			case IRI:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(IRI);
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

	public static class Shape_invocationContext extends ParserRuleContext {
		public Shape_nameContext shape_name() {
			return getRuleContext(Shape_nameContext.class,0);
		}
		public Shape_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterShape_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitShape_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitShape_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_invocationContext shape_invocation() throws RecognitionException {
		Shape_invocationContext _localctx = new Shape_invocationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_shape_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__2);
			setState(79);
			shape_name();
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
		public Triple_expressionContext triple_expression() {
			return getRuleContext(Triple_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			triple_expression(0);
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

	public static class Triple_expressionContext extends ParserRuleContext {
		public Triple_expressionContext ex1;
		public Triple_expressionContext ex2;
		public TerminalNode NOT_KW() { return getToken(ShexlParser.NOT_KW, 0); }
		public List<Triple_expressionContext> triple_expression() {
			return getRuleContexts(Triple_expressionContext.class);
		}
		public Triple_expressionContext triple_expression(int i) {
			return getRuleContext(Triple_expressionContext.class,i);
		}
		public Node_constraintContext node_constraint() {
			return getRuleContext(Node_constraintContext.class,0);
		}
		public List<Triple_constraintContext> triple_constraint() {
			return getRuleContexts(Triple_constraintContext.class);
		}
		public Triple_constraintContext triple_constraint(int i) {
			return getRuleContext(Triple_constraintContext.class,i);
		}
		public TerminalNode AND_KW() { return getToken(ShexlParser.AND_KW, 0); }
		public TerminalNode OR_KW() { return getToken(ShexlParser.OR_KW, 0); }
		public Triple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triple_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterTriple_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitTriple_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitTriple_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Triple_expressionContext triple_expression() throws RecognitionException {
		return triple_expression(0);
	}

	private Triple_expressionContext triple_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Triple_expressionContext _localctx = new Triple_expressionContext(_ctx, _parentState);
		Triple_expressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_triple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(84);
				match(NOT_KW);
				setState(85);
				triple_expression(4);
				}
				break;
			case 2:
				{
				setState(86);
				node_constraint();
				}
				break;
			case 3:
				{
				setState(87);
				match(T__3);
				setState(88);
				triple_constraint();
				setState(89);
				match(T__4);
				}
				break;
			case 4:
				{
				setState(91);
				match(T__3);
				setState(95); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(92);
						triple_constraint();
						setState(93);
						match(T__5);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(97); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(99);
				triple_constraint();
				setState(100);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(110);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new Triple_expressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_triple_expression);
						setState(104);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(105);
						match(AND_KW);
						setState(106);
						((Triple_expressionContext)_localctx).ex2 = triple_expression(7);
						}
						break;
					case 2:
						{
						_localctx = new Triple_expressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_triple_expression);
						setState(107);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(108);
						match(OR_KW);
						setState(109);
						((Triple_expressionContext)_localctx).ex2 = triple_expression(6);
						}
						break;
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Triple_constraintContext extends ParserRuleContext {
		public Node_constraintContext node_constraint() {
			return getRuleContext(Node_constraintContext.class,0);
		}
		public Prefix_invocationContext prefix_invocation() {
			return getRuleContext(Prefix_invocationContext.class,0);
		}
		public TerminalNode A_KW() { return getToken(ShexlParser.A_KW, 0); }
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public Triple_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triple_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterTriple_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitTriple_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitTriple_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Triple_constraintContext triple_constraint() throws RecognitionException {
		Triple_constraintContext _localctx = new Triple_constraintContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_triple_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case LABEL:
				{
				setState(115);
				prefix_invocation();
				}
				break;
			case A_KW:
				{
				setState(116);
				match(A_KW);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(119);
			node_constraint();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				setState(120);
				cardinality();
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

	public static class Prefix_invocationContext extends ParserRuleContext {
		public Token prefix;
		public Token property;
		public List<TerminalNode> LABEL() { return getTokens(ShexlParser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(ShexlParser.LABEL, i);
		}
		public Prefix_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterPrefix_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitPrefix_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitPrefix_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_invocationContext prefix_invocation() throws RecognitionException {
		Prefix_invocationContext _localctx = new Prefix_invocationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_prefix_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				setState(123);
				((Prefix_invocationContext)_localctx).prefix = match(LABEL);
				}
			}

			setState(126);
			match(T__1);
			setState(127);
			((Prefix_invocationContext)_localctx).property = match(LABEL);
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
		public Prefix_invocationContext prefix_invocation() {
			return getRuleContext(Prefix_invocationContext.class,0);
		}
		public TerminalNode LITERAL_KW() { return getToken(ShexlParser.LITERAL_KW, 0); }
		public TerminalNode IRI_KW() { return getToken(ShexlParser.IRI_KW, 0); }
		public TerminalNode BNODE_KW() { return getToken(ShexlParser.BNODE_KW, 0); }
		public TerminalNode NON_LITERAL_KW() { return getToken(ShexlParser.NON_LITERAL_KW, 0); }
		public List<Value_set_typeContext> value_set_type() {
			return getRuleContexts(Value_set_typeContext.class);
		}
		public Value_set_typeContext value_set_type(int i) {
			return getRuleContext(Value_set_typeContext.class,i);
		}
		public Shape_invocationContext shape_invocation() {
			return getRuleContext(Shape_invocationContext.class,0);
		}
		public Node_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterNode_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitNode_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitNode_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Node_constraintContext node_constraint() throws RecognitionException {
		Node_constraintContext _localctx = new Node_constraintContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_node_constraint);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(T__6);
				}
				break;
			case T__1:
			case LABEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				prefix_invocation();
				}
				break;
			case LITERAL_KW:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(LITERAL_KW);
				}
				break;
			case IRI_KW:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(IRI_KW);
				}
				break;
			case BNODE_KW:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(BNODE_KW);
				}
				break;
			case NON_LITERAL_KW:
				enterOuterAlt(_localctx, 6);
				{
				setState(134);
				match(NON_LITERAL_KW);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				match(T__7);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << LABEL) | (1L << REAL_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
					{
					{
					setState(136);
					value_set_type();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				match(T__8);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 8);
				{
				setState(143);
				shape_invocation();
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

	public static class Value_set_typeContext extends ParserRuleContext {
		public Prefix_invocationContext prefix_invocation() {
			return getRuleContext(Prefix_invocationContext.class,0);
		}
		public Shape_invocationContext shape_invocation() {
			return getRuleContext(Shape_invocationContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(ShexlParser.STRING_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(ShexlParser.REAL_LITERAL, 0); }
		public Value_set_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_set_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterValue_set_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitValue_set_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitValue_set_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_set_typeContext value_set_type() throws RecognitionException {
		Value_set_typeContext _localctx = new Value_set_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value_set_type);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				prefix_invocation();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				shape_invocation();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(STRING_LITERAL);
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(REAL_LITERAL);
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
		public List<TerminalNode> INT_LITERAL() { return getTokens(ShexlParser.INT_LITERAL); }
		public TerminalNode INT_LITERAL(int i) {
			return getToken(ShexlParser.INT_LITERAL, i);
		}
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShexlListener ) ((ShexlListener)listener).exitCardinality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShexlVisitor ) return ((ShexlVisitor<? extends T>)visitor).visitCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cardinality);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				match(T__10);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(T__11);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				match(T__3);
				setState(156);
				match(INT_LITERAL);
				setState(157);
				match(T__4);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				match(T__3);
				setState(159);
				match(INT_LITERAL);
				setState(160);
				match(T__12);
				setState(161);
				match(INT_LITERAL);
				setState(162);
				match(T__4);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(163);
				match(T__3);
				setState(164);
				match(INT_LITERAL);
				setState(165);
				match(T__12);
				setState(166);
				match(T__4);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return triple_expression_sempred((Triple_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean triple_expression_sempred(Triple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00ac\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\2\3\2\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\5\4"+
		"\64\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\5\7?\n\7\3\7\3\7\3\7\3\b\3"+
		"\b\5\bF\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\5\nO\n\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\rb\n\r\r\r\16\rc"+
		"\3\r\3\r\3\r\5\ri\n\r\3\r\3\r\3\r\3\r\3\r\3\r\7\rq\n\r\f\r\16\rt\13\r"+
		"\3\16\3\16\5\16x\n\16\3\16\3\16\5\16|\n\16\3\17\5\17\177\n\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u008c\n\20\f\20\16"+
		"\20\u008f\13\20\3\20\3\20\5\20\u0093\n\20\3\21\3\21\3\21\3\21\5\21\u0099"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u00aa\n\22\3\22\2\3\30\23\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"\2\2\2\u00bb\2%\3\2\2\2\4-\3\2\2\2\6\63\3\2\2\2\b\65\3\2\2"+
		"\2\n8\3\2\2\2\f<\3\2\2\2\16C\3\2\2\2\20I\3\2\2\2\22N\3\2\2\2\24P\3\2\2"+
		"\2\26S\3\2\2\2\30h\3\2\2\2\32w\3\2\2\2\34~\3\2\2\2\36\u0092\3\2\2\2 \u0098"+
		"\3\2\2\2\"\u00a9\3\2\2\2$&\5\4\3\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'("+
		"\3\2\2\2()\3\2\2\2)*\7\2\2\3*\3\3\2\2\2+.\5\6\4\2,.\5\20\t\2-+\3\2\2\2"+
		"-,\3\2\2\2.\5\3\2\2\2/\64\5\b\5\2\60\64\5\n\6\2\61\64\5\f\7\2\62\64\5"+
		"\16\b\2\63/\3\2\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\7\3\2"+
		"\2\2\65\66\7\21\2\2\66\67\7\36\2\2\67\t\3\2\2\289\7\23\2\29:\7\3\2\2:"+
		";\5\24\13\2;\13\3\2\2\2<>\7\20\2\2=?\7\35\2\2>=\3\2\2\2>?\3\2\2\2?@\3"+
		"\2\2\2@A\7\4\2\2AB\7\36\2\2B\r\3\2\2\2CE\5\22\n\2DF\7\33\2\2ED\3\2\2\2"+
		"EF\3\2\2\2FG\3\2\2\2GH\5\26\f\2H\17\3\2\2\2IJ\7\22\2\2JK\7\36\2\2K\21"+
		"\3\2\2\2LO\5\34\17\2MO\7\36\2\2NL\3\2\2\2NM\3\2\2\2O\23\3\2\2\2PQ\7\5"+
		"\2\2QR\5\22\n\2R\25\3\2\2\2ST\5\30\r\2T\27\3\2\2\2UV\b\r\1\2VW\7\26\2"+
		"\2Wi\5\30\r\6Xi\5\36\20\2YZ\7\6\2\2Z[\5\32\16\2[\\\7\7\2\2\\i\3\2\2\2"+
		"]a\7\6\2\2^_\5\32\16\2_`\7\b\2\2`b\3\2\2\2a^\3\2\2\2bc\3\2\2\2ca\3\2\2"+
		"\2cd\3\2\2\2de\3\2\2\2ef\5\32\16\2fg\7\7\2\2gi\3\2\2\2hU\3\2\2\2hX\3\2"+
		"\2\2hY\3\2\2\2h]\3\2\2\2ir\3\2\2\2jk\f\b\2\2kl\7\24\2\2lq\5\30\r\tmn\f"+
		"\7\2\2no\7\25\2\2oq\5\30\r\bpj\3\2\2\2pm\3\2\2\2qt\3\2\2\2rp\3\2\2\2r"+
		"s\3\2\2\2s\31\3\2\2\2tr\3\2\2\2ux\5\34\17\2vx\7\34\2\2wu\3\2\2\2wv\3\2"+
		"\2\2xy\3\2\2\2y{\5\36\20\2z|\5\"\22\2{z\3\2\2\2{|\3\2\2\2|\33\3\2\2\2"+
		"}\177\7\35\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7"+
		"\4\2\2\u0081\u0082\7\35\2\2\u0082\35\3\2\2\2\u0083\u0093\7\t\2\2\u0084"+
		"\u0093\5\34\17\2\u0085\u0093\7\30\2\2\u0086\u0093\7\27\2\2\u0087\u0093"+
		"\7\31\2\2\u0088\u0093\7\32\2\2\u0089\u008d\7\n\2\2\u008a\u008c\5 \21\2"+
		"\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0093\7\13\2\2"+
		"\u0091\u0093\5\24\13\2\u0092\u0083\3\2\2\2\u0092\u0084\3\2\2\2\u0092\u0085"+
		"\3\2\2\2\u0092\u0086\3\2\2\2\u0092\u0087\3\2\2\2\u0092\u0088\3\2\2\2\u0092"+
		"\u0089\3\2\2\2\u0092\u0091\3\2\2\2\u0093\37\3\2\2\2\u0094\u0099\5\34\17"+
		"\2\u0095\u0099\5\24\13\2\u0096\u0099\7!\2\2\u0097\u0099\7 \2\2\u0098\u0094"+
		"\3\2\2\2\u0098\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099"+
		"!\3\2\2\2\u009a\u00aa\7\f\2\2\u009b\u00aa\7\r\2\2\u009c\u00aa\7\16\2\2"+
		"\u009d\u009e\7\6\2\2\u009e\u009f\7\37\2\2\u009f\u00aa\7\7\2\2\u00a0\u00a1"+
		"\7\6\2\2\u00a1\u00a2\7\37\2\2\u00a2\u00a3\7\17\2\2\u00a3\u00a4\7\37\2"+
		"\2\u00a4\u00aa\7\7\2\2\u00a5\u00a6\7\6\2\2\u00a6\u00a7\7\37\2\2\u00a7"+
		"\u00a8\7\17\2\2\u00a8\u00aa\7\7\2\2\u00a9\u009a\3\2\2\2\u00a9\u009b\3"+
		"\2\2\2\u00a9\u009c\3\2\2\2\u00a9\u009d\3\2\2\2\u00a9\u00a0\3\2\2\2\u00a9"+
		"\u00a5\3\2\2\2\u00aa#\3\2\2\2\23\'-\63>ENchprw{~\u008d\u0092\u0098\u00a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}