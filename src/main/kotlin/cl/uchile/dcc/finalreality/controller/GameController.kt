package cl.uchile.dcc.finalreality.controller

import cl.uchile.dcc.finalreality.model.character.Enemy
import java.util.concurrent.LinkedBlockingQueue
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IMagicWielder
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByBlackMage
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByEngineer
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByKnight
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByThief
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByWhiteMage
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
            createEnemy("Enemy $i", 2*i, 10, 10)
        }
        // Adding players to the game
        createThief("Thief", 10, 10, Sword("Knife", 10, 10))
        createKnight("Knight", 10, 10, Knife("Knife", 10, 10))
        createEngineer("Engineer", 10, 10, Bow("Bow", 10, 10))
        createBlackMage("Black Mage", 10, 10, 10, Knife("Knife", 10, 10))
        createWhiteMage("White Mage", 10, 10, 10, Staff("Staff", 10, 10, 4))
    }
    /**
     * Creates a new enemy character and adds it to the list of enemies.
     * */
    private fun createEnemy(name: String, hp: Int, defense: Int, weight: Int) {
        val enemy = Enemy(name, hp, defense, weight, 1, this)
        enemyCharacters.add(enemy)
    }
    /**
     * Creates a new engineer character and adds it to the list of players.
     */
    private fun createEngineer(name: String, hp: Int, defense: Int, weapon: EquippableByEngineer) {
        val engineer = Engineer(name, hp, defense, this)
        engineer.equip(weapon)
        playerCharacters.add(engineer)
    }
    /**
     * Creates a new knight character and adds it to the list of players.
     */
    private fun createKnight(name: String, hp: Int, defense: Int, weapon: EquippableByKnight) {
        val knight = Knight(name, hp, defense, this)
        knight.equip(weapon)
        playerCharacters.add(knight)
    }
    /**
     * Creates a new thief character and adds it to the list of players.
     */
    private fun createThief(name: String, hp: Int, defense: Int, weapon: EquippableByThief) {
        val thief = Thief(name, hp, defense, this)
        thief.equip(weapon)
        playerCharacters.add(thief)
    }
    /**
     * Creates a new black mage character and adds it to the list of players.
     */
    private fun createBlackMage(name: String, hp: Int, defense: Int, mana: Int, weapon: EquippableByBlackMage) {
        val blackMage = BlackMage(name, hp, defense, mana, this)
        blackMage.equip(weapon)
        playerCharacters.add(blackMage)
    }
    /**
     * Creates a new white mage character and adds it to the list of players.
     */
    private fun createWhiteMage(name: String, hp: Int, defense: Int, mana: Int, weapon: EquippableByWhiteMage) {
        val whiteMage = WhiteMage(name, hp, defense, mana, this)
        whiteMage.equip(weapon)
        playerCharacters.add(whiteMage)
    }
    /**
     * Makes the attacker character attack the target character.
     */
    fun attack(attacker: IGameCharacter, target: IGameCharacter) {
        attacker.attack(target)
    }
    fun useMagic(attacker: IMagicWielder, target: Enemy) {
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