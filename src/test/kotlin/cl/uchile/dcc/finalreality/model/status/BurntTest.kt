package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.status.abstract_classes.PassiveDamageTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BurntTest : PassiveDamageTest() {
    override val firstStatus = Burnt(4, controller.enemyCharacters[0])
    override val sameStatus = Burnt(4, controller.enemyCharacters[0])
    override val differentDamage = Burnt(5, controller.enemyCharacters[0])
    override val differentEnemy = Burnt(4, controller.enemyCharacters[1])
    @Test
    fun turnEffect() {
        controller.enemyCharacters[0].status = firstStatus
        controller.waitTurn(controller.enemyCharacters[0])
        assertEquals(8, controller.enemyCharacters[0].currentHp)
    }
}