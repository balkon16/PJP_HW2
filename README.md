# Introduction

This is the second homework in Programming Languages Practice course which is dedicated to learning Groovy. Other repositories
you may be interested in:
* [Homework no. 1](https://github.com/balkon16/PJP_HW1)

# Exercise no. 1

Solution for the exercise no. 1 is located in the `src/zad1` package. The aim of the exercise is to accept an input string
from the user. The script tries to parse the user input into a list of integers. If all entries are correct, a list of integers
is returned. If the input string contains at least one incorrect representation of the *Integer* type a list of incorrect entries 
is returned.

# Exercise no. 2
Solution for the exercise no. 2 is located in teh `src/zad2` package. The aim of the exercise is to generalize the `getInts`
function which is described in the `src/zad1` module). The generalized function should handle `String`s (the default case), `Integer`s, 
and `BigDecimal`s. Additionally, it should accept an optional closure used for filtering elements.