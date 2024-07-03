package com.hus.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.hus.constraintlayout.ui.theme.ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Constrains()

        }
    }
}

@Composable
fun Test() {
    println("Recompsition")
    val x = remember {
        mutableStateOf(Math.random())
    }
    println("x = ${x.value} ")
    Button(onClick = {
        x.value++
        println("x = ${x.value} ")
    }) {
        Text(text = "Press me Please ${x.value}")

    }
}


@Composable
fun Constrains() {
    val constrains = ConstraintSet {
        val greenBox = createRefFor("green")
        val yellowBox = createRefFor("yellow")


        constrain(greenBox) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)

        }
        constrain(yellowBox) {
            top.linkTo(greenBox.bottom, margin = 12.dp)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.fillToConstraints

        }
    }
    ConstraintLayout(constrains, Modifier.fillMaxSize())
    {
        Box(
            Modifier
                .background(Color.Green)
                .layoutId("green")
        ) {

        }
        Box(
            Modifier
                .background(Color.Red)
                .layoutId("yellow")
        ) {

        }
    }

}

