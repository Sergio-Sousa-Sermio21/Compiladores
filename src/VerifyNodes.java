import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class VerifyNodes extends SolBaseVisitor<Class<?>> {
    private final HashMap<String, Funcao> functionMap = new HashMap<>();

    private final HashMap<String, Variaveis> Variaveis = new HashMap<>();
    
    private final ArrayList<ArrayList<Variaveis>>  VariaveisLocais = new ArrayList<>();
    private final ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();

    private final ArrayList<String> errors = new ArrayList<>();
    private int loopCount = 0;

    private Stack<String> funcaoAtual = new Stack<>();



    /**
     * Metodo que associa o um valor com um node da arvore
     * @param node O node da arvore
     * @param a A classe que representa o valor do node
     */
    public void setValues(ParseTree node, Class<?> a){
        values.put(node,a);
    }
    public Class<?> getValues(ParseTree node){
        return values.get(node);
    }
    public Class<?> visitProgram(SolParser.ProgramContext ctx) {
        boolean main = false;
        for(int i = 0; i<ctx.funcao().size(); i++){
            checkDuplicateFunctionName(ctx.funcao(i));
            if(ctx.funcao(i).NOME().getText().equals("main"))
                main = true;
        }
        if(!main)
            errors.add("Line " + ctx.stop.getLine() + ":" + (ctx.stop.getCharPositionInLine()+1) + ": No main found" );
        visitChildren(ctx);
        return null;
    }

    /** Para todos visits
     * Métodos responsáveis por visitar um no na arvore de analise sintatica que representa um operador.
     * Faz a verificacao dos tipos das expressoes a esquerda e à direita do operador e realiza as verificacoes de tipo apropriadas.
     *
     * @param ctx O contexto do no na árvore de análise sintatica.
     * @return O tipo resultante da expressao.
     */

    //EXP---------------------------------------------------------------------------------
    @Override
    public Class<?>  visitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx) {
        Class<?> left = visit(ctx.exp(0));
        Class<?> right = visit(ctx.exp(1));
        if(left == Object.class || right == Object.class){
            setValues(ctx, Object.class);
        }
        else{
            if(left!=right && !((left == Integer.class && right == Double.class) || (left == Double.class && right == Integer.class))){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Cannot compare " + left.getSimpleName() + " and " + right.getSimpleName());
                setValues(ctx, Object.class);
            } else {
                setValues(ctx, Boolean.class);
            }
        }
        return getValues(ctx);
    }

    @Override
    public Class<?> visitORDER(SolParser.ORDERContext ctx) {

        return visit(ctx.exp());
    }
    @Override
    public Class<?> visitNEGACION(SolParser.NEGACIONContext ctx) {
        Class<?> value = visit(ctx.exp());
        if(value == Object.class)
            setValues(ctx, Object.class);
        if(ctx.op.getText().equals("-")){
            if(value != Integer.class && value != Double.class){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Type Boolean and/or String cannot use " + ctx.op.getText() + " operator");
                setValues(ctx, Object.class);
            } else {
                if(value == Double.class)
                    setValues(ctx, Double.class);
                else
                    setValues(ctx, Integer.class);
            }
        } else {
            if(value != Boolean.class){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Type must be Boolean to use " + ctx.op.getText() + " operator");
                setValues(ctx, Object.class);
            }else{
                setValues(ctx, Boolean.class);
            }


        }
        return getValues(ctx);
    }

    @Override
    public Class<?> visitADDSUB(SolParser.ADDSUBContext ctx) {
        System.out.println("addsub" );
        Class<?> left = visit(ctx.exp(0));
        Class<?> rigth = visit(ctx.exp(1));
        if(ctx.op.getText().equals("+")){
            if(left == Object.class || rigth == Object.class){
                setValues(ctx, Object.class);
            }
            else
            if((left == Boolean.class && rigth != String.class) || (left != String.class && rigth == Boolean.class)){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: The operator " + ctx.op.getText() + " isn't valid between " + left.getSimpleName() + " and " + rigth.getSimpleName());
                setValues(ctx, Object.class);
            } else {
                if(left == String.class || rigth == String.class) {
                    setValues(ctx, String.class);
                }
                else if(left == Double.class || rigth ==  Double.class ) {
                    setValues(ctx, Double.class);
                }
                else {
                    setValues(ctx, Integer.class);
                }
            }
        } else {
            if(left == Object.class || rigth == Object.class) {
                setValues(ctx, Object.class);
            }
            else {
                if((left == Boolean.class || rigth == Boolean.class) || (left == String.class || rigth == String.class)){
                    errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: The operator " + ctx.op.getText() + " isn't valid between " + left.getSimpleName() + " and " + rigth.getSimpleName());
                    setValues(ctx, Object.class);
                } else {
                    if(left == Double.class || rigth ==  Double.class ) {
                        setValues(ctx, Double.class);
                    }
                    else{
                        setValues(ctx, Integer.class);
                    }
                }
            }
        }
        return getValues(ctx);
    }

    @Override
    public Class<?>  visitMULTDIV(SolParser.MULTDIVContext ctx) {
        Class<?> left = visit(ctx.exp(0));
        Class<?> rigth = visit(ctx.exp(1));
        if(left == Object.class || rigth == Object.class) {
            setValues(ctx, Object.class);
        }
        else {
            if(ctx.op.getText().equals("%") && (left != Integer.class || rigth!= Integer.class)){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Error in operator % cannot use " + left.getSimpleName() + " and " + rigth.getSimpleName());
                setValues(ctx, Object.class);
            }
            else if(left == String.class || rigth == String.class){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Type String is not allowed in " + ctx.op.getText());
                setValues(ctx, Object.class);
            }
            else if(left == Boolean.class || rigth == Boolean.class){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Type Boolean is not allowed in " + ctx.op.getText());
                setValues(ctx, Object.class);
            }
            else if(left == Double.class || rigth == Double.class){
                setValues(ctx, Double.class);
            }
            else {
                setValues(ctx, Integer.class);
            }
        }
        return getValues(ctx);
    }

    //Verificar isto imporante
    private void checkDuplicateFunctionName(SolParser.FuncaoContext ctx) {
        String nome = ctx.NOME().getText();
        Class<?> typeFuncion = null;
        if(ctx.types() != null)
            typeFuncion = visit(ctx.types());
        if (functionMap.containsKey(nome)) {
            int line = ctx.start.getLine();
            errors.add("Line " + line + ": Function name '" + nome + "' is duplicated.");
        } else {
            functionMap.put(nome, new Funcao(typeFuncion, getArgumentos(ctx)));
        }
    }

    private boolean functionExists(String functionName) {
        return functionMap.containsKey(functionName);
    }

    public Class<?> visitCallFuncaoExp(SolParser.CallFuncaoExpContext ctx) {
        String functionName = ctx.NOME().getText();
        if (!functionExists(functionName)) {
            errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + ": Function '" + functionName + "' does not exist.");
            return Object.class;
        }
        Funcao funcao = functionMap.get(functionName);
        funcaoAtual.push(functionName);
        for(int i = 0;i<ctx.exp().size() && i<funcao.arguments().size(); i++){
           Class<?> exp = visit(ctx.exp(i));
           if(exp != funcao.arguments().get(i).type()){
               errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) +  ": Type '"+ funcao.arguments().get(i).type().getSimpleName() + "' expected but got '" + ctx.exp(i).getText() + "' " + exp.getSimpleName() + " in '" + functionName + "'");
           }
        }
        funcaoAtual.pop();
        if(ctx.exp().size() != funcao.arguments().size())
            errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) +  ": Function '"+ functionName + "' needs " + funcao.arguments().size() + " arguments but got " + ctx.exp().size());
        if(funcao.type() == null){
            errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + ": Can not make expression with void function- '" + functionName);
            return Object.class;
        }

        return funcao.type();
    }
    public Class<?> visitCALLFUNCTION(SolParser.CALLFUNCTIONContext ctx) {
        return visit(ctx.callFuncaoExp());
    }

    public Class<?> visitReturn(SolParser.ReturnContext ctx) {
        return null;
    }

    public Class<?> visitCallFuncaoIntrucion(SolParser.CallFuncaoIntrucionContext ctx) {

        String functionName = ctx.NOME().getText();
        if (!functionExists(functionName)) {
            errors.add("Line " + ctx.start.getLine() + ": Function '" + functionName + "' does not exist.");
        }
        Funcao funcao = functionMap.get(functionName);
        funcaoAtual.push(functionName);
        for(int i = 0;i<ctx.exp().size() && i<funcao.arguments().size(); i++){
            Class<?> exp = visit(ctx.exp(i));
            if(exp != funcao.arguments().get(i).type()){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) +  ": Type '"+ funcao.arguments().get(i).type().getSimpleName() + "' expected but got '" + ctx.exp(i).getText() + "' " + exp.getSimpleName() + " in '" + functionName + "'");
            }
        }
        funcaoAtual.pop();
        if(ctx.exp().size() != funcao.arguments().size())
            errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + ":" + (ctx.start.getCharPositionInLine()+1) +  ": Function '"+ functionName + "' needs " + funcao.arguments().size() + " arguments but got " + ctx.exp().size());
        if(functionMap.get(functionName).type() != null){
            errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + ": Value of '" + functionName +"' needs to assigned to a variable or instrution");
        }
        return null;
    }

    public ArrayList<Argumentos> getArgumentos(SolParser.FuncaoContext ctx){
        ArrayList<Argumentos> argumentos = new ArrayList<>();
        for (int i = 0; i<ctx.arguments().size(); i++)
            argumentos.add(new Argumentos(visit(ctx.arguments(i).types()), ctx.arguments(i).NOME().getText()));
        return argumentos;
    }
    private int bloco = -1;

    @Override
    public Class<?> visitFuncao(SolParser.FuncaoContext ctx) {
        ArrayList<Variaveis> variaveisLocais = new ArrayList<>();
        ArrayList<Argumentos> argumentos = functionMap.get(ctx.NOME().getText()).arguments();
        for(Argumentos argumento: argumentos) {
            if(!functionExists(argumento.nome()))
                variaveisLocais.add(new Variaveis(false, argumento.type(), argumento.nome(), -1));
            else
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine() + 1) +
                        ": The argument '" + argumento.nome() + "' is already a function.");
        }
        VariaveisLocais.add(variaveisLocais);
        visit(ctx.bloco());

        VariaveisLocais.removeLast();
        return null;
    }


    @Override
    public Class<?> visitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx) {
        Class<?> left = visit(ctx.exp(0));
        Class<?> right = visit(ctx.exp(1));
        if(left == Object.class || right == Object.class){
            setValues(ctx, Object.class);
        }
        else{
            if(left == String.class || right == String.class || left == Boolean.class || right == Boolean.class){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Can not compare " + left.getSimpleName() + " and " + right.getSimpleName()  +" in " + ctx.op.getText());
                setValues(ctx, Object.class);
                return Object.class;
            } else{
                setValues(ctx, Boolean.class);
            }
        }

        return getValues(ctx);
    }

    //EXP---------------------------------------------------------------------------------
    @Override
    public Class<?>  visitInstrucao(SolParser.InstrucaoContext ctx) {
        
        visitChildren(ctx);
        return null;
    }
    @Override
    public Class<?>  visitPrint(SolParser.PrintContext ctx) {
        setValues(ctx, visit(ctx.exp()));
        return null;
    }
    @Override
    public Class<?>  visitWhileState(SolParser.WhileStateContext ctx) {
        
        loopCount++;
        Class<?> conditionType = visit(ctx.exp());
        if ( conditionType !=Object.class && !conditionType.equals(Boolean.class)) {
            errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) +
                    " error: While expression must be of type bool");

        }
        visit(ctx.instrucao());
        loopCount--;
        return null;
    }
    @Override
    public Class<?>  visitForState(SolParser.ForStateContext ctx) {
        loopCount++;
        Class<?>  variavel;
        if(Variaveis.containsKey(ctx.NOME().getText())){
            variavel = Variaveis.get(ctx.NOME().getText()).tipo();
        } else {
            errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) +
                    " error: Variable not defined " + ctx.getText());
            variavel = Object.class;
        }
        Class<?> conditionType = visit(ctx.exp(0));
        Class<?> target = visit(ctx.exp(1));
        if(variavel != Object.class && variavel!=Integer.class){
            errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) +
                                " error: For variable needs to be of type int and it is: " + variavel.getSimpleName());
        }
        if (!(target == Object.class || conditionType == Object.class ) && (!conditionType.equals(Integer.class) && target != Integer.class))
            errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine()+1) +
                    " error: For expression must be of type int");
        visit(ctx.instrucao());
        loopCount--;
        return null;
    }
    @Override
    public Class<?>  visitIfState(SolParser.IfStateContext ctx) {
        
        Class<?> conditionType = visit(ctx.exp());
        if ( conditionType!=Object.class && !conditionType.equals(Boolean.class)) {
            errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) +
                    " error: If expression must be of type bool");

        }
        for(int i =0; i<ctx.instrucao().size(); i++)
            visit(ctx.instrucao().get(i));
        return null;
    }

    public Class<?>  visitEmpty(SolParser.EmptyContext ctx) {
        
        return null;
    }
    @Override
    public Class<?> visitBreak(SolParser.BreakContext ctx) {
        
        if (loopCount == 0) {
            errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() +1)+
                    " error: Break statement can only occur inside a loop");
        }
        return null;
    }

    @Override
    public Class<?>  visitBloco(SolParser.BlocoContext ctx) {
        bloco++;
        visitChildren(ctx);
        bloco--;
        return null;
    }

    @Override
    public Class<?> visitAND(SolParser.ANDContext ctx) {
        Class<?> left= visit(ctx.exp(0));
        Class<?> right= visit(ctx.exp(1));
        if(left == Object.class || right == Object.class){
            setValues(ctx, Object.class);
        }
        else{
            if(left != Boolean.class || right != Boolean.class){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Must use Type Boolean for the operator AND" );
                setValues(ctx, Object.class);
            } else {
                setValues(ctx, Boolean.class);
            }
        }
        return getValues(ctx);
    }
    @Override
    public Class<?>  visitOR(SolParser.ORContext ctx) {
        Class<?> left= visit(ctx.exp(0));
        Class<?> right= visit(ctx.exp(1));
        if(left == Object.class || right == Object.class){
            setValues(ctx, Object.class);
        }
        else{
            if(left != Boolean.class || right != Boolean.class){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Must use Type Boolean for the operator OR" );
                setValues(ctx, Object.class);
            } else {
                setValues(ctx, Boolean.class);
            }
        }
        return getValues(ctx);
    }

    @Override
    public Class<?>  visitDeclaracao(SolParser.DeclaracaoContext ctx) {
        Class<?> tipo = visitChildren(ctx);
        if(tipo == null)
            tipo = Object.class;

        return tipo;
    }

    private boolean VerificarVariavelLocal(String Nome){
        for(Variaveis variaveis: VariaveisLocais.get(bloco)){
            if(variaveis.nome().equals(Nome))
                return true;
        }
        return false;
    }

    @Override public Class<?> visitVariavelLocal(SolParser.VariavelLocalContext ctx) {
        Class<?> tipo = visit(ctx.types());
        for(int i = 0; i<ctx.declaracao().size(); i++){
            Class<?> verificar = visit(ctx.declaracao().get(i));
            if(verificar != Object.class && verificar != tipo && !(tipo==Double.class && verificar == Integer.class)) {
                errors.add("Line " + ctx.declaracao().get(i).getStart().getLine() + ":" +
                        (ctx.declaracao().get(i).getStart().getCharPositionInLine() +1)+
                        " error: " + verificar.getSimpleName() + " type mismatch on " + ctx.declaracao().get(i).NOME().getText());
            }
            String nome = ctx.declaracao().get(i).NOME().getText();
            if(functionExists(nome)){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine() + 1) +
                        ": The declaration '" + nome + "' is already a function.");
            }
            else {
                if (VerificarVariavelLocal(nome)) {
                    errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine() + 1) + " error: Variable already defined " + ctx.declaracao().get(i).NOME().getText());
                } else
                    VariaveisLocais.get(bloco).add(new Variaveis(false, tipo, nome, -1));
            }
        }
        return tipo;
    }

    @Override public Class<?>  visitVariavelGlobal(SolParser.VariavelGlobalContext ctx) {
        
        Class<?> tipo = visit(ctx.types());
        for(int i = 0; i<ctx.declaracao().size(); i++){
            Class<?> verificar = visit(ctx.declaracao().get(i));
            if(verificar != Object.class && verificar != tipo && !(tipo==Double.class && verificar == Integer.class)) {
                errors.add("Line " + ctx.declaracao().get(i).getStart().getLine() + ":" +
                        (ctx.declaracao().get(i).getStart().getCharPositionInLine() +1)+
                        " error: " + verificar.getSimpleName() + " type mismatch on " + ctx.declaracao().get(i).NOME().getText());
            }
            String nome = ctx.declaracao().get(i).NOME().getText();
            if(functionExists(nome)){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine() + 1) +
                        ": The declaration '" + nome + "' is already a function.");
            }
            else {
                if (Variaveis.containsKey(nome)) {
                    errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine() + 1) + " error: Variable already defined " + ctx.declaracao().get(i).NOME().getText());
                } else
                    Variaveis.put(ctx.declaracao().get(i).NOME().getText(), new Variaveis(true, tipo, nome, -1));
            }
        }
        return tipo;
    }

    //Types-------------------------------------------------------------------------------------------
    @Override
    public Class<?>  visitINTT(SolParser.INTTContext ctx) {
        
        setValues(ctx, Integer.class);
        return Integer.class;
    }

    @Override
    public Class<?>  visitDOUBLET(SolParser.DOUBLETContext ctx) {
        
        setValues(ctx, Double.class);
        return Double.class;
    }

    @Override
    public Class<?>  visitSTRINGT(SolParser.STRINGTContext ctx) {
        
        setValues(ctx, String.class);
        return String.class;
    }

    @Override
    public Class<?>  visitBOLEANT(SolParser.BOLEANTContext ctx) {
        
        setValues(ctx, Boolean.class);
        return Boolean.class;
    }
    //Types-------------------------------------------------------------------------------------------

    //Variveis----------------------------------------------------------------------------------------
    @Override
    public Class<?>  visitINT(SolParser.INTContext ctx) {
        
        setValues(ctx, Integer.class);
        return Integer.class;
    }
    @Override
    public Class<?>  visitDOUBLE(SolParser.DOUBLEContext ctx) {
        
        setValues(ctx, Double.class);
        return Double.class;
    }

    @Override
    public Class<?> visitTRUE(SolParser.TRUEContext ctx) {
        
        setValues(ctx, Boolean.class);
        return Boolean.class;
    }

    @Override
    public Class<?> visitFALSE(SolParser.FALSEContext ctx) {
        
        setValues(ctx, Boolean.class);
        return Boolean.class;
    }

    @Override
    public Class<?>  visitSTRING(SolParser.STRINGContext ctx) {
        
        setValues(ctx, String.class);
        return String.class;
    }

    @Override
    public Class<?>  visitNOME(SolParser.NOMEContext ctx) {
        String nome = ctx.NOME().getText();
        System.out.println(nome + " " + ctx.start.getLine());
        if(functionExists(nome)){
            errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine() + 1) +
                    ": The declaration '" + nome + "' is already a function.");
            setValues(ctx, Object.class);
            return Object.class;
        }
        else {
            if (!Variaveis.containsKey(nome) && !VerificarVariavelGlobalAtras(nome)) {
                errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) +
                        " error: Variable not defined " + ctx.getText());
                setValues(ctx, Object.class);
                return Object.class;
            }
            if (VerificarVariavelGlobalAtras(nome)) {
                setValues(ctx, TipoVariavelLocal(nome));
                return TipoVariavelLocal(nome);
            }

            setValues(ctx, Variaveis.get(ctx.NOME().getText()).tipo());
            return Variaveis.get(ctx.NOME().getText()).tipo();
        }
    }

    //Variveis----------------------------------------------------------------------------------------

    public boolean VerificarVariavelGlobalAtras(String nome){
        int j = bloco;
        while (j>=0){
            for(Variaveis variaveis: VariaveisLocais.get(j)){
                if(variaveis.nome().equals(nome))
                    return true;
            }
            j--;
        }

        return false;
    }

    public Class<?> TipoVariavelLocal(String nome){
        int j = bloco;
        while (j>=0){
            for(Variaveis variaveis: VariaveisLocais.get(j)){
                if(variaveis.nome().equals(nome))
                    return variaveis.tipo();
            }
            j--;
        }

        return null;
    }

    @Override public Class<?>  visitDeclarar(SolParser.DeclararContext ctx) {
        
        for(int i = 0; i<ctx.exp().size();i++){
            Class<?> tipo = visit(ctx.exp(i));
            String nome = ctx.NOME().get(i).getText();
            if(functionExists(nome)){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine() + 1) +
                        ": The atribution of '" + nome + "' is already a function.");
            }
            else {
                if (Variaveis.containsKey(nome) || VerificarVariavelGlobalAtras(nome)) {
                    if ((Variaveis.get(nome) != null && tipo != Variaveis.get(nome).tipo()) && tipo != TipoVariavelLocal(nome)) {
                        errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) +
                                " error: Wrong type for variable " + ctx.NOME().get(i).getText());
                    }
                } else {
                    errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) +
                            " error: Variable not defined " + ctx.getText());
                }
            }
        }
        return null;
    }

    public ParseTreeProperty<Class<?>> TestTree(ParseTree tree){
        this.visit(tree);
        if(!errors.isEmpty())
            Error.printErrors(errors);
        return values;
    }
}
