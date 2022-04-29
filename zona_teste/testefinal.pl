:- dynamic fact/2.
%operadores
:- op( 800, fx, if). 
:- op( 700, xfx, then). 
:- op( 300, xfy, or). 
:- op( 200, xfy, and).

fact(-1,-1).


facto(1,9,10).
facto(2,4,6).
facto(3,4,6).
facto(4,4,5).


cabeca(A,R):-
    question_one(A),
    pontos_retriever([1,2,3,4],[],Bag),
    list_top_5(Bag,R).

/*funcao para ordenar os top 5 ids pela pontuacao*/
/*Categoria C*/
/****************************************************************************************************************************************************************/
/*==============================================================================================================================================================*/
%C1.1
%funcao para adicionar uma identificacao a cada lista, essa identificacao será o valor da pontuacao
listar_pares([], []).
listar_pares([E|Es], [B-E|Ps]) :-
   E = [_,B],
   listar_pares(Es, Ps).
/*==============================================================================================================================================================*/
%C1.2
%funcao para remover os identificadores que inserimos acima
remover_pares([], []).
remover_pares([_-V|Ps], [V|Vs]) :-
   remover_pares(Ps, Vs).
/*==============================================================================================================================================================*/
%C1.3
%funcao para retirar da lista os 5 primeiros elementos da mesma
top5(Src,N,L) :- findall(E, (nth1(I,Src,E), I =< N), L).
/*==============================================================================================================================================================*/
%C1.4
list_top_5(Xs, Ys) :-
   %identificamos cada lista com o seu respetivo valor da pontuacao
   listar_pares(Xs, Ps),
   %ordenamos os valores das identifacoes por ordem crescente 
   keysort(Ps, PsS),
   %removemos as identificacoes anteriormente adicionadas
   remover_pares(PsS, Ms),
   %revertemos a lista
   reverse(Ms, Os),
   %retiramos os 5 primeiros elementos da lista
   top5(Os, 5, Ys).
/*==============================================================================================================================================================*/
/****************************************************************************************************************************************************************/



pontos_retriever([],Stack,R):-
    append([],Stack,R).

pontos_retriever([Id|Resto],Stack,R):-
    !,
     request_pontos(Id,Pontos),
     append(Stack,[[Id,Pontos]],Bag),
     pontos_retriever(Resto,Bag,R).

request_pontos(Id,Pontos):-
    fact(Id,_:Pontos);
    Pontos is 0.

%Transformador de factos
question_one(A):-
    verificar_concl(Id,A:P) , ! ,
    write("Derivado ") , write(A:P) , nl ,
    assert(fact(Id,A:P)),
    question_one(A).

%Paragem
question_one(_):-
    write('Nao há mais factos').
    
verificar_concl(Id,P):-
    if Cond then P,
    % verificar se temos facto
    \+ fact(Id,P),
    % vamos testar o facto 
    testar_facto_one(Id,Cond).



testar_facto_one(Id,Cond1 and Cond2 and Cond3 and Cond4):-
    facto(Id,X,Y),
    Cond1 < X ,
    Cond2 > X,
    Cond3 < Y,
    Cond4 > Y.






if 3 and 5 and 3 and 7 then confort:20.



















if 8 and 7 then confort:10.