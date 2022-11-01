/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player.interfaces

/**
 * A character controlled by the user which has the ability to wield magic.
 *
 * @property equippedWeapon
 *    the weapon that the character is currently using
 * @property maxMp
 *    the character's maximum mana points
 * @property currentMp
 *    the character's current mana points
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface IMagicWielder : IPlayerCharacter {
    val maxMp: Int
    var currentMp: Int
}
