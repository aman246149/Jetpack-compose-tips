package com.example.udemycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.udemycompose.routing.AppNavigation
import com.example.udemycompose.ui.theme.UdemycomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UdemycomposeTheme {
                // Centralized navigation setup
                Surface {

                    AppNavigation() // Sets up NavController
                }

            }
        }
    }
}

