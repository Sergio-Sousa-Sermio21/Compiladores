public class TesteSemantico {
    public String invalidOperator(int line, Object firstOperator, Object secondOperator, boolean firstOrSecond, boolean firstAndSecond){
        return firstOrSecond? firstAndSecond ?
                ("errors in line " + line + ": invalid attribute " + firstOperator + " and invalid attribute " + secondOperator+".\n")
                :("error in line " + line + ": invalid attribute " + firstOperator + ".\n")
                : ("error in line " + line + ": invalid attribute " + secondOperator + ".\n");
    }
}
