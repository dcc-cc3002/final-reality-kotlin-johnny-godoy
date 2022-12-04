/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.weapons.interfaces

/**
 * This represents a weapon in the game.
 *
 * @property name String
 *     The weapon's name
 * @property damage Int
 *     The weapon's base damage
 * @property weight Int
 *     The weapon's weight
 * @property magicDamage Int
 *    The weapon's magic damage. It is 0 by default.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface IWeapon {
    val name: String
    val damage: Int
    val weight: Int
    val magicDamage: Int
}
