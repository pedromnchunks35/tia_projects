:- dynamic(verdadeiro/2).
%operadores
:- op( 800, fx, if). 
:- op( 700, xfx, then). 
:- op( 300, xfy, or). 
:- op( 200, xfy, and).


gosta(1,pedro,marta,5,9,2000).
gosta(2,pedro,tofu,4,2,2300).
gosta(3,pedro,macarrao,4,8,2200).
gosta(4,louis,candace,5,koalas,2400).



cabeca(P,Preco,R):-
    findall(_,demo(P,Preco),_),
    findall(Y,verdadeiro(Y,_),Bag),
    sort(Bag,New),
    counter_points(New,[],R).

counter_points([],Lista,R):-
    append([],Lista,R).
    

counter_points([Id|Resto],Lista,R):-
    findall(Pontos,verdadeiro(Id,_:_:Pontos),Pontos_lista),
    sum_list(Pontos_lista,Soma_pontos),
    append(Lista,[[Id,Soma_pontos]],Lista_aim),
    counter_points(Resto,Lista_aim,R).
    


%Apartir da resposta do usar ir verificar que factos correspondem a este
demo(P,Preco):- provavelfacto(Id,P:Id_p:Points,Preco),
write('Derived ') , write(Id) , write(" from "), write(P),write(" id "),write(Id_p),write(" Which points are "),write(Points),nl,
assert(verdadeiro(Id,P:Id_p:Points)),
demo(P,Preco).

demo(_,_):-
    write('No more facts').

provavelfacto(Id,P:Id_p:Points,Preco):-
    if Cond then P:Id_p:Points,
    \+ verdadeiro(Id,P:Id_p:Points) ,
    verificarfacto(Id,Cond,Preco).

verificarfacto(Id,entre:X:e:Y,Preco):-
    gosta(Id,_,_,X1,_,P),
    P<Preco,
    X1 > X,
    X1 < Y.

verificarfacto(Id,B1 and B2,Preco):-
verificarfacto(Id,B1,Preco),
verificarfacto(Id,B2,Preco).

verificarfacto(Id,B1 or B2,Preco):-
    verificarfacto(Id,B1,Preco);
    verificarfacto(Id,B2,Preco).

verificarfacto(Id,B,Preco):-
  gosta(Id,B,_,_,_,P),
  P<Preco.

verificarfacto(Id,B,Preco):-
    gosta(Id,_,B,_,_,P),
    P<Preco.

verificarfacto(Id,B,Preco):-
    gosta(Id,_,_,B,_,P),
    P<Preco.

verificarfacto(Id,B,Preco):-
    gosta(Id,_,_,_,B,P),
    P<Preco.

verificarfacto(Id,_:Id_p:_,_):-
    findall(Id_verify,verdadeiro(Id,_:Id_verify:_),Bag),
    member(Id_p,Bag).


verificarfacto(Id, P1:Id_p:P2 and B ,Preco):-
    verificarfacto(Id,P1:Id_p:P2,_),
    verificarfacto(Id,B,Preco).

verificarfacto(Id, P1:Id_p:P2 or B ,Preco):-
    verificarfacto(Id,P1:Id_p:P2,_);
    verificarfacto(Id,B,Preco).

verificarfacto(Id, P1:Id_p:P2 and P3:Id_p2:P4 ,_):-
    verificarfacto(Id,P1:Id_p:P2,_),
    verificarfacto(Id,P3:Id_p2:P4,_).

verificarfacto(Id, P1:Id_p:P2 or P3:Id_p2:P4 ,_):-
    verificarfacto(Id,P1:Id_p:P2,_),
    verificarfacto(Id,P3:Id_p2:P4,_).
    


%QUEREMOS QUE TENHA UM ID DE RESPOSTA E OS PONTOS ASSOCIADOS A ESSE ID

if entre:4:e:6 then bonita:1:20.

if bonita:1:20 and bonita:1:20 and bonita:1:20 and bonita:1:20 then bonitacacete:1:1000.

if pedro and marta then bonita:2:30.

if bonita:1:20 and koalas then bonita:3:40.

if bonita:1:20 and pedro then bonita:4:100.

if louis and koalas then julia:1:30.

if candace and cancas then k:1:100.

if louis or pilas then mud_bath:1:40. 




