grammar Sol;

program: (instrucao | types';')* EOF;

instrucao: 'print' exp ';';

types: 'int' declaracao+ #INTD
| 'double' declaracao+#DOUBLED
| 'boolean' declaracao+#TRUED
| 'boolean'declaracao+#FALSED
| 'string' declaracao+ #STRINGD
|declaracao #VIRGULA;

declaracao: NOME ('=' INT)?
            | NOME ('=' DOUBLE)?
            | NOME ('=' TRUE)?
            | NOME ('=' FALSE)?
            | NOME ('=' STRING)?
            | ',' declaracao;

exp: '(' exp ')' #ORDER
     | op=(NOT|SUB) exp #NEGACION
     | exp op=(MULT|DIV|RESTDIV) exp #MULTDIV
     | exp op=(ADD|SUB) exp #ADDSUB
     | exp op=(MINOR|GREATER|MINOREQUAL|GREATEREQUAL) exp #LOGICALOPERATOR
     | exp op=(EQUAL|NOTEQUAL) exp #LOGICALOPERATOREQUALNOT
     | exp AND exp #AND
     | exp OR exp #OR
     | INT #INT
     | DOUBLE #DOUBLE
     | TRUE #TRUE
     | FALSE #FALSE
     | STRING #STRING
     ;

NOTEQUAL: '!=';
EQUAL: '==';
GREATEREQUAL: '>=';
MINOREQUAL: '<=';
GREATER: '>';
MINOR: '<';
SUB: '-';
ADD: '+';
RESTDIV: '%';
DIV: '/';
MULT: '*';
NOT: 'not';
OR: 'or';
AND: 'and';
FALSE: 'false';
TRUE: 'true';
INT: [0-9]+;
DOUBLE: INT+ '.' INT+;
STRING: '"' ( ESC_SEQ | ~[\\"\r\n] )* '"';
NOME: [a-zA-Z_] [a-zA-Z_0-9-]*;
fragment ESC_SEQ : '\\' . ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment
WS: [ \t\r\n]+ -> skip;
