// Generated from C:/Users/sergi/Documents/Compiladores/CompiladoresT/t3/Sol.g4 by ANTLR 4.13.1
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
		SL_COMMENT=18, ML_COMMENT=19, LPARENTHESIS=20, RPARENTHESIS=21, NOT=22, 
		TRUE=23, FALSE=24, LT=25, MT=26, LTE=27, MTE=28, EQUAL=29, NEQUAL=30, 
		AND=31, OR=32, MULT=33, DIV=34, MOD=35, ADD=36, SUB=37, PRINT=38, INT=39, 
		DOUBLE=40, STRING=41, VAR=42, WS=43;
	public static final int
		RULE_executable = 0, RULE_command = 1, RULE_block = 2, RULE_codeType = 3, 
		RULE_while = 4, RULE_for = 5, RULE_if = 6, RULE_empty = 7, RULE_break = 8, 
		RULE_declarationType = 9, RULE_declarationDef = 10, RULE_op = 11, RULE_type = 12, 
		RULE_negate = 13, RULE_rel = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"executable", "command", "block", "codeType", "while", "for", "if", "empty", 
			"break", "declarationType", "declarationDef", "op", "type", "negate", 
			"rel"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'begin'", "'end'", "','", "'while'", "'do'", "'for'", 
			"'to'", "'if'", "'then'", "'else'", "'break'", "'int'", "'double'", "'string'", 
			"'boolean'", null, null, "'('", "')'", "'not'", "'true'", "'false'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'and'", "'or'", "'*'", 
			"'/'", "'%'", "'+'", "'-'", "'print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "SL_COMMENT", "ML_COMMENT", "LPARENTHESIS", 
			"RPARENTHESIS", "NOT", "TRUE", "FALSE", "LT", "MT", "LTE", "MTE", "EQUAL", 
			"NEQUAL", "AND", "OR", "MULT", "DIV", "MOD", "ADD", "SUB", "PRINT", "INT", 
			"DOUBLE", "STRING", "VAR", "WS"
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
	public static class ExecutableContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SolParser.EOF, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<CodeTypeContext> codeType() {
			return getRuleContexts(CodeTypeContext.class);
		}
		public CodeTypeContext codeType(int i) {
			return getRuleContext(CodeTypeContext.class,i);
		}
		public ExecutableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_executable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterExecutable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitExecutable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitExecutable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExecutableContext executable() throws RecognitionException {
		ExecutableContext _localctx = new ExecutableContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_executable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4672924673354L) != 0)) {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__2:
				case T__5:
				case T__7:
				case T__9:
				case T__12:
				case PRINT:
				case VAR:
					{
					setState(30);
					command();
					}
					break;
				case T__13:
				case T__14:
				case T__15:
				case T__16:
					{
					setState(31);
					codeType();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
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
		public TerminalNode PRINT() { return getToken(SolParser.PRINT, 0); }
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public EmptyContext empty() {
			return getRuleContext(EmptyContext.class,0);
		}
		public BreakContext break_() {
			return getRuleContext(BreakContext.class,0);
		}
		public TerminalNode VAR() { return getToken(SolParser.VAR, 0); }
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(PRINT);
				setState(40);
				op(0);
				setState(41);
				match(T__0);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				block();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				while_();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				for_();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				if_();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
				empty();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 7);
				{
				setState(48);
				break_();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(49);
				match(VAR);
				setState(50);
				match(T__1);
				setState(51);
				op(0);
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
	public static class BlockContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<CodeTypeContext> codeType() {
			return getRuleContexts(CodeTypeContext.class);
		}
		public CodeTypeContext codeType(int i) {
			return getRuleContext(CodeTypeContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__2);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4672924673354L) != 0)) {
				{
				setState(59);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__2:
				case T__5:
				case T__7:
				case T__9:
				case T__12:
				case PRINT:
				case VAR:
					{
					setState(55);
					command();
					}
					break;
				case T__13:
				case T__14:
				case T__15:
				case T__16:
					{
					setState(56);
					codeType();
					setState(57);
					match(T__0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(T__3);
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
	public static class CodeTypeContext extends ParserRuleContext {
		public DeclarationTypeContext declarationType() {
			return getRuleContext(DeclarationTypeContext.class,0);
		}
		public List<DeclarationDefContext> declarationDef() {
			return getRuleContexts(DeclarationDefContext.class);
		}
		public DeclarationDefContext declarationDef(int i) {
			return getRuleContext(DeclarationDefContext.class,i);
		}
		public CodeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterCodeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitCodeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitCodeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeTypeContext codeType() throws RecognitionException {
		CodeTypeContext _localctx = new CodeTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_codeType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			declarationType();
			setState(67);
			declarationDef();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(68);
				match(T__4);
				setState(69);
				declarationDef();
				}
				}
				setState(74);
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
	public static class WhileContext extends ParserRuleContext {
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__5);
			setState(76);
			op(0);
			setState(77);
			match(T__6);
			setState(78);
			command();
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
	public static class ForContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(SolParser.VAR, 0); }
		public List<TerminalNode> INT() { return getTokens(SolParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(SolParser.INT, i);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__7);
			setState(81);
			match(VAR);
			setState(82);
			match(T__1);
			setState(83);
			match(INT);
			setState(84);
			match(T__8);
			setState(85);
			match(INT);
			setState(86);
			match(T__6);
			setState(87);
			command();
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
	public static class IfContext extends ParserRuleContext {
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__9);
			setState(90);
			op(0);
			setState(91);
			match(T__10);
			setState(92);
			command();
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(93);
				match(T__11);
				setState(94);
				command();
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
		enterRule(_localctx, 14, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
		enterRule(_localctx, 16, RULE_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__12);
			setState(100);
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
	public static class DeclarationTypeContext extends ParserRuleContext {
		public DeclarationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationType; }
	 
		public DeclarationTypeContext() { }
		public void copyFrom(DeclarationTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerTypeContext extends DeclarationTypeContext {
		public IntegerTypeContext(DeclarationTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterIntegerType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitIntegerType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitIntegerType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringTypeContext extends DeclarationTypeContext {
		public StringTypeContext(DeclarationTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterStringType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitStringType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleTypeContext extends DeclarationTypeContext {
		public DoubleTypeContext(DeclarationTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterDoubleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitDoubleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitDoubleType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanTypeContext extends DeclarationTypeContext {
		public BooleanTypeContext(DeclarationTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationTypeContext declarationType() throws RecognitionException {
		DeclarationTypeContext _localctx = new DeclarationTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declarationType);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(T__13);
				}
				break;
			case T__14:
				_localctx = new DoubleTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(T__14);
				}
				break;
			case T__15:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(T__15);
				}
				break;
			case T__16:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				match(T__16);
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
	public static class DeclarationDefContext extends ParserRuleContext {
		public DeclarationDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationDef; }
	 
		public DeclarationDefContext() { }
		public void copyFrom(DeclarationDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleDeclarationContext extends DeclarationDefContext {
		public TerminalNode VAR() { return getToken(SolParser.VAR, 0); }
		public TerminalNode DOUBLE() { return getToken(SolParser.DOUBLE, 0); }
		public DoubleDeclarationContext(DeclarationDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterDoubleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitDoubleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitDoubleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerDeclarationContext extends DeclarationDefContext {
		public TerminalNode VAR() { return getToken(SolParser.VAR, 0); }
		public TerminalNode INT() { return getToken(SolParser.INT, 0); }
		public IntegerDeclarationContext(DeclarationDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterIntegerDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitIntegerDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitIntegerDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringDeclarationContext extends DeclarationDefContext {
		public TerminalNode VAR() { return getToken(SolParser.VAR, 0); }
		public TerminalNode STRING() { return getToken(SolParser.STRING, 0); }
		public StringDeclarationContext(DeclarationDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterStringDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitStringDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitStringDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueDeclarationContext extends DeclarationDefContext {
		public TerminalNode VAR() { return getToken(SolParser.VAR, 0); }
		public TerminalNode TRUE() { return getToken(SolParser.TRUE, 0); }
		public TrueDeclarationContext(DeclarationDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterTrueDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitTrueDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitTrueDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseDeclarationContext extends DeclarationDefContext {
		public TerminalNode VAR() { return getToken(SolParser.VAR, 0); }
		public TerminalNode FALSE() { return getToken(SolParser.FALSE, 0); }
		public FalseDeclarationContext(DeclarationDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterFalseDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitFalseDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitFalseDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationDefContext declarationDef() throws RecognitionException {
		DeclarationDefContext _localctx = new DeclarationDefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declarationDef);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new IntegerDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(VAR);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(109);
					match(T__1);
					setState(110);
					match(INT);
					}
				}

				}
				break;
			case 2:
				_localctx = new DoubleDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(VAR);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(114);
					match(T__1);
					setState(115);
					match(DOUBLE);
					}
				}

				}
				break;
			case 3:
				_localctx = new StringDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(VAR);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(119);
					match(T__1);
					setState(120);
					match(STRING);
					}
				}

				}
				break;
			case 4:
				_localctx = new TrueDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(VAR);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(124);
					match(T__1);
					setState(125);
					match(TRUE);
					}
				}

				}
				break;
			case 5:
				_localctx = new FalseDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				match(VAR);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(129);
					match(T__1);
					setState(130);
					match(FALSE);
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
	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	 
		public OpContext() { }
		public void copyFrom(OpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypesContext extends OpContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypesContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisContext extends OpContext {
		public TerminalNode LPARENTHESIS() { return getToken(SolParser.LPARENTHESIS, 0); }
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public TerminalNode RPARENTHESIS() { return getToken(SolParser.RPARENTHESIS, 0); }
		public ParenthesisContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationContext extends OpContext {
		public NegateContext negate() {
			return getRuleContext(NegateContext.class,0);
		}
		public NegationContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends OpContext {
		public Token addsubOP;
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SolParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SolParser.SUB, 0); }
		public AddSubContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultDivModContext extends OpContext {
		public Token multdivmodOp;
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode MULT() { return getToken(SolParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SolParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SolParser.MOD, 0); }
		public MultDivModContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterMultDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitMultDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationsContext extends OpContext {
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public RelationsContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterRelations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitRelations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitRelations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		return op(0);
	}

	private OpContext op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OpContext _localctx = new OpContext(_ctx, _parentState);
		OpContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_op, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(136);
				match(LPARENTHESIS);
				setState(137);
				op(0);
				setState(138);
				match(RPARENTHESIS);
				}
				break;
			case 2:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				negate();
				}
				break;
			case 3:
				{
				_localctx = new RelationsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				rel();
				}
				break;
			case 4:
				{
				_localctx = new TypesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				type();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(151);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivModContext(new OpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_op);
						setState(145);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(146);
						((MultDivModContext)_localctx).multdivmodOp = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
							((MultDivModContext)_localctx).multdivmodOp = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(147);
						op(5);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new OpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_op);
						setState(148);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(149);
						((AddSubContext)_localctx).addsubOP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).addsubOP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(150);
						op(4);
						}
						break;
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SolParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(SolParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(SolParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(SolParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SolParser.FALSE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3848315863040L) != 0)) ) {
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
	public static class NegateContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(SolParser.SUB, 0); }
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SolParser.NOT, 0); }
		public NegateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitNegate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitNegate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegateContext negate() throws RecognitionException {
		NegateContext _localctx = new NegateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_negate);
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(SUB);
				setState(159);
				op(0);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(NOT);
				setState(161);
				op(0);
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
	public static class RelContext extends ParserRuleContext {
		public RelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel; }
	 
		public RelContext() { }
		public void copyFrom(RelContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends RelContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode OR() { return getToken(SolParser.OR, 0); }
		public OrContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends RelContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode AND() { return getToken(SolParser.AND, 0); }
		public AndContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareMoreContext extends RelContext {
		public Token compareMoreOp;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode LT() { return getToken(SolParser.LT, 0); }
		public TerminalNode MT() { return getToken(SolParser.MT, 0); }
		public TerminalNode LTE() { return getToken(SolParser.LTE, 0); }
		public TerminalNode MTE() { return getToken(SolParser.MTE, 0); }
		public CompareMoreContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterCompareMore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitCompareMore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitCompareMore(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareContext extends RelContext {
		public Token compareOP;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(SolParser.EQUAL, 0); }
		public TerminalNode NEQUAL() { return getToken(SolParser.NEQUAL, 0); }
		public CompareContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rel);
		int _la;
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new CompareMoreContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				type();
				setState(165);
				((CompareMoreContext)_localctx).compareMoreOp = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 503316480L) != 0)) ) {
					((CompareMoreContext)_localctx).compareMoreOp = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(166);
				type();
				}
				break;
			case 2:
				_localctx = new CompareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				type();
				setState(169);
				((CompareContext)_localctx).compareOP = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQUAL || _la==NEQUAL) ) {
					((CompareContext)_localctx).compareOP = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(170);
				type();
				}
				break;
			case 3:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				type();
				setState(173);
				match(AND);
				setState(174);
				type();
				}
				break;
			case 4:
				_localctx = new OrContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				type();
				setState(177);
				match(OR);
				setState(178);
				type();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return op_sempred((OpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean op_sempred(OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u00b7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0005\u0000!\b\u0000\n\u0000\f\u0000$\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00015\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002<\b\u0002\n\u0002\f\u0002?\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003G\b\u0003\n\u0003\f\u0003J\t\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006`\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tk\b\t\u0001\n\u0001\n\u0001\n"+
		"\u0003\np\b\n\u0001\n\u0001\n\u0001\n\u0003\nu\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\nz\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u007f\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u0084\b\n\u0003\n\u0086\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u0090\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u0098\b\u000b\n\u000b\f\u000b\u009b"+
		"\t\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00a3"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00b5"+
		"\b\u000e\u0001\u000e\u0000\u0001\u0016\u000f\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0005\u0001"+
		"\u0000!#\u0001\u0000$%\u0002\u0000\u0017\u0018\')\u0001\u0000\u0019\u001c"+
		"\u0001\u0000\u001d\u001e\u00c9\u0000\"\u0001\u0000\u0000\u0000\u00024"+
		"\u0001\u0000\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u0006B\u0001\u0000"+
		"\u0000\u0000\bK\u0001\u0000\u0000\u0000\nP\u0001\u0000\u0000\u0000\fY"+
		"\u0001\u0000\u0000\u0000\u000ea\u0001\u0000\u0000\u0000\u0010c\u0001\u0000"+
		"\u0000\u0000\u0012j\u0001\u0000\u0000\u0000\u0014\u0085\u0001\u0000\u0000"+
		"\u0000\u0016\u008f\u0001\u0000\u0000\u0000\u0018\u009c\u0001\u0000\u0000"+
		"\u0000\u001a\u00a2\u0001\u0000\u0000\u0000\u001c\u00b4\u0001\u0000\u0000"+
		"\u0000\u001e!\u0003\u0002\u0001\u0000\u001f!\u0003\u0006\u0003\u0000 "+
		"\u001e\u0001\u0000\u0000\u0000 \u001f\u0001\u0000\u0000\u0000!$\u0001"+
		"\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000"+
		"#%\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\u0000\u0000"+
		"\u0001&\u0001\u0001\u0000\u0000\u0000\'(\u0005&\u0000\u0000()\u0003\u0016"+
		"\u000b\u0000)*\u0005\u0001\u0000\u0000*5\u0001\u0000\u0000\u0000+5\u0003"+
		"\u0004\u0002\u0000,5\u0003\b\u0004\u0000-5\u0003\n\u0005\u0000.5\u0003"+
		"\f\u0006\u0000/5\u0003\u000e\u0007\u000005\u0003\u0010\b\u000012\u0005"+
		"*\u0000\u000023\u0005\u0002\u0000\u000035\u0003\u0016\u000b\u00004\'\u0001"+
		"\u0000\u0000\u00004+\u0001\u0000\u0000\u00004,\u0001\u0000\u0000\u0000"+
		"4-\u0001\u0000\u0000\u00004.\u0001\u0000\u0000\u00004/\u0001\u0000\u0000"+
		"\u000040\u0001\u0000\u0000\u000041\u0001\u0000\u0000\u00005\u0003\u0001"+
		"\u0000\u0000\u00006=\u0005\u0003\u0000\u00007<\u0003\u0002\u0001\u0000"+
		"89\u0003\u0006\u0003\u00009:\u0005\u0001\u0000\u0000:<\u0001\u0000\u0000"+
		"\u0000;7\u0001\u0000\u0000\u0000;8\u0001\u0000\u0000\u0000<?\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0005\u0004\u0000\u0000"+
		"A\u0005\u0001\u0000\u0000\u0000BC\u0003\u0012\t\u0000CH\u0003\u0014\n"+
		"\u0000DE\u0005\u0005\u0000\u0000EG\u0003\u0014\n\u0000FD\u0001\u0000\u0000"+
		"\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000I\u0007\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000"+
		"KL\u0005\u0006\u0000\u0000LM\u0003\u0016\u000b\u0000MN\u0005\u0007\u0000"+
		"\u0000NO\u0003\u0002\u0001\u0000O\t\u0001\u0000\u0000\u0000PQ\u0005\b"+
		"\u0000\u0000QR\u0005*\u0000\u0000RS\u0005\u0002\u0000\u0000ST\u0005\'"+
		"\u0000\u0000TU\u0005\t\u0000\u0000UV\u0005\'\u0000\u0000VW\u0005\u0007"+
		"\u0000\u0000WX\u0003\u0002\u0001\u0000X\u000b\u0001\u0000\u0000\u0000"+
		"YZ\u0005\n\u0000\u0000Z[\u0003\u0016\u000b\u0000[\\\u0005\u000b\u0000"+
		"\u0000\\_\u0003\u0002\u0001\u0000]^\u0005\f\u0000\u0000^`\u0003\u0002"+
		"\u0001\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\r\u0001"+
		"\u0000\u0000\u0000ab\u0005\u0001\u0000\u0000b\u000f\u0001\u0000\u0000"+
		"\u0000cd\u0005\r\u0000\u0000de\u0005\u0001\u0000\u0000e\u0011\u0001\u0000"+
		"\u0000\u0000fk\u0005\u000e\u0000\u0000gk\u0005\u000f\u0000\u0000hk\u0005"+
		"\u0010\u0000\u0000ik\u0005\u0011\u0000\u0000jf\u0001\u0000\u0000\u0000"+
		"jg\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000"+
		"\u0000k\u0013\u0001\u0000\u0000\u0000lo\u0005*\u0000\u0000mn\u0005\u0002"+
		"\u0000\u0000np\u0005\'\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000p\u0086\u0001\u0000\u0000\u0000qt\u0005*\u0000\u0000rs\u0005"+
		"\u0002\u0000\u0000su\u0005(\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001"+
		"\u0000\u0000\u0000u\u0086\u0001\u0000\u0000\u0000vy\u0005*\u0000\u0000"+
		"wx\u0005\u0002\u0000\u0000xz\u0005)\u0000\u0000yw\u0001\u0000\u0000\u0000"+
		"yz\u0001\u0000\u0000\u0000z\u0086\u0001\u0000\u0000\u0000{~\u0005*\u0000"+
		"\u0000|}\u0005\u0002\u0000\u0000}\u007f\u0005\u0017\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0086\u0001\u0000"+
		"\u0000\u0000\u0080\u0083\u0005*\u0000\u0000\u0081\u0082\u0005\u0002\u0000"+
		"\u0000\u0082\u0084\u0005\u0018\u0000\u0000\u0083\u0081\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000\u0000"+
		"\u0000\u0085l\u0001\u0000\u0000\u0000\u0085q\u0001\u0000\u0000\u0000\u0085"+
		"v\u0001\u0000\u0000\u0000\u0085{\u0001\u0000\u0000\u0000\u0085\u0080\u0001"+
		"\u0000\u0000\u0000\u0086\u0015\u0001\u0000\u0000\u0000\u0087\u0088\u0006"+
		"\u000b\uffff\uffff\u0000\u0088\u0089\u0005\u0014\u0000\u0000\u0089\u008a"+
		"\u0003\u0016\u000b\u0000\u008a\u008b\u0005\u0015\u0000\u0000\u008b\u0090"+
		"\u0001\u0000\u0000\u0000\u008c\u0090\u0003\u001a\r\u0000\u008d\u0090\u0003"+
		"\u001c\u000e\u0000\u008e\u0090\u0003\u0018\f\u0000\u008f\u0087\u0001\u0000"+
		"\u0000\u0000\u008f\u008c\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0099\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\n\u0004\u0000\u0000\u0092\u0093\u0007\u0000\u0000"+
		"\u0000\u0093\u0098\u0003\u0016\u000b\u0005\u0094\u0095\n\u0003\u0000\u0000"+
		"\u0095\u0096\u0007\u0001\u0000\u0000\u0096\u0098\u0003\u0016\u000b\u0004"+
		"\u0097\u0091\u0001\u0000\u0000\u0000\u0097\u0094\u0001\u0000\u0000\u0000"+
		"\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u0017\u0001\u0000\u0000\u0000"+
		"\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009d\u0007\u0002\u0000\u0000"+
		"\u009d\u0019\u0001\u0000\u0000\u0000\u009e\u009f\u0005%\u0000\u0000\u009f"+
		"\u00a3\u0003\u0016\u000b\u0000\u00a0\u00a1\u0005\u0016\u0000\u0000\u00a1"+
		"\u00a3\u0003\u0016\u000b\u0000\u00a2\u009e\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a3\u001b\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0003\u0018\f\u0000\u00a5\u00a6\u0007\u0003\u0000\u0000\u00a6\u00a7"+
		"\u0003\u0018\f\u0000\u00a7\u00b5\u0001\u0000\u0000\u0000\u00a8\u00a9\u0003"+
		"\u0018\f\u0000\u00a9\u00aa\u0007\u0004\u0000\u0000\u00aa\u00ab\u0003\u0018"+
		"\f\u0000\u00ab\u00b5\u0001\u0000\u0000\u0000\u00ac\u00ad\u0003\u0018\f"+
		"\u0000\u00ad\u00ae\u0005\u001f\u0000\u0000\u00ae\u00af\u0003\u0018\f\u0000"+
		"\u00af\u00b5\u0001\u0000\u0000\u0000\u00b0\u00b1\u0003\u0018\f\u0000\u00b1"+
		"\u00b2\u0005 \u0000\u0000\u00b2\u00b3\u0003\u0018\f\u0000\u00b3\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b4\u00a4\u0001\u0000\u0000\u0000\u00b4\u00a8"+
		"\u0001\u0000\u0000\u0000\u00b4\u00ac\u0001\u0000\u0000\u0000\u00b4\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b5\u001d\u0001\u0000\u0000\u0000\u0013 \""+
		"4;=H_joty~\u0083\u0085\u008f\u0097\u0099\u00a2\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}