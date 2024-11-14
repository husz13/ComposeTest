package com.hus.foodapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.logging.Filter


@Composable
fun FilterBar(
    modifier: Modifier = Modifier,
    filters: List<Filter>,
    onShowFilter: () -> Unit
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            start = 12.dp, end = 8.dp
        ),
        modifier = modifier.heightIn(min = 56.dp)
    ) {
        item {
            IconButton(onClick = { /*TODO*/ }) {
                Surface(
                    Modifier.diagonalGradientBorder(
                        colors = listOf(Color.Red, Color.Gray),
                        shape = CircleShape
                    )
                ) {
                    Icon(imageVector = Icons.Rounded.FilterList, contentDescription ="" )
                }
            }
        }

    }
}