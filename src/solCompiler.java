import Sol.SolBaseListener;
import Sol.SolLexer;
import Sol.SolParser;
import Sol.SolBaseVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.*;

public class solCompiler {

    static class Visitor extends SolBaseVisitor<Class<?>> {
        private final Map<String, Class<?>> tiposVariaveis = new HashMap<>();
        private ArrayList<ArrayList<Integer>> breaks = new ArrayList<ArrayList<Integer>>();
        private int ciclos = -1;

        int count = 0;
        private ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();
        public Class<?> visitProgram(SolParser.ProgramContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            visitChildren(ctx);
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
                        System.out.println("DEQ");
                    } else if (leftType == Integer.class) {
                        System.out.println("IEQ");
                    } else if (leftType == String.class) {
                        System.out.println("SEQ");
                    } else {
                        System.out.println("BEQ");
                    }
                    break;
                case "!=":
                    if (leftType == Double.class || rightType == Double.class) {
                        System.out.println("DNEQ");
                    } else if (leftType == Integer.class) {
                        System.out.println("INEQ");
                    } else if (leftType == String.class) {
                        System.out.println("SNEQ");
                    } else {
                        System.out.println("BNEQ");
                    }
                    break;
            }
            if (getValues(ctx.getParent()) == String.class) {
                System.out.println("BTOS");
            }
            return null;
        }

        @Override
        public Class<?> visitORDER(SolParser.ORDERContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            Class<?> Order = visit(ctx.exp());
            Class<?> Parent = getValues(ctx.getParent());
            if(Parent == String.class) {
                if (Order != Parent) {
                    System.out.println("Instruction: ITOS");
                }
                else if (Order.equals(Double.class)) {
                    System.out.println("Instruction: DTOS");
                }
            }
            else if (Parent == Double.class) {
                if (Order == Integer.class)
                    System.out.println("Instrução: ITOD");
            }
            return Parent;
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
                        System.out.println("DUMINUS");
                    } else {
                        System.out.println("IUMINUS");
                    }
                    break;
                case "not":
                    System.out.println("NOT");
                    break;
            }
            if (Parent == String.class) {
                if (Order == Double.class) {
                    System.out.println("DTOS");
                } else if (Order == Integer.class) {
                    System.out.println("ITOS");
                } else {
                    System.out.println("BTOS");
                }
            } else if (Order != Double.class && Parent == Double.class) {
                System.out.println("ITOD");
            }
            return Parent;
        }
        @Override
        public Class<?> visitADDSUB(SolParser.ADDSUBContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            String operador = ctx.op.getText();
            Class<?> Order = visitChildren(ctx);
            Class<?> Parent = getValues(ctx.getParent());
            switch (operador) {
                case "+":
                    if (Order == Double.class) {
                        System.out.println("DADD");
                    } else if (Order == Integer.class) {
                        System.out.println("IADD");
                    } else {
                        System.out.println("SADD");
                    }
                    break;
                case "-":
                    if (Order == Double.class) {
                        System.out.println("DSUB");
                    } else {
                        System.out.println("ISUB");
                    }
                    break;
            }
            if (Parent == String.class) {
                if (Order == Double.class) {
                    System.out.println("DTOS");
                } else if (Order == Integer.class) {
                    System.out.println("ITOS");
                }
            }else if (Order != Double.class && Parent == Double.class) {
                System.out.println("ITOD");
            }
            return Parent;
        }

        @Override
        public Class<?>  visitMULTDIV(SolParser.MULTDIVContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            String operador = ctx.op.getText();
            Class<?> Order = visitChildren(ctx);
            Class<?> Parent = getValues(ctx.getParent());
            switch (operador) {
                case "*" -> {
                    if (Order == Double.class)
                        System.out.println("DMULT");
                    else
                        System.out.println("IMULT");
                }
                case "/" ->{
                    if(Order == Double.class)
                        System.out.println("DDIV");
                    else
                        System.out.println("IDIV");
                }
                case "%"-> System.out.println("IMOD");
            }
            if (Parent == String.class){
                if (Order == Double.class)
                    System.out.println("DTOS");
                else
                    System.out.println("ITOS");
            } else if (Order != Double.class && Parent == Double.class)
                System.out.println("ITOD");
            return Parent;
        }

        @Override
        public Class<?> visitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println(ctx.getText());
            visitChildren(ctx);
            System.out.println(ctx.getText());
            return getValues(ctx);
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
            Class<?> Atual = visitChildren(ctx);
            if(Atual == Integer.class)
                System.out.println("iprint");
            else if(Atual == Double.class)
                System.out.println("dprint");
            else if(Atual == String.class)
                System.out.println("sprint");
            else if(Atual == Boolean.class)
                System.out.println("bprint");
            return null;
        }
        @Override
        public Class<?>  visitWhileState(SolParser.WhileStateContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            ciclos++;
            System.out.println("jumpf while");
            visitChildren(ctx);
            ciclos--;
            System.out.println("jump while");
            return null;
        }
        @Override
        public Class<?>  visitForState(SolParser.ForStateContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            ciclos++;
            System.out.println("jumpf for");
            visitChildren(ctx);
            ciclos--;
            System.out.println("jump for");
            return null;
        }
        @Override
        public Class<?>  visitIfState(SolParser.IfStateContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("jumpf if");
            visitChildren(ctx);
            System.out.println("jump if");
            return null;
        }

        @Override
        public Class<?> visitBreak(SolParser.BreakContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            breaks.get(ciclos).add(ciclos);
            System.out.println("jump -1");
            return null;
        }

        @Override
        public Class<?> visitAND(SolParser.ANDContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("AND");
            if (getValues(ctx.getParent()) == String.class) {
                System.out.println("BTOS");
            }
            return Boolean.class;
        }
        @Override
        public Class<?>  visitOR(SolParser.ORContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            visitChildren(ctx);
            System.out.println("OR");
            if (getValues(ctx.getParent()) == String.class) {
                System.out.println("BTOS");
            }
            return Boolean.class;
        }

        @Override
        public Class<?>  visitDeclaracao(SolParser.DeclaracaoContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            if(ctx.exp()!=null){
                visitChildren(ctx.exp());
                System.out.println("gload" + ctx.NOME());
            }

            return null;
        }

        @Override public Class<?>  visitTiposNoCodigo(SolParser.TiposNoCodigoContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("GALLOC " + ctx.declaracao().size());
            visitChildren(ctx);
            return null;
        }
        @Override public Class<?>  visitDeclarar(SolParser.DeclararContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
                    for(int i = 0; i<ctx.exp().size(); i++){
                        visitChildren(ctx.exp(i));
                        System.out.println("gstore" + ctx.NOME(i).getText());
                    }
                    return null;
        }

        //Types-------------------------------------------------------------------------------------------
        @Override
        public Class<?>  visitINTT(SolParser.INTTContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            return Integer.class;
        }

        @Override
        public Class<?>  visitDOUBLET(SolParser.DOUBLETContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            return Double.class;
        }

        @Override
        public Class<?>  visitSTRINGT(SolParser.STRINGTContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            return String.class;
        }

        @Override
        public Class<?>  visitBOLEANT(SolParser.BOLEANTContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            return Boolean.class;
        }
        //Types-------------------------------------------------------------------------------------------

        //Variveis----------------------------------------------------------------------------------------
        @Override
        public Class<?>  visitINT(SolParser.INTContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("iconst " + ctx.getText());
            return Integer.class;
        }
        @Override
        public Class<?>  visitDOUBLE(SolParser.DOUBLEContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("dconst " + ctx.getText());
            return Double.class;
        }

        @Override
        public Class<?> visitTRUE(SolParser.TRUEContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("true " + ctx.getText());
            return Boolean.class;
        }

        @Override
        public Class<?> visitFALSE(SolParser.FALSEContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("false " + ctx.getText());
            return Boolean.class;
        }

        @Override
        public Class<?>  visitSTRING(SolParser.STRINGContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("sconst " + ctx.getText());
            return String.class;
        }

        @Override
        public Class<?>  visitNOME(SolParser.NOMEContext ctx) {
            //System.out.println(ctx.getText() + "-" + count++);
            System.out.println("gload " + ctx.getText());
            return null;
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
