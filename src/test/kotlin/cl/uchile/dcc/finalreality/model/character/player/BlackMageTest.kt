package cl.uchile.dcc.finalreality.model.character.player

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BlackMageTest : AbstractMagicWielderTest() {
    override val firstCharacterTest = BlackMage("Test", 5, 10, 0, turns)
    override val sameCharacterTest = BlackMage("Test", 5, 10, 0, turns)
    override val differentCharacterTest = BlackMage("Different", 10, 20, 10, turns)

    @Test
    fun testToString() {
        assertEquals("BlackMage(name='Test', maxHp=5, defense=0, currentHp=5, maxMp=10, currentMp=10)", firstCharacterTest.toString())
        assertEquals("BlackMage(name='Test', maxHp=5, defense=0, currentHp=5, maxMp=10, currentMp=10)", sameCharacterTest.toString())
        assertEquals("BlackMage(name='Different', maxHp=10, defense=10, currentHp=10, maxMp=20, currentMp=20)", differentCharacterTest.toString())
    }
}