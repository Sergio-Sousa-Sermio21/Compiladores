grammar Tasm;

program:  (expression)+ HALT? EOF;

expression: (((LABEL)*':')? instruction EOL?);

instruction: ICONST INT
           | DCONST value=(INT | DOUBLE)
           | SCONST STRING
           | JUMP LABEL
           | intinstruction
           | doubleinstruction
           | strinstruction;

intinstruction: IADD | IDIV
              | IEQ  | ILEQ
              | IMOD | IMULT
              | INEQ | IPRINT
              | ISUB | ITOP
              | ITOS | IUMINUS;

doubleinstruction: DCONST | DADD
                 | DDIV   | DEQ
                 | DLEQ   | DLT
                 | DMULT  | DPRINT
                 | DSUB   | DTOS
                 | DUMINUS;
strinstruction: SADD | SEQ | SNEQ | SPRINT;

DOUBLE : INT+'.'INT+;
ICONST  : 'iconst';
IPRINT  : 'iprint';
IUMINUS : 'iuminis';
IADD : 'iadd';
SADD : 'sadd';
ISUB : 'isub';
IMULT : 'imult';
IDIV : 'idiv';
IMOD : 'imod';
IEQ : 'ieq';
INEQ : 'ineq';
ILT : 'ilt';
ILEQ : 'ileq';
ITOP : 'itop';
ITOS : 'itos';
DCONST : 'dconst';
DPRINT : 'dprint';
DUMINUS : 'duminus';
DADD : 'dadd';
DSUB : 'dsub';
DMULT : 'dmult';
DDIV : 'ddiv';
DEQ : 'deq';
DLT : 'dlt';
DLEQ : 'dleq';
DTOS : 'dtos';
SCONST : 'sconst';
SPRINT : 'sprint';
SEQ : 'seq';
SNEQ : 'sneq';
BCONST : 'bconst';
BPRINT : 'bprint';
BEQ : 'beq';
BNEQ : 'bneq';
AND : 'and';
OR : 'or';
NOT : 'not';
BTOS : 'btos';
JUMP : 'jump';
JUMPT : 'jumpt';
JUMPF : 'jumpf';
GALLOC : 'galloc';
GLOAD : 'gload';
GSTORE : 'gstore';
BOOLEAN: 'true' | 'false';
STRING: '"'.*'"';
INT : [0-9]+;
REAL_CONST : INT '.' INT;
UNSIGNED_INT : [0-9]+;
UNSIGNED_REAL : [0-9]+ '.' [0-9]+;
CHARACTER : [a-zA-Z];
HALT: 'halt';
EOL: '\n';
LABEL: [a-zA-Z_] [a-zA-Z_0-9]* ;
WS : [ \t\r\n]+ -> skip;