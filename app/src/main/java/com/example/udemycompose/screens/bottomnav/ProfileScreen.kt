package com.example.udemycompose.screens.bottomnav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "PROFILE",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}