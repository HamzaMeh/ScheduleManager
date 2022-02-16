package com.archestro.schedulemanager.domain.model

data class ScheduleModelItem(
    val title: String,
    val subtitle: String,
    val startTime: String?,
    val endTime: String?
    // val color: String
)
