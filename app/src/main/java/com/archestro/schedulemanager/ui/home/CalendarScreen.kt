package com.archestro.schedulemanager.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CalendarScreen(
    navController: NavController
) {
    Column() {
        CalendarView()
    }
}