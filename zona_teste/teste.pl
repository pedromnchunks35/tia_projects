% A simple backward chaining rule interpreter
:- op( 800, fx, if).
:- op( 700, xfx, then).
:- op( 300, xfy, or).
:- op( 200, xfy, and).


fact(ex).
fact(gd).

exp(V:overall):-
    fact(V),
    write("Deu").

exp(V1:overall):-
    fact(V1),
    write("Deu").


exp(V:overall and V1:overall:X):-
    exp(V:overall),
    exp(V1:overall).
    exp(X).
