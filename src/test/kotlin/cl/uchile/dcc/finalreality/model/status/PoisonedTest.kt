package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.status.abstract_classes.PassiveDamageTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PoisonedTest : PassiveDamageTest() {
    override val firstStatus = Poisoned(6, controller.enemyCharacters[0])
    override val sameStatus = Poisoned(6, controller.enemyCharacters[0])
    override val differentDamage = Poisoned(5, controller.enemyCharacters[0])
    override val differentEnemy = Poisoned(6, controller.enemyCharacters[1])
    @Test
    fun turnEffect() {
        val enemy = controller.enemyCharacters[0]
        enemy.status = firstStatus
        controller.waitTurn(enemy)
        assertEquals(8, enemy.currentHp)
    }
}
