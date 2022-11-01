package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.IWeapon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class KnightTest : AbstractPlayerCharacterTest() {
    override val firstCharacterTest = Knight("Test", 5, 0, turns)
    override val sameCharacterTest = Knight("Test", 5, 0, turns)
    override val differentCharacterTest = Knight("Different", 10, 10, turns)
    override var lightWeapon: IWeapon = Axe("Axe", 10, 20)
    override var lightWeapon2: IWeapon = Axe("Axe", 10, 20)
    override var heavyWeapon: IWeapon = Axe("Axe", 10, 30)
    @Test
    fun testToString() {
        assertEquals("Knight(name='Test', maxHp=5, defense=0, currentHp=5)", firstCharacterTest.toString())
        assertEquals("Knight(name='Test', maxHp=5, defense=0, currentHp=5)", sameCharacterTest.toString())
        assertEquals("Knight(name='Different', maxHp=10, defense=10, currentHp=10)", differentCharacterTest.toString())
    }
}
