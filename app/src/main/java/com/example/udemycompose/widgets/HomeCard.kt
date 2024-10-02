package com.example.udemycompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeCardUI(borderRadius:Dp=16.dp) {
    Box(
        Modifier
            .height(200.dp)
            .width(150.dp)
            .background(color = Color.DarkGray, shape = RoundedCornerShape(borderRadius))
    ) {

    }

}

@Composable
fun HomeCardWrapperWithText(){
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)  ) {
        Text(text = "Popular Shows", fontSize = 18.sp)
        Vspace(height = 10.dp)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),

        ) {
            items(20) {

                HomeCardUI()
            }
        }
    }
}

