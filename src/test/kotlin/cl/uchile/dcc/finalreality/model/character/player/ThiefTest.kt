package cl.uchile.dcc.finalreality.model.character.player

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ThiefTest : AbstractPlayerCharacterTest() {
    override val firstCharacterTest = Thief("Test", 5, 0, turns)
    override val sameCharacterTest = Thief("Test", 5, 0, turns)
    override val differentCharacterTest = Thief("Different", 10, 10, turns)
    @Test
    fun testToString() {
        assertEquals("Thief(name='Test', maxHp=5, defense=0, currentHp=5)", firstCharacterTest.toString())
        assertEquals("Thief(name='Test', maxHp=5, defense=0, currentHp=5)", sameCharacterTest.toString())
        assertEquals("Thief(name='Different', maxHp=10, defense=10, currentHp=10)", differentCharacterTest.toString())
    }
}