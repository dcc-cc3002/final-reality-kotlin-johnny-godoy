/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.weapons.interfaces

import cl.uchile.dcc.finalreality.model.character.player.Engineer

/**
 * A class that represents a weapon that can be equipped by an engineer.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface EquippableByEngineer : IWeapon {
    /**
     * Equips this weapon to an engineer.
     */
    fun equipToEngineer(engineer: Engineer)
}
