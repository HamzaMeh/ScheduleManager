package com.archestro.schedulemanager.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.archestro.schedulemanager.ui.home.HomeScreen

@Composable
fun Navigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(Screen.SplashScreen.route){
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }


    }

}