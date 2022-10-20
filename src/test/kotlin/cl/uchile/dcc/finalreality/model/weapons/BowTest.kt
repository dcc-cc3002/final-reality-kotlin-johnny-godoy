package cl.uchile.dcc.finalreality.model.weapons

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BowTest : WeaponTest() {
    override val firstWeaponTest = Bow("Test", 5, 5)
    override val sameWeaponTest = Bow("Test", 5, 5)
    override val differentWeaponTest = Bow("Different", 10, 10)
    @Test
    fun testToString() {
        assertEquals("Bow(name='Test', damage=5, weight=5)", firstWeaponTest.toString())
        assertEquals("Bow(name='Test', damage=5, weight=5)", sameWeaponTest.toString())
        assertEquals("Bow(name='Different', damage=10, weight=10)", differentWeaponTest.toString())
    }
}