package cl.uchile.dcc.finalreality.controller

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.interfaces.IGameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.character.player.interfaces.IPlayerCharacter
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByBlackMage
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByEngineer
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByKnight
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByThief
import cl.uchile.dcc.finalreality.model.weapons.interfaces.EquippableByWhiteMage
import java.util.concurrent.LinkedBlockingQueue

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
class GameController(
    val turnsQueue: LinkedBlockingQueue<IGameCharacter> = LinkedBlockingQueue<IGameCharacter>(),
    val playerCharacters: MutableList<IPlayerCharacter> = mutableListOf(),
    val enemyCharacters: MutableList<Enemy> = mutableListOf()
) {
    /**
     * Creates a new enemy character and adds it to the list of enemies.
     * */
    fun createEnemy(name: String, hp: Int, defense: Int, weight: Int, attackStat: Int) {
        val enemy = Enemy(name, hp, defense, weight, attackStat, this)
        enemyCharacters.add(enemy)
    }
    /**
     * Creates a new engineer character and adds it to the list of players.
     */
    fun createEngineer(name: String, hp: Int, defense: Int, weapon: EquippableByEngineer) {
        val engineer = Engineer(name, hp, defense, this)
        engineer.equip(weapon)
        playerCharacters.add(engineer)
    }
    /**
     * Creates a new knight character and adds it to the list of players.
     */
    fun createKnight(name: String, hp: Int, defense: Int, weapon: EquippableByKnight) {
        val knight = Knight(name, hp, defense, this)
        knight.equip(weapon)
        playerCharacters.add(knight)
    }
    /**
     * Creates a new thief character and adds it to the list of players.
     */
    fun createThief(name: String, hp: Int, defense: Int, weapon: EquippableByThief) {
        val thief = Thief(name, hp, defense, this)
        thief.equip(weapon)
        playerCharacters.add(thief)
    }
    /**
     * Creates a new black mage character and adds it to the list of players.
     */
    fun createBlackMage(name: String, hp: Int, mana: Int, defense: Int, weapon: EquippableByBlackMage) {
        val blackMage = BlackMage(name, hp, mana, defense, this)
        blackMage.equip(weapon)
        playerCharacters.add(blackMage)
    }
    /**
     * Creates a new white mage character and adds it to the list of players.
     */
    fun createWhiteMage(name: String, hp: Int, mana: Int, defense: Int, weapon: EquippableByWhiteMage) {
        val whiteMage = WhiteMage(name, hp, mana, defense, this)
        whiteMage.equip(weapon)
        playerCharacters.add(whiteMage)
    }
    /**
     * Removes dead enemies from the list of enemies and the turns queue.
     */
    fun removeEnemy(enemy: Enemy) {
        enemyCharacters.remove(enemy)
        turnsQueue.remove(enemy)
    }
    /**
     * Removes dead players from the list of players and the turns queue.
     */
    fun removePlayer(player: IPlayerCharacter) {
        playerCharacters.remove(player)
        turnsQueue.remove(player)
    }
    /**
     * Makes the attacker character attack the target character.
     */
    fun attack(attacker: IGameCharacter, target: IGameCharacter) {
        attacker.attack(target)
    }
    /**
     * Makes a chosen enemy attack a random player.
     */
    fun enemyAttackRandomPlayer(enemyIndex: Int) {
        attack(enemyCharacters[enemyIndex], playerCharacters.random())
    }
    /**
     * Uses a thunder spell on a target enemy.
     */
    fun useThunder(mage: BlackMage, target: Enemy) {
        mage.thunderSpell(target)
    }
    /**
     * Uses a fire spell on a target enemy.
     */
    fun useFire(mage: BlackMage, target: Enemy) {
        mage.fireSpell(target)
    }
    /**
     * Uses a heal-spell on a target player.
     */
    fun useHeal(mage: WhiteMage, target: IPlayerCharacter) {
        mage.heal(target)
    }
    /**
     * Uses a paralysis spell on a target player.
     */
    fun useParalysis(mage: WhiteMage, target: Enemy) {
        mage.paralyze(target)
    }
    /**
     * Uses a poison spell on a target player.
     */
    fun usePoison(mage: WhiteMage, target: Enemy) {
        mage.poison(target)
    }
    /**
     * Calls the waitTurn method of the character.
     * @param character the character that will wait its turn.
     * @see IGameCharacter.waitTurn
     */
    fun waitTurn(character: IGameCharacter) {
        character.waitTurn()
    }
    /**
     * Determines if the player has won the game.
     */
    fun playerWon(): Boolean {
        return enemyCharacters.isEmpty()
    }
    /**
     * Determines if the player has lost the game.
     */
    fun enemyWon(): Boolean {
        return playerCharacters.isEmpty()
    }
    /**
     * Finalizes the game if the player has won.
     */
    fun onPlayerWin() {
        println("You won!")
    }
    /**
     * Finalizes the game if the player has lost.
     */
    fun onEnemyWin() {
        println("You lost!")
    }
}
