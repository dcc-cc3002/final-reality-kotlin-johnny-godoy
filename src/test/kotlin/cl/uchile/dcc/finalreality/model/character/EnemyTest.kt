package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.abstract_classes.AbstractCharacterTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class EnemyTest : AbstractCharacterTest() {
    override val firstCharacterTest = Enemy("Test", 20, 5, 0, turns)
    override val sameCharacterTest = Enemy("Test", 20, 5, 0, turns)
    override val differentCharacterTest = Enemy("Different", 30, 10, 10, turns)
    @Test
    fun testToString() {
        assertEquals("Enemy(name='Test', maxHp=5, defense=0, currentHp=5, weight=20)", firstCharacterTest.toString())
        assertEquals("Enemy(name='Test', maxHp=5, defense=0, currentHp=5, weight=20)", sameCharacterTest.toString())
        assertEquals("Enemy(name='Different', maxHp=10, defense=10, currentHp=10, weight=30)", differentCharacterTest.toString())
    }
    @Test
    fun getWeight() {
        assertEquals(20, firstCharacterTest.weight)
        assertEquals(20, sameCharacterTest.weight)
        assertEquals(30, differentCharacterTest.weight)
    }
}
