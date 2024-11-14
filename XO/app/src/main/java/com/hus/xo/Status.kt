package com.hus.xo

data class Score(var xScore  : Int = 0, var oScore : Int= 0, var draw : Int= 0)
data class GameState(
    val score :Score = Score(),
    val hintText: String = "Player 'O' turn",
    val currentTurn: BoardCellValue = BoardCellValue.CIRCLE,
    val victoryType: VictoryType = VictoryType.NONE,
    val hasWon: Boolean = false
)

enum class BoardCellValue{
    CIRCLE, CROSS, NONE

}
enum class VictoryType {
    Row1,
    Row2,
    Row3,
    Column1,
    Column2,
    Column3,
    DIAGONAL1,
    DIAGONAL2,
    NONE
}