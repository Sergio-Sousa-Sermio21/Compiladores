grammar Sol;

executable: (command | declaration ';')* EOF;

command: PRINT op';'
            | block
            | while
            | for
            | if
            | empty
            | break
            | VAR '=' op ';';

block: 'begin' (command | declaration ';')* 'end';

declaration: declarationType declarationDef (',' declarationDef)*;

while: 'while' op 'do' command;

for: 'for' VAR '=' type 'to' type 'do' command;

if: 'if' op 'then' command else?;

else: 'else' command;

empty: ';';

break: 'break' ';';

declarationType: 'int' #IntegerType
    |'double' #DoubleType
    | 'string' #StringType
    | 'boolean' #BooleanType
    ;

declarationDef: VAR ('=' op)?;

op: LPARENTHESIS op RPARENTHESIS #Parenthesis
 | negate #Negation
 | op multdivmodOp=(MULT|DIV|MOD) op #MultDivMod
 | op addsubOP=(ADD|SUB) op #AddSub
 | op compareMoreOp=(LT|MT|LTE|MTE) op #CompareMore
 | op compareOP=(EQUAL|NEQUAL) op #Compare
 | op AND op #And
 | op OR op #Or
 | type #Types
 | VAR #Variable
 ;

type: INT
 | DOUBLE
 | STRING
 | TRUE
 | FALSE
 ;

negate: SUB op
 | NOT op
 ;

SL_COMMENT : '//' .*? (EOF|'\n') -> skip; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment

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

INT: [0-9]+;
DOUBLE: INT+ '.' INT+;
STRING: '"' ( ESC_SEQ | ~[\\"\r\n] )* '"';
VAR: [a-zA-Z_] [a-zA-Z_0-9-]*;

fragment ESC_SEQ : '\\' . ;
WS: [ \t\r\n]+ -> skip;
