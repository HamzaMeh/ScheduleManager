package com.archestro.schedulemanager.data.model


import androidx.annotation.DrawableRes

data class BottomMenuItem(
    val title:String,
    @DrawableRes val iconId:Int,
    val route:String,
    val alertCount:Int?=null
)