import Sol.SolBaseVisitor;
import Sol.SolLexer;
import Sol.SolParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.*;

public class solCompiler {

    static class Visitor extends SolBaseVisitor<Class<?>> {
        private final Map<String, Integer> PosicaoVariaveis = new HashMap<>();
        private final ArrayList<ArrayList<Integer>> breaks = new ArrayList<>();

        private final ArrayList<Instrucion> instrucoes = new ArrayList<>();

        private final ArrayList<Object> constantpoll = new ArrayList<>();
        private int ciclos = -1;

        private int countVariable = 0;

        private ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();

        public Class<?> getValues(ParseTree node){
            return values.get(node);
        }

        //EXP---------------------------------------------------------------------------------
        public Class<?> visitProgram(SolParser.ProgramContext ctx) {
            visitChildren(ctx);
            instrucoes.add(new Instrucion(Commands.HALT));
            return null;
        }
        /**
         *
         * @param ctx the parse tree
         */
        @Override
        public Class<?>  visitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx) {
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
            return TypesConverter(ctx.getParent(), leftType);
        }

        @Override
        public Class<?> visitORDER(SolParser.ORDERContext ctx) {
            Class<?> Order = visit(ctx.exp());
            return TypesConverter(ctx.getParent(), Order);
        }
        @Override
        public Class<?> visitNEGACION(SolParser.NEGACIONContext ctx) {
            String operador = ctx.op.getText();
            Class<?> NegacionClass = visitChildren(ctx);
            switch (operador) {
                case "-":
                    if (NegacionClass == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DUMINUS));
                    } else {
                        instrucoes.add(new Instrucion(Commands.IUMINUS));
                    }
                    break;
                case "not":
                    instrucoes.add(new Instrucion(Commands.NOT));
                    break;
            }

            return TypesConverter(ctx.getParent(), NegacionClass);
        }
        @Override
        public Class<?> visitADDSUB(SolParser.ADDSUBContext ctx) {
            String operador = ctx.op.getText();
            Class<?> expClass = visit(ctx.exp(0));
            visit(ctx.exp(1));
            switch (operador) {
                case "+":
                    if (expClass == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DADD));
                    } else if (expClass == Integer.class) {
                        instrucoes.add(new Instrucion(Commands.IADD));
                    } else {
                        instrucoes.add(new Instrucion(Commands.SADD));
                    }
                    break;
                case "-":
                    if (expClass == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DSUB));
                    } else {
                        instrucoes.add(new Instrucion(Commands.ISUB));
                    }
                    break;
            }
            return TypesConverter(ctx.getParent(), expClass);
        }
        @Override
        public Class<?>  visitMULTDIV(SolParser.MULTDIVContext ctx) {
            String operador = ctx.op.getText();
            Class<?> MultDivClass = visit(ctx.exp(0));
            visit(ctx.exp(1));
            switch (operador) {
                case "*" -> {
                    if (MultDivClass == Double.class)
                        instrucoes.add(new Instrucion(Commands.DMULT));
                    else
                        instrucoes.add(new Instrucion(Commands.IMULT));
                }
                case "/" ->{
                    if(MultDivClass == Double.class)
                        instrucoes.add(new Instrucion(Commands.DDIV));
                    else
                        instrucoes.add(new Instrucion(Commands.IDIV));
                }
                case "%"-> instrucoes.add(new Instrucion(Commands.IMOD));
            }

            return TypesConverter(ctx.getParent(), MultDivClass);
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

            return TypesConverter(ctx.getParent(), Boolean.class);
        }

        //EXP---------------------------------------------------------------------------------
        @Override
        public Class<?>  visitInstrucao(SolParser.InstrucaoContext ctx) {
            
            visitChildren(ctx);
            return null;
        }
        @Override
        public Class<?>  visitPrint(SolParser.PrintContext ctx) {
            
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
            breaks.add(new ArrayList<>());
            ciclos++;
            int inicioWHILE = instrucoes.size();
            visit(ctx.exp());
            int posicaoJumpf = instrucoes.size();
            instrucoes.add(new Instrucion(Commands.JUMPF, -1));
            visit(ctx.instrucao());
            instrucoes.add(new Instrucion(Commands.JUMP, inicioWHILE));
            instrucoes.get(posicaoJumpf).setValue(instrucoes.size());
            setBreaks();
            ciclos--;
            HaveReturn=false;
            return null;
        }

        /**
         * Atualiza as instrucoes breaks
         */
        public void setBreaks( ){
            for (int i = 0; i< breaks.get(ciclos).size(); i++){
                instrucoes.get(breaks.get(ciclos).get(i)).setValue(instrucoes.size());
            }
            breaks.remove(ciclos);
        }
        @Override
        public Class<?>  visitForState(SolParser.ForStateContext ctx) {
            breaks.add(new ArrayList<>());
            ciclos++;
            visit(ctx.exp(0));
            instrucoes.add(new Instrucion(Commands.GSTORE, PosicaoVariaveis.get(ctx.NOME().getText())));
            int iniciofor = instrucoes.size();
            instrucoes.add(new Instrucion(Commands.GLOAD, PosicaoVariaveis.get(ctx.NOME().getText())));
            visit(ctx.exp(1));
            instrucoes.add(new Instrucion(Commands.ILEQ));
            int posicaoJumpf = instrucoes.size();
            instrucoes.add(new Instrucion(Commands.JUMPF, -1));
            visit(ctx.instrucao());
            instrucoes.add(new Instrucion(Commands.GLOAD, PosicaoVariaveis.get(ctx.NOME().getText())));
            instrucoes.add(new Instrucion(Commands.ICONST, 1));
            instrucoes.add(new Instrucion(Commands.IADD));
            instrucoes.add(new Instrucion(Commands.GSTORE, PosicaoVariaveis.get(ctx.NOME().getText())));
            instrucoes.add(new Instrucion(Commands.JUMP, iniciofor));
            instrucoes.get(posicaoJumpf).setValue(instrucoes.size());
            setBreaks();
            ciclos--;
            HaveReturn=false;
            return null;
        }
        @Override
        public Class<?>  visitIfState(SolParser.IfStateContext ctx) {
            visit(ctx.exp());
            int inicioIF = instrucoes.size();
            instrucoes.add(new Instrucion(Commands.JUMPF, -1));
            visit(ctx.instrucao(0));
            boolean ifreturn = HaveReturn;
            HaveReturn=false;
            if(ctx.ELSE() != null){
                int inicioElse = instrucoes.size();
                instrucoes.add(new Instrucion(Commands.JUMP, -1));
                instrucoes.get(inicioIF).setValue(instrucoes.size());
                visit(ctx.instrucao(1));
                instrucoes.get(inicioElse).setValue(instrucoes.size());
            } else {
                instrucoes.get(inicioIF).setValue(instrucoes.size());
            }
            HaveReturn=ifreturn&&HaveReturn;
            return null;
        }

        @Override
        public Class<?> visitBreak(SolParser.BreakContext ctx) {
            breaks.get(ciclos).add(instrucoes.size());
            instrucoes.add(new Instrucion(Commands.JUMP, -1));
            return null;
        }

        @Override
        public Class<?> visitAND(SolParser.ANDContext ctx) {
            visit(ctx.exp(0));
            visit(ctx.exp(1));
            instrucoes.add(new Instrucion(Commands.AND));
            return TypesConverter(ctx.getParent(), Boolean.class);
        }
        @Override
        public Class<?>  visitOR(SolParser.ORContext ctx) {
            visit(ctx.exp(0));
            visit(ctx.exp(1));
            instrucoes.add(new Instrucion(Commands.OR));
            return TypesConverter(ctx.getParent(), Boolean.class);
        }



        @Override public Class<?>  visitVariavelGlobal(SolParser.VariavelGlobalContext ctx) {
            instrucoes.add(new Instrucion(Commands.GALLOC, ctx.declaracao().size()));
            visitChildren(ctx);
            return null;
        }

        //Variveis----------------------------------------------------------------------------------------

        //Types-------------------------------------------------------------------------------------------
        @Override
        public Class<?>  visitINTT(SolParser.INTTContext ctx) {
            return Integer.class;
        }

        @Override
        public Class<?>  visitDOUBLET(SolParser.DOUBLETContext ctx) {
            return Double.class;
        }

        @Override
        public Class<?>  visitSTRINGT(SolParser.STRINGTContext ctx) {
            return String.class;
        }

        @Override
        public Class<?>  visitBOLEANT(SolParser.BOLEANTContext ctx) {
            return Boolean.class;
        }

        public Class<?> TypesConverter(ParserRuleContext Parent, Class<?> Atual){
            Class<?> ClassParent = getValues(Parent);
            if (ClassParent == String.class && Atual.equals(Integer.class)) {
                instrucoes.add(new Instrucion(Commands.ITOS));
            } else if (ClassParent == Double.class && Atual.equals(Integer.class)) {
                instrucoes.add(new Instrucion(Commands.ITOD));
            } else if (ClassParent == Boolean.class && Atual.equals(Integer.class)) {
                if (getValues(getvariable(Parent,0)) == Double.class || getValues(getvariable(Parent,2)) == Double.class) {
                    instrucoes.add(new Instrucion(Commands.ITOD));
                    return Double.class;
                }
                return Integer.class;
            } else if (ClassParent == String.class && Atual.equals(Boolean.class)) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            } else if (ClassParent == String.class && Atual.equals(Double.class)) {
                instrucoes.add(new Instrucion(Commands.DTOS));
            }
            if(ClassParent == Boolean.class)
                return Atual;
            System.out.println(ClassParent + "  " + Atual);
            return Objects.requireNonNullElse(ClassParent, Atual);

        }

        public ParseTree getvariable(ParserRuleContext exp, int varivavel){
            return exp.getChild(varivavel).getChild(0);
        }
        
        @Override
        public Class<?>  visitINT(SolParser.INTContext ctx) {
            ParserRuleContext exp = ctx.getParent().getParent();
            instrucoes.add(new Instrucion(Commands.ICONST, Integer.parseInt(ctx.getText())));
            return TypesConverter(exp, getValues(ctx));
        }
        @Override
        public Class<?>  visitDOUBLE(SolParser.DOUBLEContext ctx) {
            instrucoes.add(new Instrucion(Commands.DCONST, constantpoll.size()));
            constantpoll.add(Double.parseDouble(ctx.getText()));
            ParserRuleContext exp = ctx.getParent().getParent();
            return TypesConverter(exp, getValues(ctx));
        }

        @Override
        public Class<?> visitTRUE(SolParser.TRUEContext ctx) {
            instrucoes.add(new Instrucion(Commands.TCONST));
            ParserRuleContext exp = ctx.getParent().getParent();
            return TypesConverter(exp, getValues(ctx));
        }

        @Override
        public Class<?> visitFALSE(SolParser.FALSEContext ctx) {
            instrucoes.add(new Instrucion(Commands.FCONST));
            ParserRuleContext exp = ctx.getParent().getParent();
            return TypesConverter(exp, getValues(ctx));
        }

        @Override
        public Class<?>  visitSTRING(SolParser.STRINGContext ctx) {
            instrucoes.add(new Instrucion(Commands.SCONST, constantpoll.size()));
            constantpoll.add(ctx.getText());
            return String.class;
        }
