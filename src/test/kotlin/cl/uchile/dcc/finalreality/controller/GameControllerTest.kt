package cl.uchile.dcc.finalreality.controller

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GameControllerTest {
    private var controller = GameController()
    @Test
    fun constructorTest() {
        for ((index, enemy) in controller.enemyCharacters.withIndex()) {
            assertEquals(enemy.weight, 2*(index + 1), "${enemy.name} has wrong weight")
        }
        val playerCharacters = controller.playerCharacters
        assertEquals(controller.enemyCharacters.size, 5)
        assertEquals(playerCharacters.size, 5)
        assertEquals(playerCharacters[0].name, "Thief")
        assertEquals(playerCharacters[1].name, "Knight")
        assertEquals(playerCharacters[2].name, "Black Mage")
        assertEquals(playerCharacters[3].name, "White Mage")
        assertEquals(playerCharacters[4].name, "Engineer")
    }
    @Test
    fun createEnemy() {
        val expectedEnemy = Enemy("Test", 10, 10, 10, controller.turnsQueue)
        controller.createEnemy("Test", 10, 10, 10)
        val lastIndex = controller.enemyCharacters.size - 1
        assertEquals(controller.enemyCharacters[lastIndex], expectedEnemy)
    }
    private fun testPlayerCreation(expectedPlayer: IGameCharacter) {
        val lastIndex = controller.playerCharacters.size - 1
        assertEquals(controller.playerCharacters[lastIndex], expectedPlayer)
    }
    @Test
    fun createThief() {
        val expectedThief = Thief("Test", 10, 10, controller.turnsQueue)
        controller.createThief("Test", 10, 10)
        testPlayerCreation(expectedThief)
    }
    @Test
    fun createKnight() {
        val expectedKnight = Knight("Test", 10, 10, controller.turnsQueue)
        controller.createKnight("Test", 10, 10)
        testPlayerCreation(expectedKnight)
    }
    @Test
    fun createBlackMage() {
        val expectedBlackMage = BlackMage("Test", 10, 10, 10, controller.turnsQueue)
        controller.createBlackMage("Test", 10, 10, 10)
        testPlayerCreation(expectedBlackMage)
    }
    @Test
    fun createWhiteMage() {
        val expectedWhiteMage = WhiteMage("Test", 10, 10, 10, controller.turnsQueue)
        controller.createWhiteMage("Test", 10, 10, 10)
        testPlayerCreation(expectedWhiteMage)
    }
    @Test
    fun createEngineer() {
        val expectedEngineer = Engineer("Test", 10, 10, controller.turnsQueue)
        controller.createEngineer("Test", 10, 10)
        testPlayerCreation(expectedEngineer)
    }
    @Test
    fun attack() {
    }

    @Test
    fun useMagic() {
    }

    @Test
    fun waitTurn() {

    }

    @Test
    fun onPlayerWin() {
    }

    @Test
    fun onEnemyWin() {
    }
}