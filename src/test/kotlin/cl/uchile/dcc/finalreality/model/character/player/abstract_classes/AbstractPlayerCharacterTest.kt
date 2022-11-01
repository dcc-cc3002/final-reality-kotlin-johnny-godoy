package cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.player.abstract_classes

import cl.uchile.dcc.cl.uchile.dcc.finalreality.model.character.abstract_classes.AbstractCharacterTest
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon

abstract class AbstractPlayerCharacterTest : AbstractCharacterTest() {
    abstract override val firstCharacterTest: IPlayerCharacter
    abstract override val sameCharacterTest: IPlayerCharacter
    abstract override val differentCharacterTest: IPlayerCharacter
    abstract val lightWeapon: IWeapon
    abstract val lightWeapon2: IWeapon
    abstract val heavyWeapon: IWeapon
}
