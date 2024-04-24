grammar Sol;

program: (instrucao)* EOF;


instrucao: print
            | bloco
            | whileState
            | forState
            | ifState
            | empty
            | break
            | tiposNoCodigo ';'
            | NOME '=' exp;

print: 'print' exp ';';

whileState: 'while' exp 'do' instrucao;

forState: 'for' NOME '=' INT 'to' (INT|NOME) 'do' instrucao;

ifState: IF exp THEN instrucao (ELSE instrucao)?;

IF:'if';
THEN:'then';
ELSE:'else';
empty: ';';

break: 'break' ';';

tiposNoCodigo: types declaracao (','declaracao)*;

types: 'int' #INTT
| 'double' #DOUBLET
| 'boolean' #BOLEANT
| 'string' #STRINGT;

declaracao: NOME ('='variaveis)?;

bloco: 'begin' (instrucao | tiposNoCodigo ';')* 'end';

exp: '(' exp ')' #ORDER
     | op=(NOT|SUB) exp #NEGACION
     | exp op=(MULT|DIV|RESTDIV) exp #MULTDIV
     | exp op=(ADD|SUB) exp #ADDSUB
     | exp op=(MINOR|GREATER|MINOREQUAL|GREATEREQUAL) exp #LOGICALOPERATOR
     | exp op=(EQUAL|NOTEQUAL) exp #LOGICALOPERATOREQUALNOT
     | exp AND exp #AND
     | exp OR exp #OR
     | variaveis #Va;

variaveis: INT #INT
           | DOUBLE #DOUBLE
           | TRUE #TRUE
           | FALSE #FALSE
           | STRING #STRING
           | NOME #NOME;

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
