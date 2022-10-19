package cl.uchile.dcc.finalreality.model.character

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class EnemyTest : AbstractCharacterTest() {
    override val firstCharacterTest = Enemy("Test", 5, 5, 0, turns)
    override val sameCharacterTest = Enemy("Test", 5, 5, 0, turns)
    override val differentCharacterTest = Enemy("Different", 10, 10, 10, turns)

    @Test
    fun testToString() {
        assertEquals("Enemy(name='Test', maxHp=5, defense=0, currentHp=5, weight=5)", firstCharacterTest.toString())
        assertEquals("Enemy(name='Test', maxHp=5, defense=0, currentHp=5, weight=5)", sameCharacterTest.toString())
        assertEquals("Enemy(name='Different', maxHp=10, defense=10, currentHp=10, weight=10)", differentCharacterTest.toString())
    }

    @Test
    fun getWeight() {
        assertEquals(5, firstCharacterTest.weight)
        assertEquals(5, sameCharacterTest.weight)
        assertEquals(10, differentCharacterTest.weight)
    }

    @Test
    fun testEquals() {
        assertEquals(firstCharacterTest, sameCharacterTest)
        assertNotEquals(firstCharacterTest, differentCharacterTest)
        assertNotEquals(sameCharacterTest, differentCharacterTest)
    }

    @Test
    fun testHashCode() {
        assertEquals(firstCharacterTest.hashCode(), sameCharacterTest.hashCode())
        assertNotEquals(firstCharacterTest.hashCode(), differentCharacterTest.hashCode())
        assertNotEquals(sameCharacterTest.hashCode(), differentCharacterTest.hashCode())
    }

    @Test
    fun delay() {
        assertEquals(1/10, firstCharacterTest.delay())
        assertEquals(1/10, sameCharacterTest.delay())
        assertEquals(1, differentCharacterTest.delay())
    }
}
