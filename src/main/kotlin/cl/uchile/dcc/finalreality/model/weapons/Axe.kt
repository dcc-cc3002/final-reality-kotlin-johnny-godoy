package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.weapons.abstract_classes.AbstractWeapon
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByEngineer
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByKnight
import java.util.Objects

/**
 * A class that implements axes.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, and a weight value.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class Axe(name: String,
          damage: Int,
          weight: Int
) : AbstractWeapon(name, damage, weight), EquippableByKnight, EquippableByEngineer {
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Axe -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }
    override fun hashCode(): Int =
        Objects.hash(Axe::class, name, damage, weight)
    /**
     * Equips this axe to a knight.
     */
    override fun equipToKnight(knight: Knight) {
        knight.equip(this)
    }
    override fun equipToEngineer(engineer: Engineer) {
        engineer.equip(this)
    }
}
