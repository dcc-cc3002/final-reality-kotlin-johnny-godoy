package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.model.character.player.Knight

/**
 * A class that represents a weapon that can be equipped by a knight.
 * */
interface EquippableToKnight : IWeapon {
    fun equipToKnight(knight: Knight)
}