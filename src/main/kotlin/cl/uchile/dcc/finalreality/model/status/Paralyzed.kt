package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.status.interfaces.IState

/**
 * The paralyzed state. It doesn't allow the affected character to attack. It does not stack with other states.
 */
class Paralyzed(override val character: Enemy) : IState {
    override val attackerMagicDamage: Int = 0
    override fun attack(target: IGameCharacter) {
        // Does nothing.
    }
    override fun turnEffect() {
        character.status = NullState(character)
    }
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Paralyzed -> false
        hashCode() != other.hashCode() -> false
        character != other.character -> false
        else -> true
    }
    override fun hashCode(): Int {
        return character.hashCode()
    }
}
