/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractMagicWielder
import cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByWhiteMage
import java.util.Objects
import java.util.concurrent.BlockingQueue

/**
 * A White Mage is a type of [IPlayerCharacter] that can cast white magic.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum magic points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Black Mage.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class WhiteMage(
    name: String,
    maxHp: Int,
    maxMp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<IGameCharacter>
) : AbstractMagicWielder(name, maxHp, maxMp, defense, turnsQueue) {
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is WhiteMage -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        maxHp != other.maxHp -> false
        maxMp != other.maxMp -> false
        defense != other.defense -> false
        else -> true
    }
    override fun hashCode(): Int =
        Objects.hash(WhiteMage::class, name, maxHp, maxMp, defense)
    /**
     * Equips a valid weapon to this white mage.
     * This overloads the equip method of [AbstractPlayerCharacter].
     */
    fun equip(weapon: EquippableByWhiteMage) {
        super.validEquip(weapon)
    }
}
