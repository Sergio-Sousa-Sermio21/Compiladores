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

    public String invalidType(int line, String var, String type){
        return "error in line "+line+": invalid type "+var+", should be "+ type +"." ;
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
}
