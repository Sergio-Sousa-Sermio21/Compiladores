grammar Tasm;

executable : (token)+ ;

token : e MULT e 		# Mult
  | e ADD e 		# Add
  | INT        		# Int
  ;

command :

MULT: '*' ;
ADD : '+' ;
INT : [0-9]+ ;
WS : [ \t\n]+ -> skip ;
