package cl.uchile.dcc.cl.uchile.dcc.finalreality.model.weapons.abstract_classes

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

abstract class AbstractWeaponTest {
    val controller: GameController = GameController()
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
    fun testConstructor() {
        assertEquals(firstWeaponTest, sameWeaponTest)
        assertNotEquals(firstWeaponTest, differentWeaponTest)
        assertNotEquals(sameWeaponTest, differentWeaponTest)
    }
    @Test
    fun testEquals() {
        assertEquals(true, firstWeaponTest == firstWeaponTest)
        assertEquals(true, firstWeaponTest == sameWeaponTest)
        assertEquals(false, firstWeaponTest == differentWeaponTest)
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
