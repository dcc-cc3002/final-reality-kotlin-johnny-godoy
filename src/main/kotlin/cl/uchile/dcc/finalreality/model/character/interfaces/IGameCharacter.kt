/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.interfaces

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @property name
 *    The name of the character.
 * @property maxHp
 *    The maximum health points of the character.
 * @property defense
 *    The defense of the character.
 * @property currentHp
 *    The current health points of the character.
 * @property controller
 *    The game controller.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface IGameCharacter {
    val name: String
    val maxHp: Int
    var currentHp: Int
    val defense: Int
    val controller: GameController
    /**
     * Sets a scheduled executor to make this character (thread) wait for `speed / 10`
     * seconds before adding the character to the queue.
     */
    fun waitTurn()
    /**
     * Gets the correct delay for the character.
     */
    fun delay(): Long
    /**
     * Returns true if the character is alive, false otherwise.
     */
    fun isAlive(): Boolean = currentHp > 0
    /**
     * Reduces health points of the character.
     */
    fun receiveDamage(damage: Int)
    /**
     * Receives a physical attack, which is reduced by the defense of the character.
     */
    fun receivePhysicalAttack(damage: Int)
    /**
     * Get attacked by a player character.
     */
    fun attackedByPlayer(attacker: IPlayerCharacter)
    /**
     * Get attacked by an enemy character.
     */
    fun attackedByEnemy(attacker: Enemy)
    /**
     * Attack another character.
     */
    fun attack(target: IGameCharacter)
    /**
     * Tells the controller to remove this character from the game if it is dead.
     */
    fun notifyDeathToController()
}
