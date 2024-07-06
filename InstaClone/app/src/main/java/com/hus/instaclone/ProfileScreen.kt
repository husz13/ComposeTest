package com.hus.instaclone

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var selectedContent by remember {
        mutableStateOf(0)
    }
    Column(Modifier.fillMaxSize()) {
        TopBar(name = "Hussein Ahmed")
        Profile()
        Spacer(modifier = Modifier.height(10.dp))
        ButtonRow()
        Spacer(modifier = Modifier.height(10.dp))

        StoryHighlightsSection(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            storys = listOf(
                Story(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),
                Story(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                Story(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                Story(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ), Story(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                Story(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                )
            )
        )

        Tabs(
            tabIcons = listOf(
                painterResource(id = R.drawable.ic_grid),
                painterResource(id = R.drawable.ic_reels),
                painterResource(id = R.drawable.ic_igtv),
                painterResource(id = R.drawable.profile)
            ), onSelect = {
                selectedContent = it
            }
        )
        when(selectedContent){
            0->Posts(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }



    }
}

@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "",
            tint = Color.Black, modifier = Modifier.size(24.dp),
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 24.sp,
            modifier = Modifier.width(200.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "",
            tint = Color.Black, modifier = Modifier.size(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "",
            tint = Color.Black, modifier = Modifier.size(20.dp)
        )

    }
}


@Composable
fun RoundImage(modifier: Modifier = Modifier, image: Painter) {
    Image(contentScale = ContentScale.Crop,
        painter = image, contentDescription = null, modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape,
            )
            .padding(5.dp)
            .clip(CircleShape)
    )
}


@Composable
fun ButtonRow(modifier: Modifier = Modifier) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        val minWidth = 95.dp
        val height = 35.dp
        ActionButton(
            text = "Following", icon = Icons.Default.KeyboardArrowDown, modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(icon = Icons.Default.KeyboardArrowDown, modifier = Modifier.height(height))
    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null) {
    Row(
        modifier
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(6.dp)

            )
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (text != null) {
            Text(text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)

        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                //modifier = Modifier.size(10.dp)
            )
        }
    }
}

@Composable
fun StoryHighlightsSection(modifier: Modifier = Modifier, storys: List<Story>) {
    LazyRow(modifier) {
        items(storys) { item ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 10.dp)
            ) {
                RoundImage(image = item.image, modifier = Modifier.size(70.dp))
                Text(text = item.text, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }

        }

    }
}
