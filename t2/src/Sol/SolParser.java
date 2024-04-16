// Generated from C:/Users/sergi/Documents/Compiladores/CompiladoresT/t2/Sol.g4 by ANTLR 4.13.1
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
		T__0=1, SL_COMMENT=2, ML_COMMENT=3, LPARENTHESIS=4, RPARENTHESIS=5, NOT=6, 
		TRUE=7, FALSE=8, LT=9, MT=10, LTE=11, MTE=12, EQUAL=13, NEQUAL=14, AND=15, 
		OR=16, MULT=17, DIV=18, MOD=19, ADD=20, SUB=21, PRINT=22, LABEL=23, STRING=24, 
		INT=25, DOUBLE=26, WS=27, EOL=28;
	public static final int
		RULE_executable = 0, RULE_command = 1, RULE_op = 2, RULE_type = 3, RULE_negate = 4, 
		RULE_rel = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"executable", "command", "op", "type", "negate", "rel"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", null, null, "'('", "')'", "'not'", "'true'", "'false'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'and'", "'or'", "'*'", 
			"'/'", "'%'", "'+'", "'-'", "'print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SL_COMMENT", "ML_COMMENT", "LPARENTHESIS", "RPARENTHESIS", 
			"NOT", "TRUE", "FALSE", "LT", "MT", "LTE", "MTE", "EQUAL", "NEQUAL", 
			"AND", "OR", "MULT", "DIV", "MOD", "ADD", "SUB", "PRINT", "LABEL", "STRING", 
			"INT", "DOUBLE", "WS", "EOL"
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
		public TerminalNode EOL() { return getToken(SolParser.EOL, 0); }
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
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				command();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PRINT );
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(17);
				match(EOL);
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
	public static class CommandContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(SolParser.PRINT, 0); }
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(PRINT);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				op(0);
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 119538128L) != 0) );
			setState(28);
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
	public static class MultiplicationContext extends OpContext {
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode MULT() { return getToken(SolParser.MULT, 0); }
		public MultiplicationContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionContext extends OpContext {
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SolParser.ADD, 0); }
		public AdditionContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitAddition(this);
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
	public static class SubctractionContext extends OpContext {
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode SUB() { return getToken(SolParser.SUB, 0); }
		public SubctractionContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterSubctraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitSubctraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitSubctraction(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class DivisionContext extends OpContext {
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode DIV() { return getToken(SolParser.DIV, 0); }
		public DivisionContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModuleContext extends OpContext {
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode MOD() { return getToken(SolParser.MOD, 0); }
		public ModuleContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitModule(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_op, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(31);
				match(LPARENTHESIS);
				setState(32);
				op(0);
				setState(33);
				match(RPARENTHESIS);
				}
				break;
			case 2:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				negate();
				}
				break;
			case 3:
				{
				_localctx = new RelationsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				rel();
				}
				break;
			case 4:
				{
				_localctx = new TypesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				type();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(55);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new OpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_op);
						setState(40);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(41);
						match(MULT);
						setState(42);
						op(8);
						}
						break;
					case 2:
						{
						_localctx = new DivisionContext(new OpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_op);
						setState(43);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(44);
						match(DIV);
						setState(45);
						op(7);
						}
						break;
					case 3:
						{
						_localctx = new ModuleContext(new OpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_op);
						setState(46);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(47);
						match(MOD);
						setState(48);
						op(6);
						}
						break;
					case 4:
						{
						_localctx = new AdditionContext(new OpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_op);
						setState(49);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(50);
						match(ADD);
						setState(51);
						op(5);
						}
						break;
					case 5:
						{
						_localctx = new SubctractionContext(new OpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_op);
						setState(52);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(53);
						match(SUB);
						setState(54);
						op(4);
						}
						break;
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 117440896L) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_negate);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(SUB);
				setState(63);
				op(0);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(NOT);
				setState(65);
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
	public static class NotEqualContext extends RelContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode NEQUAL() { return getToken(SolParser.NEQUAL, 0); }
		public NotEqualContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterNotEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitNotEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
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
	public static class EqualContext extends RelContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(SolParser.EQUAL, 0); }
		public EqualContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitEqual(this);
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
	public static class MtContext extends RelContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode MT() { return getToken(SolParser.MT, 0); }
		public TerminalNode MTE() { return getToken(SolParser.MTE, 0); }
		public MtContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterMt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitMt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitMt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LtContext extends RelContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode LT() { return getToken(SolParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SolParser.LTE, 0); }
		public LtContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolListener ) ((SolListener)listener).exitLt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolVisitor ) return ((SolVisitor<? extends T>)visitor).visitLt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rel);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new LtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				type();
				setState(69);
				match(LT);
				setState(70);
				type();
				}
				break;
			case 2:
				_localctx = new MtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				type();
				setState(73);
				match(MT);
				setState(74);
				type();
				}
				break;
			case 3:
				_localctx = new LtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				type();
				setState(77);
				match(LTE);
				setState(78);
				type();
				}
				break;
			case 4:
				_localctx = new MtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				type();
				setState(81);
				match(MTE);
				setState(82);
				type();
				}
				break;
			case 5:
				_localctx = new EqualContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				type();
				setState(85);
				match(EQUAL);
				setState(86);
				type();
				}
				break;
			case 6:
				_localctx = new NotEqualContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				type();
				setState(89);
				match(NEQUAL);
				setState(90);
				type();
				}
				break;
			case 7:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(92);
				type();
				setState(93);
				match(AND);
				setState(94);
				type();
				}
				break;
			case 8:
				_localctx = new OrContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(96);
				type();
				setState(97);
				match(OR);
				setState(98);
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
		case 2:
			return op_sempred((OpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean op_sempred(OpContext _localctx, int predIndex) {
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001cg\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f"+
		"\u0000\u000f\u0001\u0000\u0003\u0000\u0013\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0004\u0001\u0019\b\u0001\u000b\u0001\f\u0001"+
		"\u001a\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\'\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00028\b\u0002\n\u0002"+
		"\f\u0002;\t\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004C\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005e\b\u0005\u0001\u0005\u0000\u0001\u0004\u0006\u0000\u0002\u0004"+
		"\u0006\b\n\u0000\u0001\u0002\u0000\u0007\b\u0018\u001as\u0000\r\u0001"+
		"\u0000\u0000\u0000\u0002\u0016\u0001\u0000\u0000\u0000\u0004&\u0001\u0000"+
		"\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\bB\u0001\u0000\u0000\u0000"+
		"\nd\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001"+
		"\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000"+
		"\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0012\u0001\u0000"+
		"\u0000\u0000\u0011\u0013\u0005\u001c\u0000\u0000\u0012\u0011\u0001\u0000"+
		"\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000"+
		"\u0000\u0000\u0014\u0015\u0005\u0000\u0000\u0001\u0015\u0001\u0001\u0000"+
		"\u0000\u0000\u0016\u0018\u0005\u0016\u0000\u0000\u0017\u0019\u0003\u0004"+
		"\u0002\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0001"+
		"\u0000\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e\u001f\u0006\u0002"+
		"\uffff\uffff\u0000\u001f \u0005\u0004\u0000\u0000 !\u0003\u0004\u0002"+
		"\u0000!\"\u0005\u0005\u0000\u0000\"\'\u0001\u0000\u0000\u0000#\'\u0003"+
		"\b\u0004\u0000$\'\u0003\n\u0005\u0000%\'\u0003\u0006\u0003\u0000&\u001e"+
		"\u0001\u0000\u0000\u0000&#\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000"+
		"\u0000&%\u0001\u0000\u0000\u0000\'9\u0001\u0000\u0000\u0000()\n\u0007"+
		"\u0000\u0000)*\u0005\u0011\u0000\u0000*8\u0003\u0004\u0002\b+,\n\u0006"+
		"\u0000\u0000,-\u0005\u0012\u0000\u0000-8\u0003\u0004\u0002\u0007./\n\u0005"+
		"\u0000\u0000/0\u0005\u0013\u0000\u000008\u0003\u0004\u0002\u000612\n\u0004"+
		"\u0000\u000023\u0005\u0014\u0000\u000038\u0003\u0004\u0002\u000545\n\u0003"+
		"\u0000\u000056\u0005\u0015\u0000\u000068\u0003\u0004\u0002\u00047(\u0001"+
		"\u0000\u0000\u00007+\u0001\u0000\u0000\u00007.\u0001\u0000\u0000\u0000"+
		"71\u0001\u0000\u0000\u000074\u0001\u0000\u0000\u00008;\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:\u0005\u0001"+
		"\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0007\u0000\u0000\u0000"+
		"=\u0007\u0001\u0000\u0000\u0000>?\u0005\u0015\u0000\u0000?C\u0003\u0004"+
		"\u0002\u0000@A\u0005\u0006\u0000\u0000AC\u0003\u0004\u0002\u0000B>\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000C\t\u0001\u0000\u0000\u0000"+
		"DE\u0003\u0006\u0003\u0000EF\u0005\t\u0000\u0000FG\u0003\u0006\u0003\u0000"+
		"Ge\u0001\u0000\u0000\u0000HI\u0003\u0006\u0003\u0000IJ\u0005\n\u0000\u0000"+
		"JK\u0003\u0006\u0003\u0000Ke\u0001\u0000\u0000\u0000LM\u0003\u0006\u0003"+
		"\u0000MN\u0005\u000b\u0000\u0000NO\u0003\u0006\u0003\u0000Oe\u0001\u0000"+
		"\u0000\u0000PQ\u0003\u0006\u0003\u0000QR\u0005\f\u0000\u0000RS\u0003\u0006"+
		"\u0003\u0000Se\u0001\u0000\u0000\u0000TU\u0003\u0006\u0003\u0000UV\u0005"+
		"\r\u0000\u0000VW\u0003\u0006\u0003\u0000We\u0001\u0000\u0000\u0000XY\u0003"+
		"\u0006\u0003\u0000YZ\u0005\u000e\u0000\u0000Z[\u0003\u0006\u0003\u0000"+
		"[e\u0001\u0000\u0000\u0000\\]\u0003\u0006\u0003\u0000]^\u0005\u000f\u0000"+
		"\u0000^_\u0003\u0006\u0003\u0000_e\u0001\u0000\u0000\u0000`a\u0003\u0006"+
		"\u0003\u0000ab\u0005\u0010\u0000\u0000bc\u0003\u0006\u0003\u0000ce\u0001"+
		"\u0000\u0000\u0000dD\u0001\u0000\u0000\u0000dH\u0001\u0000\u0000\u0000"+
		"dL\u0001\u0000\u0000\u0000dP\u0001\u0000\u0000\u0000dT\u0001\u0000\u0000"+
		"\u0000dX\u0001\u0000\u0000\u0000d\\\u0001\u0000\u0000\u0000d`\u0001\u0000"+
		"\u0000\u0000e\u000b\u0001\u0000\u0000\u0000\b\u000f\u0012\u001a&79Bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}