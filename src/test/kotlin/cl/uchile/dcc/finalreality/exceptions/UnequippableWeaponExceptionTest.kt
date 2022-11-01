package cl.uchile.dcc.finalreality.exceptions

import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Staff
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
}