grammar Sol;

executable : (command)+  EOF;

command : PRINT (op)+ ';'
  ;

op: LPARENTHESIS op RPARENTHESIS #Parenthesis
 | negate #Negation
 | op multdivmodOp=(MULT|DIV|MOD) op #MultDivMod
 | op addsubOP=(ADD|SUB) op #AddSub
 | rel #Relations
 | type #Types
 ;

type
 : INT
 | DOUBLE
 | STRING
 | TRUE
 | FALSE
 ;

negate: SUB op
 | NOT op
 ;

rel: type compareMoreOp=(LT|MT|LTE|MTE) type #CompareMore //check type
 | type compareOP=(EQUAL|NEQUAL) type #Compare //check type
 | type AND type #And
 | type OR type #Or
 ;

SL_COMMENT : '//' .*? (EOF|'\n') -> skip;
ML_COMMENT : '/*' .*? '*/' -> skip ;

LPARENTHESIS: '(';
RPARENTHESIS: ')';
NOT: 'not';

TRUE: 'true';
FALSE: 'false';

LT: '<';
MT: '>';
LTE: '<=';
MTE: '>=';
EQUAL: '==';
NEQUAL: '!=';

AND: 'and';
OR: 'or';
MULT: '*';
DIV: '/';
MOD: '%';
ADD: '+';
SUB: '-';

PRINT: 'print';

LABEL : [_A-Za-z]+[_A-Za-z0-9]*;
STRING : '"' .*? '"';
INT : [0-9]+ ;
DOUBLE : INT('.'INT)*;

WS : [ \n\t\r]+ -> skip ;