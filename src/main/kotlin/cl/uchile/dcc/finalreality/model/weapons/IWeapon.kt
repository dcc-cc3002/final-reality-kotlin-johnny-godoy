package cl.uchile.dcc.finalreality.model.weapons

/**
 * This represents a weapon in the game.
 *
 * @property name String
 *     The weapon's name
 * @property damage Int
 *     The weapon's base damage
 * @property weight Int
 *     The weapon's weight
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
interface IWeapon {
    val name: String
    val damage: Int
    val weight: Int
}
