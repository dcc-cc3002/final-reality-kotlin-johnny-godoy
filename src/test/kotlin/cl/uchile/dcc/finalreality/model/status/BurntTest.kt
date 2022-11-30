package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.status.abstract_classes.PassiveDamageTest
import cl.uchile.dcc.finalreality.model.status.abstract_classes.StatusTest
import cl.uchile.dcc.finalreality.model.status.interfaces.IState
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BurntTest : PassiveDamageTest() {
    override val firstStatus = Burnt(4, enemy)
    override val sameStatus = Burnt(4, enemy)
    override val differentDamage = Burnt(5, enemy)
    override val differentEnemy = Burnt(4, controller.enemyCharacters[1])
    @Test
    fun turnEffect() {
        enemy.status = firstStatus
        enemy.waitTurn()
        assertEquals(8, enemy.currentHp)
    }
}