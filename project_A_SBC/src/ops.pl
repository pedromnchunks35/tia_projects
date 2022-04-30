%factos dinamicos
:- dynamic(verdadeiro/2).
%operadores
:- op( 800, fx, if). 
:- op( 700, xfx, then). 
:- op( 300, xfy, or). 
:- op( 200, xfy, and).


%Funcao para ir buscar carateristicas
/****************************************************************************************************************************************************************/
/*==============================================================================================================================================================*/
/*
Q1- Qualidade_geral
Q2- Condicao_geral
Q3- Qualidade_cozinha
Q4- Tipo_localidade
Q5- Tipo_alojamento
Q6- Material_telhado
Q7- Material exterior
Q8- Piscina
Q9- Tamanho_casa
Q10- Fogueira
Q11- Qualidade material exterior
Q12- Condicao material exterior
Q13- Cidade
Q14- Preco
*/
get_descri(Id,Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14):-
rentops(Id,Q9,Q4,_,_,_,_,_,_,_,_,_,Q13,_,_,Q5,_,Q1,Q2,_,_,Q6,_,Q7,_,_,_,Q11,Q12,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Q3,_,_,Q10,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Q8,_,_,_,_,_,_,_,Q14).
  

/*==============================================================================================================================================================*/
/****************************************************************************************************************************************************************/


%FUNCAO PRINCIPAL CABECA
/****************************************************************************************************************************************************************/
/*==============================================================================================================================================================*/
%FUNCAO PRINCIPAL
%cabeca
cabeca(Preco,R):-
   %comprovar predicados em que existe filtro de precos
   demo(Preco),
   %ir buscar todos os ids que tem pontos
   findall(Id,verdadeiro(Id,_),Lista_ids),
   %calcular pontos
   counter_points(Lista_ids,[],Lista_pontos),
   %ordenar lista de pontos
   list_top_5(Lista_pontos,R).
/*==============================================================================================================================================================*/
/****************************************************************************************************************************************************************/





/*funcao que executa o nosso SBC*/
/*CATEGORIA A*/
/****************************************************************************************************************************************************************/
/*==============================================================================================================================================================*/
%A.1
%funcao de comeco que verifica se o Resultado do predicado ja foi comprovado e se nao estiver procura comprova-lo
demo(P,Preco):- provavelfacto(Id,P:Points,Preco),
%descritor
write('Derivou do id ->') , write(Id) , write(" com a regra ->"), write(P),write(" e com os pontos ->"),write(Points),nl,
%tornar o facto verdadeiro
assert(verdadeiro(Id,P:Points)),
%acabar com a iteracao
demo(P,Preco).
/*==============================================================================================================================================================*/
%A.2
%paragem
demo(_,_):-
   %dizer que nao há mais factos
    write('Acabou').
/*==============================================================================================================================================================*/
%A.3
%provar o predicado
provavelfacto(Id,P:Points,Preco):-
   %base de conhecimento
    if Cond then P:Points,
    %verificar se o predicado ja foi verificado
    \+ verdadeiro(Id,P:Points) ,
    %verificar o facto
    verificarfacto(Id,Cond,Preco).
/*==============================================================================================================================================================*/
/****************************************************************************************************************************************************************/


/*funcao para pegar nos precos filtrados e calcular os pontos*/
/*CATEGORIA B*/
/****************************************************************************************************************************************************************/
/*==============================================================================================================================================================*/
%B.1
%funcao de paragem
counter_points([],Lista,R):-
   %inferir resultado
   append([],Lista,R).
/*==============================================================================================================================================================*/
%B.2  
%funcao de iteracao
counter_points([Id|Resto],Lista,R):-
   %ir buscar os pontos
   findall(Pontos,verdadeiro(Id,_:Pontos),Pontos_lista),
   %soma de todos os pontos da lista
   sum_list(Pontos_lista,Soma_pontos),
   %juntar á lista um pair de id e soma dos pontos calculada em cima
   append(Lista,[[Id,Soma_pontos]],Lista_aim),
   %continuar a iteracao
   counter_points(Resto,Lista_aim,R).
