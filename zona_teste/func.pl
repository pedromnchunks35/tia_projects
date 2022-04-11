%operadores
:- op( 800, fx, if). 
:- op( 700, xfx, then). 
:- op( 300, xfy, or). 
:- op( 200, xfy, and).
/*zona de teste operacoes*/
/* funcao que dado 1 elemento e uma lista devolve a junçao*/
juntar(Elemento,Lista,New):-
   append(Elemento,Lista,New).
   
/*funcao para adicionar se o numero for maior*/
juntar_se(Elemento,Numero,Lista,Resultado):-
   Elemento > Numero -> juntar([Elemento],Lista,Resultado);
   juntar([Numero],Lista,Resultado).



/*funcoes para fazer uma lista de todas as solucoes com limite de preco*/
/*CATEGORIA A*/
/****************************************************************************************************************************************************************/
/*==============================================================================================================================================================*/
%A
%funcao principal que parte de um filtro de apenas precos e depois vai buscar as solucoes atraves dos mesmos
precos_filter_all(P,R):-
%ir buscar todos os precos
findall(Y, cozinhar(_,_,_,_,Y), Todos),
%Utilizar apenas aqueles que sejam inferiores ao preco acima
include(>(P),Todos,Filtrado),
%Retirar duplicados
sort(Filtrado, Semduplicados),
%Ir buscar dados correspondentes a estes precos
iterar_buscapelopreco(Semduplicados,[],R).
/*==============================================================================================================================================================*/
%A1
%Funcao recursiva de prioridade 1 (ponto de paragem ou basicamente quando nao há mais nada para iterar)
iterar_buscapelopreco([],X,R):-
%Juntar uma lista vazia a uma que sempre existiu(X) para dar um resultado final R
append([],X,R).
/*==============================================================================================================================================================*/
%A1.1
%Funcao recursiva de prioridade 2 (primeiro ponto a ser chamado da funcao , só é chamado uma vez)
iterar_buscapelopreco([Head|Resto],[],R):-
   %Fazer o cut para a funcao nao fazer redo
   !,
   %Ir buscar todos os factos com o preco dado proveniente dessa lista
   buscar_dados_compreco(Head,Dados),
   %Continuar a iteracao , passamos á funcao de baixo com o R intocavel ate ao ponto de paragem
   iterar_buscapelopreco(Resto,Dados,R).
/*==============================================================================================================================================================*/
%A1.2
%Funcao recursiva de prioridade 3 (Funcao é chamada n vezes até nao haver mais nada para iterar)
iterar_buscapelopreco([Head|Resto],Dados_ant,R):-
   %Ir buscar todos os factos com o preco dado proveniente dessa lista
   buscar_dados_compreco(Head,Dados),
   %Adicionar os dados de X e K em New
   append(Dados,Dados_ant,Join_dados),
   %Continuar a iteracao com o Resultado intocavel até a ultima iteracao
   iterar_buscapelopreco(Resto,Join_dados,R).
/*==============================================================================================================================================================*/ 
%A2
%Funcao que devolve todos os dados referentes a um dado preco
buscar_dados_compreco(Preco,Lista_dados):-
   %Ir buscar uma lista de todos os dados com um dado preco , com uma dada mascara.
   findall([Id,Car,Preco],cozinhar(Id,Car,_,_,Preco),Lista_dados).
/*==============================================================================================================================================================*/
/****************************************************************************************************************************************************************/

/*funcao para pegar nos precos filtrados e calcular os pontos*/
/*CATEGORIA B*/
/****************************************************************************************************************************************************************/
/*==============================================================================================================================================================*/
%B1
%funcao de paragem em que detemos o resultado final de uma lista de pares (id e os pontos desse id) PRIORIDADE 1
iter_pontos([],_,Lista_pontos,R):-
%pegar no resultado depois de chegar ao critério de paragem e somar a uma lista vazia para dar um resultado
append([],Lista_pontos,R).
/*==============================================================================================================================================================*/
%B1.1
%funcao de primeira iteracao em que nos é dada uma lista vazia alem dos ids e da pergunta PRIORIDADE 2
iter_pontos([[Id,_]|Resto],Pergunta,[],R):-
%cut
!,
%Ir calcular os pontos
request_pontos(Id,Pergunta,Pontos),
%juntar os pontos a uma lista
append([],[[Id,Pontos]],Lista_pontos),
%fazer nova iteracao em que a lista vazia passa a ser uma lista com o id e pontos calculados atrás
iter_pontos(Resto,Pergunta,Lista_pontos,R).
/*==============================================================================================================================================================*/
%B1.2
%funcao de n iteracoes,isto é ,ate o resto ser [], em que vamos fazendo stack na Lista_Antiga e que dará origem á funcao de prioridade 1 sendo esta de PRIORIDADE 3
iter_pontos([[Id,_]|Resto],Pergunta,Lista_Antiga,R):-
%calcular os pontos
request_pontos(Id,Pergunta,Pontos),
%juntar lista já existente com uma lista criada com id e os pontos calculados
append(Lista_Antiga,[[Id,Pontos]],Lista_pontos),
%fazer nova iteracao em que a lista antiga passa a ser uma lista com o id e pontos calculados atrás
iter_pontos(Resto,Pergunta,Lista_pontos,R).
/*==============================================================================================================================================================*/
%B2
%funcao de request de pontos
request_pontos(Id,Pergunta,Pontos):-
   %efetuar backchaining
   if Q then Pergunta,
   %fazer um cut
   !,
   %fazer nova chamada da funcao
   request(Id,Q,Pontos).
%B2.1
%funcao com o backchaining implementado que vai extrair os pontos
request_pontos(Id,Q1 and Q2,Pontos):-
   %extracao de pontos 1 se corresponder ao predicado
   cozinhar(Id,Q1,_,Q2,_)-> Pontos is 5;
   %extracao de pontos 2 se corresponder ao predicado
   cozinhar(Id,Q1,Q2,_,_)-> Pontos is 5;
   %caso falhe em todos os pontos dao 0
   Pontos is 0.
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
%funcao para remover os identificadores que inserimos acime
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

/****************************************************************************************************************************************************************/

%Regras de conhecimento%
if cao and rural then quinta.
if gato and industrial then fabrica.
if cao and piscina then turismo.
if porco and sempiscina then animais.