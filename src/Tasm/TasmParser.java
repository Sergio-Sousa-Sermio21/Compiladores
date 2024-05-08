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
		FCONST=42, JUMP=43, JUMPT=44, JUMPF=45, GALLOC=46, GLOAD=47, GSTORE=48, 
		HALT=49, STRING=50, DOUBLE=51, INT=52, EOL=53, LABEL=54, WS=55;
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
			"'jumpt'", "'jumpf'", "'galloc'", "'gload'", "'gstore'", "'halt'", null, 
			null, null, "'\\n'"
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
			"JUMPT", "JUMPF", "GALLOC", "GLOAD", "GSTORE", "HALT", "STRING", "DOUBLE", 
			"INT", "EOL", "LABEL", "WS"
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

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			setState(70);
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
				enterOuterAlt(_localctx, 11);
				{
				setState(66);
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
				enterOuterAlt(_localctx, 12);
				{
				setState(67);
				doubleinstruction();
				}
				break;
			case SPRINT:
			case SADD:
			case SEQ:
			case SNEQ:
				_localctx = new InstrucaoStringContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(68);
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
				enterOuterAlt(_localctx, 14);
				{
				setState(69);
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
			setState(72);
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
			setState(74);
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
			setState(76);
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
			setState(78);
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
		"\u0004\u00017Q\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
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
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002G\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0000\u0007\u0000\u0002\u0004"+
		"\u0006\b\n\f\u0000\u0005\u0001\u000034\u0001\u0000\u0004\u0010\u0001\u0000"+
		"\u0012\u001c\u0001\u0000\u001e!\u0001\u0000\"*[\u0000\u000e\u0001\u0000"+
		"\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004F\u0001\u0000\u0000\u0000"+
		"\u0006H\u0001\u0000\u0000\u0000\bJ\u0001\u0000\u0000\u0000\nL\u0001\u0000"+
		"\u0000\u0000\fN\u0001\u0000\u0000\u0000\u000e\u0017\u0003\u0002\u0001"+
		"\u0000\u000f\u0011\u00055\u0000\u0000\u0010\u000f\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0010\u0001\u0000\u0000\u0000"+
		"\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000"+
		"\u0014\u0016\u0003\u0002\u0001\u0000\u0015\u0010\u0001\u0000\u0000\u0000"+
		"\u0016\u0019\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u001d\u0001\u0000\u0000\u0000"+
		"\u0019\u0017\u0001\u0000\u0000\u0000\u001a\u001c\u00055\u0000\u0000\u001b"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e"+
		" \u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 !\u0005"+
		"\u0000\u0000\u0001!\u0001\u0001\u0000\u0000\u0000\"\'\u00056\u0000\u0000"+
		"#$\u0005\u0001\u0000\u0000$&\u00056\u0000\u0000%#\u0001\u0000\u0000\u0000"+
		"&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000"+
		"\u0000(*\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*,\u0005\u0002"+
		"\u0000\u0000+\"\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001"+
		"\u0000\u0000\u0000-.\u0003\u0004\u0002\u0000.\u0003\u0001\u0000\u0000"+
		"\u0000/0\u0005\u0003\u0000\u00000G\u00054\u0000\u000012\u0005\u0011\u0000"+
		"\u00002G\u0007\u0000\u0000\u000034\u0005\u001d\u0000\u00004G\u00052\u0000"+
		"\u000056\u0005+\u0000\u00006G\u00056\u0000\u000078\u0005,\u0000\u0000"+
		"8G\u00056\u0000\u00009:\u0005-\u0000\u0000:G\u00056\u0000\u0000;<\u0005"+
		".\u0000\u0000<G\u00054\u0000\u0000=>\u0005/\u0000\u0000>G\u00054\u0000"+
		"\u0000?@\u00050\u0000\u0000@G\u00054\u0000\u0000AG\u00051\u0000\u0000"+
		"BG\u0003\u0006\u0003\u0000CG\u0003\b\u0004\u0000DG\u0003\n\u0005\u0000"+
		"EG\u0003\f\u0006\u0000F/\u0001\u0000\u0000\u0000F1\u0001\u0000\u0000\u0000"+
		"F3\u0001\u0000\u0000\u0000F5\u0001\u0000\u0000\u0000F7\u0001\u0000\u0000"+
		"\u0000F9\u0001\u0000\u0000\u0000F;\u0001\u0000\u0000\u0000F=\u0001\u0000"+
		"\u0000\u0000F?\u0001\u0000\u0000\u0000FA\u0001\u0000\u0000\u0000FB\u0001"+
		"\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"FE\u0001\u0000\u0000\u0000G\u0005\u0001\u0000\u0000\u0000HI\u0007\u0001"+
		"\u0000\u0000I\u0007\u0001\u0000\u0000\u0000JK\u0007\u0002\u0000\u0000"+
		"K\t\u0001\u0000\u0000\u0000LM\u0007\u0003\u0000\u0000M\u000b\u0001\u0000"+
		"\u0000\u0000NO\u0007\u0004\u0000\u0000O\r\u0001\u0000\u0000\u0000\u0006"+
		"\u0012\u0017\u001d\'+F";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}