package cl.uchile.dcc.finalreality.model.weapons

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class KnifeTest : WeaponTest() {
    override val firstWeaponTest = Knife("Test", 5, 5)
    override val sameWeaponTest = Knife("Test", 5, 5)
    override val differentWeaponTest = Knife("Different", 10, 10)

    @Test
    fun testToString() {
        assertEquals("Knife(name='Test', damage=5, weight=5)", firstWeaponTest.toString())
        assertEquals("Knife(name='Test', damage=5, weight=5)", sameWeaponTest.toString())
        assertEquals("Knife(name='Different', damage=10, weight=10)", differentWeaponTest.toString())
    }
}