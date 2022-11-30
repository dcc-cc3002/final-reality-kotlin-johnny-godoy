package cl.uchile.dcc.finalreality.model.character.interfaces

import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.status.interfaces.IState

/**
 * Class that models an enemy, which has a status.
 * @property status
 *   The status of the enemy.
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 * */
interface IEnemy : IGameCharacter {
    var status: IState
}
