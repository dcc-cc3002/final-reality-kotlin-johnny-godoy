package cl.uchile.dcc.finalreality.model.character.player

interface IMagicWielder : IPlayerCharacter {
    val maxMp: Int
    var currentMp: Int
}