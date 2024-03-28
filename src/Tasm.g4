grammar Tasm;

program:  (expression)+ | HALT? EOF;

expression: (((LABEL)+(','LABEL)*':')? instruction EOL?);

instruction: ICONST INT #INTVALUE
           | (DCONST (INT | DOUBLE)) #DOUBLEVALUE
           | SCONST STRING #STRINGVALUE
           | JUMP LABEL #JUMP
           | JUMPT LABEL #JUMPT
           | JUMPF LABEL #JUMPF
           | HALT #HALT
           | INTINSTRUCTION #INTINSTRUCTION
           | DOUBLEINSTRUCTION #DOUBLEINSTRUCTION
           | STRINGINSTRUCTION #STRINGINSTRUCTION;

INTINSTRUCTION: IADD | IDIV
              | IEQ  | ILEQ
              | IMOD | IMULT
              | INEQ | IPRINT
              | ISUB | ITOP
              | ITOS | IUMINUS
              | ILT  | ITOD;

DOUBLEINSTRUCTION: DADD  | DDIV
                 | DEQ   | DLEQ
                 | DLT   | DMULT
                 | DPRINT| DSUB
                 | DTOS  | DUMINUS
                 | DNEQ;

STRINGINSTRUCTION: SADD | SEQ | SNEQ | SPRINT;

DOUBLE: INT+ '.' INT+;
DNEQ: 'dneq';
ITOD: 'itod';
ICONST: 'iconst';
IPRINT: 'iprint';
IUMINUS: 'iuminus';
IADD: 'iadd';
SADD: 'sadd';
ISUB: 'isub';
IMULT: 'imult';
IDIV: 'idiv';
IMOD: 'imod';
IEQ: 'ieq';
INEQ: 'ineq';
ILT: 'ilt';
ILEQ: 'ileq';
ITOP: 'itop';
ITOS: 'itos';
DCONST: 'dconst';
DPRINT: 'dprint';
DUMINUS: 'duminus';
DADD: 'dadd';
DSUB: 'dsub';
DMULT: 'dmult';
DDIV: 'ddiv';
DEQ: 'deq';
DLT: 'dlt';
DLEQ: 'dleq';
DTOS: 'dtos';
SCONST: 'sconst';
SPRINT: 'sprint';
SEQ: 'seq';
SNEQ: 'sneq';
BCONST: 'bconst';
BPRINT: 'bprint';
BEQ: 'beq';
BNEQ: 'bneq';
AND: 'and';
OR: 'or';
NOT: 'not';
BTOS: 'btos';
JUMP: 'jump';
JUMPT: 'jumpt';
JUMPF: 'jumpf';
GALLOC: 'galloc';
GLOAD: 'gload';
GSTORE: 'gstore';
BOOLEAN: 'true' | 'false';
STRING: '"' .*? '"';
INT: [0-9]+;
HALT: 'halt';
EOL: '\n';
LABEL: [a-zA-Z_] [a-zA-Z_0-9]*;
WS: [ \t\r\n]+ -> skip;