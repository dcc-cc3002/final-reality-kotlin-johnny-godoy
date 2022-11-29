package cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.abstract_classes

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.util.concurrent.LinkedBlockingQueue

abstract class AbstractCharacterTest {
    val controller: GameController = GameController()
    val turns: LinkedBlockingQueue<IGameCharacter> = controller.turnsQueue
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
    fun getName() {
        assertEquals("Test", firstCharacterTest.name)
        assertEquals("Test", sameCharacterTest.name)
        assertEquals("Different", differentCharacterTest.name)
    }
    @Test
    fun testConstructor() {
        assertEquals(firstCharacterTest, sameCharacterTest)
        assertNotEquals(firstCharacterTest, differentCharacterTest)
        assertNotEquals(sameCharacterTest, differentCharacterTest)
    }
    @Test
    fun testEquals() {
        assertEquals(true, firstCharacterTest == firstCharacterTest)
        assertEquals(true, firstCharacterTest == sameCharacterTest)
        assertEquals(false, firstCharacterTest == differentCharacterTest)
    }
    @Test
    fun testHashCode() {
        assertEquals(firstCharacterTest.hashCode(), sameCharacterTest.hashCode())
        assertNotEquals(firstCharacterTest.hashCode(), differentCharacterTest.hashCode())
        assertNotEquals(sameCharacterTest.hashCode(), differentCharacterTest.hashCode())
    }
    @Test
    fun delay() {
        assertEquals(2, firstCharacterTest.delay())
        assertEquals(2, sameCharacterTest.delay())
        assertEquals(3, differentCharacterTest.delay())
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
    fun receiveDamage() {
        firstCharacterTest.receiveDamage(1)
        assertEquals(4, firstCharacterTest.currentHp)
        firstCharacterTest.receiveDamage(2)
        assertEquals(2, firstCharacterTest.currentHp)
        firstCharacterTest.receiveDamage(3)
        assertEquals(0, firstCharacterTest.currentHp)
        firstCharacterTest.receiveDamage(4)
        assertEquals(0, firstCharacterTest.currentHp)
    }
    @Test
    fun isAlive() {
        assertEquals(true, firstCharacterTest.isAlive())
        assertEquals(true, sameCharacterTest.isAlive())
        assertEquals(true, differentCharacterTest.isAlive())
        firstCharacterTest.currentHp = 0
        assertEquals(false, firstCharacterTest.isAlive())
        sameCharacterTest.currentHp = 0
        assertEquals(false, sameCharacterTest.isAlive())
        differentCharacterTest.currentHp = 0
        assertEquals(false, differentCharacterTest.isAlive())
    }
    @Test
    fun recevePhysicalAttack() {
        differentCharacterTest.receivePhysicalAttack(5)
        assertEquals(10, differentCharacterTest.currentHp)
        differentCharacterTest.receivePhysicalAttack(15)
        assertEquals(5, differentCharacterTest.currentHp)
    }
}
