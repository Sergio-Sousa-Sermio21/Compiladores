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
        return "error in line: "+line+": invalid comparison between operators "+firstOperator
                +" and invalid attribute "+ secondOperator+ ".\n";
    }
}
