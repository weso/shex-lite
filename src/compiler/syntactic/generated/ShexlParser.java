/*
 * Short version for non-lawyers:
 *
 * The ShEx Lite Project is dual-licensed under GNU 3.0 and
 * MIT terms.
 *
 * Longer version:
 *
 * Copyrights in the ShEx Lite project are retained by their contributors. No
 * copyright assignment is required to contribute to the ShEx Lite project.
 *
 * Some files include explicit copyright notices and/or license notices.
 * For full authorship information, see the version control history.
 *
 * Except as otherwise noted (below and/or in individual files), ShEx Lite is
 * licensed under the GNU, Version 3.0 <LICENSE-GNU> or
 * <https://choosealicense.com/licenses/gpl-3.0/> or the MIT license
 * <LICENSE-MIT> or <http://opensource.org/licenses/MIT>, at your option.
 *
 * The ShEx Lite Project includes packages written by third parties.
 */

// Generated from C:/Users/Willy/Documents/github/thewilly/shex-lite/src/compiler/grammar\Shexl.g4 by ANTLR 4.8
package compiler.syntactic.generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShexlParser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, PREFIX_KW = 14, BASE_KW = 15, IMPORT_KW = 16,
            START_KW = 17, AND_KW = 18, OR_KW = 19, NOT_KW = 20, IRI_KW = 21, LITERAL_KW = 22,
            BNODE_KW = 23, NON_LITERAL_KW = 24, CLOSED_KW = 25, A_KW = 26, LABEL = 27, ID = 28,
            IRI = 29, INT_LITERAL = 30, REAL_LITERAL = 31, STRING_LITERAL = 32, SKIP_ = 33;
    public static final int
            RULE_schema = 0, RULE_statement = 1, RULE_definition_statement = 2, RULE_base_definition = 3,
            RULE_start_definition = 4, RULE_prefix_definition = 5, RULE_shape_definition = 6,
            RULE_import_statement = 7, RULE_shape_name = 8, RULE_shape_invocation = 9,
            RULE_constraint = 10, RULE_triple_constraint = 11, RULE_node_constraint = 12,
            RULE_value_set_type = 13, RULE_cardinality = 14;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u008c\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2\"\n\2\r\2\16" +
                    "\2#\3\2\3\2\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\5\4\60\n\4\3\5\3\5\3\5\3" +
                    "\6\3\6\3\6\3\6\3\7\3\7\5\7;\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3" +
                    "\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f" +
                    "V\n\f\r\f\16\fW\3\f\3\f\3\f\5\f]\n\f\3\r\3\r\3\r\5\rb\n\r\3\16\3\16\3" +
                    "\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16m\n\16\f\16\16\16p\13\16\3\16\5" +
                    "\16s\n\16\3\17\3\17\3\17\3\17\5\17y\n\17\3\20\3\20\3\20\3\20\3\20\3\20" +
                    "\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u008a\n\20\3\20\2\2" +
                    "\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\3\2\36\37\4\2\34\34\36" +
                    "\36\2\u0097\2!\3\2\2\2\4)\3\2\2\2\6/\3\2\2\2\b\61\3\2\2\2\n\64\3\2\2\2" +
                    "\f8\3\2\2\2\16?\3\2\2\2\20B\3\2\2\2\22E\3\2\2\2\24G\3\2\2\2\26\\\3\2\2" +
                    "\2\30^\3\2\2\2\32r\3\2\2\2\34x\3\2\2\2\36\u0089\3\2\2\2 \"\5\4\3\2! \3" +
                    "\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7\2\2\3&\3\3\2\2\2\'" +
                    "*\5\6\4\2(*\5\20\t\2)\'\3\2\2\2)(\3\2\2\2*\5\3\2\2\2+\60\5\b\5\2,\60\5" +
                    "\n\6\2-\60\5\f\7\2.\60\5\16\b\2/+\3\2\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2" +
                    "\2\60\7\3\2\2\2\61\62\7\21\2\2\62\63\7\37\2\2\63\t\3\2\2\2\64\65\7\23" +
                    "\2\2\65\66\7\3\2\2\66\67\5\24\13\2\67\13\3\2\2\28:\7\20\2\29;\7\35\2\2" +
                    ":9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\4\2\2=>\7\37\2\2>\r\3\2\2\2?@\5\22" +
                    "\n\2@A\5\26\f\2A\17\3\2\2\2BC\7\22\2\2CD\7\37\2\2D\21\3\2\2\2EF\t\2\2" +
                    "\2F\23\3\2\2\2GH\7\5\2\2HI\5\22\n\2I\25\3\2\2\2JK\7\33\2\2K]\5\26\f\2" +
                    "L]\5\32\16\2MN\7\6\2\2NO\5\30\r\2OP\7\7\2\2P]\3\2\2\2QU\7\6\2\2RS\5\30" +
                    "\r\2ST\7\b\2\2TV\3\2\2\2UR\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2" +
                    "\2\2YZ\5\30\r\2Z[\7\7\2\2[]\3\2\2\2\\J\3\2\2\2\\L\3\2\2\2\\M\3\2\2\2\\" +
                    "Q\3\2\2\2]\27\3\2\2\2^_\t\3\2\2_a\5\32\16\2`b\5\36\20\2a`\3\2\2\2ab\3" +
                    "\2\2\2b\31\3\2\2\2cs\7\t\2\2ds\5\24\13\2es\7\36\2\2fs\7\30\2\2gs\7\27" +
                    "\2\2hs\7\31\2\2is\7\32\2\2jn\7\n\2\2km\5\34\17\2lk\3\2\2\2mp\3\2\2\2n" +
                    "l\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qs\7\13\2\2rc\3\2\2\2rd\3\2\2\2" +
                    "re\3\2\2\2rf\3\2\2\2rg\3\2\2\2rh\3\2\2\2ri\3\2\2\2rj\3\2\2\2s\33\3\2\2" +
                    "\2ty\7\36\2\2uy\5\24\13\2vy\7\"\2\2wy\7!\2\2xt\3\2\2\2xu\3\2\2\2xv\3\2" +
                    "\2\2xw\3\2\2\2y\35\3\2\2\2z\u008a\7\f\2\2{\u008a\7\r\2\2|\u008a\7\16\2" +
                    "\2}~\7\6\2\2~\177\7 \2\2\177\u008a\7\7\2\2\u0080\u0081\7\6\2\2\u0081\u0082" +
                    "\7 \2\2\u0082\u0083\7\17\2\2\u0083\u0084\7 \2\2\u0084\u008a\7\7\2\2\u0085" +
                    "\u0086\7\6\2\2\u0086\u0087\7 \2\2\u0087\u0088\7\17\2\2\u0088\u008a\7\7" +
                    "\2\2\u0089z\3\2\2\2\u0089{\3\2\2\2\u0089|\3\2\2\2\u0089}\3\2\2\2\u0089" +
                    "\u0080\3\2\2\2\u0089\u0085\3\2\2\2\u008a\37\3\2\2\2\r#)/:W\\anrx\u0089";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public ShexlParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "schema", "statement", "definition_statement", "base_definition", "start_definition",
                "prefix_definition", "shape_definition", "import_statement", "shape_name",
                "shape_invocation", "constraint", "triple_constraint", "node_constraint",
                "value_set_type", "cardinality"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'='", "':'", "'@'", "'{'", "'}'", "';'", "'.'", "'['", "']'",
                "'*'", "'+'", "'?'", "','", "'PREFIX'", "'BASE'", "'IMPORT'", "'START'",
                "'AND'", "'OR'", "'NOT'", "'IRI'", "'LITERAL'", "'BNODE'", "'NONLITERAL'",
                "'CLOSED'", "'a'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, "PREFIX_KW", "BASE_KW", "IMPORT_KW", "START_KW", "AND_KW",
                "OR_KW", "NOT_KW", "IRI_KW", "LITERAL_KW", "BNODE_KW", "NON_LITERAL_KW",
                "CLOSED_KW", "A_KW", "LABEL", "ID", "IRI", "INT_LITERAL", "REAL_LITERAL",
                "STRING_LITERAL", "SKIP_"
        };
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
    public String getGrammarFileName() {
        return "Shexl.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final SchemaContext schema() throws RecognitionException {
        SchemaContext _localctx = new SchemaContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_schema);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(31);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(30);
                            statement();
                        }
                    }
                    setState(33);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX_KW) | (1L << BASE_KW) | (1L << IMPORT_KW) | (1L << START_KW) | (1L << ID) | (1L << IRI))) != 0));
                setState(35);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_statement);
        try {
            setState(39);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case PREFIX_KW:
                case BASE_KW:
                case START_KW:
                case ID:
                case IRI:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(37);
                    definition_statement();
                }
                break;
                case IMPORT_KW:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(38);
                    import_statement();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Definition_statementContext definition_statement() throws RecognitionException {
        Definition_statementContext _localctx = new Definition_statementContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_definition_statement);
        try {
            setState(45);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case BASE_KW:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(41);
                    base_definition();
                }
                break;
                case START_KW:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(42);
                    start_definition();
                }
                break;
                case PREFIX_KW:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(43);
                    prefix_definition();
                }
                break;
                case ID:
                case IRI:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(44);
                    shape_definition();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Base_definitionContext base_definition() throws RecognitionException {
        Base_definitionContext _localctx = new Base_definitionContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_base_definition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(47);
                match(BASE_KW);
                setState(48);
                match(IRI);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Start_definitionContext start_definition() throws RecognitionException {
        Start_definitionContext _localctx = new Start_definitionContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_start_definition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(50);
                match(START_KW);
                setState(51);
                match(T__0);
                setState(52);
                shape_invocation();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Prefix_definitionContext prefix_definition() throws RecognitionException {
        Prefix_definitionContext _localctx = new Prefix_definitionContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_prefix_definition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(54);
                match(PREFIX_KW);
                setState(56);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LABEL) {
                    {
                        setState(55);
                        match(LABEL);
                    }
                }

                setState(58);
                match(T__1);
                setState(59);
                match(IRI);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Shape_definitionContext shape_definition() throws RecognitionException {
        Shape_definitionContext _localctx = new Shape_definitionContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_shape_definition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(61);
                shape_name();
                setState(62);
                constraint();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Import_statementContext import_statement() throws RecognitionException {
        Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_import_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(64);
                match(IMPORT_KW);
                setState(65);
                match(IRI);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Shape_nameContext shape_name() throws RecognitionException {
        Shape_nameContext _localctx = new Shape_nameContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_shape_name);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(67);
                _la = _input.LA(1);
                if (!(_la == ID || _la == IRI)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Shape_invocationContext shape_invocation() throws RecognitionException {
        Shape_invocationContext _localctx = new Shape_invocationContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_shape_invocation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(69);
                match(T__2);
                setState(70);
                shape_name();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConstraintContext constraint() throws RecognitionException {
        ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_constraint);
        try {
            int _alt;
            setState(90);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(72);
                    match(CLOSED_KW);
                    setState(73);
                    constraint();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(74);
                    node_constraint();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(75);
                    match(T__3);
                    setState(76);
                    triple_constraint();
                    setState(77);
                    match(T__4);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(79);
                    match(T__3);
                    setState(83);
                    _errHandler.sync(this);
                    _alt = 1;
                    do {
                        switch (_alt) {
                            case 1: {
                                {
                                    setState(80);
                                    triple_constraint();
                                    setState(81);
                                    match(T__5);
                                }
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(85);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                    setState(87);
                    triple_constraint();
                    setState(88);
                    match(T__4);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Triple_constraintContext triple_constraint() throws RecognitionException {
        Triple_constraintContext _localctx = new Triple_constraintContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_triple_constraint);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(92);
                _la = _input.LA(1);
                if (!(_la == A_KW || _la == ID)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(93);
                node_constraint();
                setState(95);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
                    {
                        setState(94);
                        cardinality();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Node_constraintContext node_constraint() throws RecognitionException {
        Node_constraintContext _localctx = new Node_constraintContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_node_constraint);
        int _la;
        try {
            setState(112);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__6:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(97);
                    match(T__6);
                }
                break;
                case T__2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(98);
                    shape_invocation();
                }
                break;
                case ID:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(99);
                    match(ID);
                }
                break;
                case LITERAL_KW:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(100);
                    match(LITERAL_KW);
                }
                break;
                case IRI_KW:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(101);
                    match(IRI_KW);
                }
                break;
                case BNODE_KW:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(102);
                    match(BNODE_KW);
                }
                break;
                case NON_LITERAL_KW:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(103);
                    match(NON_LITERAL_KW);
                }
                break;
                case T__7:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(104);
                    match(T__7);
                    setState(108);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << ID) | (1L << REAL_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
                        {
                            {
                                setState(105);
                                value_set_type();
                            }
                        }
                        setState(110);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(111);
                    match(T__8);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Value_set_typeContext value_set_type() throws RecognitionException {
        Value_set_typeContext _localctx = new Value_set_typeContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_value_set_type);
        try {
            setState(118);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case ID:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(114);
                    match(ID);
                }
                break;
                case T__2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(115);
                    shape_invocation();
                }
                break;
                case STRING_LITERAL:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(116);
                    match(STRING_LITERAL);
                }
                break;
                case REAL_LITERAL:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(117);
                    match(REAL_LITERAL);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CardinalityContext cardinality() throws RecognitionException {
        CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_cardinality);
        try {
            setState(135);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(120);
                    match(T__9);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(121);
                    match(T__10);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(122);
                    match(T__11);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(123);
                    match(T__3);
                    setState(124);
                    ((CardinalityContext) _localctx).min = match(INT_LITERAL);
                    setState(125);
                    match(T__4);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(126);
                    match(T__3);
                    setState(127);
                    ((CardinalityContext) _localctx).min = match(INT_LITERAL);
                    setState(128);
                    match(T__12);
                    setState(129);
                    ((CardinalityContext) _localctx).max = match(INT_LITERAL);
                    setState(130);
                    match(T__4);
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(131);
                    match(T__3);
                    setState(132);
                    ((CardinalityContext) _localctx).min = match(INT_LITERAL);
                    setState(133);
                    match(T__12);
                    setState(134);
                    match(T__4);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SchemaContext extends ParserRuleContext {
        public SchemaContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode EOF() {
            return getToken(ShexlParser.EOF, 0);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_schema;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterSchema(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitSchema(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor) return ((ShexlVisitor<? extends T>) visitor).visitSchema(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StatementContext extends ParserRuleContext {
        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Definition_statementContext definition_statement() {
            return getRuleContext(Definition_statementContext.class, 0);
        }

        public Import_statementContext import_statement() {
            return getRuleContext(Import_statementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor) return ((ShexlVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Definition_statementContext extends ParserRuleContext {
        public Definition_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Base_definitionContext base_definition() {
            return getRuleContext(Base_definitionContext.class, 0);
        }

        public Start_definitionContext start_definition() {
            return getRuleContext(Start_definitionContext.class, 0);
        }

        public Prefix_definitionContext prefix_definition() {
            return getRuleContext(Prefix_definitionContext.class, 0);
        }

        public Shape_definitionContext shape_definition() {
            return getRuleContext(Shape_definitionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_definition_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterDefinition_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitDefinition_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitDefinition_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Base_definitionContext extends ParserRuleContext {
        public Base_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BASE_KW() {
            return getToken(ShexlParser.BASE_KW, 0);
        }

        public TerminalNode IRI() {
            return getToken(ShexlParser.IRI, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_base_definition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterBase_definition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitBase_definition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitBase_definition(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Start_definitionContext extends ParserRuleContext {
        public Start_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode START_KW() {
            return getToken(ShexlParser.START_KW, 0);
        }

        public Shape_invocationContext shape_invocation() {
            return getRuleContext(Shape_invocationContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_start_definition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterStart_definition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitStart_definition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitStart_definition(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Prefix_definitionContext extends ParserRuleContext {
        public Prefix_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PREFIX_KW() {
            return getToken(ShexlParser.PREFIX_KW, 0);
        }

        public TerminalNode IRI() {
            return getToken(ShexlParser.IRI, 0);
        }

        public TerminalNode LABEL() {
            return getToken(ShexlParser.LABEL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prefix_definition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterPrefix_definition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitPrefix_definition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitPrefix_definition(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Shape_definitionContext extends ParserRuleContext {
        public Shape_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Shape_nameContext shape_name() {
            return getRuleContext(Shape_nameContext.class, 0);
        }

        public ConstraintContext constraint() {
            return getRuleContext(ConstraintContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_shape_definition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterShape_definition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitShape_definition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitShape_definition(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Import_statementContext extends ParserRuleContext {
        public Import_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode IMPORT_KW() {
            return getToken(ShexlParser.IMPORT_KW, 0);
        }

        public TerminalNode IRI() {
            return getToken(ShexlParser.IRI, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_import_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterImport_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitImport_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitImport_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Shape_nameContext extends ParserRuleContext {
        public Shape_nameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(ShexlParser.ID, 0);
        }

        public TerminalNode IRI() {
            return getToken(ShexlParser.IRI, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_shape_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterShape_name(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitShape_name(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor) return ((ShexlVisitor<? extends T>) visitor).visitShape_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Shape_invocationContext extends ParserRuleContext {
        public Shape_invocationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Shape_nameContext shape_name() {
            return getRuleContext(Shape_nameContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_shape_invocation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterShape_invocation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitShape_invocation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitShape_invocation(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ConstraintContext extends ParserRuleContext {
        public ConstraintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode CLOSED_KW() {
            return getToken(ShexlParser.CLOSED_KW, 0);
        }

        public ConstraintContext constraint() {
            return getRuleContext(ConstraintContext.class, 0);
        }

        public Node_constraintContext node_constraint() {
            return getRuleContext(Node_constraintContext.class, 0);
        }

        public List<Triple_constraintContext> triple_constraint() {
            return getRuleContexts(Triple_constraintContext.class);
        }

        public Triple_constraintContext triple_constraint(int i) {
            return getRuleContext(Triple_constraintContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constraint;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterConstraint(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitConstraint(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor) return ((ShexlVisitor<? extends T>) visitor).visitConstraint(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Triple_constraintContext extends ParserRuleContext {
        public Triple_constraintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Node_constraintContext node_constraint() {
            return getRuleContext(Node_constraintContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(ShexlParser.ID, 0);
        }

        public TerminalNode A_KW() {
            return getToken(ShexlParser.A_KW, 0);
        }

        public CardinalityContext cardinality() {
            return getRuleContext(CardinalityContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_triple_constraint;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterTriple_constraint(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitTriple_constraint(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitTriple_constraint(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Node_constraintContext extends ParserRuleContext {
        public Node_constraintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Shape_invocationContext shape_invocation() {
            return getRuleContext(Shape_invocationContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(ShexlParser.ID, 0);
        }

        public TerminalNode LITERAL_KW() {
            return getToken(ShexlParser.LITERAL_KW, 0);
        }

        public TerminalNode IRI_KW() {
            return getToken(ShexlParser.IRI_KW, 0);
        }

        public TerminalNode BNODE_KW() {
            return getToken(ShexlParser.BNODE_KW, 0);
        }

        public TerminalNode NON_LITERAL_KW() {
            return getToken(ShexlParser.NON_LITERAL_KW, 0);
        }

        public List<Value_set_typeContext> value_set_type() {
            return getRuleContexts(Value_set_typeContext.class);
        }

        public Value_set_typeContext value_set_type(int i) {
            return getRuleContext(Value_set_typeContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_node_constraint;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterNode_constraint(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitNode_constraint(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor)
                return ((ShexlVisitor<? extends T>) visitor).visitNode_constraint(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Value_set_typeContext extends ParserRuleContext {
        public Value_set_typeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(ShexlParser.ID, 0);
        }

        public Shape_invocationContext shape_invocation() {
            return getRuleContext(Shape_invocationContext.class, 0);
        }

        public TerminalNode STRING_LITERAL() {
            return getToken(ShexlParser.STRING_LITERAL, 0);
        }

        public TerminalNode REAL_LITERAL() {
            return getToken(ShexlParser.REAL_LITERAL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_value_set_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterValue_set_type(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitValue_set_type(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor) return ((ShexlVisitor<? extends T>) visitor).visitValue_set_type(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CardinalityContext extends ParserRuleContext {
        public Token min;
        public Token max;

        public CardinalityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> INT_LITERAL() {
            return getTokens(ShexlParser.INT_LITERAL);
        }

        public TerminalNode INT_LITERAL(int i) {
            return getToken(ShexlParser.INT_LITERAL, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cardinality;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).enterCardinality(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ShexlListener) ((ShexlListener) listener).exitCardinality(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ShexlVisitor) return ((ShexlVisitor<? extends T>) visitor).visitCardinality(this);
            else return visitor.visitChildren(this);
        }
    }
}