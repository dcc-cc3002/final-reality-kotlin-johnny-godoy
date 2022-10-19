package cl.uchile.dcc.finalreality.model.weapons

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

abstract class WeaponTest {
    abstract val firstWeaponTest: IWeapon
    abstract val sameWeaponTest: IWeapon
    abstract val differentWeaponTest: IWeapon
    @Test
    fun getDamage() {
        assertEquals(5, firstWeaponTest.damage)
        assertEquals(5, sameWeaponTest.damage)
        assertEquals(10, differentWeaponTest.damage)
    }

    @Test
    fun getWeight() {
        assertEquals(5, firstWeaponTest.weight)
        assertEquals(5, sameWeaponTest.weight)
        assertEquals(10, differentWeaponTest.weight)
    }

    @Test
    fun testEquals() {
        assertEquals(firstWeaponTest, sameWeaponTest)
        assertNotEquals(firstWeaponTest, differentWeaponTest)
        assertNotEquals(sameWeaponTest, differentWeaponTest)
    }

    @Test
    fun testHashCode() {
        assertEquals(firstWeaponTest.hashCode(), sameWeaponTest.hashCode())
        assertNotEquals(firstWeaponTest.hashCode(), differentWeaponTest.hashCode())
        assertNotEquals(sameWeaponTest.hashCode(), differentWeaponTest.hashCode())
    }

    @Test
    fun getName() {
        assertEquals("Test", firstWeaponTest.name)
        assertEquals("Test", sameWeaponTest.name)
        assertEquals("Different", differentWeaponTest.name)
    }
}