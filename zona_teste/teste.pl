% A simple backward chaining rule interpreter
:- op( 800, fx, if).
:- op( 700, xfx, then).
:- op( 300, xfy, or).
:- op( 200, xfy, and).


fact(ex).
fact(gd).

exp(V:X):-
    fact(V),
    write(X).

exp(V1:X1):-
    fact(V1),
    write(X1).


exp(V and X):-
    exp(V),
    exp(X).
