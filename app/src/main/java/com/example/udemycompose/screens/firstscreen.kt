package com.example.udemycompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.udemycompose.routing.LocalNavController

@Composable
fun FirstScreen(
    stringArg: String,
    intArg: Int,
) {
    val navController = LocalNavController.current
    return Scaffold { innerPadding ->
        Column( modifier = Modifier
            .padding(16.dp) // Existing padding
            .padding(innerPadding).fillMaxSize(),  verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "FIRST SCREEN")
            Text("Data coming here $stringArg " +
                    "and  $intArg")
            Spacer(modifier = Modifier.height(20.dp))
            ElevatedButton(onClick = { navController.popBackStack() }) {
                Text(text = "Go Back")
            }
        }
    }
}