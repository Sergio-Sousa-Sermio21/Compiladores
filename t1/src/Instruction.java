import Tasm.TasmParser;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
public class Instruction {
    private TokenTasm token1;
    private Integer token2;
    Instruction(String t, Integer value){
        token1 = TokenTasm.valueOf(t);
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

    public byte[] getBytes() {
        return token2 != null?new byte[] {(byte)token1.ordinal(), token2.byteValue()}:new byte[] {(byte)token1.ordinal()};
    }

}
