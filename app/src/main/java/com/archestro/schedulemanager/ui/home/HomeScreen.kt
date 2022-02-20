package com.archestro.schedulemanager.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.navigation.NavController
import com.archestro.schedulemanager.R
import com.archestro.schedulemanager.ui.scheduleitem.ScheduleComponent
import com.archestro.schedulemanager.ui.theme.paddingMedium
import com.archestro.schedulemanager.ui.theme.paddingSmall

@Composable
fun HomeScreen(
    navController: NavController
){
    val array= stringArrayResource(id = R.array.weekdays)
    Column {
        CalendarView()
        ScheduleComponent()

    }

}

@Composable
fun WeekdayItem(day:String){
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.primary,
                shape= RoundedCornerShape(
                    paddingMedium
                )
            )
    ){
        Text(
            text = day,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .padding(paddingSmall)
        )
    }
}


