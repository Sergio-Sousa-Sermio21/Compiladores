grammar Tasm;

executable : (command)+ HALT? EOF;

command :
  ;

token :
    ;

ICONST : 'iconst';
DCONST : 'dconst';
SCONST : 'sconst';
JUMP : 'jump';
JUMPT : 'jumpt';
JUMPF : 'jumpf';
GALLOC : 'galloc';
GLOAD : 'gload';
GSTORE : 'gstore';

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
HALT : 'halt';

STRING : ;
DOUBLE : INT'.'INT;
INT : [0-9]+ ;
WS : [ \t\n]+ -> skip ;
