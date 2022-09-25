/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.Weapon
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.IGameCharacter
import java.util.concurrent.BlockingQueue

/**
 * A character controlled by the user.
 *
 * @property equippedWeapon
 *    the weapon that the character is currently using
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface IPlayerCharacter {
  val equippedWeapon: Weapon

  /**
   * Equips a weapon to the character.
   */
  fun equip(weapon: Weapon)
}

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

  private lateinit var _equippedWeapon: Weapon
  override val equippedWeapon: Weapon
    get() = _equippedWeapon

  override fun equip(weapon: Weapon) {
    _equippedWeapon = weapon
  }
}


/**
 * An abstract class that holds the information for a character that wields magic (and thus has Mana)
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum magic points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new magic wielder.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
abstract class AbstractMagicWielder(
  name: String,
  maxHp: Int,
  maxMp: Int,
  defense: Int,
  turnsQueue: BlockingQueue<IGameCharacter>
) : AbstractPlayerCharacter(name, maxHp, defense, turnsQueue) {
  val maxMp = Require.Stat(maxMp, "Max MP") atLeast 0
  var currentMp: Int = maxMp
    set(value) {
      field = Require.Stat(value, "Current MP") inRange 0..maxMp
    }
  override fun toString(): String {
    val superString = super.toString().dropLast(1)
    return "$superString, maxMp=$maxMp, currentMp=$currentMp)"
  }
}