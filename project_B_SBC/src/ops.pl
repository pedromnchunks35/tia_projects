%factos dinamicos
:- dynamic(verdadeiro/2).
%operadores
:- op( 800, fx, if).
:- op( 700, fx, then).
:- op( 300, fy, or).
:- op( 200, fy, and).
:- op( 100, fy, maior).
:- op( 100, fy, igual).
:- op( 100, fy, menor_igual).

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
%funcao de verificacao de facto e por sua vez aprovacao do mesmo caso nao seja facto
provavelfacto(Id,P:Id_p:Points):-
   %ir buscar a regra
   if Cond and Cond then P:Id_p:Points,
   %se a regra nao estiver comprovada verificar se é possivel comprovar
   \+ verdadeiro(Id,P:Id_p:Points),
   %comprovar
   verificarfacto(Id,Cond).
/*==============================================================================================================================================================*/
% %A.4
% verificarfacto(Id,B1 and B2):-
%    verificarfacto(Id,B1),
%    verificarfacto(Id,B2).
/****************************************************************************************************************************************************************/
%A.5 value ExterQual 28
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.6 value GarageArea 63
verificarfacto(Id,menor_igual(garagem,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.7 value YearBuilt 20
verificarfacto(Id,maior(ano_construido,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.8 value YearBuilt 20
verificarfacto(Id,menor_igual(ano_construido,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.9 value 1stFlrSF 44
verificarfacto(Id,menor_igual(primeiro_andar,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.10 value GrLivArea 47
verificarfacto(Id,menor_igual(espaco_sala,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.11 value GrLivArea 47
verificarfacto(Id,maior(espaco_sala,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.12 value LotArea 5
verificarfacto(Id,maior(lot_area,B)):-
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
verificarfacto(Id,maior(condition,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.16 value SalePrice 81
%verificarfacto(Id,valor_venda_maior:B):-
%   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,P),
%  P>B.
/****************************************************************************************************************************************************************/
%A.17 value MSSubClass 2
verificarfacto(Id,maior(tipo_casa,B)):-
   rentops(Id,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.18 value MSSubClass 2
verificarfacto(Id,igual(tipo_casa,B)):-
   rentops(Id,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.19 value MSSubClass 2
verificarfacto(Id,menor_igual(tipo_casa,B)):-
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
verificarfacto(Id,maior(qualidade_geral,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.24 value OverallQuall 18
verificarfacto(Id,menor_igual(qualidade_geral,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.25 value PoolQC 73
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.26 value 2stFirSF 45
verificarfacto(Id,menor_igual(n2nd_first_square_feet,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.27 value 1stFirSF 44
verificarfacto(Id,maior(n1nd_first_square_feet,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.28 value EnclosedPorch 69
verificarfacto(Id,menor_igual(area_entrada,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.29 value 3SsnPorch 70
verificarfacto(Id,menor_igual(area_entrada_3season,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.30 value BedroomAbvGr 52
verificarfacto(Id,maior(quartos_anima_media,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.31 value BedroomAbvGr 52
verificarfacto(Id,menor_igual(quartos_anima_media,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.32 value Foundation 30
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.33 value ScreenPorch 71
verificarfacto(Id,menor_igual(screen_porch_area,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.34 value FireplaceQu 58
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.35 value YearRemodAdd 21
verificarfacto(Id,maior(no_remodulacao,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.36 value YearRemodAdd 21
verificarfacto(Id,menor_igual(no_remodulacao,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value=<B.
/****************************************************************************************************************************************************************/
%A.37 value TotalBsmtSF 39
verificarfacto(Id,maior(basement_square_feet,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.38 value MasVnrArea 27
verificarfacto(Id,maior(venner_square_feet,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.39 value KitchenQual 54
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.40 value GarageCars 62
verificarfacto(Id,maior(numero_carros_garagem,B)):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,Value,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_),
   Value>B.
/****************************************************************************************************************************************************************/
%A.41 value MSZoning 3
verificarfacto(Id,B):-
   rentops(Id,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.42 LandSlope value 12
verificarfacto(Id,B):-
   rentops(Id,_,_,_,_,_,_,_,_,_,_,B,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_).
/****************************************************************************************************************************************************************/
%A.43 GarageYrBlt value 60
verificarfacto(Id,maior(ano_garagem_construido,B)):-
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
/****************************************************************************************************************************************************************/

/*Relativamente ás perguntas nśo detemos :resposta:pontos_resposta de modo a ser mais diferenciador*/

/*Pergunta 1*/

%resposta confort
if extqualex and menor_igual(garagem,663) then confort:1:1.
% /*   id: 1 */
% if extqualex and then confort:1.
% /*   id: 2 pontos: 1*/
% if confort 1 and menor_igual 663 then confort:2:1.

%resposta place to sleep
if extqualgd and maior(ano_construido,1970) and menor_igual(garage,669) and menor_igual(primeiro_andar,1493) and menor_igual(garage,446) then place_to_sleep:1:1.
% /* id: 1 */
% if extqualgd then place_to_sleep:1.
% /* id: 2 */
% if  place_to_sleep 1 and ano_construido_maior 1970 then place_to_sleep:2.
% /* id: 3 */
% if place_to_sleep 2 and garage_menor_igual 669 then place_to_sleep:3.
% /* id: 4 */
% if place_to_sleep 3 and primeiro_andar_menor_igual 1493 then place_to_sleep:4.
% /* id: 5 pontos: 1*/
% if place_to_sleep 4 and garage_menor_igual 446 then place_to_sleep:5:1.

%resposta place to work
if extqualta and menor_igual(espaco_sala,1974) then place_to_work:2:1.
% /* id: 1  */
% if extqualta then place_to_work:1.
% /* id: 2 pontos: 1*/
% if place_to_work 1 and espaco_sala_menor_igual 1974 then place_to_work:2:1.



/*Pergunta 2*/

%resposta i love it
if maior(lot_area,2081) and pave, and paven, and maior(ano_construido,1982) then o_love_it:1:1.
% /* id: 1 */
% if lot_area_maior 2081 then i_love_it:1.
% /* id: 2*/
% if i_love_it 1 and pave then i_love_it:2.
% /* id: 3 */
% if i_love_it 2 and pave then i_love_it:3.
% /* id: 4 pontos: 1*/
% if i_love_it 3 and ano_construido_maior 1982 then i_love_it:4:1.

%resposta its irritant
if maior(lot_area,2081) and pave, and empty and maior(espaco_sala, 569) then its_irritant:1:1.
% /* id: 1 */
% if lot_area_maior 2081 then its_irritant:1.
% /* id: 2 */
% if its_irritant 1 and pave then its_irritant:2.
% /* id: 3 */
% if its_irritant 2 and empty then its_irritant:3.
% /* id: 4 */
% if its_irritant 3 and condition_maior 1 then its_irritant:4.
% /* id: 5 pontos: 1*/
% if its_irritant 4 and espaco_sala_maior 569 then its_irritant:5:1.



/*pergunta 3*/

%resposta i like people
if maior(tipo_casa,105) and menor_igual(tipo_casa,185) and menor_igual(espaco_sala,2604) and maior(lot_area,2655) and menor_igual(garage,611) then i_like_people:1:1.
% /* id: 1 */
% if tipo_casa_maior 105 then i_like_people:1.
% /* id: 2 */
% if i_like_people 1 and tipo_casa_menor_igual 185 then i_like_people:2.
% /* id: 2 */
% if i_like_people 2 and espaco_sala_menor_igual 2604 then i_like_people:3.
% /* id: 1 */
% if i_like_people 3 and lot_area_maior 2655 then i_like_people:4.
% /* id: 2 pontos: 1*/
% if i_like_people 4 and garage_menor_igual 611 then i_like_people:5:1.

%resposta neutral
if maior(tipo_casa,87) and menor_igual(tipo_casa,105) neutral:2:1.
% /* id: 1 */
% if tipo_casa_maior 87 then neutral:1.
% /* id: 2 pontos: 1*/
% if neutral 1 and tipo_casa_menor_igual 105 then neutral:2:1.

%resposta i dont rly like people
if menor_igual(tipo_casa,87) then i_dont_like_people:1:1.
% /* id: 1 pontos: 1*/
% if tipo_casa_menor_igual:87 then i_dont_like_people:1:1.



/*Pergunta 4*/

%resposta jazz
if maior(qualidade_geral,1) and maior(lot_area,1640) and maior(ano_construido,1993) and metalsd then pop:1:1.
% /* id: 1 */
% if qualidade_geral_maior 1 then jazz:1.
% /* id: 2 */
% if jazz 1 and lot_area_maior 1640 then jazz:2.
% /* id: 3 */
% if jazz 2 and ano_construido_maior 1993 then jazz:3.
% /* id: 4 pontos: 1*/
% if jazz 3 and vinylsd then jazz:4:1.

%resposta pop
if maior(qualidade_geral,1) and maior(lot_area,1604) and maior(ano_construido,1993) and metalsd then pop:1:1.
% /* id: 1 */
% if qualidade_geral_maior 1 then pop:1.
% /* id: 2 */
% if pop 1 and lot_area_maior 1604 then pop:2.
% /* id: 3 */
% if pop 2 and ano_construido_maior 1993 then pop:3.
% /* id: 4 pontos: 1*/
% if pop 3 and metalsd then pop:4:1.

%resposta rap
if maior(qualidade_geral,1) and maior(lot_area,1604) and maior(ano_construido,1993) and cmentbd then rap:1:1.
% /* id: 1*/
% if qualidade_geral_maior 1 then rap:1.
% /* id: 2 */
% if rap 1 and lot_area_maior 1604 then rap:2.
% /* id: 3 */
% if rap 2 and ano_construido_maior 1993 then rap:3.
% /* id: 4 pontos: 1*/
% if rap 3 and cmentbd then rap:4:1.



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
if n1fam and slv1 then big_one:1:1.
% /* id: 1 */
% if n1fam then big_one:1.
% /* id: 2 pontos: 1*/
% if big_one 1 and slv1 then big_one:2:1.

%resposta sim
if n1fam and n2story then yes_family:1:1.
% /* id: 1 */
% if n1fam then yes_family:1.
% /* id: 2 pontos: 1*/
% if yes_family 1 and n2story then yes_family:2:1.

%resposta no
if twnhse and n1story then no_family:1:1.
% /* id: 1*/
% if twnhse then no_family:1.
% /* id: 2 pontos: 1*/
% if no_family 1 and n1story then no_family:2:1.



/*7º Pergunta*/
if menor_igual(n2nd_first_square_feet_,1849) and maior(n1nd_first_square_feet,509) and menor_igual(area_entrada,798) and menor_igual(area_entrada_3season,307) and maior(espaco_sala,792) and maior(quartos_anima_media,2001) and maior(lot_area,3079) and pconc then yes_favorite_fireplace:1:1.
% %resposta sim , favorita
% /* id: 1 */
% if n2nd_first_square_feet_menor_igual 1849 then yes_favorite_fireplace:1.
% /* id: 2 */
% if yes_favorite_fireplace 1 and n1nd_first_square_feet_maior 509 then yes_favorite_fireplace:2.
% /* id: 3 */
% if yes_favorite_fireplace 2 and area_entrada_menor_igual 798 then yes_favorite_fireplace:3.
% /* id: 4 */
% if yes_favorite_fireplace 3 and area_entrada_3season_menor_igual 307 then yes_favorite_fireplace:4.
% /* id: 5 */
% if yes_favorite_fireplace 4 and espaco_sala_maior 792 then yes_favorite_fireplace:5.
% /* id: 6 */
% if yes_favorite_fireplace 5 and quartos_anima_media_maior 2001 then yes_favorite_fireplace:6.
% /* id: 7 */
% if yes_favorite_fireplace 6 and lot_area_maior 3079 then yes_favorite_fireplace:7.
% /* id: 8 pontos: 1*/
% if yes_favorite_fireplace 7 and pconc then yes_favorite_fireplace:8:1.

%resposta okay
if menor_igual(n2nd_first_square_feet_,1849) and maior(n1nd_first_square_feet,509) and menor_igual(area_entrada,798) and menor_igual(area_entrada_3season,307) and maior(espaco_sala,792) and maior(quartos_anima_media,2001) and menor_igual(screen_por_area,345) and maior(ano_construido,1959) then its_ok_fireplace:8:1.
% /* id: 1 */
% if n2nd_first_square_feet_menor_igual 1849 then its_ok_fireplace:1.
% /* id: 2 */
% if its_ok_fireplace 1 and n1nd_first_square_feet_maior 509 then its_ok_fireplace:2.
% /* id: 3 */
% if its_ok_fireplace 2 and area_entrada_menor_igual 798 then its_ok_fireplace:3.
% /* id: 4 */
% if its_ok_fireplace 3 and area_entrada_3season_menor_igual 307 then its_ok_fireplace:4.
% /* id: 5 */
% if its_ok_fireplace 4 and espaco_sala_maior 792 then its_ok_fireplace:5.
% /* id: 6 */
% if its_ok_fireplace 5 and quartos_anima_media_menor_igual 2001 then its_ok_fireplace:6.
% /* id: 7 */
% if its_ok_fireplace 6 and screen_porch_area_menor_igual 345 then its_ok_fireplace:7.
% /* id: 8 pontos: 1*/
% if its_ok_fireplace 7 and ano_construido_maior 1959 then its_ok_fireplace:8:1.

%resposta nop
/* id: 1 pontos: 1*/
if empty then not_rly_fireplace:1:1.



/*8º Pergunta*/

%resposta sim , bastante
if menor_igual(qualidade_geral,9) and maior(qualidade_geral,8) and maior(no_remodulacao,2003) and maior(basement_square_feet,1432) and maior(venner_square_feet,142) then yes_alot_appear:1:1.
% /* id: 1 */
% if qualidade_geral_menor_igual 9 then yes_alot_appear:1.
% /* id: 2 */
% if yes_alot_appear 1 and qualidade_geral_maior 8 then yes_alot_appear:2.
% /* id: 3 */
% if yes_alot_appear 2 and no_remodulacao_maior 2003 then yes_alot_appear:3.
% /* id: 4 */
% if yes_alot_appear 3 and basement_square_feet_maior 1432 then yes_alot_appear:4.
% /* id: 5 pontos: 1*/
% if yes_alot_appear 4 and venner_square_feet_maior 142 then yes_alot_appear:5:1.

%resposta um bocado
if menor_igual(qualidade_geral,9) and menor_igual(qualidade_geral,8) and maior(ano_construido,1985) and menor_igual(area_entrada,76) and kitchengd and maior(numero_carros_garagem,0) then just_a_bit_appear:6:1.
% /* id: 1 */
% if qualidade_geral_menor_igual 9 then just_a_bit_appear:1.
% /* id: 2 */
% if just_a_bit_appear 1 and qualidade_geral_menor_igual 8 then just_a_bit_appear:2.
% /* id: 3 */
% if just_a_bit_appear 2 and ano_construido_maior 1985 then just_a_bit_appear:3.
% /* id: 4 */
% if just_a_bit_appear 3 and area_entrada_3season_menor_igual 76 then just_a_bit_appear:4.
% /* id: 5 */
% if just_a_bit_appear 4 and kitchengd then just_a_bit_appear:5.
% /* id: 6 pontos: 1*/
% if just_a_bit_appear 5 and numero_carros_garagem_maior 0 then just_a_bit_appear:6:1.

%resposta nop
if menor_igual(ano_construido,1985)and menor_igual(qualidade_geral,7) and menor_igual(no_remodulacao,2008) then not_rly_appear:5:1.
% /* id: 1 */
% if ano_construido_menor_igual 1985 then not_rly_appear:3.
% /* id: 4 */
% if not_rly_appear 3 and qualidade_geral_menor_igual 7 then not_rly_appear:4.
% /* id: 5 pontos: 1*/
% if not_rly_appear 4 and no_remodulacao_menor_igual 2008 then not_rly_appear:5:1.



/*9º Pergunta*/

%resposta yes i love it
if maior(lot_area,2379) and maior(ano_construido,1971) and rm and menor_igual(qualidade_geral,5) then yes_i_love_it:1:1.
% /* id: 1 */
% if lot_area_maior 2379 then yes_i_love_it:2.
% /* id: 3 */
% if yes_i_love_it 2 and ano_construido_maior 1971 then yes_i_love_it:3.
% /* id: 4 */
% if yes_i_love_it 3 and rm then yes_i_love_it:4.
% /* id: 5 pontos: 1*/
% if yes_i_love_it 4 and qualidade_geral_menor_igual 5 then yes_i_love_it:5:1.

%resposta i prefer the desert
if maior(lot_area,2379) and maior(ano_construido,1971) and rm and maior(qualidade_geral,5) and gtl and maior(ano_garagem_construido,1997) then i_prefer_desert:7:1.
% /* id: 1 */
% if lot_area_maior 2379 then i_prefer_desert:2.
% /* id: 3 */
% if i_prefer_desert 2 and ano_construido_maior 1971 then i_prefer_desert:3.
% /* id: 4 */
% if i_prefer_desert 3 and rm then i_prefer_desert:4.
% /* id: 5 */
% if i_prefer_desert 4 and qualidade_geral_maior 5 then i_prefer_desert:5.
% /* id: 6 */
% if i_prefer_desert 5 and gtl then i_prefer_desert:6.
% /* id: 7 pontos: 1*/
% if i_prefer_desert 6 and ano_garagem_construido_maior 1997 then i_prefer_desert:7:1.

%resposta i prefer beatches
if maior(lot_area,2379) and maior(ano_construido,1971) and rm then i_prefer_beatches:1:1.
% /* id: 1 */
% if lot_area_maior 2379 then i_prefer_beatches:2.
% /* id: 3 */
% if i_prefer_beatches 2 and ano_construido_maior 1971 then i_prefer_beatches:3.
% /* id: 4 pontos: 1*/
% if i_prefer_beatches 3 and rm then i_prefer_beatches:4:1.

%resposta i prefer green areas
%if maior(lot_area,2379) and maior(ano_construido,1971) and fv then i_prefer_green_zones:4:1.
/* id: 1 */
if maior(lot_area,2379) then i_prefer_green_zones:2:0.
/* id: 3 */
if i_prefer_green_zones 2 and maior(ano_construido,1971) then i_prefer_green_zones:3:0.
/* id: 4 pontos: 1*/
if i_prefer_green_zones 3 and fv then i_prefer_green_zones:4:1.


