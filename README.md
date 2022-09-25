Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of
enemies controlled by the computer.

---

# Homework 1

## Partial homework 1
We were asked to create a UML diagram given the problem specification (without the base code from this repo). We created this one (in Spanish):

![First UML diagram](/reports/uml_partial_1.png)

## Partial homework 2
We are asked to study the base code from this repository (in `master`), find design problems and fix them. Currently, the following code changes have been implemented:

* Created an `AbstractMagicWielder` class to generalize `Mages` and `Black Mages`.
* Modified `toString` methods in child classes to reuse the code from parents. Now it gets the class name at runtime.
