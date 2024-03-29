package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.weapons.abstract_classes.AbstractWeaponTest
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SwordTest : AbstractWeaponTest() {
    override val firstWeaponTest = Sword("Test", 5, 5)
    override val sameWeaponTest = Sword("Test", 5, 5)
    override val differentWeaponTest = Sword("Different", 10, 10)
    @Test
    fun testToString() {
        assertEquals("Sword(name='Test', damage=5, weight=5)", firstWeaponTest.toString())
        assertEquals("Sword(name='Test', damage=5, weight=5)", sameWeaponTest.toString())
        assertEquals("Sword(name='Different', damage=10, weight=10)", differentWeaponTest.toString())
    }
    @Test
    fun equipToKnight() {
        val knight = Knight("Test", 10, 10, controller)
        firstWeaponTest.equipToKnight(knight)
        assertEquals(firstWeaponTest, knight.equippedWeapon)
    }
    @Test
    fun equipToThief() {
        val thief = Thief("Test", 10, 10, controller)
        firstWeaponTest.equipToThief(thief)
        assertEquals(firstWeaponTest, thief.equippedWeapon)
    }
}
