package com.hus.canvastrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hus.canvastrial.ui.theme.CanvasTrialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            CanvasTrialTheme {



                var stringPoint by remember {
                    mutableStateOf("")
                }
                val pointList = remember {
                    mutableListOf<Float>()
                }




                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    TextField(value = stringPoint, onValueChange = {
                        stringPoint = it

                    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

                    Button(onClick = {
                        pointList.add(stringPoint.toFloat())
                        stringPoint = ""
                    }) {

                        Text(text = "Add")

                    }


                    MyGraph(Modifier, pointList)

                }
            }
        }
    }
}

@Composable
fun MyGraph(modifier: Modifier = Modifier, points: List<Float>) {


    Canvas(
        modifier = modifier
            .size(300.dp)
            .padding(20.dp)
            .background(Color.DarkGray)
    ) {
        val width = size.width
        val height = size.height
        val xScale = width / 10
        val yScale = height / 10
        var xOffset = 0f
       // var yOffset = 0f
        points.forEachIndexed(){
            index , point ->
            if(index != points.lastIndex){
                drawCircle(color = Color.White, center = Offset(x = xOffset , y =height - (point * yScale) ), radius = 3.0f)
                drawLine(
                    color = Color.White,
                    start = Offset(x = xOffset , y =height - (point * yScale) ),
                    end = Offset(x = xOffset +xScale, y = height - (points[index + 1] * yScale))
                )

            }
            xOffset += xScale


        }



    }

}
