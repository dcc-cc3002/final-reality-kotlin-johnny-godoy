/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player.abstract_classes

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.exceptions.FriendlyFireException
import cl.uchile.dcc.finalreality.exceptions.UnequippableWeaponException
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.abstract_classes.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon
import kotlin.math.min

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param controller The game controller.
 * @constructor Creates a new playable character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
abstract class AbstractPlayerCharacter(
    name: String,
    maxHp: Int,
    defense: Int,
    controller: GameController
) : AbstractCharacter(name, maxHp, defense, controller), IPlayerCharacter {
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
    override fun attack(target: IGameCharacter){
        target.attackedByPlayer(this)
    }
    override fun attackedByPlayer(attacker: IPlayerCharacter) {
        throw FriendlyFireException("Player $attacker cannot attack another player $this")
    }
    override fun attackedByEnemy(attacker: Enemy) {
        this.receivePhysicalAttack(attacker.attackStat)
        notifyDeathToController()
    }
    override fun heal(whiteMage: WhiteMage) {
        currentHp = min((currentHp + 0.3*maxHp).toInt(), maxHp)
    }
    override fun notifyDeathToController(){
        if (!isAlive()) {
            controller.removePlayer(this)
        }
    }
}
