/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.exceptions.SpellFailException
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractMagicWielder
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByBlackMage
import java.util.Objects

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum magic points
 * @param defense     the character's defense
 * @param controller The game controller.
 * @constructor Creates a new Black Mage.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class BlackMage(
    name: String,
    maxHp: Int,
    maxMp: Int,
    defense: Int,
    controller: GameController
) : AbstractMagicWielder(name, maxHp, maxMp, defense, controller) {
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is BlackMage -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        maxHp != other.maxHp -> false
        maxMp != other.maxMp -> false
        defense != other.defense -> false
        else -> true
    }
    override fun hashCode(): Int =
        Objects.hash(BlackMage::class, name, maxHp, maxMp, defense)
    /**
     * Equips a valid weapon to this black mage.
     * This overloads the equip method of [AbstractPlayerCharacter].
     */
    fun equip(weapon: EquippableByBlackMage) {
        super.validEquip(weapon)
    }
    /**
     * Attacks an enemy with a thunder spell. It costs 15 MP.
     */
    fun thunderSpell(enemy: Enemy) {
        if (currentMp < 15) {
            throw SpellFailException("$this has $currentMp MP, but needs at least 15 MP to cast Thunder Spell.")
        }
        currentMp -= 15
        enemy.receiveThunder(this)
    }
    /**
     * Attacks an enemy with a fire spell. It costs 15 MP.
     */
    fun fireSpell(enemy: Enemy) {
        if (currentMp < 15) {
            throw SpellFailException("$this has $currentMp MP, but needs at least 15 MP to cast Fire Spell.")
        }
        currentMp -= 15
        enemy.receiveFire(this)
    }
}
