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
/****************************************************************************************************************************************************************/



   



   
%Regras de conhecimento%
if cao and campo then quinta.
if gato and industrial then fabrica.
if cao and piscina then turismo.
if porco and sempiscina then animais.