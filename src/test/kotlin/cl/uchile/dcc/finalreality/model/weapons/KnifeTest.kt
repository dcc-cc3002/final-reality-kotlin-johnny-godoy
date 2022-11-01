package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.weapons.abstract_classes.AbstractWeaponTest
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class KnifeTest : AbstractWeaponTest() {
    override val firstWeaponTest = Knife("Test", 5, 5)
    override val sameWeaponTest = Knife("Test", 5, 5)
    override val differentWeaponTest = Knife("Different", 10, 10)
    @Test
    fun testToString() {
        assertEquals("Knife(name='Test', damage=5, weight=5)", firstWeaponTest.toString())
        assertEquals("Knife(name='Test', damage=5, weight=5)", sameWeaponTest.toString())
        assertEquals("Knife(name='Different', damage=10, weight=10)", differentWeaponTest.toString())
    }
    @Test
    fun equipToThief() {
        val thief = Thief("Test", 10, 10, turns)
        firstWeaponTest.equipToThief(thief)
        assertEquals(firstWeaponTest, thief.equippedWeapon)
    }
    @Test
    fun equipToBlackMage() {
        val blackMage = BlackMage("Test", 10, 10, 10, turns)
        firstWeaponTest.equipToBlackMage(blackMage)
        assertEquals(firstWeaponTest, blackMage.equippedWeapon)
    }
    @Test
    fun equipToKnight() {
        val knight = Knight("Test", 10, 10, turns)
        firstWeaponTest.equipToKnight(knight)
        assertEquals(firstWeaponTest, knight.equippedWeapon)
    }
}
