package cl.uchile.dcc.finalreality.model.weapons.interfaces

import cl.uchile.dcc.finalreality.model.character.player.Thief

/**
 * A class that represents a weapon that can be equipped by a thief.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface EquippableByThief : IWeapon {
    /**
     * Equips this weapon to a thief.
     */
    fun equipToThief(thief: Thief)
}
