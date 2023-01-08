package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractMagicWielderTest
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BlackMageTest : AbstractMagicWielderTest() {
    override val firstCharacterTest = BlackMage("Test", 5, 10, 0, controller)
    override val sameCharacterTest = BlackMage("Test", 5, 10, 0, controller)
    override val differentCharacterTest = BlackMage("Different", 10, 20, 10, controller)
    override val lightWeapon = Staff("Light", 10, 20, 10)
    override val lightWeapon2 = Staff("Light", 10, 20, 10)
    override val heavyWeapon = Knife("Heavy", 10, 30)
    @BeforeEach
    fun setup() {
        firstCharacterTest.equip(lightWeapon)
        sameCharacterTest.equip(lightWeapon2)
        differentCharacterTest.equip(heavyWeapon)
    }
    @Test
    fun testToString() {
        assertEquals("BlackMage(name='Test', maxHp=5, defense=0, currentHp=5, maxMp=10, currentMp=10)", firstCharacterTest.toString())
        assertEquals("BlackMage(name='Test', maxHp=5, defense=0, currentHp=5, maxMp=10, currentMp=10)", sameCharacterTest.toString())
        assertEquals("BlackMage(name='Different', maxHp=10, defense=10, currentHp=10, maxMp=20, currentMp=20)", differentCharacterTest.toString())
    }
}
