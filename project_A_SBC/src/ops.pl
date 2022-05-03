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
cabeca(Preco,R1,R2,R3,R4,R5,R6,R7,R8,R9,R):-
   %comprovar predicados em que existe filtro de precos
   findall(_,demo(R1),_),
   findall(_,demo(R2),_),
   findall(_,demo(R3),_),
   findall(_,demo(R4),_),
   findall(_,demo(R5),_),
   findall(_,demo(R6),_),
   findall(_,demo(R7),_),
   findall(_,demo(R8),_),
   findall(_,demo(R9),_),
   %ir buscar todos os ids que tem pontos
   findall(Id,corresponde_preco(Id,Preco),Lista_ids),
   %remover duplicados
   sort(Lista_ids,Newlista),
   %calcular pontos
   counter_points(Newlista,[],Lista_pontos),
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
demo(P):- provavelfacto(Id,P:Id_p:Points),
%descritor
write('Derivou do id ->') , write(Id) , write(" com a regra ->"), write(P),write(" e com os pontos ->"),write(Points),nl,
%tornar o facto verdadeiro
assert(verdadeiro(Id,P:Id_p:Points)),
%acabar com a iteracao
demo(P).
/*==============================================================================================================================================================*/
%A.2
%paragem
demo(_,_):-
   %dizer que nao há mais factos
    write('Acabou'), nl.
/*==============================================================================================================================================================*/
%A.3
%funcao de verificacao de facto e por sua vez aprovacao do mesmo caso nao seja facto
provavelfacto(Id,P:Id_p:Points):-
   %ir buscar a regra
   if Cond then P:Id_p:Points,
   %se a regra nao estiver comprovada verificar se é possivel comprovar
   \+ verdadeiro(Id,P:Id_p:Points) ,
   %comprovar
   verificarfacto(Id,Cond).
/*==============================================================================================================================================================*/
%A.4
verificarfacto(Id,qual_entre:X:e:Y):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,X1,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   X1 > X,
   X1 < Y.
/*==============================================================================================================================================================*/
%A.5
verificarfacto(Id,condi_entre:X:e:Y):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,X1,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   X1 > X,
   X1 < Y.
/*==============================================================================================================================================================*/
%A.6
verificarfacto(Id,bath_sup:X):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,X1,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   X1 > X.
/*==============================================================================================================================================================*/
%A.7
verificarfacto(Id,beed_sup:X):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,X1,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   X1 > X.
/*==============================================================================================================================================================*/
%A.8
verificarfacto(Id,B1 and B2):-
   verificarfacto(Id,B1),
   verificarfacto(Id,B2).
/*==============================================================================================================================================================*/
%A.9
verificarfacto(Id,B1 or B2):-
   verificarfacto(Id,B1);
   verificarfacto(Id,B2).
