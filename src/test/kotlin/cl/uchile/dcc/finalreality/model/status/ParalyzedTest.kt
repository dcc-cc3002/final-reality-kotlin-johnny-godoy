package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.status.abstract_classes.StatusTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ParalyzedTest : StatusTest() {
    override val firstStatus = Paralyzed(enemy)
    override val sameStatus = Paralyzed(enemy)
    override val differentEnemy = Paralyzed(controller.enemyCharacters[1])
    @Test
    fun turnEffect() {
        enemy.status = firstStatus
        val player = controller.playerCharacters[0]
        controller.attack(enemy, player)
        assertEquals(10, player.currentHp)
        enemy.waitTurn()
        assertEquals(NullState(enemy), enemy.status)
    }
}