/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.abstract_classes.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.interfaces.IEnemy
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.status.NullState
import cl.uchile.dcc.finalreality.model.status.interfaces.IState
import java.util.Objects
import java.util.concurrent.BlockingQueue

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @param name The name of this enemy.
 * @property weight The weight of this enemy.
 * @param controller The game controller.
 * @param maxHp The maximum health points of this enemy.
 * @param defense The defense of this enemy.
 * @property attack The attack of this enemy.
 *
 * @constructor Creates a new enemy with a name, a weight and the queue with the characters ready to
 *  play.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class Enemy(
    name: String,
    weight: Int,
    maxHp: Int,
    defense: Int,
    attack: Int,
    controller: GameController
) : AbstractCharacter(name, maxHp, defense, controller), IEnemy {
    val weight: Int = Require.Stat(weight, "Weight") atLeast 1
    val attack: Int = Require.Stat(attack, "Attack") atLeast 1
    override var status: IState = NullState(this)
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Enemy -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        weight != other.weight -> false
        maxHp != other.maxHp -> false
        defense != other.defense -> false
        attack != other.attack -> false
        else -> true
    }
    override fun hashCode(): Int =
        Objects.hash(Enemy::class, name, weight, maxHp, defense)
    override fun toString(): String {
        val superString = super.toString().dropLast(1)
        return "$superString, weight=$weight, attack=$attack)"
    }
    override fun delay(): Long =
        (weight / 10).toLong()
    override fun getAttacked(attacker: IPlayerCharacter) {
        this.receivePhysicalAttack(attacker.equippedWeapon.damage)
    }
}
