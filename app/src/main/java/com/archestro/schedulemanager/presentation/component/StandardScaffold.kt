package com.archestro.schedulemanager.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.archestro.schedulemanager.R
import com.archestro.schedulemanager.data.model.BottomMenuItem
import com.archestro.schedulemanager.presentation.util.Screen
import com.archestro.schedulemanager.ui.theme.paddingMedium
import com.archestro.schedulemanager.ui.theme.paddingSmall


@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    toolbarTitle:String?=null,
    showToolbar:Boolean=true,
    showBackArrow:Boolean=true,
    showBottomBar: Boolean = true,
    navActions:@Composable RowScope.() ->Unit={},
    bottomNavItems: List<BottomMenuItem> = listOf(
        BottomMenuItem(
            title="Splash",
            iconId = R.drawable.chat,
            route= Screen.SplashScreen.route),
        BottomMenuItem(
            title="Splash",
            iconId = R.drawable.explore,
            route= Screen.SplashScreen.route),
        BottomMenuItem(
            title="Home",
            iconId = R.drawable.home,
            route= Screen.HomeScreen.route),
        BottomMenuItem(
            title="Splash",
            iconId = R.drawable.chat,
            route= Screen.SplashScreen.route),
        BottomMenuItem(
            title="Splash",
            iconId = R.drawable.chat,
            route= Screen.SplashScreen.route),
    ),

    content: @Composable () -> Unit
) {
    val onClick={}
    Scaffold(
        floatingActionButton =
        {
            if(navController.currentDestination?.route.equals(Screen.HomeScreen.route)){
                FloatingActionButton(onClick =
                {
                    navController.navigate(Screen.SubjectScreen.route)
                }) {
                    Icon(Icons.Filled.Add,"")
                }
            }
        },
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = Color.White,
                    elevation = 5.dp
                ) {
                    BottomNavigation(
                        backgroundColor = Color.White,
                        elevation = 0.dp,
                    ) {
                        bottomNavItems.forEachIndexed { i, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.iconId,
                                contentDescription = bottomNavItem.title,
                                selected = navController.currentDestination?.route?.startsWith(bottomNavItem.route) == true,
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.iconId != null
                            ) {
                                if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route){
                                        popUpTo(Screen.HomeScreen.route){
                                            if(bottomNavItem.route==Screen.HomeScreen.route){
                                                inclusive=true
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        modifier = modifier
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
        ) {
            Column(
                modifier=Modifier
                    .padding(paddingSmall)
            ) {
                Spacer(modifier = Modifier.height(paddingMedium))
                Text(
                    text =stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h1
                )
                Spacer(modifier = Modifier.height(paddingMedium))
                content()
            }

        }

    }
}