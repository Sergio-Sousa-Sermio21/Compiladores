grammar Tasm;

program:  expression (EOL+ expression)* EOL* EOF;

expression: (((LABEL)(','LABEL)*':')? instruction);

instruction: ICONST INT #INTVALUE
           | (DCONST (INT | DOUBLE)) #DOUBLEVALUE
           | SCONST STRING #STRINGVALUE
           | JUMP LABEL #JUMP
           | JUMPT LABEL #JUMPT
           | JUMPF LABEL #JUMPF
           | GALLOC INT #GALLOC
           | GLOAD INT #GLOAD
           | GSTORE INT #GSTORE
           | HALT #HALT
           | LALLOC INT #LALLOC
           | LLOAD (NEGATIVE|INT) #LLOAD
           | LSTORE (NEGATIVE|INT) #LSTORE
           | POP INT #POP
           | CALL LABEL #CALL
           | RETVAL INT #RETVAL
           | RET INT #RET
           | intinstruction #InstrucaoInt
           | doubleinstruction #InstrucaoDouble
           | stringinstruction #InstrucaoString
           | booleaninstruction #InstrucaoBoolean;

//Regra para as instrucoes de int
intinstruction: IADD    | IDIV
              | IEQ     | ILEQ
              | IMOD    | IMULT
              | INEQ    | IPRINT
              | ISUB    | ITOS
              | IUMINUS | ILT
              | ITOD;

//Regra para as instrucoes de double
doubleinstruction: DADD  | DDIV
                 | DEQ   | DLEQ
                 | DLT   | DMULT
                 | DPRINT| DSUB
                 | DTOS  | DUMINUS
                 | DNEQ;

//Regra para as instrucoes de string
stringinstruction: SADD | SEQ | SNEQ | SPRINT;

//Regra para as instrucoes de booleans
booleaninstruction: BPRINT | BEQ | BNEQ | AND | OR | NOT | BTOS | TCONST | FCONST;

// Comandos de inteiros
ICONST: 'iconst';
IUMINUS: 'iuminus';
IADD: 'iadd';
ISUB: 'isub';
IMULT: 'imult';
IDIV: 'idiv';
IMOD: 'imod';
IEQ: 'ieq';
INEQ: 'ineq';
ILT: 'ilt';
ILEQ: 'ileq';
ITOS: 'itos';
ITOD: 'itod';
IPRINT: 'iprint';

// Comandos de Doubles
DCONST: 'dconst';
DUMINUS: 'duminus';
DADD: 'dadd';
DSUB: 'dsub';
DMULT: 'dmult';
DDIV: 'ddiv';
DEQ: 'deq';
DLT: 'dlt';
DLEQ: 'dleq';
DTOS: 'dtos';
DNEQ: 'dneq';
DPRINT: 'dprint';

// Comandos de String
SCONST: 'sconst';
SPRINT: 'sprint';
SADD: 'sadd';
SEQ: 'seq';
SNEQ: 'sneq';

// Comandos de Booleanos
BPRINT: 'bprint';
BEQ: 'beq';
BNEQ: 'bneq';
AND: 'and';
OR: 'or';
NOT: 'not';
BTOS: 'btos';
TCONST: 'tconst';
FCONST: 'fconst';

// Comandos de Jump
JUMP: 'jump';
JUMPT: 'jumpt';
JUMPF: 'jumpf';
CALL: 'call';

// Comandos de Load
GALLOC: 'galloc';
GLOAD: 'gload';
GSTORE: 'gstore';
LALLOC: 'lalloc';
LLOAD: 'lload';
LSTORE: 'lstore';

//Commandos de return
RETVAL: 'retval';
RET: 'ret';

// Outros comandos e tokens
POP: 'pop';
HALT: 'halt';
STRING: '"' ( ESC_SEQ | ~[\\"\r\n] )* '"';
fragment ESC_SEQ : '\\' . ;
DOUBLE: INT+ '.' INT+;
INT: [0-9]+;
NEGATIVE: '-' INT;
EOL: '\n';
LABEL: [a-zA-Z_] [a-zA-Z_0-9-]*;
WS: [ \t\r]+ -> skip;
