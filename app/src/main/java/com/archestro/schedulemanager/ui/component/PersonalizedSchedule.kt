package com.archestro.schedulemanager.ui.component

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.archestro.schedulemanager.ui.theme.lakeGreen

@Composable
fun PersonalizedSchedule() {
    val daysRepeat = listOf(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),


    ) {

        val checkedState = remember{ mutableStateOf(false)}

        daysRepeat.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    color = Color.Black,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(
                            vertical = 8.dp,
                            horizontal = 16.dp,
                        ),
                )
                CheckButton(isChecked = checkedState.value, onClick = {
                    //TODO HANDLE ONCLICK
                })

            }
        }
    }
}

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun CheckButton(
    isChecked: Boolean,
    onClick: () -> Unit
) {
    IconToggleButton(
        checked = isChecked,
        onCheckedChange = { onClick() }
    ) {
        val transition = updateTransition(isChecked, label = "Checked indicator")

        val tint by transition.animateColor(
            label = "Tint"
        ) { isChecked ->
            if (isChecked) lakeGreen else Color.Black
        }

        val size by transition.animateDp(
            transitionSpec = {
                if (false isTransitioningTo true) {
                    keyframes {
                        durationMillis = 250
                        30.dp at 0 with LinearOutSlowInEasing // for 0-15 ms
                        35.dp at 15 with FastOutLinearInEasing // for 15-75 ms
                        40.dp at 75 // ms
                        35.dp at 150 // ms
                    }
                } else {
                    spring(stiffness = Spring.StiffnessVeryLow)
                }
            },
            label = "Size"
        ) { 30.dp }

        Icon(
            imageVector = if (isChecked) Icons.Filled.CheckCircle else Icons.Filled.CropSquare,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(size)
        )
    }
}

/*@Preview("Favorite Button")
@Composable
fun CheckButtonPreview() {
    val (isChecked, setChecked) = remember { mutableStateOf(false) }
    MaterialTheme {
        Surface {
            CheckButton(
                isChecked = isChecked,
                onClick = { setChecked(!isChecked) }
            )
        }
    }
}*/


@Preview
@Composable
fun previewRepeatDays(){
    PersonalizedSchedule()
}
