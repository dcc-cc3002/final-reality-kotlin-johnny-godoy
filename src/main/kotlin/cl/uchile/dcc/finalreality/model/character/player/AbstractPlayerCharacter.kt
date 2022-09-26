/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.IGameCharacter
import cl.uchile.dcc.finalreality.model.weapons.IWeapon
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

    override fun equip(weapon: IWeapon) {
        _equippedWeapon = weapon
    }

    override fun delay() = equippedWeapon.weight / 10
}
