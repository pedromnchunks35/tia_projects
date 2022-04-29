:- dynamic fact/2.
%operadores
:- op( 800, fx, if). 
:- op( 700, xfx, then). 
:- op( 300, xfy, or). 
:- op( 200, xfy, and).
fact(-1,-1).
fact(1,6,corno).
fact(2,7,corno).
fact(3,8,corno).
fact(4,30,manso).


cabeca(Lista,Lista_pontos):-
    !,
    question_achiever(Lista),
    iterar(Lista,[],Lista_pontos).


iterar([],Lista_Pontos,Resultado):-
    append([],Lista_Pontos,Resultado).
    

iterar([Id|Resto],Pontos,Resultado):-
    retira_ponto(Id,P1),
    retira_ponto_2(Id,P2),
    Total is P1+P2,
    append(Pontos,[[Id,Total]],Bag),
    iterar(Resto,Bag,Resultado).
    

/*Exemplo funcao que retira pontos*/
retira_ponto(Id,Pontos):-
    fact(Id,confort:Pontos);
    Pontos is 0.

retira_ponto_2(Id,Pontos):-
    fact(Id,cornomanso:Pontos);
    Pontos is 0.


/*=========================================================================*/
%questao um
question_achiever([]).
%questao um
question_achiever([Id|Resto]):-
     demo(Id),
     demo_dois(Id),
     question_achiever(Resto).
/*=========================================================================*/
demo(Id):- new_derived_fact(Id, confort:N), !,
write( 'Derived: '), write( confort:N), nl,
assert( fact(Id, confort:N)),
demo(Id).
demo(_):- write( 'No more facts').
% A new fact
% Continue
% All facts derived
/*=========================================================================*/
new_derived_fact(Id,Concl) :-
if Cond then Concl,
 % A rule
\+ fact(Id,Concl),
 % Rule's conclusion not yet a fact
composed_fact(Id, Cond). % Condition true?
/*=========================================================================*/
composed_fact( Id,Cond1 and Cond2) :-
fact(Id,X,_),
X > Cond1,
X < Cond2.
/*=========================================================================*/

/*=========================================================================*/
%questao um
question_two([]).
%questao um
question_two([Id|Resto]):-
     demo_dois(Id),
     question_two(Resto).
/*=========================================================================*/
demo_dois(Id):- new_derived_fact_dois(Id, P), !,
write( 'Derived: '), write( P), nl,
assert( fact(Id, P)),
demo_dois(Id).
demo_dois(_):- write( 'No more facts').
% A new fact
% Continue
% All facts derived
/*=========================================================================*/
new_derived_fact_dois(Id,Concl) :-
if Cond then Concl,
 % A rule
\+ fact(Id,Concl),
 % Rule's conclusion not yet a fact
composed_fact_dois(Id, Cond). % Condition true?
/*=========================================================================*/
composed_fact_dois(Id,Cond):-
    fact(Id,_,Cond).

composed_fact_dois( Id,Cond1 or Cond2) :-
composed_fact_dois(Id,Cond1);
composed_fact_dois(Id,Cond2).
/*=========================================================================*/


if 5 and 10 then confort:10.
 
if pilas or manso then cornomanso:20.
