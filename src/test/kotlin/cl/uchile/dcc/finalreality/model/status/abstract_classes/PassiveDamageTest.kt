package cl.uchile.dcc.finalreality.model.status.abstract_classes
import cl.uchile.dcc.finalreality.model.status.interfaces.IState
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


abstract class PassiveDamageTest : StatusTest() {
    abstract val differentDamage: IState
    @Test
    override fun testEquals() {
        super.testEquals()
        assertNotEquals(firstStatus, differentDamage)
    }
}