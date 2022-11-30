package cl.uchile.dcc.finalreality.controller

import cl.uchile.dcc.finalreality.exceptions.FriendlyFireException
import cl.uchile.dcc.finalreality.exceptions.UnequippableWeaponException
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.weapons.Knife
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GameControllerTest {
    private var controller = GameController()
    @Test
    fun constructorTest() {
        // Test all character creators by transitivity
        for ((index, enemy) in controller.enemyCharacters.withIndex()) {
            assertEquals(enemy.weight, 2*(index + 1), "${enemy.name} has wrong weight")
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
        assertThrows(FriendlyFireException::class.java, {controller.attack(enemy, enemy)},"An enemy can't attack another enemy")
        assertThrows(FriendlyFireException::class.java, {controller.attack(thief, thief)},"A player character can't attack another player character")
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