package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.weapons.abstract_classes.AbstractWeaponTest
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Thief
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BowTest : AbstractWeaponTest() {
    override val firstWeaponTest = Bow("Test", 5, 5)
    override val sameWeaponTest = Bow("Test", 5, 5)
    override val differentWeaponTest = Bow("Different", 10, 10)
    @Test
    fun testToString() {
        assertEquals("Bow(name='Test', damage=5, weight=5)", firstWeaponTest.toString())
        assertEquals("Bow(name='Test', damage=5, weight=5)", sameWeaponTest.toString())
        assertEquals("Bow(name='Different', damage=10, weight=10)", differentWeaponTest.toString())
    }
    @Test
    fun equipToEngineer() {
        val engineer = Engineer("Test", 10, 10, turns)
        firstWeaponTest.equipToEngineer(engineer)
        assertEquals(firstWeaponTest, engineer.equippedWeapon)
    }
    @Test
    fun equipToThief() {
        val thief = Thief("Test", 10, 10, turns)
        firstWeaponTest.equipToThief(thief)
        assertEquals(firstWeaponTest, thief.equippedWeapon)
    }
}
