package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.character.interfaces.IEnemy
import cl.uchile.dcc.finalreality.model.status.interfaces.IState

/**
 * A state that does nothing, it's the default state.
 * It lasts forever, so passTurn() does nothing.
 * */
class NullState(override val character: IEnemy) : IState {
    override val attackerMagicDamage: Int = 0
    override var turnsLeft: Int = 1
    override fun passTurn() {
        // Does nothing.
    }
    override fun turnEffect() {
        // Does nothing.
    }
}