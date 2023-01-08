package cl.uchile.dcc.finalreality.controller

import cl.uchile.dcc.finalreality.exceptions.FriendlyFireException
import cl.uchile.dcc.finalreality.exceptions.NotEnoughManaException
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.status.Paralyzed
import cl.uchile.dcc.finalreality.model.status.Poisoned
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameControllerTest {
    var controller: GameController = GameController()
    private fun setEnemies() {
        for (i in 1..5) { // Adding enemies to the game
            controller.createEnemy("Enemy $i", 2 * i, 10, 10, 1)
        }
    }
    private fun setPlayers() {
        controller.createThief("Thief", 10, 10, Sword("Knife", 10, 10))
        controller.createKnight("Knight", 10, 10, Knife("Knife", 10, 10))
        controller.createEngineer("Engineer", 10, 10, Bow("Bow", 10, 10))
        controller.createBlackMage("Black Mage", 10, 10, 10, Knife("Knife", 10, 10))
        controller.createWhiteMage("White Mage", 10, 10, 10, Staff("Staff", 10, 10, 4))
    }
    private fun setUp() {
        setEnemies()
        setPlayers()
    }
    @Test
    fun constructorTest() {
        setUp()
        // Test all character creators by transitivity
        for ((index, enemy) in controller.enemyCharacters.withIndex()) {
            assertEquals(enemy.weight, 2 * (index + 1), "${enemy.name} has wrong weight")
        }
        val playerCharacters = controller.playerCharacters
        assertEquals(controller.enemyCharacters.size, 5)
        assertEquals(playerCharacters.size, 5)
        assertEquals(playerCharacters[0].name, "Thief")
        assertEquals(playerCharacters[1].name, "Knight")
        assertEquals(playerCharacters[2].name, "Engineer")
        assertEquals(playerCharacters[3].name, "Black Mage")
        assertEquals(playerCharacters[4].name, "White Mage")
    }
    @Test
    fun attack() {
        val enemy = Enemy("Test", 10, 10, 10, 100, controller)
        val thief = Thief("Test", 10, 10, controller)
        thief.equip(Knife("Test", 15, 10))
        controller.attack(thief, enemy)
        assertEquals(5, enemy.currentHp)
        controller.attack(enemy, thief)
        assertEquals(0, thief.currentHp)
        assertThrows(FriendlyFireException::class.java, { controller.attack(enemy, enemy) }, "An enemy can't attack another enemy")
        assertThrows(FriendlyFireException::class.java, { controller.attack(thief, thief) }, "A player character can't attack another player character")
    }
    @Test
    fun removeEnemy() {
        setEnemies()
        val enemy = Enemy("Test", 10, 10, 10, 100, controller)
        controller.createEnemy("Test", 10, 10, 10, 100)
        assertTrue(controller.enemyCharacters.contains(enemy))
        controller.removeEnemy(enemy)
        assertFalse(controller.enemyCharacters.contains(enemy))
    }
    @Test
    fun removePlayer() {
        setPlayers()
        val thief = Thief("Test", 10, 10, controller)
        controller.createThief("Test", 10, 10, Knife("Test", 10, 10))
        assertTrue(controller.playerCharacters.contains(thief))
        controller.removePlayer(thief)
        assertFalse(controller.playerCharacters.contains(thief))
    }
    @Test
    fun playerWon() {
        setUp()
        controller.createKnight("Test", 10, 10, Knife("Super Knife", 10000, 10))
        val enemyCharactersCopy = controller.enemyCharacters.toMutableList()
        for (enemy in enemyCharactersCopy) {
            controller.attack(controller.playerCharacters[5], enemy)
        }
        assertTrue(controller.playerWon())
    }
    @Test
    fun enemyWon() {
        setUp()
        controller.createEnemy("Super enemy", 10, 10, 10, 10000)
        for (_id in 1..5) {
            controller.enemyAttackRandomPlayer(5)
        }
        assertTrue(controller.enemyWon())
    }
    @Test
    fun useThunder() {
        controller.createEnemy("Test", 10, 10, 10, 100)
        controller.createBlackMage("Test", 10, 20, 10, Staff("Test", 10, 10, 4))
        val enemy = controller.enemyCharacters[0]
        val mage = controller.playerCharacters[0] as BlackMage
        controller.useThunder(mage, enemy)
        assertEquals(6, enemy.currentHp) // 10 - 4 (note: Defense doesn't affect magic damage)
        assertThrows(NotEnoughManaException::class.java, { controller.useThunder(mage, enemy) }, "Used thunder twice without enough mana to do so")
    }
    @Test
    fun useFire() {
        controller.createEnemy("Test", 10, 10, 10, 100)
        controller.createBlackMage("Test", 10, 20, 10, Staff("Test", 10, 10, 4))
        val enemy = controller.enemyCharacters[0]
        val mage = controller.playerCharacters[0] as BlackMage
        controller.useFire(mage, enemy)
        assertEquals(6, enemy.currentHp) // 10 - 4 (note: Defense doesn't affect magic damage)
        assertThrows(NotEnoughManaException::class.java, { controller.useFire(mage, enemy) }, "Used fire twice without enough mana to do so")
    }
    @Test
    fun useHeal() {
        controller.createWhiteMage("Test", 14, 20, 10, Staff("Test", 10, 10, 4))
        val mage = controller.playerCharacters[0] as WhiteMage
        mage.currentHp = 10 // Taking some damage
        controller.useHeal(mage, mage)
        assertEquals(14, mage.currentHp) // 10 + 4
        assertThrows(NotEnoughManaException::class.java, { controller.useHeal(mage, mage) }, "Used heal twice without enough mana to do so")
    }
    @Test
    fun useParalysis() {
        controller.createEnemy("Test", 10, 10, 10, 100)
        controller.createWhiteMage("Test", 10, 30, 10, Staff("Test", 10, 10, 4))
        val enemy = controller.enemyCharacters[0]
        val mage = controller.playerCharacters[0] as WhiteMage
        controller.useParalysis(mage, enemy)
        assertEquals(Paralyzed(enemy), enemy.status)
        assertThrows(NotEnoughManaException::class.java, { controller.useParalysis(mage, enemy) }, "Used paralysis twice without enough mana to do so")
    }
    @Test
    fun usePoison() {
        controller.createEnemy("Test", 10, 10, 10, 100)
        controller.createWhiteMage("Test", 10, 50, 10, Staff("Test", 10, 10, 10))
        val enemy = controller.enemyCharacters[0]
        val mage = controller.playerCharacters[0] as WhiteMage
        controller.usePoison(mage, enemy)
        assertEquals(Poisoned(10, enemy), enemy.status)
        controller.waitTurn(enemy) // Passing a turn for poison to take effect
        assertEquals(7, enemy.currentHp) // 10 - 3 (note: Defense doesn't affect magic damage)
        assertThrows(NotEnoughManaException::class.java, { controller.usePoison(mage, enemy) }, "Used poison twice without enough mana to do so")
    }
}
