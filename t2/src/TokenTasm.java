import java.util.HashMap;

/**
 * Enum with all the available instructions for a tasm program
 */
public enum TokenTasm {
    ICONST(0),
    DCONST(1),
    SCONST(2),
    IPRINT(3),
    IUMINUS(4),
    IADD(5),
    ISUB(6),
    IMULT(7),
    IDIV(8),
    IMOD(9),
    IEQ(10),
    INEQ(11),
    ILT(12),
    ILEQ(13),
    ITOD(14),
    ITOS(15),
    DPRINT(16),
    DUMINUS(17),
    DADD(18),
    DSUB(19),
    DMULT(20),
    DDIV(21),
    DEQ(22),
    DNEQ(23),
    DLT(24),
    DLEQ(25),
    DTOS(26),
    SPRINT(27),
    SADD(28),
    SEQ(29),
    SNEQ(30),
    TCONST(31),
    FCONST(32),
    BPRINT(33),
    BEQ(34),
    BNEQ(35),
    BTOS(36),
    NOT(37),
    AND(38),
    OR(39),
    JUMP(40),
    JUMPT(41),
    JUMPF(42),
    GALLOC(43),
    GLOAD(44),
    GSTORE(45),
    HALT(46),
    LABEL(47),
    INT(48),
    DOUBLE(49),
    STRING(50),
    CONSTANTPOOL(51);

    private final int value;
    private static HashMap<Integer,TokenTasm> map = new HashMap<Integer,TokenTasm>();

    private TokenTasm(int value) {
        this.value = value;
    }

    static {
        for (TokenTasm tokenTasm : TokenTasm.values()) {
            map.put(tokenTasm.value, tokenTasm);
        }
    }

    /**
     * Convert int to value of Enum
     */
    public static TokenTasm valueOf(int tokenTasm) {
        return (TokenTasm) map.get(tokenTasm);
    }

    /**
     *  Getter for Enum value
     */
    public Integer getValue() {
        return value;
    }
}
