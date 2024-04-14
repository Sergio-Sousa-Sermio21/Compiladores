grammar Tasm;

executable : (command)+ HALT? EOF;

command : PRINT (op)+ ';'+ EOL?
  ;

op: negate
 | LPARENTHESIS op RPARENTHESIS
 | mult
 | div
 | mod
 | add
 | sub
 ;
// TODO falta operadores lógicos
negate: '-'op;

add: INT '+' INT #AdditionInt
  | INT '+' DOUBLE #AdditionIntDouble
  | DOUBLE '+' INT #AdditionDoubleInt
  | DOUBLE '+' DOUBLE #AdditionDouble
  | STRING '+' STRING #Concatenation
  | bool '+' STRING #ConcatenationBool
  ;

sub: INT '-' INT #SubInt
       | INT '-' DOUBLE #SubIntDouble
       | DOUBLE '-' INT #SubDoubleInt
       | DOUBLE '-' DOUBLE #SubDouble
  ;

mult: INT '+' INT #MultInt
       | INT '+' DOUBLE #MultIntDouble
       | DOUBLE '+' INT #MultDoubleInt
       | DOUBLE '+' DOUBLE #MultDouble
   ;

div: INT '/' INT #DivInt
       | INT '/' DOUBLE #DivIntDouble
       | DOUBLE '/' INT #DivDoubleInt
       | DOUBLE '/' DOUBLE #DivDouble
   ;

mod: INT '%' INT
   ;



bool: TRUE
 | FALSE
 ;

SL_COMMENT : '//' .*? (EOF|'\n') -> skip;
ML_COMMENT : '/*' .*? '*/' -> skip ;

TRUE: 'true';
FALSE: 'false';

PRINT: 'print';
LPARENTHESIS: '(';
RPARENTHESIS: ')';
LABEL : [_A-Za-z]+[_A-Za-z0-9]*;
STRING : '"' .*? '"';
INT : [0-9]+ ;
DOUBLE : INT('.'INT)*;

EOL:'\n';
WS : [ \t\r]+ -> skip ;
