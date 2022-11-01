package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.weapons.abstract_classes.AbstractWeapon
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByBlackMage
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByKnight
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByThief
import java.util.Objects

/**
 * A class that implements knife.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, and a weight value.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class Knife(name: String,
            damage: Int,
            weight: Int
) : AbstractWeapon(name, damage, weight), EquippableByKnight, EquippableByThief,
    EquippableByBlackMage {
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Knife -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }
    override fun hashCode(): Int =
        Objects.hash(Knife::class, name, damage, weight)
    override fun equipToThief(thief: Thief) {
        thief.equip(this)
    }
    override fun equipToKnight(knight: Knight) {
        knight.equip(this)
    }
    override fun equipToBlackMage(blackMage: BlackMage) {
        blackMage.equip(this)
    }
}
