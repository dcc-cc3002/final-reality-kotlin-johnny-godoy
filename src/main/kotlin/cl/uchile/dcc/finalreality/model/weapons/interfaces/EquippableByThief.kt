package cl.uchile.dcc.finalreality.model.weapons.interfaces

import cl.uchile.dcc.finalreality.model.character.player.Thief

/**
 * A class that represents a weapon that can be equipped by a thief.
 * */
interface EquippableByThief : IWeapon {
    /**
     * Equips this weapon to a thief.
     */
    fun equipToThief(thief: Thief)
}
