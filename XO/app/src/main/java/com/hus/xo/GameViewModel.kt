package com.hus.xo


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    var state by mutableStateOf(GameState())

    val boardCells: MutableMap<Int, BoardCellValue> = mutableMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE,
    )

    fun onAction(action: UserAction) {
        when (action) {
            is UserAction.BoardTapped -> {
                addValueToCell(action.cellNo)
            }

            UserAction.ResetButtonClicked -> {
                gameReset()
            }
        }
    }
    private fun gameReset() {
        boardCells.forEach { (i, _) ->
            boardCells[i] = BoardCellValue.NONE
        }
        state = state.copy(
            hintText = "Player 'O' turn",
            currentTurn = BoardCellValue.CIRCLE,
            victoryType = VictoryType.NONE,
            hasWon = false
        )
    }


    private fun addValueToCell(cellNo: Int) {
        if (boardCells[cellNo] != BoardCellValue.NONE)
            return
        else if (state.currentTurn == BoardCellValue.CIRCLE) {
            boardCells[cellNo] = state.currentTurn
            if (hasWon()) {
                state = state.copy(
                    hasWon = true,
                    score = state.score.copy(oScore = state.score.oScore + 1),
                    hintText = "Player 'O' Won"
                )

            }
            else if(isDraw()){
                state = state.copy(
                    hasWon = true,
                    score = state.score.copy(draw = state.score.draw + 1),
                    hintText = "Draw"
                )
            }
            else {
                state = state.copy(currentTurn = BoardCellValue.CROSS, hintText = "Player 'X' Turn")

            }


            //TODO: Switch Turns 


        } else if (state.currentTurn == BoardCellValue.CROSS) {
            boardCells[cellNo] = state.currentTurn
            if (hasWon()) {
                state = state.copy(
                    hasWon = true,
                    score = state.score.copy(xScore = state.score.xScore + 1),
                    hintText = "Player 'X' Won"
                )

            }
            else if(isDraw()){
                state = state.copy(
                    hasWon = true,
                    score = state.score.copy(draw = state.score.draw + 1),
                    hintText = "Draw"
                )
            }
            else {
                state = state.copy(currentTurn = BoardCellValue.CIRCLE, hintText = "Player 'O' Turn")
            }


        }
    }

    private fun hasWon(): Boolean {

        if (boardCells[1] == state.currentTurn && boardCells[2] == state.currentTurn && boardCells[3] == state.currentTurn) {
            state = state.copy(victoryType = VictoryType.Row1)
            return true

        } else if (boardCells[4] == state.currentTurn && boardCells[5] == state.currentTurn && boardCells[6] == state.currentTurn) {
            state = state.copy(victoryType = VictoryType.Row2)
            return true

        } else if (boardCells[7] == state.currentTurn && boardCells[8] == state.currentTurn && boardCells[9] == state.currentTurn) {
            state = state.copy(victoryType = VictoryType.Row3)
            return true

        } else if (boardCells[1] == state.currentTurn && boardCells[4] == state.currentTurn && boardCells[7] == state.currentTurn) {
            state = state.copy(victoryType = VictoryType.Column1)
            return true

        } else if (boardCells[2] == state.currentTurn && boardCells[5] == state.currentTurn && boardCells[8] == state.currentTurn) {
            state = state.copy(victoryType = VictoryType.Column2)
            return true

        } else if (boardCells[3] == state.currentTurn && boardCells[6] == state.currentTurn && boardCells[9] == state.currentTurn) {
            state = state.copy(victoryType = VictoryType.Column3)
            return true

        } else if (boardCells[1] == state.currentTurn && boardCells[5] == state.currentTurn && boardCells[9] == state.currentTurn) {
            state = state.copy(victoryType = VictoryType.DIAGONAL1)
            return true

        } else if (boardCells[3] == state.currentTurn && boardCells[5] == state.currentTurn && boardCells[7] == state.currentTurn) {
            state = state.copy(victoryType = VictoryType.DIAGONAL2)
            return true

        }

        return false
    }

    fun isDraw():Boolean{
        return !boardCells.containsValue(BoardCellValue.NONE)

    }


}