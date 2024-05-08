// Generated from C:/Users/ASUS/Documents/Lab1typescript/Compiladores/src/Tasm.g4 by ANTLR 4.13.1
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
		T__0=1, T__1=2, DOUBLEINSTRUCTION=3, STRINGINSTRUCTION=4, BOLEANINSTRUCION=5, 
		ICONST=6, IUMINUS=7, IADD=8, ISUB=9, IMULT=10, IDIV=11, IMOD=12, IEQ=13, 
		INEQ=14, ILT=15, ILEQ=16, ITOS=17, ITOD=18, IPRINT=19, DCONST=20, DUMINUS=21, 
		DADD=22, DSUB=23, DMULT=24, DDIV=25, DEQ=26, DLT=27, DLEQ=28, DTOS=29, 
		DNEQ=30, DPRINT=31, SCONST=32, SPRINT=33, SADD=34, SEQ=35, SNEQ=36, BPRINT=37, 
		BEQ=38, BNEQ=39, AND=40, OR=41, NOT=42, BTOS=43, TCONST=44, FCONST=45, 
		JUMP=46, JUMPT=47, JUMPF=48, GALLOC=49, GLOAD=50, GSTORE=51, HALT=52, 
		STRING=53, DOUBLE=54, INT=55, EOL=56, LABEL=57, WS=58;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_instruction = 2, RULE_intinstruction = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "instruction", "intinstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "':'", null, null, null, "'iconst'", "'iuminus'", "'iadd'", 
			"'isub'", "'imult'", "'idiv'", "'imod'", "'ieq'", "'ineq'", "'ilt'", 
			"'ileq'", "'itos'", "'itod'", "'iprint'", "'dconst'", "'duminus'", "'dadd'", 
			"'dsub'", "'dmult'", "'ddiv'", "'deq'", "'dlt'", "'dleq'", "'dtos'", 
			"'dneq'", "'dprint'", "'sconst'", "'sprint'", "'sadd'", "'seq'", "'sneq'", 
			"'bprint'", "'beq'", "'bneq'", "'and'", "'or'", "'not'", "'btos'", "'tconst'", 
			"'fconst'", "'jump'", "'jumpt'", "'jumpf'", "'galloc'", "'gload'", "'gstore'", 
			"'halt'", null, null, null, "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "DOUBLEINSTRUCTION", "STRINGINSTRUCTION", "BOLEANINSTRUCION", 
			"ICONST", "IUMINUS", "IADD", "ISUB", "IMULT", "IDIV", "IMOD", "IEQ", 
			"INEQ", "ILT", "ILEQ", "ITOS", "ITOD", "IPRINT", "DCONST", "DUMINUS", 
			"DADD", "DSUB", "DMULT", "DDIV", "DEQ", "DLT", "DLEQ", "DTOS", "DNEQ", 
			"DPRINT", "SCONST", "SPRINT", "SADD", "SEQ", "SNEQ", "BPRINT", "BEQ", 
			"BNEQ", "AND", "OR", "NOT", "BTOS", "TCONST", "FCONST", "JUMP", "JUMPT", 
			"JUMPF", "GALLOC", "GLOAD", "GSTORE", "HALT", "STRING", "DOUBLE", "INT", 
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
			setState(8);
			expression();
			setState(17);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(10); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(9);
						match(EOL);
						}
						}
						setState(12); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==EOL );
					setState(14);
					expression();
					}
					} 
				}
				setState(19);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(20);
				match(EOL);
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				{
				setState(28);
				match(LABEL);
				}
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

			setState(39);
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
	public static class BOLEANINSTRUCIONContext extends InstructionContext {
		public TerminalNode BOLEANINSTRUCION() { return getToken(TasmParser.BOLEANINSTRUCION, 0); }
		public BOLEANINSTRUCIONContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterBOLEANINSTRUCION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitBOLEANINSTRUCION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitBOLEANINSTRUCION(this);
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
	public static class INTINSTRUCTIONContext extends InstructionContext {
		public IntinstructionContext intinstruction() {
			return getRuleContext(IntinstructionContext.class,0);
		}
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

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICONST:
				_localctx = new INTVALUEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(ICONST);
				setState(42);
				match(INT);
				}
				break;
			case DCONST:
				_localctx = new DOUBLEVALUEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(43);
				match(DCONST);
				setState(44);
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
				setState(45);
				match(SCONST);
				setState(46);
				match(STRING);
				}
				break;
			case JUMP:
				_localctx = new JUMPContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(JUMP);
				setState(48);
				match(LABEL);
				}
				break;
			case JUMPT:
				_localctx = new JUMPTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				match(JUMPT);
				setState(50);
				match(LABEL);
				}
				break;
			case JUMPF:
				_localctx = new JUMPFContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				match(JUMPF);
				setState(52);
				match(LABEL);
				}
				break;
			case GALLOC:
				_localctx = new GALLOCContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(53);
				match(GALLOC);
				setState(54);
				match(INT);
				}
				break;
			case GLOAD:
				_localctx = new GLOADContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(55);
				match(GLOAD);
				setState(56);
				match(INT);
				}
				break;
			case GSTORE:
				_localctx = new GSTOREContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(57);
				match(GSTORE);
				setState(58);
				match(INT);
				}
				break;
			case HALT:
				_localctx = new HALTContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(59);
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
				_localctx = new INTINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(60);
				intinstruction();
				}
				break;
			case DOUBLEINSTRUCTION:
				_localctx = new DOUBLEINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(61);
				match(DOUBLEINSTRUCTION);
				}
				break;
			case STRINGINSTRUCTION:
				_localctx = new STRINGINSTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(62);
				match(STRINGINSTRUCTION);
				}
				break;
			case BOLEANINSTRUCION:
				_localctx = new BOLEANINSTRUCIONContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(63);
				match(BOLEANINSTRUCION);
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
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1048448L) != 0)) ) {
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
		"\u0004\u0001:E\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0004\u0000"+
		"\u000b\b\u0000\u000b\u0000\f\u0000\f\u0001\u0000\u0005\u0000\u0010\b\u0000"+
		"\n\u0000\f\u0000\u0013\t\u0000\u0001\u0000\u0005\u0000\u0016\b\u0000\n"+
		"\u0000\f\u0000\u0019\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t\u0001\u0001"+
		"\u0001\u0003\u0001&\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002A\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004\u0006"+
		"\u0000\u0002\u0001\u000067\u0001\u0000\u0007\u0013R\u0000\b\u0001\u0000"+
		"\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u0004@\u0001\u0000\u0000\u0000"+
		"\u0006B\u0001\u0000\u0000\u0000\b\u0011\u0003\u0002\u0001\u0000\t\u000b"+
		"\u00058\u0000\u0000\n\t\u0001\u0000\u0000\u0000\u000b\f\u0001\u0000\u0000"+
		"\u0000\f\n\u0001\u0000\u0000\u0000\f\r\u0001\u0000\u0000\u0000\r\u000e"+
		"\u0001\u0000\u0000\u0000\u000e\u0010\u0003\u0002\u0001\u0000\u000f\n\u0001"+
		"\u0000\u0000\u0000\u0010\u0013\u0001\u0000\u0000\u0000\u0011\u000f\u0001"+
		"\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0017\u0001"+
		"\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0014\u0016\u0005"+
		"8\u0000\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0019\u0001\u0000"+
		"\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000"+
		"\u0000\u0000\u0018\u001a\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0005\u0000\u0000\u0001\u001b\u0001\u0001\u0000"+
		"\u0000\u0000\u001c!\u00059\u0000\u0000\u001d\u001e\u0005\u0001\u0000\u0000"+
		"\u001e \u00059\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 #\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$&\u0005\u0002"+
		"\u0000\u0000%\u001c\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&\'\u0001\u0000\u0000\u0000\'(\u0003\u0004\u0002\u0000(\u0003\u0001\u0000"+
		"\u0000\u0000)*\u0005\u0006\u0000\u0000*A\u00057\u0000\u0000+,\u0005\u0014"+
		"\u0000\u0000,A\u0007\u0000\u0000\u0000-.\u0005 \u0000\u0000.A\u00055\u0000"+
		"\u0000/0\u0005.\u0000\u00000A\u00059\u0000\u000012\u0005/\u0000\u0000"+
		"2A\u00059\u0000\u000034\u00050\u0000\u00004A\u00059\u0000\u000056\u0005"+
		"1\u0000\u00006A\u00057\u0000\u000078\u00052\u0000\u00008A\u00057\u0000"+
		"\u00009:\u00053\u0000\u0000:A\u00057\u0000\u0000;A\u00054\u0000\u0000"+
		"<A\u0003\u0006\u0003\u0000=A\u0005\u0003\u0000\u0000>A\u0005\u0004\u0000"+
		"\u0000?A\u0005\u0005\u0000\u0000@)\u0001\u0000\u0000\u0000@+\u0001\u0000"+
		"\u0000\u0000@-\u0001\u0000\u0000\u0000@/\u0001\u0000\u0000\u0000@1\u0001"+
		"\u0000\u0000\u0000@3\u0001\u0000\u0000\u0000@5\u0001\u0000\u0000\u0000"+
		"@7\u0001\u0000\u0000\u0000@9\u0001\u0000\u0000\u0000@;\u0001\u0000\u0000"+
		"\u0000@<\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@?\u0001\u0000\u0000\u0000A\u0005\u0001\u0000\u0000\u0000"+
		"BC\u0007\u0001\u0000\u0000C\u0007\u0001\u0000\u0000\u0000\u0006\f\u0011"+
		"\u0017!%@";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}