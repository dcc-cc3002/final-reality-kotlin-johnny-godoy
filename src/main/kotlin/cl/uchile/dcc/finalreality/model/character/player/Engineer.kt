/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon
import java.util.Objects
import java.util.concurrent.BlockingQueue

/**
 * An `Engineer` is a type of [IPlayerCharacter] that can equip `Axe`s and
 * `Bow`s.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Engineer.
 *
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class Engineer(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<IGameCharacter>
) :
    AbstractPlayerCharacter(name, maxHp, defense, turnsQueue) {
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Engineer -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        maxHp != other.maxHp -> false
        defense != other.defense -> false
        else -> true
    }
    override fun hashCode(): Int =
        Objects.hash(Engineer::class, name, maxHp, defense)
    override fun equip(weapon: IWeapon) {
        super.equip(weapon)
    }
}
