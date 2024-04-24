// Generated from C:/Users/ASUS/Documents/Lab1typescript/Compiladores/src/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		IF=18, THEN=19, ELSE=20, NOTEQUAL=21, EQUAL=22, GREATEREQUAL=23, MINOREQUAL=24, 
		GREATER=25, MINOR=26, SUB=27, ADD=28, RESTDIV=29, DIV=30, MULT=31, NOT=32, 
		OR=33, AND=34, FALSE=35, TRUE=36, INT=37, DOUBLE=38, STRING=39, NOME=40, 
		SL_COMMENT=41, ML_COMMENT=42, WS=43;
	public static final int
		RULE_program = 0, RULE_instrucao = 1, RULE_print = 2, RULE_whileState = 3, 
		RULE_forState = 4, RULE_ifState = 5, RULE_empty = 6, RULE_break = 7, RULE_tiposNoCodigo = 8, 
		RULE_types = 9, RULE_declaracao = 10, RULE_bloco = 11, RULE_exp = 12, 
		RULE_variaveis = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instrucao", "print", "whileState", "forState", "ifState", 
			"empty", "break", "tiposNoCodigo", "types", "declaracao", "bloco", "exp", 
			"variaveis"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'print'", "'while'", "'do'", "'for'", "'to'", "'break'", 
			"','", "'int'", "'double'", "'boolean'", "'string'", "'begin'", "'end'", 
			"'('", "')'", "'if'", "'then'", "'else'", "'!='", "'=='", "'>='", "'<='", 
			"'>'", "'<'", "'-'", "'+'", "'%'", "'/'", "'*'", "'not'", "'or'", "'and'", 
			"'false'", "'true'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "IF", "THEN", "ELSE", "NOTEQUAL", 
			"EQUAL", "GREATEREQUAL", "MINOREQUAL", "GREATER", "MINOR", "SUB", "ADD", 
			"RESTDIV", "DIV", "MULT", "NOT", "OR", "AND", "FALSE", "TRUE", "INT", 
			"DOUBLE", "STRING", "NOME", "SL_COMMENT", "ML_COMMENT", "WS"
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
	public String getGrammarFileName() { return "Sol.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SolParser.EOF, 0); }
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1099511922010L) != 0)) {
				{
				{
				setState(28);
				instrucao();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstrucaoContext extends ParserRuleContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public WhileStateContext whileState() {
			return getRuleContext(WhileStateContext.class,0);
		}
		public ForStateContext forState() {
			return getRuleContext(ForStateContext.class,0);
		}
		public IfStateContext ifState() {
			return getRuleContext(IfStateContext.class,0);
		}
		public EmptyContext empty() {
			return getRuleContext(EmptyContext.class,0);
		}
		public BreakContext break_() {
			return getRuleContext(BreakContext.class,0);
		}
		public TiposNoCodigoContext tiposNoCodigo() {
			return getRuleContext(TiposNoCodigoContext.class,0);
		}
		public TerminalNode NOME() { return getToken(SolParser.NOME, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InstrucaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterInstrucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitInstrucao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitInstrucao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrucaoContext instrucao() throws RecognitionException {
		InstrucaoContext _localctx = new InstrucaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucao);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				print();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				bloco();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				whileState();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				forState();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				ifState();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				empty();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				break_();
				}
				break;
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 8);
				{
				setState(43);
				tiposNoCodigo();
				setState(44);
				match(T__0);
				}
				break;
			case NOME:
				enterOuterAlt(_localctx, 9);
				{
				setState(46);
				match(NOME);
				setState(47);
				match(T__1);
				setState(48);
				exp(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__2);
			setState(52);
			exp(0);
			setState(53);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStateContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InstrucaoContext instrucao() {
			return getRuleContext(InstrucaoContext.class,0);
		}
		public WhileStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileState; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterWhileState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitWhileState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitWhileState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStateContext whileState() throws RecognitionException {
		WhileStateContext _localctx = new WhileStateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whileState);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__3);
			setState(56);
			exp(0);
			setState(57);
			match(T__4);
			setState(58);
			instrucao();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStateContext extends ParserRuleContext {
		public List<TerminalNode> NOME() { return getTokens(SolParser.NOME); }
		public TerminalNode NOME(int i) {
			return getToken(SolParser.NOME, i);
		}
		public List<TerminalNode> INT() { return getTokens(SolParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(SolParser.INT, i);
		}
		public InstrucaoContext instrucao() {
			return getRuleContext(InstrucaoContext.class,0);
		}
		public ForStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forState; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterForState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitForState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitForState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStateContext forState() throws RecognitionException {
		ForStateContext _localctx = new ForStateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forState);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__5);
			setState(61);
			match(NOME);
			setState(62);
			match(T__1);
			setState(63);
			match(INT);
			setState(64);
			match(T__6);
			setState(65);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==NOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(66);
			match(T__4);
			setState(67);
			instrucao();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStateContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SolParser.IF, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SolParser.THEN, 0); }
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SolParser.ELSE, 0); }
		public IfStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifState; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterIfState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitIfState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitIfState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStateContext ifState() throws RecognitionException {
		IfStateContext _localctx = new IfStateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifState);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(IF);
			setState(70);
			exp(0);
			setState(71);
			match(THEN);
			setState(72);
			instrucao();
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(73);
				match(ELSE);
				setState(74);
				instrucao();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyContext extends ParserRuleContext {
		public EmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyContext empty() throws RecognitionException {
		EmptyContext _localctx = new EmptyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreakContext extends ParserRuleContext {
		public BreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakContext break_() throws RecognitionException {
		BreakContext _localctx = new BreakContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__7);
			setState(80);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TiposNoCodigoContext extends ParserRuleContext {
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public TiposNoCodigoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tiposNoCodigo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterTiposNoCodigo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitTiposNoCodigo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitTiposNoCodigo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TiposNoCodigoContext tiposNoCodigo() throws RecognitionException {
		TiposNoCodigoContext _localctx = new TiposNoCodigoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tiposNoCodigo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			types();
			setState(83);
			declaracao();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(84);
				match(T__8);
				setState(85);
				declaracao();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypesContext extends ParserRuleContext {
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
	 
		public TypesContext() { }
		public void copyFrom(TypesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOUBLETContext extends TypesContext {
		public DOUBLETContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterDOUBLET(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitDOUBLET(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitDOUBLET(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STRINGTContext extends TypesContext {
		public STRINGTContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterSTRINGT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitSTRINGT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitSTRINGT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class INTTContext extends TypesContext {
		public INTTContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterINTT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitINTT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitINTT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BOLEANTContext extends TypesContext {
		public BOLEANTContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterBOLEANT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitBOLEANT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitBOLEANT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_types);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				_localctx = new INTTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new DOUBLETContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new BOLEANTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(T__11);
				}
				break;
			case T__12:
				_localctx = new STRINGTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				match(T__12);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode NOME() { return getToken(SolParser.NOME, 0); }
		public TerminalNode INT() { return getToken(SolParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(SolParser.DOUBLE, 0); }
		public TerminalNode TRUE() { return getToken(SolParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SolParser.FALSE, 0); }
		public TerminalNode STRING() { return getToken(SolParser.STRING, 0); }
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitDeclaracao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitDeclaracao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaracao);
		int _la;
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(NOME);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(98);
					match(T__1);
					setState(99);
					match(INT);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(NOME);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(103);
					match(T__1);
					setState(104);
					match(DOUBLE);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				match(NOME);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(108);
					match(T__1);
					setState(109);
					match(TRUE);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(NOME);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(113);
					match(T__1);
					setState(114);
					match(FALSE);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
				match(NOME);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(118);
					match(T__1);
					setState(119);
					match(STRING);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public List<TiposNoCodigoContext> tiposNoCodigo() {
			return getRuleContexts(TiposNoCodigoContext.class);
		}
		public TiposNoCodigoContext tiposNoCodigo(int i) {
			return getRuleContext(TiposNoCodigoContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitBloco(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitBloco(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__13);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1099511922010L) != 0)) {
				{
				setState(129);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(125);
					instrucao();
					}
					break;
				case 2:
					{
					setState(126);
					tiposNoCodigo();
					setState(127);
					match(T__0);
					}
					break;
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MULTDIVContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MULT() { return getToken(SolParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SolParser.DIV, 0); }
		public TerminalNode RESTDIV() { return getToken(SolParser.RESTDIV, 0); }
		public MULTDIVContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterMULTDIV(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitMULTDIV(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitMULTDIV(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LOGICALOPERATOREQUALNOTContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(SolParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(SolParser.NOTEQUAL, 0); }
		public LOGICALOPERATOREQUALNOTContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterLOGICALOPERATOREQUALNOT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitLOGICALOPERATOREQUALNOT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitLOGICALOPERATOREQUALNOT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ORDERContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ORDERContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterORDER(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitORDER(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitORDER(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NEGACIONContext extends ExpContext {
		public Token op;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SolParser.NOT, 0); }
		public TerminalNode SUB() { return getToken(SolParser.SUB, 0); }
		public NEGACIONContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterNEGACION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitNEGACION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitNEGACION(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ORContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode OR() { return getToken(SolParser.OR, 0); }
		public ORContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitOR(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ADDSUBContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SolParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SolParser.SUB, 0); }
		public ADDSUBContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterADDSUB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitADDSUB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitADDSUB(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ANDContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AND() { return getToken(SolParser.AND, 0); }
		public ANDContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterAND(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitAND(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitAND(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LOGICALOPERATORContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MINOR() { return getToken(SolParser.MINOR, 0); }
		public TerminalNode GREATER() { return getToken(SolParser.GREATER, 0); }
		public TerminalNode MINOREQUAL() { return getToken(SolParser.MINOREQUAL, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(SolParser.GREATEREQUAL, 0); }
		public LOGICALOPERATORContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterLOGICALOPERATOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitLOGICALOPERATOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitLOGICALOPERATOR(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VaContext extends ExpContext {
		public VariaveisContext variaveis() {
			return getRuleContext(VariaveisContext.class,0);
		}
		public VaContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterVa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitVa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitVa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				{
				_localctx = new ORDERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(137);
				match(T__15);
				setState(138);
				exp(0);
				setState(139);
				match(T__16);
				}
				break;
			case SUB:
			case NOT:
				{
				_localctx = new NEGACIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				((NEGACIONContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==NOT) ) {
					((NEGACIONContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(142);
				exp(8);
				}
				break;
			case FALSE:
			case TRUE:
			case INT:
			case DOUBLE:
			case STRING:
			case NOME:
				{
				_localctx = new VaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				variaveis();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(164);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new MULTDIVContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(146);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(147);
						((MULTDIVContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3758096384L) != 0)) ) {
							((MULTDIVContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(148);
						exp(8);
						}
						break;
					case 2:
						{
						_localctx = new ADDSUBContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(149);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(150);
						((ADDSUBContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SUB || _la==ADD) ) {
							((ADDSUBContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(151);
						exp(7);
						}
						break;
					case 3:
						{
						_localctx = new LOGICALOPERATORContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(152);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(153);
						((LOGICALOPERATORContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
							((LOGICALOPERATORContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(154);
						exp(6);
						}
						break;
					case 4:
						{
						_localctx = new LOGICALOPERATOREQUALNOTContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(155);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(156);
						((LOGICALOPERATOREQUALNOTContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==NOTEQUAL || _la==EQUAL) ) {
							((LOGICALOPERATOREQUALNOTContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(157);
						exp(5);
						}
						break;
					case 5:
						{
						_localctx = new ANDContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(158);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(159);
						match(AND);
						setState(160);
						exp(4);
						}
						break;
					case 6:
						{
						_localctx = new ORContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(161);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(162);
						match(OR);
						setState(163);
						exp(3);
						}
						break;
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariaveisContext extends ParserRuleContext {
		public VariaveisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variaveis; }
	 
		public VariaveisContext() { }
		public void copyFrom(VariaveisContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TRUEContext extends VariaveisContext {
		public TerminalNode TRUE() { return getToken(SolParser.TRUE, 0); }
		public TRUEContext(VariaveisContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterTRUE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitTRUE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitTRUE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STRINGContext extends VariaveisContext {
		public TerminalNode STRING() { return getToken(SolParser.STRING, 0); }
		public STRINGContext(VariaveisContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterSTRING(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitSTRING(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitSTRING(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FALSEContext extends VariaveisContext {
		public TerminalNode FALSE() { return getToken(SolParser.FALSE, 0); }
		public FALSEContext(VariaveisContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterFALSE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitFALSE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitFALSE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOUBLEContext extends VariaveisContext {
		public TerminalNode DOUBLE() { return getToken(SolParser.DOUBLE, 0); }
		public DOUBLEContext(VariaveisContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterDOUBLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitDOUBLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitDOUBLE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NOMEContext extends VariaveisContext {
		public TerminalNode NOME() { return getToken(SolParser.NOME, 0); }
		public NOMEContext(VariaveisContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterNOME(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitNOME(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitNOME(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class INTContext extends VariaveisContext {
		public TerminalNode INT() { return getToken(SolParser.INT, 0); }
		public INTContext(VariaveisContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterINT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitINT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitINT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariaveisContext variaveis() throws RecognitionException {
		VariaveisContext _localctx = new VariaveisContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variaveis);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new INTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(INT);
				}
				break;
			case DOUBLE:
				_localctx = new DOUBLEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(DOUBLE);
				}
				break;
			case TRUE:
				_localctx = new TRUEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FALSEContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(FALSE);
				}
				break;
			case STRING:
				_localctx = new STRINGContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				match(STRING);
				}
				break;
			case NOME:
				_localctx = new NOMEContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				match(NOME);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u00b2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001e\b\u0000\n\u0000"+
		"\f\u0000!\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005L\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bW\b\b\n\b\f"+
		"\bZ\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t`\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0003\ne\b\n\u0001\n\u0001\n\u0001\n\u0003\nj\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\no\b\n\u0001\n\u0001\n\u0001\n\u0003\nt\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\ny\b\n\u0003\n{\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u0082\b\u000b\n\u000b\f\u000b\u0085\t\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0091\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00a5\b\f\n\f\f\f\u00a8\t\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00b0\b\r\u0001"+
		"\r\u0000\u0001\u0018\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u0000\u0006\u0002\u0000%%((\u0002\u0000\u001b"+
		"\u001b  \u0001\u0000\u001d\u001f\u0001\u0000\u001b\u001c\u0001\u0000\u0017"+
		"\u001a\u0001\u0000\u0015\u0016\u00c9\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u00021\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u00067"+
		"\u0001\u0000\u0000\u0000\b<\u0001\u0000\u0000\u0000\nE\u0001\u0000\u0000"+
		"\u0000\fM\u0001\u0000\u0000\u0000\u000eO\u0001\u0000\u0000\u0000\u0010"+
		"R\u0001\u0000\u0000\u0000\u0012_\u0001\u0000\u0000\u0000\u0014z\u0001"+
		"\u0000\u0000\u0000\u0016|\u0001\u0000\u0000\u0000\u0018\u0090\u0001\u0000"+
		"\u0000\u0000\u001a\u00af\u0001\u0000\u0000\u0000\u001c\u001e\u0003\u0002"+
		"\u0001\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000"+
		" \"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005\u0000"+
		"\u0000\u0001#\u0001\u0001\u0000\u0000\u0000$2\u0003\u0004\u0002\u0000"+
		"%2\u0003\u0016\u000b\u0000&2\u0003\u0006\u0003\u0000\'2\u0003\b\u0004"+
		"\u0000(2\u0003\n\u0005\u0000)2\u0003\f\u0006\u0000*2\u0003\u000e\u0007"+
		"\u0000+,\u0003\u0010\b\u0000,-\u0005\u0001\u0000\u0000-2\u0001\u0000\u0000"+
		"\u0000./\u0005(\u0000\u0000/0\u0005\u0002\u0000\u000002\u0003\u0018\f"+
		"\u00001$\u0001\u0000\u0000\u00001%\u0001\u0000\u0000\u00001&\u0001\u0000"+
		"\u0000\u00001\'\u0001\u0000\u0000\u00001(\u0001\u0000\u0000\u00001)\u0001"+
		"\u0000\u0000\u00001*\u0001\u0000\u0000\u00001+\u0001\u0000\u0000\u0000"+
		"1.\u0001\u0000\u0000\u00002\u0003\u0001\u0000\u0000\u000034\u0005\u0003"+
		"\u0000\u000045\u0003\u0018\f\u000056\u0005\u0001\u0000\u00006\u0005\u0001"+
		"\u0000\u0000\u000078\u0005\u0004\u0000\u000089\u0003\u0018\f\u00009:\u0005"+
		"\u0005\u0000\u0000:;\u0003\u0002\u0001\u0000;\u0007\u0001\u0000\u0000"+
		"\u0000<=\u0005\u0006\u0000\u0000=>\u0005(\u0000\u0000>?\u0005\u0002\u0000"+
		"\u0000?@\u0005%\u0000\u0000@A\u0005\u0007\u0000\u0000AB\u0007\u0000\u0000"+
		"\u0000BC\u0005\u0005\u0000\u0000CD\u0003\u0002\u0001\u0000D\t\u0001\u0000"+
		"\u0000\u0000EF\u0005\u0012\u0000\u0000FG\u0003\u0018\f\u0000GH\u0005\u0013"+
		"\u0000\u0000HK\u0003\u0002\u0001\u0000IJ\u0005\u0014\u0000\u0000JL\u0003"+
		"\u0002\u0001\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"L\u000b\u0001\u0000\u0000\u0000MN\u0005\u0001\u0000\u0000N\r\u0001\u0000"+
		"\u0000\u0000OP\u0005\b\u0000\u0000PQ\u0005\u0001\u0000\u0000Q\u000f\u0001"+
		"\u0000\u0000\u0000RS\u0003\u0012\t\u0000SX\u0003\u0014\n\u0000TU\u0005"+
		"\t\u0000\u0000UW\u0003\u0014\n\u0000VT\u0001\u0000\u0000\u0000WZ\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"Y\u0011\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[`\u0005\n\u0000"+
		"\u0000\\`\u0005\u000b\u0000\u0000]`\u0005\f\u0000\u0000^`\u0005\r\u0000"+
		"\u0000_[\u0001\u0000\u0000\u0000_\\\u0001\u0000\u0000\u0000_]\u0001\u0000"+
		"\u0000\u0000_^\u0001\u0000\u0000\u0000`\u0013\u0001\u0000\u0000\u0000"+
		"ad\u0005(\u0000\u0000bc\u0005\u0002\u0000\u0000ce\u0005%\u0000\u0000d"+
		"b\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e{\u0001\u0000\u0000"+
		"\u0000fi\u0005(\u0000\u0000gh\u0005\u0002\u0000\u0000hj\u0005&\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j{\u0001\u0000\u0000"+
		"\u0000kn\u0005(\u0000\u0000lm\u0005\u0002\u0000\u0000mo\u0005$\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o{\u0001\u0000\u0000"+
		"\u0000ps\u0005(\u0000\u0000qr\u0005\u0002\u0000\u0000rt\u0005#\u0000\u0000"+
		"sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t{\u0001\u0000\u0000"+
		"\u0000ux\u0005(\u0000\u0000vw\u0005\u0002\u0000\u0000wy\u0005\'\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000"+
		"\u0000\u0000za\u0001\u0000\u0000\u0000zf\u0001\u0000\u0000\u0000zk\u0001"+
		"\u0000\u0000\u0000zp\u0001\u0000\u0000\u0000zu\u0001\u0000\u0000\u0000"+
		"{\u0015\u0001\u0000\u0000\u0000|\u0083\u0005\u000e\u0000\u0000}\u0082"+
		"\u0003\u0002\u0001\u0000~\u007f\u0003\u0010\b\u0000\u007f\u0080\u0005"+
		"\u0001\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000\u0081}\u0001\u0000"+
		"\u0000\u0000\u0081~\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000"+
		"\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005\u000f\u0000\u0000\u0087\u0017\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0006\f\uffff\uffff\u0000\u0089\u008a\u0005\u0010\u0000"+
		"\u0000\u008a\u008b\u0003\u0018\f\u0000\u008b\u008c\u0005\u0011\u0000\u0000"+
		"\u008c\u0091\u0001\u0000\u0000\u0000\u008d\u008e\u0007\u0001\u0000\u0000"+
		"\u008e\u0091\u0003\u0018\f\b\u008f\u0091\u0003\u001a\r\u0000\u0090\u0088"+
		"\u0001\u0000\u0000\u0000\u0090\u008d\u0001\u0000\u0000\u0000\u0090\u008f"+
		"\u0001\u0000\u0000\u0000\u0091\u00a6\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\n\u0007\u0000\u0000\u0093\u0094\u0007\u0002\u0000\u0000\u0094\u00a5\u0003"+
		"\u0018\f\b\u0095\u0096\n\u0006\u0000\u0000\u0096\u0097\u0007\u0003\u0000"+
		"\u0000\u0097\u00a5\u0003\u0018\f\u0007\u0098\u0099\n\u0005\u0000\u0000"+
		"\u0099\u009a\u0007\u0004\u0000\u0000\u009a\u00a5\u0003\u0018\f\u0006\u009b"+
		"\u009c\n\u0004\u0000\u0000\u009c\u009d\u0007\u0005\u0000\u0000\u009d\u00a5"+
		"\u0003\u0018\f\u0005\u009e\u009f\n\u0003\u0000\u0000\u009f\u00a0\u0005"+
		"\"\u0000\u0000\u00a0\u00a5\u0003\u0018\f\u0004\u00a1\u00a2\n\u0002\u0000"+
		"\u0000\u00a2\u00a3\u0005!\u0000\u0000\u00a3\u00a5\u0003\u0018\f\u0003"+
		"\u00a4\u0092\u0001\u0000\u0000\u0000\u00a4\u0095\u0001\u0000\u0000\u0000"+
		"\u00a4\u0098\u0001\u0000\u0000\u0000\u00a4\u009b\u0001\u0000\u0000\u0000"+
		"\u00a4\u009e\u0001\u0000\u0000\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u0019\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00b0\u0005%\u0000\u0000\u00aa"+
		"\u00b0\u0005&\u0000\u0000\u00ab\u00b0\u0005$\u0000\u0000\u00ac\u00b0\u0005"+
		"#\u0000\u0000\u00ad\u00b0\u0005\'\u0000\u0000\u00ae\u00b0\u0005(\u0000"+
		"\u0000\u00af\u00a9\u0001\u0000\u0000\u0000\u00af\u00aa\u0001\u0000\u0000"+
		"\u0000\u00af\u00ab\u0001\u0000\u0000\u0000\u00af\u00ac\u0001\u0000\u0000"+
		"\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b0\u001b\u0001\u0000\u0000\u0000\u0011\u001f1KX_dinsxz\u0081"+
		"\u0083\u0090\u00a4\u00a6\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}