package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.weapons.abstract_classes.AbstractWeaponTest
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StaffTest : AbstractWeaponTest() {
    override val firstWeaponTest = Staff("Test", 5, 5, 5)
    override val sameWeaponTest = Staff("Test", 5, 5, 5)
    override val differentWeaponTest = Staff("Different", 10, 10, 10)
    @Test
    fun testToString() {
        assertEquals("Staff(name='Test', damage=5, weight=5, magicDamage=5)", firstWeaponTest.toString())
        assertEquals("Staff(name='Test', damage=5, weight=5, magicDamage=5)", sameWeaponTest.toString())
        assertEquals("Staff(name='Different', damage=10, weight=10, magicDamage=10)", differentWeaponTest.toString())
    }
    @Test
    fun getMagicDamage() {
        assertEquals(5, firstWeaponTest.magicDamage)
        assertEquals(5, sameWeaponTest.magicDamage)
        assertEquals(10, differentWeaponTest.magicDamage)
    }
    @Test
    fun equipToBlackMage() {
        val blackMage = BlackMage("Test", 10, 10, 10, turns)
        firstWeaponTest.equipToBlackMage(blackMage)
        assertEquals(firstWeaponTest, blackMage.equippedWeapon)
    }
    @Test
    fun equipToWhiteMage() {
        val whiteMage = WhiteMage("Test", 10, 10, 10, turns)
        firstWeaponTest.equipToWhiteMage(whiteMage)
        assertEquals(firstWeaponTest, whiteMage.equippedWeapon)
    }
}
