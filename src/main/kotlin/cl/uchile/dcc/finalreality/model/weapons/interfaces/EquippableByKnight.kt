package cl.uchile.dcc.finalreality.model.weapons.interfaces

import cl.uchile.dcc.finalreality.model.character.player.Knight

/**
 * A class that represents a weapon that can be equipped by a knight.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface EquippableByKnight : IWeapon {
    /**
     * Equips this weapon to a knight.
     */
    fun equipToKnight(knight: Knight)
}
