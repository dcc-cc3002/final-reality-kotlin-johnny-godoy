/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player.interfaces

import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon

/**
 * A character controlled by the user.
 *
 * @property equippedWeapon
 *    the weapon that the character is currently using
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface IPlayerCharacter : IGameCharacter {
    val equippedWeapon: IWeapon
    /**
     * This method just throws an exception,
     * and is meant to be overloaded by the concrete subclasses with an appropriate weapon type.
     * @param weapon IWeapon
     * @throws UnequippableWeaponException always
     */
    fun equip(weapon: IWeapon)
}
