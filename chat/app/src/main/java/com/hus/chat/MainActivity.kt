package com.hus.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()

        }
    }
}

@Composable
fun App() {
    var itemsList by remember {
        mutableStateOf(
            listOf<String>(

            )
        )
    }
    var messageText by remember {
        mutableStateOf("")
    }
    var counter = 0
    Column(modifier = Modifier.background(color = Color.LightGray)) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = rememberLazyListState()
        ) {
            items(itemsList) {
                if (counter % 2 == 0)
                    Message(item = it, LShape)
                else
                    Message(item = it, RShape)
                counter++

            }
        }
        Row {

            TextField(modifier = Modifier.weight(1f).padding(), value = messageText, onValueChange = {
                messageText = it
            })
            IconButton(onClick = {
                if (itemsList.isEmpty()) {
                    itemsList = listOf(messageText)
                } else {
                    itemsList += messageText



                }
                messageText = ""
                println("item Added ${itemsList.count()}")
            }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "hello")
            }

        }

    }

}
data class Shape (val shape:RoundedCornerShape,val alignment: Alignment.Horizontal )
val LShape = Shape(shape =RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp, bottomEnd = 12.dp), alignment = Alignment.Start)
val RShape =  Shape(shape =RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp, bottomEnd = 12.dp), alignment = Alignment.End)

@Composable
fun Message(item: String,shape:Shape) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = shape.alignment) {
        Card(
            modifier = Modifier.padding(12.dp, 15.dp),
            shape =shape.shape
        ) {
            Text(
                modifier = Modifier.padding(10.dp, 10.dp),
                text = item,

            )
        }
    }

}


