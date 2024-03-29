package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.weapons.abstract_classes.AbstractWeaponTest
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AxeTest : AbstractWeaponTest() {
    override val firstWeaponTest = Axe("Test", 5, 5)
    override val sameWeaponTest = Axe("Test", 5, 5)
    override val differentWeaponTest = Axe("Different", 10, 10)
    @Test
    fun testToString() {
        assertEquals("Axe(name='Test', damage=5, weight=5)", firstWeaponTest.toString())
        assertEquals("Axe(name='Test', damage=5, weight=5)", sameWeaponTest.toString())
        assertEquals("Axe(name='Different', damage=10, weight=10)", differentWeaponTest.toString())
    }
    @Test
    fun equipToKnight() {
        val knight = Knight("Test", 10, 10, controller)
        firstWeaponTest.equipToKnight(knight)
        assertEquals(firstWeaponTest, knight.equippedWeapon)
    }
    @Test
    fun equipToEngineer() {
        val engineer = Engineer("Test", 10, 10, controller)
        firstWeaponTest.equipToEngineer(engineer)
        assertEquals(firstWeaponTest, engineer.equippedWeapon)
    }
}
