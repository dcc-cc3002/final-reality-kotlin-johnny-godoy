package cl.uchile.dcc.finalreality.model.status.interfaces

import cl.uchile.dcc.finalreality.model.character.interfaces.IEnemy

/**
 * Class that models a status: Burnt, Poisoned, Paralyzed or Null.
 * @property attackerMagicDamage
 *     The attacker's magic damage.
 * @property character
 *    The character that has this status.
 * @property turnsLeft
 *    The turns left for the status to end.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 * */
interface IState {
    val attackerMagicDamage: Int
    val character: IEnemy
    var turnsLeft: Int
    /**
     * The effect applied every turn.
     * */
    fun turnEffect()
    /**
     * Passes a turn.
     * */
    fun passTurn() {
        turnsLeft--
    }
}
