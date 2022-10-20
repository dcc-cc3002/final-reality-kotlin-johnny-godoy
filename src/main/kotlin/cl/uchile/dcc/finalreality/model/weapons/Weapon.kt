package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.exceptions.Require
import java.util.Objects

/**
 * A class that holds the common behaviour of all the weapons in the game.
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
abstract class Weapon(override val name: String, damage: Int, weight: Int) : IWeapon {
    override val damage: Int = Require.Stat(damage, "Damage") atLeast 0
    override val weight: Int = Require.Stat(weight, "Weight") atLeast 0

    override fun toString(): String {
        val className = this.javaClass.simpleName
        return "$className(name='$name', damage=$damage, weight=$weight)"
    }
}
