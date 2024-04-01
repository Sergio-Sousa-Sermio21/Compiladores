grammar Tasm;

executable : (command)+ HALT? EOF;

command : (LABEL(','LABEL)*':')? (token)+ EOL
  ;

token : ICONST INT          #ConstInteger
    | DCONST INT            #ConstDoubleInteger
    | DCONST DOUBLE         #ConstDouble
    | SCONST STRING         #ConstString
    | integerOP             #IntegerOperation
    | doubleOP              #DoubleOperation
    | stringOP              #StringOperation
    | boolOP                #BoolOperation
    | jumpOP                #JumpOperation
    | arrayOP               #ArrayOperation
    | HALT                  #Halt
    ;

integerOP: IPRINT
    | IMINUS
    | IADD
    | ISUB
    | IMULT
    | IDIV
    | IMOD
    | IEQ
    | INEQ
    | ILT
    | ILEQ
    | ITOD
    | ITOS
    ;

doubleOP: DPRINT
    | DUMINUS
    | DADD
    | DSUB
    | DMULT
    | DDIV
    | DEQ
    | DNEQ
    | DLT
    | DLEQ
    | DTOS
    ;

stringOP: SPRINT
    | SADD
    | SEQ
    | SNEQ
    ;

boolOP: TCONST
    | FCONST
    | BPRINT
    | BEQ
    | BNEQ
    | BTOS
    | NOT
    | AND
    | OR

    ;

jumpOP: JUMP LABEL
    | JUMPT LABEL
    | JUMPF LABEL
    ;

arrayOP: GALLOC INT
    | GLOAD INT
    | GSTORE INT
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
NOT : 'not';
AND : 'and';
OR : 'or';
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

LABEL : [_A-Za-z]+[_A-Za-z0-9]*;
STRING : '"' .*? '"';
INT : [0-9]+ ;
DOUBLE : INT('.'INT)*;

EOL:'\n';
WS : [ \t\r]+ -> skip ;
