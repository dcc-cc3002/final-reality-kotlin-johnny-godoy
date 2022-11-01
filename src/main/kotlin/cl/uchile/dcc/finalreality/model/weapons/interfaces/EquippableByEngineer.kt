package cl.uchile.dcc.finalreality.model.weapons.interfaces

import cl.uchile.dcc.finalreality.model.character.player.Engineer

/**
 * A class that represents a weapon that can be equipped by an engineer.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface EquippableByEngineer : IWeapon {
    /**
     * Equips this weapon to an engineer.
     */
    fun equipToEngineer(engineer: Engineer)
}
