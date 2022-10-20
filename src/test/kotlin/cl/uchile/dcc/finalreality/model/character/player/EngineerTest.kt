package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.AbstractCharacterTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EngineerTest : AbstractPlayerCharacterTest() {
    override val firstCharacterTest = Engineer("Test", 5, 0, turns)
    override val sameCharacterTest = Engineer("Test", 5, 0, turns)
    override val differentCharacterTest = Engineer("Different", 10, 10, turns)

    @Test
    fun testToString() {
        assertEquals("Engineer(name='Test', maxHp=5, defense=0, currentHp=5)", firstCharacterTest.toString())
        assertEquals("Engineer(name='Test', maxHp=5, defense=0, currentHp=5)", sameCharacterTest.toString())
        assertEquals("Engineer(name='Different', maxHp=10, defense=10, currentHp=10)", differentCharacterTest.toString())
    }
}