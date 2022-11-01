package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.AbstractCharacterTest
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon
import cl.uchile.dcc.finalreality.model.weapons.Knife
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

abstract class AbstractPlayerCharacterTest : AbstractCharacterTest() {
    abstract override val firstCharacterTest: IPlayerCharacter
    abstract override val sameCharacterTest: IPlayerCharacter
    abstract override val differentCharacterTest: IPlayerCharacter
    open var lightWeapon: IWeapon = Knife("Knife", 10, 20)
    open var lightWeapon2: IWeapon = Axe("Axe", 10, 20)
    open var heavyWeapon: IWeapon = Bow("Bow", 10, 30)
    @BeforeEach
    fun setup() {
        firstCharacterTest.equip(lightWeapon)
        sameCharacterTest.equip(lightWeapon2)
        differentCharacterTest.equip(heavyWeapon)
    }
    @AfterEach
    open fun cleanup() {
        firstCharacterTest.equip(lightWeapon)
        sameCharacterTest.equip(lightWeapon2)
        differentCharacterTest.equip(heavyWeapon)
    }
    @Test
    fun equip() {
        assertEquals(lightWeapon, firstCharacterTest.equippedWeapon)
        firstCharacterTest.equip(heavyWeapon)
        assertEquals(heavyWeapon, firstCharacterTest.equippedWeapon)
    }
    @Test
    fun getEquippedWeapon() {
        assertEquals(lightWeapon, firstCharacterTest.equippedWeapon)
        assertEquals(lightWeapon2, sameCharacterTest.equippedWeapon)
        assertEquals(heavyWeapon, differentCharacterTest.equippedWeapon)
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
}
