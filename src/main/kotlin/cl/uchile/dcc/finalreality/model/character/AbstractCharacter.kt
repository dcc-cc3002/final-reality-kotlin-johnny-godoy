package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.exceptions.Require
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

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
    private val turnsQueue: BlockingQueue<IGameCharacter>,
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
        turnsQueue.put(this)
        scheduledExecutor.shutdown()
    }

    override fun toString(): String {
        val className = this.javaClass.simpleName
        return "$className(name='$name', maxHp=$maxHp, defense=$defense, currentHp=$currentHp)"
    }
}
