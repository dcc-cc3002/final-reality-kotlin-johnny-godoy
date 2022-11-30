package cl.uchile.dcc.finalreality.model.status.abstract_classes

import cl.uchile.dcc.finalreality.controller.GameController
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.player.BlackMage

open class StatusTest {
    val controller = GameController()
    val enemy = Enemy("Enemy", 10, 10, 10, 10, controller)
}