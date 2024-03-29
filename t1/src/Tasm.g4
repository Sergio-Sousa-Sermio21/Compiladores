grammar Tasm;

executable : (command)+ HALT? EOF;

command : (token)+ EOL
  ;

token : ICONST INT            # IntegerConst
    | IPRINT                # IntegerPrint
    | IMINUS INT            # IntegerMinus
    | IADD                  # IntegerAdd
    | ISUB INT              # IntegerSub
    | IMULT INT             # IntegerMult
    | IDIV INT              # IntegerDiv
    | IMOD                  # IntegerMod
    | IEQ                   # IntegerEqual
    | INEQ                  # IntegerNotEqual
    | ILT                   # IntegerLessThan
    | ILEQ                  # IntegerLessOrEqual
    | ITOD                  # IntegerToDouble
    | ITOS                  # IntegerToString
    | DCONST DOUBLE         # DoubleConst
    | DPRINT                # DoublePrint
    | DUMINUS               # DoubleMinus
    | DADD                  # DoubleAdd
    | DSUB                  # DoubleSub
    | DMULT                 # DoubleMult
    | DDIV                  # DoubleDiv
    | DEQ                   #DoubleEqual
    | DNEQ                  # DoubleNotEqual
    | DLT                   # DoubleLessThan
    | DLEQ                  # DoubleLessOrEqual
    | DTOS                  # DoubleToString
    | SCONST STRING         # String
    | SPRINT                # StringPrint
    | SADD                  # StringConcat
    | SEQ                   # StringEqual
    | SNEQ                  # StringNotEqual
    | TCONST                # True
    | FCONST                # False
    | BPRINT                # BoolPrint
    | BEQ                   # BoolEqual
    | BNEQ                  # BoolNotEqual
    | BTOS                  # BoolToString
    | JUMP LABEL            # Jump
    | JUMPT LABEL           # Jumpt
    | JUMPF LABEL           # Jumpf
    | GALLOC INT            # Galloc
    | GLOAD INT             # Gload
    | GSTORE INT            # Gstore
    | HALT                  # Halt
   ;

ICONST : 'iconst';
IPRINT : 'iprint';
IMINUS : 'iuminus';
IADD : 'iadd';
ISUB : 'isub';
IMULT : 'imult';
IDIV : 'idiv';
IMOD : 'imod';
IEQ : 'ieq';
INEQ : 'ineq';
ILT : 'ilt';
ILEQ : 'ileq';
ITOD : 'itod';
ITOS : 'itos';
DCONST : 'dconst';
DPRINT : 'dprint';
DUMINUS : 'duminus';
DADD : 'dadd';
DSUB : 'dsub';
DMULT : 'dmult';
DDIV : 'ddiv';
DEQ : 'deq';
DNEQ : 'dneq';
DLT : 'dlt';
DLEQ : 'dleq';
DTOS : 'dtos';
SCONST : 'sconst';
SPRINT : 'sprint';
SADD : 'sadd';
SEQ : 'seq';
SNEQ : 'sneq';
TCONST : 'tconst';
FCONST : 'fconst';
BPRINT : 'bprint';
BEQ : 'beq';
BNEQ : 'bneq';
BTOS : 'btos';
JUMP : 'jump';
JUMPT : 'jumpt';
JUMPF : 'jumpf';
GALLOC : 'galloc';
GLOAD : 'gload';
GSTORE : 'gstore';
HALT : 'halt';

LABEL : STRING':';
STRING : '';
DOUBLE : INT('.'INT)*;
INT : [0-9]+ ;
EOL:[\n];
WS : [ \t\n]+ -> skip ;


