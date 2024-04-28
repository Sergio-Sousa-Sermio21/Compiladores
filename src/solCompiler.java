import Sol.SolBaseListener;
import Sol.SolLexer;
import Sol.SolParser;
import Sol.SolBaseVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.util.*;

public class solCompiler {

    static class Visitor extends SolBaseVisitor<Class<?>> {
        private final Map<String, Integer> PosicaoVariaveis = new HashMap<>();
        private ArrayList<ArrayList<Integer>> breaks = new ArrayList<ArrayList<Integer>>();

        private final ArrayList<Instrucion> instrucoes = new ArrayList<>();

        private final ArrayList<Object> constantpoll = new ArrayList<>();
        private int ciclos = -1;

        private int countVariable = 0;

        int count = 0;
        private ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();
        public Class<?> visitProgram(SolParser.ProgramContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            visitChildren(ctx);
            instrucoes.add(new Instrucion(Commands.HALT));
            return null;
        }

        public Class<?> getValues(ParseTree node){
            return values.get(node);
        }

        //EXP---------------------------------------------------------------------------------
        @Override
        public Class<?>  visitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            String operator = ctx.op.getText();
            Class<?> leftType = visit(ctx.exp(0));
            Class<?> rightType = visit(ctx.exp(1));

            switch (operator) {
                case "==":
                    if (leftType == Double.class || rightType == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DEQ));
                    } else if (leftType == Integer.class) {
                        instrucoes.add(new Instrucion(Commands.IEQ));
                    } else if (leftType == String.class) {
                        instrucoes.add(new Instrucion(Commands.SEQ));
                    } else {
                        instrucoes.add(new Instrucion(Commands.BEQ));
                    }
                    break;
                case "!=":
                    if (leftType == Double.class || rightType == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DNEQ));
                    } else if (leftType == Integer.class) {
                        instrucoes.add(new Instrucion(Commands.INEQ));
                    } else if (leftType == String.class) {
                        instrucoes.add(new Instrucion(Commands.SNEQ));
                    } else {
                        instrucoes.add(new Instrucion(Commands.BNEQ));
                    }
                    break;
            }
            if (getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
                return String.class;
            }
            return Boolean.class;
        }

        @Override
        public Class<?> visitORDER(SolParser.ORDERContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            Class<?> Order = visit(ctx.exp());
            Class<?> Parent = getValues(ctx.getParent());
            
            if(Parent == String.class) {
                if (Order.equals(Integer.class)) {
                    instrucoes.add(new Instrucion(Commands.ITOS));
                }
                else if (Order.equals(Double.class)) {
                    instrucoes.add(new Instrucion(Commands.DTOS));
                } else {
                    instrucoes.add(new Instrucion(Commands.BTOS));
                }
            }
            else if (Parent == Double.class) {
                if (Order == Integer.class)
                    instrucoes.add(new Instrucion(Commands.ITOD));
            }
            if(Parent != Boolean.class)
                return Parent;
            return Order;
        }
        @Override
        public Class<?> visitNEGACION(SolParser.NEGACIONContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            String operador = ctx.op.getText();
            Class<?> Order = visitChildren(ctx);
            Class<?> Parent = getValues(ctx.getParent());
            switch (operador) {
                case "-":
                    if (Order == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DUMINUS));
                    } else {
                        instrucoes.add(new Instrucion(Commands.IUMINUS));
                    }
                    break;
                case "not":
                    instrucoes.add(new Instrucion(Commands.NOT));
                    break;
            }
            if (Parent == String.class) {
                if (Order == Double.class) {
                    instrucoes.add(new Instrucion(Commands.DTOS));
                } else if (Order == Integer.class) {
                    instrucoes.add(new Instrucion(Commands.ITOS));
                } else {
                    instrucoes.add(new Instrucion(Commands.BTOS));
                }
            } else if (Order != Double.class && Parent == Double.class) {
                instrucoes.add(new Instrucion(Commands.ITOD));
            }
            if(Parent != Boolean.class)
                return Parent;
            return Order;
        }
        @Override
        public Class<?> visitADDSUB(SolParser.ADDSUBContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            String operador = ctx.op.getText();
            Class<?> Order = visit(ctx.exp(0));
            visit(ctx.exp(1));
            Class<?> Parent = getValues(ctx.getParent());
            switch (operador) {
                case "+":
                    if (Order == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DADD));
                    } else if (Order == Integer.class) {
                        instrucoes.add(new Instrucion(Commands.IADD));
                    } else {
                        instrucoes.add(new Instrucion(Commands.SADD));
                    }
                    break;
                case "-":
                    if (Order == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DSUB));
                    } else {
                        instrucoes.add(new Instrucion(Commands.ISUB));
                    }
                    break;
            }
            if (Parent == String.class) {
                if (Order == Double.class) {
                    instrucoes.add(new Instrucion(Commands.DTOS));
                } else if (Order == Integer.class) {
                    instrucoes.add(new Instrucion(Commands.ITOS));
                }
            }else if (Order != Double.class && Parent == Double.class) {
                instrucoes.add(new Instrucion(Commands.ITOD));
            }
            if(Parent != Boolean.class)
                return Parent;
            return Order;
        }
        int countdiv = 0;
        @Override
        public Class<?>  visitMULTDIV(SolParser.MULTDIVContext ctx) {
            String operador = ctx.op.getText();
            Class<?> Order = visit(ctx.exp(0));
            visit(ctx.exp(1));
            Class<?> Parent = getValues(ctx.getParent());
            switch (operador) {
                case "*" -> {
                    if (Order == Double.class)
                        instrucoes.add(new Instrucion(Commands.DMULT));
                    else
                        instrucoes.add(new Instrucion(Commands.IMULT));
                }
                case "/" ->{
                    if(Order == Double.class)
                        instrucoes.add(new Instrucion(Commands.DDIV));
                    else
                        instrucoes.add(new Instrucion(Commands.IDIV));
                }
                case "%"-> instrucoes.add(new Instrucion(Commands.IMOD));
            }
            if (Parent == String.class){
                if (Order == Double.class)
                    instrucoes.add(new Instrucion(Commands.DTOS));
                else
                    instrucoes.add(new Instrucion(Commands.ITOS));
            } else if (Order != Double.class && Parent == Double.class)
                instrucoes.add(new Instrucion(Commands.ITOD));
            if(Parent != Boolean.class)
                return Parent;
            return Order;
        }

        @Override
        public Class<?> visitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx) {
            switch (ctx.op.getText()) {
                case "<" -> {
                    Class<?> leftType = visit(ctx.exp(0));
                    Class<?> rightType = visit(ctx.exp(1));
                    if (leftType == Double.class || rightType == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DLT));
                    } else {
                        instrucoes.add(new Instrucion(Commands.ILT));
                    }
                }
                case ">" -> {
                    Class<?> leftType = visit(ctx.exp(1));
                    Class<?> rightType = visit(ctx.exp(0));
                    if (leftType == Double.class || rightType == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DLT));
                    } else {
                        instrucoes.add(new Instrucion(Commands.ILT));
                    }
                }
                case "<=" -> {
                    Class<?> leftType = visit(ctx.exp(0));
                    Class<?> rightType = visit(ctx.exp(1));
                    if (leftType == Double.class || rightType == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DLEQ));
                    } else {
                        instrucoes.add(new Instrucion(Commands.ILEQ));
                    }
                }
                case ">=" -> {
                    Class<?> leftType = visit(ctx.exp(1));
                    Class<?> rightType = visit(ctx.exp(0));
                    if (leftType == Double.class || rightType == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DLEQ));
                    } else {
                        instrucoes.add(new Instrucion(Commands.ILEQ));
                    }
                }
            }
            if (getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
                return String.class;
            }
            return Boolean.class;
        }

        //EXP---------------------------------------------------------------------------------
        @Override
        public Class<?>  visitInstrucao(SolParser.InstrucaoContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            visitChildren(ctx);
            return null;
        }
        @Override
        public Class<?>  visitPrint(SolParser.PrintContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            visit(ctx.exp());
            Class<?> Atual = getValues(ctx);
            if(Atual == Integer.class)
                instrucoes.add(new Instrucion(Commands.IPRINT));
            else if(Atual == Double.class)
                instrucoes.add(new Instrucion(Commands.DPRINT));
            else if(Atual == String.class)
                instrucoes.add(new Instrucion(Commands.SPRINT));
            else if(Atual == Boolean.class)
                instrucoes.add(new Instrucion(Commands.BPRINT));
            return null;
        }
        @Override
        public Class<?>  visitWhileState(SolParser.WhileStateContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            breaks.add(new ArrayList<>());
            ciclos++;
            visit(ctx.exp());
            System.out.println("jumpf while");
            visit(ctx.instrucao());
            ciclos--;
            System.out.println("jump while");
            return null;
        }

        public void setBreaks( ){
            for (int i = 0; i< breaks.get(ciclos).size(); i++){
                instrucoes.get(i).setValue(instrucoes.size());
            }
            breaks.remove(ciclos);
        }
        @Override
        public Class<?>  visitForState(SolParser.ForStateContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            breaks.add(new ArrayList<>());
            ciclos++;
            int iniciofor = instrucoes.size();
            visit(ctx.exp(0));
            instrucoes.add(new Instrucion(Commands.GSTORE, PosicaoVariaveis.get(ctx.NOME().getText())));
            instrucoes.add(new Instrucion(Commands.GLOAD, PosicaoVariaveis.get(ctx.NOME().getText())));
            visit(ctx.exp(1));
            instrucoes.add(new Instrucion(Commands.ILEQ));
            int posicaoJumpf = instrucoes.size();
            instrucoes.add(new Instrucion(Commands.JUMPF, -1));
            visit(ctx.instrucao());
            instrucoes.add(new Instrucion(Commands.GLOAD, PosicaoVariaveis.get(ctx.NOME().getText())));
            instrucoes.add(new Instrucion(Commands.ICONST, 1));
            instrucoes.add(new Instrucion(Commands.GSTORE, PosicaoVariaveis.get(ctx.NOME().getText())));
            instrucoes.add(new Instrucion(Commands.IADD));
            instrucoes.add(new Instrucion(Commands.JUMP, iniciofor));
            instrucoes.get(posicaoJumpf).setValue(instrucoes.size());
            setBreaks();
            ciclos--;
            return null;
        }
        @Override
        public Class<?>  visitIfState(SolParser.IfStateContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            visit(ctx.exp());
            int inicioIF = instrucoes.size();
            instrucoes.add(new Instrucion(Commands.JUMPF, -1));
            visit(ctx.instrucao(0));
            if(ctx.ELSE() != null){
                int inicioElse = instrucoes.size();
                instrucoes.add(new Instrucion(Commands.JUMP, -1));
                instrucoes.get(inicioIF).setValue(instrucoes.size());
                visit(ctx.instrucao(1));
                instrucoes.get(inicioElse).setValue(instrucoes.size());
            } else {
                instrucoes.get(inicioIF).setValue(instrucoes.size());
            }
            return null;
        }

        @Override
        public Class<?> visitBreak(SolParser.BreakContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            breaks.get(ciclos).add(ciclos);
            instrucoes.add(new Instrucion(Commands.JUMP, -1));
            return null;
        }

        @Override
        public Class<?> visitAND(SolParser.ANDContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            visit(ctx.exp(0));
            visit(ctx.exp(1));
            instrucoes.add(new Instrucion(Commands.AND));
            if (getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }
            return Boolean.class;
        }
        @Override
        public Class<?>  visitOR(SolParser.ORContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            visit(ctx.exp(0));
            visit(ctx.exp(1));
            instrucoes.add(new Instrucion(Commands.OR));
            if (getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }
            return Boolean.class;
        }

        @Override
        public Class<?>  visitDeclaracao(SolParser.DeclaracaoContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            if(ctx.exp()!=null){
                visitChildren(ctx.exp());
                instrucoes.add(new Instrucion(Commands.GSTORE, countVariable));
            }
            PosicaoVariaveis.put(ctx.NOME().getText(), countVariable++);
            return null;
        }

        @Override public Class<?>  visitTiposNoCodigo(SolParser.TiposNoCodigoContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            instrucoes.add(new Instrucion(Commands.GALLOC, ctx.declaracao().size()));
            visitChildren(ctx);
            return null;
        }
        @Override public Class<?>  visitDeclarar(SolParser.DeclararContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
                    for(int i = 0; i<ctx.exp().size(); i++){
                        visitChildren(ctx.exp(i));
                        instrucoes.add(new Instrucion(Commands.GSTORE, PosicaoVariaveis.get(ctx.getText())));
                    }
                    return null;
        }

        //Variveis----------------------------------------------------------------------------------------

        public ParseTree getvariable(ParserRuleContext exp, int varivavel){
            return exp.getChild(varivavel).getChild(0);
        }
        
        @Override
        public Class<?>  visitINT(SolParser.INTContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            Class<?> Parent = getValues(ctx.getParent().getParent());
            ParserRuleContext exp = ctx.getParent().getParent();
            instrucoes.add(new Instrucion(Commands.ICONST, Integer.parseInt(ctx.getText())));
            if (Parent == String.class) {
                instrucoes.add(new Instrucion(Commands.ITOS));
            } else if (Parent == Double.class) {
                instrucoes.add(new Instrucion(Commands.ITOD));
            } else if (Parent == Boolean.class) {
                if (getValues(getvariable(exp,0)) == Double.class || getValues(getvariable(exp,2)) == Double.class) {
                    instrucoes.add(new Instrucion(Commands.ITOD));
                    return Double.class;
                }
                return Integer.class;
            }
            return Objects.requireNonNullElse(Parent, Integer.class);
        }
        @Override
        public Class<?>  visitDOUBLE(SolParser.DOUBLEContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            Class<?> Parent = getValues(ctx.getParent().getParent());
            instrucoes.add(new Instrucion(Commands.DCONST, constantpoll.size()));
            constantpoll.add(Double.parseDouble(ctx.getText()));
            if (Parent == String.class) {
                instrucoes.add(new Instrucion(Commands.DTOS));
            }
            if(Parent == Boolean.class)
                return Double.class;
            return Objects.requireNonNullElse(Parent, Double.class);
        }

        @Override
        public Class<?> visitTRUE(SolParser.TRUEContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            Class<?> Parent = getValues(ctx.getParent().getParent());
            instrucoes.add(new Instrucion(Commands.TCONST));
            if (Parent == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }

            return Objects.requireNonNullElse(Parent, Boolean.class);
        }

        @Override
        public Class<?> visitFALSE(SolParser.FALSEContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            Class<?> Parent = getValues(ctx.getParent().getParent());
            instrucoes.add(new Instrucion(Commands.FCONST));
            if (Parent == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }

            return Objects.requireNonNullElse(Parent, Boolean.class);
        }

        @Override
        public Class<?>  visitSTRING(SolParser.STRINGContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            instrucoes.add(new Instrucion(Commands.DCONST, constantpoll.size()));
            constantpoll.add(ctx.getText());
            return String.class;
        }
        @Override
        public Class<?>  visitNOME(SolParser.NOMEContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            instrucoes.add(new Instrucion(Commands.GLOAD, PosicaoVariaveis.get(ctx.getText())));
            ParserRuleContext exp = ctx.getParent().getParent();
            Class<?> Parent = getValues(exp);
            Class<?> Variavel = getValues(ctx);
            if (Parent == String.class && Variavel.equals(Integer.class)) {
                instrucoes.add(new Instrucion(Commands.ITOS));
            } else if (Parent == Double.class && Variavel.equals(Integer.class)) {
                instrucoes.add(new Instrucion(Commands.ITOD));
            } else if (Parent == Boolean.class && Variavel.equals(Integer.class)) {

                if (getValues(exp.getChild(0).getChild(0)) == Double.class || getValues(exp.getChild(2).getChild(0)) == Double.class) {
                    instrucoes.add(new Instrucion(Commands.ITOD));
                    return Double.class;
                }
                return Integer.class;
            } else if (Parent == String.class && Variavel.equals(Boolean.class)) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            } else if (Parent == String.class && Variavel.equals(Double.class)) {
                instrucoes.add(new Instrucion(Commands.DTOS));
            }
            if(Parent == Boolean.class)
                return Variavel;
            return Objects.requireNonNullElse(Parent, Variavel);
        }
        //Variveis----------------------------------------------------------------------------------------




        public void execute(String[] args) {
            String inputFile = null;
            if (args.length > 0)
                inputFile = args[0];
            InputStream is = System.in;
            try {
                if (inputFile != null) is = new FileInputStream(inputFile);
                CharStream input = CharStreams.fromStream(is);
                SolLexer lexer = new SolLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                SolParser parser = new SolParser(tokens);
                parser.removeErrorListeners(); // Remove the default console error listener
                parser.addErrorListener(new ConsoleErrorListener());
                ParseTree tree = parser.program();
                int numberOfErrors = parser.getNumberOfSyntaxErrors();
                if (numberOfErrors > 0) {
                    System.err.println("Foram detectados " + numberOfErrors + " erros de Syntax.");
                    System.exit(0);
                }
                VerifyNodes teste = new VerifyNodes();
                values=teste.TestTree(tree);


                this.visit(tree);
            } catch (IOException e) {
                System.err.println("File Not Found.");
                System.exit(0);
            }
        }

    }

    public void executeSol(String[] args){
        Visitor visitor = new Visitor();
        visitor.execute(args);
    }


    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        visitor.execute(args);
    }

}
