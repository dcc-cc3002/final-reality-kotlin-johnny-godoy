package cl.uchile.dcc.finalreality.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GameControllerTest {
    private var controller = GameController()

    @Test
    fun constructorTest() {
        for ((index, enemy) in controller.getEnemyCharacters().withIndex()) {
            assertEquals(enemy.weight, 2*(index + 1), "${enemy.name} has wrong weight")
        }
        assertEquals(controller.getEnemyCharacters().size, 5)
        assertEquals(controller.getPlayerCharacters().size, 5)
        assertEquals(controller.getPlayerCharacters()[0].name, "Thief")
        assertEquals(controller.getPlayerCharacters()[1].name, "Knight")
        assertEquals(controller.getPlayerCharacters()[2].name, "Black Mage")
        assertEquals(controller.getPlayerCharacters()[3].name, "White Mage")
        assertEquals(controller.getPlayerCharacters()[4].name, "Engineer")
    }
    @Test
    fun createPlayer() {
    }

    @Test
    fun createEnemy() {
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