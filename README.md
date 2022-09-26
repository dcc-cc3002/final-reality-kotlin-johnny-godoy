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
We were asked to create a UML diagram given the problem specification (without the base code from this repo). I created this one (in Spanish):

![First UML diagram](/reports/uml_partial_1.png)

## Partial homework 2
We are asked to study the base code from this repository (in `master`), find design problems and fix them. When looking at the differences between the UML diagrams, I noticed that:

* `Mages` and `Black Mages` may be generalized by an `AbstractMagicWielder`. This has been added to reduce future code replication.
* It is necessary to model `Staffs` in a different way from other weapons, because it is not the responsability of the wielder to check which one it has equipped to do spells. Thus, every weapon has been added as it's own class to avoid future violations of the *Single Responsibility Principle*.

Also, the abstract method `moveTurn` violates the *Dependency Inversion Principle* because it depends on specific implementations of the abstract class. Thus, we create the `delay` abstract method, which is implemented by `Enemy` and `AbstractPlayerCharacter`, and is then used by `moveTurn`.

Also, I did some refactoring:

* Modify `toString` methods in child classes to reuse the code from parents.
* Rename interfaces to have an `I` prefix.
* `PlayerCharacter.kt` is split into more files such that each class has a unique file.

## Final version
With the changes from the previous partial homework, we have the following UML diagrams:

![Second version for weapons](/reports/uml_weapons_final_1.png)
![Second version for characters](/reports/uml_characters_final_1.png)

Which corrects the first partial homework. I also added tests for the second partial homework at `src/kotlin/main.kt`.
