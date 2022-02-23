package com.archestro.schedulemanager.presentation.util

sealed class Screen(val route:String){
    object SplashScreen:Screen("splash_screen")
    object HomeScreen:Screen("home_screen")
    object SubjectScreen: Screen("subject_screen")
}