/*==============================================================================================================================================================*/
/****************************************************************************************************************************************************************/

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


/*Pergunta 1*/

%resposta confort
if allpub then confort:12.

if f1:8 and f1:10 then confort:5.

if f2:8 and f2:10 then confort:4.

if f3:0 then confort:3.

if ex then confort:10.

%resposta place to sleep

if allpub then place_to_sleep:13.

if f1:5 and f1:10 then place_to_sleep:3.

if f2:5 and f2:10 then place_to_sleep:2.

if f3:0 then confort:1.

if gd then confort:10.

%resposta place to work
if nosewr or allpub then place_to_work:7.

if f1:1 and f1:10 then place_to_work:3.

if f2:1 and f2:10 then place_to_work:2.

if f3:0 then place_to_work:1.

/*Pergunta 2*/

%resposta i love it
if a or c or fv then i_love_it:20.

%resposta its irritant
if rm ir rh then its_irritant:20.

/*pergunta 3*/

%resposta i like people
if rm or rh then i_like_people:5.

if townhouse then i_like_people:3.

%resposta neutral
if rl or rp then neutral:10.

if duplx or n2FmCon then neutral:12.

%resposta i dont rly like people
if a or c or fv then i_dont_like_people:10.

if n1Fam then i_dont_like_people:15.

/*Pergunta 4*/

%resposta jazz
if grvl then jazz:3.

if reg then jazz:1.

if mansard then jazz:1.

if wdshake or wdshngl then jazz:1.

if wdsdng or wdshing or stone then jazz:1.

%resposta pop
if pave then pop:3.

if ir3 or reg then pop:1.

if shed then pop:1.

if metal then pop:1.

if plywood or metalsd then pop:1.

%resposta rap
if grvl or pave then rap:3.

if ir3 then rap:1.

if shed or hip then rap:1.

if roll then rap:1.

if cemntbd then rap:1.

/*Pergunta 5*/

%resposta yes, a lot
if fa or ta or gd then yes_a_lot:15.

%resposta sou um campeao
if ex or gd then champion:10.

%resposta nop
if na then not_rly:5.

/*Pergunta 6*/

%resposta sim , grande
if 190 or 160 or 85 or 80 then big_one:15.

%resposta sim
if 80 or 60 or 90 or 20 or 30 then yes_family:12.

%resposta no
if 120 or 150 or 50 then no_family:10.

/*7º Pergunta*/

%resposta sim , favorita
if 1 then yes_favorite_fireplace:5.

if ex or gd or ta then yes_favorite_fireplace:3.

%resposta okay
if 1 then its_ok_fireplace:7.

if 2 then its_ok_fireplace:5.

if fa or ta then its_ok_fireplace:2.

%resposta nop
if na then not_rly_fireplace:5.

/*8º Pergunta*/

%resposta sim , bastante
if ex or gd then yes_alot_appear:4.

if ex or gd then yes_alot_appear:3.

%resposta um bocado
if fa or ta or gd then just_a_bit_appear:5.

if fa or ta or gd then just_a_bit_appear:2.

%resposta nop
if all then not_rly_appear:6.

if all then not_rly_appear:2.

/*9º Pergunta*/

%resposta yes i love it
if clearcr or meadowv or noridge or stonebr or timber then yes_i_love_it:10.

%resposta i prefer the desert
if blueste or edwards or gilbert then i_prefer_desert:12.

%resposta i prefer beatches
if collgcr or npkvill or oldtown or sawyer then i_prefer_beatches:10.

%resposta i prefer green areas
if blmngtn or brdale or brkside or crawfor or idotrr or names or nridght or nwames or swisu or sawyerw or somerst or veenker then i_prefer_green_zones:15.


