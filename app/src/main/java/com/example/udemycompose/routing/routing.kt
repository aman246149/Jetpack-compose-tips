package com.example.udemycompose.routing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import com.example.udemycompose.screens.FirstScreen
import com.example.udemycompose.screens.SecondScreen
import com.example.udemycompose.screens.ThirdScreen
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.udemycompose.screens.bottomnav.DownloadScreen
import com.example.udemycompose.screens.bottomnav.HomeScreen
import com.example.udemycompose.screens.bottomnav.NewsAndHotScreen
import com.example.udemycompose.screens.bottomnav.ProfileScreen
import com.example.udemycompose.screens.bottomnav.SearchScreen

val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableStateOf(0) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    CompositionLocalProvider(LocalNavController provides navController) {
        Scaffold( modifier = Modifier.fillMaxSize(),
            bottomBar = {
            BottomNavigation(
                backgroundColor = Color(0xFF0F0C0D)) {
                topLevelRoutes.forEachIndexed { index, topLevelRoute ->
                    BottomNavigationItem(
                        modifier = Modifier.padding(top = 5.dp, bottom = 15.dp),
                        icon = {
                            androidx.compose.material.Icon(
                                topLevelRoute.icon,
                                contentDescription = topLevelRoute.name,
                                tint = when (selectedIndex) {
                                    index -> Color.White
                                    else -> Color.Gray.copy(alpha = 0.6f)
                                },
                            )
                        }, label = {
                            Text(

                                topLevelRoute.name,
                                color = when (selectedIndex) {
                                    index -> Color.White
                                    else -> Color.Gray.copy(alpha = 0.6f)
                                },
                                fontSize = 10.sp

                            )
                        }, selected = selectedIndex == index, onClick = {
                            selectedIndex = index
                            navController.navigate(topLevelRoute.screen) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(navController = navController, startDestination = Home, enterTransition = {
                    fadeIn(animationSpec = tween(300))
                }, exitTransition = {
                    fadeOut(animationSpec = tween(300))
                }, builder = {

                    //!BOTTOM NAVIGATION SCREENS
                    composable<Home>() { backStackEntry ->
                        HomeScreen()
                    }

                    composable<Search>() { backStackEntry ->
                        SearchScreen()
                    }

                    composable<NewAndHot> { backStackEntry ->
                        NewsAndHotScreen()
                    }
                    composable<Downloads> { backStackEntry ->
                        DownloadScreen()
                    }
                    composable<Profile> { backStackEntry ->
                        ProfileScreen()
                    }

                    //!NORMAL SCREENS

                    composable<Screen1>(
                    ) { backStackEntry ->
                        val args = backStackEntry.toRoute<Screen1>()
                        FirstScreen(args.stringArg, args.intArg)
                    }
                    composable<Screen2>(
                    ) { SecondScreen() }
                    composable<Screen3>(
                    ) { ThirdScreen() }
                })


            }
        }
    }

}



