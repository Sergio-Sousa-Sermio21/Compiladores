import Tasm.TasmParser;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
public class Instruction {
    private final TokenTasm token1;
    private Integer token2;

    /**
     * Constructor to initialize Instruction with a String token and an Integer value
     * @param t the string token
     * @param value the integer value
     */
    Instruction(String t, Integer value){
        token1 = TokenTasm.valueOf(t);
        token2 = value;
    }

    /**
     * Constructor to initialize Instruction with a TokenTasm token and an Integer value
     * @param t the TokenTasm token
     * @param value the integer value
     */
    Instruction(TokenTasm t, Integer value){
        token1 = t;
        token2 = value;
    }

    /**
     * Getter for token1
     * @return the token1 value
     */
    public TokenTasm getToken1() {
        return token1;
    }

    /**
     * Getter for token2
     * @return the token2 value
     */
    public Integer getToken2() {
        return token2;
    }

    /**
     * Setter for token2
     * @param token2 the token2 value to set
     */
    public void setToken2(Integer token2) {
        this.token2 = token2;
    }

    /**
     * Method to get the bytes representing the instruction
     * @return an array of integers representing the instruction bytes
     */
    public Integer[] getBytes() {
        return token2 != null?new Integer[] {token1.getValue(), token2}:new Integer[] {token1.getValue()};
    }

    @Override
    public String toString() {
        return token1+": "+token2;
    }
}
