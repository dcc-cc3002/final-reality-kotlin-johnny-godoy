package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.status.abstract_classes.StatusTest
import cl.uchile.dcc.finalreality.model.weapons.Knife
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ParalyzedTest : StatusTest() {
    override val firstStatus = Paralyzed( controller.enemyCharacters[0])
    override val sameStatus = Paralyzed( controller.enemyCharacters[0])
    override val differentEnemy = Paralyzed(controller.enemyCharacters[1])
    @Test
    fun turnEffect() {
        val enemy =  controller.enemyCharacters[0]
        enemy.status = firstStatus
        controller.createKnight("knight", 10, 10, Knife("knife", 10, 10))
        val player = controller.playerCharacters[0]
        controller.attack(enemy, player)
        assertEquals(10, player.currentHp)
        controller.waitTurn(enemy)
        assertEquals(NullState(enemy), enemy.status)
    }
}