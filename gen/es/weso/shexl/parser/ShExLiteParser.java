// Generated from C:/Users/Usuario/Desktop/github/weso/shex-lite/src/main/java/es.weso.shexl/parser\ShExL.g4 by ANTLR 4.8
package es.weso.shexl.parser;

  import es.weso.shexl.*;
  import java.util.*;

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
		T__9=10, INT_CONSTANT=11, REAL_CONSTANT=12, CHAR_CONSTANT=13, ID=14, IRI=15, 
		SKIP_=16;
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
			null, "'PREFIX'", "':'", "'{'", "'}'", "';'", "'@:'", "'integer'", "'string'", 
			"'double'", "'long'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INT_CONSTANT", 
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

	public ShExLiteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Shex_lite_docContext extends ParserRuleContext {
		public ShExL ast;
		public Prefix_defContext prefix_def;
		public Shape_defContext shape_def;
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
			setState(37);
			match(EOF);
			((Shex_lite_docContext)_localctx).ast =  new ShExL(0,0,defs);
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
		public Definition ast;
		public Token ID;
		public Token IRI;
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
			((Prefix_defContext)_localctx).ast =  new PrefixDef((((Prefix_defContext)_localctx).IRI!=null?((Prefix_defContext)_localctx).IRI.getLine():0), (((Prefix_defContext)_localctx).IRI!=null?((Prefix_defContext)_localctx).IRI.getCharPositionInLine():0)+1, (((Prefix_defContext)_localctx).ID!=null?((Prefix_defContext)_localctx).ID.getText():null), new URI((((Prefix_defContext)_localctx).IRI!=null?((Prefix_defContext)_localctx).IRI.getLine():0), (((Prefix_defContext)_localctx).IRI!=null?((Prefix_defContext)_localctx).IRI.getCharPositionInLine():0)+1, (((Prefix_defContext)_localctx).IRI!=null?((Prefix_defContext)_localctx).IRI.getText():null)));
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
		public Definition ast;
		public Token ID;
		public Shape_bodyContext shape_body;
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
			((Shape_defContext)_localctx).ast =  new ShapeDef((((Shape_defContext)_localctx).ID!=null?((Shape_defContext)_localctx).ID.getLine():0), (((Shape_defContext)_localctx).ID!=null?((Shape_defContext)_localctx).ID.getCharPositionInLine():0)+1, (((Shape_defContext)_localctx).ID!=null?((Shape_defContext)_localctx).ID.getText():null), ((Shape_defContext)_localctx).shape_body.ast);
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
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(55);
				((Shape_bodyContext)_localctx).c1 = constraint_def();
				_localctx.ast.add(((Shape_bodyContext)_localctx).c1.ast)
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
						_localctx.ast.add(((Shape_bodyContext)_localctx).c2.ast)
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
				_localctx.ast.add(((Shape_bodyContext)_localctx).c3.ast)
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
		public Constraint $ ast;
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
			setState(71);
			contraint_id();
			setState(72);
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
			setState(74);
			prefix_inv();
			setState(75);
			match(T__1);
			setState(76);
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
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(T__5);
				setState(79);
				shape_inv();
				}
				break;
			case T__1:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				prefix_inv();
				setState(81);
				match(T__1);
				setState(82);
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
			setState(86);
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
			setState(88);
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(90);
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
			setState(93);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22b\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\6\2\35\n\2\r\2\16\2\36\3\2\3\2\3\2\6\2$\n\2\r\2"+
		"\16\2%\3\2\3\2\3\2\3\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5A\n\5\r\5\16\5B\3\5\3\5\3\5"+
		"\5\5H\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bW\n\b"+
		"\3\t\3\t\3\n\3\n\3\13\5\13^\n\13\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22"+
		"\24\26\2\3\3\2\t\f\2]\2\30\3\2\2\2\4*\3\2\2\2\6\62\3\2\2\2\bG\3\2\2\2"+
		"\nI\3\2\2\2\fL\3\2\2\2\16V\3\2\2\2\20X\3\2\2\2\22Z\3\2\2\2\24]\3\2\2\2"+
		"\26_\3\2\2\2\30\34\b\2\1\2\31\32\5\4\3\2\32\33\b\2\1\2\33\35\3\2\2\2\34"+
		"\31\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37#\3\2\2\2 !\5"+
		"\6\4\2!\"\b\2\1\2\"$\3\2\2\2# \3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&"+
		"\'\3\2\2\2\'(\7\2\2\3()\b\2\1\2)\3\3\2\2\2*,\7\3\2\2+-\7\20\2\2,+\3\2"+
		"\2\2,-\3\2\2\2-.\3\2\2\2./\7\4\2\2/\60\7\21\2\2\60\61\b\3\1\2\61\5\3\2"+
		"\2\2\62\63\7\4\2\2\63\64\7\20\2\2\64\65\7\5\2\2\65\66\5\b\5\2\66\67\7"+
		"\6\2\2\678\b\4\1\28\7\3\2\2\29:\5\n\6\2:;\b\5\1\2;H\3\2\2\2<=\5\n\6\2"+
		"=>\7\7\2\2>?\b\5\1\2?A\3\2\2\2@<\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2"+
		"CD\3\2\2\2DE\5\n\6\2EF\b\5\1\2FH\3\2\2\2G9\3\2\2\2G@\3\2\2\2H\t\3\2\2"+
		"\2IJ\5\f\7\2JK\5\16\b\2K\13\3\2\2\2LM\5\24\13\2MN\7\4\2\2NO\5\20\t\2O"+
		"\r\3\2\2\2PQ\7\b\2\2QW\5\22\n\2RS\5\24\13\2ST\7\4\2\2TU\5\26\f\2UW\3\2"+
		"\2\2VP\3\2\2\2VR\3\2\2\2W\17\3\2\2\2XY\7\20\2\2Y\21\3\2\2\2Z[\7\20\2\2"+
		"[\23\3\2\2\2\\^\7\20\2\2]\\\3\2\2\2]^\3\2\2\2^\25\3\2\2\2_`\t\2\2\2`\27"+
		"\3\2\2\2\t\36%,BGV]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}