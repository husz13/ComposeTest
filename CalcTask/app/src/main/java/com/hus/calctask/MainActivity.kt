package com.hus.calctask

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.hus.calctask.ui.theme.CalcTaskTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator()
        }

    }

    @Composable
    fun Calculator() {

        var calcText by remember {
            mutableStateOf("")
        }
        var resultText by remember {
            mutableStateOf("0.0 ")
        }
        var isDialogOpen by remember {
            mutableStateOf(false)
        }

        fun displayText(num: String) {
            if (num == "=") {
                resultText = calcText
                return
            }
            calcText += num
        }

        fun dismissAlert() {
            isDialogOpen = false
        }





        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)) {
            if (isDialogOpen) {
                Alert { dismissAlert() }
            }
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {

                        isDialogOpen = true


                    },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add, contentDescription = "asdad"
                    )

                }
            }

            Text(
                text = calcText, modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(), fontSize = 25.sp
            )
            Text(
                text = resultText, modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(vertical = 20.dp), fontSize = 25.sp
            )
            Card(
                modifier = Modifier.weight(3f),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1.5f)
                        .background(color = Color.Gray), verticalArrangement = Arrangement.Center
                ) {
                    CalculatorKeyRow(keys = listOf("7", "8", "9", "x"), onClick = {
                        displayText(it)
                    })
                    CalculatorKeyRow(keys = listOf("4", "5", "6", "-"), onClick = {
                        displayText(it)
                    })
                    CalculatorKeyRow(keys = listOf("1", "2", "3", "+"), onClick = {
                        displayText(it)
                    })
                    CalculatorKeyRow(keys = listOf("00", "0", ".", "/"), onClick = {
                        displayText(it)
                    })
                    CalculatorKeyRow(keys = listOf("C", "="), onClick = {
                        displayText(it)
                    })
                }
            }


        }


    }

    @Composable
    fun Alert(dismiss: () -> Unit) {

        AlertDialog(onDismissRequest = {
            dismiss()
        }, confirmButton = {
            Button(
                onClick = {
                    dismiss()
                },
            ) {
                Text(text = "He")
            }
        }, text = {
            Text(text = "Hello there ")
        }
        )
    }


    @Composable
    fun CalculatorKeyRow(keys: List<String>, onClick: (String) -> Unit) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp, 30.dp)
        ) {
            keys.forEach() {
                Text(
                    text = it,
                    modifier = Modifier.clickable(onClick = {
                        onClick(it)


                    }
                    ),
                )
            }
        }


    }

}










