Conway's Game of Life Experiments
======

Inspired by Coderetreat Glasgow 2012 -- but no code was taken out of the retreat, as per the rules we deleted everything after each iteration.

* _java-functional_ is a recursive definition of each cell's state in a single function, leading a very short implementation. Inspired by the approach taken by my pair programming partner (Geoff) in the morning and reproduced by applying more tests after the event. It seems to me to be a very elegant way of solving the problem, but performance is exponential wiht the iteration number, so computing more than the first 5 or 6 iterations is not really feasible.
