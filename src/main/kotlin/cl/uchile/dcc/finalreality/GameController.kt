package cl.uchile.dcc.finalreality

import cl.uchile.dcc.finalreality.model.character.Enemy
import java.util.concurrent.LinkedBlockingQueue
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon

class GameController {
    private val turnsQueue = LinkedBlockingQueue<IGameCharacter>()
    private val playerCharacters = mutableListOf<IPlayerCharacter>()
    private val enemyCharacters = mutableListOf<Enemy>()

    init {
        for (i in 1..10) {
            // TODO: Add enemies to the game
            // TODO: Add players to the game
            // TODO: Add characters to the turns queue
        }
    }

    fun createPlayer(name: String, hp: Int, defense: Int, weapon: IWeapon) {
        // TODO: Create a player character
    }

    fun createEnemy(name: String, hp: Int, defense: Int, weight: Int) {
        // TODO: Create an enemy character
    }

    fun attack(attacker: IGameCharacter, target: IGameCharacter) {
        // TODO: Attack a target
    }

    fun useMagic(attacker: IGameCharacter, target: IGameCharacter) {
        // TODO: Use magic on a target
    }

    fun waitTurn(character: IGameCharacter) {
        // TODO: Call the waitTurn method of the character
    }

    fun onPlayerWin() {
        // TODO: Handle the player winning the game
    }

    fun onEnemyWin() {
        // TODO: Handle the enemy winning the game
    }
}