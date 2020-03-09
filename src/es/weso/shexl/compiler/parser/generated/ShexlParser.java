// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/es.weso.shexl.compiler/grammar\Shexl.g4 by ANTLR 4.8
package es.weso.shexl.compiler.parser.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

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
		BNODE_KW=23, NON_LITERAL_KW=24, LABEL=25, IRI=26, INT_LITERAL=27, REAL_LITERAL=28, 
		STRING_LITERAL=29, SKIP_=30;
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
			"'AND'", "'OR'", "'NOT'", "'IRI'", "'LITERAL'", "'BNODE'", "'NONLITERAL'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "PREFIX_KW", "BASE_KW", "IMPORT_KW", "START_KW", "AND_KW", 
			"OR_KW", "NOT_KW", "IRI_KW", "LITERAL_KW", "BNODE_KW", "NON_LITERAL_KW", 
			"LABEL", "IRI", "INT_LITERAL", "REAL_LITERAL", "STRING_LITERAL", "SKIP_"
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			shape_name();
			setState(66);
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
			setState(68);
			match(IMPORT_KW);
			setState(69);
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
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				prefix_invocation();
				}
				break;
			case IRI:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
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
			setState(75);
			match(T__2);
			setState(76);
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
			setState(78);
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
		public Token op;
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(81);
				match(NOT_KW);
				setState(82);
				triple_expression(4);
				}
				break;
			case 2:
				{
				setState(83);
				node_constraint();
				}
				break;
			case 3:
				{
				setState(84);
				match(T__3);
				setState(85);
				triple_constraint();
				setState(86);
				match(T__4);
				}
				break;
			case 4:
				{
				setState(88);
				match(T__3);
				setState(92); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(89);
						triple_constraint();
						setState(90);
						match(T__5);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(94); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(96);
				triple_constraint();
				setState(97);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Triple_expressionContext(_parentctx, _parentState);
					_localctx.ex1 = _prevctx;
					_localctx.ex1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_triple_expression);
					setState(101);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(102);
					((Triple_expressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==AND_KW || _la==OR_KW) ) {
						((Triple_expressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(103);
					((Triple_expressionContext)_localctx).ex2 = triple_expression(6);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public Prefix_invocationContext prefix_invocation() {
			return getRuleContext(Prefix_invocationContext.class,0);
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
			setState(109);
			prefix_invocation();
			setState(110);
			node_constraint();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				setState(111);
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
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				setState(114);
				((Prefix_invocationContext)_localctx).prefix = match(LABEL);
				}
			}

			setState(117);
			match(T__1);
			setState(118);
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
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(T__6);
				}
				break;
			case T__1:
			case LABEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				prefix_invocation();
				}
				break;
			case LITERAL_KW:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(LITERAL_KW);
				}
				break;
			case IRI_KW:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(IRI_KW);
				}
				break;
			case BNODE_KW:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(BNODE_KW);
				}
				break;
			case NON_LITERAL_KW:
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				match(NON_LITERAL_KW);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(126);
				match(T__7);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << LABEL) | (1L << REAL_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
					{
					{
					setState(127);
					value_set_type();
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				match(T__8);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 8);
				{
				setState(134);
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
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				prefix_invocation();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				shape_invocation();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(STRING_LITERAL);
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
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
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(T__10);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				match(T__11);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				match(T__3);
				setState(147);
				match(INT_LITERAL);
				setState(148);
				match(T__4);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				match(T__3);
				setState(150);
				match(INT_LITERAL);
				setState(151);
				match(T__12);
				setState(152);
				match(INT_LITERAL);
				setState(153);
				match(T__4);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				match(T__3);
				setState(155);
				match(INT_LITERAL);
				setState(156);
				match(T__12);
				setState(157);
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
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\2\3\2\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\5\4"+
		"\64\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\5\7?\n\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\n\3\n\5\nL\n\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r_\n\r\r\r\16\r`\3\r\3\r\3\r\5"+
		"\rf\n\r\3\r\3\r\3\r\7\rk\n\r\f\r\16\rn\13\r\3\16\3\16\3\16\5\16s\n\16"+
		"\3\17\5\17v\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\7\20\u0083\n\20\f\20\16\20\u0086\13\20\3\20\3\20\5\20\u008a\n\20\3\21"+
		"\3\21\3\21\3\21\5\21\u0090\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00a1\n\22\3\22\2\3\30\23\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\3\3\2\24\25\2\u00af\2%\3\2\2"+
		"\2\4-\3\2\2\2\6\63\3\2\2\2\b\65\3\2\2\2\n8\3\2\2\2\f<\3\2\2\2\16C\3\2"+
		"\2\2\20F\3\2\2\2\22K\3\2\2\2\24M\3\2\2\2\26P\3\2\2\2\30e\3\2\2\2\32o\3"+
		"\2\2\2\34u\3\2\2\2\36\u0089\3\2\2\2 \u008f\3\2\2\2\"\u00a0\3\2\2\2$&\5"+
		"\4\3\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\2\2\3"+
		"*\3\3\2\2\2+.\5\6\4\2,.\5\20\t\2-+\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\64\5"+
		"\b\5\2\60\64\5\n\6\2\61\64\5\f\7\2\62\64\5\16\b\2\63/\3\2\2\2\63\60\3"+
		"\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\7\3\2\2\2\65\66\7\21\2\2\66\67\7"+
		"\34\2\2\67\t\3\2\2\289\7\23\2\29:\7\3\2\2:;\5\24\13\2;\13\3\2\2\2<>\7"+
		"\20\2\2=?\7\33\2\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\4\2\2AB\7\34\2\2"+
		"B\r\3\2\2\2CD\5\22\n\2DE\5\26\f\2E\17\3\2\2\2FG\7\22\2\2GH\7\34\2\2H\21"+
		"\3\2\2\2IL\5\34\17\2JL\7\34\2\2KI\3\2\2\2KJ\3\2\2\2L\23\3\2\2\2MN\7\5"+
		"\2\2NO\5\22\n\2O\25\3\2\2\2PQ\5\30\r\2Q\27\3\2\2\2RS\b\r\1\2ST\7\26\2"+
		"\2Tf\5\30\r\6Uf\5\36\20\2VW\7\6\2\2WX\5\32\16\2XY\7\7\2\2Yf\3\2\2\2Z^"+
		"\7\6\2\2[\\\5\32\16\2\\]\7\b\2\2]_\3\2\2\2^[\3\2\2\2_`\3\2\2\2`^\3\2\2"+
		"\2`a\3\2\2\2ab\3\2\2\2bc\5\32\16\2cd\7\7\2\2df\3\2\2\2eR\3\2\2\2eU\3\2"+
		"\2\2eV\3\2\2\2eZ\3\2\2\2fl\3\2\2\2gh\f\7\2\2hi\t\2\2\2ik\5\30\r\bjg\3"+
		"\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\31\3\2\2\2nl\3\2\2\2op\5\34\17\2"+
		"pr\5\36\20\2qs\5\"\22\2rq\3\2\2\2rs\3\2\2\2s\33\3\2\2\2tv\7\33\2\2ut\3"+
		"\2\2\2uv\3\2\2\2vw\3\2\2\2wx\7\4\2\2xy\7\33\2\2y\35\3\2\2\2z\u008a\7\t"+
		"\2\2{\u008a\5\34\17\2|\u008a\7\30\2\2}\u008a\7\27\2\2~\u008a\7\31\2\2"+
		"\177\u008a\7\32\2\2\u0080\u0084\7\n\2\2\u0081\u0083\5 \21\2\u0082\u0081"+
		"\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u008a\7\13\2\2\u0088\u008a\5"+
		"\24\13\2\u0089z\3\2\2\2\u0089{\3\2\2\2\u0089|\3\2\2\2\u0089}\3\2\2\2\u0089"+
		"~\3\2\2\2\u0089\177\3\2\2\2\u0089\u0080\3\2\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\37\3\2\2\2\u008b\u0090\5\34\17\2\u008c\u0090\5\24\13\2\u008d\u0090\7"+
		"\37\2\2\u008e\u0090\7\36\2\2\u008f\u008b\3\2\2\2\u008f\u008c\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090!\3\2\2\2\u0091\u00a1\7\f\2\2"+
		"\u0092\u00a1\7\r\2\2\u0093\u00a1\7\16\2\2\u0094\u0095\7\6\2\2\u0095\u0096"+
		"\7\35\2\2\u0096\u00a1\7\7\2\2\u0097\u0098\7\6\2\2\u0098\u0099\7\35\2\2"+
		"\u0099\u009a\7\17\2\2\u009a\u009b\7\35\2\2\u009b\u00a1\7\7\2\2\u009c\u009d"+
		"\7\6\2\2\u009d\u009e\7\35\2\2\u009e\u009f\7\17\2\2\u009f\u00a1\7\7\2\2"+
		"\u00a0\u0091\3\2\2\2\u00a0\u0092\3\2\2\2\u00a0\u0093\3\2\2\2\u00a0\u0094"+
		"\3\2\2\2\u00a0\u0097\3\2\2\2\u00a0\u009c\3\2\2\2\u00a1#\3\2\2\2\20\'-"+
		"\63>K`elru\u0084\u0089\u008f\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}