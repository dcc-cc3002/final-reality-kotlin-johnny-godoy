package cl.uchile.dcc.finalreality.model.weapons

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SwordTest : WeaponTest() {
    override val firstWeaponTest = Sword("Test", 5, 5)
    override val sameWeaponTest = Sword("Test", 5, 5)
    override val differentWeaponTest = Sword("Different", 10, 10)
    @Test
    fun testToString() {
        assertEquals("Sword(name='Test', damage=5, weight=5)", firstWeaponTest.toString())
        assertEquals("Sword(name='Test', damage=5, weight=5)", sameWeaponTest.toString())
        assertEquals("Sword(name='Different', damage=10, weight=10)", differentWeaponTest.toString())
    }
}
