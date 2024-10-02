package com.example.udemycompose.screens.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.udemycompose.routing.LocalNavController
import com.example.udemycompose.routing.Screen1
import com.example.udemycompose.routing.Screen2
import com.example.udemycompose.routing.Screen3
import com.example.udemycompose.widgets.HomeCardUI
import com.example.udemycompose.widgets.HomeCardWrapperWithText
import com.example.udemycompose.widgets.Vspace

@Composable
fun HomeScreen() {
    val navController = LocalNavController.current
    return Scaffold { innerPadding ->

      LazyColumn (
          modifier = Modifier.padding(innerPadding),
          verticalArrangement = Arrangement.spacedBy(20.dp)){
          items(20){
              HomeCardWrapperWithText()
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