package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.AbstractCharacterTest
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

abstract class AbstractPlayerCharacterTest : AbstractCharacterTest() {
    abstract override val firstCharacterTest: IPlayerCharacter
    abstract override val sameCharacterTest: IPlayerCharacter
    abstract override val differentCharacterTest: IPlayerCharacter
    private val knife: Knife = Knife("Knife", 10, 1)
    private val axe: Axe = Axe("Axe", 10, 2)
    private val bow: Bow = Bow("Bow", 10, 3)
    private val staff: Staff = Staff("Staff", 10, 4, 5)
    private val sword: Sword = Sword("Sword", 10, 5)

    @BeforeEach
    fun setup() {
        firstCharacterTest.equip(knife)
        sameCharacterTest.equip(axe)
        differentCharacterTest.equip(bow)
    }

    @AfterEach
    fun cleanup() {
        firstCharacterTest.equip(knife)
        sameCharacterTest.equip(axe)
        differentCharacterTest.equip(bow)
    }

    @Test
    fun equip() {
        assertEquals(knife, firstCharacterTest.equippedWeapon)
        firstCharacterTest.equip(sword)
        assertEquals(sword, firstCharacterTest.equippedWeapon)
    }

    @Test
    fun getEquippedWeapon() {
        assertEquals(knife, firstCharacterTest.equippedWeapon)
        assertEquals(axe, sameCharacterTest.equippedWeapon)
        assertEquals(bow, differentCharacterTest.equippedWeapon)
    }

    @Test
    fun delay() {
        assertEquals(1/10, firstCharacterTest.delay())
        assertEquals(2/10, sameCharacterTest.delay())
        assertEquals(3/10, differentCharacterTest.delay())
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