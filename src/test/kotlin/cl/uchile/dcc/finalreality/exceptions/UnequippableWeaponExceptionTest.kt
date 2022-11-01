package cl.uchile.dcc.finalreality.exceptions

import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import org.junit.jupiter.api.Test
import java.util.concurrent.LinkedBlockingDeque

internal class UnequippableWeaponExceptionTest {
    val turns: LinkedBlockingDeque<IGameCharacter> = LinkedBlockingDeque<IGameCharacter>()
    private val axe = Axe("Axe", 10, 10)
    private val bow = Bow("Bow", 10, 10)
    private val knife = Knife("Knife", 10, 10)
    private val staff = Staff("Staff", 10, 10, 10)
    private val sword = Sword("Sword", 10, 10)
    @Test
    fun testKnight() {
        val knight = Knight("Knight", 10, 10, turns)
        assertThrows(UnequippableWeaponException::class.java, { knight.equip(staff) }, "A staff was equipped to a knight.")
        assertThrows(UnequippableWeaponException::class.java, { knight.equip(bow) }, "A bow was equipped to a knight.")
    }
    @Test
    fun testEngineer() {
        val engineer = Engineer("Test", 5, 0, turns)
        assertThrows(UnequippableWeaponException::class.java, { engineer.equip(sword) }, "A sword was equipped to an engineer.")
        assertThrows(UnequippableWeaponException::class.java, { engineer.equip(knife) }, "A knife was equipped to an engineer.")
        assertThrows(UnequippableWeaponException::class.java, { engineer.equip(staff) }, "A staff was equipped to an engineer.")
    }
    @Test
    fun testThief() {
        val thief = Thief("Test", 5, 0, turns)
        assertThrows(UnequippableWeaponException::class.java, { thief.equip(axe) }, "An axe was equipped to a thief.")
        assertThrows(UnequippableWeaponException::class.java, { thief.equip(staff) }, "A staff was equipped to a thief.")
    }
    @Test
    fun testWhiteMage() {
        val whiteMage = WhiteMage("Test", 5, 10, 5, turns)
        assertThrows(UnequippableWeaponException::class.java, { whiteMage.equip(sword) }, "A sword was equipped to a white mage.")
        assertThrows(UnequippableWeaponException::class.java, { whiteMage.equip(knife) }, "A knife was equipped to an white mage.")
        assertThrows(UnequippableWeaponException::class.java, { whiteMage.equip(bow) }, "A bow was equipped to a white mage.")
        assertThrows(UnequippableWeaponException::class.java, { whiteMage.equip(axe) }, "An axe was equipped to a white mage.")
    }
    @Test
    fun testBlackMage() {
        val blackMage = BlackMage("Test", 5, 10, 5, turns)
        assertThrows(UnequippableWeaponException::class.java, { blackMage.equip(sword) }, "A sword was equipped to a black mage.")
        assertThrows(UnequippableWeaponException::class.java, { blackMage.equip(bow) }, "A bow was equipped to a black mage.")
        assertThrows(UnequippableWeaponException::class.java, { blackMage.equip(axe) }, "An axe was equipped to a black mage.")
    }
}
