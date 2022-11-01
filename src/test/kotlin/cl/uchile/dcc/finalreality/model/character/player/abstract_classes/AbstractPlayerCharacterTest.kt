package cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.player.abstract_classes

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.abstract_classes.AbstractCharacterTest
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
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
    abstract val lightWeapon: IWeapon
    abstract val lightWeapon2: IWeapon
    abstract val heavyWeapon: IWeapon
    @BeforeEach
    fun setup() {
        firstCharacterTest.equip(lightWeapon)
        sameCharacterTest.equip(lightWeapon2)
        differentCharacterTest.equip(heavyWeapon)
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
