package cl.uchile.dcc.finalreality.controller

import cl.uchile.dcc.finalreality.model.character.Enemy
import java.util.concurrent.LinkedBlockingQueue
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.IWeapon

/**
 * The controller class.
 * @property turnsQueue the queue of characters that will be used to determine the order of the turns.
 * @property playerCharacters the list of player characters.
 * @property enemyCharacters the list of enemy characters.
 *
 * @constructor Creates a controller with all the lists and queues initialized.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class GameController {
    val turnsQueue: LinkedBlockingQueue<IGameCharacter> = LinkedBlockingQueue<IGameCharacter>()
    val playerCharacters: MutableList<IPlayerCharacter> = mutableListOf()
    val enemyCharacters: MutableList<Enemy> = mutableListOf()
    init {
        for (i in 1..5) { // Adding enemies to the game
            enemyCharacters.add(Enemy("Enemy $i", 2*i, 10, 10, turnsQueue))
        }
        // Adding players to the game
        playerCharacters.add(Thief("Thief", 10, 10, turnsQueue))
        playerCharacters.add(Knight("Knight", 10, 10, turnsQueue))
        playerCharacters.add(BlackMage("Black Mage", 10, 10, 10, turnsQueue))
        playerCharacters.add(WhiteMage("White Mage", 10, 10, 10, turnsQueue))
        playerCharacters.add(Engineer("Engineer", 10, 10, turnsQueue))
    }
    /**
     * Creates a new enemy character and adds it to the list of enemies.
     * */
    fun createEnemy(name: String, hp: Int, defense: Int, weight: Int) {
        val enemy = Enemy(name, hp, defense, weight, turnsQueue)
        enemyCharacters.add(enemy)
    }
    /**
     * Creates a new engineer character and adds it to the list of players.
     */
    fun createEngineer(name: String, hp: Int, defense: Int) {
        // TODO: Implement this method
    }
    /**
     * Creates a new knight character and adds it to the list of players.
     */
    fun createKnight(name: String, hp: Int, defense: Int) {
        val knight = Knight(name, hp, defense, turnsQueue)
        playerCharacters.add(knight)
    }
    /**
     * Creates a new thief character and adds it to the list of players.
     */
    fun createThief(name: String, hp: Int, defense: Int) {
        val thief = Thief(name, hp, defense, turnsQueue)
        playerCharacters.add(thief)
    }
    /**
     * Creates a new black mage character and adds it to the list of players.
     */
    fun createBlackMage(name: String, hp: Int, defense: Int, mana: Int) {
        // TODO: Implement this method
    }
    /**
     * Creates a new white mage character and adds it to the list of players.
     */
    fun createWhiteMage(name: String, hp: Int, defense: Int, mana: Int) {
        // TODO: Implement this method
    }
    fun attack(attacker: IGameCharacter, target: IGameCharacter) {
        // TODO: Attack a target
    }
    fun useMagic(attacker: IGameCharacter, target: IGameCharacter) {
        // TODO: Use magic on a target
    }
    /**
     * Calls the waitTurn method of the character.
     * @param character the character that will wait its turn.
     * @see IGameCharacter.waitTurn
     */
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