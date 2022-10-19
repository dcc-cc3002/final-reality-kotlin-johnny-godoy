package cl.uchile.dcc.finalreality.model.character

import java.util.concurrent.LinkedBlockingDeque
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

abstract class AbstractCharacterTest {
    val turns: LinkedBlockingDeque<IGameCharacter> = LinkedBlockingDeque<IGameCharacter>()
    abstract val firstCharacterTest: IGameCharacter
    abstract val sameCharacterTest: IGameCharacter
    abstract val differentCharacterTest: IGameCharacter

    @Test
    fun getMaxHp() {
        assertEquals(5, firstCharacterTest.maxHp)
        assertEquals(5, sameCharacterTest.maxHp)
        assertEquals(10, differentCharacterTest.maxHp)
    }

    @Test
    fun getCurrentHp() {
        assertEquals(5, firstCharacterTest.currentHp)
        assertEquals(5, sameCharacterTest.currentHp)
        assertEquals(10, differentCharacterTest.currentHp)
    }

    @Test
    fun setCurrentHp() {
        firstCharacterTest.currentHp = 0
        assertEquals(0, firstCharacterTest.currentHp)
        firstCharacterTest.currentHp = 1
        assertEquals(1, firstCharacterTest.currentHp)
        firstCharacterTest.currentHp = 2
        assertEquals(2, firstCharacterTest.currentHp)
    }

    @Test
    fun getDefense() {
        assertEquals(0, firstCharacterTest.defense)
        assertEquals(0, sameCharacterTest.defense)
        assertEquals(10, differentCharacterTest.defense)
    }

    @Test
    fun waitTurn() {
        firstCharacterTest.waitTurn()
        sameCharacterTest.waitTurn()
        differentCharacterTest.waitTurn()
        assertEquals(firstCharacterTest, turns.take())
        assertEquals(sameCharacterTest, turns.take())
        assertEquals(differentCharacterTest, turns.take())
    }

    @Test
    fun getName() {
        assertEquals("Test", firstCharacterTest.name)
        assertEquals("Test", sameCharacterTest.name)
        assertEquals("Different", differentCharacterTest.name)
    }
}