package cl.uchile.dcc.finalreality.model.weapons

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AxeTest : WeaponTest() {
    override val firstWeaponTest = Axe("Test", 5, 5)
    override val sameWeaponTest = Axe("Test", 5, 5)
    override val differentWeaponTest = Axe("Different", 10, 10)
    @Test
    fun testToString() {
        assertEquals("Axe(name='Test', damage=5, weight=5)", firstWeaponTest.toString())
        assertEquals("Axe(name='Test', damage=5, weight=5)", sameWeaponTest.toString())
        assertEquals("Axe(name='Different', damage=10, weight=10)", differentWeaponTest.toString())
    }
}