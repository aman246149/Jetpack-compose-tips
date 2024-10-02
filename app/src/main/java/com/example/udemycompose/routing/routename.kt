package com.example.udemycompose.routing

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.udemycompose.R
import kotlinx.serialization.Serializable

@Serializable
    object HomeScreen

@Serializable
data class Screen1(
    val stringArg: String = "",
    val intArg: Int = 0,
)

@Serializable
    object Screen2
@Serializable
    object Screen3


////!Bottom navigation
data class TopLevelRoute<T : Any>(val name: String, val icon: ImageVector)

val topLevelRoutes = listOf(
    TopLevelRoute<Any>("Home", Icons.Filled.Person),
    TopLevelRoute<Any>("Second", Icons.Filled.Build),
    TopLevelRoute<Any>("Third", Icons.Filled.Favorite)
)