:- dynamic(verdadeiro/2).
%operadores
:- op( 800, fx, if). 
:- op( 700, xfx, then). 
:- op( 300, xfy, or). 
:- op( 200, xfy, and).
:- op( 100, fy , bonita).


gosta(1,pedro,marta,5,9,2000).
gosta(2,pedro,tofu,4,2,2300).
gosta(3,pedro,macarrao,4,8,2200).
gosta(4,louis,candace,5,koalas,2400).



cabeca(P,Preco,R):-
    findall(_,demo(P),_),
    findall(Id,corresponde_preco(Id,Preco),Bag),
    sort(Bag,New),
    counter_points(New,[],Points_list),
    list_top_5(Points_list,R).

counter_points([],Lista,R):-
    append([],Lista,R).
    

counter_points([Id|Resto],Lista,R):-
    findall(Pontos,verdadeiro(Id,_:_:Pontos),Pontos_lista),
    sum_list(Pontos_lista,Soma_pontos),
    append(Lista,[[Id,Soma_pontos]],Lista_aim),
    counter_points(Resto,Lista_aim,R).
    
corresponde_preco(Id,Preco):-
    verdadeiro(Id,_),
    gosta(Id,_,_,_,_,Preco_facto),
    Preco_facto<Preco.


%Apartir da resposta do usar ir verificar que factos correspondem a este
demo(P):- provavelfacto(Id,P:Id_p:Points),
write('Derived ') , write(Id) , write(" from "), write(P),write(" id "),write(Id_p),write(" Which points are "),write(Points),nl,
assert(verdadeiro(Id,P:Id_p:Points)),
demo(P).

demo(_):-
    write('No more facts').

provavelfacto(Id,P:Id_p:Points):-
    if Cond then P:Id_p:Points,
    \+ verdadeiro(Id,P:Id_p:Points) ,
    verificarfacto(Id,Cond).


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





verificarfacto(Id,B1 and B2):-
verificarfacto(Id,B1),
verificarfacto(Id,B2).

verificarfacto(Id,B1 or B2):-
    verificarfacto(Id,B1);
    verificarfacto(Id,B2).

verificarfacto(Id,B):-
  gosta(Id,B,_,_,_,_).
  

verificarfacto(Id,B):-
    gosta(Id,_,B,_,_,_).
    

verificarfacto(Id,B):-
    gosta(Id,_,_,B,_,_).
    

verificarfacto(Id,B):-
    gosta(Id,_,_,_,B,_).
    

verificarfacto(Id,B):-
    verdadeiro(Id,B:_).

verificarfacto(Id,bonita X):-
    verdadeiro(Id,bonita:X:_).

verificarfacto(Id,maior(data_construcao,X)):-
    gosta(Id,_,_,_,_,C),
    C>X.

verificarfacto(Id,limite(qualidade,X,Y)):-
    gosta(Id,_,_,Valor,_,_),
    X<Valor,
    Y>Valor.


%QUEREMOS QUE TENHA UM ID DE RESPOSTA E OS PONTOS ASSOCIADOS A ESSE ID
if marta and pedro or elsa  then bonita:1:20.  

if maior(data_construcao,1970) and pedro then  bonita:2:20.

if bonita 2 and pedro then bonita:3:30.



