package cl.uchile.dcc.finalreality.model.character.player.abstract_classes

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractPlayerCharacterTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractMagicWielderTest : AbstractPlayerCharacterTest() {
    // Here we use an abstract class as a type, which breaks a principle of OOP,
    // but it's worth it to avoid creating an interface just for this test.
    abstract override val firstCharacterTest: AbstractMagicWielder
    abstract override val sameCharacterTest: AbstractMagicWielder
    abstract override val differentCharacterTest: AbstractMagicWielder
    @AfterEach
    fun cleanup() {
        firstCharacterTest.currentMp = 10
        sameCharacterTest.currentMp = 10
        differentCharacterTest.currentMp = 20
    }
    @Test
    fun getMaxMp() {
        assertEquals(10, firstCharacterTest.maxMp)
        assertEquals(10, sameCharacterTest.maxMp)
        assertEquals(20, differentCharacterTest.maxMp)
    }
    @Test
    fun getCurrentMp() {
        assertEquals(10, firstCharacterTest.currentMp)
        assertEquals(10, sameCharacterTest.currentMp)
        assertEquals(20, differentCharacterTest.currentMp)
    }
    @Test
    fun setCurrentMp() {
        firstCharacterTest.currentMp = 5
        assertEquals(5, firstCharacterTest.currentMp)
        sameCharacterTest.currentMp = 1
        assertEquals(1, sameCharacterTest.currentMp)
        differentCharacterTest.currentMp = 4
        assertEquals(4, differentCharacterTest.currentMp)
    }
}
