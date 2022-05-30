
:- dynamic(options/5).

quest(Cam1,Cam2,Numiter,Verbose,Probs):-
    assert(options(Cam1,Cam2,Numiter,Verbose,Probs)).
