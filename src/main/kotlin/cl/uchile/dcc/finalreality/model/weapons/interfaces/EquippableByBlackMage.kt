package cl.uchile.dcc.finalreality.model.weapons.interfaces

import cl.uchile.dcc.finalreality.model.character.player.BlackMage

/**
 * A class that represents a weapon that can be equipped by a black mage.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface EquippableByBlackMage : IWeapon {
    /**
     * Equips this weapon to a black mage.
     */
    fun equipToBlackMage(blackMage: BlackMage)
}
