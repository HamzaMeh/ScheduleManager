package com.archestro.schedulemanager.data.model

import java.time.LocalDate

data class ScheduleModelItem(
    val title: String,
    val subtitle: String,
    val startTime: String?,
    val endTime: String?,
    val date: LocalDate
    // val color: String
)
