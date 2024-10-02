package com.example.udemycompose.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Hspace(width: Dp){
    Spacer(modifier = Modifier.width(width))
}