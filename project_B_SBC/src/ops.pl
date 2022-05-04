%factos dinamicos
:- dynamic(verdadeiro/2).
%operadores
:- op( 800, fx, if). 
:- op( 700, fx, then). 
:- op( 300, fy, or). 
:- op( 200, fy, and).
:- op( 100, fy, maior).
:- op( 99, fy, menor_igual).
:- op( 98, fy, igual).


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
   \+ verdadeiro(Id,P:Id_p:Points),
   %comprovar
   verificarfacto(Id,Cond).
/*==============================================================================================================================================================*/
%A.4
verificarfacto(Id,B1 and B2):-
   verificarfacto(Id,B1),
   verificarfacto(Id,B2).
/****************************************************************************************************************************************************************/
%A.5 value ExterQual 28
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.6 value GarageArea 63
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.7 value YearBuilt 20
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.8 value YearBuilt 20
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.9 value 1stFlrSF 44
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.10 value GrLivArea 47
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.11 value GrLivArea 47
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.12 value LotArea 5
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.13 value Street 6
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.14 value Alley 7
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.15 value OverallCond 19
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.16 value SalePrice 81
%verificarfacto(Id,valor_venda_maior:B):-
%   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,P),
%  P>B.
/****************************************************************************************************************************************************************/
%A.17 value MSSubClass 2
verificarfacto(Id,maior,B):-
   rentops(Id,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.18 value MSSubClass 2
verificarfacto(Id,menor_igual,B):-
   rentops(Id,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.19 value MSSubClass 2
verificarfacto(Id,igual,B):-
   rentops(Id,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=B.
/****************************************************************************************************************************************************************/
%A.20 value Exterior2nd 25
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.21 value MSSubClass 16
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.22 value HouseStyle 17
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.23 value OverallQuall 18
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.24 value OverallQuall 18
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.25 value PoolQC 73
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.26 value 2stFirSF 45
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.27 value 1stFirSF 44
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.28 value EnclosedPorch 69
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.29 value 3SsnPorch 70
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.30 value BedroomAbvGr 52
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.31 value BedroomAbvGr 52
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.32 value Foundation 30
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.33 value ScreenPorch 71
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.34 value FireplaceQu 58
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_),
   B=Value.
/****************************************************************************************************************************************************************/
%A.35 value YearRemodAdd 21
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.36 value YearRemodAdd 21
verificarfacto(Id,menor_igual,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.37 value TotalBsmtSF 39
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.38 value MasVnrArea 27
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.39 value KitchenQual 54
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.40 value GarageCars 62
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.41 value MSZoning 3
verificarfacto(Id,B):-
   rentops(Id,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.42 LandSlope value 12
verificarfacto(Id,B:-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.43 GarageYrBlt value 60
verificarfacto(Id,maior,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/*==============================================================================================================================================================*/
%A.43 corresponde preco
corresponde_preco(Id,Preco):-
      verdadeiro(Id,_),
      rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Preco_facto),
      Preco_facto<Preco. 
/*==============================================================================================================================================================*/                 

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
/*   id: 1 */
if extqualex then confort:1.
/*   id: 2 pontos: 1*/
if confort 1 and menor_igual 663 then confort:2:1.

%resposta place to sleep
/* id: 1 */
if extqualgd then place_to_sleep:1.
/* id: 2 */
if  ano_construido_maior:1970 and ano_construido_maior 1970 then place_to_sleep:1.
/* id: 3 */
if garage_menor_igual:669 and place_to_sleep2 then place_to_sleep:3.
/* id: 4 */
if primeiro_andar_menor_igual:1493 and place_to_sleep3 then place_to_sleep:4.
/* id: 5 pontos: 1*/
if garage_menor_igual:446 and place_to_sleep4 then place_to_sleep:5:1.

%resposta place to work
/* id: 1  */
if extqualta then place_to_work:1.
/* id: 2 pontos: 1*/
if espaço_sala_menor_igual:1974 and place_to_work1 then place_to_work:2:1.



/*Pergunta 2*/

%resposta i love it
/* id: 1 */
if lot_area_maior:2081 then i_love_it:1.
/* id: 2*/
if pave and i_love_it1 then i_love_it:2.
/* id: 3 */
if pave and i_love_it2 then i_love_it:3.
/* id: 4 pontos: 1*/
if ano_construido_maior:1982 and i_love_it3 then i_love_it:4:1.

%resposta its irritant
/* id: 1 */
if lot_area_maior:2081 then i_love_it:1.
/* id: 2 */
if pave and i_love_it1 then i_love_it:2.
/* id: 3 */
if empty and i_love_it2 then i_love_it:3.
/* id: 4 */
if condition_maior:1 and i_love_it3 then i_love_it:4.
/* id: 5 pontos: 1*/
if espaco_sala_maior:569 and i_love_it4 then i_love_it:5:1.



/*pergunta 3*/

%resposta i like people
/* id: 1 */
if tipo_casa_maior:87 then i_like_people:1.
/* id: 2 */
if tipo_casa_igual:185 and i_like_people1 then i_like_people:2.
/* id: 2 */
if espaço_sala_menor_igual:2604 and i_like_people2 then i_like_people:3.
/* id: 1 */
if lot_area_maior:2655 and i_like_people3 then i_like_people:4.
/* id: 2 pontos: 1*/
if garage_menor_igual:611 and i_like_people4 then i_like_people:5:1.

%resposta neutral
/* id: 1 */
if tipo_casa_maior:87 then neutral:1.
/* id: 2 pontos: 1*/
if tipo_casa_menor_igual:105 and neutral1 then neutral:2:1.

%resposta i dont rly like people
/* id: 1 pontos: 1*/
if tipo_casa_menor_igual:87 then i_dont_like_people:1:1.



/*Pergunta 4*/

%resposta jazz
/* id: 1 */
if qualidade_geral_maior:1 then jazz:1.
/* id: 2 */
if lot_area_maior:1640 and jazz1 then jazz:2.
/* id: 3 */
if ano_construido_maior:1993 and jazz2 then jazz:3.
/* id: 4 pontos: 1*/
if vinylsd and jazz3 then jazz:4:1.

%resposta pop
/* id: 1 */
if qualidade_geral_maior:1 then pop:1.
/* id: 2 */
if lot_area_maior:1604 and pop1 then pop:2.
/* id: 3 */
if ano_construido_maior:1993 and pop2 then pop:3.
/* id: 4 pontos: 1*/
if metalsd and pop3 then pop:4:1.

%resposta rap
/* id: 1*/
if qualidade_geral_maior:1 then rap:1.
/* id: 2 */
if lot_area_maior:1604 and rap1 then rap:2.
/* id: 3 */
if ano_construido_maior:1993 and rap2 then rap:3.
/* id: 4 pontos: 1*/
if cmentbd and rap3 then rap:4:1.



/*Pergunta 5*/
%resposta yes, a lot
/* id: 1 pontos: 1*/
if poolex then yes_a_lot:1:1.

%resposta sou um campeao
/* id: 1 pontos: 1*/
if poolgd then champion:1:1.

%resposta nop
/* id: 1 pontos: 1*/
if poolempty then not_rly:1:1.



/*Pergunta 6*/
%resposta sim , grande
/* id: 1 */
if n1fam then big_one:1.
/* id: 2 pontos: 1*/
if slv1 and big_one1 then big_one:2:1.

%resposta sim
/* id: 1 */
if n1fam then yes_family:1.
/* id: 2 pontos: 1*/
if n2story and yes_family1 then yes_family:2:1.

%resposta no
/* id: 1*/
if twnhse then no_family:1.
/* id: 2 pontos: 1*/
if n1story and no_family1 then no_family:2:1.



/*7º Pergunta*/

%resposta sim , favorita
/* id: 1 */
if n2nd_first_square_feet_menor_igual:1849 then yes_favorite_fireplace:1.
/* id: 2 */
if n1nd_first_square_feet_maior:509 and yes_favorite_fireplace1 then yes_favorite_fireplace:2.
/* id: 3 */
if area_entrada_menor_igual:798 and yes_favorite_fireplace2 then yes_favorite_fireplace:3.
/* id: 4 */
if area_entrada_3season_menor_igual:307 and yes_favorite_fireplace3 then yes_favorite_fireplace:4.
/* id: 5 */
if espaco_sala_maior:792 and yes_favorite_fireplace4 then yes_favorite_fireplace:5.
/* id: 6 */
if quartos_anima_media_maior:2001 and yes_favorite_fireplace5 then yes_favorite_fireplace:6.
/* id: 7 */
if lot_area_maior:3079 and yes_favorite_fireplace6 then yes_favorite_fireplace:7.
/* id: 8 pontos: 1*/
if pconc and yes_favorite_fireplace7 then yes_favorite_fireplace:8:1.

%resposta okay
/* id: 1 */
if n2nd_first_square_feet_menor_igual:1849 then its_ok_fireplace:1.
/* id: 2 */
if n1nd_first_square_feet_maior:509 and its_ok_fireplace1 then its_ok_fireplace:2.
/* id: 3 */
if area_entrada_menor_igual:798 and its_ok_fireplace2 then its_ok_fireplace:3.
/* id: 4 */
if area_entrada_3season_menor_igual:307 and its_ok_fireplace3 then its_ok_fireplace:4.
/* id: 5 */
if espaco_sala_maior:792 and its_ok_fireplace4 then its_ok_fireplace:5.
/* id: 6 */
if quartos_anima_media_menor_igual:2001 and its_ok_fireplace5 then its_ok_fireplace:6.
/* id: 7 */
if screen_porch_area_menor_igual:345 and its_ok_fireplace6 then its_ok_fireplace:7.
/* id: 8 pontos: 1*/
if ano_construido_maior:1959 and its_ok_fireplace7 then its_ok_fireplace:8:1.

%resposta nop
/* id: 1 pontos: 1*/
if empty then not_rly_fireplace:1:1.



/*8º Pergunta*/

%resposta sim , bastante
/* id: 1 */
if qualidade_geral_menor_igual:9 then yes_alot_appear:1.
/* id: 2 */
if qualidade_geral_maior:8 and yes_alot_appear1 then yes_alot_appear:2.
/* id: 3 */
if no_remodulacao_maior:2003 and yes_alot_appear2 then yes_alot_appear:3.
/* id: 4 */
if basement_square_feet_maior:1432 and yes_alot_appear3 then yes_alot_appear:4.
/* id: 5 pontos: 1*/
if venner_square_feet_maior:142 and yes_alot_appear4 then yes_alot_appear:5:1.

%resposta um bocado
/* id: 1 */
if qualidade_geral_menor_igual:9 then just_a_bit_appear:1.
/* id: 2 */
if qualidade_geral_menor_igual:8 and just_a_bit_appear1 then just_a_bit_appear:2.
/* id: 3 */
if ano_construido_maior:1985 and just_a_bit_appear2 then just_a_bit_appear:3.
/* id: 4 */
if area_entrada_3season_menor_igual:76 and just_a_bit_appear3 then just_a_bit_appear:4.
/* id: 5 */
if kitchengd and just_a_bit_appear4 then just_a_bit_appear:5.
/* id: 6 pontos: 1*/
if numero_carros_garagem_maior:0 and just_a_bit_appear5 then just_a_bit_appear:6:1.

%resposta nop
/* id: 1 */
if qualidade_geral_menor_igual:9 then not_rly_appear:1.
/* id: 2 */
if qualidade_geral_menor_igual:8 and not_rly_appear1 then not_rly_appear:2.
/* id: 3 */
if ano_construido_menor_igual:1985 and not_rly_appear2 then not_rly_appear:3.
/* id: 4 */
if qualidade_geral_menor_igual:7 and not_rly_appear3 then not_rly_appear:4.
/* id: 5 pontos: 1*/
if no_remodulacao_menor_igual:2008 and not_rly_appear4 then not_rly_appear:5:1.



/*9º Pergunta*/

%resposta yes i love it
/* id: 1 */
if lot_area_maior:2081 then yes_i_love_it:1.
/* id: 2 */
if lot_area_maior:2379 and yes_i_love_it1 then yes_i_love_it:2.
/* id: 3 */
if ano_construido_maior:1971 and yes_i_love_it2 then yes_i_love_it:3.
/* id: 4 */
if rm and yes_i_love_it3 then yes_i_love_it:4.
/* id: 5 pontos: 1*/
if qualidade_geral_menor_igual:5 and yes_i_love_it4 then yes_i_love_it:5:1.

%resposta i prefer the desert
/* id: 1 */
if lot_area_maior:2081 then i_prefer_desert:1.
/* id: 2 */
if lot_area_maior:2379 and i_prefer_desert1 then i_prefer_desert:2.
/* id: 3 */
if ano_construido_maior:1971 and i_prefer_desert2 then i_prefer_desert:3.
/* id: 4 */
if rm and i_prefer_desert3 then i_prefer_desert:4.
/* id: 5 */
if qualidade_geral_maior:5 and i_prefer_desert4 then i_prefer_desert:5.
/* id: 6 */
if gtl and i_prefer_desert5 then i_prefer_desert:6.
/* id: 7 pontos: 1*/
if 1997 and i_prefer_desert6 then i_prefer_desert:7:1.

%resposta i prefer beatches
/* id: 1 */
if lot_area_maior:2081 then i_prefer_beatches:1.
/* id: 2 */
if lot_area_maior:2379 and i_prefer_beatches1 then i_prefer_beatches:2.
/* id: 3 */
if ano_garagem_construido_maior:1971 and i_prefer_beatches2 then i_prefer_beatches:3.
/* id: 4 pontos: 1*/
if rm and i_prefer_beatches3 then i_prefer_beatches:4:1.

%resposta i prefer green areas
/* id: 1 */
if lot_area_maior:2081 then i_prefer_green_zones:1.
/* id: 2 */
if lot_area_maior:2379 and i_prefer_green_zones1 then i_prefer_green_zones:2.
/* id: 3 */
if ano_construido_maior:1971 and i_prefer_green_zones2 then i_prefer_green_zones:3.
/* id: 4 pontos: 1*/
if fv and i_prefer_green_zones3 then i_prefer_green_zones:4:1.


