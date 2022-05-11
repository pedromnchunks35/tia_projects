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

custo(l1,50).
custo(l3,240).
custo(l4,150).
custo(l5,400).
custo(l6,70).
custo(l7,30).
custo(l8,100).
custo(l2,0).

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

% calcula o comprimento de um dado caminho: comprimento(C,N)
custo_distancia([_],0). 
custo_distancia([X,Y|R],D):- custo_distancia([Y|R],D1), distancia(Y,X,Dis), D is Dis + D1.

custo_alojamento([],0). 
custo_alojamento([X|R],VT):- custo_alojamento(R,V1), custo(X,V), VT is V + V1.

% caminho.pl
caminho(X,Z,C):-caminho(X,Z,[X],C).
caminho(X,X,Caminho,Caminho).
caminho(X,Z,Visitado,Caminho):- arco(X,Y),\+ member(Y,Visitado),caminho(Y,Z,[Y | Visitado],Caminho).