import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class VerifyNodes extends SolBaseVisitor<Class<?>> {

    private final HashMap<String, Class<?>> tiposVariaveis = new HashMap<>();
    private final ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();

    private final ArrayList<String> errors = new ArrayList<>();
    private int loopCount = 0;



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
        if(tiposVariaveis.containsKey(ctx.NOME().getText())){
            variavel = tiposVariaveis.get(ctx.NOME().getText());
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
        
        visitChildren(ctx);
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

    @Override public Class<?>  visitTiposNoCodigo(SolParser.TiposNoCodigoContext ctx) {
        
        Class<?> tipo = visit(ctx.types());
        for(int i = 0; i<ctx.declaracao().size(); i++){
            Class<?> verificar = visit(ctx.declaracao().get(i));
            if(verificar != Object.class && verificar != tipo && !(tipo==Double.class && verificar == Integer.class)) {
                errors.add("Line " + ctx.declaracao().get(i).getStart().getLine() + ":" +
                        (ctx.declaracao().get(i).getStart().getCharPositionInLine() +1)+
                        " error: " + verificar.getSimpleName() + " type mismatch on " + ctx.declaracao().get(i).NOME().getText());
            }
            if(tiposVariaveis.containsKey(ctx.declaracao().get(i).NOME().getText())){
                errors.add("Line " + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Variable already defined " + ctx.declaracao().get(i).NOME().getText());
            }
            else
                tiposVariaveis.put(ctx.declaracao().get(i).NOME().getText(), tipo);
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
        if(!tiposVariaveis.containsKey(ctx.NOME().getText())){
            errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) +
                    " error: Variable not defined " + ctx.getText());
            setValues(ctx, Object.class);
            return Object.class;
        }
        setValues(ctx, tiposVariaveis.get(ctx.NOME().getText()));
        return tiposVariaveis.get(ctx.NOME().getText());
    }

    //Variveis----------------------------------------------------------------------------------------

    @Override public Class<?>  visitDeclarar(SolParser.DeclararContext ctx) {
        
        for(int i = 0; i<ctx.exp().size();i++){
            Class<?> tipo = visit(ctx.exp(i));
            if(tiposVariaveis.containsKey(ctx.NOME().get(i).getText())){
                if(tipo!=tiposVariaveis.get(ctx.NOME().get(i).getText())) {
                    errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) +
                            " error: Wrong type for variable " + ctx.NOME().get(i).getText());
                }

            } else {
                errors.add("Line " + ctx.getStart().getLine() + ":" + (ctx.getStart().getCharPositionInLine() + 1) +
                        " error: Variable not defined " + ctx.getText());
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
