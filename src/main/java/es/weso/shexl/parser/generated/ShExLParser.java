// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/main/java/es/weso/shexl/parser\ShExL.g4 by ANTLR 4.8
package es.weso.shexl.parser.generated;

import es.weso.shexl.ast.*;
import java.util.*;
import java.lang.String;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShExLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		INT_CONSTANT=10, REAL_CONSTANT=11, CHAR_CONSTANT=12, ID=13, IRI=14, SKIP_=15;
	public static final int
		RULE_shex_lite_doc = 0, RULE_prefix_def = 1, RULE_shape_def = 2, RULE_shape_body = 3, 
		RULE_constraint_def = 4, RULE_constraint_field = 5, RULE_constraint_type = 6, 
		RULE_property_def = 7, RULE_shape_inv = 8, RULE_prefix_inv = 9, RULE_primitive_type = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"shex_lite_doc", "prefix_def", "shape_def", "shape_body", "constraint_def", 
			"constraint_field", "constraint_type", "property_def", "shape_inv", "prefix_inv", 
			"primitive_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PREFIX'", "':'", "'{'", "'}'", "';'", "'@'", "'integer'", "'string'", 
			"'double'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "INT_CONSTANT", 
			"REAL_CONSTANT", "CHAR_CONSTANT", "ID", "IRI", "SKIP_"
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
	public String getGrammarFileName() { return "ShExL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShExLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Shex_lite_docContext extends ParserRuleContext {
		public ShExL ast;
		public Prefix_defContext prefix_def;
		public Shape_defContext shape_def;
		public TerminalNode EOF() { return getToken(ShExLParser.EOF, 0); }
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
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterShex_lite_doc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitShex_lite_doc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitShex_lite_doc(this);
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
			List<Definition> defs = new ArrayList<Definition>();
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				((Shex_lite_docContext)_localctx).prefix_def = prefix_def();
				defs.add(((Shex_lite_docContext)_localctx).prefix_def.ast);
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				((Shex_lite_docContext)_localctx).shape_def = shape_def();
				defs.add(((Shex_lite_docContext)_localctx).shape_def.ast);
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			((Shex_lite_docContext)_localctx).ast =  new ShExL(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), defs);
			setState(38);
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
		public PrefixDef ast;
		public Token ID;
		public Token IRI;
		public TerminalNode IRI() { return getToken(ShExLParser.IRI, 0); }
		public TerminalNode ID() { return getToken(ShExLParser.ID, 0); }
		public Prefix_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterPrefix_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitPrefix_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitPrefix_def(this);
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
			setState(40);
			match(T__0);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(41);
				((Prefix_defContext)_localctx).ID = match(ID);
				}
			}

			setState(44);
			match(T__1);
			setState(45);
			((Prefix_defContext)_localctx).IRI = match(IRI);
			((Prefix_defContext)_localctx).ast =  new PrefixDef(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), (((Prefix_defContext)_localctx).ID!=null?((Prefix_defContext)_localctx).ID.getText():null), new URL(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), (((Prefix_defContext)_localctx).IRI!=null?((Prefix_defContext)_localctx).IRI.getText():null)));
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
		public ShapeDef ast;
		public Token ID;
		public Shape_bodyContext shape_body;
		public TerminalNode ID() { return getToken(ShExLParser.ID, 0); }
		public Shape_bodyContext shape_body() {
			return getRuleContext(Shape_bodyContext.class,0);
		}
		public Shape_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterShape_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitShape_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitShape_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_defContext shape_def() throws RecognitionException {
		Shape_defContext _localctx = new Shape_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_shape_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__1);
			setState(49);
			((Shape_defContext)_localctx).ID = match(ID);
			setState(50);
			match(T__2);
			setState(51);
			((Shape_defContext)_localctx).shape_body = shape_body();
			setState(52);
			match(T__3);
			((Shape_defContext)_localctx).ast =  new ShapeDef(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), (((Shape_defContext)_localctx).ID!=null?((Shape_defContext)_localctx).ID.getText():null), ((Shape_defContext)_localctx).shape_body.ast);
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
		public List<Constraint> ast = new ArrayList<Constraint>();
		public Constraint_defContext c1;
		public Constraint_defContext c2;
		public Constraint_defContext c3;
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
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterShape_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitShape_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitShape_body(this);
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
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(55);
				((Shape_bodyContext)_localctx).c1 = constraint_def();
				_localctx.ast.add(((Shape_bodyContext)_localctx).c1.ast);
				}
				break;
			case 2:
				{
				setState(62); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(58);
						((Shape_bodyContext)_localctx).c2 = constraint_def();
						setState(59);
						match(T__4);
						_localctx.ast.add(((Shape_bodyContext)_localctx).c2.ast);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(64); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(66);
				((Shape_bodyContext)_localctx).c3 = constraint_def();
				_localctx.ast.add(((Shape_bodyContext)_localctx).c3.ast);
				}
				break;
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

	public static class Constraint_defContext extends ParserRuleContext {
		public Constraint ast;
		public Constraint_fieldContext constraint_field;
		public Constraint_typeContext constraint_type;
		public Constraint_fieldContext constraint_field() {
			return getRuleContext(Constraint_fieldContext.class,0);
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
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterConstraint_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitConstraint_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitConstraint_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_defContext constraint_def() throws RecognitionException {
		Constraint_defContext _localctx = new Constraint_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constraint_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((Constraint_defContext)_localctx).constraint_field = constraint_field();
			setState(72);
			((Constraint_defContext)_localctx).constraint_type = constraint_type();
			((Constraint_defContext)_localctx).ast =  new Constraint(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), ((Constraint_defContext)_localctx).constraint_field.ast, ((Constraint_defContext)_localctx).constraint_type.ast);
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

	public static class Constraint_fieldContext extends ParserRuleContext {
		public FieldConstraint ast;
		public Prefix_invContext prefix_inv;
		public Property_defContext property_def;
		public Prefix_invContext prefix_inv() {
			return getRuleContext(Prefix_invContext.class,0);
		}
		public Property_defContext property_def() {
			return getRuleContext(Property_defContext.class,0);
		}
		public Constraint_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterConstraint_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitConstraint_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitConstraint_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_fieldContext constraint_field() throws RecognitionException {
		Constraint_fieldContext _localctx = new Constraint_fieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constraint_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			((Constraint_fieldContext)_localctx).prefix_inv = prefix_inv();
			setState(76);
			match(T__1);
			setState(77);
			((Constraint_fieldContext)_localctx).property_def = property_def();
			((Constraint_fieldContext)_localctx).ast =  new FieldConstraint(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), new PrefixInv(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), ((Constraint_fieldContext)_localctx).prefix_inv.ast.prefixName(), ((Constraint_fieldContext)_localctx).property_def.ast));
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
		public TypeConstraint ast;
		public Prefix_invContext prefix_inv;
		public Primitive_typeContext primitive_type;
		public Shape_invContext shape_inv;
		public Prefix_invContext prefix_inv() {
			return getRuleContext(Prefix_invContext.class,0);
		}
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public Shape_invContext shape_inv() {
			return getRuleContext(Shape_invContext.class,0);
		}
		public Constraint_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterConstraint_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitConstraint_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitConstraint_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constraint_typeContext constraint_type() throws RecognitionException {
		Constraint_typeContext _localctx = new Constraint_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constraint_type);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((Constraint_typeContext)_localctx).prefix_inv = prefix_inv();
				setState(81);
				match(T__1);
				setState(82);
				((Constraint_typeContext)_localctx).primitive_type = primitive_type();
				((Constraint_typeContext)_localctx).ast =  new TypeConstraint(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), new PrefixInv(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), ((Constraint_typeContext)_localctx).prefix_inv.ast.prefixName(), ((Constraint_typeContext)_localctx).primitive_type.ast));
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(T__5);
				setState(86);
				match(T__1);
				setState(87);
				((Constraint_typeContext)_localctx).shape_inv = shape_inv();
				((Constraint_typeContext)_localctx).ast =  new TypeConstraint(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), new ShapeInv(_localctx.start.getLine(), _localctx.start.getCharPositionInLine(), ((Constraint_typeContext)_localctx).shape_inv.ast.shapeName()));
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
		public String ast;
		public Token ID;
		public TerminalNode ID() { return getToken(ShExLParser.ID, 0); }
		public Property_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterProperty_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitProperty_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitProperty_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Property_defContext property_def() throws RecognitionException {
		Property_defContext _localctx = new Property_defContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_property_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((Property_defContext)_localctx).ID = match(ID);
			((Property_defContext)_localctx).ast =  (((Property_defContext)_localctx).ID!=null?((Property_defContext)_localctx).ID.getText():null);
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
		public ShapeInv ast;
		public Token ID;
		public TerminalNode ID() { return getToken(ShExLParser.ID, 0); }
		public Shape_invContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_inv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterShape_inv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitShape_inv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitShape_inv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_invContext shape_inv() throws RecognitionException {
		Shape_invContext _localctx = new Shape_invContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_shape_inv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((Shape_invContext)_localctx).ID = match(ID);
			((Shape_invContext)_localctx).ast =  new ShapeInv((((Shape_invContext)_localctx).ID!=null?((Shape_invContext)_localctx).ID.getLine():0), (((Shape_invContext)_localctx).ID!=null?((Shape_invContext)_localctx).ID.getCharPositionInLine():0)+1, (((Shape_invContext)_localctx).ID!=null?((Shape_invContext)_localctx).ID.getText():null));
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
		public PrefixInv ast;
		public Token ID;
		public TerminalNode ID() { return getToken(ShExLParser.ID, 0); }
		public Prefix_invContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_inv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterPrefix_inv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitPrefix_inv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitPrefix_inv(this);
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
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(98);
				((Prefix_invContext)_localctx).ID = match(ID);
				}
			}

			((Prefix_invContext)_localctx).ast =  new PrefixInv((((Prefix_invContext)_localctx).ID!=null?((Prefix_invContext)_localctx).ID.getLine():0), (((Prefix_invContext)_localctx).ID!=null?((Prefix_invContext)_localctx).ID.getCharPositionInLine():0)+1, (((Prefix_invContext)_localctx).ID!=null?((Prefix_invContext)_localctx).ID.getText():null), "");
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
		public String ast;
		public Primitive_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).enterPrimitive_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExLListener ) ((ShExLListener)listener).exitPrimitive_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExLVisitor ) return ((ShExLVisitor<? extends T>)visitor).visitPrimitive_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_typeContext primitive_type() throws RecognitionException {
		Primitive_typeContext _localctx = new Primitive_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primitive_type);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(T__6);
				((Primitive_typeContext)_localctx).ast =  "INTEGER";
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(T__7);
				((Primitive_typeContext)_localctx).ast =  "STRING";
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				match(T__8);
				((Primitive_typeContext)_localctx).ast =  "DOUBLE";
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21r\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\6\2\35\n\2\r\2\16\2\36\3\2\3\2\3\2\6\2$\n\2\r\2"+
		"\16\2%\3\2\3\2\3\2\3\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5A\n\5\r\5\16\5B\3\5\3\5\3\5"+
		"\5\5H\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\5\13f\n\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\fp\n\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22"+
		"\24\26\2\2\2o\2\30\3\2\2\2\4*\3\2\2\2\6\62\3\2\2\2\bG\3\2\2\2\nI\3\2\2"+
		"\2\fM\3\2\2\2\16\\\3\2\2\2\20^\3\2\2\2\22a\3\2\2\2\24e\3\2\2\2\26o\3\2"+
		"\2\2\30\34\b\2\1\2\31\32\5\4\3\2\32\33\b\2\1\2\33\35\3\2\2\2\34\31\3\2"+
		"\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37#\3\2\2\2 !\5\6\4\2!"+
		"\"\b\2\1\2\"$\3\2\2\2# \3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2"+
		"\2\'(\b\2\1\2()\7\2\2\3)\3\3\2\2\2*,\7\3\2\2+-\7\17\2\2,+\3\2\2\2,-\3"+
		"\2\2\2-.\3\2\2\2./\7\4\2\2/\60\7\20\2\2\60\61\b\3\1\2\61\5\3\2\2\2\62"+
		"\63\7\4\2\2\63\64\7\17\2\2\64\65\7\5\2\2\65\66\5\b\5\2\66\67\7\6\2\2\67"+
		"8\b\4\1\28\7\3\2\2\29:\5\n\6\2:;\b\5\1\2;H\3\2\2\2<=\5\n\6\2=>\7\7\2\2"+
		">?\b\5\1\2?A\3\2\2\2@<\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2"+
		"DE\5\n\6\2EF\b\5\1\2FH\3\2\2\2G9\3\2\2\2G@\3\2\2\2H\t\3\2\2\2IJ\5\f\7"+
		"\2JK\5\16\b\2KL\b\6\1\2L\13\3\2\2\2MN\5\24\13\2NO\7\4\2\2OP\5\20\t\2P"+
		"Q\b\7\1\2Q\r\3\2\2\2RS\5\24\13\2ST\7\4\2\2TU\5\26\f\2UV\b\b\1\2V]\3\2"+
		"\2\2WX\7\b\2\2XY\7\4\2\2YZ\5\22\n\2Z[\b\b\1\2[]\3\2\2\2\\R\3\2\2\2\\W"+
		"\3\2\2\2]\17\3\2\2\2^_\7\17\2\2_`\b\t\1\2`\21\3\2\2\2ab\7\17\2\2bc\b\n"+
		"\1\2c\23\3\2\2\2df\7\17\2\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\b\13\1\2h"+
		"\25\3\2\2\2ij\7\t\2\2jp\b\f\1\2kl\7\n\2\2lp\b\f\1\2mn\7\13\2\2np\b\f\1"+
		"\2oi\3\2\2\2ok\3\2\2\2om\3\2\2\2p\27\3\2\2\2\n\36%,BG\\eo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}