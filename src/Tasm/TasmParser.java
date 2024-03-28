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
		T__0=1, DOUBLE=2, DNEQ=3, ITOD=4, ICONST=5, IPRINT=6, IUMINUS=7, IADD=8, 
		SADD=9, ISUB=10, IMULT=11, IDIV=12, IMOD=13, IEQ=14, INEQ=15, ILT=16, 
		ILEQ=17, ITOP=18, ITOS=19, DCONST=20, DPRINT=21, DUMINUS=22, DADD=23, 
		DSUB=24, DMULT=25, DDIV=26, DEQ=27, DLT=28, DLEQ=29, DTOS=30, SCONST=31, 
		SPRINT=32, SEQ=33, SNEQ=34, BCONST=35, BPRINT=36, BEQ=37, BNEQ=38, AND=39, 
		OR=40, NOT=41, BTOS=42, JUMP=43, JUMPT=44, JUMPF=45, GALLOC=46, GLOAD=47, 
		GSTORE=48, BOOLEAN=49, STRING=50, INT=51, REAL_CONST=52, UNSIGNED_INT=53, 
		UNSIGNED_REAL=54, CHARACTER=55, HALT=56, EOL=57, LABEL=58, WS=59;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_instruction = 2, RULE_intinstruction = 3, 
		RULE_doubleinstruction = 4, RULE_strinstruction = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "instruction", "intinstruction", "doubleinstruction", 
			"strinstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, "'dneq'", "'itod'", "'iconst'", "'iprint'", "'iuminis'", 
			"'iadd'", "'sadd'", "'isub'", "'imult'", "'idiv'", "'imod'", "'ieq'", 
			"'ineq'", "'ilt'", "'ileq'", "'itop'", "'itos'", "'dconst'", "'dprint'", 
			"'duminus'", "'dadd'", "'dsub'", "'dmult'", "'ddiv'", "'deq'", "'dlt'", 
			"'dleq'", "'dtos'", "'sconst'", "'sprint'", "'seq'", "'sneq'", "'bconst'", 
			"'bprint'", "'beq'", "'bneq'", "'and'", "'or'", "'not'", "'btos'", "'jump'", 
			"'jumpt'", "'jumpf'", "'galloc'", "'gload'", "'gstore'", null, null, 
			null, null, null, null, null, "'halt'", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "DOUBLE", "DNEQ", "ITOD", "ICONST", "IPRINT", "IUMINUS", 
			"IADD", "SADD", "ISUB", "IMULT", "IDIV", "IMOD", "IEQ", "INEQ", "ILT", 
			"ILEQ", "ITOP", "ITOS", "DCONST", "DPRINT", "DUMINUS", "DADD", "DSUB", 
			"DMULT", "DDIV", "DEQ", "DLT", "DLEQ", "DTOS", "SCONST", "SPRINT", "SEQ", 
			"SNEQ", "BCONST", "BPRINT", "BEQ", "BNEQ", "AND", "OR", "NOT", "BTOS", 
			"JUMP", "JUMPT", "JUMPF", "GALLOC", "GLOAD", "GSTORE", "BOOLEAN", "STRING", 
			"INT", "REAL_CONST", "UNSIGNED_INT", "UNSIGNED_REAL", "CHARACTER", "HALT", 
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
		public TerminalNode EOF() { return getToken(TasmParser.EOF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
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
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				expression();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 288291983162605562L) != 0) );
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HALT) {
				{
				setState(17);
				match(HALT);
				}
			}

			setState(20);
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==LABEL) {
				{
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LABEL) {
					{
					{
					setState(22);
					match(LABEL);
					}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(28);
				match(T__0);
				}
			}

			setState(31);
			instruction();
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(32);
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
	public static class INTIINSTRUCTIONContext extends InstructionContext {
		public IntinstructionContext intinstruction() {
			return getRuleContext(IntinstructionContext.class,0);
		}
		public INTIINSTRUCTIONContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterINTIINSTRUCTION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitINTIINSTRUCTION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitINTIINSTRUCTION(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOUBLEINSTRUCTIONContext extends InstructionContext {
		public DoubleinstructionContext doubleinstruction() {
			return getRuleContext(DoubleinstructionContext.class,0);
		}
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
	public static class STRINGINSTRUCTIONContext extends InstructionContext {
		public StrinstructionContext strinstruction() {
			return getRuleContext(StrinstructionContext.class,0);
		}
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
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICONST:
				_localctx = new INTVALUEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(ICONST);
				setState(36);
				match(INT);
				}
				break;
			case DCONST:
				_localctx = new DCONSTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(DCONST);
				setState(38);
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
				setState(39);
				match(SCONST);
				setState(40);
				match(STRING);
				}
				break;
			case JUMP:
				_localctx = new JUMPContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				match(JUMP);
				setState(42);
				match(LABEL);
				}
				break;
			case JUMPT:
				_localctx = new JUMPTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				match(JUMPT);
				setState(44);
				match(LABEL);
				}
				break;
			case JUMPF:
				_localctx = new JUMPFContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				match(JUMPF);
				setState(46);
				match(LABEL);
				}
				break;
			case ITOD:
			case IPRINT:
			case IUMINUS:
			case IADD:
			case ISUB:
			case IMULT:
			case IDIV:
			case IMOD:
			case IEQ:
			case INEQ:
			case ILT:
			case ILEQ:
			case ITOP:
			case ITOS:
				_localctx = new INTIINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(47);
				intinstruction();
				}
				break;
			case DNEQ:
			case DPRINT:
			case DUMINUS:
			case DADD:
			case DSUB:
			case DMULT:
			case DDIV:
			case DEQ:
			case DLT:
			case DLEQ:
			case DTOS:
				_localctx = new DOUBLEINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(48);
				doubleinstruction();
				}
				break;
			case SADD:
			case SPRINT:
			case SEQ:
			case SNEQ:
				_localctx = new STRINGINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(49);
				strinstruction();
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
	public static class IntinstructionContext extends ParserRuleContext {
		public TerminalNode IADD() { return getToken(TasmParser.IADD, 0); }
		public TerminalNode IDIV() { return getToken(TasmParser.IDIV, 0); }
		public TerminalNode IEQ() { return getToken(TasmParser.IEQ, 0); }
		public TerminalNode ILEQ() { return getToken(TasmParser.ILEQ, 0); }
		public TerminalNode IMOD() { return getToken(TasmParser.IMOD, 0); }
		public TerminalNode IMULT() { return getToken(TasmParser.IMULT, 0); }
		public TerminalNode INEQ() { return getToken(TasmParser.INEQ, 0); }
		public TerminalNode IPRINT() { return getToken(TasmParser.IPRINT, 0); }
		public TerminalNode ISUB() { return getToken(TasmParser.ISUB, 0); }
		public TerminalNode ITOP() { return getToken(TasmParser.ITOP, 0); }
		public TerminalNode ITOS() { return getToken(TasmParser.ITOS, 0); }
		public TerminalNode IUMINUS() { return getToken(TasmParser.IUMINUS, 0); }
		public TerminalNode ILT() { return getToken(TasmParser.ILT, 0); }
		public TerminalNode ITOD() { return getToken(TasmParser.ITOD, 0); }
		public IntinstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intinstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIntinstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIntinstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIntinstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntinstructionContext intinstruction() throws RecognitionException {
		IntinstructionContext _localctx = new IntinstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_intinstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1048016L) != 0)) ) {
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
	public static class DoubleinstructionContext extends ParserRuleContext {
		public TerminalNode DADD() { return getToken(TasmParser.DADD, 0); }
		public TerminalNode DDIV() { return getToken(TasmParser.DDIV, 0); }
		public TerminalNode DEQ() { return getToken(TasmParser.DEQ, 0); }
		public TerminalNode DLEQ() { return getToken(TasmParser.DLEQ, 0); }
		public TerminalNode DLT() { return getToken(TasmParser.DLT, 0); }
		public TerminalNode DMULT() { return getToken(TasmParser.DMULT, 0); }
		public TerminalNode DPRINT() { return getToken(TasmParser.DPRINT, 0); }
		public TerminalNode DSUB() { return getToken(TasmParser.DSUB, 0); }
		public TerminalNode DTOS() { return getToken(TasmParser.DTOS, 0); }
		public TerminalNode DUMINUS() { return getToken(TasmParser.DUMINUS, 0); }
		public TerminalNode DNEQ() { return getToken(TasmParser.DNEQ, 0); }
		public DoubleinstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleinstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDoubleinstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDoubleinstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDoubleinstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleinstructionContext doubleinstruction() throws RecognitionException {
		DoubleinstructionContext _localctx = new DoubleinstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_doubleinstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2145386504L) != 0)) ) {
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
	public static class StrinstructionContext extends ParserRuleContext {
		public TerminalNode SADD() { return getToken(TasmParser.SADD, 0); }
		public TerminalNode SEQ() { return getToken(TasmParser.SEQ, 0); }
		public TerminalNode SNEQ() { return getToken(TasmParser.SNEQ, 0); }
		public TerminalNode SPRINT() { return getToken(TasmParser.SPRINT, 0); }
		public StrinstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strinstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterStrinstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitStrinstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitStrinstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrinstructionContext strinstruction() throws RecognitionException {
		StrinstructionContext _localctx = new StrinstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_strinstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771584L) != 0)) ) {
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
		"\u0004\u0001;;\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f\u0000"+
		"\u000f\u0001\u0000\u0003\u0000\u0013\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0005\u0001\u0018\b\u0001\n\u0001\f\u0001\u001b\t\u0001\u0001\u0001"+
		"\u0003\u0001\u001e\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00023\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0004\u0002\u0000"+
		"\u0002\u000233\u0003\u0000\u0004\u0004\u0006\b\n\u0013\u0002\u0000\u0003"+
		"\u0003\u0015\u001e\u0002\u0000\t\t \"A\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0002\u001d\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000\u0006"+
		"4\u0001\u0000\u0000\u0000\b6\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000"+
		"\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001\u0000\u0000\u0000\u000e"+
		"\u000f\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010"+
		"\u0001\u0000\u0000\u0000\u0010\u0012\u0001\u0000\u0000\u0000\u0011\u0013"+
		"\u00058\u0000\u0000\u0012\u0011\u0001\u0000\u0000\u0000\u0012\u0013\u0001"+
		"\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0015\u0005"+
		"\u0000\u0000\u0001\u0015\u0001\u0001\u0000\u0000\u0000\u0016\u0018\u0005"+
		":\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000"+
		"\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000"+
		"\u0000\u0000\u001c\u001e\u0005\u0001\u0000\u0000\u001d\u0019\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000"+
		"\u0000\u0000\u001f!\u0003\u0004\u0002\u0000 \"\u00059\u0000\u0000! \u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0003\u0001\u0000\u0000"+
		"\u0000#$\u0005\u0005\u0000\u0000$3\u00053\u0000\u0000%&\u0005\u0014\u0000"+
		"\u0000&3\u0007\u0000\u0000\u0000\'(\u0005\u001f\u0000\u0000(3\u00052\u0000"+
		"\u0000)*\u0005+\u0000\u0000*3\u0005:\u0000\u0000+,\u0005,\u0000\u0000"+
		",3\u0005:\u0000\u0000-.\u0005-\u0000\u0000.3\u0005:\u0000\u0000/3\u0003"+
		"\u0006\u0003\u000003\u0003\b\u0004\u000013\u0003\n\u0005\u00002#\u0001"+
		"\u0000\u0000\u00002%\u0001\u0000\u0000\u00002\'\u0001\u0000\u0000\u0000"+
		"2)\u0001\u0000\u0000\u00002+\u0001\u0000\u0000\u00002-\u0001\u0000\u0000"+
		"\u00002/\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000021\u0001\u0000"+
		"\u0000\u00003\u0005\u0001\u0000\u0000\u000045\u0007\u0001\u0000\u0000"+
		"5\u0007\u0001\u0000\u0000\u000067\u0007\u0002\u0000\u00007\t\u0001\u0000"+
		"\u0000\u000089\u0007\u0003\u0000\u00009\u000b\u0001\u0000\u0000\u0000"+
		"\u0006\u000f\u0012\u0019\u001d!2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}