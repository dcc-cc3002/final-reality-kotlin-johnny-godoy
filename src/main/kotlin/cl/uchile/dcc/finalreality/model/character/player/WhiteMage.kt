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
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractMagicWielder
import cl.uchile.dcc.finalreality.model.character.player.abstract_classes.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByWhiteMage
import java.util.Objects

/**
 * A White Mage is a type of [IPlayerCharacter] that can cast white magic.
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
class WhiteMage(
    name: String,
    maxHp: Int,
    maxMp: Int,
    defense: Int,
    controller: GameController
) : AbstractMagicWielder(name, maxHp, maxMp, defense, controller) {
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
    /**
     * Heals an ally character. It costs 15 MP.
     */
    fun heal(target: IPlayerCharacter) {
        if (currentMp < 15) {
            throw SpellFailException("$this has $currentMp MP, but needs at least 15 MP to cast Heal Spell.")
        }
        if (!target.isAlive()){
            throw SpellFailException("$target is already dead, it cannot be healed.")
        }
        currentMp -= 15
        target.heal(this)
    }
    /**
     * Poison an enemy character. It costs 40 MP.
     */
    fun poison(target: Enemy) {
        if (currentMp < 40) {
            throw SpellFailException("$this has $currentMp MP, but needs at least 40 MP to cast Poison Spell.")
        }
        currentMp -= 40
        target.receivePoison(this)
    }
    /**
     * Paralyze an enemy character. It costs 25 MP.
     */
    fun paralyze(target: Enemy) {
        if (currentMp < 25) {
            throw SpellFailException("$this has $currentMp MP, but needs at least 25 MP to cast Paralyze Spell.")
        }
        currentMp -= 25
        target.receiveParalysis(this)
    }
}
