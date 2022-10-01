package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.exceptions.Require
import java.util.Objects

/**
 * A class that implements staffs.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 * @property magicDamage Int
 *    The base magic damage done by the weapon.
 *
 * @constructor Creates a staff with a name, a base damage, and a weight value.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class Staff(name: String, damage: Int, weight: Int, magicDamage: Int) : Weapon(name, damage, weight) {
    val magicDamage: Int = Require.Stat(magicDamage, "Magic Damage") atLeast 0
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Staff -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        magicDamage != other.magicDamage -> false
        else -> true
    }

    override fun hashCode(): Int = Objects.hash(Staff::class, name, damage, weight, magicDamage)
}