/*==============================================================================================================================================================*/
%A.10 value10
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.11 value 54
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.12 value 3
verificarfacto(Id,B):-
rentops(Id,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.13 value 16
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.14 value 6
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.15 value 8
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.16 value 22
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_). 
/*==============================================================================================================================================================*/
%A.17 value 23
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.18 value 24
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.19 value 73
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.20 value 2
verificarfacto(Id,B):-
rentops(Id,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.21 value 57
verificarfacto(Id,sup_fire:B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
                                 Value>B.
/*==============================================================================================================================================================*/
%A.22 value 57
verificarfacto(Id,fire_entre:B:e:B1):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
                                 Value>B,
                                 Value<B1.
/*==============================================================================================================================================================*/
%A.23 value 58
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.24 value 28
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.25 value 29
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.26 value 28 && 29 passe 
verificarfacto(Id,dar_pontos_simplesmente_passe).
/*==============================================================================================================================================================*/
%A.27 value 13
verificarfacto(Id,B):-
rentops(Id,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/*==============================================================================================================================================================*/
%A.28 factos verdadeiros
verificarfacto(Id,B):-
   verdadeiro(Id,B:_). 
/*==============================================================================================================================================================*/
%A.29 corresponde preco
corresponde_preco(Id,Preco):-
      verdadeiro(Id,_),
      rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Preco_facto),
      Preco_facto<Preco. 
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
   findall(Pontos,verdadeiro(Id,_:_:Pontos),Pontos_lista),
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

/*Relativamente ás perguntas nśo detemos :resposta:pontos_resposta de modo a ser mais diferenciador*/

/*Pergunta 1*/

%resposta confort
/*   id: 1 pontos: 10  */
if allpub then confort:1:1.
/*   id: 2 pontos: 5  */
if qual_entre:8:e:10 then confort:2:1.
/*   id: 3 pontos: 4 */
if condi_entre:8:e:10 then confort:3:1.
/*   id: 4 pontos: 3 */
if bath_sup:0 then confort:4:1.
/*   id: 5 pontos: 6 */
if beed_sup:0 then confort:5:1.
/* id: 6 pontos: 6*/
if kitchenex then confort:6:1.

%resposta place to sleep
/* id: 1 pontos: 13*/
if allpub then place_to_sleep:1:1.
/* id: 2 pontos: 3*/
if qual_entre:5:e:10 then place_to_sleep:2:1.
/* id: 3 pontos: 2*/
if condi_entre:5:e:10 then place_to_sleep:3:1.
/* id: 4 pontos: 2*/
if bath_sup:-1 then place_to_sleep:4:1.
/* id: 5 pontos: 10*/
if beed_sup:0 then place_to_sleep:5:1.
/* id: 6 pontos: 10 */
if kitchengd then place_to_sleep:6:1.

%resposta place to work
/* id: 1  pontos: 7*/
if nosewr or allpub then place_to_work:1:1.
/* id: 2 pontos: 3*/
if qual_entre:0:e:10 then place_to_work:2:1.
/* id: 3 pontos: 2*/
if condi_entre:0:e:10 then place_to_work:3:1.
/* id: 4 pontos: 2*/
if bath_sup:-1 then place_to_work:4:1.

/*Pergunta 2*/

%resposta i love it
/* id: 1 pontos: 10*/
if a or c or fv then i_love_it:1:1.
/* id: 1 pontos: 20*/
%resposta its irritant
if rm or rh then its_irritant:1:1.

/*pergunta 3*/

%resposta i like people
/* id: 1 pontos: 5*/
if rm or rh then i_like_people:1:1.
/* id: 2 pontos: 3*/
if townhouse then i_like_people:2:1.

%resposta neutral
/* id: 1 pontos: 10*/
if rl or rp then neutral:1:1.
/* id: 2 pontos: 12*/
if duplx or n2FmCon then neutral:2:1.

%resposta i dont rly like people
/* id: 1 pontos: 10*/
if a or c or fv then i_dont_like_people:1:1.
/* id: 2 pontos: 15*/
if n1Fam then i_dont_like_people:2:1.

/*Pergunta 4*/

%resposta jazz
/* id: 1 pontos: 3*/
if grvl then jazz:1:1.
/* id: 2 pontos: 1*/
if reg then jazz:2:1.
/* id: 3 pontos: 1*/
if mansard then jazz:3:1.
/* id: 4 pontos: 1*/
if wdshake or wdshngl then jazz:4:1.
/* id: 5 pontos: 1*/
if wdsdng or wdshing or stone then jazz:5:1.
/* id: 6 pontos: 10*/
if confort then jazz:6:1.

%resposta pop
/* id: 1 pontos: 3*/
if pave then pop:1:1.
/* id: 2 pontos: 1*/
if ir3 or reg then pop:2:1.
/* id: 3 pontos: 1*/
if shed then pop:3:1.
/* id: 4 pontos: 1*/
if metal then pop:4:1.
/* id: 5 pontos: 1*/
if plywood or metalsd then pop:5:1.

%resposta rap
/* id: 1 pontos: 3*/
if grvl or pave then rap:1:1.
/* id: 2 pontos: 1*/
if ir3 then rap:2:1.
/* id: 3 pontos: 1*/
if shed or hip then rap:3:1.
/* id: 4 pontos: 1*/
if roll then rap:4:1.
/* id: 5 pontos: 1*/
if cemntbd then rap:5:1.

/*Pergunta 5*/
/* id: 1 pontos: 15*/
%resposta yes, a lot
if poolfa or poolta or poolgd then yes_a_lot:1:1.
/* id: 1 pontos: 10*/
%resposta sou um campeao
if poolex or poolgd then champion:1:1.
/* id: 1 pontos: 5*/
%resposta nop
if poolna then not_rly:1:1.

/*Pergunta 6*/
/* id: 1 pontos: 15*/
%resposta sim , grande
if 190 or 160 or 85 or 80 then big_one:1:1.

/* id: 1 pontos: 12*/
%resposta sim
if 80 or 60 or 90 or 20 or 30 then yes_family:1:1.

/* id: 1 pontos: 10*/
%resposta no
if 120 or 150 or 50 then no_family:1:1.

/*7º Pergunta*/

%resposta sim , favorita
/* id: 1 pontos: 5*/
if sup_fire:1 then yes_favorite_fireplace:1:1.
/* id: 2 pontos: 3*/
if fireex or firegd or fireta then yes_favorite_fireplace:2:1.

%resposta okay
/* id: 1 pontos: 7*/
if fire_entre:0:e:3 then its_ok_fireplace:1:1.
/* id: 1 pontos: 3*/
if firefa or fireta then its_ok_fireplace:2:1.

%resposta nop
/* id: 1 pontos: 5*/
if firena then not_rly_fireplace:1:1.

/*8º Pergunta*/
/* id: 1 pontos: 4*/
%resposta sim , bastante
if extqualex or extqualgd then yes_alot_appear:1:1.
/* id: 2 pontos: 3*/
if extcondex or extcondgd then yes_alot_appear:2:1.
/* id: 3 pontos: 10 */
if confort then yes_alot_appear:3:1.

%resposta um bocado
/* id: 1 pontos: 5*/
if extqualfa or extqualta or extqualgd then just_a_bit_appear:1:1.
/* id: 2 pontos: 2*/
if extcondfa or extcondta or extcondgd then just_a_bit_appear:2:1.

%resposta nop
/* id: 1 pontos: 6*/
if dar_pontos_simplesmente_passe then not_rly_appear:1:1.
/* id: 2 pontos: 2*/
if dar_pontos_simplesmente_passe then not_rly_appear:2:1.

/*9º Pergunta*/

%resposta yes i love it
/* id: 1 pontos: 10*/
if clearcr or meadowv or noridge or stonebr or timber then yes_i_love_it:1:1.

%resposta i prefer the desert
/* id: 1 pontos: 12*/
if blueste or edwards or gilbert then i_prefer_desert:1:1.

%resposta i prefer beatches
/* id: 1 pontos: 10*/
if collgcr or npkvill or oldtown or sawyer then i_prefer_beatches:1:1.

%resposta i prefer green areas
/* id: 1 pontos: 15*/
if blmngtn or brdale or brkside or crawfor or idotrr or names or nridght or nwames or swisu or sawyerw or somerst or veenker then i_prefer_green_zones:1:1.



