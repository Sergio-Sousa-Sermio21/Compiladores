// Generated from C:/Users/ASUS/Documents/Lab1typescript/Compiladores/src/Tasm.g4 by ANTLR 4.13.1
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
		T__0=1, T__1=2, T__2=3, INTINSTRUCTION=4, DOUBLEINSTRUCTION=5, STRINGINSTRUCTION=6, 
		DOUBLE=7, DNEQ=8, ITOD=9, ICONST=10, IPRINT=11, IUMINUS=12, IADD=13, SADD=14, 
		ISUB=15, IMULT=16, IDIV=17, IMOD=18, IEQ=19, INEQ=20, ILT=21, ILEQ=22, 
		ITOP=23, ITOS=24, DCONST=25, DPRINT=26, DUMINUS=27, DADD=28, DSUB=29, 
		DMULT=30, DDIV=31, DEQ=32, DLT=33, DLEQ=34, DTOS=35, SCONST=36, SPRINT=37, 
		SEQ=38, SNEQ=39, BCONST=40, BPRINT=41, BEQ=42, BNEQ=43, AND=44, OR=45, 
		NOT=46, BTOS=47, JUMP=48, JUMPT=49, JUMPF=50, GALLOC=51, GLOAD=52, GSTORE=53, 
		BOOLEAN=54, STRING=55, INT=56, HALT=57, EOL=58, LABEL=59, WS=60;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_instruction = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "instruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "':'", "' '", null, null, null, null, "'dneq'", "'itod'", 
			"'iconst'", "'iprint'", "'iuminus'", "'iadd'", "'sadd'", "'isub'", "'imult'", 
			"'idiv'", "'imod'", "'ieq'", "'ineq'", "'ilt'", "'ileq'", "'itop'", "'itos'", 
			"'dconst'", "'dprint'", "'duminus'", "'dadd'", "'dsub'", "'dmult'", "'ddiv'", 
			"'deq'", "'dlt'", "'dleq'", "'dtos'", "'sconst'", "'sprint'", "'seq'", 
			"'sneq'", "'bconst'", "'bprint'", "'beq'", "'bneq'", "'and'", "'or'", 
			"'not'", "'btos'", "'jump'", "'jumpt'", "'jumpf'", "'galloc'", "'gload'", 
			"'gstore'", null, null, null, "'halt'", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "INTINSTRUCTION", "DOUBLEINSTRUCTION", "STRINGINSTRUCTION", 
			"DOUBLE", "DNEQ", "ITOD", "ICONST", "IPRINT", "IUMINUS", "IADD", "SADD", 
			"ISUB", "IMULT", "IDIV", "IMOD", "IEQ", "INEQ", "ILT", "ILEQ", "ITOP", 
			"ITOS", "DCONST", "DPRINT", "DUMINUS", "DADD", "DSUB", "DMULT", "DDIV", 
			"DEQ", "DLT", "DLEQ", "DTOS", "SCONST", "SPRINT", "SEQ", "SNEQ", "BCONST", 
			"BPRINT", "BEQ", "BNEQ", "AND", "OR", "NOT", "BTOS", "JUMP", "JUMPT", 
			"JUMPF", "GALLOC", "GLOAD", "GSTORE", "BOOLEAN", "STRING", "INT", "HALT", 
			"EOL", "LABEL", "WS"
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
	public String getGrammarFileName() { return "Tasm.g4"; }

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
	public static class ProgramContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(TasmParser.EOF, 0); }
		public TerminalNode HALT() { return getToken(TasmParser.HALT, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			setState(15);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTINSTRUCTION:
			case DOUBLEINSTRUCTION:
			case STRINGINSTRUCTION:
			case ICONST:
			case DCONST:
			case SCONST:
			case JUMP:
			case JUMPT:
			case JUMPF:
			case LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(7); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(6);
					expression();
					}
					}
					setState(9); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 578431145893430384L) != 0) );
				}
				break;
			case EOF:
			case HALT:
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HALT) {
					{
					setState(11);
					match(HALT);
					}
				}

				setState(14);
				match(EOF);
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
	public static class ExpressionContext extends ParserRuleContext {
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public TerminalNode EOL() { return getToken(TasmParser.EOL, 0); }
		public List<TerminalNode> LABEL() { return getTokens(TasmParser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(TasmParser.LABEL, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(17);
					match(LABEL);
					}
					}
					setState(20); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LABEL );
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(22);
					match(T__0);
					setState(23);
					match(LABEL);
					}
				}

				setState(26);
				match(T__1);
				}
			}

			setState(29);
			instruction();
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(30);
				match(EOL);
				}
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
	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DCONSTContext extends InstructionContext {
		public TerminalNode DCONST() { return getToken(TasmParser.DCONST, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(TasmParser.DOUBLE, 0); }
		public DCONSTContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDCONST(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDCONST(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDCONST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JUMPFContext extends InstructionContext {
		public TerminalNode JUMPF() { return getToken(TasmParser.JUMPF, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public JUMPFContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterJUMPF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitJUMPF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitJUMPF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOUBLEINSTRUCTIONContext extends InstructionContext {
		public TerminalNode DOUBLEINSTRUCTION() { return getToken(TasmParser.DOUBLEINSTRUCTION, 0); }
		public DOUBLEINSTRUCTIONContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDOUBLEINSTRUCTION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDOUBLEINSTRUCTION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDOUBLEINSTRUCTION(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SCONSTContext extends InstructionContext {
		public TerminalNode SCONST() { return getToken(TasmParser.SCONST, 0); }
		public TerminalNode STRING() { return getToken(TasmParser.STRING, 0); }
		public SCONSTContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterSCONST(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitSCONST(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitSCONST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JUMPContext extends InstructionContext {
		public TerminalNode JUMP() { return getToken(TasmParser.JUMP, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public JUMPContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterJUMP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitJUMP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitJUMP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JUMPTContext extends InstructionContext {
		public TerminalNode JUMPT() { return getToken(TasmParser.JUMPT, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public JUMPTContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterJUMPT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitJUMPT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitJUMPT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class INTINSTRUCTIONContext extends InstructionContext {
		public TerminalNode INTINSTRUCTION() { return getToken(TasmParser.INTINSTRUCTION, 0); }
		public INTINSTRUCTIONContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterINTINSTRUCTION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitINTINSTRUCTION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitINTINSTRUCTION(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STRINGINSTRUCTIONContext extends InstructionContext {
		public TerminalNode STRINGINSTRUCTION() { return getToken(TasmParser.STRINGINSTRUCTION, 0); }
		public STRINGINSTRUCTIONContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterSTRINGINSTRUCTION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitSTRINGINSTRUCTION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitSTRINGINSTRUCTION(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class INTVALUEContext extends InstructionContext {
		public TerminalNode ICONST() { return getToken(TasmParser.ICONST, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public INTVALUEContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterINTVALUE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitINTVALUE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitINTVALUE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICONST:
				_localctx = new INTVALUEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(ICONST);
				setState(34);
				match(T__2);
				setState(35);
				match(INT);
				}
				break;
			case DCONST:
				_localctx = new DCONSTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(DCONST);
				setState(37);
				_la = _input.LA(1);
				if ( !(_la==DOUBLE || _la==INT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case SCONST:
				_localctx = new SCONSTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				match(SCONST);
				setState(39);
				match(STRING);
				}
				break;
			case JUMP:
				_localctx = new JUMPContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				match(JUMP);
				setState(41);
				match(LABEL);
				}
				break;
			case JUMPT:
				_localctx = new JUMPTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				match(JUMPT);
				setState(43);
				match(LABEL);
				}
				break;
			case JUMPF:
				_localctx = new JUMPFContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(44);
				match(JUMPF);
				setState(45);
				match(LABEL);
				}
				break;
			case INTINSTRUCTION:
				_localctx = new INTINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(46);
				match(INTINSTRUCTION);
				}
				break;
			case DOUBLEINSTRUCTION:
				_localctx = new DOUBLEINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(47);
				match(DOUBLEINSTRUCTION);
				}
				break;
			case STRINGINSTRUCTION:
				_localctx = new STRINGINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(48);
				match(STRINGINSTRUCTION);
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
		"\u0004\u0001<4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0001\u0000\u0004\u0000\b\b\u0000\u000b\u0000\f\u0000\t\u0001"+
		"\u0000\u0003\u0000\r\b\u0000\u0001\u0000\u0003\u0000\u0010\b\u0000\u0001"+
		"\u0001\u0004\u0001\u0013\b\u0001\u000b\u0001\f\u0001\u0014\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0019\b\u0001\u0001\u0001\u0003\u0001\u001c\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002\u0001\u0002\u0000"+
		"\u0000\u0003\u0000\u0002\u0004\u0000\u0001\u0002\u0000\u0007\u000788?"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000"+
		"\u00041\u0001\u0000\u0000\u0000\u0006\b\u0003\u0002\u0001\u0000\u0007"+
		"\u0006\u0001\u0000\u0000\u0000\b\t\u0001\u0000\u0000\u0000\t\u0007\u0001"+
		"\u0000\u0000\u0000\t\n\u0001\u0000\u0000\u0000\n\u0010\u0001\u0000\u0000"+
		"\u0000\u000b\r\u00059\u0000\u0000\f\u000b\u0001\u0000\u0000\u0000\f\r"+
		"\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u0010\u0005"+
		"\u0000\u0000\u0001\u000f\u0007\u0001\u0000\u0000\u0000\u000f\f\u0001\u0000"+
		"\u0000\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0013\u0005;\u0000"+
		"\u0000\u0012\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000"+
		"\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000"+
		"\u0000\u0015\u0018\u0001\u0000\u0000\u0000\u0016\u0017\u0005\u0001\u0000"+
		"\u0000\u0017\u0019\u0005;\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000"+
		"\u001a\u001c\u0005\u0002\u0000\u0000\u001b\u0012\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000"+
		"\u001d\u001f\u0003\u0004\u0002\u0000\u001e \u0005:\u0000\u0000\u001f\u001e"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0003\u0001\u0000"+
		"\u0000\u0000!\"\u0005\n\u0000\u0000\"#\u0005\u0003\u0000\u0000#2\u0005"+
		"8\u0000\u0000$%\u0005\u0019\u0000\u0000%2\u0007\u0000\u0000\u0000&\'\u0005"+
		"$\u0000\u0000\'2\u00057\u0000\u0000()\u00050\u0000\u0000)2\u0005;\u0000"+
		"\u0000*+\u00051\u0000\u0000+2\u0005;\u0000\u0000,-\u00052\u0000\u0000"+
		"-2\u0005;\u0000\u0000.2\u0005\u0004\u0000\u0000/2\u0005\u0005\u0000\u0000"+
		"02\u0005\u0006\u0000\u00001!\u0001\u0000\u0000\u00001$\u0001\u0000\u0000"+
		"\u00001&\u0001\u0000\u0000\u00001(\u0001\u0000\u0000\u00001*\u0001\u0000"+
		"\u0000\u00001,\u0001\u0000\u0000\u00001.\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000010\u0001\u0000\u0000\u00002\u0005\u0001\u0000\u0000"+
		"\u0000\b\t\f\u000f\u0014\u0018\u001b\u001f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}