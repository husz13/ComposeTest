package com.hus.meditation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hus.meditation.ui.theme.AquaBlue
import com.hus.meditation.ui.theme.BottomMenuItem
import com.hus.meditation.ui.theme.DeepBlue


@Composable
fun BottomMenu(
    menu: List<BottomMenuItem>,
    modifier: Modifier = Modifier,
    activeIconColor: Color = AquaBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedIndex: Int = 0
) {
    var selected by remember {
        mutableIntStateOf(initialSelectedIndex)

    }
    Row(
        modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        menu.forEachIndexed { index, item ->
            MenuItem(
                item = item,

                activeIconColor = activeIconColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                isSelected = selected == index,
                onClick = {
                    selected = index

                },
            )
        }
    }
}

@Composable
fun MenuItem(
    item: BottomMenuItem,
    activeIconColor: Color = AquaBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    isSelected: Boolean = false,
    onClick: () -> Unit

) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            // .padding(10.dp)
            .clickable { onClick() }
            .clip(
                RoundedCornerShape(10.dp)
            )
            .background(
                if (isSelected) activeIconColor else Color.Transparent
            )
            .padding(10.dp)) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(
                    20.dp
                )
            )

        }



        Text(text = item.title, color = if (isSelected) activeTextColor else inactiveTextColor)

    }

}