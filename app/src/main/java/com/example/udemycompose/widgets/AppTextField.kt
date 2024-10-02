package com.example.udemycompose.widgets

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

@Composable
fun  AppTextField( searchQuery:MutableState<String>){
    TextField(value = searchQuery.value,
        colors = TextFieldDefaults.colors(

            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black


        ), onValueChange = { newValue -> searchQuery.value = newValue },
        placeholder = {
            Text("Movies, shows and more", color = Color.Black)

        }

    )
}