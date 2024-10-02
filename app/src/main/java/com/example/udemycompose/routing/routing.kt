package com.example.udemycompose.routing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.udemycompose.screens.BottomBarScreen

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.toRoute
import com.example.udemycompose.screens.FirstScreen
import com.example.udemycompose.screens.SecondScreen
import com.example.udemycompose.screens.ThirdScreen


val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }



@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = HomeScreen,
            builder = {
                composable<HomeScreen>(
                    enterTransition = {
                        fadeIn(animationSpec = tween(300))
                    },
                    exitTransition = {
                        fadeOut(animationSpec = tween(300))
                    }
                ) { backStackEntry ->

                    BottomBarScreen()
                }
                composable<Screen1>(

                    enterTransition = {
                        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
                    },
                    exitTransition = {
                        slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
                    }
                ) { backStackEntry ->
                    val args = backStackEntry.toRoute<Screen1>()
                    FirstScreen(args.stringArg, args.intArg)
                }


                composable<Screen2>(

                    enterTransition = {
                        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
                    },
                    exitTransition = {
                        slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
                    }
                ) { SecondScreen() }
                composable<Screen3>(

                    enterTransition = {
                        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
                    },
                    exitTransition = {
                        slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
                    }
                ) { ThirdScreen() }
            }
        )
    }
}