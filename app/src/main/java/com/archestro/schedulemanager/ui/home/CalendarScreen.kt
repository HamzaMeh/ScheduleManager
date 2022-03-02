package com.archestro.schedulemanager.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.archestro.schedulemanager.ui.component.BottomSheetRepeat

@Composable
fun CalendarScreen(
    navController: NavController
) {
    Column() {
        CalendarView()
        Repeat()
    }
}

@Composable
fun Repeat() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp, 0.dp)
        ) {
            /*Text(
                text = "Repeat",
                style = MaterialTheme.typography.h5,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "Repeat",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )*/
            BottomSheetRepeat()
        }
    }
}

@Preview
@Composable
fun previewRepeat(){
    Repeat()
}

