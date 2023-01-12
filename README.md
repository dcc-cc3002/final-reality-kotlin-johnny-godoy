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

# Homework 1: Introduction to the model

## Partial homework 1: UML Diagrams
We were asked to create a UML diagram given the problem specification (without the base code from this repo). I created this one (in Spanish):

![First UML diagram](/reports/uml_partial_1.png)

## Partial homework 2: Fixing design issues
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

Which corrects the first partial homework.
---

# Homework 2: Weapons and characters with Test Driven Development
## Partial homework 3: Implementing tests
At this point, we implement tests for every class with JUnit, reaching 99% test coverage. These are all available in the `test/kotlin/` directory, where you can verify 100% passed.

When doing this, I noticed a few improvements to the character modelling, such as:

* The `delay` method is now public and a part of the `IGameCharacter` interface
* `IPlayerCharacter` now inherits from `IGameCharacter`
* Create the `IMagicWielder` interface, which inherits from `IPlayerCharacter`, and is implemented by `AbstractMagicWielder`

Giving us the updated UML diagram:

![Third version for characters](/reports/uml_characters_partial_3.png)
## Partial homework 4: Implementing the equip method
We are asked to implement restrictions to which weapons can be equipped to a character. 
To do this, the `equip` method of the `AbstractPlayerCharacter` takes an `IWeapon` parameter and throws an `UnequippableWeaponException` exception.
Then, each character of type `X` overloads the `equip` method to take a weapon which implements the `EquippableByX` interface, and properly equips it.
This guarantees that only the correct weapons can be equipped to a character, while `playerCharacter.equip(weapon)` always compiles.

All new features have been tested in the `test/kotlin/` directory, holding still 99% test coverage. The updated UML diagram is:
![Fourth version for characters](/reports/uml_characters_partial_4.png)
![Fourth version for weapons](/reports/uml_weapons_partial_4.png)

## Final version
Nothing is added, as the requirements are met from the partial versions.

---

# Homework 3: Finishing the model, and starting the controller.
I did not do anything apart from the first partial homework, as I was not able to finish it in time.
Only what was implemented will be shown here.

We are asked to implement the controller class `GameController`, which is the class that interacts with the models.
It is responsible for:
* Handling the queue for the turns of the characters
* Handling the list of all living characters, both enemies and players
* Creating the characters, weapons and enemies
* Telling a character to attack or cast a spell targeting another character
* Telling an enemy to attack a random player character

In order to do this, the controller must know when characters die, to remove them from the queue and the list of living characters.
To do this, we implement an Observer pattern, where the `GameController` is the observer, and the `IGameCharacter` is the subject.
When a character dies, it notifies the controller, which removes the character from the queue and the list of living characters.

Note that the `GameController` could also be a singleton, but I decided to make it a normal class to avoid coupling.
It also determines victory (resp. loss) conditions for the player, by checking if the list of alive enemies (resp. players) is empty.

To make magicians cast spells, we added new methods. Black mages can cast fire and thunder spells,
while white mages can cast cure, paralyze and poison spells. 
This is done with double dispatch, where the spell receiver implement `receiveX(magicWielder)` method for each `castX(enemy)` the magic wielder implements.
For attacks, the receiver is an `Enemy`, whereas for the healing spell, the receiver is a `PlayerCharacter`.

Spells can't be used if the wielder doesn't have enough mana, a `SpellFailedException` is thrown if attempted. It can't target dead enemies either, but that will be handled by the controller. Mages are able to use spells when not wielding a staff, but their `magicDamage` attribute is set to 0, meaning they cannot inflict damage, but can inflict a status or heal an ally.

For thunder, fire and poison spells, we need to implement status effects (paralyze, poison and burn).
These are implemented as States, where the `Enemy` is the context, and the status effect is the state.
The enemy has a `status` field, which is an implementation of `IState`, and every turn, the enemy calls `status.turnEffect` to apply the effect of the status.
It also calls `status.attack` every time the enemy attacks, to apply damage reductions or cancellations (for example, if the enemy is paralyzed, it cannot attack).
To deal with enemies without a status, we create a Null Object pattern, where the `NullState` is the null object, and the `Enemy` has a `NullState` as a status by default.

For every method, we have tests in the `test/kotlin/` directory, holding 95% test coverage. The updated UML diagram is:

![Fifth version for characters](/reports/uml_characters_final_3.png)
![First version for states](/reports/uml_states_final_3.png)

Weapons did not change significantly, other than the addition of a `magicDamage` attribute defaulted to 0 for non-staffs.
