package cl.uchile.dcc.finalreality.exceptions

import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import java.util.concurrent.LinkedBlockingDeque
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UnequippableWeaponExceptionTest{
    val turns: LinkedBlockingDeque<IGameCharacter> = LinkedBlockingDeque<IGameCharacter>()
    @Test
    fun testKnight(){
        val knight = Knight("Test", 5, 0, turns)
        val staff = Staff("Staff", 10, 10, 10)
        val bow = Bow("Bow", 10, 10)
        assertThrows(UnequippableWeaponException::class.java) { knight.equip(staff) }
        assertThrows(UnequippableWeaponException::class.java) { knight.equip(bow) }
    }
    @Test
    fun testEngineer(){
        val engineer = Engineer("Test", 5, 0, turns)
        val staff = Staff("Staff", 10, 10, 10)
        val sword = Sword("Sword", 10, 10)
        val knife = Knife("Knife", 10, 10)
        assertThrows(UnequippableWeaponException::class.java) { engineer.equip(staff) }
        assertThrows(UnequippableWeaponException::class.java) { engineer.equip(sword) }
        assertThrows(UnequippableWeaponException::class.java) { engineer.equip(knife) }
    }
}