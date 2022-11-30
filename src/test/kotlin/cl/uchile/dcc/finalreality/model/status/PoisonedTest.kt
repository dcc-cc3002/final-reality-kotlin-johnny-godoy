package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.status.abstract_classes.StatusTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PoisonedTest : StatusTest() {
    @Test
    fun turnEffect() {
        enemy.status = Burnt(6, enemy)
        enemy.waitTurn()
        assertEquals(7, enemy.currentHp)
    }
}