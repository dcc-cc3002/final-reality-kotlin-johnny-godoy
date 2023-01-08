/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByEngineer
import java.util.Objects

/**
 * An `Engineer` is a type of [IPlayerCharacter] that can equip `Axe`s and
 * `Bow`s.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param controller The game controller.
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
    controller: GameController
) :
    AbstractPlayerCharacter(name, maxHp, defense, controller) {
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
    /**
     * Equips a valid weapon to this engineer.
     * This overloads the equip method of [AbstractPlayerCharacter].
     */
    fun equip(weapon: EquippableByEngineer) {
        super.validEquip(weapon)
    }
}
