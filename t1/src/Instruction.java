import Tasm.TasmParser;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
public class Instruction {
    private final TokenTasm token1;
    private Integer token2;
    Instruction(String t, Integer value){
        token1 = TokenTasm.valueOf(t);
        token2 = value;
    }
    Instruction(TokenTasm t, Integer value){
        token1 = t;
        token2 = value;
    }

    public TokenTasm getToken1() {
        return token1;
    }

    public Integer getToken2() {
        return token2;
    }

    public void setToken2(Integer token2) {
        this.token2 = token2;
    }

    public Integer[] getBytes() {
        return token2 != null?new Integer[] {token1.getValue(), token2}:new Integer[] {token1.getValue()};
    }

}
