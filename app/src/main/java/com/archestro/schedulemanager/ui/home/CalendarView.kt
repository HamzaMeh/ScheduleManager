package com.archestro.schedulemanager.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.archestro.schedulemanager.domain.model.ScheduleModelItem
import com.archestro.schedulemanager.ui.component.WeekHeader
import com.archestro.schedulemanager.ui.subjectdialog.SubjectDialog
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode

@Composable
fun CalendarView(){
    val state = rememberSelectableCalendarState(
        initialSelectionMode = SelectionMode.Single,
    )
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        SelectableCalendar(
            calendarState = state,
            dayContent = { dayState ->
                DaySchedule(
                    state = dayState,
                )
            },
            weekHeader = { WeekHeader(daysOfWeek = it) },
        )
    }
}

@Composable
fun DaySchedule(
    state: DayState<DynamicSelectionState>,
    scheduleModelItem: ScheduleModelItem?=null,
    modifier: Modifier = Modifier,
) {
    val date = state.date
    val selectionState = state.selectionState

   // val isSelected = selectionState.isDateSelected(date)

    Card(
        modifier = modifier
            .aspectRatio(1f)
            .padding(2.dp),
        elevation =  0.dp,
        border = if (state.isCurrentDay) BorderStroke(1.dp, MaterialTheme.colors.primary) else null,
        contentColor = if(state.isFromCurrentMonth) Color.Black else Color.LightGray
    ) {
        Column(
            modifier = Modifier.clickable {
                selectionState.onDateSelected(date)
            },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = date.dayOfMonth.toString())
            if (scheduleModelItem != null) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)
                )
            }
        }
    }
}

@Preview
@Composable
fun CalendarPreview(){
    Box(
    modifier = Modifier
        .padding(20.dp)
        .fillMaxSize(),
    contentAlignment = Alignment.Center
    ) {
        Column() {
            CalendarView()
        }
    }
}