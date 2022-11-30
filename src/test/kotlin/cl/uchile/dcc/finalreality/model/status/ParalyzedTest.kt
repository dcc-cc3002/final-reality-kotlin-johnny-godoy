package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.status.abstract_classes.StatusTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ParalyzedTest : StatusTest() {

    @Test
    fun turnEffect() {
        enemy.status = Paralyzed(enemy)
        val player = controller.playerCharacters[0]
        controller.attack(enemy, player)
        assertEquals(10, player.currentHp)
        enemy.waitTurn()
        assertEquals(NullState(enemy), enemy.status)
    }
}