package com.hus.foodapp.ui.components

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.diagonalGradientBorder(
    colors: List<Color>,
    shape: Shape,
    borderWidth: Dp = 2.dp
) = this.border(
    width = borderWidth,
    shape = shape,
    brush = Brush.linearGradient(colors = colors)
)