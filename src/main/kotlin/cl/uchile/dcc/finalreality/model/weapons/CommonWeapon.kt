package cl.uchile.dcc.finalreality.model.weapons

import java.util.Objects

/**
 * A class that holds information of weapons that cannot use magic.
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
class CommonWeapon(name: String, damage: Int, weight: Int, val type: CommonWeaponTypes) : AbstractWeapon(name, damage, weight) {
    override fun equals(other: Any?) = when {
        this === other                 -> true
        other !is CommonWeapon       -> false
        hashCode() != other.hashCode() -> false
        name != other.name             -> false
        damage != other.damage         -> false
        weight != other.weight         -> false
        type != other.type             -> false
        else                           -> true
    }

    override fun hashCode() = Objects.hash(AbstractWeapon::class, name, damage, weight)

    override fun toString(): String {
        val superString = super.toString().dropLast(1)
        return "$superString, type=$type)"
    }
}