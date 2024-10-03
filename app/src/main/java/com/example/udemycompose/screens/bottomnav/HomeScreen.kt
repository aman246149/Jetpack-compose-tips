package com.example.udemycompose.screens.bottomnav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.udemycompose.R
import com.example.udemycompose.model.MarsPhoto
import com.example.udemycompose.routing.LocalNavController
import com.example.udemycompose.routing.Screen1
import com.example.udemycompose.routing.Screen2
import com.example.udemycompose.routing.Screen3
import com.example.udemycompose.viewmodel.MovieUiState
import com.example.udemycompose.viewmodel.MyMovieViewModel
import com.example.udemycompose.widgets.HomeCardUI
import com.example.udemycompose.widgets.HomeCardWrapperWithText
import com.example.udemycompose.widgets.Vspace

@Composable
fun HomeScreen(modifier: Modifier = Modifier, movieViewModel: MyMovieViewModel = viewModel()) {
    val navController = LocalNavController.current
    val movieUiState = movieViewModel.moviewUiState

    return Scaffold { innerPadding ->
        when (movieUiState) {
            is MovieUiState.Loading -> LoadingScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )

            is MovieUiState.Success -> {
                // Safely cast the data to List<MarsPhoto>

                val photos: List<MarsPhoto>? = movieUiState.data as? List<MarsPhoto>

                if (photos != null) {
                    ResultScreen(
                        photos,
                        modifier = modifier.fillMaxWidth().padding(innerPadding)
                    )
                } else {

                    Text("Failed to load photos.")
                }
            }

            is MovieUiState.Error -> ErrorScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }

//      LazyColumn (
//          modifier = Modifier.padding(innerPadding),
//          verticalArrangement = Arrangement.spacedBy(20.dp)){
//          items(20){
//              HomeCardWrapperWithText()
//          }
//      }


    }


}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ResultScreen(photos: List<MarsPhoto>, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // This makes it a 2-column grid
            modifier = Modifier.padding(8.dp), // Padding for the entire grid
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(photos.size) { index ->
                HomeCardUI(imageUrl = photos[index].img_src)
            }
        }
    }
}

//Text(text = "Popular Shows")
//Vspace(height = 10.dp)

//Column(
//modifier = Modifier
//.padding(16.dp) // Existing padding
//.padding(innerPadding)
//.fillMaxSize(), // Apply innerPadding from Scaffold
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    ElevatedButton(onClick = { navController.navigate(Screen1("Hello", 42)) }) {
//        Text(text = "First Screen")
//    }
//    Spacer(modifier = Modifier.height(20.dp))
//    ElevatedButton(onClick = { navController.navigate(Screen2) }) {
//        Text(text = "Second Screen")
//    }
//    Spacer(modifier = Modifier.height(20.dp))
//    ElevatedButton(onClick = { navController.navigate(Screen3) }) {
//        Text(text = "Third Screen")
//    }
//}