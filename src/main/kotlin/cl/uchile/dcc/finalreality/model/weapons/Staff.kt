/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.weapons.abstract_classes.AbstractWeapon
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByBlackMage
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByWhiteMage
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
class Staff(
    name: String,
    damage: Int,
    weight: Int,
    magicDamage: Int
) : AbstractWeapon(name, damage, weight), EquippableByWhiteMage, EquippableByBlackMage {
    override val magicDamage: Int = Require.Stat(magicDamage, "Magic Damage") atLeast 0
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
    override fun hashCode(): Int =
        Objects.hash(Staff::class, name, damage, weight, magicDamage)
    override fun toString(): String {
        val superString = super.toString().dropLast(1)
        return "$superString, magicDamage=$magicDamage)"
    }
    override fun equipToWhiteMage(whiteMage: WhiteMage) {
        whiteMage.equip(this)
    }
    override fun equipToBlackMage(blackMage: BlackMage) {
        blackMage.equip(this)
    }
}
