package com.hus.instaclone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Profile(modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp), verticalAlignment = Alignment.CenterVertically
        ) {

            RoundImage(
                image = painterResource(id = R.drawable.gato), modifier = Modifier
                    .size(110.dp)
                    .weight(3f)
            )


            Spacer(modifier = Modifier.width(4.dp))
            StatusSection(
                modifier = Modifier
                    .weight(7f)
                    .padding()
            )

        }
        Description(
            name = "HusseinAhmed ",
            description = "Living the adventure called life\n" + "aisufuansoofasof\n" + "aisufuansoofasof\n",
            followersList = listOf("sakjfa", "asjdasd")
        )
    }

}

@Composable
fun StatusSection(modifier: Modifier = Modifier) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        StatusItem(numberText = "123", text = "Posts")
        StatusItem(numberText = "123", text = "Followers")
        StatusItem(numberText = "123", text = "Following")
    }
}

@Composable
fun StatusItem(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = numberText, fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
fun Description(
    modifier: Modifier = Modifier,
    name: String,
    description: String,
    followersList: List<String>,
) {
    val lineHeight = 20.sp
    val spacing = 0.3.sp
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {

        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = spacing
        )
        Text(text = description, lineHeight = lineHeight, letterSpacing = spacing, fontSize = 20.sp)
        Text(text = buildAnnotatedString {
            val style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            append("Followers by ")
            followersList.forEachIndexed { index, s ->
                pushStyle(style)
                append(s)
                pop()

                if (index < followersList.size - 1) {
                    append(", ")
                }


            }
            append(" and ")
            pushStyle(style)
            append("${followersList.size} others")
        }, lineHeight = lineHeight, letterSpacing = spacing)

    }

}