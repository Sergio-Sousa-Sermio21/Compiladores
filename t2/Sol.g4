grammar Sol;

executable : (command)+  EOF;

command : PRINT (op)+ ';'
  ;

op: LPARENTHESIS op RPARENTHESIS #Parenthesis
 | negate #Negation
 | op MULT op #Multiplication //check type
 | op DIV op #Division//check type
 | op MOD op #Module//check type
 | op ADD op #Addition //check type
 | op SUB op #Subctraction
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

rel: type LT type #Lt //check type
 | type MT type #Mt //check type
 | type LTE type #Lt //check type
 | type MTE type #Mt //check type
 | type EQUAL type #Equal //check type
 | type NEQUAL type #NotEqual //check type
 | type AND type #And //check type
 | type OR type #Or //check type
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