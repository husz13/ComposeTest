package com.hus.instaclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    tabIcons: List<Painter>,
    onSelect: (selectedTabIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color.Gray
    TabRow(
        containerColor = Color.Transparent, selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black, modifier = modifier
    ) {
        tabIcons.forEachIndexed { index, icon ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { selectedTabIndex = index
                    onSelect(index)},
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                modifier = Modifier.background(Color.Transparent)
            ) {


                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(25.dp)
                )

            }
        }
    }
}

@Composable
fun Posts(modifier: Modifier = Modifier, posts: List<Painter>) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = modifier.scale(1.01f)) {
        items(posts) { post ->
            Image(
                painter = post,
                contentDescription = null,
                modifier = Modifier.aspectRatio(1f).border(width = 1.dp, color = Color.White),
                contentScale = ContentScale.Crop
            )
        }
    }
}