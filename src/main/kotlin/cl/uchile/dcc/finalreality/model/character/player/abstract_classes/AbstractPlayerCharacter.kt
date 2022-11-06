/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player.abstract_classes

import cl.uchile.dcc.finalreality.exceptions.UnequippableWeaponException
import cl.uchile.dcc.finalreality.model.character.abstract_classes.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon
import java.util.concurrent.BlockingQueue

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new playable character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
abstract class AbstractPlayerCharacter(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<IGameCharacter>
) : AbstractCharacter(name, maxHp, defense, turnsQueue), IPlayerCharacter {
    private lateinit var _equippedWeapon: IWeapon
    override val equippedWeapon: IWeapon
        get() = _equippedWeapon
    /**
     * Equips a weapon to the character.
     * It works for any weapon type, so it is protected to avoid misuse with invalid weapons.
     * @param weapon the weapon to equip
     */
    protected fun validEquip(weapon: IWeapon) {
        _equippedWeapon = weapon
    }
    override fun equip(weapon: IWeapon) {
        throw UnequippableWeaponException("$this cannot equip $weapon.")
    }
    override fun delay(): Long =
        (equippedWeapon.weight / 10).toLong()
}
