package com.example.joyfin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.joyfin.navigation.NavigationController
import com.example.joyfin.screens.AppViewModel
import com.example.joyfin.screens.HomeScreen
import com.example.joyfin.ui.theme.JoyfinTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JoyfinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationController(
                        navController = rememberNavController(),
                        viewModel = AppViewModel()
                    )
                }
            }
        }

    }
}
