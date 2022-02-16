package com.archestro.schedulemanager.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleComponent(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row( verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "WEEKDAY 00",
                modifier = Modifier.padding(32.dp,8.dp,16.dp,8.dp),
                style = MaterialTheme.typography.h6)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color.Gray)
            )
        }

        ScheduleItem()
        ScheduleItem()
    }
}


@Composable
fun ScheduleItem(
    //scheduleModelItem: ScheduleModelItem,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(32.dp,8.dp,32.dp,8.dp)
        ) {
            Text(text = "8:00", color = Color.Gray)
            /* scheduleModelItem.startTime?.let {
                 Text(
                     text = it,
                     style = MaterialTheme.typography.body2
                 )
             }*/
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Text(text = "8:00", color = Color.Gray)
            /*scheduleModelItem.endTime?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body2,
                )
            }*/
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            CircleShape()
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp,8.dp,16.dp,8.dp)
        ) {
            Text(
                text = "Title Schedule",
                //text = scheduleModelItem.title,
                style = MaterialTheme.typography.h6
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Text(
                text = "Description Schedule Item",
                //text = scheduleModelItem.subtitle,
                style = MaterialTheme.typography.body2,
                fontStyle = FontStyle.Italic
            )
        }
    }
}


@Composable
fun CircleShape() {
    Canvas(modifier = Modifier.size(25.dp), onDraw = {
        val size = 10.dp.toPx()
        drawCircle(
            //TODO COLOR
            color = Color.Red,
            radius = size / 2f
        )
    })
}


@Preview(showBackground = true)
@Composable
fun PreviewScheduleItem() {
    ScheduleComponent()
}
