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
		T__0=1, T__1=2, INTINSTRUCTION=3, DOUBLEINSTRUCTION=4, STRINGINSTRUCTION=5, 
		INTVALUE=6, STRINGVALUE=7, DOUBLEVALUE=8, DOUBLE=9, DNEQ=10, ITOD=11, 
		ICONST=12, IPRINT=13, IUMINUS=14, IADD=15, SADD=16, ISUB=17, IMULT=18, 
		IDIV=19, IMOD=20, IEQ=21, INEQ=22, ILT=23, ILEQ=24, ITOP=25, ITOS=26, 
		DCONST=27, DPRINT=28, DUMINUS=29, DADD=30, DSUB=31, DMULT=32, DDIV=33, 
		DEQ=34, DLT=35, DLEQ=36, DTOS=37, SCONST=38, SPRINT=39, SEQ=40, SNEQ=41, 
		BCONST=42, BPRINT=43, BEQ=44, BNEQ=45, AND=46, OR=47, NOT=48, BTOS=49, 
		JUMP=50, JUMPT=51, JUMPF=52, GALLOC=53, GLOAD=54, GSTORE=55, BOOLEAN=56, 
		STRING=57, INT=58, HALT=59, EOL=60, LABEL=61, WS=62;
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
			null, "','", "':'", null, null, null, null, null, null, null, "'dneq'", 
			"'itod'", "'iconst'", "'iprint'", "'iuminus'", "'iadd'", "'sadd'", "'isub'", 
			"'imult'", "'idiv'", "'imod'", "'ieq'", "'ineq'", "'ilt'", "'ileq'", 
			"'itop'", "'itos'", "'dconst'", "'dprint'", "'duminus'", "'dadd'", "'dsub'", 
			"'dmult'", "'ddiv'", "'deq'", "'dlt'", "'dleq'", "'dtos'", "'sconst'", 
			"'sprint'", "'seq'", "'sneq'", "'bconst'", "'bprint'", "'beq'", "'bneq'", 
			"'and'", "'or'", "'not'", "'btos'", "'jump'", "'jumpt'", "'jumpf'", "'galloc'", 
			"'gload'", "'gstore'", null, null, null, "'halt'", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "INTINSTRUCTION", "DOUBLEINSTRUCTION", "STRINGINSTRUCTION", 
			"INTVALUE", "STRINGVALUE", "DOUBLEVALUE", "DOUBLE", "DNEQ", "ITOD", "ICONST", 
			"IPRINT", "IUMINUS", "IADD", "SADD", "ISUB", "IMULT", "IDIV", "IMOD", 
			"IEQ", "INEQ", "ILT", "ILEQ", "ITOP", "ITOS", "DCONST", "DPRINT", "DUMINUS", 
			"DADD", "DSUB", "DMULT", "DDIV", "DEQ", "DLT", "DLEQ", "DTOS", "SCONST", 
			"SPRINT", "SEQ", "SNEQ", "BCONST", "BPRINT", "BEQ", "BNEQ", "AND", "OR", 
			"NOT", "BTOS", "JUMP", "JUMPT", "JUMPF", "GALLOC", "GLOAD", "GSTORE", 
			"BOOLEAN", "STRING", "INT", "HALT", "EOL", "LABEL", "WS"
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
			case INTVALUE:
			case STRINGVALUE:
			case DOUBLEVALUE:
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2313724308561592824L) != 0) );
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
	public static class DOUBLEVALUEContext extends InstructionContext {
		public TerminalNode DOUBLEVALUE() { return getToken(TasmParser.DOUBLEVALUE, 0); }
		public DOUBLEVALUEContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDOUBLEVALUE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDOUBLEVALUE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDOUBLEVALUE(this);
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
	public static class STRINGVALUEContext extends InstructionContext {
		public TerminalNode STRINGVALUE() { return getToken(TasmParser.STRINGVALUE, 0); }
		public STRINGVALUEContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterSTRINGVALUE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitSTRINGVALUE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitSTRINGVALUE(this);
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
		public TerminalNode INTVALUE() { return getToken(TasmParser.INTVALUE, 0); }
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
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTVALUE:
				_localctx = new INTVALUEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(INTVALUE);
				}
				break;
			case DOUBLEVALUE:
				_localctx = new DOUBLEVALUEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(DOUBLEVALUE);
				}
				break;
			case STRINGVALUE:
				_localctx = new STRINGVALUEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				match(STRINGVALUE);
				}
				break;
			case JUMP:
				_localctx = new JUMPContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				match(JUMP);
				setState(37);
				match(LABEL);
				}
				break;
			case JUMPT:
				_localctx = new JUMPTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				match(JUMPT);
				setState(39);
				match(LABEL);
				}
				break;
			case JUMPF:
				_localctx = new JUMPFContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				match(JUMPF);
				setState(41);
				match(LABEL);
				}
				break;
			case INTINSTRUCTION:
				_localctx = new INTINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				match(INTINSTRUCTION);
				}
				break;
			case DOUBLEINSTRUCTION:
				_localctx = new DOUBLEINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(43);
				match(DOUBLEINSTRUCTION);
				}
				break;
			case STRINGINSTRUCTION:
				_localctx = new STRINGINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(44);
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
		"\u0004\u0001>0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0001\u0000\u0004\u0000\b\b\u0000\u000b\u0000\f\u0000\t\u0001"+
		"\u0000\u0003\u0000\r\b\u0000\u0001\u0000\u0003\u0000\u0010\b\u0000\u0001"+
		"\u0001\u0004\u0001\u0013\b\u0001\u000b\u0001\f\u0001\u0014\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0019\b\u0001\u0001\u0001\u0003\u0001\u001c\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002.\b"+
		"\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002\u0004\u0000\u0000;\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u0004"+
		"-\u0001\u0000\u0000\u0000\u0006\b\u0003\u0002\u0001\u0000\u0007\u0006"+
		"\u0001\u0000\u0000\u0000\b\t\u0001\u0000\u0000\u0000\t\u0007\u0001\u0000"+
		"\u0000\u0000\t\n\u0001\u0000\u0000\u0000\n\u0010\u0001\u0000\u0000\u0000"+
		"\u000b\r\u0005;\u0000\u0000\f\u000b\u0001\u0000\u0000\u0000\f\r\u0001"+
		"\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u0010\u0005\u0000"+
		"\u0000\u0001\u000f\u0007\u0001\u0000\u0000\u0000\u000f\f\u0001\u0000\u0000"+
		"\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0013\u0005=\u0000\u0000"+
		"\u0012\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000"+
		"\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000"+
		"\u0015\u0018\u0001\u0000\u0000\u0000\u0016\u0017\u0005\u0001\u0000\u0000"+
		"\u0017\u0019\u0005=\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a"+
		"\u001c\u0005\u0002\u0000\u0000\u001b\u0012\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d"+
		"\u001f\u0003\u0004\u0002\u0000\u001e \u0005<\u0000\u0000\u001f\u001e\u0001"+
		"\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0003\u0001\u0000\u0000"+
		"\u0000!.\u0005\u0006\u0000\u0000\".\u0005\b\u0000\u0000#.\u0005\u0007"+
		"\u0000\u0000$%\u00052\u0000\u0000%.\u0005=\u0000\u0000&\'\u00053\u0000"+
		"\u0000\'.\u0005=\u0000\u0000()\u00054\u0000\u0000).\u0005=\u0000\u0000"+
		"*.\u0005\u0003\u0000\u0000+.\u0005\u0004\u0000\u0000,.\u0005\u0005\u0000"+
		"\u0000-!\u0001\u0000\u0000\u0000-\"\u0001\u0000\u0000\u0000-#\u0001\u0000"+
		"\u0000\u0000-$\u0001\u0000\u0000\u0000-&\u0001\u0000\u0000\u0000-(\u0001"+
		"\u0000\u0000\u0000-*\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000"+
		"-,\u0001\u0000\u0000\u0000.\u0005\u0001\u0000\u0000\u0000\b\t\f\u000f"+
		"\u0014\u0018\u001b\u001f-";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}