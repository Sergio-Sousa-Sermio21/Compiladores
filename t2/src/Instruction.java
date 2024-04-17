import Sol.SolParser;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
public class Instruction {
    private final TokenTasm op;
    private Integer argument;

    /**
     * Constructor to initialize Instruction with a String token and an Integer value
     * @param t the string token
     * @param value the integer value
     */
    Instruction(String t, Integer value){
        op = TokenTasm.valueOf(t);
        argument = value;
    }

    Instruction(TokenTasm t){
        op = t;
        argument = null;
    }

    /**
     * Constructor to initialize Instruction with a TokenTasm token and an Integer value
     * @param t the TokenTasm token
     * @param value the integer value
     */
    Instruction(TokenTasm t, Integer value){
        op = t;
        argument = value;
    }

    /**
     * Getter for op
     * @return the op value
     */
    public TokenTasm getOp() {
        return op;
    }

    /**
     * Getter for argument
     * @return the argument value
     */
    public Integer getArgument() {
        return argument;
    }

    /**
     * Setter for argument
     * @param argument the argument value to set
     */
    public void setArgument(Integer argument) {
        this.argument = argument;
    }

    /**
     * Method to get the bytes representing the instruction
     * @return an array of integers representing the instruction bytes
     */
    public Integer[] getBytes() {
        return argument != null?new Integer[] {op.ordinal(), argument}:new Integer[] {op.ordinal()};
    }

    @Override
    public String toString() {
        return op+": "+argument;
    }
}
