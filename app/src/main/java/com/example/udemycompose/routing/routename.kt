package com.example.udemycompose.routing

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.udemycompose.R
import com.example.udemycompose.screens.bottomnav.DownloadScreen
import com.example.udemycompose.screens.bottomnav.HomeScreen
import com.example.udemycompose.screens.bottomnav.NewsAndHotScreen
import com.example.udemycompose.screens.bottomnav.ProfileScreen
import com.example.udemycompose.screens.bottomnav.SearchScreen
import kotlinx.serialization.Serializable


@Serializable
data class Screen1(
    val stringArg: String = "",
    val intArg: Int = 0,
)

@Serializable
object Screen2

@Serializable
object Screen3

//!BOTTOM NAVIGATION SCREENS
@Serializable
object Home
@Serializable
object Search
@Serializable
object NewAndHot
@Serializable
object Downloads
@Serializable
object Profile


////!Bottom navigation
data class TopLevelRoute<T : Any>(val name: String, val icon: ImageVector, val screen: T)

val topLevelRoutes = listOf(
    TopLevelRoute<Any>("Home", Icons.Filled.Home, Home),
    TopLevelRoute<Any>("Second", Icons.Default.Search, Search),
    TopLevelRoute<Any>("New & Hot", Icons.Filled.Newspaper, NewAndHot),
    TopLevelRoute<Any>("Downloads", Icons.Filled.Download, Downloads),
    TopLevelRoute<Any>("Profile", Icons.Filled.Person, Profile)
)