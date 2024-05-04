// Generated from C:/Users/sergi/Documents/Compiladores/CompiladoresT/t1/Sol.g4 by ANTLR 4.13.1
package Tasm;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TasmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ICONST=3, IPRINT=4, IMINUS=5, IADD=6, ISUB=7, IMULT=8, 
		IDIV=9, IMOD=10, IEQ=11, INEQ=12, ILT=13, ILEQ=14, ITOD=15, ITOS=16, DCONST=17, 
		DPRINT=18, DUMINUS=19, DADD=20, DSUB=21, DMULT=22, DDIV=23, DEQ=24, DNEQ=25, 
		DLT=26, DLEQ=27, DTOS=28, SCONST=29, SPRINT=30, SADD=31, SEQ=32, SNEQ=33, 
		TCONST=34, FCONST=35, BPRINT=36, NOT=37, AND=38, OR=39, BEQ=40, BNEQ=41, 
		BTOS=42, JUMP=43, JUMPT=44, JUMPF=45, GALLOC=46, GLOAD=47, GSTORE=48, 
		HALT=49, LABEL=50, STRING=51, INT=52, DOUBLE=53, EOL=54, WS=55;
	public static final int
		RULE_executable = 0, RULE_command = 1, RULE_token = 2, RULE_integerOP = 3, 
		RULE_doubleOP = 4, RULE_stringOP = 5, RULE_boolOP = 6, RULE_jumpOP = 7, 
		RULE_arrayOP = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"executable", "command", "token", "integerOP", "doubleOP", "stringOP", 
			"boolOP", "jumpOP", "arrayOP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "':'", "'iconst'", "'iprint'", "'iuminus'", "'iadd'", "'isub'", 
			"'imult'", "'idiv'", "'imod'", "'ieq'", "'ineq'", "'ilt'", "'ileq'", 
			"'itod'", "'itos'", "'dconst'", "'dprint'", "'duminus'", "'dadd'", "'dsub'", 
			"'dmult'", "'ddiv'", "'deq'", "'dneq'", "'dlt'", "'dleq'", "'dtos'", 
			"'sconst'", "'sprint'", "'sadd'", "'seq'", "'sneq'", "'tconst'", "'fconst'", 
			"'bprint'", "'not'", "'and'", "'or'", "'beq'", "'bneq'", "'btos'", "'jump'", 
			"'jumpt'", "'jumpf'", "'galloc'", "'gload'", "'gstore'", "'halt'", null, 
			null, null, null, "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "ICONST", "IPRINT", "IMINUS", "IADD", "ISUB", "IMULT", 
			"IDIV", "IMOD", "IEQ", "INEQ", "ILT", "ILEQ", "ITOD", "ITOS", "DCONST", 
			"DPRINT", "DUMINUS", "DADD", "DSUB", "DMULT", "DDIV", "DEQ", "DNEQ", 
			"DLT", "DLEQ", "DTOS", "SCONST", "SPRINT", "SADD", "SEQ", "SNEQ", "TCONST", 
			"FCONST", "BPRINT", "NOT", "AND", "OR", "BEQ", "BNEQ", "BTOS", "JUMP", 
			"JUMPT", "JUMPF", "GALLOC", "GLOAD", "GSTORE", "HALT", "LABEL", "STRING", 
			"INT", "DOUBLE", "EOL", "WS"
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

	public TasmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExecutableContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TasmParser.EOF, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public TerminalNode HALT() { return getToken(TasmParser.HALT, 0); }
		public ExecutableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_executable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterExecutable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitExecutable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitExecutable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExecutableContext executable() throws RecognitionException {
		ExecutableContext _localctx = new ExecutableContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_executable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(18);
					command();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(21); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HALT) {
				{
				setState(23);
				match(HALT);
				}
			}

			setState(26);
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
	public static class CommandContext extends ParserRuleContext {
		public List<TerminalNode> LABEL() { return getTokens(TasmParser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(TasmParser.LABEL, i);
		}
		public List<TokenContext> token() {
			return getRuleContexts(TokenContext.class);
		}
		public TokenContext token(int i) {
			return getRuleContext(TokenContext.class,i);
		}
		public TerminalNode EOL() { return getToken(TasmParser.EOL, 0); }
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				setState(28);
				match(LABEL);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(29);
					match(T__0);
					setState(30);
					match(LABEL);
					}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(36);
				match(T__1);
				}
			}

			setState(40); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(39);
					token();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(42); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(44);
				match(EOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TokenContext extends ParserRuleContext {
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
	 
		public TokenContext() { }
		public void copyFrom(TokenContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringOperationContext extends TokenContext {
		public StringOPContext stringOP() {
			return getRuleContext(StringOPContext.class,0);
		}
		public StringOperationContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterStringOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitStringOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitStringOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstIntegerContext extends TokenContext {
		public TerminalNode ICONST() { return getToken(TasmParser.ICONST, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public ConstIntegerContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterConstInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitConstInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitConstInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleOperationContext extends TokenContext {
		public DoubleOPContext doubleOP() {
			return getRuleContext(DoubleOPContext.class,0);
		}
		public DoubleOperationContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDoubleOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDoubleOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDoubleOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayOperationContext extends TokenContext {
		public ArrayOPContext arrayOP() {
			return getRuleContext(ArrayOPContext.class,0);
		}
		public ArrayOperationContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterArrayOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitArrayOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitArrayOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HaltContext extends TokenContext {
		public TerminalNode HALT() { return getToken(TasmParser.HALT, 0); }
		public HaltContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterHalt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitHalt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitHalt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstDoubleContext extends TokenContext {
		public TerminalNode DCONST() { return getToken(TasmParser.DCONST, 0); }
		public TerminalNode DOUBLE() { return getToken(TasmParser.DOUBLE, 0); }
		public ConstDoubleContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterConstDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitConstDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitConstDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JumpOperationContext extends TokenContext {
		public JumpOPContext jumpOP() {
			return getRuleContext(JumpOPContext.class,0);
		}
		public JumpOperationContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterJumpOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitJumpOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitJumpOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstDoubleIntegerContext extends TokenContext {
		public TerminalNode DCONST() { return getToken(TasmParser.DCONST, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public ConstDoubleIntegerContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterConstDoubleInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitConstDoubleInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitConstDoubleInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstStringContext extends TokenContext {
		public TerminalNode SCONST() { return getToken(TasmParser.SCONST, 0); }
		public TerminalNode STRING() { return getToken(TasmParser.STRING, 0); }
		public ConstStringContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterConstString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitConstString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitConstString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolOperationContext extends TokenContext {
		public BoolOPContext boolOP() {
			return getRuleContext(BoolOPContext.class,0);
		}
		public BoolOperationContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterBoolOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitBoolOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitBoolOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerOperationContext extends TokenContext {
		public IntegerOPContext integerOP() {
			return getRuleContext(IntegerOPContext.class,0);
		}
		public IntegerOperationContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIntegerOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIntegerOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIntegerOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_token);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ConstIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(ICONST);
				setState(48);
				match(INT);
				}
				break;
			case 2:
				_localctx = new ConstDoubleIntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(DCONST);
				setState(50);
				match(INT);
				}
				break;
			case 3:
				_localctx = new ConstDoubleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				match(DCONST);
				setState(52);
				match(DOUBLE);
				}
				break;
			case 4:
				_localctx = new ConstStringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				match(SCONST);
				setState(54);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new IntegerOperationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				integerOP();
				}
				break;
			case 6:
				_localctx = new DoubleOperationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				doubleOP();
				}
				break;
			case 7:
				_localctx = new StringOperationContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(57);
				stringOP();
				}
				break;
			case 8:
				_localctx = new BoolOperationContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(58);
				boolOP();
				}
				break;
			case 9:
				_localctx = new JumpOperationContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(59);
				jumpOP();
				}
				break;
			case 10:
				_localctx = new ArrayOperationContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(60);
				arrayOP();
				}
				break;
			case 11:
				_localctx = new HaltContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(61);
				match(HALT);
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
	public static class IntegerOPContext extends ParserRuleContext {
		public TerminalNode IPRINT() { return getToken(TasmParser.IPRINT, 0); }
		public TerminalNode IMINUS() { return getToken(TasmParser.IMINUS, 0); }
		public TerminalNode IADD() { return getToken(TasmParser.IADD, 0); }
		public TerminalNode ISUB() { return getToken(TasmParser.ISUB, 0); }
		public TerminalNode IMULT() { return getToken(TasmParser.IMULT, 0); }
		public TerminalNode IDIV() { return getToken(TasmParser.IDIV, 0); }
		public TerminalNode IMOD() { return getToken(TasmParser.IMOD, 0); }
		public TerminalNode IEQ() { return getToken(TasmParser.IEQ, 0); }
		public TerminalNode INEQ() { return getToken(TasmParser.INEQ, 0); }
		public TerminalNode ILT() { return getToken(TasmParser.ILT, 0); }
		public TerminalNode ILEQ() { return getToken(TasmParser.ILEQ, 0); }
		public TerminalNode ITOD() { return getToken(TasmParser.ITOD, 0); }
		public TerminalNode ITOS() { return getToken(TasmParser.ITOS, 0); }
		public IntegerOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIntegerOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIntegerOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIntegerOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerOPContext integerOP() throws RecognitionException {
		IntegerOPContext _localctx = new IntegerOPContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_integerOP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 131056L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class DoubleOPContext extends ParserRuleContext {
		public TerminalNode DPRINT() { return getToken(TasmParser.DPRINT, 0); }
		public TerminalNode DUMINUS() { return getToken(TasmParser.DUMINUS, 0); }
		public TerminalNode DADD() { return getToken(TasmParser.DADD, 0); }
		public TerminalNode DSUB() { return getToken(TasmParser.DSUB, 0); }
		public TerminalNode DMULT() { return getToken(TasmParser.DMULT, 0); }
		public TerminalNode DDIV() { return getToken(TasmParser.DDIV, 0); }
		public TerminalNode DEQ() { return getToken(TasmParser.DEQ, 0); }
		public TerminalNode DNEQ() { return getToken(TasmParser.DNEQ, 0); }
		public TerminalNode DLT() { return getToken(TasmParser.DLT, 0); }
		public TerminalNode DLEQ() { return getToken(TasmParser.DLEQ, 0); }
		public TerminalNode DTOS() { return getToken(TasmParser.DTOS, 0); }
		public DoubleOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDoubleOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDoubleOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDoubleOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleOPContext doubleOP() throws RecognitionException {
		DoubleOPContext _localctx = new DoubleOPContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_doubleOP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 536608768L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringOPContext extends ParserRuleContext {
		public TerminalNode SPRINT() { return getToken(TasmParser.SPRINT, 0); }
		public TerminalNode SADD() { return getToken(TasmParser.SADD, 0); }
		public TerminalNode SEQ() { return getToken(TasmParser.SEQ, 0); }
		public TerminalNode SNEQ() { return getToken(TasmParser.SNEQ, 0); }
		public StringOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterStringOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitStringOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitStringOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringOPContext stringOP() throws RecognitionException {
		StringOPContext _localctx = new StringOPContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stringOP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class BoolOPContext extends ParserRuleContext {
		public TerminalNode TCONST() { return getToken(TasmParser.TCONST, 0); }
		public TerminalNode FCONST() { return getToken(TasmParser.FCONST, 0); }
		public TerminalNode BPRINT() { return getToken(TasmParser.BPRINT, 0); }
		public TerminalNode BEQ() { return getToken(TasmParser.BEQ, 0); }
		public TerminalNode BNEQ() { return getToken(TasmParser.BNEQ, 0); }
		public TerminalNode BTOS() { return getToken(TasmParser.BTOS, 0); }
		public TerminalNode NOT() { return getToken(TasmParser.NOT, 0); }
		public TerminalNode AND() { return getToken(TasmParser.AND, 0); }
		public TerminalNode OR() { return getToken(TasmParser.OR, 0); }
		public BoolOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterBoolOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitBoolOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitBoolOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOPContext boolOP() throws RecognitionException {
		BoolOPContext _localctx = new BoolOPContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_boolOP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8778913153024L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class JumpOPContext extends ParserRuleContext {
		public TerminalNode JUMP() { return getToken(TasmParser.JUMP, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public TerminalNode JUMPT() { return getToken(TasmParser.JUMPT, 0); }
		public TerminalNode JUMPF() { return getToken(TasmParser.JUMPF, 0); }
		public JumpOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterJumpOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitJumpOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitJumpOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpOPContext jumpOP() throws RecognitionException {
		JumpOPContext _localctx = new JumpOPContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_jumpOP);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JUMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(JUMP);
				setState(73);
				match(LABEL);
				}
				break;
			case JUMPT:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(JUMPT);
				setState(75);
				match(LABEL);
				}
				break;
			case JUMPF:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(JUMPF);
				setState(77);
				match(LABEL);
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
	public static class ArrayOPContext extends ParserRuleContext {
		public TerminalNode GALLOC() { return getToken(TasmParser.GALLOC, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public TerminalNode GLOAD() { return getToken(TasmParser.GLOAD, 0); }
		public TerminalNode GSTORE() { return getToken(TasmParser.GSTORE, 0); }
		public ArrayOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterArrayOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitArrayOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitArrayOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayOPContext arrayOP() throws RecognitionException {
		ArrayOPContext _localctx = new ArrayOPContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayOP);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GALLOC:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(GALLOC);
				setState(81);
				match(INT);
				}
				break;
			case GLOAD:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(GLOAD);
				setState(83);
				match(INT);
				}
				break;
			case GSTORE:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				match(GSTORE);
				setState(85);
				match(INT);
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
		"\u0004\u00017Y\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0001\u0000\u0004\u0000\u0014\b\u0000\u000b\u0000\f\u0000\u0015\u0001"+
		"\u0000\u0003\u0000\u0019\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t\u0001\u0001"+
		"\u0001\u0003\u0001&\b\u0001\u0001\u0001\u0004\u0001)\b\u0001\u000b\u0001"+
		"\f\u0001*\u0001\u0001\u0003\u0001.\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002?\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007O\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bW\b\b\u0001"+
		"\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0004"+
		"\u0001\u0000\u0004\u0010\u0001\u0000\u0012\u001c\u0001\u0000\u001e!\u0001"+
		"\u0000\"*c\u0000\u0013\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000"+
		"\u0000\u0004>\u0001\u0000\u0000\u0000\u0006@\u0001\u0000\u0000\u0000\b"+
		"B\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000\u0000\fF\u0001\u0000\u0000"+
		"\u0000\u000eN\u0001\u0000\u0000\u0000\u0010V\u0001\u0000\u0000\u0000\u0012"+
		"\u0014\u0003\u0002\u0001\u0000\u0013\u0012\u0001\u0000\u0000\u0000\u0014"+
		"\u0015\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015"+
		"\u0016\u0001\u0000\u0000\u0000\u0016\u0018\u0001\u0000\u0000\u0000\u0017"+
		"\u0019\u00051\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0018\u0019"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0005\u0000\u0000\u0001\u001b\u0001\u0001\u0000\u0000\u0000\u001c!\u0005"+
		"2\u0000\u0000\u001d\u001e\u0005\u0001\u0000\u0000\u001e \u00052\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!"+
		"\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000$&\u0005\u0002\u0000\u0000%\u001c"+
		"\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000"+
		"\u0000\')\u0003\u0004\u0002\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000"+
		"\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+-\u0001"+
		"\u0000\u0000\u0000,.\u00056\u0000\u0000-,\u0001\u0000\u0000\u0000-.\u0001"+
		"\u0000\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0005\u0003\u0000"+
		"\u00000?\u00054\u0000\u000012\u0005\u0011\u0000\u00002?\u00054\u0000\u0000"+
		"34\u0005\u0011\u0000\u00004?\u00055\u0000\u000056\u0005\u001d\u0000\u0000"+
		"6?\u00053\u0000\u00007?\u0003\u0006\u0003\u00008?\u0003\b\u0004\u0000"+
		"9?\u0003\n\u0005\u0000:?\u0003\f\u0006\u0000;?\u0003\u000e\u0007\u0000"+
		"<?\u0003\u0010\b\u0000=?\u00051\u0000\u0000>/\u0001\u0000\u0000\u0000"+
		">1\u0001\u0000\u0000\u0000>3\u0001\u0000\u0000\u0000>5\u0001\u0000\u0000"+
		"\u0000>7\u0001\u0000\u0000\u0000>8\u0001\u0000\u0000\u0000>9\u0001\u0000"+
		"\u0000\u0000>:\u0001\u0000\u0000\u0000>;\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000?\u0005\u0001\u0000\u0000"+
		"\u0000@A\u0007\u0000\u0000\u0000A\u0007\u0001\u0000\u0000\u0000BC\u0007"+
		"\u0001\u0000\u0000C\t\u0001\u0000\u0000\u0000DE\u0007\u0002\u0000\u0000"+
		"E\u000b\u0001\u0000\u0000\u0000FG\u0007\u0003\u0000\u0000G\r\u0001\u0000"+
		"\u0000\u0000HI\u0005+\u0000\u0000IO\u00052\u0000\u0000JK\u0005,\u0000"+
		"\u0000KO\u00052\u0000\u0000LM\u0005-\u0000\u0000MO\u00052\u0000\u0000"+
		"NH\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000"+
		"\u0000O\u000f\u0001\u0000\u0000\u0000PQ\u0005.\u0000\u0000QW\u00054\u0000"+
		"\u0000RS\u0005/\u0000\u0000SW\u00054\u0000\u0000TU\u00050\u0000\u0000"+
		"UW\u00054\u0000\u0000VP\u0001\u0000\u0000\u0000VR\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000W\u0011\u0001\u0000\u0000\u0000\t\u0015\u0018"+
		"!%*->NV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}