package com.hus.meditation

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs

fun Path.bezierFromTo(start: Offset, end: Offset) {
    quadraticBezierTo(
        start.x,
        start.y,
        abs(start.x + end.x) / 2f,
        abs(start.y + end.y) / 2f
    )
}