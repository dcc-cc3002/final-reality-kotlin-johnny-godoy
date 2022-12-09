package cl.uchile.dcc.finalreality.model.status.interfaces

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter

/**
 * Class that models a status: Burnt, Poisoned, Paralyzed or Null.
 * @property attackerMagicDamage
 *     The attacker's magic damage.
 * @property character
 *    The character that has this status.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 * */
interface IState {
    val attackerMagicDamage: Int
    val character: Enemy
    /**
     * The effect applied every turn. By default, it does nothing.
     * */
    fun turnEffect() {
        // Does nothing.
    }
    /**
     * Modifies the attack method from the character. By default, it does nothing.
     * */
    fun attack(target: IGameCharacter) {
        target.attackedByEnemy(character)
    }
}
