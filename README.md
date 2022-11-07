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

* `Mages` and `Black Mages` may be generalized by an `AbstractMagicWielder`. This has been added to reduce future code duplication.
* It is necessary to model `Staffs` in a different way from other weapons, because the wielder shouldn't have to check what it has equipped to do spells. Thus, every weapon has been added as its own class to avoid future violations of encapsulation.

Also, the abstract method `moveTurn` violates the *Dependency Inversion Principle* because it depends on specific implementations of the abstract class. Thus, we create the `delay` abstract method, which is implemented by `Enemy` and `AbstractPlayerCharacter`, and is then used by `moveTurn`.

Finally, I did some small refactoring:

* Modify `toString` methods in child classes to reuse the code from parents.
* Rename interfaces to have an `I` prefix.
* `PlayerCharacter.kt` is split into more files such that each class has a unique file.

## Final version
With the changes from the previous partial homework, we have the following UML diagrams:

![Second version for weapons](/reports/uml_weapons_final_1.png)
![Second version for characters](/reports/uml_characters_final_1.png)

Which corrects the first partial homework. I also added tests for the second partial homework at `test/kotlin/main.kt`.
Just run this file to see the results.

---

# Homework 2
## Partial homework 3
At this point, we implement tests for every class with JUnit, reaching 99% test coverage. These are all available in the `test/kotlin/` directory, where you can verify 100% passed.

When doing this, I noticed a few improvements to the character modelling, such as:

* The `delay` method is now public and a part of the `IGameCharacter` interface
* `IPlayerCharacter` now inherits from `IGameCharacter`
* Create the `IMagicWielder` interface, which inherits from `IPlayerCharacter`, and is implemented by `AbstractMagicWielder`

Giving us the updated UML diagram:

![Third version for characters](/reports/uml_characters_partial_3.png)
## Partial homework 4
We are asked to implement restrictions to which weapons can be equipped to a character. 
To do this, the `equip` method of the `AbstractPlayerCharacter` takes an `IWeapon` parameter and throws an `UnequippableWeaponException` exception.
Then, each character of type `X` overloads the `equip` method to take a weapon which implements the `EquippableByX` interface, and properly equips it.
This guarantees that only the correct weapons can be equipped to a character, while `playerCharacter.equip(weapon)` always compiles.

All new features have been tested in the `test/kotlin/` directory, holding still 99% test coverage. The updated UML diagram is:
![Fourth version for characters](/reports/uml_characters_partial_4.png)
![Fourth version for weapons](/reports/uml_weapons_partial_4.png)

## Final version
Nothing is added, as the requirements are met from the partial versions.