//----------------------------------------------------------------------------------------------------------------------------------
        private HashMap<String, Funcao> functionMap ;


        private String funcaoAtual;

        private final ArrayList<ArrayList<Variaveis>>  VariaveisLocais = new ArrayList<>();

        private boolean HaveReturn = false;

        public Class<?> visitReturn(SolParser.ReturnContext ctx){
            visit(ctx.exp());
            Funcao currentFunction = functionMap.get(funcaoAtual);
            if(currentFunction.type() != null)
                instrucoes.add(new Instrucion(Commands.RETVAL, currentFunction.arguments().size()));
            else
                instrucoes.add(new Instrucion(Commands.RET, currentFunction.arguments().size()));
            HaveReturn=true;
            return null;
        }
        private int lloadposicao;
        @Override
        public Class<?> visitFuncao(SolParser.FuncaoContext ctx) {
            HaveReturn=false;
            funcaoAtual = ctx.NOME().getText();
            lloadposicao = 2;
            ArrayList<Variaveis> variaveisLocais = new ArrayList<>();
            int posicao = -1;
            for (int i = ctx.arguments().size()-1; i >=0 ; i--) {
                variaveisLocais.add(new Variaveis(false,visit(ctx.arguments(i).types()) ,ctx.arguments(i).NOME().getText() , posicao));
                posicao--;
            }

            for(Variaveis vari: variaveisLocais){
                System.out.println(vari);
            }
            VariaveisLocais.add(variaveisLocais);


            visit(ctx.bloco());
            if(!HaveReturn)
                instrucoes.add(new Instrucion(Commands.RET, functionMap.get(funcaoAtual).arguments().size()));
            VariaveisLocais.removeLast();
            return null;
        }

        private int bloco = -1;

        @Override
        public Class<?>  visitBloco(SolParser.BlocoContext ctx) {
            bloco++;
            if(bloco !=0)
                VariaveisLocais.add(new ArrayList<>());
            visitChildren(ctx);
            if(bloco!=0){
                if(!HaveReturn){
                    instrucoes.add(new Instrucion(Commands.POP,VariaveisLocais.getLast().size()));
                    lloadposicao -=VariaveisLocais.getLast().size();
                }

                VariaveisLocais.removeLast();
            }

            bloco--;
            return null;
        }

        @Override public Class<?> visitVariavelLocal(SolParser.VariavelLocalContext ctx) {
            instrucoes.add(new Instrucion(Commands.LALLOC, ctx.declaracao().size()));
            for(int i = 0; i<ctx.declaracao().size(); i++)
                VariaveisLocais.get(bloco).add(new Variaveis(false, visit(ctx.types()), ctx.declaracao(i).NOME().getText(), lloadposicao++));
            visitChildren(ctx);
            return null;
        }

        public int VerificarVariavelGlobalAtras(String nome){
            int j = bloco;
            while (j>=0){
                for(Variaveis variaveis: VariaveisLocais.get(j)){
                    if(variaveis.nome().equals(nome))
                        return variaveis.posicao();
                }
                j--;
            }

            return 0;
        }
        public Class<?> visitCall(SolParser.CallFuncaoExpContext ctx) {
            return null;
        }
        @Override
        public Class<?>  visitNOME(SolParser.NOMEContext ctx) {
            int posicaoLocal = VerificarVariavelGlobalAtras(ctx.NOME().getText());
            if(posicaoLocal ==0 )
                instrucoes.add(new Instrucion(Commands.GLOAD, PosicaoVariaveis.get(ctx.getText())));
            else
                instrucoes.add(new Instrucion(Commands.LLOAD, posicaoLocal));
            ParserRuleContext exp = ctx.getParent().getParent();
            return  TypesConverter(exp, getValues(ctx));
        }

        @Override
        public Class<?>  visitDeclaracao(SolParser.DeclaracaoContext ctx) {
            int posicaoLocal = VerificarVariavelGlobalAtras(ctx.NOME().getText());
            if(posicaoLocal==0){
                 if(ctx.exp()!=null){
                     visitChildren(ctx);
                     instrucoes.add(new Instrucion(Commands.GSTORE, countVariable));
                 }
                 PosicaoVariaveis.put(ctx.NOME().getText(), countVariable++);
            } else {
                if(ctx.exp()!=null){
                    visitChildren(ctx);
                    instrucoes.add(new Instrucion(Commands.LSTORE, posicaoLocal));
                }
            }

            return null;
        }

        @Override
        public Class<?>  visitDeclarar(SolParser.DeclararContext ctx) {

            for(int i = 0; i<ctx.exp().size(); i++){
                int posicaoLocal = VerificarVariavelGlobalAtras(ctx.NOME(i).getText());
                visit(ctx.exp(i));
                if(posicaoLocal==0)
                    instrucoes.add(new Instrucion(Commands.GSTORE, PosicaoVariaveis.get(ctx.NOME(i).getText())));
                else
                    instrucoes.add(new Instrucion(Commands.LSTORE, posicaoLocal));
            }
            return null;
        }
        //Variveis----------------------------------------------------------------------------------------
        /**
         * Escreve os bytecodes no arquivo com extensão .tbc.
         *
         * @param args Um array de strings contendo os argumentos do programa.
         * @throws IOException Se ocorrer um erro de entrada/saida durante a escrita do arquivo.
         */
        private void write(String[] args) throws IOException{
            File file = new File(args[0]);
            String newFile = file.getPath().replaceFirst("[.][^.]+$", ".tbc");
            FileOutputStream fos = new FileOutputStream(newFile);
            DataOutputStream bytescodes = new DataOutputStream(fos);
            writeBytecode(bytescodes);

            newFile = file.getPath().replaceFirst("[.][^.]+$", ".tasm");
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            writeTasm(writer);
        }
        /**
         * Verifica se um comando é um salto (jump).
         *
         * @param command O comando a ser verificado.
         * @return true se o comando for um salto, false caso contrario.
         */
        public boolean isCommandAJump(Commands command){
            return command.equals(Commands.JUMP) || command.equals(Commands.JUMPF) || command.equals(Commands.JUMPT);
        }
        /**
         * Verifica se um valor está na pool de constantes.
         *
         * @param command O comando a ser verificado.
         * @return true se o valor estiver na pool de constantes, false caso contrario.
         */
        public boolean isValueInConstantPool(Commands command){
            return command.equals(Commands.DCONST) || command.equals(Commands.SCONST);
        }

        /** Escreve Tams Commands em um file com base nas instruções fornecidas
         *
         * @param tasmcodes DataOutputStream para onde os comandos vão ser escritos
         * @throws IOException Se ocorrer algum erro de E/S ao escrever o file em bytecode
         */
        private void writeTasm(BufferedWriter tasmcodes) throws IOException {
            int line = 0;
            for (Instrucion  instruction : instrucoes) {
                if (!instruction.isValueNull()) {
                    if (isValueInConstantPool(instruction.getCommand()))
                        tasmcodes.write("L" + line + ": " + instruction.getCommand().name().toLowerCase() + " " + constantpoll.get(instruction.getValue()));
                    else if (isCommandAJump(instruction.getCommand())) {
                        tasmcodes.write("L" + line + ": " + instruction.getCommand().name().toLowerCase() + " L" + instruction.getValue());
                    } else {
                        tasmcodes.write("L" + line + ": " + instruction.getCommand().name().toLowerCase() + " " + instruction.getValue());
                    }
                } else {
                    tasmcodes.write("L" + line + ": " + instruction.getCommand().name().toLowerCase());
                }
                tasmcodes.newLine(); // Add a new line for each instruction
                line++;
            }
            // Flush and close the BufferedWriter after writing
            tasmcodes.flush();
            tasmcodes.close();
        }

        /** Escreve bytecode em um file com base nas instruções fornecidas
         *
         * @param bytecodes DataOutputStream para onde os comandos vão ser escritos
         * @throws IOException Se ocorrer algum erro de E/S ao escrever o file em bytecode
         */
        private void writeBytecode(DataOutputStream bytecodes) throws IOException {
            for (Instrucion instruction : instrucoes) {
                bytecodes.write(instruction.getCommand().ordinal());
                if(instruction.getValue() != null){
                    bytecodes.writeInt( instruction.getValue());
                }
            }
            writeConstantPoll(bytecodes);
        }

        /** Escreve a tabela de constantes em bytecode no fim do file
         *
         * @param bytecodes Serve para a criação de dados em byte
         * @throws IOException Se ocorrer algum erro de E/S ao escrever na constant
         */
        public void writeConstantPoll(DataOutputStream bytecodes) throws IOException{
            bytecodes.write(Commands.values().length);
            for (Object constant: constantpoll){
                if(constant instanceof Double){
                    bytecodes.write(0);
                    bytecodes.writeDouble((double) constant);
                } else if (constant instanceof String finalstring){
                    finalstring = finalstring.substring(1,finalstring.length()-1);
                    bytecodes.write(1);
                    bytecodes.writeInt(finalstring.length());
                    bytecodes.writeChars(finalstring);
                }

            }
        }
        /**Metodo que mostra as instruções e a constantPool
         */
        public void debug(){
            System.out.println("----------------------------------------\nConstant Pool:");
            for (int i = 0; i<constantpoll.size(); i++) {
                System.out.println(i + ": " + constantpoll.get(i));
            }
            System.out.println("-----------------------------------------\nInstrution array:");
            for (int i = 0; i<instrucoes.size(); i++) {
                System.out.println("L"+i + ": " + instrucoes.get(i));
            }
            System.out.println("-----------------------------------------");
        }


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
                functionMap = teste.getFunctionMap();

                this.visit(tree);
            } catch (IOException e) {
                System.err.println("File Not Found.");
                System.exit(0);
            }
        }

    }

    public void executeSol(String[] args) throws IOException {
        Visitor visitor = new Visitor();
        visitor.execute(args);
        visitor.write(args);
    }


    public static void main(String[] args) throws IOException {
        boolean debug = false;
        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        for (String arg : inputArguments) {
            if (arg.contains("jdwp")) {
                debug = true;
                break;
            }
        }
        Visitor visitor = new Visitor();
        visitor.execute(args);
        debug=true;
        if (debug){
            visitor.debug();
        }
        visitor.write(args);
    }

}
