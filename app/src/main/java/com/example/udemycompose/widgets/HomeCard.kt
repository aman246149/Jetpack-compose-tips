package com.example.udemycompose.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.udemycompose.R

@Composable
fun HomeCardUI(borderRadius: Dp = 16.dp, imageUrl: String = "") {
    Box(
        modifier = Modifier
            .height(200.dp)

            .background(color = Color.DarkGray, shape = RoundedCornerShape(borderRadius))
            .clip(RoundedCornerShape(borderRadius))
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize() // Use fillMaxSize to cover the Box
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(borderRadius)
                ), // Set the shape for AsyncImage
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .diskCachePolicy(CachePolicy.ENABLED)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,

            placeholder = painterResource(id = R.drawable.loading_img)
        )
    }
}

@Composable
fun HomeCardWrapperWithText() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
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

