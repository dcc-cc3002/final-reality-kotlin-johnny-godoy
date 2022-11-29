package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractPlayerCharacterTest
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Sword
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class KnightTest : AbstractPlayerCharacterTest() {
    override val firstCharacterTest = Knight("Test", 5, 0, controller)
    override val sameCharacterTest = Knight("Test", 5, 0, controller)
    override val differentCharacterTest = Knight("Different", 10, 10, controller)
    override var lightWeapon = Axe("Axe", 10, 20)
    override var lightWeapon2 = Sword("Axe", 10, 20)
    override var heavyWeapon = Knife("Axe", 10, 30)
    @BeforeEach
    fun setup() {
        firstCharacterTest.equip(lightWeapon)
        sameCharacterTest.equip(lightWeapon2)
        differentCharacterTest.equip(heavyWeapon)
    }
    @Test
    fun testToString() {
        assertEquals("Knight(name='Test', maxHp=5, defense=0, currentHp=5)", firstCharacterTest.toString())
        assertEquals("Knight(name='Test', maxHp=5, defense=0, currentHp=5)", sameCharacterTest.toString())
        assertEquals("Knight(name='Different', maxHp=10, defense=10, currentHp=10)", differentCharacterTest.toString())
    }
}
