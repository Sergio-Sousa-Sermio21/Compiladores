import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerifyNodes extends SolBaseVisitor<Class<?>> {

    private HashMap<String, Class<?>> tiposVariaveis = new HashMap<String, Class<?>>();
    private final ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();

    private final ArrayList<String> errors = new ArrayList<>();
    private boolean insideLoop = false;
    private boolean breakFound = false;
    public Class<?> visitProgram(SolParser.ProgramContext ctx) {
        visitChildren(ctx);
        System.out.println("Halt");
        return null;
    }


    //EXP---------------------------------------------------------------------------------
    @Override
    public Class<?>  visitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx) {
        Class<?> left = visit(ctx.exp(0));
        Class<?> right = visit(ctx.exp(1));
        if(left == Object.class || right == Object.class)
            return Object.class;
        else{
            if(left!=right && !((left == Integer.class && right == Double.class) || (left == Double.class && right == Integer.class))){
                errors.add("Line" + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Cannot compare " + left.getSimpleName() + " and " + right.getSimpleName());
                return Object.class;
            } else
                return Boolean.class;
        }
    }
    @Override
    public Class<?> visitORDER(SolParser.ORDERContext ctx) {
        return visit(ctx.exp());
    }
    @Override
    public Class<?> visitNEGACION(SolParser.NEGACIONContext ctx) {
        Class<?> tipo = visit(ctx.exp());
        return tipo;
    }

    @Override
    public Class<?> visitADDSUB(SolParser.ADDSUBContext ctx) {
        Class<?> left = visit(ctx.exp(0));
        Class<?> rigth = visit(ctx.exp(1));
        if(ctx.op.getText().equals("+")){
            if(left == Object.class || rigth == Object.class)
               return Object.class;
            else
            if((left == Boolean.class && rigth != String.class) || (left != String.class && rigth == Boolean.class)){
                errors.add("Line" + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: The operator " + ctx.op.getText() + " isn't valid between " + left.getSimpleName() + " and " + rigth.getSimpleName());
                return Object.class;
            } else {
                if(left == String.class || rigth == String.class)
                    return  String.class;
                else if(left == Double.class || rigth ==  Double.class )
                    return Double.class;
                else
                    return Integer.class;
            }
        } else {
            if(left == Object.class || rigth == Object.class)
                return Object.class;
            else {
                if((left == Boolean.class || rigth == Boolean.class) || (left == String.class || rigth == String.class)){
                    errors.add("Line" + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: The operator " + ctx.op.getText() + " isn't valid between " + left.getSimpleName() + " and " + rigth.getSimpleName());
                    return Object.class;
                } else {
                    if(left == Double.class || rigth ==  Double.class )
                        return Double.class;
                    else
                        return Integer.class;
                }
            }
        }
    }

    @Override
    public Class<?>  visitMULTDIV(SolParser.MULTDIVContext ctx) {
        Class<?> left = visit(ctx.exp(0));
        Class<?> rigth = visit(ctx.exp(1));
        if(left == Object.class || rigth == Object.class)
            return Object.class;
        else {
            if(ctx.op.getText().equals("%") && (left != Integer.class || rigth!= Integer.class)){
                errors.add("Line" + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Error in operator % cannot use " + left.getSimpleName() + " and " + rigth.getSimpleName());
                return Object.class;
            }
            else if(left == String.class || rigth == String.class){
                errors.add("Line" + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Type String is not allowed in " + ctx.op.getText());
                return Object.class;
            }
            else if(left == Boolean.class || rigth == Boolean.class){
                errors.add("Line" + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Type Boolean is not allowed in " + ctx.op.getText());
                return Object.class;
            }
            else if(left == Double.class || rigth == Double.class)
                return Double.class;
            else
                return Integer.class;
        }
    }

    @Override
    public Class<?> visitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx) {
        Class<?> left = visit(ctx.exp(0));
        Class<?> right = visit(ctx.exp(1));
        if(left == Object.class || right == Object.class)
            return  Object.class;
        else{
            if(left == String.class || right == String.class || left == Boolean.class || right == Boolean.class){
                errors.add("Line" + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Can not compare " + left.getSimpleName() + " and " + right.getSimpleName()  +" in " + ctx.op.getText());
                return Object.class;
            } else{
                return Boolean.class;
            }
        }
    }

    //EXP---------------------------------------------------------------------------------
    @Override
    public Class<?>  visitInstrucao(SolParser.InstrucaoContext ctx) {
        visitChildren(ctx);
        return null;
    }
    @Override
    public Class<?>  visitPrint(SolParser.PrintContext ctx) {
        visitChildren(ctx);
        System.out.println("Print: " + ctx.getText());
        return null;
    }
    @Override
    public Class<?>  visitWhileState(SolParser.WhileStateContext ctx) {
        insideLoop = true;
        breakFound = false;
        Class<?> conditionType = visit(ctx.exp());
        if (!conditionType.equals(Boolean.class))
            errors.add("line " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine()+1 +
                    " error: While expression must be of type bool");

        if (ctx.instrucao()!=null)
            visit(ctx.instrucao());
        else
            visit(ctx.bloco());
        insideLoop = false;
        return null;
    }
    @Override
    public Class<?>  visitForState(SolParser.ForStateContext ctx) {
        insideLoop = true;
        breakFound = false;
        Class<?> conditionType = visit(ctx.exp(0));
        Class<?> target = visit(ctx.exp(0));
        if (!(target == Object.class || conditionType == Object.class ) && (!conditionType.equals(Integer.class) || target != Integer.class))
            errors.add("line " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine()+1 +
                    " error: While expression must be of type bool");
        System.out.println("FOR: " + ctx.getText());
        visitChildren(ctx);
        insideLoop = true;
        return null;
    }
    @Override
    public Class<?>  visitIfState(SolParser.IfStateContext ctx) {
        visit(ctx.exp());
        System.out.println("IF: " + ctx.getText());
        for(int i =0; i<ctx.instrucao().size(); i++)
            visit(ctx.instrucao().get(i));
        return null;
    }

    public Class<?>  visitEmpty(SolParser.EmptyContext ctx) {
        System.out.println("EMPTY: " + ctx.getText());
        return null;
    }
    @Override
    public Class<?> visitBreak(SolParser.BreakContext ctx) {
        System.out.println("BREAK: " + ctx.getText());
        if (!insideLoop) {
            errors.add("line " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() +
                    " error: Break statement can only occur inside a loop");
        } else if (breakFound) {
            errors.add("line " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() +
                    " error: Break statement can only occur once inside a loop");
        } else
            breakFound = true;
        return null;
    }

    @Override
    public Class<?>  visitBloco(SolParser.BlocoContext ctx) {
        System.out.println("Bloco: " + ctx.getText());
        visitChildren(ctx);
        System.out.println("Bloco: " + ctx.getText());
        return null;
    }
    @Override
    public Class<?>  visitOR(SolParser.ORContext ctx) {
        System.out.println("OR: " + ctx.getText());
        return null;
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
                errors.add("line " + ctx.declaracao().get(i).getStart().getLine() + ":" +
                        ctx.declaracao().get(i).getStart().getCharPositionInLine() +
                        " error: " + verificar + " type mismatch");
            }
            if(tiposVariaveis.containsKey(ctx.declaracao().get(i).NOME().getText())){
                errors.add("Line" + ctx.start.getLine() + ":" + (ctx.start.getCharPositionInLine()+1) + " error: Variable already defined " + ctx.declaracao().get(i).NOME().getText());
            }
            else
                tiposVariaveis.put(ctx.declaracao().get(i).NOME().getText(), tipo);
        }
        return tipo;
    }

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
    //Types-------------------------------------------------------------------------------------------

    //Variveis----------------------------------------------------------------------------------------
    @Override
    public Class<?>  visitINT(SolParser.INTContext ctx) {
        return Integer.class;
    }
    @Override
    public Class<?>  visitDOUBLE(SolParser.DOUBLEContext ctx) {
        return Double.class;
    }

    @Override
    public Class<?> visitTRUE(SolParser.TRUEContext ctx) {
        return Boolean.class;
    }

    @Override
    public Class<?> visitFALSE(SolParser.FALSEContext ctx) {
        return Boolean.class;
    }

    @Override
    public Class<?>  visitSTRING(SolParser.STRINGContext ctx) {
        return System.class;
    }

    @Override
    public Class<?>  visitNOME(SolParser.NOMEContext ctx) {
        if(!tiposVariaveis.containsKey(ctx.NOME().getText())){
            System.err.println("line" + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() +
                            " error: Variavel nao defenida " + ctx.getText());
            return Object.class;
        }
        return tiposVariaveis.get(ctx.NOME().getText());
    }
    //Variveis----------------------------------------------------------------------------------------

    @Override public Class<?>  visitDeclarar(SolParser.DeclararContext ctx) {
        for(int i = 0; i<ctx.exp().size();i++){
            Class<?> tipo = visit(ctx.exp().get(i));
            if(tiposVariaveis.containsKey(ctx.NOME().get(i).getText())){
                if(tipo!=tiposVariaveis.get(ctx.NOME().get(i).getText())) {
                    System.err.println("Tipo errado" + " " + tipo.getSimpleName() + " hash " + tiposVariaveis.get(ctx.NOME().get(i).getText()));
                    errors.add("line " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() +
                            " error: Tipo errado para a variavel " + ctx.NOME().get(i).getText());
                }

            }
        }
        System.out.println("Declarar-" + ctx.getText());
        return null;
    }

    public ParseTreeProperty<Class<?>> TestTree(ParseTree tree){
        this.visit(tree);
        if(!errors.isEmpty())
            Error.printErrors(errors);
        return values;
    }
}
