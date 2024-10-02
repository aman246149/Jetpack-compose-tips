package com.example.udemycompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerDefaults.backgroundColor
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.udemycompose.routing.LocalNavController
import com.example.udemycompose.routing.topLevelRoutes

@Composable
fun BottomBarScreen(modifier: Modifier = Modifier) {
    val navController = LocalNavController.current
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor= Color(0xFF0F0C0D)) {
                topLevelRoutes.forEachIndexed { index, topLevelRoute ->
                    BottomNavigationItem(

                        icon = {
                            Icon(
                                topLevelRoute.icon,
                                contentDescription = topLevelRoute.name,
                                tint = when (selectedIndex) {
                                    index -> Color.White
                                    else -> Color.Gray.copy(alpha = 0.6f)
                                },
                            )
                        },
                        label = { Text(topLevelRoute.name,
                            color = when (selectedIndex){
                                index -> Color.White
                                else -> Color.Gray.copy(alpha = 0.6f)
                            }
                            ) },
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index

                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedIndex) {
                0 -> HomeScreen()
                1 -> SecondScreen()
                2 -> ThirdScreen()
            }
        }
    }
}





