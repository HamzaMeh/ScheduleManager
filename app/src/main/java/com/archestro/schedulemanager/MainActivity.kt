package com.archestro.schedulemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.archestro.schedulemanager.presentation.component.StandardScaffold
import com.archestro.schedulemanager.presentation.util.Navigation
import com.archestro.schedulemanager.presentation.util.Screen
import com.archestro.schedulemanager.ui.theme.ScheduleManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScheduleManagerTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    StandardScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.HomeScreen.route,
                        ),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Navigation(navController)
                    }

                }
            }
        }
    }
}


