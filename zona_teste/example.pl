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



counter_points([],Lista,R):-
    append([],Lista,R).
    

counter_points([Id|Resto],Lista,R):-
    findall(Pontos,verdadeiro(Id,_:Pontos),Pontos_lista),
    sum_list(Pontos_lista,Soma_pontos),
    append(Lista,[[Id,Soma_pontos]],Lista_aim),
    counter_points(Resto,Lista_aim,R).
    





cabeca(P,Preco):-
    findall(_,demo(P,Preco),_).

%Apartir da resposta do usar ir verificar que factos correspondem a este
demo(P,Preco):- provavelfacto(Id,P:Points,Preco),
write('Derived ') , write(Id) , write(" "), write(P),nl,
assert(verdadeiro(Id,P:Points)),
demo(P,Preco).

demo(_,_):-
    write('No more facts').

provavelfacto(Id,P:Points,Preco):-
    if Cond then P:Points,
    \+ verdadeiro(Id,P:Points) ,
    verificarfacto(Id,Cond,Preco).

verificarfacto(Id, f1:X and f1:Y,Preco):-
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

verificarfacto(Id,Nome and Nome1,Preco):-
    gosta(Id,Nome,Nome1,_,_,P),
    P<Preco.





if f1:3 and f1:6 then bonita:1.

if pedro and marta then bonita:1.

if louis and koalas then julia:20.

if candace and cancas then k:100.

if louis or pilas then mud_bath:40. 




