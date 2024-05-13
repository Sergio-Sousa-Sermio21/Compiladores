import java.util.HashMap;

/**
 * Enum with all the available instructions for a tasm program
 */
public enum TokenTasm {
    ICONST,
    DCONST,
    SCONST,
    IPRINT,
    IUMINUS,
    IADD,
    ISUB,
    IMULT,
    IDIV,
    IMOD,
    IEQ,
    INEQ,
    ILT,
    ILEQ,
    ITOD,
    ITOS,
    DPRINT,
    DUMINUS,
    DADD,
    DSUB,
    DMULT,
    DDIV,
    DEQ,
    DNEQ,
    DLT,
    DLEQ,
    DTOS,
    SPRINT,
    SADD,
    SEQ,
    SNEQ,
    TCONST,
    FCONST,
    BPRINT,
    BEQ,
    BNEQ,
    BTOS,
    NOT,
    AND,
    OR,
    JUMP,
    JUMPT,
    JUMPF,
    GALLOC,
    GLOAD,
    GSTORE,
    HALT,
    LABEL,
    INT,
    DOUBLE,
    STRING,
    LALLOC,
    LLOAD,
    LSTORE,
    POP,
    CALL,
    RETVAL,
    RET,
    CONSTANTPOOL;
    private static HashMap<Integer,TokenTasm> map = new HashMap<Integer,TokenTasm>();

    static {
        for (TokenTasm tokenTasm : TokenTasm.values()) {
            map.put(tokenTasm.ordinal(), tokenTasm);
        }
    }

    /**
     * Convert int to value of Enum
     */
    public static TokenTasm valueOf(int tokenTasm) {
        return (TokenTasm) map.get(tokenTasm);
    }
}
