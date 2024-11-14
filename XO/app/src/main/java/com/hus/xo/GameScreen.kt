package com.hus.xo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.scaleMatrix
import com.hus.xo.ui.theme.Aqua
import com.hus.xo.ui.theme.BlueCustom
import com.hus.xo.ui.theme.ButtonColor
import com.hus.xo.ui.theme.GrayBackground
import com.hus.xo.ui.theme.GreenishYellow

@Composable
fun GameScreen(viewModel: GameViewModel) {

    //val state = viewModel.state

    Column(
        Modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScoreBoard(score = viewModel.state.score)
        Title()
        GameBoard(viewModel = viewModel)
        TurnAndReset(
            viewModel.state.hintText,
            reset = { viewModel.onAction(UserAction.ResetButtonClicked) })


    }

}

@Composable
fun ScoreBoard(modifier: Modifier = Modifier, score: Score = Score()) {
    val fontSize  =18.sp
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Player X: ${score.xScore}", fontWeight = FontWeight.SemiBold, fontSize = fontSize)
        Text(text = "Draw : ${score.draw}", fontWeight = FontWeight.SemiBold, fontSize = fontSize)
        Text(text = "Player O: ${score.oScore}", fontWeight = FontWeight.SemiBold, fontSize = fontSize)
    }

}

@Composable
fun Title() {
    Text(text = "X O", fontFamily = FontFamily.Cursive, fontSize = 40.sp, overflow = TextOverflow.Clip)
}

@Composable
fun TurnAndReset(turn: String, reset: () -> Unit) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = turn, fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold)
        Button(
            onClick = { reset() },
            shape = RoundedCornerShape(5.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonColor,
                contentColor = Color.Black
            ),
        )
        {

            Text(
                text = "Reset",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding()
            )

        }
    }
}

@Composable
fun GameBoard(modifier: Modifier = Modifier, viewModel: GameViewModel) {

    Box(
        modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(GrayBackground),
        contentAlignment = Alignment.Center

    ) {
        Board()
        TouchPad(viewModel = viewModel)

        AnimatedVisibility(visible = viewModel.state.hasWon, enter = scaleIn()) {
            DrawWin(winType = viewModel.state.victoryType)
        }


    }
}

@Composable
fun TouchPad(modifier: Modifier = Modifier, viewModel: GameViewModel) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        viewModel.boardCells.forEach { (cellNo, value) ->
            item {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clickable(
                            enabled = !viewModel.state.hasWon,
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) {
                            viewModel.onAction(UserAction.BoardTapped(cellNo))


                        }
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    AnimatedVisibility(
                        visible = viewModel.boardCells[cellNo] != BoardCellValue.NONE,
//                        enter = scaleIn(tween(500)),
//                        exit = scaleOut(tween(500))
                    ) {

                        if (value == BoardCellValue.CROSS) {
                            DrawX()

                        } else if (value == BoardCellValue.CIRCLE)
                            DrawO()

                    }


                }
            }

        }


    }

}

@Composable
fun Board(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .size(400.dp)
            .padding(5.dp)
    ) {
        drawLine(
            color = Color.Gray,
            strokeWidth = 7f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 1 / 3, y = 0f),
            end = Offset(x = size.width * 1 / 3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 7f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 2 / 3, y = 0f),
            end = Offset(x = size.width * 2 / 3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 7f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 1 / 3),
            end = Offset(x = size.width, y = size.height * 1 / 3)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 7f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 2 / 3),
            end = Offset(x = size.width, y = size.height * 2 / 3)
        )
    }


}

@Composable
fun DrawX(modifier: Modifier = Modifier) {


    val animatedValue = remember {
        Animatable(0f)
    }
    val animatedZeroValue = remember {
        Animatable(1f)
    }
    LaunchedEffect(animatedValue) {
        animatedValue.animateTo(1f, tween(1000))
    }
    LaunchedEffect(animatedValue) {
        animatedZeroValue.animateTo(0f, tween(1000))
    }


    Canvas(
        modifier = modifier
            .size(100.dp)

            .padding(4.dp)
    ) {

        drawLine(
            pathEffect = PathEffect.cornerPathEffect(15f),
            color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(
                x = size.width * animatedValue.value,
                y = size.height * animatedValue.value
            )
        )
        drawLine(
            color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width, y = 0f),
            end = Offset(
                x = size.width * animatedZeroValue.value,
                y = size.height * animatedValue.value
            )
        )
    }

}

@Composable
fun DrawO(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .size(100.dp)
            .padding(5.dp)
    ) {
        drawCircle(
            color = Color.Blue,
            radius = size.width / 2,
            center = Offset(x = size.width / 2, y = size.height / 2),
            style = Stroke(width = 10f)
        )
    }

}

@Composable
fun DrawWin(modifier: Modifier = Modifier, winType: VictoryType) {
    Canvas(
        modifier = modifier
            .size(400.dp)
            .padding(3.dp)
    ) {
        val strokeWidth = 15f
        when (winType) {

            //win column 1
            VictoryType.Column1 -> drawLine(
                color = Color.Red,
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round,
                start = Offset(x = size.width * 1 / 6, y = 0f),
                end = Offset(x = size.width * 1 / 6, y = size.height)
            )
            //win column 2
            VictoryType.Column2 -> drawLine(
                color = Color.Red,
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round,
                start = Offset(x = size.width * 3 / 6, y = 0f),
                end = Offset(x = size.width * 3 / 6, y = size.height)
            )
            //win column 3
            VictoryType.Column3 -> drawLine(
                color = Color.Red,
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round,
                start = Offset(x = size.width * 5 / 6, y = 0f),
                end = Offset(x = size.width * 5 / 6, y = size.height)
            )
            //win Row 2
            VictoryType.Row2 -> drawLine(
                color = Color.Red,
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round,
                start = Offset(x = 0f, y = size.height * 3 / 6),
                end = Offset(x = size.width, y = size.height * 3 / 6)
            )
            //win Row 1
            VictoryType.Row1 -> drawLine(
                color = Color.Red,
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round,
                start = Offset(x = 0f, y = size.height * 1 / 6),
                end = Offset(x = size.width, y = size.height * 1 / 6)
            )
            //win Row 3
            VictoryType.Row3 -> drawLine(
                color = Color.Red,
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round,
                start = Offset(x = 0f, y = size.height * 5 / 6),
                end = Offset(x = size.width, y = size.height * 5 / 6)
            )

            //win diagonal1
            VictoryType.DIAGONAL1 -> drawLine(
                color = Color.Red,
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round,
                start = Offset(x = 20f, y = 20f),
                end = Offset(x = size.width - 20f, y = size.height - 20f)
            )
            //win column 3
            VictoryType.DIAGONAL2 -> drawLine(
                color = Color.Red,
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round,
                start = Offset(x = size.width, y = 0f),
                end = Offset(x = 0f, y = size.height)
            )

            VictoryType.NONE -> {

            }


        }


    }
}
