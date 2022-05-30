/******************************************************************/
%criterio de paragem , ou seja quando só tiver um elemento
eval([_],0).
%juntar custos
eval(L,E):-
	%custo alojamento 
	custo_alojamento(L,CA),
	%custo distancia
	custo_distancia(L,CD),
	%somar custos 
	E is CA + CD.
/******************************************************************/

/******************************************************************/
%ir verificar a solucao
change(S, SNEW,[Cam1,Cam2]):-
	%ir buscar todas as solucoes de l1 a l2 cujo preco é inferior a 450
    findall(X,(caminho(Cam1,Cam2,X),custo_alojamento(X,C),C =< 450),L), 
	%verificar tamanho de lista
	length(L,LE),
	%buscar posi na lista random 
	random(0,LE,R),
	%ir buscar elemento atraves dessa posi random 
	nth0(R,L,SNEW),
	%verificar se as listas sao diferentes
     dif(SNEW,S).
/******************************************************************/

/******************************************************************/
%init da funcao hill climbing , passamos solucao inicial , numero de iteracoes , probs e o tipo de func 
demo(Cam1,Cam2,Numiter,Verbose,Prob,Resultado):-
	findall(X,(caminho(Cam1,Cam2,X),custo_alojamento(X,C),C =< 450),L),  
	length(L,Lengthsol),
	Lengthsol >= 2,
	nth0(0,L,K),
	hill_climbing(K,[Numiter,Verbose,Prob,min],[Cam1,Cam2],S),
	write(S),
	Resultado=S.
/******************************************************************/
% assumes eval(Solution,Result)
% assumes change(S1,S2)
/******************************************************************/
% return SR, the best value of S1 and S2: SR (solution) and ER (eval)
best(Prob,Opt,S1,E1,S2,E2,SR,ER):-
	eval(S2,E2),
	best_opt(Prob,Opt,S1,E1,S2,E2,SR,ER).

best_opt(Prob,_,_,_,S2,E2,S2,E2):-
	random(X), % random from 0 to 1,
	X< Prob. % accept new solution

best_opt(_,Opt,S1,E1,S2,E2,SR,ER):- % else, select the best one
    ( (Opt=max,max_list([E1,E2],ER));(Opt=min,min_list([E1,E2],ER)) ),
    ( (ER==E1,SR=S1); (ER==E2,SR=S2) ).

% show evolution:
show(final,Verbose,S1,E1,_,_):-
	 Verbose>0,
	 write('final:'),write(' S:'),write(S1),write(' E:'),write(E1),nl.
show(0,Verbose,S1,E1,_,_):-
	Verbose>0,
	write('init:'),write(' S0:'),write(S1),write(' E0:'),write(E1),nl.
show(I,Verbose,S1,E1,S2,E2):-
	0 is I mod Verbose,
	write('iter:'),write(I),write(' S1:'),write(S1),write(' E1:'),
	write(E1),write(' S2:'),write(S2),write(' E2:'),write(E2),nl.
show(_,_,_,_,_,_).

% hill climbing
% Prob=0 is pure hill climbing, Prob>0 means Stochastic Hill Climbing
% S0 is the initial solution, Control is a list with the number of iterations, verbose in console, probability and type of optimization.
hill_climbing(S0,[Iter,Verbose,Prob,Opt],[Cam1,Cam2],S1):-
	eval(S0,E0),
        show(0,Verbose,S0,E0,_,_),
	hill_climbing(S0,E0,0,Iter,Verbose,Prob,Opt,[Cam1,Cam2],S1).

hill_climbing(S,_,Iter,Iter,_,_,_,_,S).
hill_climbing(S1,E1,I,Iter,Verbose,Prob,Opt,[Cam1,Cam2],SFinal):-
	change(S1,SNew,[Cam1,Cam2]),
	best(Prob,Opt,S1,E1,SNew,_,S2,E2),
	I1 is I+1,
        show(I1,Verbose,S1,E1,S2,E2),
	hill_climbing(S2,E2,I1,Iter,Verbose,Prob,Opt,[Cam1,Cam2],SFinal).
/******************************************************************/