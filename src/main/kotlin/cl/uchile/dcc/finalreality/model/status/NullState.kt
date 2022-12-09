package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.status.interfaces.IState

/**
 * A state that does nothing, it's the default state.
 * It lasts forever, so passTurn() does nothing.
 * It follows the Null Object pattern.
 */
class NullState(override val character: Enemy) : IState {
    override val attackerMagicDamage: Int = 0
    override fun turnEffect() {
        // Does nothing.
    }
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is NullState -> false
        hashCode() != other.hashCode() -> false
        character != other.character -> false
        else -> true
    }
    override fun hashCode(): Int {
        return character.hashCode()
    }
}
