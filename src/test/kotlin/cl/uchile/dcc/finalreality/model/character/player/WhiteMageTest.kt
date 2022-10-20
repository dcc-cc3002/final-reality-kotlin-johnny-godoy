package cl.uchile.dcc.finalreality.model.character.player

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WhiteMageTest : AbstractMagicWielderTest() {
    override val firstCharacterTest = WhiteMage("Test", 5, 10, 0, turns)
    override val sameCharacterTest = WhiteMage("Test", 5, 10, 0, turns)
    override val differentCharacterTest = WhiteMage("Different", 10, 20, 10, turns)
    @Test
    fun testToString() {
        assertEquals("WhiteMage(name='Test', maxHp=5, defense=0, currentHp=5, maxMp=10, currentMp=10)", firstCharacterTest.toString())
        assertEquals("WhiteMage(name='Test', maxHp=5, defense=0, currentHp=5, maxMp=10, currentMp=10)", sameCharacterTest.toString())
        assertEquals("WhiteMage(name='Different', maxHp=10, defense=10, currentHp=10, maxMp=20, currentMp=20)", differentCharacterTest.toString())
    }
}