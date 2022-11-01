package cl.uchile.dcc.finalreality.model.weapons.interfaces

import cl.uchile.dcc.finalreality.model.character.player.WhiteMage

/**
 * A class that represents a weapon that can be equipped by a white mage.
 * */
interface EquippableByWhiteMage : IWeapon {
    /**
     * Equips this weapon to a white mage.
     */
    fun equipToWhiteMage(whiteMage: WhiteMage)
}
