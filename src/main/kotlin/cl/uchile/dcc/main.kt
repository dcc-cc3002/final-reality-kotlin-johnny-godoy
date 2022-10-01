package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import java.util.concurrent.LinkedBlockingQueue

/**
 * A function for preliminar testing for the grading assistants.
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
fun main() {
    // Testing each weapon's constructor
    println("Creating an example for each weapon type...")
    val sword = Sword("Excalibur", 10, 15)
    val axe = Axe("Giant's Axe", 12, 20)
    val bow = Bow("Longbow", 8, 25)
    val knife = Knife("Shadow Dagger", 6, 30)
    val staff = Staff("Staff of Wisdom", 4, 35, 10)
    // Printing each weapon's info
    println("Every weapon was properly created. Now printing their info.")
    println(sword)
    println(axe)
    println(bow)
    println(knife)
    println(staff)
    // Testing each weapon's getters
    println("Now testing the weapon's getters...")
    println("Sword's name: ${sword.name}")
    println("Axe's damage: ${axe.damage}")
    println("Bow's weight: ${bow.weight}")
    println("Staff's magic damage: ${staff.magicDamage}")
    // Creating player characters
    println("Creating player characters...")
    val queue = LinkedBlockingQueue<IGameCharacter>()
    val blackMage = BlackMage("Rick", 100, 10, 10, queue)
    val engineer = Engineer("yoni godoi", 100, 10, queue)
    val knight = Knight("Esteban el del mine craft", 100, 10, queue)
    val thief = Thief("Funny politician name", 100, 10, queue)
    val whiteMage = WhiteMage("Gandalf", 100, 10, 10, queue)
    // Testing each character's getters
    println("Now testing the character's getters...")
    println("Black Mage's name: ${blackMage.name}")
    println("Engineer's maxHp: ${engineer.maxHp}")
    println("Knight's defense: ${knight.defense}")
    println("Thief's current HP: ${thief.currentHp}")
    println("White Mage's max mana: ${whiteMage.maxMp}")
    println("Black Mage's current mana: ${blackMage.currentMp}")
    // Creating 3 enemies
    println("Creating 3 enemies...")
    val heavyEnemy = Enemy("Heavy enemy", 100, 10, 10, queue)
    val lightEnemy = Enemy("Light enemy", 30, 10, 10, queue)
    val mediumEnemy = Enemy("Medium enemy", 50, 10, 10, queue)
    // Testing each enemy's getters
    println("Now testing the enemy's getters...")
    println("Heavy enemy's name: ${heavyEnemy.name}")
    println("Light enemy's maxHp: ${lightEnemy.maxHp}")
    println("Medium enemy's defense: ${mediumEnemy.defense}")
    println("Heavy enemy's current HP: ${heavyEnemy.currentHp}")
    // Equipping weapons (disregarding the character's class)
    blackMage.equip(knife)
    blackMage.waitTurn()
    engineer.equip(bow)
    engineer.waitTurn()
    knight.equip(sword)
    knight.waitTurn()
    thief.equip(axe)
    thief.waitTurn()
    whiteMage.equip(staff)
    whiteMage.waitTurn()
    heavyEnemy.waitTurn()
    lightEnemy.waitTurn()
    mediumEnemy.waitTurn()
    // Pop and print the names of the characters of the queue to illustrate the turns order
    println("Now printing the names of the characters in the queue to illustrate the turns order...")
    Thread.sleep(10000)
    while (!queue.isEmpty()) {
        val character = queue.poll()
        println("Character: $character.")
        if (character is AbstractPlayerCharacter) { // Only player characters have equipped weapons.
            println("Equipped weapon: ${character.equippedWeapon}.")
        }
        else {
            println("Equipped weapon: None.")
        }
    }
    println("The queue is empty. Testing finished.")
}