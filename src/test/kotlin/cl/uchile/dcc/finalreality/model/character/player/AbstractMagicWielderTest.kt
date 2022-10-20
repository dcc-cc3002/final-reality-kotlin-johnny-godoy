package cl.uchile.dcc.finalreality.model.character.player

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

abstract class AbstractMagicWielderTest : AbstractPlayerCharacterTest() {
    @Test
    fun getMaxMp() {
        assertEquals(5, firstCharacterTest.maxMp)
        assertEquals(5, sameCharacterTest.maxMp)
        assertEquals(10, differentCharacterTest.maxMp)
    }

    @Test
    fun getCurrentMp() {
        assertEquals(5, firstCharacterTest.currentMp)
        assertEquals(5, sameCharacterTest.currentMp)
        assertEquals(10, differentCharacterTest.currentMp)
    }

    @Test
    fun setCurrentMp() {
        firstCharacterTest.currentMp = 10
        assertEquals(10, firstCharacterTest.currentMp)
        sameCharacterTest.currentMp = 10
        assertEquals(10, sameCharacterTest.currentMp)
        differentCharacterTest.currentMp = 10
        assertEquals(10, differentCharacterTest.currentMp)
    }
}