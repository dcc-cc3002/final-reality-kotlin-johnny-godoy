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
We are asked to study the base code from this repository (in `master`), find design problems and fix them.

Design problems have been fixed like such:

* Fix class structure: create an `AbstractMagicWielder` class to generalize `Mages` and `Black Mages`.
* Fix `moveTurn` method: create `delay` abstract method implemented by `Enemy` and `AbstractPlayerCharacter` instead of checking which class the object belongs to - as to adhere to the *Dependency Inversion Principle*.

Also, I implemented some less important refactoring:

* Modify `toString` methods in child classes to reuse the code from parents.
* Rename interfaces to have an `I` prefix.
* `PlayerCharacter.kt` is split into more files such that each class has a unique file

I also noticed a *potential* problem which is yet to be fixed: Staffs work different than other weapons, because they have magic damage.
