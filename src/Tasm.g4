grammar Tasm;

program:  (expression)+ EOF;

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


ICONST: 'iconst';
//Comandos de inteiros
IUMINUS: 'iuminus';IADD: 'iadd'; ISUB: 'isub';IMULT: 'imult';IDIV: 'idiv';IMOD: 'imod';
IEQ: 'ieq';INEQ: 'ineq';ILT: 'ilt';ILEQ: 'ileq';ITOP: 'itop';ITOS: 'itos';ITOD: 'itod';IPRINT: 'iprint';
DCONST: 'dconst';
//Comandos de Doubles
DUMINUS: 'duminus';DADD: 'dadd';DSUB: 'dsub';DMULT: 'dmult';DDIV: 'ddiv';DEQ: 'deq';
DLT: 'dlt';DLEQ: 'dleq';DTOS: 'dtos';DNEQ: 'dneq';DPRINT: 'dprint';
SCONST: 'sconst';
//Comandos de String
SPRINT: 'sprint';SADD: 'sadd';SEQ: 'seq';SNEQ: 'sneq';
BCONST: 'bconst';
BPRINT: 'bprint';
BEQ: 'beq';
BNEQ: 'bneq';
AND: 'and';
OR: 'or';
NOT: 'not';
BTOS: 'btos';
//Comandos de Jump
JUMP: 'jump';JUMPT: 'jumpt';JUMPF: 'jumpf';
GALLOC: 'galloc';
GLOAD: 'gload';
GSTORE: 'gstore';
BOOLEAN: 'true' | 'false';
HALT: 'halt';
STRING: '"' .*? '"';
DOUBLE: INT+ '.' INT+;
INT: [0-9]+;
EOL: '\n';
LABEL: [a-zA-Z_] [a-zA-Z_0-9]*;
WS: [ \t\r\n]+ -> skip;