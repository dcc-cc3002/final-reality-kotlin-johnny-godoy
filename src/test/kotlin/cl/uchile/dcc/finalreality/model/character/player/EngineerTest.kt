package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractPlayerCharacterTest
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class EngineerTest : AbstractPlayerCharacterTest() {
    override val firstCharacterTest = Engineer("Test", 5, 0, turns)
    override val sameCharacterTest = Engineer("Test", 5, 0, turns)
    override val differentCharacterTest = Engineer("Different", 10, 10, turns)
    override val lightWeapon = Axe("Light", 10, 20)
    override val lightWeapon2 = Axe("Light", 10, 20)
    override val heavyWeapon = Bow("Heavy", 10, 30)
    @Test
    fun testToString() {
        assertEquals("Engineer(name='Test', maxHp=5, defense=0, currentHp=5)", firstCharacterTest.toString())
        assertEquals("Engineer(name='Test', maxHp=5, defense=0, currentHp=5)", sameCharacterTest.toString())
        assertEquals("Engineer(name='Different', maxHp=10, defense=10, currentHp=10)", differentCharacterTest.toString())
    }
}
