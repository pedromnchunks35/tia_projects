%ARCOS EXISTENTES
arco(l1,l3).
arco(l1,l5).
arco(l1,l6).
arco(l1,l7).
arco(l1,l8).
arco(l3,l4).
arco(l4,l2).
arco(l5,l2).
arco(l6,l2).
arco(l7,l6).
arco(l7,l2).
arco(l8,l3).
arco(l8,l7).
%CUSTO DO SITIO
custo(l1,50).
custo(l3,240).
custo(l4,150).
custo(l5,400).
custo(l6,70).
custo(l7,30).
custo(l8,100).
custo(l2,0).
%CUSTO EM KM
distancia(l1,l3,25).
distancia(l1,l5,100).
distancia(l1,l6,55).
distancia(l1,l7,34).
distancia(l1,l8,55).
distancia(l3,l4,150).
distancia(l4,l2,20).
distancia(l5,l2,25).
distancia(l6,l2,30).
distancia(l7,l6,15).
distancia(l7,l2,40). 
distancia(l8,l3,70).
distancia(l8,l7,25).
/******************************************************************/
% calcula o comprimento de um dado caminho: comprimento(C,N)
%criterio da paragem ,isto é , quando sobra um elemento da lista de caminhos
custo_distancia([_],0). 
%funcao que vai ser iterada que utiliza os 2 primeiros elementos sempre
custo_distancia([X,Y|R],D):-
%voltar a iterar com o resto da lista    
custo_distancia([Y|R],D1), 
%ir buscar a distancia de Y a X (porque a lista esta ao contrário)
distancia(Y,X,Dis), 
%Efetuar a soma e passar o valor para D
D is Dis + D1.
/******************************************************************/

/******************************************************************/
%calcula o custo do alojamento
%criterio de paragem (neste caso é lista vazia porque é 1 a 1)
custo_alojamento([],0). 
%funcao que vai ser iterada
custo_alojamento([X|R],VT):-
%iterar com o resto da lista 
custo_alojamento(R,V1),
%ir buscar o custo de alojamento 
custo(X,V), 
%fazer a soma
VT is V + V1.
/******************************************************************/

/******************************************************************/
% funcao para ir buscar o caminho de X a Z
% funcao inicial de X a Z
caminho(X,Z,C):-caminho(X,Z,[X],C).

%criterio de paragem (Quando chegar ao destino)
caminho(X,X,Caminho,Caminho).

%funcao que vai ser iteraa
caminho(X,Z,Visitado,Caminho):-
%ir buscar o sitio do caminho seguinte 
arco(X,Y),
%verificar se já foi visitado , se já foi nao prossegue , porem se for adiciona á lista
\+ member(Y,Visitado),
%prossegue a iteracao passando o caminho seguinte Y e adiciona á lista dos visitados
caminho(Y,Z,[Y | Visitado],Caminho).
/******************************************************************/