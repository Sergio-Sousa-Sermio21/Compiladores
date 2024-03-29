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
}


import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class Instruction {
    // Example properties of an instruction
    private byte opcode;
    private byte[] operands;

    // Constructor
    public Instruction(byte opcode, byte[] operands) {
        this.opcode = opcode;
        this.operands = operands;
    }

    // Method to get the bytes of the instruction
    public byte[] getBytes() {
        byte[] bytes = new byte[operands.length + 1]; // +1 for the opcode
        bytes[0] = opcode;
        System.arraycopy(operands, 0, bytes, 1, operands.length); // Copy operands after the opcode
        return bytes;
    }
}


