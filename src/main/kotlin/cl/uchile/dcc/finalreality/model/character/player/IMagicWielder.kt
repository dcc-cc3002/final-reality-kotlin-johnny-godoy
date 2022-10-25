package cl.uchile.dcc.finalreality.model.character.player

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
