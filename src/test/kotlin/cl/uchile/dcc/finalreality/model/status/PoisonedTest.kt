package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.status.abstract_classes.PassiveDamageTest
import cl.uchile.dcc.finalreality.model.status.abstract_classes.StatusTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PoisonedTest : PassiveDamageTest() {
    override val firstStatus = Poisoned(6, enemy)
    override val sameStatus = Poisoned(6, enemy)
    override val differentDamage = Poisoned(5, enemy)
    override val differentEnemy = Poisoned(6, controller.enemyCharacters[1])
    @Test
    fun turnEffect() {
        enemy.status = firstStatus
        enemy.waitTurn()
        assertEquals(8, enemy.currentHp)
    }
}