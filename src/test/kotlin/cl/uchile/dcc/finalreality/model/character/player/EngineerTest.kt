package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractPlayerCharacterTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
