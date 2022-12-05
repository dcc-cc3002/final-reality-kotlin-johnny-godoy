/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.exceptions.FriendlyFireException
import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.abstract_classes.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IMagicWielder
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.status.Burnt
import cl.uchile.dcc.finalreality.model.status.NullState
import cl.uchile.dcc.finalreality.model.status.Paralyzed
import cl.uchile.dcc.finalreality.model.status.Poisoned
import cl.uchile.dcc.finalreality.model.status.interfaces.IState
import cl.uchile.dcc.finalreality.model.weapons.Staff
import java.util.Objects
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @param name The name of this enemy.
 * @property weight The weight of this enemy.
 * @param controller The game controller.
 * @param maxHp The maximum health points of this enemy.
 * @param defense The defense of this enemy.
 * @property attackStat The attack of this enemy.
 * @property status The status of this enemy.
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
    attackStat: Int,
    controller: GameController
) : AbstractCharacter(name, maxHp, defense, controller) {
    val weight: Int = Require.Stat(weight, "Weight") atLeast 1
    val attackStat: Int = Require.Stat(attackStat, "Attack") atLeast 1
    var status: IState = NullState(this)
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Enemy -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        weight != other.weight -> false
        maxHp != other.maxHp -> false
        defense != other.defense -> false
        attackStat != other.attackStat -> false
        else -> true
    }
    override fun hashCode(): Int =
        Objects.hash(Enemy::class, name, weight, maxHp, defense, attackStat)
    override fun toString(): String {
        val superString = super.toString().dropLast(1)
        return "$superString, weight=$weight, attack=$attackStat)"
    }
    override fun delay(): Long =
        (weight / 10).toLong()
    override fun attack(target: IGameCharacter){
        status.attack(target)
    }
    override fun waitTurn() {
        super.waitTurn()
        status.turnEffect()
        notifyDeathToController() // In case the enemy died from the status effect
    }
    override fun attackedByPlayer(attacker: IPlayerCharacter) {
        this.receivePhysicalAttack(attacker.equippedWeapon.damage)
        notifyDeathToController()
    }
    override fun attackedByEnemy(attacker: Enemy) {
        throw FriendlyFireException("Enemy $attacker cannot attack another enemy $this")
    }
    /**
     * Damages this enemy, and with a probability of 30%, it will be paralyzed.
     */
    fun receiveThunder(blackMage: BlackMage){
        receiveDamage(blackMage.equippedWeapon.magicDamage)
        if (Math.random() < 0.3) {
            status = Paralyzed(this)
        }
    }
    /**
     * Damages this enemy, and with a probability of 20%, it will be burnt.
     */
    fun receiveFire(blackMage: BlackMage) {
        receiveDamage(blackMage.equippedWeapon.magicDamage)
        if (Math.random() < 0.2) {
            status = Burnt(blackMage.equippedWeapon.magicDamage, this)
        }
    }
    /**
     * Poisons this enemy
     */
    fun receivePoison(whiteMage: WhiteMage) {
        status = Poisoned(whiteMage.equippedWeapon.magicDamage, this)
    }
    /**
     * Paralyzes this enemy
     */
    fun receiveParalysis(@Suppress("UNUSED_PARAMETER") whiteMage: WhiteMage) {
        status = Paralyzed(this)
    }
    override fun notifyDeathToController(){
        if (!isAlive()) {
            controller.removeEnemy(this)
        }
    }
}
