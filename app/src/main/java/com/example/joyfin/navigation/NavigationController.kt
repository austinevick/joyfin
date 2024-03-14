package com.example.joyfin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.joyfin.screens.AppViewModel
import com.example.joyfin.screens.HomeScreen
import com.example.joyfin.screens.LoginScreen


@Composable
fun NavigationController(navController: NavHostController,viewModel: AppViewModel) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            LoginScreen(navController)
        }
        composable(Routes.Home.route) {
            HomeScreen(viewModel)
        }
    }
}