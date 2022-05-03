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
    findall(_,demo(P),_),
    findall(Id,corresponde_preco(Id,Preco),Bag),
    sort(Bag,New),
    counter_points(New,[],R).

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

demo(_,_):-
    write('No more facts').

provavelfacto(Id,P:Id_p:Points):-
    if Cond then P:Id_p:Points,
    \+ verdadeiro(Id,P:Id_p:Points) ,
    verificarfacto(Id,Cond).

verificarfacto(Id,entre:X:e:Y):-
    gosta(Id,_,_,X1,_,_),
    X1 > X,
    X1 < Y.

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
    

verificarfacto(Id,B,_):-
    verdadeiro(Id,B:_).
    


%QUEREMOS QUE TENHA UM ID DE RESPOSTA E OS PONTOS ASSOCIADOS A ESSE ID

if entre:4:e:6 then bonita:1:20.

if pedro and marta then bonita:2:30.

if bonita and pedro then calhau:1:20.





