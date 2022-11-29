/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.abstract_classes

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.math.max

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @param name
 *    The name of the character.
 * @param maxHp
 *    The maximum health points of the character.
 * @param defense
 *    The defense of the character.
 * @property turnsQueue
 *    The queue with the characters waiting for their turn.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
abstract class AbstractCharacter(
    override val name: String,
    maxHp: Int,
    defense: Int,
    private val controller: GameController
) : IGameCharacter {
    private lateinit var scheduledExecutor: ScheduledExecutorService
    override val maxHp: Int = Require.Stat(maxHp, "Max Hp") atLeast 1
    override var currentHp: Int = maxHp
        set(value) {
            field = Require.Stat(value, "Current Hp") inRange 0..maxHp
        }
    override val defense: Int = Require.Stat(defense, "Defense") atLeast 0
    override fun waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
        scheduledExecutor.schedule(this::addToQueue, this.delay(), TimeUnit.SECONDS)
    }
    /**
     * Adds this character to the turns queue.
     */
    private fun addToQueue() {
        controller.turnsQueue.put(this)
        scheduledExecutor.shutdown()
    }
    override fun toString(): String {
        val className = this.javaClass.simpleName
        return "$className(name='$name', maxHp=$maxHp, defense=$defense, currentHp=$currentHp)"
    }
    override fun receiveDamage(damage: Int) {
        currentHp = max(currentHp - damage, 0)
    }
}
