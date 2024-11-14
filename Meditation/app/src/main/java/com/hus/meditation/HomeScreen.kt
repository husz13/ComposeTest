package com.hus.meditation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hus.meditation.ui.theme.AquaBlue
import com.hus.meditation.ui.theme.Beige1
import com.hus.meditation.ui.theme.Beige2
import com.hus.meditation.ui.theme.Beige3
import com.hus.meditation.ui.theme.BlueViolet1
import com.hus.meditation.ui.theme.BlueViolet2
import com.hus.meditation.ui.theme.BlueViolet3
import com.hus.meditation.ui.theme.BottomMenuItem
import com.hus.meditation.ui.theme.ButtonBlue
import com.hus.meditation.ui.theme.DarkerButtonBlue
import com.hus.meditation.ui.theme.DeepBlue
import com.hus.meditation.ui.theme.LightGreen1
import com.hus.meditation.ui.theme.LightGreen2
import com.hus.meditation.ui.theme.LightGreen3
import com.hus.meditation.ui.theme.LightRed
import com.hus.meditation.ui.theme.OrangeYellow1
import com.hus.meditation.ui.theme.OrangeYellow2
import com.hus.meditation.ui.theme.OrangeYellow3
import com.hus.meditation.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)

            .fillMaxSize()
    ) {
        Column {
            Greetings()
            ChipSection(listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            Features(
                listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ), Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ), Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ), Feature(
                        title = "Calming sounds", R.drawable.ic_headphone, Beige1, Beige2, Beige3
                    ), Feature(
                        title = "Calming sounds", R.drawable.ic_headphone, Beige1, Beige2, Beige3
                    ), Feature(
                        title = "Calming sounds", R.drawable.ic_headphone, Beige1, Beige2, Beige3
                    ), Feature(
                        title = "Calming sounds", R.drawable.ic_headphone, Beige1, Beige2, Beige3
                    ), Feature(
                        title = "Calming sounds", R.drawable.ic_headphone, Beige1, Beige2, Beige3
                    )
                )
            )


        }
        BottomMenu(
            menu = listOf(
                BottomMenuItem("Home", R.drawable.ic_home),
                BottomMenuItem("Meditate", R.drawable.ic_bubble),
                BottomMenuItem("Sleep", R.drawable.ic_moon),
                BottomMenuItem("Music", R.drawable.ic_music),
                BottomMenuItem("Profile", R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Composable
fun Greetings(name: String = "Hussein") {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 15.dp, bottom = 10.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                text = "Good Night ,$name", style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "we wish you have a good day", style = MaterialTheme.typography.bodyMedium

            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Hello",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }

}

@Composable
fun ChipSection(chips: List<String>) {
    var selected by remember {
        mutableIntStateOf(0)


    }
    LazyRow(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        itemsIndexed(chips) { idx, chip ->
            Chip(chip, idx == selected, onClick = {
                selected = idx
            })

        }
    }

}

@Composable
fun Chip(content: String, selected: Boolean, onClick: () -> Unit) {
    Box(
        Modifier
            .padding(start = 7.5.dp, top = 10.dp, bottom = 10.dp)


            .clip(shape = RoundedCornerShape(10.dp))
            .background(if (selected) ButtonBlue else DarkerButtonBlue)
            .clickable {
                onClick()
            }
            .padding(10.dp, 10.dp)


    ) {
        Text(text = content, color = TextWhite)
    }
}

@Composable
fun CurrentMeditation(backgroundColor: Color = LightRed) {
    Row(
        Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .padding(15.dp, 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                "Daily Thought", style = MaterialTheme.typography.headlineMedium, color = TextWhite
            )
            Text(
                "Meditation • 3-10 min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }
        Box(
            Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(ButtonBlue),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
