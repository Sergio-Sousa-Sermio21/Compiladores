public class TesteSemantico {

    public String invalidOperator(int line, Object operator) {
        return ("error in line " + line + ": invalid attribute " + operator + ".\n");
    }

    public String invalidTwoOperators(int line, Object firstOperator, Object secondOperator, boolean firstOrSecond, boolean firstAndSecond){
        return firstOrSecond? firstAndSecond ?
                ("errors in line " + line + ": invalid attribute " + firstOperator + " and invalid attribute " + secondOperator+".\n")
                :invalidOperator(line, firstOperator):invalidOperator(line, secondOperator);
    }

    public String invalidComparison(int line, Object firstOperator, Object secondOperator){
        return "error in line "+line+": invalid comparison between operators "+firstOperator
                +" and invalid attribute "+ secondOperator+ ".\n";
    }

    public String invalidVariable(int line, Object var){
        return "error in line "+line+": invalid variable, "+var+" is not defined." ;
    }

    public String invalidType(int line, Object var, String type){
        return "error in line "+line+": invalid type "+var.getClass().getSimpleName()+", should be "+ type +"." ;
    }

    public String invalidPrintType(int line){
        return "error in line "+line+": invalid Void type.";
    }

    public String invalidType(int line, String var, String type){
        return "error in line "+line+": invalid type "+var+", should be "+ type +"." ;
    }

    public String invalidTypeArgs(int line, String var, String varType, String type){
        return "error in line "+line+": invalid variable "+var+" of type "+varType+", should be "+ type +" which is defined by the function argument." ;
    }

    public String invalidNumArgsLess(int line, int argSize, int opSize){
        return "error in line "+line+": less number of expressions than expected, which is "+opSize+" and should be "+argSize+".";
    }

    public String invalidNumArgsMore(int line, int argSize, int opSize){
        return "error in line "+line+": more number of expressions than expected, which is "+opSize+" and should be "+argSize+".";
    }

    public String invalidBreak(int line){
        return "error in line "+line+": incorrect use of the break command, not inside a loop.";
    }

    public String alreadyDefined(int line, String var){
        return "error in line "+line+": "+var+" is already defined.";
    }

    public String notInitialized(int line, String var){
        return "error in line "+line+": "+var+" is not initialized.";
    }

    public String invalidVariableFunction(int line, String var){
        return "error in line "+line+": "+var+" is already a function name.";
    }

    public String invalidReturn(int line){
        return "error in line "+line+": incorrect 'return' command usage, not inside a function.";}

    public String invalidIfReturn(int line){
        return "error in line "+line+": return should be in both if and else blocks.";
    }

    public String noReturn(int line, String var){
        return "error in line "+line+": function "+var+" has no return.";
    }

    public String invalidReturnType(int line, String var, String type){
        return "error in line "+line+": incorrect return type for '"+var+"' should be "+type+" type.";
    }

    public String invalidReturnType(int line, String var, String varType, String type){
        return "error in line "+line+": incorrect return type for '"+var+"' of type "+varType+" should be "+type+" type.";
    }

    public String invalidCall(int line, String var){
        return "error in line "+line+": invalid function call, '"+ var+"' function does not exist.";
    }

    public  String invalidFunction(int line){
        return "error in line "+line+": invalid function declaration, already inside a function.";
    }

    public String alreadyDefinedFunction(int line, String var){
        return "error in line " +line+": function "+var+" already defined.";
    }

    public String invalidMainFunctionType(int line){
        return "error in line " +line+": function main should be void.";
    }

    public String noMainFunction(){
        return "There is no main function in the program.";
    }
}
