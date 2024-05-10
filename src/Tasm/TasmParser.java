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
		T__0=1, T__1=2, ICONST=3, IUMINUS=4, IADD=5, ISUB=6, IMULT=7, IDIV=8, 
		IMOD=9, IEQ=10, INEQ=11, ILT=12, ILEQ=13, ITOS=14, ITOD=15, IPRINT=16, 
		DCONST=17, DUMINUS=18, DADD=19, DSUB=20, DMULT=21, DDIV=22, DEQ=23, DLT=24, 
		DLEQ=25, DTOS=26, DNEQ=27, DPRINT=28, SCONST=29, SPRINT=30, SADD=31, SEQ=32, 
		SNEQ=33, BPRINT=34, BEQ=35, BNEQ=36, AND=37, OR=38, NOT=39, BTOS=40, TCONST=41, 
		FCONST=42, JUMP=43, JUMPT=44, JUMPF=45, CALL=46, GALLOC=47, GLOAD=48, 
		GSTORE=49, LALLOC=50, LLOAD=51, LSTORE=52, RETVAL=53, RET=54, POP=55, 
		HALT=56, STRING=57, DOUBLE=58, INT=59, NEGATIVE=60, EOL=61, LABEL=62, 
		WS=63;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_instruction = 2, RULE_intinstruction = 3, 
		RULE_doubleinstruction = 4, RULE_stringinstruction = 5, RULE_booleaninstruction = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "instruction", "intinstruction", "doubleinstruction", 
			"stringinstruction", "booleaninstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "':'", "'iconst'", "'iuminus'", "'iadd'", "'isub'", "'imult'", 
			"'idiv'", "'imod'", "'ieq'", "'ineq'", "'ilt'", "'ileq'", "'itos'", "'itod'", 
			"'iprint'", "'dconst'", "'duminus'", "'dadd'", "'dsub'", "'dmult'", "'ddiv'", 
			"'deq'", "'dlt'", "'dleq'", "'dtos'", "'dneq'", "'dprint'", "'sconst'", 
			"'sprint'", "'sadd'", "'seq'", "'sneq'", "'bprint'", "'beq'", "'bneq'", 
			"'and'", "'or'", "'not'", "'btos'", "'tconst'", "'fconst'", "'jump'", 
			"'jumpt'", "'jumpf'", "'call'", "'galloc'", "'gload'", "'gstore'", "'lalloc'", 
			"'lload'", "'lstore'", "'retval'", "'ret'", "'pop'", "'halt'", null, 
			null, null, null, "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "ICONST", "IUMINUS", "IADD", "ISUB", "IMULT", "IDIV", 
			"IMOD", "IEQ", "INEQ", "ILT", "ILEQ", "ITOS", "ITOD", "IPRINT", "DCONST", 
			"DUMINUS", "DADD", "DSUB", "DMULT", "DDIV", "DEQ", "DLT", "DLEQ", "DTOS", 
			"DNEQ", "DPRINT", "SCONST", "SPRINT", "SADD", "SEQ", "SNEQ", "BPRINT", 
			"BEQ", "BNEQ", "AND", "OR", "NOT", "BTOS", "TCONST", "FCONST", "JUMP", 
			"JUMPT", "JUMPF", "CALL", "GALLOC", "GLOAD", "GSTORE", "LALLOC", "LLOAD", 
			"LSTORE", "RETVAL", "RET", "POP", "HALT", "STRING", "DOUBLE", "INT", 
			"NEGATIVE", "EOL", "LABEL", "WS"
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
		public List<TerminalNode> EOL() { return getTokens(TasmParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(TasmParser.EOL, i);
		}
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			expression();
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(16); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(15);
						match(EOL);
						}
						}
						setState(18); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==EOL );
					setState(20);
					expression();
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(26);
				match(EOL);
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				{
				setState(34);
				match(LABEL);
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(35);
					match(T__0);
					setState(36);
					match(LABEL);
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(42);
				match(T__1);
				}
			}

			setState(45);
			instruction();
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
	public static class HALTContext extends InstructionContext {
		public TerminalNode HALT() { return getToken(TasmParser.HALT, 0); }
		public HALTContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterHALT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitHALT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitHALT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LLOADContext extends InstructionContext {
		public TerminalNode LLOAD() { return getToken(TasmParser.LLOAD, 0); }
		public TerminalNode NEGATIVE() { return getToken(TasmParser.NEGATIVE, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public LLOADContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterLLOAD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitLLOAD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitLLOAD(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RETContext extends InstructionContext {
		public TerminalNode RET() { return getToken(TasmParser.RET, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public RETContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterRET(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitRET(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitRET(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GLOADContext extends InstructionContext {
		public TerminalNode GLOAD() { return getToken(TasmParser.GLOAD, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public GLOADContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterGLOAD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitGLOAD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitGLOAD(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CALLContext extends InstructionContext {
		public TerminalNode CALL() { return getToken(TasmParser.CALL, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public CALLContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterCALL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitCALL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitCALL(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RETVALContext extends InstructionContext {
		public TerminalNode RETVAL() { return getToken(TasmParser.RETVAL, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public RETVALContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterRETVAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitRETVAL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitRETVAL(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstrucaoIntContext extends InstructionContext {
		public IntinstructionContext intinstruction() {
			return getRuleContext(IntinstructionContext.class,0);
		}
		public InstrucaoIntContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterInstrucaoInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitInstrucaoInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitInstrucaoInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstrucaoStringContext extends InstructionContext {
		public StringinstructionContext stringinstruction() {
			return getRuleContext(StringinstructionContext.class,0);
		}
		public InstrucaoStringContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterInstrucaoString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitInstrucaoString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitInstrucaoString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOUBLEVALUEContext extends InstructionContext {
		public TerminalNode DCONST() { return getToken(TasmParser.DCONST, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(TasmParser.DOUBLE, 0); }
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
	public static class InstrucaoDoubleContext extends InstructionContext {
		public DoubleinstructionContext doubleinstruction() {
			return getRuleContext(DoubleinstructionContext.class,0);
		}
		public InstrucaoDoubleContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterInstrucaoDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitInstrucaoDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitInstrucaoDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STRINGVALUEContext extends InstructionContext {
		public TerminalNode SCONST() { return getToken(TasmParser.SCONST, 0); }
		public TerminalNode STRING() { return getToken(TasmParser.STRING, 0); }
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
	public static class InstrucaoBooleanContext extends InstructionContext {
		public BooleaninstructionContext booleaninstruction() {
			return getRuleContext(BooleaninstructionContext.class,0);
		}
		public InstrucaoBooleanContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterInstrucaoBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitInstrucaoBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitInstrucaoBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LALLOCContext extends InstructionContext {
		public TerminalNode LALLOC() { return getToken(TasmParser.LALLOC, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public LALLOCContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterLALLOC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitLALLOC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitLALLOC(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class POPContext extends InstructionContext {
		public TerminalNode POP() { return getToken(TasmParser.POP, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public POPContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterPOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitPOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitPOP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GALLOCContext extends InstructionContext {
		public TerminalNode GALLOC() { return getToken(TasmParser.GALLOC, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public GALLOCContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterGALLOC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitGALLOC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitGALLOC(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GSTOREContext extends InstructionContext {
		public TerminalNode GSTORE() { return getToken(TasmParser.GSTORE, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public GSTOREContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterGSTORE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitGSTORE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitGSTORE(this);
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
	public static class LSTOREContext extends InstructionContext {
		public TerminalNode LSTORE() { return getToken(TasmParser.LSTORE, 0); }
		public TerminalNode NEGATIVE() { return getToken(TasmParser.NEGATIVE, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public LSTOREContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterLSTORE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitLSTORE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitLSTORE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICONST:
				_localctx = new INTVALUEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(ICONST);
				setState(48);
				match(INT);
				}
				break;
			case DCONST:
				_localctx = new DOUBLEVALUEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(49);
				match(DCONST);
				setState(50);
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
				}
				break;
			case SCONST:
				_localctx = new STRINGVALUEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				match(SCONST);
				setState(52);
				match(STRING);
				}
				break;
			case JUMP:
				_localctx = new JUMPContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				match(JUMP);
				setState(54);
				match(LABEL);
				}
				break;
			case JUMPT:
				_localctx = new JUMPTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				match(JUMPT);
				setState(56);
				match(LABEL);
				}
				break;
			case JUMPF:
				_localctx = new JUMPFContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(57);
				match(JUMPF);
				setState(58);
				match(LABEL);
				}
				break;
			case GALLOC:
				_localctx = new GALLOCContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(59);
				match(GALLOC);
				setState(60);
				match(INT);
				}
				break;
			case GLOAD:
				_localctx = new GLOADContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(61);
				match(GLOAD);
				setState(62);
				match(INT);
				}
				break;
			case GSTORE:
				_localctx = new GSTOREContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(63);
				match(GSTORE);
				setState(64);
				match(INT);
				}
				break;
			case HALT:
				_localctx = new HALTContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(65);
				match(HALT);
				}
				break;
			case LALLOC:
				_localctx = new LALLOCContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(66);
				match(LALLOC);
				setState(67);
				match(INT);
				}
				break;
			case LLOAD:
				_localctx = new LLOADContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(68);
				match(LLOAD);
				setState(69);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==NEGATIVE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case LSTORE:
				_localctx = new LSTOREContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(70);
				match(LSTORE);
				setState(71);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==NEGATIVE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case POP:
				_localctx = new POPContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(72);
				match(POP);
				setState(73);
				match(INT);
				}
				break;
			case CALL:
				_localctx = new CALLContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(74);
				match(CALL);
				setState(75);
				match(LABEL);
				}
				break;
			case RETVAL:
				_localctx = new RETVALContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(76);
				match(RETVAL);
				setState(77);
				match(INT);
				}
				break;
			case RET:
				_localctx = new RETContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(78);
				match(RET);
				setState(79);
				match(INT);
				}
				break;
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
			case ITOS:
			case ITOD:
			case IPRINT:
				_localctx = new InstrucaoIntContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(80);
				intinstruction();
				}
				break;
			case DUMINUS:
			case DADD:
			case DSUB:
			case DMULT:
			case DDIV:
			case DEQ:
			case DLT:
			case DLEQ:
			case DTOS:
			case DNEQ:
			case DPRINT:
				_localctx = new InstrucaoDoubleContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(81);
				doubleinstruction();
				}
				break;
			case SPRINT:
			case SADD:
			case SEQ:
			case SNEQ:
				_localctx = new InstrucaoStringContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(82);
				stringinstruction();
				}
				break;
			case BPRINT:
			case BEQ:
			case BNEQ:
			case AND:
			case OR:
			case NOT:
			case BTOS:
			case TCONST:
			case FCONST:
				_localctx = new InstrucaoBooleanContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(83);
				booleaninstruction();
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
			setState(86);
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
			setState(88);
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
	public static class StringinstructionContext extends ParserRuleContext {
		public TerminalNode SADD() { return getToken(TasmParser.SADD, 0); }
		public TerminalNode SEQ() { return getToken(TasmParser.SEQ, 0); }
		public TerminalNode SNEQ() { return getToken(TasmParser.SNEQ, 0); }
		public TerminalNode SPRINT() { return getToken(TasmParser.SPRINT, 0); }
		public StringinstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringinstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterStringinstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitStringinstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitStringinstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringinstructionContext stringinstruction() throws RecognitionException {
		StringinstructionContext _localctx = new StringinstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stringinstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
	public static class BooleaninstructionContext extends ParserRuleContext {
		public TerminalNode BPRINT() { return getToken(TasmParser.BPRINT, 0); }
		public TerminalNode BEQ() { return getToken(TasmParser.BEQ, 0); }
		public TerminalNode BNEQ() { return getToken(TasmParser.BNEQ, 0); }
		public TerminalNode AND() { return getToken(TasmParser.AND, 0); }
		public TerminalNode OR() { return getToken(TasmParser.OR, 0); }
		public TerminalNode NOT() { return getToken(TasmParser.NOT, 0); }
		public TerminalNode BTOS() { return getToken(TasmParser.BTOS, 0); }
		public TerminalNode TCONST() { return getToken(TasmParser.TCONST, 0); }
		public TerminalNode FCONST() { return getToken(TasmParser.FCONST, 0); }
		public BooleaninstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleaninstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterBooleaninstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitBooleaninstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitBooleaninstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleaninstructionContext booleaninstruction() throws RecognitionException {
		BooleaninstructionContext _localctx = new BooleaninstructionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_booleaninstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
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

	public static final String _serializedATN =
		"\u0004\u0001?_\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0004\u0000"+
		"\u0011\b\u0000\u000b\u0000\f\u0000\u0012\u0001\u0000\u0005\u0000\u0016"+
		"\b\u0000\n\u0000\f\u0000\u0019\t\u0000\u0001\u0000\u0005\u0000\u001c\b"+
		"\u0000\n\u0000\f\u0000\u001f\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001&\b\u0001\n\u0001\f\u0001)\t\u0001"+
		"\u0001\u0001\u0003\u0001,\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002U\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0000"+
		"\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0006\u0001\u0000:;\u0001\u0000"+
		";<\u0001\u0000\u0004\u0010\u0001\u0000\u0012\u001c\u0001\u0000\u001e!"+
		"\u0001\u0000\"*p\u0000\u000e\u0001\u0000\u0000\u0000\u0002+\u0001\u0000"+
		"\u0000\u0000\u0004T\u0001\u0000\u0000\u0000\u0006V\u0001\u0000\u0000\u0000"+
		"\bX\u0001\u0000\u0000\u0000\nZ\u0001\u0000\u0000\u0000\f\\\u0001\u0000"+
		"\u0000\u0000\u000e\u0017\u0003\u0002\u0001\u0000\u000f\u0011\u0005=\u0000"+
		"\u0000\u0010\u000f\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000"+
		"\u0000\u0012\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000"+
		"\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0016\u0003\u0002\u0001"+
		"\u0000\u0015\u0010\u0001\u0000\u0000\u0000\u0016\u0019\u0001\u0000\u0000"+
		"\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000"+
		"\u0000\u0018\u001d\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000"+
		"\u0000\u001a\u001c\u0005=\u0000\u0000\u001b\u001a\u0001\u0000\u0000\u0000"+
		"\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0001\u0000\u0000\u0000\u001e \u0001\u0000\u0000\u0000\u001f"+
		"\u001d\u0001\u0000\u0000\u0000 !\u0005\u0000\u0000\u0001!\u0001\u0001"+
		"\u0000\u0000\u0000\"\'\u0005>\u0000\u0000#$\u0005\u0001\u0000\u0000$&"+
		"\u0005>\u0000\u0000%#\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000"+
		"\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(*\u0001\u0000\u0000"+
		"\u0000)\'\u0001\u0000\u0000\u0000*,\u0005\u0002\u0000\u0000+\"\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0003"+
		"\u0004\u0002\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0005\u0003\u0000"+
		"\u00000U\u0005;\u0000\u000012\u0005\u0011\u0000\u00002U\u0007\u0000\u0000"+
		"\u000034\u0005\u001d\u0000\u00004U\u00059\u0000\u000056\u0005+\u0000\u0000"+
		"6U\u0005>\u0000\u000078\u0005,\u0000\u00008U\u0005>\u0000\u00009:\u0005"+
		"-\u0000\u0000:U\u0005>\u0000\u0000;<\u0005/\u0000\u0000<U\u0005;\u0000"+
		"\u0000=>\u00050\u0000\u0000>U\u0005;\u0000\u0000?@\u00051\u0000\u0000"+
		"@U\u0005;\u0000\u0000AU\u00058\u0000\u0000BC\u00052\u0000\u0000CU\u0005"+
		";\u0000\u0000DE\u00053\u0000\u0000EU\u0007\u0001\u0000\u0000FG\u00054"+
		"\u0000\u0000GU\u0007\u0001\u0000\u0000HI\u00057\u0000\u0000IU\u0005;\u0000"+
		"\u0000JK\u0005.\u0000\u0000KU\u0005>\u0000\u0000LM\u00055\u0000\u0000"+
		"MU\u0005;\u0000\u0000NO\u00056\u0000\u0000OU\u0005;\u0000\u0000PU\u0003"+
		"\u0006\u0003\u0000QU\u0003\b\u0004\u0000RU\u0003\n\u0005\u0000SU\u0003"+
		"\f\u0006\u0000T/\u0001\u0000\u0000\u0000T1\u0001\u0000\u0000\u0000T3\u0001"+
		"\u0000\u0000\u0000T5\u0001\u0000\u0000\u0000T7\u0001\u0000\u0000\u0000"+
		"T9\u0001\u0000\u0000\u0000T;\u0001\u0000\u0000\u0000T=\u0001\u0000\u0000"+
		"\u0000T?\u0001\u0000\u0000\u0000TA\u0001\u0000\u0000\u0000TB\u0001\u0000"+
		"\u0000\u0000TD\u0001\u0000\u0000\u0000TF\u0001\u0000\u0000\u0000TH\u0001"+
		"\u0000\u0000\u0000TJ\u0001\u0000\u0000\u0000TL\u0001\u0000\u0000\u0000"+
		"TN\u0001\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000"+
		"\u0000TR\u0001\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000U\u0005\u0001"+
		"\u0000\u0000\u0000VW\u0007\u0002\u0000\u0000W\u0007\u0001\u0000\u0000"+
		"\u0000XY\u0007\u0003\u0000\u0000Y\t\u0001\u0000\u0000\u0000Z[\u0007\u0004"+
		"\u0000\u0000[\u000b\u0001\u0000\u0000\u0000\\]\u0007\u0005\u0000\u0000"+
		"]\r\u0001\u0000\u0000\u0000\u0006\u0012\u0017\u001d\'+T";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}