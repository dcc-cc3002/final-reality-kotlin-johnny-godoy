package cl.uchile.dcc.finalreality.model.status.abstract_classes

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.status.interfaces.IState
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

abstract class StatusTest {
    val controller: GameController = GameController()
    val enemy: Enemy = controller.enemyCharacters[0]
    abstract val firstStatus: IState
    abstract val sameStatus: IState
    abstract val differentEnemy: IState
    @Test
    open fun testEquals() {
        assertEquals(firstStatus, sameStatus)
        assertNotEquals(firstStatus, differentEnemy)
    }
}