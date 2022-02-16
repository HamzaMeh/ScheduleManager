package com.archestro.schedulemanager.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.archestro.schedulemanager.ui.theme.HintGray


@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    contentDescription: String? = null,
    selected: Boolean = false,
    alertCount: Int? = null,
    selectedColor: Color = MaterialTheme.colors.onBackground,
    unselectedColor: Color = HintGray,
    enabled: Boolean = true,
    onItemClick: () -> Unit
) {
    if (alertCount != null && alertCount < 0) {
        throw IllegalArgumentException("Alert count can't be negative")
    }

    BottomNavigationItem(
        selected = selected,
        onClick = onItemClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        icon = {
            Box(modifier = Modifier
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(50))
                .padding(vertical = 10.dp, horizontal = 20.dp)

            ) {
                val selectedSize: Dp =25.dp
                val defaultSize: Dp =20.dp
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .size(
                            size = if (selected) selectedSize
                            else defaultSize
                        )
                )
                if (alertCount != null && alertCount>0) {
                    val alertText = if (alertCount > 99) {
                        "99+"
                    } else {
                        alertCount.toString()
                    }
                    Text(
                        text = "",
                        /*color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,*/
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(10.dp, -10.dp)
                            .size(size = 15.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.error)
                    )
                }
            }
        }
    )
}