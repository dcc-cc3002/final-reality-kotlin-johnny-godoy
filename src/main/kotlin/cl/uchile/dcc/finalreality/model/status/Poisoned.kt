package cl.uchile.dcc.finalreality.model.status

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.status.interfaces.IState

/**
 * The poisoned state. It deals damage every turn when it is the active state. It does not stack with other states.
 */
class Poisoned(override val attackerMagicDamage: Int, override val character: Enemy) : IState {
    override fun turnEffect() {
        character.receiveDamage(attackerMagicDamage / 3)
    }
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Poisoned -> false
        hashCode() != other.hashCode() -> false
        attackerMagicDamage != other.attackerMagicDamage -> false
        character != other.character -> false
        else -> true
    }
    override fun hashCode(): Int {
        var result = attackerMagicDamage
        result = 31 * result + character.hashCode()
        return result
    }
}