/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player.abstract_classes

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IMagicWielder
import java.util.concurrent.BlockingQueue

/**
 * An abstract class that holds the information for a character that wields magic (and thus has Mana)
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum mana points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new magic wielder.
 *
 * @property maxMp the character's maximum mana points
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
) : AbstractPlayerCharacter(name, maxHp, defense, turnsQueue), IMagicWielder {
    override val maxMp: Int = Require.Stat(maxMp, "Max MP") atLeast 0
    override var currentMp: Int = maxMp
        set(value) {
            field = Require.Stat(value, "Current MP") inRange 0..maxMp
        }
    override fun toString(): String {
        val superString = super.toString().dropLast(1)
        return "$superString, maxMp=$maxMp, currentMp=$currentMp)"
    }
}
