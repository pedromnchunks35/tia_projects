path(A,B,D,V,Caminho):-caminho(A,B,Caminho),custo_distancia(Caminho,D),custo_alojamento(Caminho,V), V =< 450.

findapath(A,B,Custo,C):-path(A,B,D,V,C), Custo is D + V.

:-dynamic(solucao/2).
findminpath(X, Y, W, P) :- \+ solucao(_, _),
                           findapath(X, Y, W1, P1),
                           assertz(solucao(W1, P1)),
                           !,
                           findminpath(X,Y,W,P).

findminpath(X, Y, _, _) :- findapath(X, Y, W1, P1),
                           solucao(W2, P2),
                           W1 < W2,
                           retract(solucao(W2, P2)),
                           asserta(solucao(W1, P1)),
                           fail.

findminpath(_, _, W, P) :- solucao(W,P), retract(solucao(W,P)).
