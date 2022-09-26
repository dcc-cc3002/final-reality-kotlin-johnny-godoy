package cl.uchile.dcc.finalreality.model.weapons

import java.util.Objects

/**
 * A class that implements bows.
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
class Bow(name: String, damage: Int, weight: Int) : Weapon(name, damage, weight) {
    override fun equals(other: Any?) = when {
        this === other                 -> true
        other !is Bow                  -> false
        hashCode() != other.hashCode() -> false
        name != other.name             -> false
        damage != other.damage         -> false
        weight != other.weight         -> false
        else                           -> true
    }

    override fun hashCode() = Objects.hash(Bow::class, name, damage, weight)
}