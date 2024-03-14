package com.example.joyfin.navigation


sealed class Routes(val route: String) {
    data object Login : Routes("Login")
    data object Home : Routes("Home")
}